package com.JANA60.valutazioni.controller.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		/* Classe Main con metodo main in cui create un array di studenti 
		 * (i dati degli studenti possono essere chiesti all’utente oppure inseriti nel codice con dei valori di test). 
		 * L’id di ogni studente deve essere univoco nell’array (possiamo usare un numero progressivo). 
		 * Il programma deve poi stampare a video per ogni studente se è stato promosso o bocciato e quanti studenti sono stati promossi in tutto.
		 */

		Scanner keyboard = new Scanner(System.in);
		String repeat;
		
		do
		{
			int promotedStudents=0;
			
			System.out.println("Welcome to the student processing app.\nHow many students would you like to process?");
			int nStudents= Integer.parseInt(keyboard.nextLine()); //l'utente decide quanti studenti registrare
			
			Student[] students = new Student[nStudents];
			int absenceDays;
			double average;
			
			for (int i=0; i<students.length;i++)
			{
				int id= i+1;//id prograssivo dato dal vettore
				System.out.println("This student received id n° " +(i+1));
				do
				{
					System.out.println("Please insert how many days the student with id " +id+ " has been absent:");
					absenceDays= Integer.parseInt(keyboard.nextLine()); //da input do il numero di giorni di assenza, non la percentuale
					if(absenceDays<0 && absenceDays>Student.getSchooldays())
						System.out.println("A student can't be absent for more than " +Student.getSchooldays()+ " days.");
				}while(absenceDays<0 && absenceDays>Student.getSchooldays());
				do
				{
					System.out.println("Please insert the grade average of the student with id " +id);
					average= Double.parseDouble(keyboard.nextLine());
					if(average<0.0 && average > 5.0)
						System.out.println("GPA goes from 0 to 5, it can't be outside this range of values.");
				}while(average<0.0 && average > 5.0);
				
				Student s = new Student(id, absenceDays, average);
				students[i]= s;
				
				if (students[i].isPromoted()) //calcolo numero di studenti promossi
					promotedStudents++;
				
			}
			
			
			
			for (int j=0; j<students.length;j++)
				System.out.println(students[j].toString());
			
			System.out.println("The total number of promoted students is: "+promotedStudents);
		
			do
			{
				System.out.println("would you like to process more students?");
				
				repeat=keyboard.nextLine();
				
				if(!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("no"))
					System.out.println("Wrong input. Please insert yes or no.");
				
			}while(!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("no"));
		
		}while(!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("no"));
		
		keyboard.close();
	}

}
