package com.vooazdomain.Vooaz.modelsData.constantsData

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.vooazdomain.Vooaz.modelsData.ListOfValues.GetListUsers
import com.vooazdomain.Vooaz.modelsData.ListOfValues.getOthersUsersList
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel

import com.vooazdomain.Vooaz.modelsData.datas.User
import java.util.Date
import java.util.Objects

class UsersConts {
    private val users: List<User> = initializeUsers()

    private fun initializeUsers(): List<User> {
        return GetListUsers()

    }

    // Método para buscar um usuário pelo ID
    fun getUserById(id: Int?): User? {
        return users.find { it.userId == id }
    }

    // Método para obter todos os usuários
    fun getAllUsers(): List<User> {
        return users
    }

    // Função para atualizar as informações de um usuário
    fun setUserInformations(
        nome: String?,
        country: String?,
        state: String?,
        city: String?,
        aboutUser: String?,
        neighborhood: String?,
        email: String?,
        disabilityType: String?,

        gender: String?,
        sharedModel: SharedModel
    ): Boolean {
        // Buscar o usuário pelo id
        val user = getUserById(sharedModel.selectedUser?.userId)

        return if (user != null) {
            // Se o usuário for encontrado, atualizamos os dados
            user.name = nome
            user.country = country
            user.state = state
            user.city = city
            user.AboutUser = aboutUser
            user.neighborhood = neighborhood
            user.email = email
            user.disabilityType = disabilityType

            user.gender = gender

            sharedModel.setSelectedUser(user)

            true
        } else {
            false
        }
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



