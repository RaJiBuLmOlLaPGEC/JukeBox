package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Song;

public interface IPlayListService {
    public String createPLayList(PlayList p);
    public String deletePLayList(String userId,String playListId);
    public PlayList addSong(String userId,String playListId,List<String> songs);
    public PlayList deleteSong(String string, String string2, List<String> list);
    public Song playPlayList(String userId,String playListId);
}
