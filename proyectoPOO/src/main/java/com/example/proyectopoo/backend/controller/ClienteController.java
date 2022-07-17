package com.example.proyectopoo.backend.controller;


import com.example.proyectopoo.backend.dto.Producto;
import com.example.proyectopoo.backend.dto.resp.RespuestaProducto;
import com.example.proyectopoo.backend.service.AdministradorService;
import com.example.proyectopoo.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    //Servicios Cliente

    //Verificado
    @GetMapping("/ver-catalogo")
    public List<Producto> verCatalogo(){
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        respuestaProducto.setListaProducto(clienteService.verCatalogo());
        return respuestaProducto.getListaProducto();
    }

    //Verificado
    @RequestMapping (value = "/ver-detalle-producto/{idProducto}", method = RequestMethod.GET)
    public @ResponseBody Producto verDetalleProducto(@PathVariable Integer idProducto){
        return clienteService.verDetalleProducto(idProducto);
    }


}



