package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.ResponsabiliteDirectionEncadrementEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponsabiliteDirectionEncadrementEtudiantDao extends JpaRepository<ResponsabiliteDirectionEncadrementEtudiant,Long> {




    ResponsabiliteDirectionEncadrementEtudiant findByCode(String code);

    int deleteByCode(String code);



}
