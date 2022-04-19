package com.sty.smbms_master.mapper;


import com.sty.smbms_master.pojo.smbmsProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface ProviderMapper {

    public Collection<smbmsProvider> findAll();

    public Collection<smbmsProvider> findByProCode(String proCode);

    public Collection<smbmsProvider> findByProName(String proName);

    public Collection<smbmsProvider> findByProDesc(String proDesc);

    public int addPro(smbmsProvider provider);

    public int delPro(int id);

    public int comPro(smbmsProvider provider);

    public smbmsProvider findProById(int id);
}
