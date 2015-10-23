package leetcode;
/* Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */
/* 这是一道检查字符串输入是否为合法的题目。基本规则是按照科学计数法，出现的字符有以下几个： 
 * 符号位‘+’，‘-’，小数点‘.’，还有‘e’和‘E’，数字0-9，其他非法字符。
 * 数字字符在哪里出现都是合法的，我们主要考虑几个特殊字符的情况。
 * 对于小数点出现，要满足条件：
 *（1）前面不能有小数点或者‘e’和‘E’；
 *（2）前一位是数字（不能是第一位）或者后一位要是数字（不能是最后一位）。
 * 对于正负号出现，要满足条件：
 *（1）必须是第一位或者在‘e’和‘E’后一位；
 *（2）后一位要是数字。
 * 对于‘e’和‘E’，要满足条件：
 *（1）前面不能有‘e’和‘E’出现过；
 *（2）不能是第一位（前面没数字科学计数没有意义）或者最后一位（后面没数字就不用写指数了）。
 * 根据上面列举的情况，我们用两个标签和做前后位的判断来实现，算法复杂度是O(n)，只需要O(1)的额外空间。
 */
public class ValidNumber {
	public boolean isNumber(String s) {
	    if(s==null)
	        return false;
	    s = s.trim();
	    if(s.length()==0)
	        return false;
	    boolean dotFlag = false;
	    boolean eFlag = false;
	    for(int i=0;i<s.length();i++)
	    {
	        switch(s.charAt(i))
	        {
	            case '.':
	                if(dotFlag || eFlag 
	                || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')) 
	                    && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))))
	                    return false;
	                dotFlag = true;
	                break;
	            case '+':
	            case '-':
	                if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
	                  || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.')))
	                    return false;
	                break;
	            case 'e':
	            case 'E':
	                if(eFlag || i==s.length()-1 || i==0)
	                    return false;
	                eFlag = true;
	                break;
	            case '0':
	            case '1':
	            case '2':
	            case '3':
	            case '4':
	            case '5':
	            case '6':
	            case '7':
	            case '8':
	            case '9':
	                break;
	            default:
	                return false;
	        }
	    }
	    return true;
	}
}
