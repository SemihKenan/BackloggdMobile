package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // LazyColumn için items importu
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource // Örnek resim için
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.ProfileFilter
import com.example.myapplication.ui.theme.MyApplicationTheme // Projenizin tema adını kullanın

// --- 1. Durum ve Veri Modelleri ---

// Hangi sekmenin seçili olduğunu tutacak enum veya sealed class

// Örnek veri modelleri (Bunları kendi veri yapınıza göre uyarlayın)
data class GameItem(
    val id: String,
    val name: String,
    val genre: String,
    val imageUrl: String? = null, // Veya placeholder için Int (Drawable Res ID)
    val playedDate: String? = null, // Son oynanma için
    val isFavorite: Boolean = false
)

data class CommentItem(
    val id: String,
    val gameName: String,
    val commentText: String,
    val date: String
)

// Örnek Mock Data (Gerçek uygulamanızda ViewModel'den veya Repository'den gelir)
val mockAllGames = listOf(
    GameItem(id = "g1", name = "CyberRebel", genre = "RPG", playedDate = "2023-10-25", isFavorite = true),
    GameItem(id = "g2", name = "Galaxy Runner", genre = "Action", playedDate = "2023-10-26"),
    GameItem(id = "g3", name = "Mystic Forest", genre = "Adventure", playedDate = "2023-10-20", isFavorite = true),
    GameItem(id = "g4", name = "Speed Demons", genre = "Racing", playedDate = "2023-10-22"),
    GameItem(id = "g5", name = "Ancient Realms", genre = "RPG", playedDate = "2023-09-15", isFavorite = true)
)

val mockComments = listOf(
    CommentItem(id = "c1", gameName = "CyberRebel", commentText = "Harika bir oyun!", date = "2023-10-25"),
    CommentItem(id = "c2", gameName = "Speed Demons", commentText = "Grafikler çok iyi.", date = "2023-10-23")
)


