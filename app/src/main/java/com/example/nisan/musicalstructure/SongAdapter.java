package com.example.nisan.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    @SuppressWarnings("unchecked")
    SongAdapter(Context context, ArrayList pSongs) {
        super(context, 0, pSongs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Song currentSong = getItem(position);

        if (currentSong != null) {
            TextView songNameTextView = listItemView.findViewById(R.id.songName_text_view);
            songNameTextView.setText(currentSong.getSongName());

            TextView artistNameTextView = listItemView.findViewById(R.id.artistName_text_view);
            artistNameTextView.setText(currentSong.getArtistName());

            ImageView iconView = listItemView.findViewById(R.id.imageButton);
            iconView.setImageResource(currentSong.getImageResourceId());
        }
        return listItemView;
    }
}
