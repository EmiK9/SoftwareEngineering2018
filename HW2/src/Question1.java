import java.util.HashSet;

public class Question1 {
	
	public Question1() {}
	
	public int getSumWithoutDuplicates(int array[]) {
		HashSet<Integer> hash = new HashSet<Integer>();
		int sum = 0;
		for (int x:array) {
			if (!hash.contains(x)) { //If the int is not already in the hashset, add to sum and to hashset
				sum += x;
				hash.add(x);
			}
		}
		return sum;
	}
}
