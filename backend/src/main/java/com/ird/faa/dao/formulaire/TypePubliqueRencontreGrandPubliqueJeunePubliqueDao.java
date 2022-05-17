package com.ird.faa.dao.formulaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.formulaire.TypePubliqueRencontreGrandPubliqueJeunePublique;


@Repository
public interface TypePubliqueRencontreGrandPubliqueJeunePubliqueDao extends JpaRepository<TypePubliqueRencontreGrandPubliqueJeunePublique,Long> {






    List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByRencontreGrandPubliqueJeunePubliqueId(Long id);

    int deleteByRencontreGrandPubliqueJeunePubliqueId(Long id);
    List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByTypePubliqueCode(String code);
    int deleteByTypePubliqueCode(String code);

    List<TypePubliqueRencontreGrandPubliqueJeunePublique> findByTypePubliqueId(Long id);

    int deleteByTypePubliqueId(Long id);


}
