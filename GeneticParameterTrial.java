// Integer based, value encoded chromosome
// S. Sheridan 27/02/2014
// Institute of Technology Blanchardstown

import java.io.*;
import java.util.*;

public class GeneticParameterTrial {
	
	private static final int NUM_TRIALS = 10; // 10 trial values for each parameters, see trial arrays below
	private static final int NUM_GENERATIONS = 100; // Max number of generations to run for
	private static final int NUM_REPEATS = 10; // Repeat this number of times to get an average for a particular trial value
	private static final int CHROMOSOME_LENGTH = 4; // Fix chromosome length at 4 a,b,c,d values
	
	// Setup our trial values for each parameter
	// Different size populations
	private static final int POPULATION_TRIALS[] = {5, 10, 15, 20, 50, 100, 150, 300, 600, 1000};
	// Range of crossover fractions between 0% and 100%
	private static final float CROSSOVER_TRIALS[] = {0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.7f, 0.8f, 0.9f, 1.0f};
	// Range of mutation fractions between 0% and 300%
	private static final float MUTATION_TRIALS[] = {0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.7f, 1.0f, 2.0f, 3.0f};
	
	
	public static void main(String[] args){
				
		String results = "";
		int cummulativeGenerations = 0;
		int l;
		double avg = 0;
		
		// **************************************************************************************************
		// Make a TRIAL
		// Setup a particular trial - in this case we are fixing all parameters except the crossover fraction
		int population_param = POPULATION_TRIALS[2]; // This is how you keep a fixed population size [2] = 15
		float mutation_param = MUTATION_TRIALS[1]; // This is how you keep a fixed mutation fraction [1] = 1%
		float[] current_trial = CROSSOVER_TRIALS;
		String trial_name = "Mutation fraction";
		// NOTE: change this block for different trials
		// **************************************************************************************************
			
		// Test the genetic algorithm over 5 trials
		for(int i = 0; i < NUM_TRIALS; i++){
			
			// Reset our generation counter
			cummulativeGenerations = 0;
			for(int j = 0; j < NUM_REPEATS; j++){
				
				// Create a population using particular trial data
				Population p = new Population(population_param, CHROMOSOME_LENGTH, current_trial[i], mutation_param);

				// Each trial will run over 100 generations or until solution has been found
				l = 0;
				while (l < NUM_GENERATIONS && !p.converged()){
					p.evolve(false);
					l++;
				}
			
				// Add up the number of generations over the repeats to find the average number 
				// of generations for a test value
				cummulativeGenerations = cummulativeGenerations + l;
			}
			
			// Calculate the average number of generations for this test value over NUM_REPEATS
			avg = cummulativeGenerations / NUM_REPEATS;
			
			// Store the result
			results = results + current_trial[i] + "," + avg + "\n";
			
		}	
		// Print out the trial results so we can make a nice graph
		System.out.println("*** T R I A L  R E S U L T S ***");
		System.out.println(trial_name + "," + "Average generations");
		System.out.println(results);
		
	}
}
