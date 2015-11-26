package leetcode;

import java.util.LinkedList;
import java.util.List;

/* Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses {
	   public List<String> removeInvalidParentheses(String s) {
	        LinkedList<String> res= new LinkedList<String>();
	        if(isvalid(s)){
	            res.add(s);
	            return res;
	        }
	        LinkedList<String> invalid= new LinkedList<String>();
	        invalid.add(s);
	        helper(invalid,0,res);
	        return res;
	    }
	    private boolean isvalid(String s) {
		// TODO Auto-generated method stub
		return false;
	}
		public void helper( LinkedList<String> invalid,int index, LinkedList<String> res){
	        for(int i=0;i<invalid.size();i++){
	            String s=invalid.get(i);
	            for(int j=0;j<s.length();j++){
	                
	            }
	        }
	    }
}
