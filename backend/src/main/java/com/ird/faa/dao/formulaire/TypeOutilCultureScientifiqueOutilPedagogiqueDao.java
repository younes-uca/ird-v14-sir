package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.TypeOutilCultureScientifiqueOutilPedagogique;


@Repository
public interface TypeOutilCultureScientifiqueOutilPedagogiqueDao extends JpaRepository<TypeOutilCultureScientifiqueOutilPedagogique,Long> {






    List<TypeOutilCultureScientifiqueOutilPedagogique> findByCultureScientifiqueOutilPedagogiqueId(Long id);

    int deleteByCultureScientifiqueOutilPedagogiqueId(Long id);
    List<TypeOutilCultureScientifiqueOutilPedagogique> findByTypeOutilCode(String code);
    int deleteByTypeOutilCode(String code);

    List<TypeOutilCultureScientifiqueOutilPedagogique> findByTypeOutilId(Long id);

    int deleteByTypeOutilId(Long id);


}
