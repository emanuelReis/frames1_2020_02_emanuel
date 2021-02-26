package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class campusRepository {

    private Session session;
    private Transaction transaction;

    public void salvar(campusModel campus) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        this.session.save(campus);
        this.transaction.commit();
        this.session.close();
        System.out.println("esse é o campus model");
    }

    public List<campusModel> buscarTodos() {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<campusModel> listaDeCampus = this.session.createQuery("from campusModel").list();

        this.transaction.commit();
        this.session.close();
        return listaDeCampus;
    }
}
