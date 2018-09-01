import java.util.Collections;
import java.util.HashMap;

public class Question2 {
	public Question2() {}
	
	public String getMostFrequestWord(String input, String stopWords) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word:input.split(" ")) { //Add every unique word from the input string to hashmap
			if (!stopWords.contains(word)) {
				Integer i = map.putIfAbsent(word, 1);
				if (i != null) { //If the word is already in the hashmap, increase its int frequency by 1
					map.replace(word, i, i+1);
				}
			}
		}
		int maxVal = getMaxValue(map);
		if (Collections.frequency(map.values(), maxVal) > 1) { //If there is more than one instance of a frequency value, return null
			return null;
		}
		else {
			return getKey(map, maxVal);
		}
	}
	
	//Helper function returns largest int value in hashmap
	public static int getMaxValue(HashMap<String, Integer> map) {
		int maxValue = 0;
		for (int val:map.values()) {
			if (val > maxValue) {
				maxValue = val;
			}
		}
		return maxValue;
	}
	
	//Helper function returns the key for a value in hashmap
	public static String getKey(HashMap<String, Integer> map, int value) {
		for (String s:map.keySet()) {
			if (map.get(s).equals(value)) {
				return s;
			}
		}
		return null;
	}
}
