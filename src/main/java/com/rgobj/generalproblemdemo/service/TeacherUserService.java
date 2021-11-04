package com.rgobj.generalproblemdemo.service;

import com.rgobj.generalproblemdemo.bean.TeacherBean;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-11 20:16
 */

public interface TeacherUserService {

    //查询数据
    public List<TeacherBean> queryAll();

    //添加数据
    public int add(TeacherBean teacherBean);

    //根据用户查询数据
    public TeacherBean queryByName(String username);

    //登陆密码验证
    public TeacherBean loginCheck(String username,String password);
}
