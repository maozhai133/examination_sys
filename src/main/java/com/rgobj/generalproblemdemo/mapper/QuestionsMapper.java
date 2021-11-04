package com.rgobj.generalproblemdemo.mapper;

import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-22 21:57
 */
@Mapper
@Repository
public interface QuestionsMapper {

    //查询
    public List<QuestionsBean> queryAll();

    //根据套题ID查询
    public List<QuestionsBean> queryAllByCode(int questions_code);

    //修改题
    public int upadateQset(String questions,String answer_a,String answer_b,String answer_c,String answer_d,String answer_right,int question_code,int questions_counter);

    //增加新题
    public int addQset(QuestionsBean questionsBean);
}
