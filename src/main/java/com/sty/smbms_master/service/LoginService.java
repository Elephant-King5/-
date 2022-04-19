package com.sty.smbms_master.service;

import com.sty.smbms_master.mapper.LoginMapper;
import com.sty.smbms_master.pojo.smbmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Service
public class LoginService {
    //Service层调用Dao层
    @Autowired
    LoginMapper loginMapper;
    //判断登录信息
    public smbmsUser login(String userCode,String Password){
        smbmsUser user = loginMapper.findUserByName(userCode);
        if(user!=null&&user.getUserPassword().equals(Password)){    //用户名密码正确
            return user;
        }else{
            return null;
        }
    }
}
