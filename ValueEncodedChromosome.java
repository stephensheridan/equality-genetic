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
		
		fitness = 1000; // High number equals low fitness

		// Create the gene array
		genes = new int[length];
							
		// Initialises the genes to random values between 1 - 30
		Random r = new Random();
		for(int i = 0; i < length; i++){			
			genes[i] = r.nextInt(upper_bound - 1) + 1;
		}
	}
	// Returns gene value at given locus
	public int getGeneAt(int pos){
		return genes[pos];
	}
	// Used for changing a gene value at given locus in chromosome
	public void setGeneAt(int pos, int val){
		genes[pos] = val;
	}
	// Will mutate a gene at given locus based on random value between 1 and upper_bound
	public void mutateGeneAt(int pos){
		Random r = new Random();
		genes[pos] = r.nextInt(upper_bound - 1) + 1;
	}
	// Sets the chromosome length
	public void setLength(int length){
		this.length = length;
	}
	// Returns the length of a chromosome
	public int getLength(){
		return length;
	}
	// Sets the fitness value for a chromosome
	public void setFitness(int fitness){
		this.fitness = fitness;
	}
	// Returns the fitness value for a chromosome
	public int getFitness(){
		return fitness;
	}
	// Used to compare chromosomes in order to remove duplicates
	// Compare this chromosome against argument c
	public boolean equals(ValueEncodedChromosome c){
		boolean same = true;
		for(int i = 0; i < length && same == true; i++){
			same = genes[i] == c.getGeneAt(i);
		}
		return same;
	}
	// Helps to show chromosome values on screen
	public String toString(){
		String s = "";
		for(int i = 0; i < length; i++){
			s = s + genes[i] + " ";
		}
		return s;
	}
	public int func(){
		int func = Math.abs(genes[0] + (2*genes[1]) + (3*genes[2]) + (4*genes[3]));
		return func;
	}
	
}