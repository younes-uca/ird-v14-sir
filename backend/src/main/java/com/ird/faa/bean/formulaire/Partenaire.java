package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partenaire")
public class Partenaire {
    @Id
    @SequenceGenerator(name = "partenaire_seq", sequenceName = "partenaire_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partenaire_seq")
    private Long id;
    private String idGraphQl;
    private String nomOfficel;
    private String sigleOfficel;
    private String adresse;
    @ManyToOne
    private Pays paysPartenaire;
    private String typePartenaire;

    public Partenaire() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdGraphQl() {
        return idGraphQl;
    }

    public void setIdGraphQl(String idGraphQl) {
        this.idGraphQl = idGraphQl;
    }

    public String getNomOfficel() {
        return nomOfficel;
    }

    public void setNomOfficel(String nomOfficel) {
        this.nomOfficel = nomOfficel;
    }

    public String getSigleOfficel() {
        return sigleOfficel;
    }

    public void setSigleOfficel(String sigleOfficel) {
        this.sigleOfficel = sigleOfficel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Pays getPaysPartenaire() {
        return paysPartenaire;
    }

    public void setPaysPartenaire(Pays paysPartenaire) {
        this.paysPartenaire = paysPartenaire;
    }

    public String getTypePartenaire() {
        return typePartenaire;
    }

    public void setTypePartenaire(String typePartenaire) {
        this.typePartenaire = typePartenaire;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partenaire other = (Partenaire) obj;
        return Objects.equals(id, other.id);
    }

}
