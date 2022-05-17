package com.ird.faa.bean.formulaire;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "categorie_notification")
public class CategorieNotification {

@Id
    @SequenceGenerator(name="categorie_notification_seq",sequenceName="categorie_notification_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_notification_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            @Column(length = 500)
            private String code;



public CategorieNotification(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public String getCode(){
            return this.code;
            }
            public void setCode(String code){
            this.code = code;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieNotification categorieNotification = (CategorieNotification) o;
        return id != null && id.equals(categorieNotification.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

