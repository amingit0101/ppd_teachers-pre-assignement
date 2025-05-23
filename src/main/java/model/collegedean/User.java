package model.collegedean;

import service.collegedean.*;

public class User {
    private static int id = 0;
    private String password;
    private int user_type;
    private int persone_id ; 
    Managment_Class manager = new Managment_Class() ; 
    // Constructor
    public User(String password, int user_type,int persone_id) {
        id = manager.getLastUserID() ; 
        id++;
        this.id = id;
        this.password = password;
        this.user_type = user_type;
        this.persone_id = persone_id ; 
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUser_type() {
        return user_type;
    }
    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public int getPersone_id() {
        return persone_id;
    }

    public void setPersone_id(int persone_id) {
        this.persone_id = persone_id;
    }

}
