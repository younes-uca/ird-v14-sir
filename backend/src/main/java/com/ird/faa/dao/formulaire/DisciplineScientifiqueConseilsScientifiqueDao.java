package com.ird.faa.dao.formulaire;

import com.ird.faa.bean.formulaire.DisciplineScientifiqueConseilsScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DisciplineScientifiqueConseilsScientifiqueDao extends JpaRepository<DisciplineScientifiqueConseilsScientifique,Long> {






    List<DisciplineScientifiqueConseilsScientifique> findByConseilsScientifiqueId(Long id);

    int deleteByConseilsScientifiqueId(Long id);
    List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueCode(String code);
    int deleteByDisciplineScientifiqueCode(String code);

    List<DisciplineScientifiqueConseilsScientifique> findByDisciplineScientifiqueId(Long id);

    int deleteByDisciplineScientifiqueId(Long id);


}
