import java.util.Scanner;

public class Triplet{
        public int a;
        public int b;
        public int c;
        
        public Triplet(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public List<Integer> toList(){
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }
        
        @Override
        public boolean equals(Object o){
            if(o == null){
                return false;
            }
            Triplet t = (Triplet) o;
            
            Set<Integer> set = new HashSet<>();
            set.add(t.a);
            set.add(t.b);
            set.add(t.c);
            
            return (set.contains(this.a) && set.contains(this.b) && set.contains(this.c));
        }
    }

public class ThreeSum {
	
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<Triplet> uniques = new HashSet<>();
        for(int i = 0, k = nums.length; i < k; i++){
            Set<Integer> hash = new HashSet<>();
            for(int j = i + 1; j < k; j++){
                if(hash.contains(-(nums[j] + nums[i]))){
                    Triplet t = new Triplet(nums[i], nums[j], -(nums[i] + nums[j]));
                    uniques.add(t);
                } else {
                    hash.add(nums[j]);
                }
            }
        }
        uniques.forEach((t) -> {
    		t.toList().forEach(System.out::println);
    		list.add(t.toList());
    	});
        return list;
    }
    
    

	public static void main(String[] args){
		int[] a = {1, 4, -1, 0, 2, -3, -2};
		List<List<Integer>> list = threeSum(a);
		list.forEach((l) -> {
			l.forEach(System.out::println);
		}
	}
}

