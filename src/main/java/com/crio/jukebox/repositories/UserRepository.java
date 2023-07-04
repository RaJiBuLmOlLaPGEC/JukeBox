package com.crio.jukebox.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.User;

public class UserRepository {
    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }
    public User save(User entity){
        if(entity.getId()==null){
            autoIncrement++;
            entity.setId(Integer.toString(autoIncrement));
            userMap.put(Integer.toString(autoIncrement), entity);
            return entity;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }
    public boolean findById(String id){
        return userMap.containsKey(id);
    }

    public void setCurrentSong(String userId, String playListId, String songId) {
        User user=userMap.get(userId);
        user.setActivesong(Arrays.asList(playListId,songId));
    }

    public List<String> activeplayListDetails(String userId){
        return userMap.get(userId).getActivesong();
    }

    public void changeCurrentstatus(String userId, String activatePlayListId, String songId) {
        User user=userMap.get(userId);
        user.setActivesong(Arrays.asList(activatePlayListId,songId));
        userMap.put(userId, user);

    }
}
