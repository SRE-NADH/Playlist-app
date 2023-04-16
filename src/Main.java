import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Albums album1 = new Albums("samsmithalbum","samsmith");
        album1.addsong(new Song("unholy","samsmith",2));
        album1.addsong(new Song("perfect","samsmith",3));
        album1.addsong(new Song("gloria","samsmith",1));

        Albums album2 = new Albums("honestly nevermind","drake");
        album2.addsong(new Song("view","drake",1));
        album2.addsong(new Song("herloss","drake",2));
        album2.addsong(new Song("titan","drake",3));

        PlayList mypplayList = new PlayList("my playlist");
        mypplayList.addsongFromalbum(album1,"gloria");
        mypplayList.addsongFromalbum(album2,1);
        mypplayList.addsongFromalbum(album2,2);
        mypplayList.addsongFromalbum(album1,2);



        //System.out.println(mypplayList.playcurrsong());
        System.out.println(mypplayList.playnextsong());
        System.out.println(mypplayList.playprevsong());
        System.out.println(mypplayList.playprevsong());
        System.out.println(mypplayList.playcurrsong());
    }
}