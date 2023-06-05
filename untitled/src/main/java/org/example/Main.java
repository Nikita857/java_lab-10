package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException{

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);

        User[] list = {new User("john", "jhon@gmail.com", "pass", 15),new User("max", "max@gmail.com", "pass1", 18),new User("oleg", "oleg@gmail.com", "pass2", 15),new User("nikita", "nikita@gmail.com", "pass3", 22)};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();


        User result = getUserByLoginAndPassword(login,password,list);

        validateUser(result);

        System.out.println("Доступ предоставлен");


    }
    public static User[] getUser(User[] list){
        return new User[]{list[0],list[1],list[2],list[3]};
    }
    public static User getUserByLoginAndPassword(String login, String password,User[] list) throws UserNotFoundException {
        User[] users = getUser(list);
        for (User user : users) {
        if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
            System.out.println("Пользователь найден");
            return user;
        }
        }

        throw new UserNotFoundException("User not found");
    }
    public static void validateUser(User user) throws AccessDeniedException{
        if(user.getAge()<18){
            throw new AccessDeniedException("Возраст менее 18 лет");
        }
    }

}