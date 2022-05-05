package Application.model

import groovy.transform.MapConstructor

@MapConstructor
class Candidato implements IModel {
    def id
    def nome
    def sobrenome
    def data_nascimento
    def email
    def CPF
    def pais
    def CEP
    def descricao
    def senha
}
