package com.vooazdomain.Vooaz.modelsData.constantsData
import ObjectDestination
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.ListOfValues.GetListUsers
import com.vooazdomain.Vooaz.modelsData.ListOfValues.getOthersUsersList
import com.vooazdomain.Vooaz.modelsData.datas.Acessibilidade
import com.vooazdomain.Vooaz.modelsData.datas.Comments
import com.vooazdomain.Vooaz.modelsData.datas.Destinations
import com.vooazdomain.Vooaz.modelsData.datas.User
import java.util.Date

class UsersConts {
    private val users: List<User> = initializeUsers()

    private fun initializeUsers(): List<User> {
        return GetListUsers()

    }

    // Método para buscar um usuário pelo ID
    fun getUserById(id: Int): User? {
        return users.find { it.userId == id }
    }

    // Método para obter todos os usuários
    fun getAllUsers(): List<User> {
        return users
    }
}
class UsersConts2 {
    private val users: List<User?> = initializeUsers()

    private fun initializeUsers(): List<User?> {
        return getOthersUsersList()

    }

    // Método para buscar um usuário pelo ID
    fun getUserById(id: Int): User? {
        return users.find { it?.userId == id }
    }

    // Método para obter todos os usuários
    fun getAllUsers(): List<User?> {
        return users
    }
}


