package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        //Producto celular = new Producto("Samsung", "teléfono usado", new BigDecimal("1000"), celulares);

        EntityManager em = JPAUtils.getEntityManager();

        em.getTransaction().begin();

        em.persist(celulares);

        celulares.setNombre("LIBROS");

        em.flush();
        em.clear();

        celulares = em.merge(celulares);
        celulares.setNombre("SOFTWARES");

        em.flush();
        em.clear();

        celulares = em.merge(celulares);
        em.flush();
    }
}
