package problemSolving;

import java.util.Stack;

public class StringDecoding {

	public static void main(String[] args) {

		String stringToEncode = "ogle.og is. orld's.w ost.m ous.maf any.pmoc";
		String decodedString = getDecodedString(stringToEncode);
		System.out.println(decodedString);
	}

	private static String getDecodedString(String stringToEncode) {

		String[] strArr = stringToEncode.split(" ");
		Stack<String> stack = new Stack<>();
		StringBuilder decodedString = new StringBuilder();
		
		for(String word : strArr) {
			String decodedWord = getDecodedWord(word);
			stack.push(decodedWord);
		}
		
		for(String word : stack) {
			decodedString.append(word);
			decodedString.append(" ");
		}
		
		return decodedString.substring(0, decodedString.length()-1).toString();
	}

	private static String getDecodedWord(String word) {
		
		int len = word.length();
		int index = 0;
		StringBuilder decodedString = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		for(int i=0; i<len; i++) {
			if(word.charAt(i) == '.') {
				index = i;
				break;
			}
		}		
		tmp.append(word.substring(index+1));
		decodedString.append(tmp.reverse());
		decodedString.append(word.substring(0, index));		
		
		return decodedString.toString();
	}

}
