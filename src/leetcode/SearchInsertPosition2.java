package leetcode;

public class SearchInsertPosition2 {
	public int searchInsert(int[] A, int target) {
		int start=0, end=A.length-1;
		return searchInsert(A,start,end,target);
	}
	
	public int searchInsert(int[] A, int start, int end,int target){
		if(start>=end){
			if(A[start]<target)
				return start;
			else
				return start+1;
		}
		int mid= (start+end)>>1;
		if(A[mid]==target)
			return mid;
		if(A[mid]>target)
			return searchInsert(A,start,mid,target);
		else
			return searchInsert(A,mid+1,end,target);
	}
}
