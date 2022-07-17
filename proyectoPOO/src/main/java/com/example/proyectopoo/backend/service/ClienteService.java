package com.example.proyectopoo.backend.service;

import com.example.proyectopoo.backend.dto.Producto;

import java.util.List;

public interface ClienteService {
    List<Producto> verCatalogo();

    public Producto verDetalleProducto(Integer idProducto);

    List<Producto>buscarProducto(String nombre);

}
