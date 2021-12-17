package com.stockie;
import java.io.IOException;

public class Main {
    /*
     * Entry-Point und Main der gesamten Applikation.
     * */

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Starte Upload in die Datenbank Se2Projekt.");

        /**
         *
         * API CALLS AND UPLOAD TO THE MARIA DB
         *
         * */

        new DatabaseConnectorFactory();

    }
}
