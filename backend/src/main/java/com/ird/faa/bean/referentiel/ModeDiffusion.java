package com.ird.faa.bean.referentiel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mode_diffusion")
public class ModeDiffusion   implements Archivable  {

    @Id
    @SequenceGenerator(name = "mode_diffusion_seq", sequenceName = "mode_diffusion_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mode_diffusion_seq")
    private Long id;

    private String libelle;
    private String code;

    @ManyToOne
    private TypeSavoir typeSavoir;


    public ModeDiffusion()  {
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

    public TypeSavoir getTypeSavoir()  {
        return this.typeSavoir;
    }

    public void setTypeSavoir(TypeSavoir typeSavoir)  {
        this.typeSavoir = typeSavoir;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeDiffusion modeDiffusion = (ModeDiffusion) o;
        return id != null && id.equals(modeDiffusion.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

