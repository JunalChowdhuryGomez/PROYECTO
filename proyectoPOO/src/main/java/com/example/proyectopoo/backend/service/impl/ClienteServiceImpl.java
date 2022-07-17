package com.example.proyectopoo.backend.service.impl;

import com.example.proyectopoo.backend.dao.ClienteDao;
import com.example.proyectopoo.backend.dto.Producto;
import com.example.proyectopoo.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Producto> verCatalogo() {
        return clienteDao.verCatalogo();
    }

    @Override
    public Producto verDetalleProducto(Integer idProducto) {
        return clienteDao.verDetalleProducto(idProducto);
    }

    @Override
    public List<Producto> buscarProducto(String nombre) {
        return clienteDao.buscarProducto(nombre);
    }


}
