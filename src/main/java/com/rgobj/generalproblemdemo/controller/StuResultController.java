package com.rgobj.generalproblemdemo.controller;

import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionInfoServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionsServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuResultImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuUserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nekotaku
 * @create 2021-05-25 10:58
 */

@Controller
public class StuResultController {

    @Autowired
    StuUserServiceImpl stuUserServiceImpl;//学生业务层实现

    @Autowired
    QuestionInfoServiceImpl questionInfoServiceImpl;//套题信息业务层实现

    @Autowired
    QuestionsServiceImpl questionsServiceImpl;//套题业务层实现

    @Autowired
    StuResultImpl stuResultImpl;//学生结果业务层实现

    @RequestMapping("/toDeleted")
    public String toDeleted(Model model, HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("username");
//        System.out.println("删除的用户名："+username);
        String finishtime = request.getParameter("finishtime");
//        System.out.println("删除的完成时间"+stuResultImpl.resDate(finishtime));

//        删除操作
        stuResultImpl.deleteBySelect(username,finishtime);

        return "redirect:/toStuExamResult";
    }

}
