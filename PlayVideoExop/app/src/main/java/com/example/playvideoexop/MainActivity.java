package com.example.playvideoexop;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {
    private PlayerView playerView;
    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.playerView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        player = ExoPlayerFactory.newSimpleInstance(this,new DefaultTrackSelector());

        playerView.setPlayer(player);

        DataSource.Factory datasourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this,getString(R.string.app_name)));

        MediaSource videoSource = new ExtractorMediaSource.Factory(datasourceFactory)
                .createMediaSource(Uri.parse("http://s4.tamilvideosda.net/files/Tamil%202020%20Videos%20Songs/Soorarai%20Pottru/Aagasam%20-%20Soorarai%20Pottru/Aagasam%20-%20Soorarai%20Pottru%201080p%20HD.mp4"));

        player.prepare(videoSource);
    }

    @Override
    protected void onStop() {
        super.onStop();
        playerView.setPlayer(null);
        player.release();
        player = null;

    }
}