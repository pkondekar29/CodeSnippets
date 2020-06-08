package CodeSnippets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagram {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];

        for(int i = 0; i< n; i++){
            strs[i] = sc.next();
        }

        List<List<String>> list = new ArrayList<>();
        boolean found;
        int j;
        for(int i = 0; i < n; i++){
            found = false;
            for(j = 0; j < list.size(); j++){
                if(isAnagram(list.get(j).get(0), strs[i])){
                    found = true;
                    break;
                }
            }
            if(found){
                list.get(j).add(strs[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                list.add(l);
            }
        }
        list.stream()
            .forEach(sl -> {
                System.out.println();
                sl.forEach(System.out::print);
                System.out.println();
            });
        sc.close();
    }

    private static boolean isAnagram(String s1, String s2){
        // Use count array histogram
        return true;
    }

}