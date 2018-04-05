package question4;

import java.util.*;

public class question4 {

	public static int threeSum(int[] list) {
		if (list.length < 3)
			return 0;
		Arrays.sort(list);
		int counter = 0;
		for (int firstChar = 0; firstChar < list.length - 2; firstChar++) {
			if (firstChar == 0 || list[firstChar] > list[firstChar - 1]) {
				int secondChar = firstChar + 1;
				int thirdChar = list.length - 1;

				while (secondChar < thirdChar) {
					if (list[firstChar] + list[secondChar] + list[thirdChar] == 0) {
						List<Integer> l = new ArrayList<Integer>();
						l.add(list[firstChar]);
						l.add(list[secondChar]);
						l.add(list[thirdChar]);
						counter++;
						secondChar++;
						thirdChar--;
						
						while (secondChar < thirdChar && list[secondChar] == list[secondChar - 1])
							secondChar++;
						while (secondChar < thirdChar && list[thirdChar] == list[thirdChar + 1])
							thirdChar--;

					} else if (list[firstChar] + list[secondChar] + list[thirdChar] < 0) {
						secondChar++;
					} else {
						thirdChar--;
					}
				}
			}

		}

		return counter;
	}

	/*public static void main(String[] args) {
		int[] list= {-10,-20,-30,5,0,10,30,20};
		System.out.println(threeSum(list));
	}*/

}
