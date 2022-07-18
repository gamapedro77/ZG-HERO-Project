package com.linketinder.MSCadastro.CustomExceptions;

public class CandidatoNaoEncontradoException extends Exception {

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message = "Candidato não pode ser encontrado";
}
