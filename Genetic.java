// Integer based, value encoded chromosome
// S. Sheridan 27/02/2014
// TU Dublin - Blanchardstown Campus

import java.io.*;
import java.util.*;

public class Genetic {
	
	private static  int POPULATION_SIZE = 10; 			// No. of chromosomes in the population
	private static  int CHROMOSOME_LENGTH = 4; 		// No. of genes per chromosome (Problem dependent!! a +2 b +3 c +4 d = 30)
    private static  float CROSSOVER_FRACTION = 0.5f; 	// Half population is recombined every evolution
    private static  float MUTATION_FRACTION = 0.1f; 	// 10% of populaiton is mutated
	private static  int NUM_GENERATIONS = 200; 		// Max number of generations to run for
	
	private static void arguments(String[] args){
		switch(args.length){
			case 0:
				// Take the default arguments
				System.out.println("Usage: java Genetic [INT NUM GENERATIONS] {INT POPULATION SIZE} {FLOAT CROSSOVER FRACTION} {FLOAT MUTATION FRACTION}");
				System.exit(0);
			case 1:
				// Number of generations
				NUM_GENERATIONS = Integer.parseInt(args[0]);
				break;
			case 2:
				// Generations, population size
				NUM_GENERATIONS = Integer.parseInt(args[0]);
				POPULATION_SIZE = Integer.parseInt(args[1]);
				if (POPULATION_SIZE < 10){System.out.println("Error: Population size must be > 10");System.exit(0);}
				break;
			case 3:
				// Generations, population size, crossover_fraction
				NUM_GENERATIONS = Integer.parseInt(args[0]);
				POPULATION_SIZE = Integer.parseInt(args[1]);
				CROSSOVER_FRACTION = (float)Double.parseDouble(args[2]);
				if (POPULATION_SIZE < 10){System.out.println("Error: Population size must be > 10");System.exit(0);}
				break;
			case 4:
				// Generations, population size, crossover_fraction
				NUM_GENERATIONS = Integer.parseInt(args[0]);
				POPULATION_SIZE = Integer.parseInt(args[1]);
				CROSSOVER_FRACTION = (float)Double.parseDouble(args[2]);
				MUTATION_FRACTION = (float)Double.parseDouble(args[3]);
				if (POPULATION_SIZE < 10){System.out.println("Error: Population size must be > 10");System.exit(0);}
		}
		
	}

	public static void main(String[] args){

		// Check the command line for parameters
		arguments(args);

		// Create a population using fixed parameters
		Population p = new Population(POPULATION_SIZE, CHROMOSOME_LENGTH, CROSSOVER_FRACTION, MUTATION_FRACTION);

		// Run the genetic algorithm over NUM_GENERATIONS or until it has converged on a solution
		System.out.println("Solve a + 2b + 3c + 4d = 30");
		for(int gen = 0; gen < NUM_GENERATIONS && !p.converged(); gen++){
			System.out.println("*** Generation " + gen + " ***");
			p.evolve(true); // true passed to display population
		}
	}
}
