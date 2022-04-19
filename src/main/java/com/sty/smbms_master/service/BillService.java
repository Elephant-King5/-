package com.sty.smbms_master.service;


import com.sty.smbms_master.mapper.BillMapper;
import com.sty.smbms_master.pojo.smbmsBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;
    //返回所有订单
    public Collection<smbmsBill> findAll(){
        return billMapper.findAll();
    }

    //根据账单编码返回订单
    public Collection<smbmsBill> findByBillCode(String billCode){
        if(billCode.equals(""))  return billMapper.findAll();
        else    return billMapper.findByBillCode(billCode);
    }
    //根据商品名称返回订单
    public Collection<smbmsBill> findByName(String name){
        if(name.equals(""))    return billMapper.findAll();
        else    return billMapper.findByName(name);
    }
    //根据商品描述查找订单
    public Collection<smbmsBill> findByTitle(String title){
        if(title.equals(""))    return  billMapper.findAll();
        else return billMapper.findByTitle(title);
    }
    //删除订单信息
    public void delBill(int id){
        billMapper.deleteBill(id);
    }
    //添加订单信息
    public int addBill(smbmsBill bill){
        if(bill.getBillCode().equals("")||bill.getIsPayment()==null||bill.getProductCount()==null||bill.getProductDesc().equals("")||bill.getProductName().equals("")||bill.getProductUnit().equals("")||bill.getTotalPrice()==null){
            return -1;
        }else{
            billMapper.addBill(bill);
            return 1;
        }
    }
    //根据订单id查找订单
    public smbmsBill findBillById(int id){
        return billMapper.findById(id);
    }


    //修改订单信息
    public int updateBill(smbmsBill bill){
        if(bill.getBillCode().equals("")||bill.getIsPayment()==null||bill.getProductCount()==null||bill.getProductDesc().equals("")||bill.getProductName().equals("")||bill.getProductUnit().equals("")||bill.getTotalPrice()==null){
            return -1;
        }else{
            billMapper.updateBill(bill);
            return 1;
        }
    }


}
