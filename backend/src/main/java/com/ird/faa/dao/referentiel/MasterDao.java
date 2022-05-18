package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.Master;


@Repository
public interface MasterDao extends JpaRepository<Master,Long> {




    Master findByCode(String code);

    int deleteByCode(String code);

    List<Master> findByPaysCode(String code);
    int deleteByPaysCode(String code);

    List<Master> findByPaysId(Long id);

    int deleteByPaysId(Long id);


}
