// Integer based, value encoded chromosome
// S. Sheridan 27/02/2014
// Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class ValueEncodedChromosome{
		
	private int[] genes;			// Chromosome genes
	private int upper_bound;		// Upper bound for randomising
	private int length;				// Chromosome length
	private int fitness;			// Fitness value for chromosome

	public ValueEncodedChromosome(int length, int upper_bound){
		this.length = length;
		this.upper_bound = upper_bound;
		
		//TODO
		// Initialise fitness to high number. Bad fitness to start with
		// Create the gene array based on length
		// Initialises the genes to random values between 1 - upper_bound, 30 in this case
	}
	
	// Returns gene value at given locus
	public int getGeneAt(int pos){
		//TODO
	}
	
	// Used for changing a gene value at given locus in chromosome
	public void setGeneAt(int pos, int val){
		//TODO
	}
	
	// Will mutate a gene at given locus based on random value between 1 and upper_bound
	public void mutateGeneAt(int pos){
		//TODO
	}
	
	// Sets the chromosome length
	public void setLength(int length){
		//TODO
	}
	
	// Returns the length of a chromosome
	public int getLength(){
		//TODO
	}
	
	// Sets the fitness value for a chromosome
	public void setFitness(int fitness){
		//TODO
	}
	
	// Returns the fitness value for a chromosome
	public int getFitness(){
		//TODO
	}
	
	// Used to compare chromosomes in order to remove duplicates
	// Compare this chromosome against argument c
	public boolean equals(ValueEncodedChromosome c){
		//TODO
	}
	
	// Helps to show chromosome values on screen
	public String toString(){
		//TODO
	}
}