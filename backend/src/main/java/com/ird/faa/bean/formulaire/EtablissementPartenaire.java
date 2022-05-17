package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "etablissement_partenaire")
public class EtablissementPartenaire   implements Archivable {

    @Id
    @SequenceGenerator(name = "etablissement_partenaire_seq", sequenceName = "etablissement_partenaire_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etablissement_partenaire_seq")
    private Long id;

    private String libelle;
    private String code;

    @Column(columnDefinition = "TEXT", length = 10485760)
    private String description;


    public EtablissementPartenaire()  {
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

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtablissementPartenaire etablissementPartenaire = (EtablissementPartenaire) o;
        return id != null && id.equals(etablissementPartenaire.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

