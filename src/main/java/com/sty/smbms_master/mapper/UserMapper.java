package com.sty.smbms_master.mapper;

import com.sty.smbms_master.pojo.smbmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;


@Mapper
@Repository
public interface UserMapper {
    //查询所有用户信息
    public Collection<smbmsUser> findAll();
    //添加用户
    public int addUser(smbmsUser user);
    //删除用户
    public int deleteById(int id);
    //通过id查找用户
    public smbmsUser findById(int id);
    //更新用户
    public int updateUser(smbmsUser user);
    //更新用户密码
    public int updateUserPwd(Map hashMap);
    //通过用户名查找用户
    public Collection<smbmsUser> searchUserByName(String name);
}
