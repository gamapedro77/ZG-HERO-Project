package com.linketinder.MSCadastro.CustomExceptions;

public class EmailAlreadyRegisteredException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message = "Usuario com este email já existe!";
}
