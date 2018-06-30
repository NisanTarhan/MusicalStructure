package com.example.nisan.musicalstructure;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Song {
    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private int mSongId;
    private int mImageResourceId;

    public Song(@NonNull int songId, @Nullable String songName, @Nullable String artistName, @Nullable String albumName, @Nullable int imageResourceId) {
        this.mSongId = songId;
        this.mSongName = songName;
        this.mArtistName = artistName;
        this.mAlbumName = albumName;
        this.mImageResourceId = imageResourceId;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getSongId() {
        return mSongId;
    }

}
