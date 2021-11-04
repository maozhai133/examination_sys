package com.rgobj.generalproblemdemo.mapper;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-19 11:16
 */
@Mapper
@Repository
public interface QuestionInfoMapper {
    //查询
    public List<QuestionInfoBean> queryAll();

    //根据教师用户名查询
    public List<QuestionInfoBean> queryByTeacherUser(String question_username);

    //根据套题ID查询
    public QuestionInfoBean queryByQsetCode(int code);

    //根据ID和用户输入修改套题信息
    public int updateInfo(String question_title,String question_type,int question_code);

    //增加套题信息
    public int addInfo(String question_title, String question_author, String question_time, String question_type, String question_username, int question_totalpoints);

    //查询套题ID
    public int queryCode(String question_username,String question_time);
}
