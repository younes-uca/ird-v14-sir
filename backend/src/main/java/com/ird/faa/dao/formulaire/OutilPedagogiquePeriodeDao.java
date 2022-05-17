package com.ird.faa.dao.formulaire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ird.faa.bean.formulaire.OutilPedagogiquePeriode;


@Repository
public interface OutilPedagogiquePeriodeDao extends JpaRepository<OutilPedagogiquePeriode, Long> {


	List<OutilPedagogiquePeriode> findByOutilPedagogiqueId(Long id);

	int deleteByOutilPedagogiqueId(Long id);


}
