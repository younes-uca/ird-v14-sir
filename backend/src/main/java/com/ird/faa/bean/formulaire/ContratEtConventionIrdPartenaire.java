package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contrat_et_convention_ird_partenaire")
public class ContratEtConventionIrdPartenaire {
    @Id
    @SequenceGenerator(name = "contrat_et_convention_ird_partenaire_seq", sequenceName = "contrat_et_convention_ird_partenaire_seq", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrat_et_convention_ird_partenaire_seq")
    private Long id;
    @ManyToOne
    private ContratEtConventionIrd contratEtConventionIrd;
    @ManyToOne
    private Partenaire partenaire;

    public ContratEtConventionIrdPartenaire() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContratEtConventionIrd getContratEtConventionIrd() {
        return contratEtConventionIrd;
    }

    public void setContratEtConventionIrd(ContratEtConventionIrd contratEtConventionIrd) {
        this.contratEtConventionIrd = contratEtConventionIrd;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
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
        ContratEtConventionIrdPartenaire other = (ContratEtConventionIrdPartenaire) obj;
        return Objects.equals(id, other.id);
    }

}
