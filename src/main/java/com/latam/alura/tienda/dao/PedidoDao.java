package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.modelo.Pedido;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Pedido pedido){
        this.em.persist(pedido);
    }

    public void actualizar(Pedido pedido) {
        this.em.merge(pedido);
    }

    public void remover(Pedido pedido) {
        pedido=this.em.merge(pedido);
        this.em.remove(pedido);
    }
    public Pedido consultaPorId(Long id){
        return em.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos(){
        String jpql = "SELECT P FROM Pedido AS P";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM (p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
}
