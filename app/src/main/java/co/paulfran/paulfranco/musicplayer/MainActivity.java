package co.paulfran.paulfranco.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRockMusicList(View view){
        Intent intent = new Intent(this, RockActivity.class);
        startActivity(intent);
    }

    public void openCountryMusicList(View view){
        Intent intent = new Intent(this, CountryActivity.class);
        startActivity(intent);
    }

    public void openJazzMusicList(View view){
        Intent intent = new Intent(this, JazzActivity.class);
        startActivity(intent);
    }

    public void openRapMusicList(View view){
        Intent intent = new Intent(this, RapActivity.class);
        startActivity(intent);
    }

    public void openClassicalMusicList(View view){
        Intent intent = new Intent(this, ClassicalActivity.class);
        startActivity(intent);
    }

    public void openGrungeMusicList(View view){
        Intent intent = new Intent(this, GrungeActivity.class);
        startActivity(intent);
    }
}
