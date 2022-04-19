package com.sty.smbms_master.service;


import com.sty.smbms_master.mapper.UserMapper;
import com.sty.smbms_master.pojo.smbmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public Collection<smbmsUser> findAll(){
        return userMapper.findAll();
    }
    public int addUser(smbmsUser user){
        System.out.println(user);
        boolean f=false;
        if(user.getUserPassword()!=""&&user.getUserCode()!=""&&user.getUserName()!=""){
            for (smbmsUser smbmsUser : userMapper.findAll()) {
                if(smbmsUser.getUserCode().equals(user.getUserCode())) f=true;
            }
            if(!f){
                userMapper.addUser(user);
                return 1;
            }
            else
                return -1;
        }
        else{
            return 0;
        }
    }
    public void deleteUser(int id){
        userMapper.deleteById(id);
    }

    public smbmsUser findById(int id){
        return userMapper.findById(id);
    }

    public void update(smbmsUser user){
        userMapper.updateUser(user);
    }

    public int updatePwd(String oldPwd, String newPwd, String newPwdAgain, smbmsUser user){
        if(newPwd.equals(newPwdAgain)&&newPwd!=""){
            if(user.getUserPassword().equals(oldPwd)){
                Map params = new HashMap();
                params.put("pwd",newPwd);
                params.put("id",user.getId());
                userMapper.updateUserPwd(params);
                return 1;   //正确
            }else{
                return 0;   //旧密码对不上
            }
        }else {
            return -1;      //两次密码不一样
        }

    }
    public smbmsUser searchById(String id) {         //主页面查询
        if(id.equals(""))
            return null;
        else{
            smbmsUser user = findById(Integer.parseInt(id));
            return user;
        }
    }
    public Collection<smbmsUser> searchUserByName(String name){
        if(name.equals("")){
            return null;
        }
        else{
            Collection<smbmsUser> smbmsUsers = userMapper.searchUserByName(name);
            return smbmsUsers;
        }
    }

}
