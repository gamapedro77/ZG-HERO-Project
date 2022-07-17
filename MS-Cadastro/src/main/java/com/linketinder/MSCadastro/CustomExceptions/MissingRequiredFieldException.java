package com.linketinder.MSCadastro.CustomExceptions;

import java.util.ArrayList;

public class MissingRequiredFieldException extends Exception{
    private ArrayList<String> parameters;
    String message = "Os seguintes parametros não foram encontrados: ";
    public MissingRequiredFieldException(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getMessage() {
        return message + parameters.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
