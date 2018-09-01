
public class Question3 {
	public Question3() {}
	
	public int getMirrorCount(int nums[]) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int mid = length / 2;
		int point = -1;
		int count = 0;
		int first = -1;
		int last = -1;
		for (int i = 0; i < mid+1; i++) { //Iterate through array, checking if current and mirrored position are equal
			int j = i+1;
			if (count > 0) { //If there has already been a mirror, check if it ended
				if (i == mid || nums[i] != nums[length-j]) { //Record where the mirror ended
					point = i;
				}
			}
			if (nums[i] == nums[length-j]) {
				count++;
			}
			i++;
		}
		if (point != -1) { //If there were mirrors in the array somewhere
			int sum = 0;
			if (point != mid) { //If the mirror did end at some point, the final count will only be from the start of the mirror to where the endpoint was
				last = point;
			}
			for (int k = first; k <= last; k++) { //If the mirror endpoint is the midpoint, then from start of mirror to end of mirror there were no non-mirrors
				sum++; //Count up and return the number of integers from start of mirror to end
			}
			return sum;
		}
		else { //If there were no mirrors, one integer mirrored itself
			return 1;
		}
	}
}
