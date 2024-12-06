import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

//@Composable
//fun EntrepreneurScreen(viewModel: EntrepreneurViewModel = viewModel(), entrepreneurId: Int) {
//    val entrepreneur by viewModel.entrepreneur.collectAsState()
//
//    LaunchedEffect(Unit) {
//        viewModel.fetchEntrepreneur(entrepreneurId)
//    }
//
//    entrepreneur?.let { data ->
//        Column(modifier = Modifier.padding(16.dp)) {
//            Image(
//                painter = rememberAsyncImagePainter(data.user.image),
//                contentDescription = "User Image",
//                modifier = Modifier.size(100.dp)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            BasicText(text = "Name: ${data.user.name} ${data.user.lastname}", style = TextStyle(fontSize = 20.sp))
//            Spacer(modifier = Modifier.height(4.dp))
//            BasicText(text = "Email: ${data.user.email}")
//            BasicText(text = "Phone: ${data.user.phone}")
//            BasicText(text = "Location: ${data.user.location}")
//        }
//    } ?: run {
//        BasicText(text = "Loading...", style = TextStyle(fontSize = 16.sp))
//    }
//}
