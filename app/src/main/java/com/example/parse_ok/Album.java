
package com.example.parse_ok;

public class Album {

    private String artist, title;

    private Image[] image = null;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image[] getImage() {
        return image;
    }

    public void setImage(Image[] image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", artist = "+artist+", title = "+title+"]";
    }



}
