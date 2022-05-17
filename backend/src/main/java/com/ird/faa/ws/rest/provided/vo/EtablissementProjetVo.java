package  com.ird.faa.ws.rest.provided.vo;


public class EtablissementProjetVo {

    private String id ;
    private String libelle ;
    private String code ;
    private String description ;
    private String sigleOfficiel ;
    private String nomEnFrancais ;
    private String sigleEnFrancais ;
    private String anciensNom ;
    private String champIntervention ;
    private String valide ;



        private VilleVo villeVo ;
        private PaysVo paysVo ;


    public EtablissementProjetVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getSigleOfficiel(){
        return this.sigleOfficiel;
        }

        public void setSigleOfficiel(String sigleOfficiel){
        this.sigleOfficiel = sigleOfficiel;
        }
        public String getNomEnFrancais(){
        return this.nomEnFrancais;
        }

        public void setNomEnFrancais(String nomEnFrancais){
        this.nomEnFrancais = nomEnFrancais;
        }
        public String getSigleEnFrancais(){
        return this.sigleEnFrancais;
        }

        public void setSigleEnFrancais(String sigleEnFrancais){
        this.sigleEnFrancais = sigleEnFrancais;
        }
        public String getAnciensNom(){
        return this.anciensNom;
        }

        public void setAnciensNom(String anciensNom){
        this.anciensNom = anciensNom;
        }
        public String getChampIntervention(){
        return this.champIntervention;
        }

        public void setChampIntervention(String champIntervention){
        this.champIntervention = champIntervention;
        }
        public String getValide(){
        return this.valide;
        }

        public void setValide(String valide){
        this.valide = valide;
        }



        public VilleVo getVilleVo(){
        return this.villeVo;
        }

        public void setVilleVo(VilleVo villeVo){
        this.villeVo = villeVo;
        }
        public PaysVo getPaysVo(){
        return this.paysVo;
        }

        public void setPaysVo(PaysVo paysVo){
        this.paysVo = paysVo;
        }


            }
