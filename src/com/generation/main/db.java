package com.generation.main;

import java.time.LocalDate;

public class db {
     private static String getMaxQuinquennio() 
    {
        int annoMinimo = getDobOldestStudent();
        //voglio che inizi o con 0 o con 5

        //immaginiamo che lo studente più vecchio sia del 1983
        //quale deve essere il mio anno di partenza?
        //1980
        //come faccio a farlo calcolare alla macchina?
        int annoPartenza = annoMinimo - annoMinimo%5;
        int annoMassimo = getDobYoungestStudent();
        int annoFine = annoMassimo + (annoMassimo%5==0 ? 0 : (5-annoMassimo%5)); //2004 -> 2002 + 2
        //stessa domanda di prima, il mio studente più giovane è del 2002, quale è il mio anno di fine?
        //2005
        //come lo ottengo

        //studente più vecchio nato nel 1982
        //studente più giovane nato nel 1991

        //1) inizio=1980
        //2) inizio=1985
        //3) inizio=1990
        //4) che non avviene, inizio sarebbe 1995, ma annoFine è 1995, quindi inizio<annoFine è false e il ciclo si ferma
        String quinquennioPiuProficuo = "";
        double massimoProfitto =0;
        for(int inizio=annoPartenza;inizio<annoFine;inizio+=5)
        {
            double guadagnoQuinquennio = 0;
            for(Partecipation p : partecipations)
            {
                Student s = p.getMyStudent();
                if(s.getDob().getYear()>=inizio && s.getDob().getYear()<(inizio+5))
                    guadagnoQuinquennio+=p.getPrice();
            }

            //ho calcolato quanto ho guadagnato, vediamo se è il quinquennio più proficuo
            if(guadagnoQuinquennio>massimoProfitto)
            {
                quinquennioPiuProficuo = inizio + "-"+(inizio+4)+" guadagnato "+guadagnoQuinquennio;
                massimoProfitto = guadagnoQuinquennio;
            }
        }

        return quinquennioPiuProficuo;
    }


    private static int getDobYoungestStudent() 
    {
         int maxDobYear = 0;//parto dal 0 d.c.

        for(Student s : students)
            if(s.getDob().getYear()>maxDobYear)
                maxDobYear = s.getDob().getYear();

        return maxDobYear;
    }

    private static int getDobOldestStudent() 
    {
        int minDobYear = LocalDate.now().plusYears(1).getYear();//parto dal 2025 d.c.

        for(Student s : students)
            if(s.getDob().getYear()<minDobYear)
                minDobYear = s.getDob().getYear();

        return minDobYear;
    }
    
}
