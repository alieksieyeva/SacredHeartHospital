package com.generation.main;

import java.time.LocalDate;

import com.generation.entities.Doctor;
import com.generation.entities.Employee;
import com.generation.entities.StaffMember;
import com.generation.library.Console;
import com.generation.library.List;

public class MainLiskov
{
  //PRINCIPIO DI SOSTITUZIONE DI LISKOV
  //UN SUPERTIPO può essere SOSTITUITO DA QUALSIASI SUO SOTTOTIPO
  //SEMPRE
    private static List <Employee> content = new List<Employee>(); //questa sarà una lista polimorfica

	private static void init()
	{
		StaffMember s1 = new StaffMember(1,"Pedro", "Concuglia", LocalDate.of(1994, 01, 06), 1300, 14, "nurse", "conc@gmail.com", "ER");
		StaffMember s2 = new StaffMember(2,"Manuel", "Caniva", LocalDate.of(1990, 03, 06), 1350, 14, "nurse", "manu@gmail.com", "ER");
		StaffMember s3 = new StaffMember(3,"Giorgio", "Barbieri", LocalDate.of(1987, 03, 04), 1500, 13, "accountant", "gio@gmail.com", "administration");
		StaffMember s4 = new StaffMember(4,"Cettina", "Barbieri", LocalDate.of(1980, 9, 10),  1700, 13, "dean of medicine", "cetti@gmail.com", "administration");
		Doctor d1 = new Doctor(5, "Gregory","House",LocalDate.of(1980, 07, 20), 5000,14, 200);
		Doctor d2 = new Doctor(6, "Allison", "Cameron",LocalDate.of(1991, 05, 06), 2000,14,1500);
		Doctor d3 = new Doctor(7,"Eric", "Forman", LocalDate.of(1963, 03, 05), 3000, 14,250);
		//content è una lista che ha il contenuto polimorfico in quanto Employee può prendere più forme diverse
		content.add(s1);//aggiungo staffmember
		content.add(s2);
		content.add(s3);
		content.add(s4);
		content.add(d1);//aggiungo dottori
		content.add(d2);
		content.add(d3); 
		// content --> lista polimorfica
		
		
	}

    public static void main(String[] args) 
    {
        init();

        //dobbiamo trovare tutti gli impiegati che prendono 14 mensilità
       // Console.print(findEmployesQuatordicesima());
       //printSuspectsDoctors();
       
       //StaffMember s1 = new StaffMember(1,"Pedro", "Concuglia", LocalDate.of(1994, 01, 06), 1300, 14, "nurse", "conc@gmail.com", "ER");

       // s1 instanceof StaffMember --> Vero o Falso? -> VERO
       // s1 instanceof Doctor --> Vero o Falso? -> FALSO
       // s1 instanceof Employee --> Vero o Falso? -> VERO
       // s1 instanceof Person --> Vero o Falso? -> VERO
       // s1 instanceof Patient --> Vero o Falso? -> False
       //instanceof da TRUE se l'oggetto in memoria è CASTABILE al TIPO SPECIFICATO
       //istanceof -> traducibile con is_a
        Console.print(dammiSoloDottori());
    }
    
    public static List <Employee> findEmployesQuatordicesima()
    {
        List <Employee> result = new List <Employee>();
        for (Employee e: content)
            if(e.getnMonths()==14)
            result.add(e);

        return result; 
    }

    public static void printSuspectsDoctors()
    {
        for(Employee e: content)
        {   // la variabile "e" è di tipo Employee
            // e.getSalaryBonus() dà errore, non è definito per classe Employee
            // Doctor d = (Doctor) e;
            // Console.print(d.getSalaryBonus());  --eccezione
            //OPERATORE instanceof
            if(e instanceof Doctor)
            {   
                Doctor d = (Doctor) e;
                if(d.getSalaryBonus()>1000)
                    Console.print("Da attenzionare!\n"+d.toString());
            } 
                
            //è una VERGOGNA fare DOWNCASTING senza prima aver controllato di poterlo fare tramite un istanceof

            //if(a instanceof CLASSE)
            //{
            //     Classe o = (Classe)a;
            //}

            //SAFE-CASTING

            //COME DICEVANO ALLE SUPERIORI
            //MI RACCOMANDO, fate solo CASTING PROTETTO
        }

        
    }
    //abbiamo una lista POLIMORFICA chiamata content, che contiene Doctor e StaffMember
    //se vogliamo ottenere una lista di soli dottori (o di solo staff)

    public static List<Doctor> dammiSoloDottori()
    {
        List<Doctor> res  =  new List<Doctor>();

        for(Employee e: content)
            if(e instanceof Doctor)
                res.add((Doctor)e);
        return res;
    }


}
