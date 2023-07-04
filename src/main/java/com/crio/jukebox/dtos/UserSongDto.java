package com.crio.jukebox.dtos;

import java.util.List;

public class UserSongDto {
    private String userId;
    private String currentPLayListId;
    private String currentSongId;
    public UserSongDto(String userId, String currentPLayListId, String currentSongId) {
        this.userId = userId;
        this.currentPLayListId = currentPLayListId;
        this.currentSongId = currentSongId;
    }
    
    public UserSongDto() {}

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCurrentPLayListId() {
        return currentPLayListId;
    }
    public void setCurrentPLayListId(String currentPLayListId) {
        this.currentPLayListId = currentPLayListId;
    }
    public String getCurrentSongId() {
        return currentSongId;
    }
    public void setCurrentSongId(String currentSongId) {
        this.currentSongId = currentSongId;
    }
    
}
