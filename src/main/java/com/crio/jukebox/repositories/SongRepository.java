package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Song;

public class SongRepository{

    private final Map<String,Song> allSongs;
    public SongRepository(){
        this.allSongs=new HashMap<>();
    }
    public SongRepository(Map<String,Song> songs){
        this.allSongs=songs;
    }

    public Song save(Song entity){
        if(entity.getId()==null){
            entity.setId(Integer.toString(allSongs.size()+1));
            allSongs.put(entity.getId(),entity);
            return entity;
        }
        allSongs.put(entity.getId(),entity);
        return entity;
    }
    public boolean containsAllSongs(List<String> songs){
        return allSongs.keySet().stream().collect(Collectors.toList()).containsAll(songs);
    }
    public Song findById(String songId) {
        return allSongs.get(songId);
    }
    
    
    
}
