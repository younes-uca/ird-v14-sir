package  com.ird.faa.ws.rest.provided.vo;


public class CommunauteSavoirEvaluationRechercheUniversitaireVo {

    private String id ;



        private EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo ;
        private CommunauteSavoirVo communauteSavoirVo ;


    public CommunauteSavoirEvaluationRechercheUniversitaireVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public EvaluationRechercheUniversitaireVo getEvaluationRechercheUniversitaireVo(){
        return this.evaluationRechercheUniversitaireVo;
        }

        public void setEvaluationRechercheUniversitaireVo(EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo){
        this.evaluationRechercheUniversitaireVo = evaluationRechercheUniversitaireVo;
        }
        public CommunauteSavoirVo getCommunauteSavoirVo(){
        return this.communauteSavoirVo;
        }

        public void setCommunauteSavoirVo(CommunauteSavoirVo communauteSavoirVo){
        this.communauteSavoirVo = communauteSavoirVo;
        }


            }
