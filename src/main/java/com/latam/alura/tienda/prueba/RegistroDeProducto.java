package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.CategoriaId;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class RegistroDeProducto {
    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto p = productoDao.consultaPorId(1l);
        System.out.println(p.getNombre());

/*        List<Producto> productos = productoDao.consultarTodos();
        productos.forEach(prod -> System.out.println(prod.getDescripcion()));

        List<Producto> productos1 = productoDao.consultaPorNombre("Xiaomi Redmi");
        productos1.forEach(prod1 -> System.out.println(prod1.getDescripcion()));

        List<Producto> productos2 = productoDao.consultaPorNombreCategoría("CELULARES");
        productos2.forEach(prod1 -> System.out.println(prod1.getDescripcion()));*/

        BigDecimal precio = productoDao.consultarPrecio("Xiaomi Redmi");
        System.out.println(precio);

        Categoria find = em.find(Categoria.class, new CategoriaId("CELULARES", "456"));
        System.out.println(find.getNombre());
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
