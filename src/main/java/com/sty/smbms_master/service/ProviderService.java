package com.sty.smbms_master.service;


import com.sty.smbms_master.mapper.ProviderMapper;
import com.sty.smbms_master.pojo.smbmsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProviderService {
    @Autowired
    ProviderMapper providerMapper;
    public Collection<smbmsProvider> findAll(){
        return providerMapper.findAll();
    }

    public Collection<smbmsProvider> findByProCode(String proCode){
        if(proCode.equals("")){
            return null;
        }else{
            return providerMapper.findByProCode(proCode);
        }
    }
    public Collection<smbmsProvider> findByProName(String proName){
        if(proName.equals("")){
            return null;
        }else{
            return providerMapper.findByProName(proName);
        }
    }
    public Collection<smbmsProvider> findByProDesc(String proDesc){
        if(proDesc.equals("")){
            return null;
        }else{
            return providerMapper.findByProDesc(proDesc);
        }
    }
    public int addPro(smbmsProvider provider){
        if(provider.getProCode().equals("")||provider.getProName().equals("")||provider.getProDesc().equals("")||provider.getProContact().equals("")||provider.getProPhone().equals("")){
            return -1;
        }else{
            providerMapper.addPro(provider);
            return 1;
        }
    }
    public void delPro(int id){
        providerMapper.delPro(id);
    }
    public smbmsProvider findProById(int id){
        smbmsProvider proById = providerMapper.findProById(id);
        return proById;
    }

    public int comPro(smbmsProvider provider){
        if(provider.getProCode().equals("")||provider.getProName().equals("")||provider.getProDesc().equals("")||provider.getProContact().equals("")||provider.getProPhone().equals("")){
            return -1;
        }else{
            providerMapper.comPro(provider);
            return 1;
        }
    }
}
