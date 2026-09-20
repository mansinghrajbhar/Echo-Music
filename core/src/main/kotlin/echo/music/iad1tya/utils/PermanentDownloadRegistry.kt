package echo.music.iad1tya.utils

import java.util.concurrent.ConcurrentHashMap

/**
 * Maps a stable song id to the permanent user-selected content URI that stores
 * its downloaded audio. The map is populated from DataStore during app startup.
 */
object PermanentDownloadRegistry {
  private val uris = ConcurrentHashMap<String, String>()

  fun register(songId: String, uri: String) {
    if (songId.isNotBlank() && uri.isNotBlank()) {
      uris[songId] = uri
    }
  }

  fun remove(songId: String) {
    uris.remove(songId)
  }

  fun get(songId: String): String? = uris[songId]

  fun clear() {
    uris.clear()
  }
}
