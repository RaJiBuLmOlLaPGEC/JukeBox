package com.crio.jukebox.exception;

public class NoSuchCommandException extends RuntimeException{

    public NoSuchCommandException(){
        super();
    }
    public NoSuchCommandException(String s){
        super(s);
    }
}
