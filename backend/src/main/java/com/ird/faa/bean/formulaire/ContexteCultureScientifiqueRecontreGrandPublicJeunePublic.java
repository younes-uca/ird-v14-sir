package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Contexte;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contexte_culture_scientifique_recontre_grand_public_jeune_public")
public class ContexteCultureScientifiqueRecontreGrandPublicJeunePublic {

    @Id
    @SequenceGenerator(name = "contexte_culture_scientifique_recontre_grand_public_jeune_public_seq", sequenceName = "contexte_culture_scientifique_recontre_grand_public_jeune_public_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contexte_culture_scientifique_recontre_grand_public_jeune_public_seq")
    private Long id;


    @ManyToOne
    private CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic;
    @ManyToOne
    private Contexte contexte;


    public ContexteCultureScientifiqueRecontreGrandPublicJeunePublic() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CultureScientifiqueRecontreGrandPublicJeunePublic getCultureScientifiqueRecontreGrandPublicJeunePublic() {
        return this.cultureScientifiqueRecontreGrandPublicJeunePublic;
    }

    public void setCultureScientifiqueRecontreGrandPublicJeunePublic(CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic) {
        this.cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublic;
    }

    public Contexte getContexte() {
        return this.contexte;
    }

    public void setContexte(Contexte contexte) {
        this.contexte = contexte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContexteCultureScientifiqueRecontreGrandPublicJeunePublic contexteCultureScientifiqueRecontreGrandPublicJeunePublic = (ContexteCultureScientifiqueRecontreGrandPublicJeunePublic) o;
        return id != null && id.equals(contexteCultureScientifiqueRecontreGrandPublicJeunePublic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

