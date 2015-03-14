package string;

public class ReadNCharactersGivenRead4CallMultipleTimes extends ReadNCharactersGiveRead4{
	private char[] buffer = new char[4];
	int offset = 0, bufsize = 0;

	/**
	 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
	 *  
	 * @param buf 	Destination buffer
	 * @param n  	Maximum number of characters to read
	 * @return 		The number of characters read
	 */
	public int readIII(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			if (bufsize == 0) {
				bufsize = read4(buffer);
				eof = bufsize < 4;
			}
			int bytes = Math.min(n - readBytes, bufsize);
			System.arraycopy(buffer, offset, buf, readBytes, bytes);
			offset = (offset + bytes) % 4;
			bufsize -= bytes;
			readBytes += bytes;
		}
		return readBytes;
	}
}
