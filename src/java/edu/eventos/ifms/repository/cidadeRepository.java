package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class cidadeRepository {
 private Session session;
 private Transaction transaction;
 public List<cidadeModel> buscar(long IdEstado){
 this.session = hibernateConector.getSessionFactory().openSession();
 this.transaction = session.beginTransaction();

 List<cidadeModel> listaDeCidades = this.session.createQuery("from cidadeModel where idEstado = "+
IdEstado).list();

 this.transaction.commit();
 this.session.close();
 return listaDeCidades;
 }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}

