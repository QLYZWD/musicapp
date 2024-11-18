package com.example.music.ui.profile;

public class FavoriteItem {
    private String songTitle;
    private String artistName;

    public FavoriteItem(String songTitle, String artistName) {
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
