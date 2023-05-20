package com.latam.alura.tienda.prueba;

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
        Producto celular = new Producto("Samsung", "teléfono usado", new BigDecimal("1000"), Categoria.CELULARES);

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDao productoDao = new ProductoDao(em);

        em.getTransaction().begin();

        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
