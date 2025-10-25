package net.biliarski.razhodi.service;


import net.biliarski.razhodi.dto.PersonDto;
import net.biliarski.razhodi.dto.UserDto;
import net.biliarski.razhodi.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

@Service
public class UserService {

    public List<UserDto> getUsers() {


        List<UserDto> users = new ArrayList<>();

       users.add(new UserDto( "user_id 1", "User 1", "username1 ", "user1@gmail.com"));
       users.add(new UserDto( "user_id 2", "User 2", "username2 ", "user2@gmail.com"));

        return users;
    }

    public List<UserDto> getUsersWithCapitalizedNamesAndMd5() {


//        List<UserDto> users = new ArrayList<>();
//        users.add(new UserDto("user_id 1", "User 1", "username1", "user1@gmail.com", "password1"));
//        users.add(new UserDto("user_id 2", "User 2", "username2", "user2@gmail.com", "password2"));

        List<UserDto> users = getUsers() ;

        List<UserDto> result = new ArrayList<>();
        for (UserDto user : users) {
            // Capitalize the name
            //String capitalized = capitalizeWords(user.getName());
            String capitalized =(user.getName().toUpperCase());

            // Compute MD5 of the capitalized name
            String md5 = md5Hex(capitalized);

            // Create a new UserDto or extend UserDto class to hold md5 if needed
            UserDto newUser = new UserDto(
                    user.getId(),
                    capitalized,
                    user.getUsername(),
                    user.getEmail().toUpperCase()
            );
            // Add md5 as an additional property or handle differently as per your UserDto design

            // Example if UserDto has setMd5 method or md5 field (add to UserDto accordingly)
            // newUser.setMd5(md5);

            result.add(newUser);
        }
        return result;
    }

    /************* Utils *************/

    private String md5Hex(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            return byteArray2Hex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String byteArray2Hex(final byte[] hash) {
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }
    }

    public List<UserResponse> getUsersWithAddress() {


        List<UserDto> users = getUsers();
        List<UserResponse> result = new ArrayList<>();

        for (UserDto user : users) {


            result.add(new UserResponse(
                    user.id
                    ,user.name
                    ,user.username
                    ,user.email
                    ,"Sofia 1000" //"Sofia 1000";
                    ,"088 1234" //user.phone = phone; //"088 1234";
                    ,"Sofia City" //user.city = city; // "Sofia";
                ));
        }
        System.out.println(result);
         return result;
    }

    public List<PersonDto> getDummyData() {




        ArrayList<PersonDto> result = new ArrayList<>();
        PersonDto oo = new PersonDto("Hello", "World");
        oo.name = "Hello0";
        oo.address = "World";
        result.add(oo);

        result.add(new PersonDto("Miro", "Sofia 2000"));
        result.add(new PersonDto("Mia", "Sofia 1000"));

        return result;
    }
}


