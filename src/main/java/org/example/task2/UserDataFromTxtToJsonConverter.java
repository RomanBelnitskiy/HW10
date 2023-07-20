package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static org.example.utils.FileUtils.loadDataFromFile;
import static org.example.utils.FileUtils.writeDataToFile;

public class UserDataFromTxtToJsonConverter {
    public void convert(String fileName) {
        String[] loadedData = loadDataFromFile(fileName);
        if (loadedData.length <= 1) {
            return;
        }

        User[] users = createUsersFromStrings(loadedData);
        String jsonData = convertToJson(users);

        String jsonFileName = fileName.replace(".txt", ".json");
        writeDataToFile(jsonFileName, jsonData);
    }

    private String convertToJson(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }

    private User[] createUsersFromStrings(String[] usersData) {
        User[] users = new User[usersData.length - 1];
        for (int i = 1; i < usersData.length; i++) {
            String[] data = usersData[i].split(" ");

            String userName = data[0].trim();
            int userAge = Integer.parseInt(data[1].trim());
            User user = new User(userName, userAge);

            users[i - 1] = user;
        }

        return users;
    }

    public static void main(String[] args) {
        UserDataFromTxtToJsonConverter converter = new UserDataFromTxtToJsonConverter();
        converter.convert("./files/user.txt");
    }
}
