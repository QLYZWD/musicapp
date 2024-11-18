package com.example.music.ui.search;

public class SearchItem {
    private String songTitle;
    private String artistName;

    public SearchItem(String songTitle, String artistName) {
        this.songTitle = songTitle;
        this.artistName = artistName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }
}
