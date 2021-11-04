package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.StuResultBean;
import com.rgobj.generalproblemdemo.mapper.StuResultMapper;
import com.rgobj.generalproblemdemo.service.StuResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-25 10:36
 */
@Service
public class StuResultImpl implements StuResultService {

    @Autowired
    StuResultMapper stuResultMapper;

    @Override
    public int add(StuResultBean stuResultBean) {
        return stuResultMapper.add(stuResultBean);
    }

    @Override
    public List<StuResultBean> queryAllByName(String stu_username) {
        return stuResultMapper.queryAllByName(stu_username);
    }

    @Override
    public int deleteBySelect(String stu_username, String stu_finishtime) {
        String finishtime = resDate(stu_finishtime);//将时间转换为时间戳
        return stuResultMapper.deleteBySelect(stu_username,finishtime);
    }

    //对列表排序
    public void setSorting(List<StuResultBean> stuResultBeans){
        Collections.sort(stuResultBeans, new Comparator<StuResultBean>() {
            @Override
            public int compare(StuResultBean o1, StuResultBean o2) {
                long l1 = Long.parseLong(o1.getStu_finishtime());
                long l2 = Long.parseLong(o2.getStu_finishtime());
                if (l1 == l2) {
                    return 0;
                } else {
                    return l1 > l2 ? -1 : 1;
                }
            }
        });
    }

    //时间转换(时间戳——>固定格式)
    public String getFormatDate(String time){
        long mytime = Long.parseLong(time);
        Date date = new Date(mytime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }
    //时间反转(格式——>时间戳)
    public String resDate(String time) {

        String finishTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        finishTime = ts + "";
        return finishTime;
    }

}
