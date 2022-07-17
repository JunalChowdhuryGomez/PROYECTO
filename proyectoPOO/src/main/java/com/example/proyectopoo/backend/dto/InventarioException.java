package com.example.proyectopoo.backend.dto;

import lombok.Data;

@Data
public class InventarioException extends RuntimeException{


    public InventarioException() {
    }

    public InventarioException(String message) {
        super(message);
    }

    public InventarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
