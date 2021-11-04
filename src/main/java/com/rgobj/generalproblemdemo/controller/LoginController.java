package com.rgobj.generalproblemdemo.controller;

import com.rgobj.generalproblemdemo.bean.StuUserBean;
import com.rgobj.generalproblemdemo.bean.TeacherBean;
import com.rgobj.generalproblemdemo.service.serviceImpl.StuUserServiceImpl;
import com.rgobj.generalproblemdemo.service.serviceImpl.TeacherUserServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * @author nekotaku
 * @create 2021-05-04 20:05
 */
@Controller
public class LoginController {

    @Autowired
    StuUserServiceImpl stuUserServiceImpl;//学生业务层实现

    @Autowired
    TeacherUserServiceImpl teacherUserServiceImpl;//教师业务层实现


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/")
    public String firstInto(){
        return "login";
    }

    @RequestMapping("/LoginSuccess")
    public String LoginSuccess(Model model, StuUserBean stuUserBean, TeacherBean teacherBean, HttpServletRequest request, HttpServletResponse response) {

        //获取登陆的用户类型
        String logintype = "0";
        if (request.getParameter("logintype") != null) {
            logintype = request.getParameter("logintype");//1教师，2学生
        }
        Integer type = new Integer(logintype);
        switch (type) {
            case 1://教师登陆
                TeacherBean teacherBeanMy = teacherUserServiceImpl.loginCheck(teacherBean.getUsername(), teacherBean.getPassword());
                if (teacherBeanMy != null) {//查询不为空
                    String loginTime = teacherUserServiceImpl.loginTime();

                    request.getSession().setAttribute("userInfo",teacherBeanMy.getName());
                    request.getSession().setAttribute("username",teacherBeanMy.getUsername());
                    request.getSession().setAttribute("loginTime",loginTime);

                    return "TeacherIndex";
                } else {
                    model.addAttribute("data", "用户名或密码错误，请重新输入");
                    System.out.println("用户名或密码错误，请重新输入--教师");
                    return "login";
                }
            case 2:
                StuUserBean stuUserBeanMy = stuUserServiceImpl.loginCheck(stuUserBean.getUsername(), stuUserBean.getPassword());
                if (stuUserBeanMy != null) {
                    String loginTime = stuUserServiceImpl.loginTime();//登录时间
//                    System.out.println(stuUserBeanMy.toString());
//                    model.addAttribute("userInfo",stuUserBeanMy.getName());
//                    model.addAttribute("username",stuUserBeanMy.getUsername());
//                    model.addAttribute("loginTime",loginTime);


                    request.getSession().setAttribute("userInfo",stuUserBeanMy.getName());
                    request.getSession().setAttribute("username",stuUserBeanMy.getUsername());
                    request.getSession().setAttribute("loginTime",loginTime);
//
//                    //登陆成功的弹窗
//                    response.setContentType("text/html; charset=utf-8");
//                    PrintWriter out = null;
//                    try {
//                        out = response.getWriter();
//                        out.print("<script>alert('登陆成功');</script>");
//                        out.close();
//                        return "StudentIndex";
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }finally {
//                        IOUtils.closeQuietly(out);
//                    }
                    return "StudentIndex";

                } else {
                    model.addAttribute("data", "用户名或密码错误，请重新输入");
                    System.out.println("用户名或密码错误，请重新输入--学生");
                    return "login";
                }
//                //先查询该用户名是否存在
//                StuUserBean stuUserBeanMy = stuUserServiceImpl.queryByName(stuUserBean.getUsername());
//                if (stuUserBeanMy != null) {//如果查询不为空
////            System.out.println(stuUserBeanMy.toString());//验证密码
//                    return "StudentIndex";
//                } else {
//                    model.addAttribute("data", "该用户不存在，请先注册");
//                    return "login";
//                }
            default:
                model.addAttribute("data", "请选择登陆身份!");
                return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/RegisterSuccess")
    public String toRegisterSuccess(Model model, StuUserBean stuUserBean, TeacherBean teacherBean,HttpServletRequest request) {

        //获取用户选择的注册类型
        String registertype = "0";
        if (request.getParameter("registertype") != null) {
            registertype = request.getParameter("registertype");//1教师，2学生
        }
        Integer type = new Integer(registertype);

        switch (type) {
            case 1:
                TeacherBean teacherBeanMy = teacherUserServiceImpl.queryByName(teacherBean.getUsername());
                if (teacherBeanMy != null) {//如果查询不为空
                    model.addAttribute("data", "用户名已存在，请重新输入");
                    System.out.println("用户名已存在，请重新输入--教师");
                    return "register";
                } else {//账号不存在可以注册
                    //将账号密码加入到数据库中
                    int add = teacherUserServiceImpl.add(teacherBean);
//                    System.out.println("数据插入成功！");
                    //System.out.println(add);
                    model.addAttribute("data", "注册成功，请登陆!");
//                    System.out.println("注册成功--教师");
                    return "login";
                }

            case 2:
                StuUserBean stuUserBeanMy = stuUserServiceImpl.queryByName(stuUserBean.getUsername());
                if (stuUserBeanMy != null) {//如果查询不为空
                    model.addAttribute("data", "用户名已存在，请重新输入");
                    System.out.println("用户名已存在，请重新输入--学生");
                    return "register";
                } else {//账号不存在可以注册
                    //将账号密码加入到数据库中
                    int add = stuUserServiceImpl.add(stuUserBean);
//                    System.out.println("数据插入成功！");
                    //System.out.println(add);
                    model.addAttribute("data", "注册成功，请登陆!");
//                    System.out.println("注册成功--学生");
                    return "login";
                }
            default:
                model.addAttribute("data", "请先选择注册身份!");
                return "register";
        }
    }
}
