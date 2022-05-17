package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "discipline_scientifique_erc_parent")
public class DisciplineScientifiqueErcParent    implements Archivable {

@Id
    @SequenceGenerator(name="discipline_scientifique_erc_parent_seq",sequenceName="discipline_scientifique_erc_parent_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="discipline_scientifique_erc_parent_seq")
private Long id;

            @Column(length = 500)
            private String libelleFr;
            @Column(length = 500)
            private String libelleEng;
            @Column(length = 500)
            private String code;
            private Long niveau ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;



public DisciplineScientifiqueErcParent(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getLibelleFr(){
            return this.libelleFr;
            }
            public void setLibelleFr(String libelleFr){
            this.libelleFr = libelleFr;
            }
            public String getLibelleEng(){
            return this.libelleEng;
            }
            public void setLibelleEng(String libelleEng){
            this.libelleEng = libelleEng;
            }
            public String getCode(){
            return this.code;
            }
            public void setCode(String code){
            this.code = code;
            }
            public Long getNiveau(){
            return this.niveau;
            }
            public void setNiveau(Long niveau){
            this.niveau = niveau;
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
        DisciplineScientifiqueErcParent disciplineScientifiqueErcParent = (DisciplineScientifiqueErcParent) o;
        return id != null && id.equals(disciplineScientifiqueErcParent.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

