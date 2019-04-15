package com.company;
import it.sauronsoftware.ftp4j.*;
import java.util.*;

public class Main {
    public static void main (String[] args){
        int i;
        FTPClient client = new FTPClient();
        Menu menu = new Menu(client);
        Scanner scan = new Scanner(System.in);
        try{
            client.connect("www.mehmetb1r.com");
            client.login("Kullanıcı Adı","Şifre");
            client.setPassive(false); 
            while(true){
                menu.yazdir();
                i = scan.nextInt();
                if(i==8) { break; }  else { menu.yaptir(i); }
            }
            System.out.println("Bağlantı Kapandı");
            client.disconnect(true);
            }
        catch (Exception e) {
            e.printStackTrace();
            }
    }
}
