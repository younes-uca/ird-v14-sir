package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.KeyWordDisciplineScientifiqueErc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KeyWordDisciplineScientifiqueErcDao extends JpaRepository<KeyWordDisciplineScientifiqueErc,Long> {





    List<KeyWordDisciplineScientifiqueErc> findByKeyWordCode(String code);
    int deleteByKeyWordCode(String code);

    List<KeyWordDisciplineScientifiqueErc> findByKeyWordId(Long id);

    int deleteByKeyWordId(Long id);
    List<KeyWordDisciplineScientifiqueErc> findByDisciplineScientifiqueErcCode(String code);
    int deleteByDisciplineScientifiqueErcCode(String code);

    List<KeyWordDisciplineScientifiqueErc> findByDisciplineScientifiqueErcId(Long id);

    int deleteByDisciplineScientifiqueErcId(Long id);


}
