package leetcode;
/* The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
*/
public class ReadNCharactersGivenRead4Callmultipletimes {
	private char[] buffer = new char[4];
	int offset = 0, bufsize = 0;

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			int sz = (bufsize > 0) ? bufsize : read4(buffer);
			if (bufsize == 0 && sz < 4)
				eof = true;
			int bytes = Math.min(n - readBytes, sz);
			System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
			offset = (offset + bytes) % 4;
			bufsize = sz - bytes;
			readBytes += bytes;
		}
		return readBytes;
	}

	private int read4(char[] buffer2) {
		return 0;
	}
}
