package com.LoginOdev.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
public class Login {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String GetUser(){
        return "giris yapılamadı";
    }
    ArrayList<Users> usrlst = new ArrayList<Users>();
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String PostUser(@ModelAttribute("login") Users usrq){

        Users usr = new Users();
        usr.setUname("burak");
        usr.setPasswd("pass");
        Users usr2 = new Users();
        usr2.setUname("deneme");
        usr2.setPasswd("pass");

        usrlst.add(usr);
        usrlst.add(usr2);

        boolean isSuccess = false;

        for (Users liste: usrlst){
            if (liste.getUname().equals(usrq.getUname()) && liste.getPasswd().equals(usrq.getPasswd())){
                isSuccess=true;
                break;
            }
        }
        if (isSuccess) return "giris yapıldı";
        else return "hata olustu";

    }

}
