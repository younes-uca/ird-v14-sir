package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.referentiel.EntiteAdministrative;


@Repository
public interface EntiteAdministrativeDao extends JpaRepository<EntiteAdministrative,Long> {




    EntiteAdministrative findByCode(String code);

    int deleteByCode(String code);

    List<EntiteAdministrative> findByTypeEntiteAdministrativeCode(String code);
    int deleteByTypeEntiteAdministrativeCode(String code);

    List<EntiteAdministrative> findByTypeEntiteAdministrativeId(Long id);

    int deleteByTypeEntiteAdministrativeId(Long id);


}
