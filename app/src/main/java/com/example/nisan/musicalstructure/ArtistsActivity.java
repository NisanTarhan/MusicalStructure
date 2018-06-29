package com.example.nisan.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        ArrayList<Song> artists = new ArrayList<>();

        artists.add(new Song(0, null, "Sofi Tukker", null, R.drawable.play_button));
        artists.add(new Song(1, null, "Imagine Dragons", null, R.drawable.play_button));
        artists.add(new Song(2, null, "Camila Cabello", null, R.drawable.play_button));

        ArtistAlbumAdapter adapter = new ArtistAlbumAdapter(this, artists);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent item = new Intent(ArtistsActivity.this, NowPlayingScreen.class);
                Song itemValue = (Song) adapter.getItemAtPosition(position);
                String itemName = itemValue.getSongName();
                item.putExtra("song_name", itemName);
                startActivity(item);
            }
        });

    }
}
