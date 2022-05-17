package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.CategorieNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieNotificationDao extends JpaRepository<CategorieNotification,Long> {




    CategorieNotification findByCode(String code);

    int deleteByCode(String code);



}
