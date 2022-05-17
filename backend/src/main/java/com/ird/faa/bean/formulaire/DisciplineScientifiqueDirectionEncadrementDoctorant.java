package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discipline_scientifique_direction_encadrement_doctorant")
public class DisciplineScientifiqueDirectionEncadrementDoctorant {

    @Id
    @SequenceGenerator(name = "discipline_scientifique_direction_encadrement_doctorant_seq", sequenceName = "discipline_scientifique_direction_encadrement_doctorant_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_scientifique_direction_encadrement_doctorant_seq")
    private Long id;


    @ManyToOne
    private EncadrementDoctorant encadrementDoctorant;
    @ManyToOne
    private DisciplineScientifique disciplineScientifique;


    public DisciplineScientifiqueDirectionEncadrementDoctorant() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EncadrementDoctorant getDirectionEncadrementDoctorant() {
        return this.encadrementDoctorant;
    }

    public void setDirectionEncadrementDoctorant(EncadrementDoctorant encadrementDoctorant) {
        this.encadrementDoctorant = encadrementDoctorant;
    }

    public DisciplineScientifique getDisciplineScientifique() {
        return this.disciplineScientifique;
    }

    public void setDisciplineScientifique(DisciplineScientifique disciplineScientifique) {
        this.disciplineScientifique = disciplineScientifique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineScientifiqueDirectionEncadrementDoctorant disciplineScientifiqueDirectionEncadrementDoctorant = (DisciplineScientifiqueDirectionEncadrementDoctorant) o;
        return id != null && id.equals(disciplineScientifiqueDirectionEncadrementDoctorant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

