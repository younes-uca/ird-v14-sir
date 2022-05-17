package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pays_culture_scientifique_recontre_grand_public_jeune_public")
public class PaysCultureScientifiqueRecontreGrandPublicJeunePublic {

    @Id
    @SequenceGenerator(name = "pays_culture_scientifique_recontre_grand_public_jeune_public_seq", sequenceName = "pays_culture_scientifique_recontre_grand_public_jeune_public_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pays_culture_scientifique_recontre_grand_public_jeune_public_seq")
    private Long id;


    @ManyToOne
    private Pays pays;
    @ManyToOne
    private CultureScientifiqueRecontreGrandPublicJeunePublic cultureScientifiqueRecontreGrandPublicJeunePublic;


    public PaysCultureScientifiqueRecontreGrandPublicJeunePublic() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
        PaysCultureScientifiqueRecontreGrandPublicJeunePublic paysCultureScientifiqueRecontreGrandPublicJeunePublic = (PaysCultureScientifiqueRecontreGrandPublicJeunePublic) o;
        return id != null && id.equals(paysCultureScientifiqueRecontreGrandPublicJeunePublic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

