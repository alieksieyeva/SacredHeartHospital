package com.generation.main;

import java.time.LocalDate;

import com.generation.entities.Doctor;
import com.generation.entities.Employee;
import com.generation.entities.StaffMember;
import com.generation.library.List;

public class MainLiskov
{
  
    private static List <Employee> content = new List<Employee>();
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

    }


}
