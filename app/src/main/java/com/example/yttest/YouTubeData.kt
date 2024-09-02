package com.example.yttest

data class YouTubeResponse(val items: List<PlaylistItem>)
data class PlaylistItem(val id: String, val snippet: Snippet)
data class Snippet(val title: String, val thumbnails: Thumbnails)
data class Thumbnails(val default: Thumbnail)
data class Thumbnail(val url: String)
