package  com.ird.faa.ws.rest.provided.vo;


public class EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo {

    private String id ;



        private CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo ;
        private EtablissementVo etablissementVo ;


    public EtablissementCultureScientifiqueRecontreGrandPublicJeunePublicVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public CultureScientifiqueRecontreGrandPublicJeunePublicVo getCultureScientifiqueRecontreGrandPublicJeunePublicVo(){
        return this.cultureScientifiqueRecontreGrandPublicJeunePublicVo;
        }

        public void setCultureScientifiqueRecontreGrandPublicJeunePublicVo(CultureScientifiqueRecontreGrandPublicJeunePublicVo cultureScientifiqueRecontreGrandPublicJeunePublicVo){
        this.cultureScientifiqueRecontreGrandPublicJeunePublicVo = cultureScientifiqueRecontreGrandPublicJeunePublicVo;
        }
        public EtablissementVo getEtablissementVo(){
        return this.etablissementVo;
        }

        public void setEtablissementVo(EtablissementVo etablissementVo){
        this.etablissementVo = etablissementVo;
        }


            }
