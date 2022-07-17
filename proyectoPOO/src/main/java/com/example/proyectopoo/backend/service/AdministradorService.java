package com.example.proyectopoo.backend.service;

import com.example.proyectopoo.backend.dto.Producto;

import java.util.List;

public interface AdministradorService {
    public Producto agregarProducto(Producto producto);
    public Producto modificarProducto(Integer id_producto, Integer cantidad, Float precio_regular);
    public Producto eliminarProducto(Integer id_producto);
    public Producto verDetalleProductoAdministrador(Integer idProducto);
    public List<Producto> verCatalogoAdministrador();
}
