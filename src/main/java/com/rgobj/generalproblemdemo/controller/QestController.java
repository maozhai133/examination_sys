package com.rgobj.generalproblemdemo.controller;

import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import com.rgobj.generalproblemdemo.bean.StuResultBean;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionsServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-23 15:12
 */
@Controller
public class QestController {

    @Autowired
    QuestionsServiceImpl questionsServiceImpl;//套题业务层实现

    @Autowired
    StuResultImpl stuResultImpl;//学生结果业务层实现

    @RequestMapping("/answerable")
    public String answerable(HttpServletRequest request){

        List<String> answerlist = new ArrayList<>();//正确答案列表
        List<String> inputanswerlist = new ArrayList<>();//用户选择的答案列表

//        获取传值
        String code = request.getParameter("question_code");//获取套题ID
        int question_code = new Integer(code);//将ID转换为整形
        //根据套题ID查询套题
        List<QuestionsBean> currentQset = questionsServiceImpl.queryAllByCode(question_code);

//      获取提交的答案
        for (int i=1;i<=currentQset.size();i++){
            String flag = "answer_"+i;
            inputanswerlist.add(request.getParameter(flag));
        }
//        System.out.println("提交的答案："+inputanswerlist);

        int result = questionsServiceImpl.checkAnswers(inputanswerlist, currentQset);//统计得分，调用checkAnswers()检验
//        System.out.println(result);
        String username =(String) request.getSession().getAttribute("username");//获取当前答题的用户名
//        System.out.println("当前用户名："+username);
        String currentTime = questionsServiceImpl.getCurrentTime()+"";//获取完成时的时间
//        System.out.println("当前提交时间"+currentTime);
        String  qset_title =(String) request.getSession().getAttribute("Qset_title");//获取套题标题
//        System.out.println("当前套题标题：" + qset_title);

        //添加数据
        stuResultImpl.add(new StuResultBean(result,username,currentTime,question_code,qset_title));
//        System.out.println("添加数据成功！");

        return "StudentIndex";
    }


}
