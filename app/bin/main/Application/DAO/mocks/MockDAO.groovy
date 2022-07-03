package Application.DAO.mocks

import Application.DAO.IDAO
import Application.model.IModel

class MockDAO implements IDAO {

    @Override
    def insert(IModel model) {
        return null
    }

    @Override
    def delete(Integer id) {
        return null
    }

    @Override
    def readAll() {
        return null
    }

    @Override
    def selectById(Integer id) {
        return null
    }
}
