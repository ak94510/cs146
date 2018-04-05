010286913 (Kauzer, Addison)
Question1
The algorithm is quick sort with the pivot chosen by
matching a nut and a bolt and setting them as pivots.
If the pivot is exactly half way through the array then the 
cost would be N=4C(n/2) + 2n. This is because there are
4 halfs and you have to organize n items twice as lesser or
greater then the pivot. Using the master theorem, a =4,b=2,
c=2, and k=1. This falls under the third case where a>b^k
so the algorithm is big-Omega(n^log4 base 2) or n^2.

Question2
Request upgrade: Sets value as lowest value in the max
heap then swims up. Worst case it swims to the top so
it is log(n) comparisons because n values have log(n)
rows. This puts it in O(log(n)).
Cancel upgrade: Swap the position of the upgrade you
want to cancel with the last position of the heap. Set the
last position to null and sink the original position.Worst 
case it sinks from the top to the bottom so it is log(n) 
comparisons because n values have log(n) rows. 
This puts the algorithm in O(log(n)).
Print upgrade list: Remove the top value k times. 
Removing is O(log(n)) and you repeat it k times so 
this is O(klog(n)).

Question 3
1. Split the Array in half
2. compare the half point(hp) and the hp+1
3. If hp+1<hp then save the first half, if hp+1>hp
save the second half. Then recursivly 
repeat steps 1-3 on the half you saved untill you have 
one value.
4. Cost is N=C(n/2)+1 since it calls itself on a array of 
n/2 and makes one comparison. Using the master 
theorem a=1,b=2,c=1, and k=0. This falls under the second
case since a=b^k so it is big-Omega(n^1logn) or (nlogn).