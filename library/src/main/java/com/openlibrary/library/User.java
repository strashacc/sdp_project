package com.openlibrary.library;

public class User {
    private int id;
    private String firstName, lastName, email, password;
    private boolean administrator;

    public User(String first_name, String last_name, String email){
        this.firstName = first_name; 
        this.lastName = last_name; 
        this.email = email;
        this.id = 0;
        for(int i = 0; i < this.email.length(); ++i){
            this.id *= 10;
            this.id += this.email.charAt(i);
            System.out.println(id);
        }
    }
    public User(UserBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.administrator = builder.administrator;
        this.password = builder.password;
    }
    public int getId() {
        return id;
    }
    public String getFirst_name() {
        return firstName;
    }
    public String getLast_name() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public boolean isAdministrator() {
        return administrator;
    }
    public static void main(String[] args){
        User user0 = new User("Sayan", "Aukatov", "sayantrashacc@gmail.com");
        User user1 = new User("Jaslan", "Aukatov", "saymonauk@gmail.com");

        System.out.println(user0.getId());
        System.out.println(user1.getId());
    }

    public  class UserBuilder{
        private String firstName, lastName, email, password;
        private boolean administrator;

        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public UserBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public UserBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public UserBuilder setAdministrator(boolean administrator){
            this.administrator = administrator;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
