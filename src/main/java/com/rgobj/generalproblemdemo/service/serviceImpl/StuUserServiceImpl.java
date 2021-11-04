package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.StuUserBean;
import com.rgobj.generalproblemdemo.mapper.StuUserMapper;
import com.rgobj.generalproblemdemo.service.StuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-04 21:11
 */

@Service
public class StuUserServiceImpl implements StuUserService {

    //将DAO注入Service层
    @Autowired
    StuUserMapper stuUserMapper;

    @Override
    public List<StuUserBean> queryAll() {
        return stuUserMapper.queryAll();
    }

    @Override
    public int add(StuUserBean stuUserBean) {
        return stuUserMapper.add(stuUserBean);
    }

    @Override
    public StuUserBean queryByName(String username) {
        return stuUserMapper.queryByName(username);
    }

    @Override
    public StuUserBean loginCheck(String username, String password) {
        return stuUserMapper.loginCheck(username,password);
    }

    //获取当前登陆时间
    public String loginTime(){
        long timenumber = System.currentTimeMillis();
        Date date = new Date(timenumber);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }

}
