package string;
/**
 * 157
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example,
 * it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * @author yili3
 *
 */
public class ReadNCharactersGiveRead4 {
	int read4(char[] buf){
		return buf.length>4?4:buf.length;
	}
	
	public int readII(char[] buf, int n) {
        char[] buffer = new char[4];
		int readBytes = 0;
		while (readBytes < n) {
            int sz = read4(buffer); 
            int bytes = Math.min(n-readBytes, sz);
            System.arraycopy(buffer, 0, buf, readBytes, bytes);
            readBytes += bytes;
            if (sz < 4) return readBytes;
        }
		return readBytes;
    }
}
