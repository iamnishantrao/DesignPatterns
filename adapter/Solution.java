
public class Solution {
    
    public static void main(String[] args) {
        
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play(".mp3", "hello.mp3");
        audioPlayer.play(".wav", "world.wav");
        audioPlayer.play(".mp4", "helloworld.mp4");
    }
}

// target interface
interface MediaPlayer {

    public void play(String audioType, String fileName);
}

// class following target interface
class MP3Player implements MediaPlayer {

    public void play(String audioType, String fileName) {

        if (audioType.equals(".mp3")) {

            System.out.println("Playing MP3 File: " + fileName);
        } else {

            System.out.println("Invalid media format, can only play MP3 files!");
        }
    }
}

// adaptee class
class WAVPlayer {

    public void playWAV(String fileName) {

        System.out.println("Playing WAV File: " + fileName);
    }
}

// adapter
class MediaAdapter implements MediaPlayer {

    public WAVPlayer wavPlayer;

    public MediaAdapter(String audioType) {

        if (audioType.equals(".wav")) {
            
            wavPlayer = new WAVPlayer();
        }
    }

    public void play(String audioType, String fileName) {

        if (audioType.equals(".wav")) {

            System.out.println("Playing WAV File: " + fileName);
        } else {

            System.out.println("Invalid media format, can only play WAV files!");
        }
    }
}

// concrete class implementing target interface
class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        
        if (audioType.equalsIgnoreCase(".mp3")) {
            
            MP3Player mp3Player = new MP3Player();
            mp3Player.play(audioType, fileName);
        } else if (audioType.equalsIgnoreCase(".wav")) {
            
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            
            System.out.println("Invalid media type. AudioPlayer can only play MP3 and WAV files.");
        }
    }
}
