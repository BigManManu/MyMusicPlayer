import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.FloatControl;
public class WAVSongs implements LineListener{
    
    private Clip clip;
    private AudioInputStream audio;
    private File musicPath;
    private ArrayList<String> songFiles;
    private ArrayList<String> randomSongs;
    private int randSongSelect;
    private int songSelected;
    private boolean playing;
    private boolean random;
    private boolean loop;
    private boolean songLoopEnded;
    private Random rand;
    private long clipTimePos;
    private DataLine.Info info;
    
    WAVSongs(String songs[]) {
        songSelected = 0;
        randSongSelect = 0;
        clipTimePos = 0;
        playing = false;
        random = false;
        loop = false;
        songLoopEnded = false;
        info = null;
        songFiles = new ArrayList<String>();
        Collections.addAll(songFiles, songs);
    }
    
    /*
        Boolean setters that are set from the GUI buttons
    */
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    public void setRandom(boolean random) {
        this.random = random;
    }
    
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
    
    /*
        Get the name of a song in a string and returns it
        so it can be dipslayed on the GUI
    */
    public String getSong() {
        if (!random) {
            String editedStr = new String(songFiles.get(songSelected));
            String songName = editedStr.substring(9);
            return songName;
        }
        else {
            String editedStr = new String(randomSongs.get(randSongSelect));
            String songName = editedStr.substring(9);
            return songName;
        }
    }
    
    /*
        Function is in charge of playing and pausing the song
    */
    public void playAndPause() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (playing && !random) {
            musicPath = new File(songFiles.get(songSelected));
            if (musicPath.exists()) {
                audio = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.setMicrosecondPosition(clipTimePos);
                clip.addLineListener(this);
                clip.start();
            }
        }
        if (!playing && !random) {
            clipTimePos = clip.getMicrosecondPosition();
            clip.stop();
        }
        if (playing && random) {
            musicPath = new File(randomSongs.get(randSongSelect));
            if (musicPath.exists()) {
                audio = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.setMicrosecondPosition(clipTimePos);
                clip.addLineListener(this);               
                clip.start();
            }
        }
        if (!playing && random) {
            clipTimePos = clip.getMicrosecondPosition();
            clip.stop();
        }
    }
    
    /*
        Update interface that checks to see when the song is over
        so it can move onto the next or play it again if on loop.
    */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        long length = clip.getMicrosecondLength();
        if (type == LineEvent.Type.STOP && length == clip.getMicrosecondPosition()) {
            try {
                if (loop) {
                    songLoopEnded = true;
                }
                nextSong();
            }
            catch(Exception e) {
                System.out.println("Dummy");
            }
        }
    }
    
    /*
        Gets the next song of the playlist, if there is no song afterwards
        it will just loop back to the first song.
    */
    public void nextSong() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        try {
            clip.removeLineListener(this);
        }
        catch (Exception e){
            System.out.println("This does nothing");
        }
        finally {
            if (songSelected >= songFiles.size() - 1) {songSelected = -1;}
            if (random){
                if (randSongSelect >= randomSongs.size() - 1) {randSongSelect = -1;}
            }
            if (!random) {
                try {
                    clipTimePos = 0;
                    clip.close();
                    if (songLoopEnded) songLoopEnded = false;
                    else songSelected++;
                    playAndPause();
                }
                catch (Exception e) {
                    songSelected++;
                }
            }
            else {
                try {
                    clipTimePos = 0;
                    clip.close();
                    if (songLoopEnded) songLoopEnded = false;
                    else randSongSelect++;
                    playAndPause();
                }
                catch (Exception e) {
                    randSongSelect++;
                }
            }
        }
    }
    
    /*
        Gets the previous song of the playlist, if it's on
        the first song it will go the the last song.
    */
    public void previousSong() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        try {
            clip.removeLineListener(this);
        }
        catch (Exception e) {
            System.out.println("This does nothing also");
        }
        finally {
            if (songSelected <= 0) {songSelected = songFiles.size();}
            if (random) {
                if (randSongSelect <= 0) {randSongSelect = randomSongs.size();}
            }
            if (!random) {
                try {
                    clipTimePos = 0;
                    clip.close();
                    songSelected--;
                    playAndPause();
                }
                catch (Exception e) {
                    if (songSelected <= 0) {songSelected = songFiles.size() - 1;}
                    else songSelected--;
                }
            }
            else {
                try {
                    clipTimePos = 0;
                    clip.close();
                    randSongSelect--;
                    playAndPause();
                }
                catch (Exception e) {
                    if (randSongSelect <= 0) {randSongSelect = randomSongs.size() - 1;}
                    else randSongSelect--;
                }
            }
        }
    }
    
    /*
        Creates an ArrayList of all the song files 
        in random order
    */
    public void randomSongs() {
        if (random) {
            rand = new Random();
            int randNum;
            randomSongs = new ArrayList<String>();
            randomSongs.add(songFiles.get(songSelected));
            for (String files: songFiles) {
                randNum = (int)Math.floor(Math.random() * ((randomSongs.size()-1)-1+1) + 1);
                randomSongs.add(randNum, files);
            }
            checkForRepeat();
            randSongSelect = 0;
            if (this.clip != null) clipTimePos = clip.getMicrosecondPosition();
        }
        else {
            clipTimePos = clip.getMicrosecondPosition();
            findPosition();
            randomSongs.clear();
        }
    }
    
    /*
        Changes the volume of the clip when the slider is used
    */
    public void volumeChange(int volume) throws LineUnavailableException {
        double gain = (double)volume / 100;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
    
    /* 
       To make sure a repeated song dosen't show up during 
       the process of making the random playlist
    */
    public void checkForRepeat() {
        for (int i = 0; i < randomSongs.size(); i++) {
            for (int j = i + 1; j < randomSongs.size(); j++) {
                if (randomSongs.get(i).equals(randomSongs.get(j))) {
                    randomSongs.remove(j);
                }
            }
        }
    }
    
    /*
      Finds the position where the song left off.
      Function used mianly for when random is switched off.
    */
    public void findPosition() {
        songSelected = 0;
        for (String song: songFiles) {
            if (randomSongs.get(randSongSelect).equals(song)) {
                break;
            }
            songSelected++;
        }
    }
        
    public void removeLineListener(LineListener listener) {
       clip.removeLineListener(listener);
    }
}