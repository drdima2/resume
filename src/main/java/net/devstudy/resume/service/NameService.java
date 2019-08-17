package net.devstudy.resume.service;

public class NameService {
    public static NameService getInstance(){
        return new NameService();
    }

    private NameService(){

    }


    public String convertName(String name){
        return name.toUpperCase();
    }
}
