package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "discipline_scientifique_erc_association")
public class DisciplineScientifiqueErcAssociation    implements Archivable {

@Id
    @SequenceGenerator(name="discipline_scientifique_erc_association_seq",sequenceName="discipline_scientifique_erc_association_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="discipline_scientifique_erc_association_seq")
private Long id;

            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;

    @ManyToOne
    private DisciplineScientifiqueErc disciplineScientifiqueErc ;
    @ManyToOne
    private DisciplineScientifique disciplineScientifique ;
    @ManyToOne
    private SemanticRelationship semanticRelationship ;


public DisciplineScientifiqueErcAssociation(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public DisciplineScientifiqueErc getDisciplineScientifiqueErc(){
            return this.disciplineScientifiqueErc;
            }
            public void setDisciplineScientifiqueErc(DisciplineScientifiqueErc disciplineScientifiqueErc){
            this.disciplineScientifiqueErc = disciplineScientifiqueErc;
            }
            public DisciplineScientifique getDisciplineScientifique(){
            return this.disciplineScientifique;
            }
            public void setDisciplineScientifique(DisciplineScientifique disciplineScientifique){
            this.disciplineScientifique = disciplineScientifique;
            }
            public SemanticRelationship getSemanticRelationship(){
            return this.semanticRelationship;
            }
            public void setSemanticRelationship(SemanticRelationship semanticRelationship){
            this.semanticRelationship = semanticRelationship;
            }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineScientifiqueErcAssociation disciplineScientifiqueErcAssociation = (DisciplineScientifiqueErcAssociation) o;
        return id != null && id.equals(disciplineScientifiqueErcAssociation.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

