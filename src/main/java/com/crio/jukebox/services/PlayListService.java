package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.dtos.UserSongDto;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;

public class PlayListService implements IPlayListService{

    private final UserRepository urepo;
    private final PlayListRepository prepo;
    private final SongRepository srepo;

    
    public PlayListService(UserRepository urepo, PlayListRepository prepo, SongRepository srepo) {
        this.urepo = urepo;
        this.prepo = prepo;
        this.srepo = srepo;
    }

    @Override
    public String createPLayList(PlayList p) {
        // TODO Auto-generated method stub
        //valid user
        if(urepo.findById(p.getUserId()) && srepo.containsAllSongs(p.getSongs())){
            return prepo.save(null, p);
        }else{
            return "Some Requested Songs Not Available. Please try again.";
        }
    }

    @Override
    public String deletePLayList(String userId, String playListId) {
        // TODO Auto-generated method stub
        if(urepo.findById(userId) && prepo.findById(playListId)){
            prepo.deletePLayList(playListId);
            return "Delete Successful";
        }
        return "Playlist Not Found";
    }

    @Override
    public PlayList addSong(String userId, String playListId, List<String> songs) {
        // TODO Auto-generated method stub
        if(urepo.findById(userId)&& prepo.findById(playListId)&& srepo.containsAllSongs(songs)){
            PlayList p= prepo.addSong(playListId,songs);
            p.setId(playListId);
            return p;
        }
        return null;
    }

    @Override
    public PlayList deleteSong(String userId, String playListId, List<String> songs) {
        // TODO Auto-generated method stub
        if(urepo.findById(userId)&& prepo.findById(playListId)&& srepo.containsAllSongs(songs)){
            PlayList p= prepo.deleteSong(playListId,songs);
            p.setId(playListId);
            return p;
        }
        return null;
    }

    @Override
    public Song playPlayList(String userId, String playListId) {
        // TODO Auto-generated method stub
        if(urepo.findById(userId)&& prepo.findById(playListId)){
            String songId=prepo.play(playListId);
            Song song=srepo.findById(songId);
            urepo.setCurrentSong(userId,playListId,songId);
            return song;
        }
        return null;
    }
    
}
