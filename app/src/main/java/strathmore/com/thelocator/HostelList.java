package strathmore.com.thelocator;

import android.media.Image;

/**
 * Created by Cece on 04/11/2017.
 */

public class HostelList {

    private String image;
    private String hostelname;
    private String hostelprice;
    private String favouritesimg;

    //The default constructor
    public HostelList(){

    }

    //Constructor with the parameters
    public HostelList(String image, String hostelname, String hostelprice, String favouritesimg ){
        this.image = image;
        this.hostelname = hostelname;
        this.hostelprice = hostelprice;
        this.favouritesimg = favouritesimg;
    }

    public HostelList(String image, String hostelname, String hostelprice){
        this.image = image;
        this.hostelname = hostelname;
        this.hostelprice = hostelprice;
        this.favouritesimg = favouritesimg;
    }

    //Image getter and setter
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    //Hostel name getter and setter
    public String getHostelname() {
        return this.hostelname;
    }

    public void setHostelname(String hostelname) {
        this.hostelname = hostelname;
    }


    //Hostel price getter and setter
    public String getHostelprice() {
        return this.hostelprice;
    }

    public void setHostelprice(String hostelprice) {
        this.hostelprice = hostelprice;
    }


    //Favourites getter and setter

    public String getFavouritesimg() {
        return favouritesimg;
    }

    public void setFavouritesimg(String favouritesimg) {
        this.favouritesimg = favouritesimg;
    }


}

