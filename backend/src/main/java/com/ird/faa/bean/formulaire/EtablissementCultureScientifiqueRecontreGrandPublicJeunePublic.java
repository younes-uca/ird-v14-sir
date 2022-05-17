package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Etablissement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_culture_scientifique_recontre_grand_public_jeune_public")
public class EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic {

    @Id
    @SequenceGenerator(name = "etablissement_culture_scientifique_recontre_grand_public_jeune_public_seq", sequenceName = "etablissement_culture_scientifique_recontre_grand_public_jeune_public_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_culture_scientifique_recontre_grand_public_jeune_public_seq")
    private Long id;


    @ManyToOne
    private CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic;
    @ManyToOne
    private Etablissement etablissement;


    public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic() {
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

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic etablissementCultureScientifiqueRecontreGrandPublicJeunePublic = (EtablissementCultureScientifiqueRecontreGrandPublicJeunePublic) o;
        return id != null && id.equals(etablissementCultureScientifiqueRecontreGrandPublicJeunePublic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

