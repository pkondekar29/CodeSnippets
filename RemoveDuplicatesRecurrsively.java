import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesRecurrsively {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- > 0) {
            String str = sc.next();
            // System.out.println(removeDuplicates(str, new char[str.length()], 0, 0));
            System.out.println(removeAllAdjacentDuplicates(str, new ArrayDeque<Character>(), 0, 0));
	    }
	    sc.close();
	}
	
	private static String removeDuplicates(String str, char[] uniques, int strIndex, int uniqueIndex){
	    if(strIndex == 0 || str.charAt(strIndex) != uniques[uniqueIndex - 1]){
            uniques[uniqueIndex] = str.charAt(strIndex);
            uniqueIndex++;
        }
        strIndex++;
        if(strIndex == str.length()) return (new String(uniques));
	    else return removeDuplicates(str, uniques, strIndex, uniqueIndex);
    }
    
    private static String removeAllAdjacentDuplicates(String str, Deque<Character> uniques, int strIndex, int lastIndex) {
        if(strIndex == 0 || str.charAt(strIndex) != str.charAt(lastIndex)){
            uniques.add(str.charAt(strIndex));
            lastIndex = strIndex;
        } else if(str.charAt(strIndex) == str.charAt(lastIndex - 1)){
            uniques.removeLast();
        }
        strIndex++;
        if(strIndex == str.length()) {
            StringBuilder sb = new StringBuilder();
            for(Character c : uniques) {
                sb.append(c);
            }
            return sb.toString();
        } else {
            return removeAllAdjacentDuplicates(str, uniques, strIndex, lastIndex);
        }
    }
}