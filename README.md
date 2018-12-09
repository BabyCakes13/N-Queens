# N-Queens

The application creates a solution ( or partial solution ) for the N-Queens problem, using depth-wise implementation and a stack to keep track of the solution.

### IDEA

The algorithm takes each column and checks whether a queen can be placed on a row from that column, so that no two queens will be in conflict ( two queens will bug each other if they are on the same line or same column ).
When all the columns have been checked, the stack will have each column on (row, column) as (number in stack, position in stack).

### SOLUTION

Represents the final stack which will contain the row positions of the queens.

- does not always represent a valid solution for the N-Queens (there will not always be n queens placed, but some number k between (1, n)), but a partial solution in case a full one is not found (n = 5 generates a full solution). 
- the partial solution represents the stack filled with queens until another queen could not be placed without conflicting with the others.
