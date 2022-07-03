package Application.repositories

import Application.repositories.implementations.PostgresDB

class DatabaseFactory {
    static getDatabase(String database) {
        switch(database) {
            case "postgres":
                return new PostgresDB()
                break
            default:
                throw new Error('Database não existe ou não foi implementada!')
                break
        }
    }
}
