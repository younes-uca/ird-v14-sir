package com.ird.faa.bean.referentiel;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "instrument_ird")
public class InstrumentIrd   implements Archivable  {

    @Id
    @SequenceGenerator(name = "instrument_ird_seq", sequenceName = "instrument_ird_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instrument_ird_seq")
    private Long id;

    private String code;
    private String libelle;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage;

    @ManyToOne
    private TypeInstrumentIrd typeInstrumentIrd;


    public InstrumentIrd()  {
        super();
    }


    public Long getId()  {
        return this.id;
    }

    public void setId(Long id)  {
        this.id = id;
    }

    public String getCode()  {
        return this.code;
    }

    public void setCode(String code)  {
        this.code = code;
    }

    public String getLibelle()  {
        return this.libelle;
    }

    public void setLibelle(String libelle)  {
        this.libelle = libelle;
    }

    public TypeInstrumentIrd getTypeInstrumentIrd()  {
        return this.typeInstrumentIrd;
    }

    public void setTypeInstrumentIrd(TypeInstrumentIrd typeInstrumentIrd)  {
        this.typeInstrumentIrd = typeInstrumentIrd;
    }

    public Boolean getArchive()  {
        return this.archive;
    }

    public void setArchive(Boolean archive)  {
        this.archive = archive;
    }

    public Date getDateArchivage()  {
        return this.dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage)  {
        this.dateArchivage = dateArchivage;
    }

    @Override
    public boolean equals(Object o)  {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentIrd instrumentIrd = (InstrumentIrd) o;
        return id != null && id.equals(instrumentIrd.id);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(id);
    }

}

