package co.paulfran.paulfranco.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView rockTextView;
    private TextView countryTextView;
    private TextView jazzTextView;
    private TextView rapTextView;
    private TextView classicalTextView;
    private TextView grungeTextView;

    // Each button’s behavior is determined by an OnClickListener in the Java code rather than by the android:onClick attribute in the XML Layout.
    private View.OnClickListener rockOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openRockMusicList();
        }
    };

    private View.OnClickListener countryOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openCountryMusicList();
        }
    };

    private View.OnClickListener jazzOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openJazzMusicList();
        }
    };

    private View.OnClickListener rapOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openRapMusicList();
        }
    };

    private View.OnClickListener classicalOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openClassicalMusicList();
        }
    };

    private View.OnClickListener grungeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openGrungeMusicList();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Each button’s behavior is determined by an OnClickListener in the Java code rather than by the android:onClick attribute in the XML Layout.
        rockTextView = findViewById(R.id.rockTextView);
        rockTextView.setOnClickListener(rockOnClickListener);

        countryTextView = findViewById(R.id.countryTextView);
        countryTextView.setOnClickListener(countryOnClickListener);

        jazzTextView = findViewById(R.id.jazzTextView);
        jazzTextView.setOnClickListener(jazzOnClickListener);

        rapTextView = findViewById(R.id.rapTextView);
        rapTextView.setOnClickListener(rapOnClickListener);

        classicalTextView = findViewById(R.id.classicalTextView);
        classicalTextView.setOnClickListener(classicalOnClickListener);

        grungeTextView = findViewById(R.id.grungeTextView);
        grungeTextView.setOnClickListener(grungeOnClickListener);

    }

    public void openRockMusicList(){
        Intent intent = new Intent(this, RockActivity.class);
        startActivity(intent);
    }

    public void openCountryMusicList(){
        Intent intent = new Intent(this, CountryActivity.class);
        startActivity(intent);
    }

    public void openJazzMusicList(){
        Intent intent = new Intent(this, JazzActivity.class);
        startActivity(intent);
    }

    public void openRapMusicList(){
        Intent intent = new Intent(this, RapActivity.class);
        startActivity(intent);
    }

    public void openClassicalMusicList(){
        Intent intent = new Intent(this, ClassicalActivity.class);
        startActivity(intent);
    }

    public void openGrungeMusicList(){
        Intent intent = new Intent(this, GrungeActivity.class);
        startActivity(intent);
    }
}
