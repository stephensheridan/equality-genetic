# Computational Intelligence - Assignment 2 - Feb 2016

## Introduction
For your second Computational Intelligence assessment you will have to build a genetic algorithm to solve the following equality problem:

__a + 2b + 3c + 4d = 30__

This can be viewed as a search problem where the GA must find suitable values for a, b, c, and d so that when plugged into the formula they equal 30. Each chromosome in the population must encode 4 integer values so binary encoding isnot suitable for this problem. Therefore, you will have to implement a value encoded chromosome in order to solve the problem.

## Supporting GitHub Files
In order to complete this assignment you will have to download the accompanying template code for this assessment that is available from my GitHub repositories at 

https://github.com/stephensheridan/equality-genetic

The GitHub repository consists of five files that you will have to modify in order to complete the assessment. The following is a brief description of each file, you should inspect the files for detailed code comments that explain what is going on in a little more detail.

1. __Genetic.java__ :- This is the main driver file for the genetic algorithm
2. __GeneticParameterTrial.java___ :- This file is similar to Genetic.java but automates the testing of some trial genetic parameters such as population_size, crossover_rate and mutation_rate.
3. __Population.java__ :- This file implements a population of value encoded chromosomes. All the operations associated with the population of candidate solutions are implemented here.
4. __ValueEncodedChromosome.java__ :- This class represents a single value encoded chromosome.
5. __README.md__ :- This file contains all of the info contained in this document in markdown form. That's the GitHub way.

If you have not used GitHub before or don't know anything about it, now is your time to find out about it. Having working knowledge of a version control system like GitHub is essential industry experience. Trust me it will really stand to you if you spend a little time learning GitHub. So create your GitHub account now and get going.

## Assessment Tasks

#### Task 1 - 5%
In task 1 your job is to complete the TODO sections that are listed in the GitHub source code. The ValueEncodedChromosome class does not have any implementation sections but does have its interface and data members define. You must look at how the methods are called from the other classes and read the code comments in order to understand what each method should do. Once you complete all the code sections you should be able to test your code by running the *__Genetic.java__* file. You can control the GA by fine tuning the GA parameters listed in *__Genetic.java__*.

#### Task 2 - 5%
The second part of this assessment is to run a number of experiments that will test the effects of changing the GA parameters *population_size*, *crossover_fraction*, and *mutation_fraction* on the number of generations the GA takes to converge. You will need to execute the *__GeneticParameterTrial.java__* file in order to run the experiments. This file is already coded to run an experiment where the *crossover_fraction* is modified while the *population_size* and *mutation_rate* remain constant. When you look at the code in *__GeneticParameterTrial.java__* you will see a section marked out where the experiment is setup. The rest of the code is generic and you should not have to modify it. NOTE: the only output from this java program will be a table of values that can be easily graphed in MS Excel or any other graphing tool. For each experiment or trial you will get a table of values that can be graphed. You must run and graph three experiments as follows:

1. Vary the *population_size* from 5 to 1000 while keeping the *crossover_fraction = 50%* and the *mutation_fraction = 2%*
2. Vary the *crossover_fraction* from 0% to 100% while keeping the *population_size = 50* and the *mutation_fraction = 20%*
3. Vary the *mutation_fraction* from 0% to 300% while keeping the *population_size = 50* and the *crossover_fraction = 50%*

All experiments must average the number of generations taken over 10 runs (*NUM_REPEAT_AVG = 10*) and must set the maximum number of generations for each trial to 200 (*NUM_GENERATIONS = 200*).

#### Task 3 - 5%
Create a PDF document that explains the code changes you made in *task 1*. List each method and give a very brief explanation of what it does. Your documentation should also show a graph for each experiment in *task 2* and a brief description of what the graph shows in terms of how the parameters trial effected the number of generations required to converge.

## Deliverables
1. Completed source code files
2. Documentation for *task 1* and *task 2*
3. Demo of code in lab

## Deadlines
All work should be submitted on MOODLE by 18:00hrs on the 8th of April.
