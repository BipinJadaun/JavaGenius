package algorithms.backtracking;

/* find all combination of a given string
    Input: str = “a1b2c3”
    Output: a1b2c3, A1b2c3, a1B2c3, a1b2C3, A1B2c3, a1B2C3, A1b2C3, A1B2C3
 */

public class LetterCasePermutations {
    public static void main(String[] args) {
        String str = "a1b2c3";
        findPermsUsingDFS(str.toCharArray(), 0);
    }

    private static void findPermsUsingDFS(char[] str, int pos) {
        if(pos == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        if(Character.isDigit(str[pos])){
            findPermsUsingDFS(str, pos + 1);
            return;
        }
        str[pos] = Character.toUpperCase(str[pos]);
        findPermsUsingDFS(str, pos+1);

        str[pos] = Character.toLowerCase(str[pos]);
        findPermsUsingDFS(str, pos+1);
    }
}
