package com.generation.main;

import java.time.LocalDate;
import java.util.ArrayList;

import com.generation.entities.Doctor;
import com.generation.entities.Employee;
import com.generation.entities.Person;
import com.generation.entities.StaffMember;
import com.generation.library.Console;
import com.generation.library.List;

public class TestHospital {


    public static void main(String[] args) 
    {


        boolean goOn;
        String cmd ="";

        do
        {
            Console.print("Scrivi un commando da eseguire");
            cmd = Console.readString();
          

            switch(cmd) 
            {
                case "aggiungi paziente":     
                    Console.print(addParola());          
                break;                     

                case "stampa dottori":  
                    printAll();
                break;
                case "elimina paziente":
                    Console.print(removeOne());
                break;
                case "stampa persone"://nuovi metodi
                    Console.print(printPeople());
                break;
                case "stampa impiegati":
                    Console.print(printEmployees());
                break;
                case "stampa impiegati minRal":
                    Console.print(printEmployeeByMinRal());
                break;
                case "stampa stefani":
                    Console.print(printStefanos());
                break;
                case "dimmi cosa fa"://utente inserisce nome e cognome e diciamo 
                                    //cosa fa quella persona(è un paziente/staffMember o dottore)
                    Console.print(printRole());
                break;
                default:
                    Console.print("non abbiamo trovato il comando richiesto");
                break;
            }

            Console.print("Scrivi quit se vuoi uscire dal programma o premi invio per continuare");
            goOn = !Console.readString().equals("quit");


        }while(goOn);
    }

    }
}   