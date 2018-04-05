010286913 (Kauzer, Addison)
Question 1

My approch to this problem is to create a hashcode of a
queue containing n words and map that to the value of the 
file. Then go through the target file and compare it's
hashcodes of n words to the map. If it .contains then it has
been plagerized.
Worst case of each step
(1)Tokenize - O(2n) Splits into n words and then converts
to ArrayList.
(2)Parser - O(n) visits every word once to add it to the
queue
(3)Target Tokenize - Same as tokenize for corpus file
(4)Parser - Same as parser for corpus file, but calls 
.contains on the map for the hashcode of the queue.
Total Efficiency O(3n+3m) or O(n+m).

Question 2

My approch to this problem is to only save the locations
that have candy since all of the other locations have a value
of 0. Grid class saves a HashTable of only size n. To look up
a locations, just see if that location is in the table. If it is you
can get it's value and if not it is 0. To add 100 to a random
point, generate a random location and see if it is in the table. 
If it is add 100 to it. If it is not, add it to the table and map it
to a value of 100. 