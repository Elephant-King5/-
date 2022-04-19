package com.sty.smbms_master.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class smbmsUser {
    private Integer id;
    private String userCode;    //用户编码
    private String userName;    //用户名
    private String userPassword;    //密码
    private Integer gender;
    private Date birthday;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer createdBy;  //创建者
    private Date createDate;
    private Integer modifyBy;   //更新者
    private Date modifyDate;    //更新时间

}
