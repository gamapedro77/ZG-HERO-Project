package Application.DAO

import Application.model.IModel

interface IDAO {
    insert(IModel model)
    delete(Integer id)
    readAll()
    selectById(Integer id)

}