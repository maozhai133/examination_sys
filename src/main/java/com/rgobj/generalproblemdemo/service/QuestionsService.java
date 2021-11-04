package com.rgobj.generalproblemdemo.service;

import com.rgobj.generalproblemdemo.bean.QuestionsBean;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-22 21:59
 */
public interface QuestionsService {
    //查询
    public List<QuestionsBean> queryAll();

    //根据套题ID查询
    public List<QuestionsBean> queryAllByCode(int questions_code);
}
