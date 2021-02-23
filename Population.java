// Genetic algorithm for solving a +2b + 3c + 4d = 30
// S. Sheridan 27/02/2014
// TU Dublin - Blanchardstown Campus
// Code based on Mark Watsons Genetic Algorithm code
// https://github.com/mark-watson/Java-AI-Book-Code/tree/master/genetic-algorithms

import java.io.*;
import java.util.*;

public class Population{
	
	private int population_size;					// Number of chromosomes in population
	private int chromosome_length;					// Number of genes per chromosome
	
	private ValueEncodedChromosome[] population;	// Array to store chromosome objects
	
    private int [] rouletteWheel;					// Used for selecting parents
    private int rouletteWheelSize;					// Size of roulette wheel
	
    private float crossoverFraction;				// Control how many offspring will be created via crossover
    private float mutationFraction;					// Control the amount of mutation per evolution
	
			
	public Population(int population_size, int chromosome_length, float crossoverFraction, float mutationFraction){
		this.population_size = population_size;
		this.chromosome_length = chromosome_length;
		this.crossoverFraction = crossoverFraction;
		this.mutationFraction = mutationFraction;
		
		// Create the population of chromosomes
		population = new ValueEncodedChromosome[population_size];
		
		// Randomise the population
		initialisePopulation();
		
        // Build a roulette wheel array for selecting parents
		buildRouletteWheel();
	}
	// Randomise the population
	public void initialisePopulation(){
		// Create an array of integer based value encoded chromosomes
		// Each chromosome will have an initial random value between 1 - 30
		// This initial random value is problem dependent
		for(int i = 0; i < population_size; i++){
			population[i] = new ValueEncodedChromosome(chromosome_length, 30);
		}
	}
	public void buildRouletteWheel(){
        // Build a roulette wheel array for selecting parents
		rouletteWheelSize = 0;
        for (int i=0; i < population_size; i++){
 	   		rouletteWheelSize += i + 1;
        }
        rouletteWheel = new int[rouletteWheelSize];
        int num_trials = population_size;
        int index = 0;
        for (int i=0; i<population_size; i++){
 		   for (int j=0; j<num_trials; j++){
 			   rouletteWheel[index++] = i;
 		   }
 		   num_trials--;
        }
	}
	// Set the population size
	public void setPopulationSize(int size){
		population_size = size;
	}
	// Set the crossover fraction
	public void setCrossoverFraction(float cf){
		crossoverFraction = cf;
	}
	// Set the mutation fraction
	public void setMutationFraction(float mf){
		mutationFraction = mf;
	}
	// Return a chromosome at given position in population
	public ValueEncodedChromosome getChromosomeAt(int pos){
		return population[pos];
	}
	// Set the value of a chromosome at given position in population
	public void setChromosomeAt(int pos, ValueEncodedChromosome c){
		population[pos] = c;
	}
	// Return the size of the population
	public int getSize(){
		return population_size;
	}
	// Return fitness for given set of values based on a +2 b +3 c +4 d = 30
	// The closer a + 2*b + 3*c + 4*d is to 30 the lower the difference, therefore fitness is high
	public int fitness(int a, int b, int c, int d){
		// Calculate the difference between chromosome solution and required equivalance of 30
		int f = Math.abs(( a + (2*b) + (3*c) + (4*d) ) - 30);
		return f;
	}
	
	// If the fitness for the top chromosome is zero then we 
	// have found a solution to a +2 b +3 c +4 d = 30
	public boolean converged(){
		return (population[0].getFitness() == 0);
	}
	// Swap populaiton members
	public void swap(int i, int k){
		ValueEncodedChromosome temp;
		temp = population[i];
		population[i] = population[k];
		population[k] = temp;
	}
	// Sort the population based on their fitness ASCENDING (lower number better fitness)
	public void sort(){
		// Selection sort - Ooops should do better
  		for(int i = 0; i < population_size; i++){
  			int k = i;
  			for(int j = i + 1; j < population_size; j++){
  				if (population[j].getFitness() < population[k].getFitness())
  					k = j;
  			}
  			swap(k, i);
  		}
	}
	
 	// Set the fitness function for each populaiton member
 	public void evaluate(){
		int a, b, c, d;
 		for(int j = 0; j < population_size; j++){
 			a = population[j].getGeneAt(0); // a
 			b = population[j].getGeneAt(1); // b
 			c = population[j].getGeneAt(2); // c
 			d = population[j].getGeneAt(3); // d
 			population[j].setFitness(fitness(a,b,c,d));
 		}
 	}
	
	// Select and combine genetic material
	public void crossover(){
       int num = (int)(population_size-(population_size * crossoverFraction));
	   // Upper % of the population will be effected by crossover
	   //for (int i=0; i < num; i++){
	   // Bottom % of the population will be effected by crossover
	   for (int i=num; i < population_size; i++){
		   // Select two parents using roulette wheel 	
 		  int c1 = (int)(rouletteWheelSize * Math.random() * 0.9999f);
 		  int c2 = (int)(rouletteWheelSize * Math.random() * 0.9999f);
 		  c1 = rouletteWheel[c1];
 		  c2 = rouletteWheel[c2];
		  if (c1 != c2){
 			  // Perform single point crossover
			  int locus = 1 + (int)((chromosome_length - 2) * Math.random());
			  for (int g=0; g < chromosome_length; g++){
 				  if (g < locus)
 				  	population[i].setGeneAt(g, population[c1].getGeneAt(g)); // Copy from parent c1 up to locus g
 				  else
 				    population[i].setGeneAt(g, population[c2].getGeneAt(g)); // Copy from parent c2 after locus g
 			  }
 		  }
       }
     }
	 // Carry out mutation on population	 
     public void mutate(){
	   int num = (int)(population_size * mutationFraction);
	   // Loop through a number of chromosomes to mutate
	   for (int i=0; i<num; i++){
 		  int c = (int)(population_size * Math.random() * 0.99); 	// Random chromosome
 		  int g = (int)(chromosome_length * Math.random() * 0.99);	// Random gene
		  population[c].mutateGeneAt(g);
       }
     }
	 // Remove any duplicate chromosomes from population to prevent stagnation
     public void removeDuplicates(){
 		for (int i=population_size - 1; i>3; i--){
			// i>3 dont touch the top of the population
 			for (int j=0; j<i; j++){
 				if (population[i].equals(population[j])){
 					int g = (int)(chromosome_length * Math.random() * 0.99);
					population[i].mutateGeneAt(g);
					break;
 				}
 			}
 		}
     }
	 // Called to envoke one complete evolution		 
     public void evolve(boolean display){
  	   evaluate();
  	   sort();
	   if (display)
	   	display();
	   crossover();
  	   mutate();
  	   removeDuplicates();
     }
	 public void display(){
  		for(int j = 0; j < population_size; j++){
			System.out.println("Chromosome[" + j + "] = " + population[j].toString() + "\tFunc val = " + population[j].func() + "\tFitness = " + population[j].getFitness());  		}
	 }
	
}
