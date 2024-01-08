package com.generation.main;

import java.time.LocalDate;

import com.generation.entities.Doctor;
import com.generation.entities.Patient;
import com.generation.entities.Person;
import com.generation.entities.StaffMember;
import com.generation.library.Console;
import com.generation.library.List;

public class MainEsercizietto 
{
    private static List <Person> content = new List<Person>(); //questa sarà una lista polimorfica

	private static void init()
	{
		StaffMember s1 = new StaffMember(1,"Pedro", "Concuglia", LocalDate.of(1994, 01, 06), 1300, 14, "nurse", "conc@gmail.com", "ER");
		StaffMember s2 = new StaffMember(2,"Manuel", "Caniva", LocalDate.of(1990, 03, 06), 1350, 14, "nurse", "manu@gmail.com", "ER");
		StaffMember s3 = new StaffMember(3,"Giorgio", "Barbieri", LocalDate.of(1987, 03, 04), 1500, 13, "accountant", "gio@gmail.com", "administration");
		StaffMember s4 = new StaffMember(4,"Cettina", "Barbieri", LocalDate.of(1980, 9, 10),  1700, 13, "dean of medicine", "cetti@gmail.com", "administration");
		Doctor d1 = new Doctor(5, "Gregory","House",LocalDate.of(1980, 07, 20), 5000,14, 200);
		Doctor d2 = new Doctor(6, "Allison", "Cameron",LocalDate.of(1991, 05, 06), 2000,14,1500);
		Doctor d3 = new Doctor(7,"Eric", "Forman", LocalDate.of(1963, 03, 05), 3000, 14,250);
		Patient p1 = new Patient(8,"Stefano", "Rubinetti", LocalDate.of(1995, 8, 27), new List<String>("javaite","battute Brutte") ,false);
        Patient p2 = new Patient(9,"Ferdinando", "Primerano", LocalDate.of(1980, 1, 1), new List<String>("javaite","dimentica date di compleanno") ,false);

        
        
        content.add(s1);//aggiungo staffmember
		content.add(s2);
		content.add(s3);
		content.add(s4);
		content.add(d1);//aggiungo dottori
		content.add(d2);
		content.add(d3); 
        content.add(p1);
        content.add(p2);

		// content --> lista polimorfica
	}

    public static void main(String[] args) 
    {
        Console.print(getPeopleOlderThan35());    //deve restituire tutte le persone nate prima del 1989
        Console.print(getPatientsWithJavaite()); //lista di paziente che hanno javaite tra le diagnosi
    }

    

    private static List<Person> getPeopleOlderThan35() {
        return null;
    }

    private static List<Patient> getPatientsWithJavaite() {
        return null;
    }
}
