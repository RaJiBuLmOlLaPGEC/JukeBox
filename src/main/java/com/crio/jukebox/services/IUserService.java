package com.crio.jukebox.services;

import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;

public interface IUserService {
    public String create(String name);
    public Song playSong(String userId,String songId);
}
