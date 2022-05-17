package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "public_cible_culture_scientifique_recontre_grand_public")
public class PublicCibleCultureScientifiqueRecontreGrandPublic {

    @Id
    @SequenceGenerator(name = "public_cible_culture_scientifique_recontre_grand_public_seq", sequenceName = "public_cible_culture_scientifique_recontre_grand_public_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public_cible_culture_scientifique_recontre_grand_public_seq")
    private Long id;


    @ManyToOne
    private PublicCible publicCible;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic;


    public PublicCibleCultureScientifiqueRecontreGrandPublic() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublicCible getPublicCible() {
        return this.publicCible;
    }

    public void setPublicCible(PublicCible publicCible) {
        this.publicCible = publicCible;
    }

    public Pays getPays() {
        return this.pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public CultureScientifiqueRecontreGrandPublicJeunePublic getCultureScientifiqueRecontreGrandPublicJeunePublic() {
        return this.cultureScientifiqueRecontreGrandPublicJeunePublic;
    }

    public void setCultureScientifiqueRecontreGrandPublicJeunePublic(CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic) {
        this.cultureScientifiqueRecontreGrandPublicJeunePublic = cultureScientifiqueRecontreGrandPublicJeunePublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicCibleCultureScientifiqueRecontreGrandPublic publicCibleCultureScientifiqueRecontreGrandPublic = (PublicCibleCultureScientifiqueRecontreGrandPublic) o;
        return id != null && id.equals(publicCibleCultureScientifiqueRecontreGrandPublic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

