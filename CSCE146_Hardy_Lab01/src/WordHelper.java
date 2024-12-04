/*
 * Written by Joe Hardy.
 */
public class WordHelper {
	
	//Array of all vowels considered for the methods with sorting by vowels or consonants.
	private static final char[] VOWELS = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};
	
	//Sorts two given string arrays from lowest amount of vowels to highest.
	public static String[] sortByVowels(String[] words) {
		String[] sorted = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			String newWord = words[i]; //The word that is getting added to the sorted array.
			
			boolean stay = true;
			for (int j = 0; j <= i && stay; j++) {
				String oldWord = sorted[j]; //The word that is already sorted and is getting compared to the new word.
				if (oldWord == null) {
					sorted[j] = newWord;
					stay = false;
				}
				else if (getNumOfVowels(newWord) < getNumOfVowels(oldWord)) {
					for (int k = i; k > j; k--) {
						sorted[k] = sorted[k - 1];
					}
					sorted[j] = newWord;
					stay = false;
				}
			}
		}
		return sorted;
	}
	
	//Sorts two given string arrays from lowest amount of consonants to highest.
	public static String[] sortByConsonants(String[] words) {
		String[] sorted = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			String newWord = words[i]; //The word that is getting added to the sorted array.
			
			boolean stay = true;
			for (int j = 0; j <= i && stay; j++) {
				String oldWord = sorted[j]; //The word that is already sorted and is getting compared to the new word.
				if (oldWord == null) {
					sorted[j] = newWord;
					stay = false;
				}
				else if (getNumOfConsonants(newWord) < getNumOfConsonants(oldWord)) {
					for (int k = i; k > j; k--) {
						sorted[k] = sorted[k - 1];
					}
					sorted[j] = newWord;
					stay = false;
				}
			}
		}
		return sorted;
	}
	
	//Sorts two given string arrays from lowest amount of characters to highest.
	public static String[] sortByLength(String[] words) {
		String[] sorted = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			String newWord = words[i]; //The word that is getting added to the sorted array.
			
			boolean stay = true;
			for (int j = 0; j <= i && stay; j++) {
				String oldWord = sorted[j]; //The word that is already sorted and is getting compared to the new word.
				if (oldWord == null) {
					sorted[j] = newWord;
					stay = false;
				}
				else if (newWord.length() < oldWord.length()) {
					for (int k = i; k > j; k--) {
						sorted[k] = sorted[k - 1];
					}
					sorted[j] = newWord;
					stay = false;
				}
			}
		}
		return sorted;
	}
	
	//Helper function that determines the number of vowels in a string.
	private static int getNumOfVowels(String word) {
		char[] chars = word.toCharArray();
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			if (isVowel(chars[i])) {
				num ++;
			}
		}
		return num;
	}
	
	//Helper function that determines the number of characters that are not vowels in a string.
	private static int getNumOfConsonants(String word) {
		char[] chars = word.toCharArray();
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			if (!isVowel(chars[i])) {
				num ++;
			}
		}
		return num;
	}
	
	//Helper function that determines whether or not a character is a vowel.
	private static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		for (int i = 0; i < VOWELS.length; i++) {
			if (c == VOWELS[i]) {
				return true;
			}
		}
		return false;
	}
	
}
