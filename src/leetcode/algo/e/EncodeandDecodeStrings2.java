package leetcode.algo.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * } 
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
Well, let's use an example strs = ["#$%", "", "12"] to illustrate the encoding and decoding algorithms. The idea is to use some character as sentinel. But since the input strs may contain any character, including the sentinel, we still need to use other information to avoid ambiguation. Specifically, we use the length of the string. The above string will be encoded as

3##$%0#2#12

Each color represents the encoding of each string and we use # as the sentinel.

During decoding, we will initialize a starting point p to be 0. Then we find the first # starting from p, which is just the sentinel for the first string and characters between p and the first # encode the length of the following string, using which we would be able to extract that string. In the above example, the length of the first string is 3 and we extract 3 characters after the first sentinel # and get #$%, which is just the first string. Then we move p to the point after the first string and continue the above process. Finally, all strings will be extracted out.

The code is as follows. If you find it not that clear, run it on the above example and you will get how it works.
*/
// SOLUTION: use non-ascii char
public class EncodeandDecodeStrings2 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
        	return Character.toString((char) 258);
		}

        String d = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(d);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char) 258);
        if (s.equals(d))
        	return new LinkedList<>();

        d = Character.toString((char) 257);
        return Arrays.asList(s.split(d, -1));
    }
}
