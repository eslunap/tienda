package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.*;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDePedido {
    public static void main(String[] args) {
        registrarProducto();

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1L);

        Cliente cliente = new Cliente("Juan", "12345678");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        
    }
    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }


}
