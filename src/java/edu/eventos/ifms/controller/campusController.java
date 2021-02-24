package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.estadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class campusController {

    private campusModel campusModel;
    private campusRepository campusRepository;
    private estadoRepository estadoRepository;

    public campusController() {
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
    }
    
    public void salvar() {
        System.out.println("esse é o campus modelcontroller");
        this.campusRepository.salvar(this.campusModel);
    }

    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.estadoRepository.buscar();
        listaDeEstados.forEach((estado) -> {
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        });
        return itens;    
    }

    public List<SelectItem> getCidades() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        
        return itens;

    }
    
    public campusModel getCampusModel() {
		return campusModel;
	}
	
	public void setCampusModel(campusModel campusModel) {
		this.campusModel = campusModel;
	}
    public campusRepository getCampusRepository() {
		return campusRepository;
	}
	
	public void setCampusRepository(campusRepository campusRepository) {
		this.campusRepository = campusRepository;
	}

    public estadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }
        
   
}
