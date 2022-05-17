package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "type_publique_culture_scientifique")
public class TypePubliqueCultureScientifique    implements Archivable {

@Id
    @SequenceGenerator(name="type_publique_culture_scientifique_seq",sequenceName="type_publique_culture_scientifique_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_publique_culture_scientifique_seq")
private Long id;

            @Column(length = 500)
            private String code;
            @Column(length = 500)
            private String libelle;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;



public TypePubliqueCultureScientifique(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getCode(){
            return this.code;
            }
            public void setCode(String code){
            this.code = code;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
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
        TypePubliqueCultureScientifique typePubliqueCultureScientifique = (TypePubliqueCultureScientifique) o;
        return id != null && id.equals(typePubliqueCultureScientifique.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

