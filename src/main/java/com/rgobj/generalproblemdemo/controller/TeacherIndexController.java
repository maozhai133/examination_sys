package com.rgobj.generalproblemdemo.controller;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import com.rgobj.generalproblemdemo.mapper.QuestionInfoMapper;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionInfoServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionsServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.TeacherQsetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-06-02 9:12
 */

@Controller
public class TeacherIndexController {

    @Autowired
    TeacherQsetServiceImpl teacherQsetServiceImpl;//教师套题信息业务层实现

    @Autowired
    QuestionInfoServiceImpl questionInfoServiceImpl;//套题业务层实现

    @Autowired
    QuestionsServiceImpl questionsServiceImpl;//具体答题业务层实现



    //查看教师用户自己出的套题
    @RequestMapping("/toTeacherQset")
    public String toTeacherQset(HttpServletRequest request){
        String username =(String) request.getSession().getAttribute("username");//获取当前登录的教师用户名
//        System.out.println("教师账户:"+username);
        List<QuestionInfoBean> questionInfoBeans = teacherQsetServiceImpl.queryByTeacherUser(username);//根据用户名获取相应的套题信息

//        System.out.println(questionInfoBeans);
        //按时间排序，时间后的靠前
        teacherQsetServiceImpl.setSorting(questionInfoBeans);

        for(QuestionInfoBean q:questionInfoBeans){
            q.setQuestion_time(teacherQsetServiceImpl.getFormatDate(q.getQuestion_time()));
        }
        request.getSession().setAttribute("questionInfo_tea",questionInfoBeans);

        return "TeacherQset";
    }

    //套题修改界面
    @RequestMapping("/toUpdateQset")
    public String toUpdateQset(HttpServletRequest request){
        //获取当前套题ID
        String qsetCode =(String) request.getParameter("QsetCode");
//        System.out.println("当前ID："+qsetCode);
//        将ID转换为int类型
        int code = Integer.parseInt(qsetCode);
//        查询到当前套题信息
        QuestionInfoBean questionInfoBean = teacherQsetServiceImpl.queryByQsetCode(code);
//        System.out.println("当前点击的套题信息"+questionInfoBean);

//        查询具体答题
        List<QuestionsBean> questionsBeans = questionsServiceImpl.queryAllByCode(code);

        //存入状态
        request.getSession().setAttribute("CurrentInfoQset",questionInfoBean);
        request.getSession().setAttribute("CurrentQsetNow",questionsBeans);

        return "TeacherQestUpdate";
    }

    //修改套题信息
    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(HttpServletRequest request){
        //获取当前套题ID
        String qsetCode =(String) request.getParameter("QsetCode");
        //将ID转换为int类型
        int code = Integer.parseInt(qsetCode);
        //获取用户输入框的值(标题和类型)
        String qsetTitle = request.getParameter("QsetTitle");
        String qsetType = request.getParameter("QsetType");
//        System.out.println("输入的值为:"+qsetTitle+":"+qsetType);

        //修改调用
        teacherQsetServiceImpl.updateInfo(qsetTitle,qsetType,code);


//        查询到当前套题信息
        QuestionInfoBean questionInfoBean = teacherQsetServiceImpl.queryByQsetCode(code);
//        System.out.println("当前点击的套题信息"+questionInfoBean);
//        查询具体答题
        List<QuestionsBean> questionsBeans = questionsServiceImpl.queryAllByCode(code);

        //存入状态
        request.getSession().setAttribute("CurrentInfoQset",questionInfoBean);
        request.getSession().setAttribute("CurrentQsetNow",questionsBeans);
        request.getSession().setAttribute("QsetCode",code);

        return "TeacherQestUpdate";
    }

    //修改每题
    @RequestMapping("/UpdateQset")
    public String UpdateQset(HttpServletRequest request){

        //获取当前套题ID
        String qsetCode =(String) request.getParameter("QsetCode");
        //将ID转换为int类型
        int code = Integer.parseInt(qsetCode);
        //获取用户修改的输入框的值
        String currentQuestions = request.getParameter("CurrentQuestions");
        String currentAnswerA = request.getParameter("CurrentAnswerA");
        String currentAnswerB = request.getParameter("CurrentAnswerB");
        String currentAnswerC = request.getParameter("CurrentAnswerC");
        String currentAnswerD = request.getParameter("CurrentAnswerD");
        String currentRight = request.getParameter("CurrentRight");
        String currentCounter = request.getParameter("CurrentCounter");
        //转换题记号的值
        int counter = Integer.parseInt(currentCounter);

        //修改
        teacherQsetServiceImpl.upadateQset(currentQuestions,currentAnswerA,currentAnswerB,currentAnswerC,currentAnswerD,currentRight,code,counter);


        //        查询到当前套题信息
        QuestionInfoBean questionInfoBean = teacherQsetServiceImpl.queryByQsetCode(code);
//        System.out.println("当前点击的套题信息"+questionInfoBean);
//        查询具体答题
        List<QuestionsBean> questionsBeans = questionsServiceImpl.queryAllByCode(code);

        //存入状态
        request.getSession().setAttribute("CurrentInfoQset",questionInfoBean);
        request.getSession().setAttribute("CurrentQsetNow",questionsBeans);
        request.getSession().setAttribute("QsetCode",code);

        return "TeacherQestUpdate";
    }

