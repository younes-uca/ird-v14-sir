package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.ModeDiffusion;


@Repository
public interface ModeDiffusionDao extends JpaRepository<ModeDiffusion,Long> {




    ModeDiffusion findByCode(String code);

    int deleteByCode(String code);

    List<ModeDiffusion> findByTypeSavoirCode(String code);
    int deleteByTypeSavoirCode(String code);

    List<ModeDiffusion> findByTypeSavoirId(Long id);

    int deleteByTypeSavoirId(Long id);


}
