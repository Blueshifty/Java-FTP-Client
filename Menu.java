package com.company;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;
import java.io.File;

import java.util.Scanner;

public class Menu {
    FTPClient client;
    Scanner scan = new Scanner(System.in);
    Menu(FTPClient client){
        this.client = client;
    }

    void yazdir() throws Exception {

            System.out.println("-----Dosya Islemleri-----");
            System.out.println("1- Dosya Indir");
            System.out.println("2- Dosya Yukle");
            System.out.println("3- Dosya Sil");
            System.out.println("-----Dizin Islemleri-----");
            System.out.println("4- Dizin Degistir");
            System.out.println("5- Dizin Yarat");
            System.out.println("6- Dizin Sil");
            System.out.println("-----Diger İslemler-----");
            System.out.println("7- Dizindeki Dosyaları Yazdır");
            System.out.println("8- Baglantiyi Kapat");
            System.out.println("Suan ki Dizin = " + client.currentDirectory());
            System.out.println("Yapmak Istediginiz Islemin Numarasini Giriniz:");

    }

    void yaptir(int i) throws Exception{
        String girdi;
        switch (i){
            case 1 :{
                System.out.println("Indirmek Istediginiz Dosyanın Adini Giriniz:");
                girdi = scan.nextLine();
                client.download(girdi, new File(girdi));
                break;
            }
            case 2 :{
                System.out.println("Yuklemek Istediginiz Dosyanın Adını Giriniz");
                girdi = scan.nextLine();
                client.append(new File(girdi));
                break;
            }
            case 3 :{
                System.out.println("Silmek Istediginiz Dosyanin Adini Giriniz:");
                girdi = scan.nextLine();
                client.deleteFile(girdi);
                break;
            }
            case 4 :{
                System.out.println("Gecmek Istediginiz Dizinin Adını Girin");
                girdi = scan.nextLine();
                client.changeDirectory(girdi);
                break;
            }
            case 5 :{
                System.out.println("Yaratmak Istediginiz Dizinin Adını Girin:");
                girdi = scan.nextLine();
                client.createDirectory(girdi);
                break;
            }
            case 6 :{
                System.out.println("Silmek Istediginiz Dizinin Yolunu  Giriniz:");
                girdi = scan.nextLine();
                client.deleteDirectory(girdi);
                break;
            }
            case 7 :{
                String[] list = client.listNames();
                for(int j = 0; j<list.length;++j){
                    System.out.println(list[j]+"\t");
                }
                break;
            }
            default:{
                System.out.println("Islem Numarası Girmeliydiziniz Menuye Donmek Icin Bir Tusa Basin\n");
            }
        }
    }
}
