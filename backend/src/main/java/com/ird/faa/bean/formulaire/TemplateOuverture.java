package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "template_ouverture")
public class TemplateOuverture {

    @Id
    @SequenceGenerator(name = "template_ouverture_seq", sequenceName = "template_ouverture_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_ouverture_seq")
    private Long id;

    private String code;
    private String objet;

    @Column(columnDefinition = "TEXT")
    private String message;


    public TemplateOuverture() {
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
        TemplateOuverture templateOuverture = (TemplateOuverture) o;
        return id != null && id.equals(templateOuverture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

