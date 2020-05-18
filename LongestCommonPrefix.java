import java.util.Scanner;

class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
        	int min = Integer.MAX_VALUE;
        	for(int i = 0; i < strs.length; i++){
            		min = min > strs[i].length() ? strs[i].length() : min;
        	}
	        StringBuilder sb = new StringBuilder();
        	boolean found = false;
        	for(int i = 0; i < min && !found; i++){
            		if(allSame(strs, i)){
                		sb.append(strs[0].charAt(i));
            		} else {
                		found = true;
            		}
        	}
        	return sb.toString();
    	}
    
    	private static boolean allSame(String[] strs, int i){
        	for(int k = 1; k < strs.length; k++){
            		if(strs[k-1].charAt(i) != strs[k].charAt(i)){
                		return false;
            		}
        	}
    	   	return true;
    	}


	public static void main(String[] args){
		System.out.println(longestCommonPrefix(args));
	}
}
