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

public class ArtistAlbumAdapter extends ArrayAdapter<Song> {

    @SuppressWarnings("unchecked")
    ArtistAlbumAdapter(Context context, ArrayList pSongs) {
        super(context, 0, pSongs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_other, parent, false);
        }


        Song currentSong = getItem(position);

        if (currentSong != null) {
            TextView nameTextView = listItemView.findViewById(R.id.name_text_view);

            if (currentSong.getArtistName() != null) {
                nameTextView.setText(currentSong.getArtistName());
            } else {
                nameTextView.setText(currentSong.getAlbumName());
            }

            ImageView iconView = listItemView.findViewById(R.id.album_image_view);
            iconView.setImageResource(currentSong.getImageResourceId());
        }

        return listItemView;
    }
}
