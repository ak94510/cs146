010286913 (Kauzer, Addison)

Question 1.
My shuffle algorithm turns the goodness value into a 
number that represents the number of cards that need to 
be shuffled. For every two cards it picks two random array 
index to swap.
goodness[test1,test2,test3,test4,test5]

0   [74%, 68%, 72%, 71%, 72%]
0.3[75%, 72%, 77%, 79%, 75%]
0.5[77%, 80%, 79%, 77%, 79%]
0.9[94%, 95%, 96%, 96%, 97%]
1   [100%, 100%, 100%, 100%, 100%]

Question 2. 
{sizeOfA,sizeOfB} [time1,time2,time3,time4,time5]
{10,20} [9ms, 8ms, 11ms, 10ms, 8ms]
{100,200} [33ms, 29ms, 31ms, 31ms, 53ms]
{200,400} [81ms, 84ms, 73ms, 84ms, 89ms]
{40000,160000}[2068ms]
{4000000,1600000}[75334ms]
	Pair the k array's together and run the program 
on the pairs. Then recursivly take the results, pair
them together, and run the program on the pairs until there
is only one array left. If k is odd, one array will be saved
until the end and run with the result of the pairs.

Question 3.
1)Constant
2)yes
3)yes
4)yes, using a second stack
 


