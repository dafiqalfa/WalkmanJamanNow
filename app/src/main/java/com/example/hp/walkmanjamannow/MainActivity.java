package com.example.hp.walkmanjamannow;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

public class MainActivity extends Activity implements OnActionClickedListener, AdapterView.OnItemClickListener {

    private InteractivePlayerView ipv;
    private Button control;
    private MediaPlayer mediaPlayer;

    private ListView listView;
    private String[] number;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.walkwithyou);

        // input inisialisasi
        number = getResources().getStringArray(R.array.listmusik);
        listView = (ListView) findViewById(R.id.listMusik);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, number);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        // call music
        uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/walkwithyou");
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(MainActivity.this, uri);

        String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        int milli = Integer.parseInt(durationString);
        milli=milli/1000;

        ipv = (InteractivePlayerView) findViewById(R.id.ipv);
        ipv.setMax(milli);
        ipv.setProgress(0);
        ipv.setOnActionClickedListener(this);

        control = (Button) findViewById(R.id.btnPlay);
        control.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!ipv.isPlaying()){
                    ipv.start();
                    control.setText("PAUSE");

                    mediaPlayer.start();
                }
                else{
                    ipv.stop();
                    control.setText("PLAY");

                    mediaPlayer.pause();
                }
            }
        });
    }

    @Override
    public void onActionClicked(int i) {
        switch (i){
            case 1:
                Toast.makeText(MainActivity.this, "Shuffle", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Love", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Replay", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = (TextView) view;
        String parameterNilai = String.valueOf(textView.getText());

        if (parameterNilai.equals("Walk With You")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/walkwithyou");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.walkwithyou);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("Aku Tenang")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/akutenang");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.akutenang);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("You And Me")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/youandme");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.youandme);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("Zona Nyaman")){
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/zonanyaman");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.zonanyaman);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("To Get To You")) {
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/togettoyou");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.togettoyou);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli / 1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("Monokrom")) {
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/monokrom");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.monokrom);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli / 1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else if (parameterNilai.equals("Thinking Out Loud")) {
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/tol");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.tol);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli / 1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }else{
            cekMusikPlay();

            uri = Uri.parse("android.resource://com.example.hp.walkmanjamannow/raw/walkwithyou");
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.walkwithyou);

            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(MainActivity.this, uri);
            String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int milli = Integer.parseInt(durationString);
            milli = milli/1000;
            ipv.setMax(milli);
            ipv.setProgress(0);

            cekMusikEnd();
        }
    }

    private void cekMusikPlay(){
        if (ipv.isPlaying()){
            ipv.stop();
            control.setText("PLAY");
            mediaPlayer.pause();
        }
    }

    private void cekMusikEnd(){
        ipv.start();
        control.setText("PAUSE");
        mediaPlayer.start();
    }
}
