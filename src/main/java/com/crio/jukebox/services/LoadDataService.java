package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.SongRepository;

public class LoadDataService implements ILoadDataService{
    private final SongRepository srepo;

    
    public LoadDataService(SongRepository srepo) {
        this.srepo = srepo;
    }


    @Override
    public String loadSongs(String csvFile) throws FileNotFoundException {
        // System.out.println("inside csv");
        String message;
        //Creating list<Song> object from csv file given.
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(csvFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> songDetails = Arrays.asList(line.trim().split(","));
                Song song=new Song(songDetails.get(0), songDetails.get(1), songDetails.get(2), songDetails.get(3), songDetails.get(4), Arrays.asList(songDetails.get(5).trim().split("#")));
                srepo.save(song);
                // read next line
                line = reader.readLine();
            }
            reader.close();
            message= "Songs Loaded successfully";
        } catch (Exception e) {
            message=e.getMessage()+"some issue";
        }
        return message;
        
    }
    
}
