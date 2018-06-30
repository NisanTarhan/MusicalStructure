package com.example.nisan.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        ArrayList<Song> albums = new ArrayList<>();

        albums.add(new Song(0, null, null, "TreeHouse", R.drawable.play_button));
        albums.add(new Song(1, null, null, "Evolve", R.drawable.play_button));
        albums.add(new Song(2, null, null, "Camila", R.drawable.play_button));

        ArtistAlbumAdapter adapter = new ArtistAlbumAdapter(this, albums);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent item = new Intent(AlbumsActivity.this, NowPlayingActivity.class);
                Song itemValue = (Song) adapter.getItemAtPosition(position);
                Song songId_item = (Song) adapter.getItemAtPosition(position);
                int songId = songId_item.getSongId();
                String itemName = itemValue.getSongName();
                item.putExtra("song_name", itemName);
                item.putExtra("song_id", songId);
                startActivity(item);
            }
        });
    }

}
