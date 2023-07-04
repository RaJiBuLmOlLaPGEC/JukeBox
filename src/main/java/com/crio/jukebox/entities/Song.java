package com.crio.jukebox.entities;

import java.util.List;

public class Song extends BaseEntity{
    private String name;
    private String genre;
    private String albumName;
    private String mainArtist;
    private List<String> allArtist;
    public Song(String id,String name, String genre, String albumName, String mainArtist,
            List<String> allArtist) {
        this.id=id;
        this.name = name;
        this.genre = genre;
        this.albumName = albumName;
        this.mainArtist = mainArtist;
        this.allArtist = allArtist;
    }
    public Song(String name, String genre, String albumName, String mainArtist,
            List<String> allArtist) {
        this.name = name;
        this.genre = genre;
        this.albumName = albumName;
        this.mainArtist = mainArtist;
        this.allArtist = allArtist;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getMainArtist() {
        return mainArtist;
    }
    public void setMainArtist(String mainArtist) {
        this.mainArtist = mainArtist;
    }
    public List<String> getAllArtist() {
        return allArtist;
    }
    public void setAllArtist(List<String> allArtist) {
        this.allArtist = allArtist;
    }
    @Override
    public String toString() {
        return "Song [albumName=" + albumName + ", allArtist=" + allArtist + ", genre=" + genre
                + ", mainArtist=" + mainArtist + ", name=" + name + "]";
    }

    
    
}
