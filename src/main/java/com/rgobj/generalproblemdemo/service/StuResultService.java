package com.rgobj.generalproblemdemo.service;

import com.rgobj.generalproblemdemo.bean.StuResultBean;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-25 10:33
 */
public interface StuResultService {
    //添加数据
    public int add(StuResultBean stuResultBean);

    //查询
    public List<StuResultBean> queryAllByName(String stu_username);

    //删除
    public int deleteBySelect(String stu_username,String stu_finishtime);
}
