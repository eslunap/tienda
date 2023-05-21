package com.latam.alura.tienda.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="items_pedido")
public class ItemsPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private BigDecimal precioUnitario;

    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Pedido pedido;

}
