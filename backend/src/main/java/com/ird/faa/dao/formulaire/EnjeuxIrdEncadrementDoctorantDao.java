package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.EnjeuxIrdEncadrementDoctorant;


@Repository
public interface EnjeuxIrdEncadrementDoctorantDao extends JpaRepository<EnjeuxIrdEncadrementDoctorant,Long> {





    List<EnjeuxIrdEncadrementDoctorant> findByEnjeuxIrdCode(String code);
    int deleteByEnjeuxIrdCode(String code);

    List<EnjeuxIrdEncadrementDoctorant> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<EnjeuxIrdEncadrementDoctorant> findByEncadrementDoctorantId(Long id);

    int deleteByEncadrementDoctorantId(Long id);


}
