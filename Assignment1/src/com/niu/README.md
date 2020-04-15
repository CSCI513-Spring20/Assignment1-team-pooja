# Assignment2
# Battleships

#### design decisions for battleships search strategies:
In this problem we'll have to implement three different search strategies. 
Strategy design pattern works here because, class behavior or its algorithm can be changed at run time.

Advantages of using Strategy Pattern for this problem:

1. Clean Code, as we can avoid conditional-infested code.
2. In Strategy Pattern we create objects which represent the three search strategies 
and a context object whose behaviour varies as per the sort strategy. The strategy object
changes the executing algorithm of the context object.
3. Data structures used for implementing the algorithm are completely encapsulated in Strategy classes.
Therefore, the implementation of an algorithm can be changed without affecting the Context class.

##### output:
```$xslt
Assignment1-team-pooja>java -jar Assignment1-team-pooja.jar
Game: 1
Strategy: HorizontalSweepSearch
Number of cells searched 117
Carrier found: (0,0) to (0,4) Submarine found: (4,15) to (4,17)

Strategy: RandomSearch
Number of cells searched 496
Carrier found: (0,0) to (0,4) Submarine found: (4,15) to (4,17)

Strategy: StrategicSearch
Number of cells searched 67
Carrier found: (0,0) to (0,4) Submarine found: (4,15) to (4,17)

Game: 2
Strategy: HorizontalSweepSearch
Number of cells searched 507
Carrier found: (5,9) to (5,13) Submarine found: (20,5) to (20,7)

Strategy: RandomSearch
Number of cells searched 320
Carrier found: (5,9) to (5,13) Submarine found: (20,5) to (20,7)

Strategy: StrategicSearch
Number of cells searched 390
Carrier found: (5,9) to (5,13) Submarine found: (20,5) to (20,7)

Game: 3
Strategy: HorizontalSweepSearch
Number of cells searched 608
Carrier found: (15,3) to (19,3) Submarine found: (24,6) to (24,8)

Strategy: RandomSearch
Number of cells searched 594
Carrier found: (15,3) to (19,3) Submarine found: (24,6) to (24,8)

Strategy: StrategicSearch
Number of cells searched 308
Carrier found: (15,3) to (19,3) Submarine found: (24,6) to (24,8)

```