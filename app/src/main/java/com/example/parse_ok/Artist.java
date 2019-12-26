
package com.example.parse_ok;

import java.util.List;

public class Artist {

    private String name;


    private List<Image> image = null;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }



}
