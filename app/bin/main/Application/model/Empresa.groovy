package Application.model

import groovy.transform.MapConstructor

@MapConstructor
class Empresa implements IModel {
    def id
    def nome
    def email
    def cnpj
    def pais
    def cep
    def descricao
    def senha
}
