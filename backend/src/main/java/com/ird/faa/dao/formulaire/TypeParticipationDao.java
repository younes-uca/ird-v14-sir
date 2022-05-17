package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.TypeParticipation;


@Repository
public interface TypeParticipationDao extends JpaRepository<TypeParticipation,Long> {




    TypeParticipation findByCode(String code);

    int deleteByCode(String code);



}
