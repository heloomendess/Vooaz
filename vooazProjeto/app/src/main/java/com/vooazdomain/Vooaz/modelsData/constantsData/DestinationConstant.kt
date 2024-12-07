

import com.vooazdomain.Vooaz.modelsData.ListOfValues.getDestinationList

import com.vooazdomain.Vooaz.modelsData.datas.Destinations

class ObjectDestination {
    private val destinations : List<Destinations> = initializeDestinations()

    private fun initializeDestinations(): List<Destinations> {
        return getDestinationList()

    }

    // Método para buscar um usuário pelo ID
    fun getDestinationById(id: Int): Destinations? {
        return destinations.find { it.destinationId == id }
    }

    // Método para obter todos os usuários
    fun getAllDestination(): List<Destinations> {
        return destinations
    }
}
