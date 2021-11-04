package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import com.rgobj.generalproblemdemo.mapper.QuestionInfoMapper;
import com.rgobj.generalproblemdemo.service.QuestionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-19 11:21
 */
@Service
public class QuestionInfoServiceImpl implements QuestionInfoService {

    @Autowired
    QuestionInfoMapper questionInfoMapper;

    @Override
    public List<QuestionInfoBean> queryAll() {
        return questionInfoMapper.queryAll();
    }

    //对列表排序(时间顺序)
    public void setSorting(List<QuestionInfoBean> questionInfoBeans) {
        Collections.sort(questionInfoBeans, new Comparator<QuestionInfoBean>() {
            @Override
            public int compare(QuestionInfoBean o1, QuestionInfoBean o2) {
                long l1 = Long.parseLong(o1.getQuestion_time());
                long l2 = Long.parseLong(o2.getQuestion_time());
                if (l1 == l2) {
                    return 0;
                } else {
                    return l1 > l2 ? -1 : 1;
                }

            }
        });
    }


    //时间转换
    public String getFormatDate(String time) {
        long mytime = Long.parseLong(time);
        Date date = new Date(mytime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }
}
