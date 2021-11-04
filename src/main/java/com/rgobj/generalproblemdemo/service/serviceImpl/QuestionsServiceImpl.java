package com.rgobj.generalproblemdemo.service.serviceImpl;

import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import com.rgobj.generalproblemdemo.mapper.QuestionsMapper;
import com.rgobj.generalproblemdemo.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-22 22:00
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsMapper questionsMapper;

    @Override
    public List<QuestionsBean> queryAll() {
        return questionsMapper.queryAll();
    }

    @Override
    public List<QuestionsBean> queryAllByCode(int questions_code) {
        return questionsMapper.queryAllByCode(questions_code);
    }


//检验答案是否正确
    public int checkAnswers(List<String> subAnswer,List<QuestionsBean> questionsBeanList){
        int score = 0;
        for (int i = 0;i<subAnswer.size();i++){
            if(subAnswer.get(i)!=null){
                if(subAnswer.get(i).equals(questionsBeanList.get(i).getAnswer_right()))
                score +=questionsBeanList.get(i).getQuestions_score();
            }
        }
        return score;
    }

//获取当前时间戳
    public Long getCurrentTime(){
//        long currentTime=System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time =format.format(date);
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();

        return ts;
    }

//计算套题总分
    public int sumScore(List<QuestionsBean> list){
        int Score = 0;
        for(QuestionsBean q:list){
            Score+=q.getQuestions_score();
        }
        return Score;
    }

}
