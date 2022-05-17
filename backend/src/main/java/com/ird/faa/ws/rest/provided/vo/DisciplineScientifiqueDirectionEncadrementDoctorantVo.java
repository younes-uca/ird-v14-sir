package  com.ird.faa.ws.rest.provided.vo;


public class DisciplineScientifiqueDirectionEncadrementDoctorantVo {

    private String id ;



        private EncadrementDoctorantVo directionEncadrementDoctorantVo ;
        private DisciplineScientifiqueVo disciplineScientifiqueVo ;


    public DisciplineScientifiqueDirectionEncadrementDoctorantVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public EncadrementDoctorantVo getDirectionEncadrementDoctorantVo(){
        return this.directionEncadrementDoctorantVo;
        }

        public void setDirectionEncadrementDoctorantVo(EncadrementDoctorantVo directionEncadrementDoctorantVo){
        this.directionEncadrementDoctorantVo = directionEncadrementDoctorantVo;
        }
        public DisciplineScientifiqueVo getDisciplineScientifiqueVo(){
        return this.disciplineScientifiqueVo;
        }

        public void setDisciplineScientifiqueVo(DisciplineScientifiqueVo disciplineScientifiqueVo){
        this.disciplineScientifiqueVo = disciplineScientifiqueVo;
        }


            }
