package com.example.music.ui.charts;

public class ChartItem {
    private int rank;
    private String songTitle;
    private String artistName;

    public ChartItem(int rank, String songTitle, String artistName) {
        this.rank = rank;
        this.songTitle = songTitle;
        this.artistName = artistName;
    }

    public int getRank() {
        return rank;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }
}
