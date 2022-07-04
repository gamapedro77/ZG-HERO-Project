package Application.repositories.implementations

import Application.DAO.IDAO
import Application.model.Empresa
import Application.repositories.IEmpresaRepository

class EmpresaRepository implements IEmpresaRepository {

    IDAO empresaDAO

    EmpresaRepository(IDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    @Override
    def save(Empresa empresa) {
        return empresaDAO.insert(empresa)
    }

    @Override
    def findByEmail(String email) {
        return empresaDAO.selectByEmail(email)
    }

    @Override
    def findByCnpj(String cnpj) {
        return empresaDAO.selectByCnpj(cnpj)
    }

    @Override
    def listAll() {
        return empresaDAO.selectAll()
    }
}
