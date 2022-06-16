package com.JANA60.valutazioni.controller.main;

public class Student 
{
	/*
	 * State costruendo un programma per un corso di studi.
	La valutazione complessiva viene fatta sulla percentuale di assenze (da 0 a 100) e sulla media dei voti (da 0 a 5):
- 	se lo studente ha fatto più del 50% di assenze è bocciato
- 	se ha fatto tra il 25% e il 50% di assenze è promosso solo se la media dei voti è superiore a 2
- 	se ha fatto meno del 25% di assenze è promosso se la media dei voti è superiore o uguale a 2


	Classe Studente con tre attributi: 
	id dello studente (intero), 
	percentuale assenze (intero), 
	media voti (numero decimale). 
	La classe deve avere un costruttore con parametri e anche un metodo che calcola, 
	in base a percentuale delle assenze e media dei voti, se lo studente è promosso o bocciato
	 */
	
	private static final int SCHOOLDAYS = 200; //il numero di giorni di scuola è un dato fisso, non variabile
	
	int id, absenceDays;
	double gradeAverage;
	
	Student(int i, int aD, double gA)
	{
		id=i;
		absenceDays=aD;
		gradeAverage=gA;
	}
	
	double getAbsencePercentage() //calcolo della percentuale di giorni di assenze usando i dati in mio possesso
	{
		return absenceDays * (100.0/SCHOOLDAYS);
	}
	
	boolean isPromoted() //è promosso se ha poche assenze o se ha un buon GPA
	{
		return getAbsencePercentage() >= 50
				||
				(
						getAbsencePercentage() >25 
						&&
						getAbsencePercentage() < 50
						&&
						gradeAverage > 2
				)
				||
				(
						getAbsencePercentage() <25
						&&
						gradeAverage > 2
				);
				
	}
	
	public String toString() //output diverso a seconda se è promosso o meno
	{
		String res="";
		
		if (isPromoted())
			res= "The student with ID number " +id+ " has been promoted, since he has a GPA of " +gradeAverage+ " points and was absent the " +getAbsencePercentage()+ "% of the total school days.";
		else
			res= "The student with ID number " +id+ " has failed, since he has a GPA of " +gradeAverage+ " points and was absent the " +getAbsencePercentage()+ " of the total school days.";

		return res;
	}

	public static int getSchooldays() {
		return SCHOOLDAYS;
	}
	
	
	
	
	
	
}
	