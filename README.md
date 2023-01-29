
# Bacteria

Bacteria is a simulation of a 2-dimensional grid petri dish of bacteria. The bacteria in dish live and die by the following rules based on the bacteria surrounding it.

# Bacteria Rules
1. Any live bacteria cell with fewer than two live neighbours dies, as if caused by under-population.

2. Any live bacteria cell with two or three live neighbours lives on to the next generation.

3. Any live bacteria cell with more than three live neighbours dies, as if by overcrowding.

4. Any dead bacteria cell with exactly three live neighbours becomes a live bacteria cell, as if by reproduction.


# Program input

The the program will take from standard input a series of comma separated integer x,y pairs each on a new line that indicate the location of live bacteria cells. The input will be terminated with end. 

# Program output

Bacteria outputs the results of the simulation to standard output consisting the of x,y pairs marking the locations of live bacteria cells after one generation has completed. The output of the program is be able to be used to feed into the program again to perform another “generation”.