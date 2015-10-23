package leetcode;

public class ReadNCharactersGivenRead4 {

		/**
		 * @param buf
		 *            Destination buffer
		 * @param n
		 *            Maximum number of characters to read
		 * @return The number of characters read
		 */
		public int read(char[] buf, int n) {
			char[] buffer = new char[4];
			int readBytes = 0;
			boolean eof = false;
			while (!eof && readBytes < n) {
				int sz = read4(buffer);
				if (sz < 4)
					eof = true;
				int bytes = Math.min(n - readBytes, sz);
				System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
				readBytes += bytes;
			}
			return readBytes;
		}

		private int read4(char[] buffer) {
			return 0;
		}
	}
