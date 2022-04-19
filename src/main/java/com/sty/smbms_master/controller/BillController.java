package com.sty.smbms_master.controller;


import com.sty.smbms_master.pojo.smbmsBill;
import com.sty.smbms_master.pojo.smbmsProvider;
import com.sty.smbms_master.service.BillService;
import com.sty.smbms_master.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class BillController {

    @Autowired
    BillService billService;
    @Autowired
    ProviderService providerService;
    //查找所有订单
    @GetMapping("/bill/list")
    public String toBillList(Model model){
        Collection<smbmsBill> bills = billService.findAll();
        System.out.println(bills);
        model.addAttribute("bills",bills);
        return "bill/list";
    }
    @GetMapping("/billPay")
    public String toPay(){
        return "bill/pay";
    }
    //通过id查询商品
    @GetMapping("/bill/findById")
    public String findByBillCode(String billCode,Model model){
        Collection<smbmsBill> bills = billService.findByBillCode(billCode);
        model.addAttribute("bills",bills);
        return "bill/list";
    }
    //通过商品名查询商品
    @GetMapping("/bill/findByName")
    public String findByName(String name,Model model){
        Collection<smbmsBill> bills = billService.findByName(name);
        model.addAttribute("bills",bills);
        return "bill/list";
    }
    //通过商品描述查询商品
    @GetMapping("/bill/findByTitle")
    public String findByTitle(String title,Model model){
        Collection<smbmsBill> bills = billService.findByTitle(title);
        model.addAttribute("bills",bills);
        return "bill/list";
    }
    @GetMapping("/billDel/{id}")
    public String deleteBill(@PathVariable("id") int id){
        billService.delBill(id);
        return "redirect:/bill/list";
    }
    @GetMapping("/billAdd")
    public String toAddPage(Model model){
        Collection<smbmsProvider> providers = providerService.findAll();
        model.addAttribute("addBillProviders",providers);
        return "bill/add";
    }
    @PostMapping("/addBill")
    public String addBill(smbmsBill bill,Model model){
        int i = billService.addBill(bill);
        if(i==-1){
            model.addAttribute("addmsg","输入信息有误！请重新输入！");
            return "bill/add";
        }else {
            return "redirect:/bill/list";
        }
    }
    @GetMapping("/billCom/{id}")
    public String toComBillPage(@PathVariable("id") int id,Model model){
        smbmsBill bill = billService.findBillById(id);
        model.addAttribute("bill",bill);
        Collection<smbmsProvider> providers = providerService.findAll();
        model.addAttribute("addBillProviders",providers);
        return "bill/update";
    }
    @PostMapping("/comBill")
    public String comBill(smbmsBill bill,Model model){
        int i = billService.updateBill(bill);
        if(i==-1){
            model.addAttribute("updmsg","输入数据错误！请重新输入！");
            model.addAttribute("bill",bill);
            Collection<smbmsProvider> providers = providerService.findAll();
            model.addAttribute("addBillProviders",providers);
            return "bill/update";
        }else{
            return "redirect:/bill/list";
        }
    }
}
