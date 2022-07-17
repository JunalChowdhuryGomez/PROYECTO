package com.example.proyectopoo.backend.dto.resp;


import com.example.proyectopoo.backend.dto.Administrador;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaAdministrador {
    private List<Administrador> listaAdministrador;
}
