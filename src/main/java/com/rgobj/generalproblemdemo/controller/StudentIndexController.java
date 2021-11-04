package com.rgobj.generalproblemdemo.controller;

import com.rgobj.generalproblemdemo.bean.QuestionInfoBean;
import com.rgobj.generalproblemdemo.bean.QuestionsBean;
import com.rgobj.generalproblemdemo.bean.StuResultBean;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionInfoServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.QuestionsServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuResultImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author nekotaku
 * @create 2021-05-13 20:35
 */
@Controller
public class StudentIndexController {

    @Autowired
    StuUserServiceImpl stuUserServiceImpl;//学生业务层实现

    @Autowired
    QuestionInfoServiceImpl questionInfoServiceImpl;//套题信息业务层实现

    @Autowired
    QuestionsServiceImpl questionsServiceImpl;//套题业务层实现

    @Autowired
    StuResultImpl stuResultImpl;//学生结果业务层实现

    @RequestMapping("/toStuIndex")
    public String toStudentIndex(Model model, HttpServletRequest request){
        return "StudentIndex";
    }


//    跳转答题中心
    @RequestMapping("/toStuExam")
    public String toStuExam(Model model, HttpServletRequest request){

        //查询所有套题
        List<QuestionInfoBean> questionInfoBeans = questionInfoServiceImpl.queryAll();

        //对套题进行排序显示，时间后的靠前
        questionInfoServiceImpl.setSorting(questionInfoBeans);

        //将套题的时间戳进行格式化
        for(QuestionInfoBean q:questionInfoBeans){
            q.setQuestion_time(questionInfoServiceImpl.getFormatDate(q.getQuestion_time()));
        }
        request.getSession().setAttribute("questionInfo",questionInfoBeans);

        return "StuExam";
    }

//    跳转情况查看中心
    @RequestMapping("/toStuExamResult")
    public String toStuExamResult(Model model, HttpServletRequest request){

//        获取当前用户名
        String username =(String) request.getSession().getAttribute("username");

        //查询当前学生结果
        List<StuResultBean> stuResultBeans = stuResultImpl.queryAllByName(username);

        //按最新的答题时间排序
        stuResultImpl.setSorting(stuResultBeans);

        //对时间进行格式化
        for(StuResultBean s:stuResultBeans){
            s.setStu_finishtime(stuResultImpl.getFormatDate(s.getStu_finishtime()));
        }
        request.getSession().setAttribute("StuResults",stuResultBeans);

        return "StuExamResult";
    }

//    退出
    @GetMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("loginTime");
        request.getSession().removeAttribute("questionInfo");
        return "redirect:/toLogin";
    }

//    跳转答题界面
    @RequestMapping("/toQuestionsStart")
    public String toQuestionsStart(HttpServletRequest request){
        String question_code = request.getParameter("Question_code");//获取套题ID
        String question_title = request.getParameter("Question_title");//套题标题
        String question_author = request.getParameter("Question_author");//套题作者
//        System.out.println("套题ID："+question_code);
        int code = new Integer(question_code);//将ID转换为整形
//        System.out.println("套题ID："+code);
        //根据套题ID查询套题
        List<QuestionsBean> currentQset = questionsServiceImpl.queryAllByCode(code);

        String question_count = currentQset.size() + "";//套题的总题数
        String score = questionsServiceImpl.sumScore(currentQset)+"";//当前套题总分


        //存储相关信息状态
        request.getSession().setAttribute("currentQset",currentQset);
        request.getSession().setAttribute("Qset_title",question_title);
        request.getSession().setAttribute("Qset_author",question_author);
        request.getSession().setAttribute("Question_code",question_code);
        request.getSession().setAttribute("Qset_count",question_count);
        request.getSession().setAttribute("Qset_score",score);

        return "QuestionsStart";
    }

}
