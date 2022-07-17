package com.example.proyectopoo.backend.dto;

import lombok.Data;

@Data
public class Administrador {

    private String idUser;

    private String password;

    public Administrador(String idUser,  String password) {
        this.idUser = idUser;
        this.password = password;
        if(idUser==null || password==null){
            throw new InventarioException("Datos nulos, no validos");
        }
    }
}
