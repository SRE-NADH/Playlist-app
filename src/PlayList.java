import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {
    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;
    private boolean isnext;
    public PlayList(String title) {
        this.title = title;
        songs = new ArrayList<>();
        itr = songs.listIterator();
    }
   public void print(){
        for(Song x: songs){
            System.out.println(x);
        }
   }
    Optional<Song> findsong(String title){
        for(Song x:songs){
            if(x.getTitle().equals(title)){
                return Optional.of(x);
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

    public ListIterator<Song> getItr() {
        return itr;
    }

    public String addsongFromalbum(Albums album, String songtitle){
        Optional<Song> optional = album.findsong(songtitle);
        Optional<Song> optionalPlaylist = findsong(songtitle);
        if(optional.isPresent() && optionalPlaylist.isEmpty()){
            songs.add(optional.get());
            itr = songs.listIterator();
            return "song added to play list";
        }
        if(optional.isEmpty()){
            return "song not found in album";
        }
        return "song alredy exit in playlist";
    }

    public String addsongFromalbum(Albums album,int trackno){
        Optional<Song> optional = album.findsong(trackno);
        if(optional.isEmpty()){
            return "song not found in album";
        }

        Optional<Song> optional1 = findsong(optional.get().getTitle());
        if(optional.isPresent() && optional1.isEmpty()){
            songs.add(optional.get());
            itr = songs.listIterator();
            return "song added to play list";
        }
        return "song alredy exit in playlist";
    }
    public  String playcurrsong(){
        if(isnext){
            isnext = false;
            return "current song is "+itr.previous();
        }
            isnext=true;
         return "current playing song is "+itr.next();

    }

    public String playnextsong(){
        if(!isnext){
            itr.next();
            isnext=true;
        }
        if(itr.hasNext()){
            isnext=true;
            return "next song to play is "+itr.next();
        }
        return "there is no next song";
    }

    public String playprevsong(){
        if(isnext){
            itr.previous();
            isnext=false;
        }
        if(itr.hasPrevious()){
            isnext=false;
            return "prev song to play is "+itr.previous();
        }
        return "there is no previous song";
    }

}
