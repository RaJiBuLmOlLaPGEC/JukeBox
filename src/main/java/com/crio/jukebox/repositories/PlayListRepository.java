package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Song;

public class PlayListRepository {
    private final Map<String,PlayList> playListMap=new HashMap<>();
    public PlayListRepository(){

    }

    public String save(String id,PlayList p){
        if(id==null){
            id=Integer.toString(playListMap.size()+1);
        }
        playListMap.put(id, p);
        return "Playlist ID - "+id;
    }

    public boolean findById(String playListId) {
        return playListMap.containsKey(playListId);
    }

    public void deletePLayList(String playListId) {
        playListMap.remove(playListId);
    }

    public PlayList addSong(String id,List<String> songs){
        List<String> allSongs=playListMap.get(id).getSongs();
        allSongs.addAll(songs);
        playListMap.get(id).setSongs(allSongs);
        return playListMap.get(id);
    }

    public PlayList deleteSong(String playListId, List<String> songs) {
        List<String> allSongs=playListMap.get(playListId).getSongs();
        allSongs.removeAll(songs);
        playListMap.get(playListId).setSongs(allSongs);
        return playListMap.get(playListId);
    }

    public String play(String playListId) {
        return playListMap.get(playListId).getSongs().get(0);
        
    }

    public List<String> getSongs(String playListId) {
        return playListMap.get(playListId).getSongs();
    }
}
