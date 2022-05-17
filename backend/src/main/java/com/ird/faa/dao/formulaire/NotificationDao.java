package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification,Long> {



    @Query("SELECT item FROM Notification item ORDER BY item.dateNotification ASC")
    List<Notification> findAll();


    List<Notification> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<Notification> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<Notification> findByCategorieNotificationCode(String code);
    int deleteByCategorieNotificationCode(String code);

    List<Notification> findByCategorieNotificationId(Long id);

    int deleteByCategorieNotificationId(Long id);


}
