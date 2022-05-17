package com.ird.faa.bean.formulaire;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.faa.bean.Archivable;
import com.ird.faa.bean.referentiel.KeyWord;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "key_word_discipline_scientifique_erc")
public class KeyWordDisciplineScientifiqueErc implements Archivable {

@Id
    @SequenceGenerator(name="key_word_discipline_scientifique_erc_seq",sequenceName="key_word_discipline_scientifique_erc_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="key_word_discipline_scientifique_erc_seq")
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
    private KeyWord keyWord ;
    @ManyToOne
    private DisciplineScientifiqueErc disciplineScientifiqueErc ;


public KeyWordDisciplineScientifiqueErc(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public KeyWord getKeyWord(){
            return this.keyWord;
            }
            public void setKeyWord(KeyWord keyWord){
            this.keyWord = keyWord;
            }
            public DisciplineScientifiqueErc getDisciplineScientifiqueErc(){
            return this.disciplineScientifiqueErc;
            }
            public void setDisciplineScientifiqueErc(DisciplineScientifiqueErc disciplineScientifiqueErc){
            this.disciplineScientifiqueErc = disciplineScientifiqueErc;
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
        KeyWordDisciplineScientifiqueErc keyWordDisciplineScientifiqueErc = (KeyWordDisciplineScientifiqueErc) o;
        return id != null && id.equals(keyWordDisciplineScientifiqueErc.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

