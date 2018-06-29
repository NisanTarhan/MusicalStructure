package com.example.nisan.musicalstructure;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Song {
    private String songName;
    private String artistName;
    private String albumName;
    private int songId;
    private int imageResourceId;

    public Song(@NonNull int songId, @Nullable String songName, @Nullable String artistName, @Nullable String albumName, @Nullable int imageResourceId) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageResourceId = imageResourceId;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSongId() {
        return songId;
    }


}
