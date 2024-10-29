import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class MenuItem(
    val texto: String,
    val icono: ImageVector,
    val ruta: String
)

@Composable
fun Menu(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val menuItems = listOf(
        MenuItem("Mi Perfil", Icons.Default.Person, "perfil"),
        MenuItem("Inicio", Icons.Default.Home, "inicio"),
        MenuItem("Busqueda por categoria", Icons.Default.Search, "busqueda"),
        MenuItem("Lista de emprendimientos", Icons.Default.List, "emprendimientos"),
        MenuItem("Notificaciones", Icons.Default.Notifications, "notificaciones"),
        MenuItem("Chat", Icons.Default.Email, "chat"),
        MenuItem("Cerrar Sesión", Icons.Default.ExitToApp, "cerrar-sesion"),
        MenuItem("Ayuda", Icons.Default.Info, "ayuda")
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    menuItems.forEach { menuItem ->
                        MenuItemRow(
                            item = menuItem,
                            onItemClick = {
                                scope.launch {
                                    drawerState.close()
                                }
                                navController.navigate(menuItem.ruta)
                            }
                        )
                    }
                }
            }
        }
    ) {
        // Content of the main screen goes here
    }
}

@Composable
private fun MenuItemRow(
    item: MenuItem,
    onItemClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(vertical = 4.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = item.icono,
                contentDescription = item.texto,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = item.texto,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}