import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Conferência de Tecnologia 2024",
        description = "Tendências em tecnologia.",
        date = "2024-12-15",
        location = "Parque Tecnológico",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img1
    ),
    Event(
        id = 2,
        title = "Festival de Música Eletrônica",
        description = "Os melhores DJs do mundo.",
        date = "2024-12-20",
        location = "Praia Central",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img2
    ),
    Event(
        id = 3,
        title = "Workshop de Fotografia",
        description = "Aperfeiçoe suas habilidades.",
        date = "2024-12-18",
        location = "Centro Cultural",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img3
    ),
    Event(
        id = 4,
        title = "Feira de Startups",
        description = "Novas ideias e networking.",
        date = "2024-12-22",
        location = "Centro de Convenções",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img4
    ),
    Event(
        id = 5,
        title = "Maratona de Coding",
        description = "Resolva desafios de programação.",
        date = "2024-12-19",
        location = "Universidade Tecnológica",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img5
    ),
    Event(
        id = 6,
        title = "Palestra Motivacional",
        description = "Inspire-se com grandes histórias.",
        date = "2024-12-16",
        location = "Auditório Principal",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img6
    ),
    Event(
        id = 7,
        title = "Noite do Cinema Indie",
        description = "Exibição de curtas independentes.",
        date = "2024-12-21",
        location = "Cinema da Praça",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img7
    ),
    Event(
        id = 8,
        title = "Ciclo de Palestras de Saúde",
        description = "Dicas e práticas para bem-estar.",
        date = "2024-12-23",
        location = "Academia Municipal",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img8
    ),
    Event(
        id = 9,
        title = "Oficina de Culinária Vegana",
        description = "Receitas saudáveis e deliciosas.",
        date = "2024-12-17",
        location = "Espaço Gourmet",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img9
    ),
    Event(
        id = 10,
        title = "Show de Stand-up Comedy",
        description = "Ria com os melhores comediantes.",
        date = "2024-12-25",
        location = "Teatro Municipal",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageRes = R.drawable.img10
    )
)

