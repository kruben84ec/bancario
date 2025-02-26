package com.banco.cliente_service.exception;

public class IdentificacionDuplicadaException extends RuntimeException {
    public IdentificacionDuplicadaException(String message) {
        super(message);
    }
}