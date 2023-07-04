package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.UserService;

public class CreateUserCommand implements ICommand{
    private final UserService userService;
    

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(userService.create(tokens.get(1)));
        
    }
    
}
