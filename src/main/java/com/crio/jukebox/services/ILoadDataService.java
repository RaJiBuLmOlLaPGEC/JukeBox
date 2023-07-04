package com.crio.jukebox.services;

import java.io.FileNotFoundException;

public interface ILoadDataService {
    public String loadSongs(String csvFile) throws FileNotFoundException;
}
