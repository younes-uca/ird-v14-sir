package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "financement_encadrement_doctorant")
public class FinancementEncadrementDoctorant {

    @Id
    @SequenceGenerator(name = "financement_encadrement_doctorant_seq", sequenceName = "financement_encadrement_doctorant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financement_encadrement_doctorant_seq")
    private Long id;


    @ManyToOne
    private FinancementDoctorant financement;
    @ManyToOne
    private EncadrementDoctorant encadrementDoctorant;


    public FinancementEncadrementDoctorant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FinancementDoctorant getFinancement() {
        return this.financement;
    }

    public void setFinancement(FinancementDoctorant financement) {
        this.financement = financement;
    }

    public EncadrementDoctorant getEncadrementDoctorant() {
        return this.encadrementDoctorant;
    }

    public void setEncadrementDoctorant(EncadrementDoctorant encadrementDoctorant) {
        this.encadrementDoctorant = encadrementDoctorant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancementEncadrementDoctorant financementEncadrementDoctorant = (FinancementEncadrementDoctorant) o;
        return id != null && id.equals(financementEncadrementDoctorant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

