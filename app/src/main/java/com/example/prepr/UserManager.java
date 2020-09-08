package com.example.prepr;

import android.content.Context;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UserManager {

    private static ArrayList<User> users = new ArrayList<>();

    private ArrayList<String> userData = new ArrayList<>();
    private HashMap<User, Integer> userStates = new HashMap<>();
    static Context context;

    public static void makeList(){
        try(Scanner scanner = new Scanner(context.openFileInput("users.txt"))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                users.add(new User(data));
            }
        }
        catch (IOException e){}
    }

    static boolean authenticate(String user, String pass){
        for(User u: users){
            if(u.userName.equals(user) && u.password.equals(pass)){
                return true;
            }
        }
        return false;
    }

    public UserManager(Context context){
        this.context = context;

        makeList();
    }

    static boolean checkExists(String user){
        for(User u:users){
            if (u.userName.equals(user)){
                return true;
            }
        }
        return false;
    }
    
    static void addUser(String user, String pass){
        PrintWriter out = null;

        try{
            OutputStream outStream = context.openFileOutput("users.txt", Context.MODE_APPEND);
            out = new PrintWriter(outStream);

        } catch (FileNotFoundException e){}

        out.append(user +" " + pass +" SS\n");
        out.close();

        String[] info ={user, pass, "SS"};
        users.add(new User(info));

    }
}
