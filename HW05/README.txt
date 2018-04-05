(010286913)Addison Kauzer
(010266477)Eric Scaramuzzo
(010485982)Joleena Marshall

Question 1
No unvisited node can ever connect to a node that 
has been visited. The connections only go from visited nodes
to unvisited nodes. This ensures that the maze has no cycles.

Question 2
Create a digraph with each node containing the information
of adjacent nodes, arrival time to those nodes, and 
departure times. Use a BFS with Dijkstra's Algorithm, but 
the weights are the arrival times and do not need to be added
together when relaxing. Also, when relaxing, make sure that the 
distance to origin< departure time.

Efficiency: Worst case is that every node is connected to every other
node, this would make the run time O(V(V-1)) or O(V^2). Our 
implementation creates a Directed graph, but then uses Dijkstra's 
Algorithm to turn it into a DAG. This is because each node only 
has an edgeTo that takes it closer to the origin, making it a 
topological graph.
