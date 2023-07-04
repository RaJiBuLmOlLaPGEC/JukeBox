package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.PlayListService;
import com.crio.jukebox.services.IUserService;

public class DeletePlayListCommand implements ICommand{

    private final PlayListService playListService;


    public DeletePlayListCommand(PlayListService playListService) {
        this.playListService = playListService;
    }


    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(playListService.deletePLayList(tokens.get(1), tokens.get(2)));
        
    }

}
