package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.PlayListService;

public class PlayPlayListCommand implements ICommand{

    private PlayListService playListService;
    
    public PlayPlayListCommand(PlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        Song song=playListService.playPlayList(tokens.get(1), tokens.get(2));
        if(song!=null){
            System.out.println("Current Song Playing");
            System.out.println("Song - "+song.getName());
            System.out.println("Album - "+song.getAlbumName());
            String str="Artists - ";
            List<String> artist=song.getAllArtist();
            for(int i=0;i<artist.size();i++){
                if(i==artist.size()-1){
                    str+=artist.get(i);
                }else{
                    str+=artist.get(i)+",";
                }
            }
            System.out.println(str);
        }else{
            System.out.println("Playlist is empty.");
        }
        
    }
    
}
