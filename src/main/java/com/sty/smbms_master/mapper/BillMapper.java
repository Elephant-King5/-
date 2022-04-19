package com.sty.smbms_master.mapper;


import com.sty.smbms_master.pojo.smbmsBill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface BillMapper {
    //查询所有订单
    public Collection<smbmsBill> findAll();

    //通过账单编码查询订单

    public Collection<smbmsBill> findByBillCode(String billCode);

    //根据商品名称查找订单
    public Collection<smbmsBill> findByName(String name);

    //根据商品描述查找订单
    public Collection<smbmsBill> findByTitle(String title);

    //根据id删除订单
    public int deleteBill(int id);

    //添加账单
    public int addBill(smbmsBill bill);

    //更新订单信息
    public int updateBill(smbmsBill bill);

    //根据ID查询订单
    public smbmsBill findById(int id);
}