@Composable
fun ProfileScreen() {
    // Seçili filtreyi tutacak state
    var selectedFilter by remember { mutableStateOf(ProfileFilter.All_Activity) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Temaya uygun arka plan
    ) {
        // --- Üst Profil Bilgisi Bölümü ---
        ProfileHeaderSection(
            username = "Oyuncu123", // Örnek kullanıcı adı
            profileImageUrl = null, // Gerçek bir URL veya null olabilir
            gamesPlayed = 25,
            commentsMade = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Orta Filtre Butonları Bölümü ---
        ProfileFilterButtons(
            selectedFilter = selectedFilter,
            onFilterSelected = { newFilter ->
                selectedFilter = newFilter
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Alt Dinamik İçerik Bölümü ---
        DynamicProfileContent(
            selectedFilter = selectedFilter,
            allGames = mockAllGames, // Mock datayı veriyoruz
            allComments = mockComments
        )
    }
}

@Composable
fun ProfileHeaderSection(
    username: String,
    profileImageUrl: String?, // Veya Int (drawable id)
    gamesPlayed: Int,
    commentsMade: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.shapes.medium) // Hafif farklı bir arka plan
            .padding(16.dp), // İç padding
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profil Resmi
        if (profileImageUrl != null) {
            // Coil, Glide veya Picasso gibi bir kütüphane ile ağdan resim yükleyebilirsiniz
            // Image(painter = rememberAsyncImagePainter(profileImageUrl), ...)
            // Şimdilik placeholder kullanalım:
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Projenizde bir resim olmalı
                contentDescription = "Profil Resmi",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profil Resmi",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer, CircleShape)
                    .padding(16.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Kullanıcı Bilgileri
        Column(
            modifier = Modifier.weight(1f) // Kalan alanı doldur
        ) {
            Text(
                text = username,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.PlayArrow,
                    contentDescription = "Oynanan Oyunlar",
                    tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Oynanan Oyunlar: $gamesPlayed",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Create, contentDescription = "Yapılan Yorumlar", tint = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Yorum Sayısı: $commentsMade",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun ProfileFilterButtons(
    selectedFilter: ProfileFilter,
    onFilterSelected: (ProfileFilter) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround // Butonları eşit aralıklarla dağıt
    ) {
        ProfileFilterButton(
            text = "Favoriler",
            icon = Icons.Filled.Favorite,
            isSelected = selectedFilter == ProfileFilter.Favorites,
            onClick = { onFilterSelected(ProfileFilter.Favorites) }
        )
        ProfileFilterButton(
            text = "Son Oynananlar",
            icon = Icons.Filled.Edit,
            isSelected = selectedFilter == ProfileFilter.Recently_Played,
            onClick = { onFilterSelected(ProfileFilter.Recently_Played) }
        )
        ProfileFilterButton(
            text = "Hepsi",
            icon = Icons.Filled.List,
            isSelected = selectedFilter == ProfileFilter.All_Activity,
            onClick = { onFilterSelected(ProfileFilter.All_Activity) }
        )
    }
}

@Composable
fun ProfileFilterButton(
    text: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = if (isSelected) {
        ButtonDefaults.filledTonalButtonColors( // Seçili ise farklı renk
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    } else {
        ButtonDefaults.outlinedButtonColors( // Seçili değilse outlined
            contentColor = MaterialTheme.colorScheme.primary
        )
    }
    val border = if (isSelected) null else BorderStroke(1.dp, MaterialTheme.colorScheme.outline)

    Button( // TextButton yerine Button kullandım, daha belirgin olabilir
        onClick = onClick,
        colors = colors,
        border = border,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(icon, contentDescription = text, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 13.sp) // Yazı boyutunu biraz küçülttüm
    }
}


@Composable
fun DynamicProfileContent(
    selectedFilter: ProfileFilter,
    allGames: List<GameItem>,
    allComments: List<CommentItem>
) {
    // Seçili filtreye göre gösterilecek içeriği belirle
    // Bu kısım daha karmaşık olabilir, ViewModel'den filtrelenmiş veri almak daha iyi olur
    val contentModifier = Modifier
        .fillMaxSize() // LazyColumn'un tüm kalan alanı kaplaması için
        .padding(horizontal = 16.dp)

    when (selectedFilter) {
        ProfileFilter.Favorites -> {
            val favoriteGames = allGames.filter { it.isFavorite }
            if (favoriteGames.isEmpty()) {
                EmptyStateMessage("Henüz favori oyununuz yok.", contentModifier)
            } else {
                LazyColumn(modifier = contentModifier) {
                    items(favoriteGames) { game ->
                        GameInfoCard(game) // Her oyun için bir kart
                    }
                }
            }
        }
        ProfileFilter.Recently_Played -> {
            // Son oynanma tarihine göre sırala (String tarih varsayımıyla basit sıralama)
            val recentlyPlayedGames = allGames.sortedByDescending { it.playedDate ?: "" }
            if (recentlyPlayedGames.isEmpty()) {
                EmptyStateMessage("Henüz oynadığınız oyun yok.", contentModifier)
            } else {
                LazyColumn(modifier = contentModifier) {
                    items(recentlyPlayedGames) { game ->
                        GameInfoCard(game, showPlayedDate = true)
                    }
                }
            }
        }
        ProfileFilter.All_Activity -> {
            // "Hepsi" için oyunları ve yorumları bir arada veya ayrı sekmelerde gösterebilirsiniz.
            // Bu örnekte sadece oyunları ve sonra yorumları listeliyoruz.
            // Daha karmaşık bir "tüm aktiviteler" akışı için farklı bir yapı gerekebilir.
            if (allGames.isEmpty() && allComments.isEmpty()) {
                EmptyStateMessage("Henüz bir aktiviteniz bulunmuyor.", contentModifier)
            } else {
                LazyColumn(modifier = contentModifier) {
                    if (allGames.isNotEmpty()) {
                        item {
                            Text(
                                "Tüm Oyunlar",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                        items(allGames) { game ->
                            GameInfoCard(game, showPlayedDate = true)
                        }
                    }
                    if (allComments.isNotEmpty()) {
                        item {
                            Text(
                                "Tüm Yorumlar",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(start = 8.dp, top = 16.dp)
                            )
                        }
                        items(allComments) { comment ->
                            CommentInfoCard(comment)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyStateMessage(message: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(message, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.outline)
    }
}

// Örnek Kart Composable'ları (Bunları kendi tasarımınıza göre geliştirin)
@Composable
fun GameInfoCard(game: GameItem, showPlayedDate: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Oyun resmi veya ikonu
            // Icon(Icons.Filled.PlayCircleOutline, contentDescription = "Oyun", modifier = Modifier.size(40.dp))
            // Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(game.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                Text(game.genre, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                if (showPlayedDate && game.playedDate != null) {
                    Text("Son Oynanma: ${game.playedDate}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.outline)
                }
            }
            if (game.isFavorite) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favori", tint = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}

@Composable
fun CommentInfoCard(comment: CommentItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Yorum Yapılan Oyun: ${comment.gameName}", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text("\"${comment.commentText}\"", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Tarih: ${comment.date}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.outline, modifier = Modifier.align(Alignment.End))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MyApplicationTheme { // Kendi tema adınızı kullanın
        ProfileScreen()
    }
}

@Preview(showBackground = true, name = "Favoriler Seçili")
@Composable
fun ProfileScreenFavoritesPreview() {
    MyApplicationTheme {
        val screen = @Composable {
            // Seçili filtreyi ve mock datayı doğrudan vererek preview alıyoruz
            Column(modifier = Modifier.fillMaxSize()) {
                ProfileHeaderSection("Kullanıcı", null, 10, 5)
                ProfileFilterButtons(selectedFilter = ProfileFilter.Favorites, onFilterSelected = {})
                DynamicProfileContent(
                    selectedFilter = ProfileFilter.Favorites,
                    allGames = mockAllGames,
                    allComments = mockComments
                )
            }
        }
        screen()
    }
}

