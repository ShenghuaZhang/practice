package string;

public class ReadNCharactersGiveRead4 {
	
	public static int read(char[] buf, int n){
		char[] buffer = new char[4];
		int readByte = 0;
		while(readByte<n){
			int cur = Math.min(n-readByte, 4);
			System.arraycopy(buffer, 0, buf, readByte, cur);
			
			readByte += read4(buffer);
			if(read4(buffer)<4)	return readByte;
		}
		
		return readByte;
	}
	protected static int read4(char[] buf){
		return 1;
	}
	
	public int readII(char[] buf, int n) {
        char[] buffer = new char[4];
		int readBytes = 0;
		while (readBytes < n) {
            int sz = read4(buffer);
            int bytes = Math.min(n - readBytes, sz);
            System.arraycopy(buffer, 0, buf, readBytes, bytes);
            readBytes += bytes;
            if (sz < 4) return readBytes;
        }
		return readBytes;
    }
	
	public static void main(String[] args){
		char[] c = {'a'};
		System.out.println(read(c, 1));
	}
}
