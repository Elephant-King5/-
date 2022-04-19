package com.sty.smbms_master.mapper;

import com.sty.smbms_master.pojo.smbmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;


@Repository
@Mapper
public interface LoginMapper {

    //根据用户名查找用户信息
    public smbmsUser findUserByName(String userCode);

}
