package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import com.rgobj.generalproblemdemo.bean.StuResultBean;
import com.rgobj.generalproblemdemo.mapper.QuestionInfoMapper;
import com.rgobj.generalproblemdemo.mapper.QuestionsMapper;
import com.rgobj.generalproblemdemo.service.TeacherQsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-06-02 9:25
 */
@Service
public class TeacherQsetServiceImpl implements TeacherQsetService {

    @Autowired
    QuestionInfoMapper questionInfoMapper;

    @Autowired
    QuestionsMapper questionsMapper;

    @Override
    public List<QuestionInfoBean> queryByTeacherUser(String question_username) {
        return questionInfoMapper.queryByTeacherUser(question_username);
    }

    @Override
    public QuestionInfoBean queryByQsetCode(int code) {
        return questionInfoMapper.queryByQsetCode(code);
    }

    @Override
    public int updateInfo(String question_title, String question_type, int question_code) {
        return questionInfoMapper.updateInfo(question_title,question_type,question_code);
    }

    @Override
    public int upadateQset(String questions, String answer_a, String answer_b, String answer_c, String answer_d, String answer_right, int question_code, int questions_counter) {
        return questionsMapper.upadateQset(questions,answer_a,answer_b,answer_c,answer_d,answer_right,question_code,questions_counter);
    }

    @Override
    public int addInfo(String question_title, String question_author, String question_time, String question_type, String question_username, int question_totalpoints) {
        return questionInfoMapper.addInfo(question_title,question_author,question_time,question_type,question_username,question_totalpoints);
    }

    @Override
    public int queryCode(String question_username, String question_time) {

        return questionInfoMapper.queryCode(question_username,question_time);
    }

    @Override
    public int addQset(QuestionsBean questionsBean) {
        return questionsMapper.addQset(questionsBean);
    }


    //对列表排序
    public void setSorting(List<QuestionInfoBean> questionInfoBeans){
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

    //获取当前时间
    public String SetQsetTime(){
        long timenumber = System.currentTimeMillis();
        Date date = new Date(timenumber);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        return dateString;
    }

    //时间反转(格式——>时间戳)
    public String resDate(String time) {
        String finishTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        finishTime = ts + "";
        return finishTime;
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
