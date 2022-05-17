package  com.ird.faa.ws.rest.provided.vo;


public class DisciplineScientifiqueEvaluationRechercheUniversitaireVo {

    private String id ;



        private DisciplineScientifiqueVo disciplineScientifiqueVo ;
        private EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo ;


    public DisciplineScientifiqueEvaluationRechercheUniversitaireVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public DisciplineScientifiqueVo getDisciplineScientifiqueVo(){
        return this.disciplineScientifiqueVo;
        }

        public void setDisciplineScientifiqueVo(DisciplineScientifiqueVo disciplineScientifiqueVo){
        this.disciplineScientifiqueVo = disciplineScientifiqueVo;
        }
        public EvaluationRechercheUniversitaireVo getEvaluationRechercheUniversitaireVo(){
        return this.evaluationRechercheUniversitaireVo;
        }

        public void setEvaluationRechercheUniversitaireVo(EvaluationRechercheUniversitaireVo evaluationRechercheUniversitaireVo){
        this.evaluationRechercheUniversitaireVo = evaluationRechercheUniversitaireVo;
        }


            }
