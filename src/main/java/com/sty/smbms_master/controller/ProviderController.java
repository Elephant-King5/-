package com.sty.smbms_master.controller;


import com.sty.smbms_master.pojo.smbmsProvider;
import com.sty.smbms_master.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping("/provider/list")
    public String list(Model model){
        Collection<smbmsProvider> providers = providerService.findAll();
        model.addAttribute("providers",providers);
        return "provider/list";
    }

    @GetMapping("/provider/findById")
    public String findById(Model model,String proCode){
        Collection<smbmsProvider> byProCode = providerService.findByProCode(proCode);
        if(byProCode==null){
            return "redirect:/provider/list";
        }else{
            model.addAttribute("providers",byProCode);
            return "provider/list";
        }
    }
    @GetMapping("/provider/findByName")
    public String findByName(Model model,String proName){
        Collection<smbmsProvider> byProCode = providerService.findByProName(proName);
        if(byProCode==null){
            return "redirect:/provider/list";
        }else{
            model.addAttribute("providers",byProCode);
            return "provider/list";
        }
    }
    @GetMapping("/provider/findByTitle")
    public String findByTitle(Model model,String proTitle){
        Collection<smbmsProvider> byProCode = providerService.findByProDesc(proTitle);
        if(byProCode==null){
            return "redirect:/provider/list";
        }else{
            model.addAttribute("providers",byProCode);
            return "provider/list";
        }
    }
    @GetMapping("/provider/add")
    public String toAddPage(){
        return "provider/add";
    }

    @PostMapping("/addPro")
    public String addPro(Model model,smbmsProvider provider){
        int i = providerService.addPro(provider);
        if(i==-1)  {
            model.addAttribute("addmsg","信息输入错误！请重新输入！");
            return "provider/add";
        }else{
            return "redirect:/provider/list";
        }
    }

    @GetMapping("/ProCom/{id}")
    public String toComProPage(@PathVariable("id") int id,Model model){
        smbmsProvider proById = providerService.findProById(id);
        model.addAttribute("updateProvider",proById);
        return "provider/update";
    }

    @GetMapping("/ProDel/{id}")
    public String ProDel(@PathVariable("id") int id){
        providerService.delPro(id);
        return "redirect:/provider/list";
    }

    @PostMapping("/updPro")
    public String updPro(smbmsProvider provider,Model model){
        int i = providerService.comPro(provider);
        if(i==-1){
            model.addAttribute("updmsg","输入错误！请重新输入！");
            smbmsProvider proById = providerService.findProById(provider.getId());
            model.addAttribute("updateProvider",proById);
            return "provider/update";
        }else{
            return "redirect:/provider/list";
        }
    }
}
