package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "template_relance")
public class TemplateRelance {

    @Id
    @SequenceGenerator(name = "template_relance_seq", sequenceName = "template_relance_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_relance_seq")
    private Long id;

    private String code;
    @Column(length = 500)
    private String objet;

    @Column(columnDefinition = "TEXT")
    private String message;


    public TemplateRelance() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getObjet() {
        return this.objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateRelance templateRelance = (TemplateRelance) o;
        return id != null && id.equals(templateRelance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

