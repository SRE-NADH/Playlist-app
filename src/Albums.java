import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Albums {
    private String title;
    private  String artist;
    private List<Song> songs;

    public Albums(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public Albums(String title, String artist) {
        this.title = title;
        this.artist = artist;
        songs = new ArrayList<>();
    }
    boolean findsong(Song song){
        for(Song x:songs){
            if(x.getTitle().equals(song.getTitle()) && x.getArtist().equals(song.getArtist())){
                return true;
            }
        }
        return false;
    }

    Optional<Song> findsong(String title,String artist){
        for(Song x:songs){
            if(x.getTitle().equals(title) && x.getArtist().equals(artist)){
                return Optional.of(x);
            }
        }
        return Optional.empty();
    }
    Optional<Song> findsong(String title){
        for(Song x:songs){
            if(x.getTitle().equals(title)){
                return Optional.of(x); // optional is nothing but a container with an object
            }
        }
        return Optional.empty();
    }
    Optional<Song> findsong(int trackno){
        if(trackno>=0 && trackno<=songs.size()){
            return Optional.of(songs.get(trackno-1));
        }
        return Optional.empty();
    }
    public String addsong(Song song){
         Optional<Song> optionalsong = findsong(song.getTitle(),song.getArtist());
        if(!optionalsong.isEmpty()){
            return "the song already exist";
        }
        else{
            songs.add(song);
            return "song added successfully";
        }
    }
}
