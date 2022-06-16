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
		int promotedStudents=0;
		
		System.out.println("Welcome to the student processing app.\nHow many students would you like to process?");
		int nStudents= Integer.parseInt(keyboard.nextLine()); //l'utente decide quanti studenti registrare
		
		Student[] students = new Student[nStudents];
		
		for (int i=0; i<students.length;i++)
		{
			int id= i+1;//id prograssivo dato dal vettore
			System.out.println("This student received id n° " +(i+1));
			System.out.println("Please insert how many days the student with id " +id+ " has been absent:");
			int absenceDays= Integer.parseInt(keyboard.nextLine()); //da input do il numero di giorni di assenza, non la percentuale
			System.out.println("Please insert the grade average of the student with id " +id);
			double average= Double.parseDouble(keyboard.nextLine());
			
			Student s = new Student(id, absenceDays, average);
			students[i]= s;
			
			if (students[i].isPromoted()) //calcolo numero di studenti promossi
				promotedStudents++;
			
		}
		
		
		
		for (int j=0; j<students.length;j++)
			System.out.println(students[j].toString());
		
		System.out.println("The total number of promoted students is: "+promotedStudents);
		
		keyboard.close();
	}

}
