package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    public int x;

    public ClientHandler(Socket s,int y) {
        x=y;
        this.s = s;
        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {

            System.out.println(br.readLine());
            pr.println("Ciao come ti chiami?"); // invio messaggio
            String nome = br.readLine(); //? ricevo: il nome
            String nomeM = nome.toUpperCase(); //! conversione in maiuscolo
            System.out.println("Utente "+nomeM);
            pr.println("Benvenuto "+ nomeM+" sei l'utente numero "+ x); // invio messaggio
            
            pr.println("Ciao "+ nomeM +" piacere di averti conosciuto, alla prossima!!"); // invio il bmi
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
