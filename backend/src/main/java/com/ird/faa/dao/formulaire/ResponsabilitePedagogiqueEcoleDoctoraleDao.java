package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.ResponsabilitePedagogiqueEcoleDoctorale;


@Repository
public interface ResponsabilitePedagogiqueEcoleDoctoraleDao extends JpaRepository<ResponsabilitePedagogiqueEcoleDoctorale,Long> {




    ResponsabilitePedagogiqueEcoleDoctorale findByAnnee(Integer annee);

    int deleteByAnnee(Integer annee);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByStatutEcoleDoctoraleCode(String code);
    int deleteByStatutEcoleDoctoraleCode(String code);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByStatutEcoleDoctoraleId(Long id);

    int deleteByStatutEcoleDoctoraleId(Long id);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEcoleDoctoraleIntitule(String intitule);
    int deleteByEcoleDoctoraleIntitule(String intitule);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEcoleDoctoraleId(Long id);

    int deleteByEcoleDoctoraleId(Long id);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEtablissementCode(String code);
    int deleteByEtablissementCode(String code);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEtablissementId(Long id);

    int deleteByEtablissementId(Long id);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEtatEtapeCampagneCode(String code);
    int deleteByEtatEtapeCampagneCode(String code);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByEtatEtapeCampagneId(Long id);

    int deleteByEtatEtapeCampagneId(Long id);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByChercheurNumeroMatricule(String numeroMatricule);
    int deleteByChercheurNumeroMatricule(String numeroMatricule);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByChercheurId(Long id);

    int deleteByChercheurId(Long id);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByCampagneCode(String code);
    int deleteByCampagneCode(String code);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByCampagneId(Long id);

    int deleteByCampagneId(Long id);

    List<ResponsabilitePedagogiqueEcoleDoctorale> findByChercheurUsernameAndCampagneId(String username, Long compagneId);
    List<ResponsabilitePedagogiqueEcoleDoctorale> findByChercheurUsername(String username);

}
