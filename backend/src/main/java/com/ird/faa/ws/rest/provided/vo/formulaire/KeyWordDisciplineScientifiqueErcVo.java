package main.java.com.ird.faa.ws.rest.provided.vo.formulaire;

public class KeyWordDisciplineScientifiqueErcVo {

    private String id ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;


            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private KeyWordVo keyWordVo ;
        private DisciplineScientifiqueErcVo disciplineScientifiqueErcVo ;


    public KeyWordDisciplineScientifiqueErcVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public Boolean getArchive(){
        return this.archive;
        }

        public void setArchive(Boolean archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }


            public String getDateArchivageMax(){
            return this.dateArchivageMax;
            }

            public String getDateArchivageMin(){
            return this.dateArchivageMin;
            }

            public void setDateArchivageMax(String dateArchivageMax){
            this.dateArchivageMax = dateArchivageMax;
            }

            public void setDateArchivageMin(String dateArchivageMin){
            this.dateArchivageMin = dateArchivageMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }


        public KeyWordVo getKeyWordVo(){
        return this.keyWordVo;
        }

        public void setKeyWordVo(KeyWordVo keyWordVo){
        this.keyWordVo = keyWordVo;
        }
        public DisciplineScientifiqueErcVo getDisciplineScientifiqueErcVo(){
        return this.disciplineScientifiqueErcVo;
        }

        public void setDisciplineScientifiqueErcVo(DisciplineScientifiqueErcVo disciplineScientifiqueErcVo){
        this.disciplineScientifiqueErcVo = disciplineScientifiqueErcVo;
        }


            }
