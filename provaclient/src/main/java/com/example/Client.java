package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);

        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // per la tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("Eccomi");
        System.out.println(br.readLine()); // rivevo: benvenuti dammi il tuo nome
        pr.println(tastiera.readLine()); //! invio da tastiera il nome 
        System.out.println(br.readLine()); //? ricevo: il nome e il numero del client ricevuti in quella sessione
        System.out.println(br.readLine()); //* rivevo i saluti dal server*/

        s.close();
    }
}
