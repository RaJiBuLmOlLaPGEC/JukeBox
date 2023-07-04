package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.services.IPlayListService;

public class CreatePlayListCommand implements ICommand{

    private final IPlayListService playListService;
    
    public CreatePlayListCommand(IPlayListService playListService) {
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        List<String> songId=new ArrayList<>();
        for(int i=3;i<tokens.size();i++){
            songId.add(tokens.get(i));
        }
        PlayList p=new PlayList(tokens.get(1), tokens.get(2), songId);
        System.out.println(playListService.createPLayList(p));
        
    }
    
}
