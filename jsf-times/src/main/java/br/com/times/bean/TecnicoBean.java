package br.com.times.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.times.dao.TecnicoDAO;
import br.com.times.dao.TimeDAO;
import br.com.times.modelo.Tecnico;
import br.com.times.modelo.Time;
import br.com.times.transaction.Transactional;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TecnicoBean implements Serializable {
	
	
	private Tecnico tecnico = new Tecnico();
	
	private Long timeId;
	
	@Inject
	private TecnicoDAO tecnicoDAO;
	
	@Inject
	private TimeDAO timeDAO;
	

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	

	public Long getTimeId() {
		return timeId;
	}

	public void setTimeId(Long timeId) {
		this.timeId = timeId;
	}

	@Transactional
	public String gravar() {
		
		if(this.timeId != null) {
		
		this.tecnico.setTime(this.timeDAO.findById(this.timeId));

		}
		
		if(this.getTecnico().getId() == null) {
			this.tecnicoDAO.save(this.tecnico);
		} else {
			this.tecnicoDAO.update(this.tecnico);
		}

		return "tecnico?faces-redirect=true";

	}
	
	@Transactional
	public void remover(Tecnico tecnico) {
		this.tecnicoDAO.remove(tecnico);
	}
	
	public List<Time> getTimes() {
		return this.timeDAO.findAll();
	}
	
	public List<Tecnico> getTecnicos() {
		return this.tecnicoDAO.findAll();
	}
	
	public void carregar(Tecnico tecnico) {
		this.tecnico = this.tecnicoDAO.findById(tecnico.getId());
	}

}
