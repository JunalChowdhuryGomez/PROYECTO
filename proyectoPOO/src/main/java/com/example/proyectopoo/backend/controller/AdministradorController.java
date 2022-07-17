package com.example.proyectopoo.backend.controller;

import com.example.proyectopoo.backend.dto.Producto;
import com.example.proyectopoo.backend.dto.resp.RespuestaProducto;
import com.example.proyectopoo.backend.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"*"})
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @RequestMapping(
            value = "/agregar-producto",
            method = RequestMethod.POST
    )
    public @ResponseBody Producto agregarProducto(@RequestBody Producto producto){
        return administradorService.agregarProducto(producto);
    }

    @RequestMapping(
            value = "/modificar-producto",
            method = RequestMethod.POST
    )
    public @ResponseBody Producto modificarProducto(@RequestBody Integer id_producto, Integer cantidad, Float precio_regular){
        return administradorService.modificarProducto(id_producto, cantidad, precio_regular);
    }

    @RequestMapping(
            value = "/eliminar-producto",
            method = RequestMethod.POST
    )
    public @ResponseBody Producto eliminarProducto(@RequestBody Integer id_producto){
        return administradorService.eliminarProducto(id_producto);
    }



    //Verificado
    @RequestMapping(
            value = "/ver-detalle-producto-administrador/{idProducto}",
            method = RequestMethod.GET
    )
    public @ResponseBody Producto verDetalleProductoAdministrador(@PathVariable Integer idProducto){
        return administradorService.verDetalleProductoAdministrador(idProducto);
    }


    //Verificado
    @RequestMapping(
            value = "/ver-catalogo-administrador",
            method = RequestMethod.GET
    )
    public @ResponseBody RespuestaProducto verCatalogoAdministrador(){
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        respuestaProducto.setListaProducto(administradorService.verCatalogoAdministrador());
        return respuestaProducto;
    }

}
