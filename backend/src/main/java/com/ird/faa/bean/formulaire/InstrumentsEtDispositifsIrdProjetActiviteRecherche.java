package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instruments_et_dispositifs_ird_projet_activite_recherche")
public class InstrumentsEtDispositifsIrdProjetActiviteRecherche {

    @Id
    @SequenceGenerator(name = "instruments_et_dispositifs_ird_projet_activite_recherche_seq", sequenceName = "instruments_et_dispositifs_ird_projet_activite_recherche_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instruments_et_dispositifs_ird_projet_activite_recherche_seq")
    private Long id;


    @ManyToOne
    private ProjetActiviteRecherche projetActiviteRecherche;
    @ManyToOne
    private InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd;


    public InstrumentsEtDispositifsIrdProjetActiviteRecherche() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjetActiviteRecherche getProjetActiviteRecherche() {
        return this.projetActiviteRecherche;
    }

    public void setProjetActiviteRecherche(ProjetActiviteRecherche projetActiviteRecherche) {
        this.projetActiviteRecherche = projetActiviteRecherche;
    }

    public InstrumentsEtDispositifsIrd getInstrumentsEtDispositifsIrd() {
        return this.instrumentsEtDispositifsIrd;
    }

    public void setInstrumentsEtDispositifsIrd(InstrumentsEtDispositifsIrd instrumentsEtDispositifsIrd) {
        this.instrumentsEtDispositifsIrd = instrumentsEtDispositifsIrd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentsEtDispositifsIrdProjetActiviteRecherche instrumentsEtDispositifsIrdProjetActiviteRecherche = (InstrumentsEtDispositifsIrdProjetActiviteRecherche) o;
        return id != null && id.equals(instrumentsEtDispositifsIrdProjetActiviteRecherche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

