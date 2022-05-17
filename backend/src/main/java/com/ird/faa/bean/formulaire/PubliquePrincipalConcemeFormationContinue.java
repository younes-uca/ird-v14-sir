package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "publique_principal_conceme_formation_continue")
public class PubliquePrincipalConcemeFormationContinue {

    @Id
    @SequenceGenerator(name = "publique_principal_conceme_formation_continue_seq", sequenceName = "publique_principal_conceme_formation_continue_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publique_principal_conceme_formation_continue_seq")
    private Long id;


    @ManyToOne
    private PubliquePrincipal publiquePrincipal;
    @ManyToOne
    private FormationContinue formationContinue;


    public PubliquePrincipalConcemeFormationContinue() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PubliquePrincipal getPubliquePrincipal() {
        return this.publiquePrincipal;
    }

    public void setPubliquePrincipal(PubliquePrincipal publiquePrincipal) {
        this.publiquePrincipal = publiquePrincipal;
    }

    public FormationContinue getFormationContinue() {
        return this.formationContinue;
    }

    public void setFormationContinue(FormationContinue formationContinue) {
        this.formationContinue = formationContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubliquePrincipalConcemeFormationContinue publiquePrincipalConcemeFormationContinue = (PubliquePrincipalConcemeFormationContinue) o;
        return id != null && id.equals(publiquePrincipalConcemeFormationContinue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

