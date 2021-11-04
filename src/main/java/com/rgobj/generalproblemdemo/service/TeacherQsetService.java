package com.rgobj.generalproblemdemo.service;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import com.rgobj.generalproblemdemo.bean.QuestionsBean;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-06-02 9:22
 */
public interface TeacherQsetService {

    //通过教师用户名查询套题信息
    public List<QuestionInfoBean> queryByTeacherUser(String username);

    //通过套题ID查询套题信息
    public QuestionInfoBean queryByQsetCode(int code);

    //根据ID和输入的值修改套题信息
    public int updateInfo(String question_title,String question_type,int question_code);

    //修改每道题的内容
    public int upadateQset(String questions,String answer_a,String answer_b,String answer_c,String answer_d,String answer_right,int question_code,int questions_counter);

    //增加套题信息
    public int addInfo(String question_title, String question_author, String question_time, String question_type, String question_username, int question_totalpoints);

    //查询套题ID
    public int queryCode(String question_username,String question_time);

    //增加新题
    public int addQset(QuestionsBean questionsBean);
}
