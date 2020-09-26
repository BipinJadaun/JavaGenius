/*encode a string as per below rules-
each word in string should be encoded as per below rules-
	1. alphabets till second vowel in the world becomes start of the word, followed by a dot, followed by alphabets reversed till the vowel
	2. if the word have only 1 vowel it will follow same rule as above and consider first vowel as starting point.
	3. if word has no vowels then start with a dot followed by alphabets in reverse order.
exp : 
	String = google is world's most famous company
	encoded String = ogle.og is. orld's.w ost.m ous.maf any.pmoc
*/

package problemSolving;

import java.util.Stack;

public class StringEncoding {

	public static void main(String[] args) {
		
		String stringToEncode = "google is world's most famous company";
		String encodedString = getEncodedString(stringToEncode);
		System.out.println(encodedString);
	}

	private static String getEncodedString(String stringToEncode) {
		String[] strArr = stringToEncode.split(" ");
		Stack<String> stack = new Stack<>();
		StringBuilder encodedString = new StringBuilder();
		
		for(String word : strArr) {
			String encodedWord = getEncodedWord(word);
			stack.push(encodedWord);
		}
		
		for(String word : stack) {
			encodedString.append(word);
			encodedString.append(" ");
		}
		
		return encodedString.substring(0, encodedString.length()-1).toString();
	}

	private static String getEncodedWord(String word) {
		int len = word.length();
		int count = 0;
		String vowels = "aeiou";
		StringBuilder encodedWord = new StringBuilder();
		StringBuilder strTmp = new StringBuilder();
		int index = 0;
		
		for(int i=0; i< len; i++) {
			if(vowels.contains(Character.toString(word.charAt(i)))) {
				count++;
				index = i;
			}			
			if(count == 2)
				break;
		}			
		if(count == 2 || count == 1) {
			encodedWord.append(word.substring(index));
			encodedWord.append(".");
			strTmp.append(word.substring(0, index));
			encodedWord.append(strTmp.reverse());
		}
		
		if(count == 0) {			
			encodedWord.append(".");
			strTmp.append(word);
			encodedWord.append(strTmp.reverse());
		}
		return encodedWord.toString();
	}

}
