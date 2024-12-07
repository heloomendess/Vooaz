package com.vooazdomain.Vooaz.telas.destinationsScreen.infoDestination

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vooazdomain.Vooaz.R

@Composable
fun TravelItineraryScreen(expanded_Travel: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF7F5F5))
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.roteiro,"Mini roteiro:"),

            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.duração, "Duração: Aprox. 3–4 horas"),
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TravelStep(
            title =stringResource(R.string.titulo,  "Chegada"),
            time = stringResource(R.string.horários, "10h"),
            description = stringResource(R.string.descrição, "Transporte: A combinar com o guia ou uso de transporte público. Se optar por carro, verificar opções de estacionamento.")
        )
        TravelStep(
            title =stringResource(R.string.titulo,  "Entrada"),
            time = stringResource(R.string.horários, "10h15"),
            description = stringResource(R.string.descrição, "Dica: Informe-se sobre acessibilidade na bilheteria, como guias ou audioguias adaptados.")
        )
        TravelStep(
            title =stringResource(R.string.titulo,  "Visita às Exposições"),
            time = stringResource(R.string.horários, "10h30"),
            description =stringResource(R.string.descrição,  "Atividades: Explore salas e exposições. Não perca a sala 'Grito do Ipiranga' e itens históricos."),
            duration =stringResource(R.string.duração,  "1h30")
        )
        TravelStep(
            title = stringResource(R.string.titulo, "Pausa para Café"),
            time =stringResource(R.string.horários,  "12h00"),
            description =stringResource(R.string.duração,  "Local: Café do Museu. Duração: 30 min.")
        )
        TravelStep(
            title =stringResource(R.string.titulo,  "Passeio pelos Jardins"),
            time = stringResource(R.string.horários, "12h30"),
            description =stringResource(R.string.descrição,  "Atividades: Aproveite os jardins para tirar fotos."),
            duration = stringResource(R.string.duração, "30 min")
        )
        TravelStep(
            title =stringResource(R.string.titulo,  "Visita à Loja de Souvenirs"),
            time = stringResource(R.string.horários, "13h00"),
            description =stringResource(R.string.descrição,  "Atividades: Confira itens relacionados ao museu e à história do Brasil."),
            duration =stringResource(R.string.duração,  "30 min")
        )
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        AdditionalTips()
        Spacer(modifier = Modifier.weight(1f))
        Button (
            onClick = { expanded_Travel.value = !expanded_Travel.value },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary)
        ) {
            Text("Sair do Modo Roteiro")
        }
    }
}

@Composable
fun TravelStep(title: String, time: String, description: String, duration: String? = null) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = title,
        )
        Row (verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint =MaterialTheme.colorScheme.tertiary)
            Text(
                text = stringResource(R.string.horários,"Horário: $time"),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        if (duration != null) {
            Text(
                text =stringResource(R.string.duração, "Duração: $duration"),
                color =MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Text(
            text = description,
            
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun AdditionalTips() {
    Column {
        Text(
            text = stringResource(R.string.mensagem,"Dicas Adicionais"),
        )
        Text(
            text =stringResource(R.string.mensagem, "Planejamento: Entre em contato com o museu para verificar recursos disponíveis."),

            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = stringResource(R.string.mensagem,"Acompanhante: Esteja acompanhado para melhor navegação."),

            modifier = Modifier.padding(top = 4.dp)
        )   
        Text(
            text =stringResource(R.string.mensagem, "Material tátil: Pergunte por materiais táteis ou experiências sensoriais."),
            
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
