package co.paulfran.paulfranco.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    /* Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume Playback
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create and setup the AudioManager to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();

        // Add word objects to the list of songs
        songs.add(new Song("Paint it Black", "The Rolling Stones", R.drawable.apps, R.raw.serenata));
        songs.add(new Song("Thunderstruck", "AC/DC", R.drawable.apps, R.raw.serenata));
        songs.add(new Song("Back in Black", "AC/DC", R.drawable.apps, R.raw.serenata));

        // Create a new SongAdapter called adapter. We are calling the contructor and passing it a context and the array list of song objects
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_blue);

        // Create a list view
        // removed casting
        ListView listView = findViewById(R.id.list);

        // Passing the adapter to the list view
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the object ant the position clicked on and store in variable
                Song song = songs.get(position);
                // Create and setup the Media Player for the audio associated with the word
                // Release the media player if it currently exists because we are about to play a different sound file
                releaseMediaPlayer();
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music Stream
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have Audio Focus now
                    // Create and setup the Media Player for the audio associated with the word
                    mMediaPlayer = MediaPlayer.create(RockActivity.this, song.getAudioResourceId());
                    // Start the audio file
                    mMediaPlayer.start();
                    // setup a listener on the media player, so that we can stop and release the media player once the sounds has finished playing
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }

            }
        });
        setTitle("Rock Music");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we wont be playing any sounds anymore
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Abandon audio focus when playback is complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}
