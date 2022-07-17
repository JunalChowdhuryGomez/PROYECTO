package com.example.proyectopoo.backend.service.impl;

import com.example.proyectopoo.backend.dao.AdministradorDao;
import com.example.proyectopoo.backend.dto.Producto;
import com.example.proyectopoo.backend.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorDao administradorDao;

    @Override
    public Producto agregarProducto(Producto producto) {
        return administradorDao.agregarProducto(producto);
    }

    @Override
    public Producto modificarProducto(Integer id_producto, Integer cantidad, Float precio_regular) {
        return administradorDao.modificarProducto(id_producto, cantidad, precio_regular);
    }

    @Override
    public Producto eliminarProducto(Integer id_producto) {
        return administradorDao.eliminarProducto(id_producto);
    }

    @Override
    public Producto verDetalleProductoAdministrador(Integer idProducto) {
        return administradorDao.verDetalleProductoAdministrador(idProducto);
    }

    @Override
    public List<Producto> verCatalogoAdministrador() {
        return administradorDao.verCatalogoAdministrador();
    }
}
