package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.formulaire.EncadrementEtudiant;
import com.ird.faa.ws.rest.provided.vo.EncadrementEtudiantVo;

@Component
public class EncadrementEtudiantConverter extends AbstractConverter<EncadrementEtudiant,EncadrementEtudiantVo>{

        @Autowired
        private EtatEtapeCampagneConverter etatEtapeCampagneConverter ;
        @Autowired
        private ResponsabiliteEncadrementEtudiantConverter responsabiliteEncadrementEtudiantConverter ;
        @Autowired
        private EncadrementConverter encadrementConverter ;
        @Autowired
        private EncadrementEtudiantEnjeuxIrdConverter encadrementEtudiantEnjeuxIrdConverter ;
        
        
        @Autowired
        private EtablissementEncadrementEtudiantConverter etablissementEncadrementEtudiantConverter ;
        
        @Autowired
        private PaysEncadrementEtudiantConverter paysEncadrementEtudiantConverter ;
       
        
        @Autowired
        private NiveauFormationPostBacConverter niveauFormationPostBacConverter ;
        @Autowired
        private EtablissementConverter etablissementConverter ;
        @Autowired
        private EncadrementEtudiantDisciplineScientifiqueConverter encadrementEtudiantDisciplineScientifiqueConverter ;
        @Autowired
        private PaysConverter paysConverter ;
        @Autowired
        private EtudiantConverter etudiantConverter ;
    private Boolean niveauFormationPostBac;
    private Boolean responsabiliteEncadrementEtudiant;
    private Boolean etablissement;
    private Boolean pays;
    private Boolean encadrement;
    private Boolean etatEtapeCampagne;
        private Boolean encadrementEtudiantEnjeuxIrds;
        private Boolean etablissementEncadrementEtudiants;
        private Boolean paysEncadrementEtudiants;
        
 
        
        private Boolean encadrementEtudiantDisciplineScientifiques;
        private Boolean etudiant;

public  EncadrementEtudiantConverter(){
init(true);
}

@Override
public EncadrementEtudiant toItem(EncadrementEtudiantVo vo) {
if (vo == null) {
return null;
} else {
EncadrementEtudiant item = new EncadrementEtudiant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getSujetEtude()))
        item.setSujetEtude(vo.getSujetEtude());
        if(StringUtil.isNotEmpty(vo.isCursus()))
        item.setCursus(vo.isCursus());
    if(vo.getNiveauFormationPostBacVo()!=null && this.niveauFormationPostBac)
        item.setNiveauFormationPostBac(niveauFormationPostBacConverter.toItem(vo.getNiveauFormationPostBacVo())) ;
    if(vo.getResponsabiliteEncadrementEtudiantVo()!=null && this.responsabiliteEncadrementEtudiant)
        item.setResponsabiliteEncadrementEtudiant(responsabiliteEncadrementEtudiantConverter.toItem(vo.getResponsabiliteEncadrementEtudiantVo())) ;
    if(vo.getEtablissementVo()!=null && this.etablissement)
        item.setEtablissement(etablissementConverter.toItem(vo.getEtablissementVo())) ;
    if(vo.getPaysVo()!=null && this.pays)
        item.setPays(paysConverter.toItem(vo.getPaysVo())) ;
    
    
    if(vo.getEtudiantVo()!=null && this.etudiant)
        item.setEtudiant(etudiantConverter.toItem(vo.getEtudiantVo())) ;
    if(vo.getEncadrementVo()!=null && this.encadrement)
        item.setEncadrement(encadrementConverter.toItem(vo.getEncadrementVo())) ;
    if(vo.getEtatEtapeCampagneVo()!=null && this.etatEtapeCampagne)
        item.setEtatEtapeCampagne(etatEtapeCampagneConverter.toItem(vo.getEtatEtapeCampagneVo())) ;

    if(ListUtil.isNotEmpty(vo.getEncadrementEtudiantEnjeuxIrdsVo()) && this.encadrementEtudiantEnjeuxIrds)
        item.setEncadrementEtudiantEnjeuxIrds(encadrementEtudiantEnjeuxIrdConverter.toItem(vo.getEncadrementEtudiantEnjeuxIrdsVo()));
   
    
    if (ListUtil.isNotEmpty(vo.getEtablissementEncadrementEtudiantsVo()) && this.etablissementEncadrementEtudiants)
		item.setEtablissementEncadrementEtudiants(
				etablissementEncadrementEtudiantConverter.toItem(vo.getEtablissementEncadrementEtudiantsVo()));

