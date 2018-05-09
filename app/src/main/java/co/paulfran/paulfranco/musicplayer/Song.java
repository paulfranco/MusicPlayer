package co.paulfran.paulfranco.musicplayer;

public class Song {

    /** Song Title */
    private String mSongTitle;

    /** Artist name */
    private String mArtistName;

    /** Image Resource */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio reource ID for the word */
    private int mAudioResourceId;


    /**
     * Contructor with four inputs
     * @param songTitle
     * @param artistName
     * @param imageResourceId
     * @param audioResourceId
     */
    public Song(String songTitle, String artistName, int imageResourceId, int audioResourceId) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the Song Title
     */
    public String getSongTitle() { return mSongTitle; }

    /**
     * Get Artist Name
     */
    public String getArtistName() { return mArtistName; }

    /**
     * Get the Image Resource Id
     */
    public int getImageResourceId() { return mImageResourceId; }

    /**
     * Get the Audio Resource Id
     */
    public int getAudioResourceId() { return mAudioResourceId; }

    /**
     * Returns whether or not there is an image for this song
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
