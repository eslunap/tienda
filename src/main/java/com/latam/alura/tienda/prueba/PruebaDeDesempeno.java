package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;

public class PruebaDeDesempeno {
    public static void main(String[] args) throws FileNotFoundException {
        LoadRecords.cargarRegistros();

        EntityManager em = JPAUtils.getEntityManager();

        Pedido pedido = em.find(Pedido.class, 3L);

        //System.out.println(pedido.getFecha());
        //System.out.println(pedido.getItems().size());
        System.out.println(pedido.getCliente().getNombre());
    }
}
