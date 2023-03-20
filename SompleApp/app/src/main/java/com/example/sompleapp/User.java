package com.example.sompleapp;

public class User {

    int _id;
    String _name;
    String _email;

    User(){}

    User(int _id,String _name,String _email){

        this._id = _id;
        this._name = _name;
        this._email = _email;


    }

    User(String _name,String _email){
         this._name = _name;
         this._email = _email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}
