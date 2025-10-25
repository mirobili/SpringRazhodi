package net.biliarski.razhodi.dto.response;

public class UserResponse {

        public String id;
        public String name;
        public String username;
        public String email;
        public String password;
        public String address;
        public String phone;
        public String city;


        public UserResponse(String id, String name, String username, String email, String address, String phone, String city) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.address = address; //"Sofia 1000";
            this.phone = phone; //"088 1234";
            this.city = city; // "Sofia";
        }

}
