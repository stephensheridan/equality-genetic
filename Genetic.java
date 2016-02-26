// Integer based, value encoded chromosome
// S. Sheridan 27/02/2014
// Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class Genetic {
	
	private static final int POPULATION_SIZE = 10; 			// No. of chromosomes in the population
	private static final int CHROMOSOME_LENGTH = 4; 		// No. of genes per chromosome (Problem dependent!! a +2 b +3 c +4 d = 30)
    private static final float CROSSOVER_FRACTION = 0.5f; 	// Half population is recombined every evolution
    private static final float MUTATION_FRACTION = 0.1f; 	// 10% of populaiton is mutated
	private static final int NUM_GENERATIONS = 200; 		// Max number of generations to run for
	
	public static void main(String[] args){
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
