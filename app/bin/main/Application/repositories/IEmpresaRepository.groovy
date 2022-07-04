package Application.repositories

import Application.model.Empresa

interface IEmpresaRepository {
    def save(Empresa empresa)
    def findByEmail(String email)
    def findByCnpj(String cnpj)
    def listAll()
}