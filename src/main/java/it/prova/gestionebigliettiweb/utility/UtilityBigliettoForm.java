package it.prova.gestionebigliettiweb.utility;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class UtilityBigliettoForm {
	
	public static Biglietto createBigliettoFromParams(String provenienzaInputParam, String destinazioneInputParam,
			String dataInputParam, String prezzoInputStringParam) {
		
		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);
		
		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateArrivoFromString(dataInputParam));

		return result;
	}
	
	public static Biglietto createBigliettoFromParamsWithId(String id, String provenienzaInputParam, String destinazioneInputParam,
				String dataInputParam, String prezzoInputStringParam) {
			
			Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);
			
			if (NumberUtils.isCreatable(id)) {
				result.setId(Long.parseLong(id));
			}
			
			if (NumberUtils.isCreatable(prezzoInputStringParam)) {
				result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
			}
			result.setData(parseDateArrivoFromString(dataInputParam));

			return result;
		
	}
	
	
	
	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(bigliettoToBeValidated.getProvenienza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getPrezzo() == null 
				|| bigliettoToBeValidated.getPrezzo() < 1
				|| bigliettoToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}
	
	public static Date parseDateArrivoFromString(String dataArrivoStringParam) {
		if (StringUtils.isBlank(dataArrivoStringParam))
			return null;
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataArrivoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
