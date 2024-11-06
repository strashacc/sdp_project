package com.openlibrary.library;

public class User {
    private int id;
    private String firstName, lastName, email, password;
    private boolean administrator;

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
