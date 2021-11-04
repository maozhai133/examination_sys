package com.rgobj.generalproblemdemo.service;

import com.rgobj.generalproblemdemo.bean.StuUserBean;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-04 21:09
 */
public interface StuUserService {

    //查询
    public List<StuUserBean> queryAll();
    //添加数据
    public int add(StuUserBean stuUserBean);
    //根据用户名查询数据
    public StuUserBean queryByName(String username);
    //验证密码
    public StuUserBean loginCheck(String username,String password);
}
