package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class InstrumentIrdVo {

    private String id ;
    private String code ;
    private String libelle ;
    private String archive ;
    private String dateArchivage ;


            private String dateArchivageMax ;
            private String dateArchivageMin ;

        private TypeInstrumentIrdVo typeInstrumentIrdVo ;


    public InstrumentIrdVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getArchive(){
        return this.archive;
        }

        public void setArchive(String archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
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


        public TypeInstrumentIrdVo getTypeInstrumentIrdVo(){
        return this.typeInstrumentIrdVo;
        }

        public void setTypeInstrumentIrdVo(TypeInstrumentIrdVo typeInstrumentIrdVo){
        this.typeInstrumentIrdVo = typeInstrumentIrdVo;
        }


            }
