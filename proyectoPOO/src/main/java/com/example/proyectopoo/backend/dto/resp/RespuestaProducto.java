package com.example.proyectopoo.backend.dto.resp;


import com.example.proyectopoo.backend.dto.Producto;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaProducto {
    List<Producto> listaProducto;

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
}
