package com.example.proyectopoo.backend.dao;

import com.example.proyectopoo.backend.dto.Producto;

import java.util.List;

public interface ClienteDao {
    public List<Producto> verCatalogo();
    public Producto verDetalleProducto(Integer idProducto);

    List<Producto>buscarProducto(String nombre);
}