	if (ListUtil.isNotEmpty(vo.getPaysEncadrementEtudiantsVo()) && this.paysEncadrementEtudiants)
		item.setPaysEncadrementEtudiants(
				paysEncadrementEtudiantConverter.toItem(vo.getPaysEncadrementEtudiantsVo()));
   
    
    if(ListUtil.isNotEmpty(vo.getEncadrementEtudiantDisciplineScientifiquesVo()) && this.encadrementEtudiantDisciplineScientifiques)
        item.setEncadrementEtudiantDisciplineScientifiques(encadrementEtudiantDisciplineScientifiqueConverter.toItem(vo.getEncadrementEtudiantDisciplineScientifiquesVo()));

return item;
}
}

@Override
public EncadrementEtudiantVo toVo(EncadrementEtudiant item) {
if (item == null) {
return null;
} else {
EncadrementEtudiantVo vo = new EncadrementEtudiantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getSujetEtude()))
        vo.setSujetEtude(item.getSujetEtude());

        if(StringUtil.isNotEmpty(item.isCursus()))
        vo.setCursus(item.isCursus());

    if(item.getNiveauFormationPostBac()!=null && this.niveauFormationPostBac) {
        vo.setNiveauFormationPostBacVo(niveauFormationPostBacConverter.toVo(item.getNiveauFormationPostBac())) ;
    }
    if(item.getResponsabiliteEncadrementEtudiant()!=null && this.responsabiliteEncadrementEtudiant) {
        vo.setResponsabiliteEncadrementEtudiantVo(responsabiliteEncadrementEtudiantConverter.toVo(item.getResponsabiliteEncadrementEtudiant())) ;
    }
    if(item.getEtablissement()!=null && this.etablissement) {
        vo.setEtablissementVo(etablissementConverter.toVo(item.getEtablissement())) ;
    }
    if(item.getPays()!=null && this.pays) {
        vo.setPaysVo(paysConverter.toVo(item.getPays())) ;
    }
    
    
    if(item.getEtudiant()!=null && this.etudiant) {
        vo.setEtudiantVo(etudiantConverter.toVo(item.getEtudiant())) ;
    }
    if(item.getEncadrement()!=null && this.encadrement) {
        vo.setEncadrementVo(encadrementConverter.toVo(item.getEncadrement())) ;
    }
    if(item.getEtatEtapeCampagne()!=null && this.etatEtapeCampagne) {
        vo.setEtatEtapeCampagneVo(etatEtapeCampagneConverter.toVo(item.getEtatEtapeCampagne())) ;
    }
        if(ListUtil.isNotEmpty(item.getEncadrementEtudiantEnjeuxIrds()) && this.encadrementEtudiantEnjeuxIrds){
        encadrementEtudiantEnjeuxIrdConverter.init(true);
        encadrementEtudiantEnjeuxIrdConverter.setEncadrementEtudiant(false);
        vo.setEncadrementEtudiantEnjeuxIrdsVo(encadrementEtudiantEnjeuxIrdConverter.toVo(item.getEncadrementEtudiantEnjeuxIrds()));
        encadrementEtudiantEnjeuxIrdConverter.setEncadrementEtudiant(true);
        }
        
        if (ListUtil.isNotEmpty(item.getEtablissementEncadrementEtudiants()) && this.etablissementEncadrementEtudiants) {
			etablissementEncadrementEtudiantConverter.init(true);
			etablissementEncadrementEtudiantConverter.setEncadrementEtudiant(false);
			vo.setEtablissementEncadrementEtudiantsVo(
					etablissementEncadrementEtudiantConverter.toVo(item.getEtablissementEncadrementEtudiants()));
			etablissementEncadrementEtudiantConverter.setEncadrementEtudiant(true);
		}

		if (ListUtil.isNotEmpty(item.getPaysEncadrementEtudiants()) && this.paysEncadrementEtudiants) {
			paysEncadrementEtudiantConverter.init(true);
			paysEncadrementEtudiantConverter.setEncadrementEtudiant(false);
			vo.setPaysEncadrementEtudiantsVo(
					paysEncadrementEtudiantConverter.toVo(item.getPaysEncadrementEtudiants()));
			paysEncadrementEtudiantConverter.setEncadrementEtudiant(true);
		}
		
        if(ListUtil.isNotEmpty(item.getEncadrementEtudiantDisciplineScientifiques()) && this.encadrementEtudiantDisciplineScientifiques){
        encadrementEtudiantDisciplineScientifiqueConverter.init(true);
        encadrementEtudiantDisciplineScientifiqueConverter.setEncadrementEtudiant(false);
        vo.setEncadrementEtudiantDisciplineScientifiquesVo(encadrementEtudiantDisciplineScientifiqueConverter.toVo(item.getEncadrementEtudiantDisciplineScientifiques()));
        encadrementEtudiantDisciplineScientifiqueConverter.setEncadrementEtudiant(true);
        }

