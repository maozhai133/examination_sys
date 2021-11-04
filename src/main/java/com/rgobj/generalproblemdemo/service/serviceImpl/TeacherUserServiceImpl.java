package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.TeacherBean;
import com.rgobj.generalproblemdemo.mapper.TeacherUserMapper;
import com.rgobj.generalproblemdemo.service.TeacherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-11 20:17
 */
@Service
public class TeacherUserServiceImpl implements TeacherUserService {

    //将DAO注入Service层
    @Autowired
    TeacherUserMapper teacherUserMapper;

    @Override
    public List<TeacherBean> queryAll() {
        return teacherUserMapper.queryAll();
    }

    @Override
    public int add(TeacherBean teacherBean) {
        return teacherUserMapper.add(teacherBean);
    }

    @Override
    public TeacherBean queryByName(String username) {
        return teacherUserMapper.queryByName(username);
    }

    @Override
    public TeacherBean loginCheck(String username, String password) {
        return teacherUserMapper.loginCheck(username,password);
    }

    public String loginTime(){
        long timenumber = System.currentTimeMillis();
        Date date = new Date(timenumber);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }
}
