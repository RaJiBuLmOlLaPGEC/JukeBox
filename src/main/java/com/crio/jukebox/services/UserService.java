package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;

public class UserService implements IUserService{

    private final UserRepository userRepo;
    private final PlayListRepository prepo;
    private final SongRepository srepo;
    public UserService(UserRepository userRepository,PlayListRepository playListRepository,SongRepository songRepository) {
        this.userRepo=userRepository;
        this.prepo=playListRepository;
        this.srepo=songRepository;
    }
    @Override
    public String create(String name) {
        User user= userRepo.save(new User(name));
        return user.getId()+" "+user.getName();
        // return null;
    }
    @Override
    public Song playSong(String userId, String songId) {
        // if(userRepo.findById(userId)==false) return"User Not Found";
        // TODO Auto-generated method stub
        List<String> strList=userRepo.activeplayListDetails(userId);
        String activatePlayListId=strList.get(0);
        List<String> songs=prepo.getSongs(activatePlayListId);
        if(songId.equals("NEXT")){
            songId=strList.get(1);
            int currentpos=songs.indexOf(songId);
            currentpos+=1;
            if(currentpos>=songs.size()){
                currentpos=0;
            }
            userRepo.changeCurrentstatus(userId,activatePlayListId,songs.get(currentpos));
            return srepo.findById(songs.get(currentpos));
            
        }else if(songId.equals("BACK")){
            songId=strList.get(1);
            int currentpos=songs.indexOf(songId);
            currentpos-=1;
            if(currentpos<0){
                currentpos=songs.size()-1;
            }
            userRepo.changeCurrentstatus(userId,activatePlayListId,songs.get(currentpos));
            return srepo.findById(songs.get(currentpos));
        }else{
            if(songs.contains(songId)){
                userRepo.changeCurrentstatus(userId,activatePlayListId,songId);
                return srepo.findById(songId);
            }else{
                return null;
            }
            
        }
        // return null;
    }
    
}
