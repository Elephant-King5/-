package com.sty.smbms_master.controller;


import com.sty.smbms_master.pojo.smbmsUser;
import com.sty.smbms_master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    //转到用户显示界面
    @GetMapping("/users")
    public String findAll(Model model){
        Collection<smbmsUser> users = userService.findAll();
        model.addAttribute("users",users);
        return "user/list";
    }

    @GetMapping("/user")
    public String toAddPage(){
        return "user/add";
    }
    @PostMapping("/user")
    public String addUser(smbmsUser smbmsUser, HttpSession session,Model model){
        smbmsUser user = (smbmsUser) session.getAttribute("user");
        //System.out.println(smbmsUser);
        smbmsUser.setCreatedBy(user.getId());
        smbmsUser.setCreateDate(new Date());
        int i = userService.addUser(smbmsUser);
        if(i==0){
            model.addAttribute("addmsg","输入错误，请重新输入！");
            return "user/add";
        }else if(i==1){
            return "redirect:/users";
        }else{
            model.addAttribute("addmsg","用户名重复！请重新输入！");
            return "user/add";
        }
    }

    @GetMapping("/userDel/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/user/updatePwd")
    public String toupdatePwdPage(){

        return "user/updatePassword";
    }
    @PostMapping("/user/updatePwd")
    public  String updatePwd(Model model,String oldPwd, String newPwd, String newPwdAgain, HttpSession session){
        smbmsUser user = (smbmsUser) session.getAttribute("user");
        int i = userService.updatePwd(oldPwd, newPwd, newPwdAgain, user);
        if(i==0){
            model.addAttribute("updatePwdmsg","输入密码错误！");
            return "user/updatePassword";
        }else if(i==-1){
            model.addAttribute("updatePwdmsg","两次输入不相同,或者输入密码为空！");
            return "user/updatePassword";
        }else{
            model.addAttribute("msg","密码修改成功！请重新登录!");
            return "index";
        }


    }
    @GetMapping("/user/{id}")
    public String toUpdatePage(@PathVariable("id") int id,Model model){
        model.addAttribute("updateUser",userService.findById(id));
        return "user/update";
    }
    @PostMapping("/updateUser")
    public String updateUser(smbmsUser user){
        userService.update(user);
        return "redirect:/users";
    }
    @GetMapping("/user/findById")
    public String searchById(Model model,String id){        //用户通过id查找
        smbmsUser user = userService.searchById(id);
        if(user==null)  return "redirect:/users";
        else{
            model.addAttribute("users", user);
            return "user/list";
        }
    }
    @GetMapping("/user/findByName")
    public String searchByName(String name,Model model){
        Collection<smbmsUser> smbmsUsers = userService.searchUserByName(name);
        if(smbmsUsers==null){
            return "redirect:/users";
        }else{
            model.addAttribute("users",smbmsUsers);
            return "/user/list";
        }
    }
}
