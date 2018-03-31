package algorithms;

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
