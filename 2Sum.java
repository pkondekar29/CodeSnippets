import java.util.Map;

public class TwoSum{

    public static void main(String[] args){

        System.out.println(twoSum(new int[]{1, 4, 2, 3}, 4));

    }

    private static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            /**  Here finding the complement and checking if the key exists in hash map. Ex - (for 1 => complement is (4-1) = 3 -> finding if key = 3 is present in map) */
            if(hashMap.containsKey(target - arr[i]) && hashMap.get(target - arr[i]) != i){
                return new int[]{i, hashMap.get(target - arr[i])};
            }
            hashMap.put(arr[i], i);
        }
    }
}