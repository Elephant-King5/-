package com.sty.smbms_master.controller;

import com.sty.smbms_master.pojo.smbmsUser;
import com.sty.smbms_master.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    //登录
    @GetMapping("/user/login")
    public String loginController(@RequestParam("Username") String username, @RequestParam("Password") String password, HttpSession session, Model model){
        smbmsUser login = loginService.login(username, password);
        if(login!=null) {
            session.setAttribute("user",login);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误，请重新输入！");
            return "index";
        }
    }
    //返回主界面

    @GetMapping("/index")
    public String toIndex(){
        return "redirect:/main.html";
    }
}
