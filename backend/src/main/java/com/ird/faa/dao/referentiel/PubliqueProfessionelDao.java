package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.referentiel.PubliqueProfessionel;


@Repository
public interface PubliqueProfessionelDao extends JpaRepository<PubliqueProfessionel,Long> {


}
