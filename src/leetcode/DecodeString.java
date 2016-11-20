package leetcode;

import java.util.Stack;

/*Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/
public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            int begin = i;
            while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                i++;
            }
            if (i != begin)
                stack.push(s.substring(begin, i));
            begin = i;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                i++;
            }
            if (i != begin) {
                num.push(Integer.parseInt(s.substring(begin, i)));
            }
            if (i<s.length()&&s.charAt(i) == '[')
                stack.push("[");
            else if (i<s.length()&& s.charAt(i) == ']') {
                String str = "";
                while (!stack.isEmpty()&&stack.peek()!="["){
                    str=stack.pop()+str;
                }
                String temp ="";
                int times = num.pop();
                while (times-->0){
                    temp+=str;
                }
                while (!stack.isEmpty()&&stack.peek()!="["){
                    temp=stack.pop()+temp;
                }
                if(!stack.isEmpty())
                    stack.pop();
                stack.push(temp);
            }
            i++;
        }
        StringBuilder res= new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
    public static void  main(String[] args){
        String s ="3[a2[c]]";
        String ss ="3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
