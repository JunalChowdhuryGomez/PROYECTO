package com.example.proyectopoo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto {
    private Integer id;
    private String tipo;
    private String nombre;
    private String descripcion;
    private Double precioRegular;
    private Integer cantidad;
    private String urlImagen;

    public Producto(Integer id, String tipo, String nombre,
                    String descripcion, Double precioRegular,
                    Integer cantidad, String urlImagen) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioRegular = precioRegular;
        this.cantidad = cantidad;
        this.urlImagen = urlImagen;
        if(id==null || nombre==null || descripcion==null ||
                precioRegular==null || cantidad==null || urlImagen==null || tipo==null){
            throw new InventarioException("Datos nulos, no validos");
        }
    }



}
