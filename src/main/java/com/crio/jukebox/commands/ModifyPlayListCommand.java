package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.services.IPlayListService;

public class ModifyPlayListCommand implements ICommand{

    private IPlayListService playListService;
    
    public ModifyPlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.get(1).equals("ADD-SONG")){
            List<String> list=new ArrayList<>();
            for(int i=4;i<tokens.size();i++){
                list.add(tokens.get(i));
            }
            PlayList p=playListService.addSong(tokens.get(2), tokens.get(3),list );
            if(p!=null){
                System.out.println("Playlist ID - "+p.getId());
                System.out.println("Playlist Name - "+p.getName());
                String str="Song IDs - ";
                for(String s:p.getSongs()){
                    str+=s+" ";
                }
                System.out.println(str.trim());
            }else{
                System.out.println("Some Requested Songs Not Available. Please try again.");
            }
        }else if(tokens.get(1).equals("DELETE-SONG")){
            List<String> list=new ArrayList<>();
            for(int i=4;i<tokens.size();i++){
                list.add(tokens.get(i));
            }
            PlayList p=playListService.deleteSong(tokens.get(2), tokens.get(3),list);
            if(p!=null){
                System.out.println("Playlist ID - "+p.getId());
                System.out.println("Playlist Name - "+p.getName());
                String str="Song IDs - ";
                for(String s:p.getSongs()){
                    str+=s.trim()+" ";
                }
                System.out.println(str.trim());
            }else{
                System.out.println("Some Requested Songs Not Available. Please try again.");
            }
        }
    }
    
}
