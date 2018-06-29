package com.example.nisan.musicalstructure;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingScreen extends AppCompatActivity implements Runnable {

    final int[] songArray = {R.raw.sofi_tukker_batshit, R.raw.imagine_dragons_thunder, R.raw.camila_cabello_havana};
    private MediaPlayer mediaPlayer;
    private int pauseCurrenPosition;
    private SeekBar soundSeekBar;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;
    TextView songName;
    Thread soundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing_screen);

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        soundSeekBar = findViewById(R.id.seekBar);
        songName = findViewById(R.id.songText);

        Bundle extras = getIntent().getExtras();
        final int songId = extras.getInt("song_id");
        String song_name = extras.getString("song_name");
        songName.setText(song_name);

        mediaPlayer = MediaPlayer.create(this, songArray[songId]);

        setupListener(songId);

        soundThread = new Thread(this);
        soundThread.start();

    }

    private void setupListener(final int songId) {
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), songArray[songId]);
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pauseCurrenPosition);
                    mediaPlayer.start();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseCurrenPosition = mediaPlayer.getCurrentPosition();
                }

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    soundSeekBar.setProgress(0);
                    mediaPlayer = null;
                }
            }
        });


        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public void run() {
        int currentPosition = 0;
        int soundTotal = mediaPlayer.getDuration();
        soundSeekBar.setMax(soundTotal);

        while (mediaPlayer != null && currentPosition < soundTotal) {

            try {
                Thread.sleep(300);
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (InterruptedException soundException) {
                return;
            } catch (Exception otherException) {
                return;
            }
            soundSeekBar.setProgress(currentPosition);
        }
    }
}
