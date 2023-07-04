package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.UserService;


public class PlaySongCommand implements ICommand{

    private final UserService userService;
    
    public PlaySongCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String userId=tokens.get(1);
        String nextSong=tokens.get(2);
        Song song=userService.playSong(userId,nextSong);
        if(song==null){
            System.out.println("Given song id is not a part of the active playlist");
            return;
        }
        System.out.println("Current Song Playing");
        System.out.println("Song - "+song.getName());
        System.out.println("Album - "+song.getAlbumName());
        String str="Artists - ";
        List<String> artists=song.getAllArtist();
        // TheWeeknd,Ariana Grande
        for(int i=0;i<artists.size();i++){
            if(i==artists.size()-1){
                str+=artists.get(i);
            }else{
                str+=artists.get(i)+",";
            }
        }
        System.out.println(str);
        return;
    }
    
}
