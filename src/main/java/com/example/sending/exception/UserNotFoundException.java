package com.example.sending.exception;

public class UserNotFoundException extends BaseNotFoundException{

    private static final String USER_NOT_FOUND = "Пользователь с таким email %s не найден";

    protected UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException createByName (String name){
        String message = String.format(USER_NOT_FOUND, name);
        return new UserNotFoundException(message);
    }
}
