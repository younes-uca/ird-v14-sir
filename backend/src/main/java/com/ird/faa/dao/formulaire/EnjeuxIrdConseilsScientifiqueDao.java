package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.EnjeuxIrdConseilsScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnjeuxIrdConseilsScientifiqueDao extends JpaRepository<EnjeuxIrdConseilsScientifique,Long> {





    List<EnjeuxIrdConseilsScientifique> findByEnjeuxIrdCode(String code);
    int deleteByEnjeuxIrdCode(String code);

    List<EnjeuxIrdConseilsScientifique> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);

    List<EnjeuxIrdConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);


}
