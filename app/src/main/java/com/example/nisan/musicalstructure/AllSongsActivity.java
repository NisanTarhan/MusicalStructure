package com.example.nisan.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song(0, "Batshit", "Sofi Tukker", null, R.drawable.play_button));
        songs.add(new Song(1, "Thunder", "Imagine Dragons", null, R.drawable.play_button));
        songs.add(new Song(2, "Havana", "Camila Cabello", null, R.drawable.play_button));

        SongListAdapter adapter = new SongListAdapter(this, songs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent item = new Intent(AllSongsActivity.this, NowPlayingActivity.class);
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
