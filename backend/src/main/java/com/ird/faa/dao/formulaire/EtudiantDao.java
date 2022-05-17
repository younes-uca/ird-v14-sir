package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.Etudiant;


@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Long> {





    List<Etudiant> findBySexeCode(String code);
    int deleteBySexeCode(String code);

    List<Etudiant> findBySexeId(Long id);

    int deleteBySexeId(Long id);
    List<Etudiant> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<Etudiant> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}
