package com.ird.faa.bean.formulaire;

import com.ird.faa.bean.referentiel.InstrumentIrd;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "instrument_ird_consultance_scientifique_ponctuelle")
public class InstrumentIrdConsultanceScientifiquePonctuelle {

@Id
    @SequenceGenerator(name="instrument_ird_consultance_scientifique_ponctuelle_seq",sequenceName="instrument_ird_consultance_scientifique_ponctuelle_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="instrument_ird_consultance_scientifique_ponctuelle_seq")
private Long id;

            @Column(columnDefinition = "boolean default false")
                 private Boolean existe = false;

    @ManyToOne
    private ConsultanceScientifiquePonctuelle consultanceScientifiquePonctuelle ;
    @ManyToOne
    private InstrumentIrd instrumentIrd ;


public InstrumentIrdConsultanceScientifiquePonctuelle(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public ConsultanceScientifiquePonctuelle getConsultanceScientifiquePonctuelle(){
            return this.consultanceScientifiquePonctuelle;
            }
            public void setConsultanceScientifiquePonctuelle(ConsultanceScientifiquePonctuelle consultanceScientifiquePonctuelle){
            this.consultanceScientifiquePonctuelle = consultanceScientifiquePonctuelle;
            }
            public InstrumentIrd getInstrumentIrd(){
            return this.instrumentIrd;
            }
            public void setInstrumentIrd(InstrumentIrd instrumentIrd){
            this.instrumentIrd = instrumentIrd;
            }
        public Boolean  getExiste(){
        return this.existe;
        }
        public void setExiste(Boolean existe){
        this.existe = existe;
        }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentIrdConsultanceScientifiquePonctuelle instrumentIrdConsultanceScientifiquePonctuelle = (InstrumentIrdConsultanceScientifiquePonctuelle) o;
        return id != null && id.equals(instrumentIrdConsultanceScientifiquePonctuelle.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

