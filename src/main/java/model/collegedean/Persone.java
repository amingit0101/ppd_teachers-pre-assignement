package model.collegedean;

import java.time.LocalDate;


import service.collegedean.*;

public class Persone {
    private static int id =0; 
    private String nome;
    private String Phone;
    private String email;
    private LocalDate bithday;
    private int deplome_id ;
    Managment_Class manager = new Managment_Class() ; 
    // Constructor  
    public Persone(String nome, String phone, String email, LocalDate bithday, int deplome_id) {
        id = manager.getLastPersoneID() ; 
        id++ ;
        this.id = id;
        this.nome = nome;
        this.Phone = phone;
        this.email = email;
        this.bithday = bithday;
        this.deplome_id = deplome_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getBithday() {
        return bithday;
    }
    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }
    public int getDeplome_id() {
        return deplome_id;
    }
    public void setDeplome_id(int deplome_id) {
        this.deplome_id = deplome_id;
    } 
    
}
