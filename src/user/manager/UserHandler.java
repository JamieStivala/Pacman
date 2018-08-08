package user.manager;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class UserHandler {
    public static void saveUser(ArrayList<User> users) {
        try {
            ObjectOutputStream userSaver = new ObjectOutputStream(new FileOutputStream("saves/users.sav"));
            userSaver.writeObject(users);
            userSaver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static boolean nameExists(ArrayList<User> users, String name) {
        for (User user : users) {
            if (user.getCharacterName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}
