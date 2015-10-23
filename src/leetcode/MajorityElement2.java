package leetcode;

public class MajorityElement2 {
	  public int majorityElement(int[] num) {
	        int maj=0;
	        int count = 0;
	        for (int i = 0; i < num.length; i++){
	            if (count == 0){
	                maj = num[i];
	                count++;
	            }
	            else if (num[i] == maj){
	                count++;
	                if (count > num.length/2) return maj;
	            }
	            else count--;
	        }
	        return maj;
	    }
}
