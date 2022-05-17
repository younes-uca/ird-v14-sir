package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.InstitutionCoContractant;


@Repository
public interface InstitutionCoContractantDao extends JpaRepository<InstitutionCoContractant,Long> {





    List<InstitutionCoContractant> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<InstitutionCoContractant> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<InstitutionCoContractant> findByInstitutionCode(String code);
    int deleteByInstitutionCode(String code);

    List<InstitutionCoContractant> findByInstitutionId(Long id);

    int deleteByInstitutionId(Long id);


}
