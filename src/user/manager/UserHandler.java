package user.manager;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class UserHandler {
    /**
     * Using ObjectOutputStream this will save all the users to the file in location "saves/users.sav"
     * @param users The ArrayList of users to save
     */
    public static void saveUser(ArrayList<User> users) {
        try {
            ObjectOutputStream userSaver = new ObjectOutputStream(new FileOutputStream("saves/users.sav"));
            userSaver.writeObject(users);
            userSaver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using ObjectInputStream it will load all the files from "saves/users.sav"
     * @return Will return an ArrayList loaded with all the users that have played the game
     */
    public static ArrayList<User> loadUser() {
        if (!new File("saves/users.sav").exists()) return null;

        ArrayList<User> users = null;
        try {
            ObjectInputStream f = new ObjectInputStream(new FileInputStream("saves/users.sav"));
            users = (ArrayList<User>) f.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * This will be used with the UI so that the user doesn't create a profile with the same name
     * @param users The ArrayList of users to be checked
     * @param name The new name to be inserted into the ArrayList
     * @return A boolean that checks if a user with that name already exists
     */
    public static boolean nameExists(ArrayList<User> users, String name) {
        for (User user : users) {
            if (user.getCharacterName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}
