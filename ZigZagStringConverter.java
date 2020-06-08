package CodeSnippets;
import java.util.Scanner;

public class ZigZagStringConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int rows = sc.nextInt();
        System.out.println(convert(str, rows));

        sc.close();
    }

    public static String convert(String s, int n) {
        int len = s.length();
        if(len <= 0){
            return "";
        }

        int i = 1, index = 0, currRow = 0; 
        boolean b = false;   
        char[] str = new char[len];
        str[0] = s.charAt(0);
        final int interval = (n - 2 > 0) ? n - 2 : 0;
        while(i < len){       // while all elements are not printed
            // findNextIndex
            index = findNextIndex(len, index, n, currRow, b, interval);
            
            // print
            if(currRow != 0 && currRow != (n - 1)){       // if top or bottom row
                b = !b;
            }
            if(index >= len) {
                currRow++;
                index = currRow;
                b = false;       // bottom
            } 
            str[i] = s.charAt(index);
            i++;
        }
        
        return String.valueOf(str);
    }
    
    private static int findNextIndex(final int len, int currIndex, final int numRows, int currRow, boolean b, final int interval) {
        if(currRow == 0 || currRow == (numRows - 1)){       // if top or bottom row
            currIndex += (numRows + interval);   // elements in vertical and diagonal
        } else {
            if(b) {      // Top
                currIndex += (2 * currRow);
            } else {        // Bottom
                currIndex += 2 * (numRows - currRow - 1);
            }   
        }
        return currIndex;
    }

}