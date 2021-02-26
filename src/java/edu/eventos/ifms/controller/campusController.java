package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cidadeRepository;
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
    private cidadeRepository cidadeRepository;
    private List<SelectItem> listaDeCidades;
    private List<SelectItem> listaDeCampus;
    private List<campusModel> ListaDeCapumModel;

    public campusController() {
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
        this.cidadeRepository = new cidadeRepository();
        this.listaDeCidades = this.getCidades(1);
        this.listaDeCampus = this.listaDeCampus();
        this.ListaDeCapumModel = this.ListaDeCapumModel();
    }

    public void salvar() {
        this.campusRepository.salvar(this.campusModel);
    }

    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.estadoRepository.buscar();
        for (estadoModel estado : listaDeEstados) {
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        }
        return itens;
    }

    public void onChangeEstado() {
        this.listaDeCidades = this.getCidades(this.campusModel.getEstado().getIdEstado());
    }
    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cidadeModel> listaDeCidades = this.cidadeRepository.buscar(idEstado);
        for (cidadeModel cidade : listaDeCidades) {
            itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
        }
        return itens;
    }
    
    public campusModel buscarTodosCampus() {
        this.listaDeCampus = this.campusRepository.buscarTodos();
        return campusModel;
        
    }

    private List<SelectItem> listaDeCampus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<campusModel> ListaDeCapumModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
