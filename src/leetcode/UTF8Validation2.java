package leetcode;

/*A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

Note:
The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:
data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
*/
/* Followings are the rules:
1-byte: [0, 127]
2-byte: [192, 223], [128, 191]
3-byte: [224, 239], [128, 191], [128, 191]
4-byte: [240, 247], [128, 191], [128, 191], [128, 191]
5-byte: [248, 251], [128, 191], [128, 191], [128, 191], [128, 191]
6-byte: [252, 254], [128, 191], [128, 191], [128, 191], [128, 191], [128, 191]
7-byte: [255, 255], [128, 191], [128, 191], [128, 191], [128, 191], [128, 191], [128, 191]
 */

public class UTF8Validation2 {
	public boolean validUtf8(int[] data) {
		int bitCount = 0;
		for (int n : data) {
			if (n >= 192) {
				if (bitCount != 0)
					return false;
				else if (n >= 255)
					bitCount = 6;
				else if (n >= 252)
					bitCount = 5;
				else if (n >= 248)
					bitCount = 4;
				else if (n >= 240)
					bitCount = 3;
				else if (n >= 224)
					bitCount = 2;
				else
					bitCount = 1;
			} else if (n >= 128) {
				bitCount--;
				if (bitCount < 0)
					return false;
			} else if (bitCount > 0) {
				return false;
			}
		}

		return bitCount == 0;
	}

}
