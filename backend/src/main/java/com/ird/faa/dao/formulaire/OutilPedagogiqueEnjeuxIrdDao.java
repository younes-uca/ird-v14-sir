package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.OutilPedagogiqueEnjeuxIrd;


@Repository
public interface OutilPedagogiqueEnjeuxIrdDao extends JpaRepository<OutilPedagogiqueEnjeuxIrd,Long> {






    List<OutilPedagogiqueEnjeuxIrd> findByOutilPedagogiqueId(Long id);

    int deleteByOutilPedagogiqueId(Long id);
    List<OutilPedagogiqueEnjeuxIrd> findByEnjeuxIrdCode(String code);
    int deleteByEnjeuxIrdCode(String code);

    List<OutilPedagogiqueEnjeuxIrd> findByEnjeuxIrdId(Long id);

    int deleteByEnjeuxIrdId(Long id);


}
