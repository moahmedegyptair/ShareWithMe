package com.dandara.nourishlocal.model;

import java.io.Serializable;

public class Community implements Serializable {

    //region Variables
    private String name;
    private String description;
    private int imageReference;
    //endregion
    public Community(String name, String description, int imageReference){
        this.name = name;
        this.description = description;
        this.imageReference = imageReference;
    }
    //region Name
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    //endregion
    //region Description
    public String getDescription(){ return name;}
    public void setDescription(String description){this.description = description;}
    //endregion
    //region ImageReference
    public int getImageReference(){return imageReference;}
    public void setImageReference(int imageReference){this.imageReference = imageReference;}
    //endregion
}
