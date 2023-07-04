package com.crio.jukebox.appConfig;
import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreatePlayListCommand;
import com.crio.jukebox.commands.CreateSongCommand;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.DeletePlayListCommand;
import com.crio.jukebox.commands.LoadDataCommand;
import com.crio.jukebox.commands.ModifyPlayListCommand;
import com.crio.jukebox.commands.PlayPlayListCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.services.IPlayListService;
import com.crio.jukebox.services.LoadDataService;
import com.crio.jukebox.services.PlayListService;
import com.crio.jukebox.services.UserService;

public class ApplicationConfig {
    //Repository
    private final SongRepository songRepository=new SongRepository();
    private final UserRepository userRepository=new UserRepository();
    private final PlayListRepository playListRepository=new PlayListRepository();
    
    //Service
    private final LoadDataService loadDataService= new LoadDataService(songRepository);
    private final UserService userService=new UserService(userRepository,playListRepository,songRepository);
    private final IPlayListService iplayListService=new PlayListService(userRepository, playListRepository, songRepository);
    private final PlayListService playListService=new PlayListService(userRepository, playListRepository, songRepository);
    //Command
    private final LoadDataCommand loadDataCommand=new LoadDataCommand(loadDataService);
    private final CreateUserCommand createUserCommand=new CreateUserCommand(userService);
    private final CreatePlayListCommand createPlayListCommand=new CreatePlayListCommand(iplayListService);
    private final DeletePlayListCommand deletePLayListCommand=new DeletePlayListCommand(playListService);
    private final PlayPlayListCommand playPlayListCommand=new PlayPlayListCommand(playListService);
    private final ModifyPlayListCommand modifyPlayListCommand=new ModifyPlayListCommand(playListService);
    private final PlaySongCommand playSongCommand=new PlaySongCommand(userService);

    //commandInvocer
    private final CommandInvoker commandInvoker = new CommandInvoker();

    //Register All The Command To commandInvocer
    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("LOAD-DATA",loadDataCommand);
        commandInvoker.register("CREATE-USER",createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST",createPlayListCommand);
        commandInvoker.register("DELETE-PLAYLIST",deletePLayListCommand);
        commandInvoker.register("PLAY-PLAYLIST",playPlayListCommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyPlayListCommand);
        commandInvoker.register("PLAY-SONG",playSongCommand);
        return commandInvoker;
    }

}
