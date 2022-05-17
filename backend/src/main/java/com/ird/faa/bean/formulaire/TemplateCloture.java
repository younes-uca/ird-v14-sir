package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "template_cloture")
public class TemplateCloture {

    @Id
    @SequenceGenerator(name = "template_cloture_seq", sequenceName = "template_cloture_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_cloture_seq")
    private Long id;

    private String code;
    private String objet;

    @Column(columnDefinition = "TEXT")
    private String message;


    public TemplateCloture() {
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
        TemplateCloture templateCloture = (TemplateCloture) o;
        return id != null && id.equals(templateCloture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

