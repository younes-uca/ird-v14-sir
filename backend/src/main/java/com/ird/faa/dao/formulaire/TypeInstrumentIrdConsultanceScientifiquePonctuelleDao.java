package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.TypeInstrumentIrdConsultanceScientifiquePonctuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeInstrumentIrdConsultanceScientifiquePonctuelleDao extends JpaRepository<TypeInstrumentIrdConsultanceScientifiquePonctuelle,Long> {





    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByTypeInstrumentIrdCode(String code);
    int deleteByTypeInstrumentIrdCode(String code);

    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByTypeInstrumentIrdId(Long id);

    int deleteByTypeInstrumentIrdId(Long id);

    List<TypeInstrumentIrdConsultanceScientifiquePonctuelle> findByConsultanceScientifiquePonctuelleId(Long id);

    int deleteByConsultanceScientifiquePonctuelleId(Long id);


}
