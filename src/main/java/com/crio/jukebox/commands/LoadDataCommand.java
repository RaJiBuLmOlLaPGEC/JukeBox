package com.crio.jukebox.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.ILoadDataService;
import com.crio.jukebox.services.LoadDataService;


public class LoadDataCommand implements ICommand{

    private final ILoadDataService loadDataService;
    public LoadDataCommand(ILoadDataService loadDataService){
        this.loadDataService=loadDataService;
    }


    @Override
    public void execute(List<String> tokens) {
        // token=<"LOadData","song.csv">
        // TODO Auto-generated method stub
        // System.out.println(tokens.size());
        String csvFile=tokens.get(1);
        // System.out.println("done");
        try {
            System.out.println(loadDataService.loadSongs(csvFile));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
           System.out.println(e.getMessage());
        }

        
        
    }
    
}
