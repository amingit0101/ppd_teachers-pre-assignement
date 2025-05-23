package model.collegedean;

import service.collegedean.*;

public class Departement_Dean {
    private static int  id = 0 ;
    private int personel_info;
    private int user_id ;
    Managment_Class manager = new Managment_Class() ; 
    // Constructor 
    public Departement_Dean() {
        id = manager.getLastIDepDeanID() ; 
        id++;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPersonel_info() {
        return personel_info;
    }
    public void setPersonel_info(int personel_info) {
        this.personel_info = personel_info;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    } 
    
}
