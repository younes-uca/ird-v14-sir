package com.ird.faa.mail.util;

import com.ird.faa.bean.formulaire.Campagne;
import com.ird.faa.bean.formulaire.Chercheur;

public class FormatUtils {
	
	
	
	public static String formatMessage(Campagne campagne, Chercheur chercheur, String message) {
		if(message!=null) {

			if(chercheur.getPrenom()!=null && chercheur.getNom()!=null ) {
				message = message.replace("$chercheur", chercheur.getPrenom() + " " + chercheur.getNom());
			}
			if(campagne.getLibelle()!=null) {
				message=message.replace("$campagne", campagne.getLibelle());
			}
		}
		
		return message;
	}

	public static String formatObject(Campagne campagne, Chercheur chercheur, String message) {
		if(message!=null) {
			if(chercheur.getPrenom()!=null && chercheur.getNom()!=null) {
				message = message.replace("$chercheur", chercheur.getPrenom() + " " + chercheur.getNom());
			}
			if(campagne.getLibelle()!=null) {
				message=message.replace("$campagne", campagne.getLibelle());	
			}
		}
	
		return message;
	}
	
	
	


}
