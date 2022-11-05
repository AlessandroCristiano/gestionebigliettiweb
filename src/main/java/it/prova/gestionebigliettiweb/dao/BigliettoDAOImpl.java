package it.prova.gestionebigliettiweb.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class BigliettoDAOImpl implements BigliettoDAO{
	private EntityManager entityManager;

	@Override
	public List<Biglietto> list() throws Exception {
		return entityManager.createQuery("from Biglietto", Biglietto.class).getResultList();
	}

	@Override
	public Biglietto findOne(Long id) throws Exception {
		return entityManager.find(Biglietto.class, id);
	}

	@Override
	public void update(Biglietto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Biglietto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);		
	}

	@Override
	public void delete(Biglietto input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public List<Biglietto> findByExample(Biglietto input) throws Exception {
		
		String queryString="from Biglietto where 1=1";
		SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
		dataFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		if(!(input.getProvenienza().isEmpty()))
			queryString+=" and provenienza LIKE '" + input.getProvenienza() + "%'";
		if(!(input.getDestinazione().isEmpty()))
			queryString+=" and destinazione LIKE '" + input.getDestinazione() + "%'";
		if(input.getData()!=null)
			queryString+=" and DATE(data)='" + dataFormat.format(new java.sql.Date(input.getData().getTime())) + "'";
		if(input.getPrezzo()!=null)
			queryString+=" and prezzo LIKE '" + input.getPrezzo() + "%'";
		
		return entityManager.createQuery(queryString, Biglietto.class).getResultList();
	}
}