return vo;
}
}

public void init(Boolean value) {
    niveauFormationPostBac = value;
    responsabiliteEncadrementEtudiant = value;
    etablissement = value;
    pays = value;
    encadrement = value;
    etudiant = value;
    etatEtapeCampagne = value;
        encadrementEtudiantEnjeuxIrds = value;
        
        etablissementEncadrementEtudiants=value;
        paysEncadrementEtudiants=value;
        encadrementEtudiantDisciplineScientifiques = value;
}


        public EtatEtapeCampagneConverter getEtatEtapeCampagneConverter(){
        return this.etatEtapeCampagneConverter;
        }
        public void setEtatEtapeCampagneConverter(EtatEtapeCampagneConverter etatEtapeCampagneConverter ){
        this.etatEtapeCampagneConverter = etatEtapeCampagneConverter;
        }
        public ResponsabiliteEncadrementEtudiantConverter getResponsabiliteEncadrementEtudiantConverter(){
        return this.responsabiliteEncadrementEtudiantConverter;
        }
        public void setResponsabiliteEncadrementEtudiantConverter(ResponsabiliteEncadrementEtudiantConverter responsabiliteEncadrementEtudiantConverter ){
        this.responsabiliteEncadrementEtudiantConverter = responsabiliteEncadrementEtudiantConverter;
        }
        public EncadrementConverter getEncadrementConverter(){
        return this.encadrementConverter;
        }
        public void setEncadrementConverter(EncadrementConverter encadrementConverter ){
        this.encadrementConverter = encadrementConverter;
        }
        public EncadrementEtudiantEnjeuxIrdConverter getEncadrementEtudiantEnjeuxIrdConverter(){
        return this.encadrementEtudiantEnjeuxIrdConverter;
        }
        public void setEncadrementEtudiantEnjeuxIrdConverter(EncadrementEtudiantEnjeuxIrdConverter encadrementEtudiantEnjeuxIrdConverter ){
        this.encadrementEtudiantEnjeuxIrdConverter = encadrementEtudiantEnjeuxIrdConverter;
        }
        
        public EtablissementEncadrementEtudiantConverter getEtablissementEncadrementEtudiantConverter() {
    		return this.etablissementEncadrementEtudiantConverter;
    	}
    	public void setEtablissementEncadrementEtudiantConverter(
    			EtablissementEncadrementEtudiantConverter etablissementEncadrementEtudiantConverter) {
    		this.etablissementEncadrementEtudiantConverter = etablissementEncadrementEtudiantConverter;
    	}
    	
    	public PaysEncadrementEtudiantConverter getPaysEncadrementEtudiantConverter() {
    		return this.paysEncadrementEtudiantConverter;
    	}
    	
    	public void setPaysEncadrementEtudiantConverter(
    			PaysEncadrementEtudiantConverter paysEncadrementEtudiantConverter) {
    		this.paysEncadrementEtudiantConverter = paysEncadrementEtudiantConverter;
    	}
        public NiveauFormationPostBacConverter getNiveauFormationPostBacConverter(){
        return this.niveauFormationPostBacConverter;
        }
        public void setNiveauFormationPostBacConverter(NiveauFormationPostBacConverter niveauFormationPostBacConverter ){
        this.niveauFormationPostBacConverter = niveauFormationPostBacConverter;
        }
        public EtablissementConverter getEtablissementConverter(){
        return this.etablissementConverter;
        }
        public void setEtablissementConverter(EtablissementConverter etablissementConverter ){
        this.etablissementConverter = etablissementConverter;
        }
        public EncadrementEtudiantDisciplineScientifiqueConverter getEncadrementEtudiantDisciplineScientifiqueConverter(){
        return this.encadrementEtudiantDisciplineScientifiqueConverter;
        }
        public void setEncadrementEtudiantDisciplineScientifiqueConverter(EncadrementEtudiantDisciplineScientifiqueConverter encadrementEtudiantDisciplineScientifiqueConverter ){
        this.encadrementEtudiantDisciplineScientifiqueConverter = encadrementEtudiantDisciplineScientifiqueConverter;
        }
        public PaysConverter getPaysConverter(){
        return this.paysConverter;
        }
        public void setPaysConverter(PaysConverter paysConverter ){
        this.paysConverter = paysConverter;
        }

    public boolean  isNiveauFormationPostBac(){
    return this.niveauFormationPostBac;
    }
    public void  setNiveauFormationPostBac(boolean niveauFormationPostBac){
    this.niveauFormationPostBac = niveauFormationPostBac;
    }
    public boolean  isResponsabiliteEncadrementEtudiant(){
    return this.responsabiliteEncadrementEtudiant;
    }
    public void  setResponsabiliteEncadrementEtudiant(boolean responsabiliteEncadrementEtudiant){
    this.responsabiliteEncadrementEtudiant = responsabiliteEncadrementEtudiant;
    }
    public boolean  isEtablissement(){
    return this.etablissement;
    }
    public void  setEtablissement(boolean etablissement){
    this.etablissement = etablissement;
    }
    public boolean  isPays(){
    return this.pays;
    }
    public void  setPays(boolean pays){
    this.pays = pays;
    }
    public boolean  isEncadrement(){
    return this.encadrement;
    }
    public void  setEncadrement(boolean encadrement){
    this.encadrement = encadrement;
    }
    public boolean  isEtatEtapeCampagne(){
    return this.etatEtapeCampagne;
    }
    public void  setEtatEtapeCampagne(boolean etatEtapeCampagne){
    this.etatEtapeCampagne = etatEtapeCampagne;
    }









        public Boolean  isEncadrementEtudiantEnjeuxIrds(){
        return this.encadrementEtudiantEnjeuxIrds ;
        }
        public void  setEncadrementEtudiantEnjeuxIrds(Boolean encadrementEtudiantEnjeuxIrds ){
        this.encadrementEtudiantEnjeuxIrds  = encadrementEtudiantEnjeuxIrds ;
        }


        
        
        
        public Boolean  isEtablissementEncadrementEtudiants(){
            return this.etablissementEncadrementEtudiants ;
            }
            public void  setEtablissementEncadrementEtudiants(Boolean etablissementEncadrementEtudiants ){
            this.etablissementEncadrementEtudiants  = etablissementEncadrementEtudiants ;
            }
            
            
            public Boolean  isPaysEncadrementEtudiants(){
                return this.paysEncadrementEtudiants ;
                }
                public void  setPaysEncadrementEtudiants(Boolean paysEncadrementEtudiants ){
                this.paysEncadrementEtudiants  = paysEncadrementEtudiants ;
                }

        public Boolean  isEncadrementEtudiantDisciplineScientifiques(){
        return this.encadrementEtudiantDisciplineScientifiques ;
        }
        public void  setEncadrementEtudiantDisciplineScientifiques(Boolean encadrementEtudiantDisciplineScientifiques ){
        this.encadrementEtudiantDisciplineScientifiques  = encadrementEtudiantDisciplineScientifiques ;
        }



        public boolean  isEtudiant(){
            return this.etudiant;
            }
            public void  setEtudiant(boolean etudiant){
            this.etudiant = etudiant;
            }








}
