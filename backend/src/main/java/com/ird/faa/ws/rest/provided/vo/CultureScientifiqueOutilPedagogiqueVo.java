package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class CultureScientifiqueOutilPedagogiqueVo {

    private String id ;
    private String role ;
    private String nomOutil ;
    private String sortieAnnee ;
    private String sortieMois ;
    private String lienWeb ;


            private String sortieAnneeMax ;
            private String sortieAnneeMin ;
            private String sortieMoisMax ;
            private String sortieMoisMin ;

        private CampagneVo campagneVo ;
        private ChercheurVo chercheurVo ;
        private EtatEtapeCampagneVo etatEtapeCampagneVo ;

    private List<PublicCibleCultureScientifiqueOutilPedagogiqueVo> publicCibleCultureScientifiqueOutilPedagogiquesVo ;
    private List<TypeOutilCultureScientifiqueOutilPedagogiqueVo> typeOutilCultureScientifiqueOutilPedagogiquesVo ;
    private List<PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo> paysTypeOutilCultureScientifiqueOutilPedagogiquesVo ;
    private List<EtablissementCultureScientifiqueOutilPedagogiqueVo> etablissementCultureScientifiqueOutilPedagogiquesVo ;

    public CultureScientifiqueOutilPedagogiqueVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getRole(){
        return this.role;
        }

        public void setRole(String role){
        this.role = role;
        }
        public String getNomOutil(){
        return this.nomOutil;
        }

        public void setNomOutil(String nomOutil){
        this.nomOutil = nomOutil;
        }
        public String getSortieAnnee(){
        return this.sortieAnnee;
        }

        public void setSortieAnnee(String sortieAnnee){
        this.sortieAnnee = sortieAnnee;
        }
        public String getSortieMois(){
        return this.sortieMois;
        }

        public void setSortieMois(String sortieMois){
        this.sortieMois = sortieMois;
        }
        public String getLienWeb(){
        return this.lienWeb;
        }

        public void setLienWeb(String lienWeb){
        this.lienWeb = lienWeb;
        }


            public String getSortieAnneeMax(){
            return this.sortieAnneeMax;
            }

            public String getSortieAnneeMin(){
            return this.sortieAnneeMin;
            }

            public void setSortieAnneeMax(String sortieAnneeMax){
            this.sortieAnneeMax = sortieAnneeMax;
            }

            public void setSortieAnneeMin(String sortieAnneeMin){
            this.sortieAnneeMin = sortieAnneeMin;
            }

            public String getSortieMoisMax(){
            return this.sortieMoisMax;
            }

            public String getSortieMoisMin(){
            return this.sortieMoisMin;
            }

            public void setSortieMoisMax(String sortieMoisMax){
            this.sortieMoisMax = sortieMoisMax;
            }

            public void setSortieMoisMin(String sortieMoisMin){
            this.sortieMoisMin = sortieMoisMin;
            }


        public CampagneVo getCampagneVo(){
        return this.campagneVo;
        }

        public void setCampagneVo(CampagneVo campagneVo){
        this.campagneVo = campagneVo;
        }
        public ChercheurVo getChercheurVo(){
        return this.chercheurVo;
        }

        public void setChercheurVo(ChercheurVo chercheurVo){
        this.chercheurVo = chercheurVo;
        }
        public EtatEtapeCampagneVo getEtatEtapeCampagneVo(){
        return this.etatEtapeCampagneVo;
        }

        public void setEtatEtapeCampagneVo(EtatEtapeCampagneVo etatEtapeCampagneVo){
        this.etatEtapeCampagneVo = etatEtapeCampagneVo;
        }


        public List<PublicCibleCultureScientifiqueOutilPedagogiqueVo> getPublicCibleCultureScientifiqueOutilPedagogiquesVo(){
        return this.publicCibleCultureScientifiqueOutilPedagogiquesVo;
        }

        public void setPublicCibleCultureScientifiqueOutilPedagogiquesVo(List<PublicCibleCultureScientifiqueOutilPedagogiqueVo> publicCibleCultureScientifiqueOutilPedagogiquesVo){
            this.publicCibleCultureScientifiqueOutilPedagogiquesVo = publicCibleCultureScientifiqueOutilPedagogiquesVo;
            }

        public List<TypeOutilCultureScientifiqueOutilPedagogiqueVo> getTypeOutilCultureScientifiqueOutilPedagogiquesVo(){
        return this.typeOutilCultureScientifiqueOutilPedagogiquesVo;
        }

        public void setTypeOutilCultureScientifiqueOutilPedagogiquesVo(List<TypeOutilCultureScientifiqueOutilPedagogiqueVo> typeOutilCultureScientifiqueOutilPedagogiquesVo){
            this.typeOutilCultureScientifiqueOutilPedagogiquesVo = typeOutilCultureScientifiqueOutilPedagogiquesVo;
            }

        public List<PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo> getPaysTypeOutilCultureScientifiqueOutilPedagogiquesVo(){
        return this.paysTypeOutilCultureScientifiqueOutilPedagogiquesVo;
        }

        public void setPaysTypeOutilCultureScientifiqueOutilPedagogiquesVo(List<PaysTypeOutilCultureScientifiqueOutilPedagogiqueVo> paysTypeOutilCultureScientifiqueOutilPedagogiquesVo){
            this.paysTypeOutilCultureScientifiqueOutilPedagogiquesVo = paysTypeOutilCultureScientifiqueOutilPedagogiquesVo;
            }

        public List<EtablissementCultureScientifiqueOutilPedagogiqueVo> getEtablissementCultureScientifiqueOutilPedagogiquesVo(){
        return this.etablissementCultureScientifiqueOutilPedagogiquesVo;
        }

        public void setEtablissementCultureScientifiqueOutilPedagogiquesVo(List<EtablissementCultureScientifiqueOutilPedagogiqueVo> etablissementCultureScientifiqueOutilPedagogiquesVo){
            this.etablissementCultureScientifiqueOutilPedagogiquesVo = etablissementCultureScientifiqueOutilPedagogiquesVo;
            }

            }
