package string;

public class ReadNCharactersGiveRead4 {
	protected static int read4(char[] buf){
		return buf.length>4?4:buf.length;
	}
	
	public static int readII(char[] buf, int n) {
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
	
	public static void main(String[] args){
		char[] c = {'a','d','d','f','g','h'};
		System.out.println(readII(c, 5));
	}
}
