//https://www.hackerrank.com/challenges/grading/problem

package problemSolving;

import java.util.Scanner;

public class RoundOffGrading {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        
        in.close();
    }
    
    static int[] solve(int[] grades){
        
    	int[] newGrades = new int[grades.length];
    	int newGrade = 0;
    	for(int i=0; i<grades.length; i++) {
    		if(grades[i]<38) {
    			newGrades[i] = grades[i];
    			continue;
    		}
    		newGrade = ((grades[i]/5)+1)*5;
    		if((newGrade - grades[i]) < 3)
    			newGrades[i] = newGrade;
    		else
    			newGrades[i] = grades[i];    		
    	}
    	return newGrades;
    }
}
