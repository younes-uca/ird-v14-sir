package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.Pays;
import com.ird.faa.bean.referentiel.Ville;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etablissement_projet")
public class EtablissementProjet   implements Archivable  {

    @Id
    @SequenceGenerator(name = "etablissement_projet_seq", sequenceName = "etablissement_projet_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_projet_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String sigleOfficiel;
    private String nomEnFrancais;
    private String sigleEnFrancais;
    private String anciensNom;
    private String champIntervention;
    private Boolean valide;

    @ManyToOne
    private Ville ville;
    @ManyToOne
    private Pays pays;


    public EtablissementProjet()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getLibelle()  {
        return this.libelle;
    }

    public void setLibelle(String libelle)  {
        this.libelle = libelle;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    public String getDescription()  {
        return this.description;
    }

    public void setDescription(String description)  {
        this.description = description;
    }

    public String getSigleOfficiel()  {
        return this.sigleOfficiel;
    }

    public void setSigleOfficiel(String sigleOfficiel)  {
        this.sigleOfficiel = sigleOfficiel;
    }

    public String getNomEnFrancais()  {
        return this.nomEnFrancais;
    }

    public void setNomEnFrancais(String nomEnFrancais)  {
        this.nomEnFrancais = nomEnFrancais;
    }

    public String getSigleEnFrancais()  {
        return this.sigleEnFrancais;
    }

    public void setSigleEnFrancais(String sigleEnFrancais)  {
        this.sigleEnFrancais = sigleEnFrancais;
    }

    public String getAnciensNom()  {
        return this.anciensNom;
    }

    public void setAnciensNom(String anciensNom)  {
        this.anciensNom = anciensNom;
    }

    public Ville getVille()  {
        return this.ville;
    }

    public void setVille(Ville ville)  {
        this.ville = ville;
    }

    public Pays getPays()  {
        return this.pays;
    }

    public void setPays(Pays pays)  {
        this.pays = pays;
    }

    public String getChampIntervention()  {
        return this.champIntervention;
    }

    public void setChampIntervention(String champIntervention)  {
        this.champIntervention = champIntervention;
    }

    public Boolean getValide()  {
        return this.valide;
    }

    public void setValide(Boolean valide)  {
        this.valide = valide;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementProjet etablissementProjet = (EtablissementProjet) o;
        return id != null && id.equals(etablissementProjet.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

