import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SendMailButton(
    email: String,
    content: String,
    subject: String,
    onNavigate: () -> Unit
) {
    val context = LocalContext.current // Contexto dentro de um Composable

    Button(
        onClick = {
            // Chamada da função de envio de e-mail
            sendMail(context, email, content, subject)
            // Navegar para outra tela
            onNavigate()
        },
        modifier = Modifier
            .width(223.dp)
            .height(39.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(size = 28.dp)
            ),
      ) {
        Text("Enviar Email")
    }
}

fun sendMail(context: android.content.Context, email: String, content: String, subject: String) {
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:") // Apenas apps de e-mail devem responder
        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, content)
    }

    if (emailIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(emailIntent)
    } else {
        Toast.makeText(context, "Nenhum aplicativo de e-mail encontrado.", Toast.LENGTH_SHORT).show()
    }
}