    //增加套题界面
    @RequestMapping("/toAddQset")
    public String toAddQset(HttpServletRequest request){
        return "AddQsetInfo";
    }

    //跳转具体题目设置
    @RequestMapping("/toAddQsetSet")
    public String toAddQsetSet(HttpServletRequest request){
        //获取当前登录的教师用户名
        String username =(String) request.getSession().getAttribute("username");
//        System.out.println("用户名："+username);
        String userInfo =(String) request.getSession().getAttribute("userInfo");
//        System.out.println("用户名称："+userInfo);

        //获取套题信息相关
        String addQsetTitle = request.getParameter("AddQsetTitle");//标题
        String addQsetType = request.getParameter("AddQsetType");//类型
        String addQsetCounter = request.getParameter("AddQsetCounter");//数量
        String addQsetScore = request.getParameter("AddQsetScore");//每题分数
        //数量和分数转换为整型

        System.out.println("数量："+addQsetCounter);
        int counter = Integer.parseInt(addQsetCounter);
        int score = Integer.parseInt(addQsetScore);
        //获取总分
        int totalpoints = counter * score;

        //获取当前时间戳
        String AddQsetTime = teacherQsetServiceImpl.resDate(teacherQsetServiceImpl.SetQsetTime());
//        System.out.println("时间戳:"+AddQsetTime);
//        teacherQsetServiceImpl.addInfo(new QuestionInfoBean(addQsetTitle,userInfo,AddQsetTime,addQsetType,username,totalpoints));

        //添加信息
        teacherQsetServiceImpl.addInfo(addQsetTitle,userInfo,AddQsetTime,addQsetType,username,totalpoints);

        //状态存入
        request.getSession().setAttribute("AddedQsetTitle",addQsetTitle);
        request.getSession().setAttribute("AddedQsetType",addQsetType);
        request.getSession().setAttribute("AddedQsetCounter",addQsetCounter);
        request.getSession().setAttribute("AddedQsetScore",addQsetScore);
        request.getSession().setAttribute("AddedQsetAuthor",userInfo);

        //获取添加的套题ID
        int QsetCode = teacherQsetServiceImpl.queryCode(username, AddQsetTime);
//        System.out.println("套题ID："+QsetCode);
        request.getSession().setAttribute("AddQsetCode",QsetCode);

        //根据数量生成对应的出题模板
        List<QuestionsBean> questionsBeans = new ArrayList<>();
        for (int i = 1; i <= counter; i++) {
            questionsBeans.add(new QuestionsBean(userInfo,QsetCode,i,score));
        }
        request.getSession().setAttribute("AddQsetsList",questionsBeans);

        return "AddQsets";
    }

    @RequestMapping("/AddComplete")
    public String AddComplete(HttpServletRequest request){

        List<QuestionsBean> list = new ArrayList<>();

        //获取套题基本信息
        String counterQset = request.getParameter("counterQset");//数量

        String codeQset = request.getParameter("codeQset");//套题ID
        String authorQset = request.getParameter("authorQset");//套题作者
        String scoreQset = request.getParameter("scoreQset");//套题每题分值

        //类型转换
        int counter = Integer.parseInt(counterQset);
        int code = Integer.parseInt(codeQset);
        int score = Integer.parseInt(scoreQset);

        for (int i = 1; i <= counter; i++) {

            String addQsetCounter = request.getParameter("AddQsetCounter"+i);
            String addQuestions = request.getParameter("AddQuestions"+i);
            String addQsetA = request.getParameter("AddQsetA"+i);
            String addQsetB = request.getParameter("AddQsetB"+i);
            String addQsetC = request.getParameter("AddQsetC"+i);
            String addQsetD = request.getParameter("AddQsetD"+i);
            String addQsetRight = request.getParameter("AddQsetRight"+i);
            //题号类型转换
            int count = Integer.parseInt(addQsetCounter);
            list.add(new QuestionsBean(addQuestions,addQsetA,addQsetB, addQsetC, addQsetD, addQsetRight, authorQset,code,count,score));
        }

        //添加
        for (int i = 0; i < counter; i++) {
            teacherQsetServiceImpl.addQset(list.get(i));
        }

        return "TeacherIndex";
    }
}
