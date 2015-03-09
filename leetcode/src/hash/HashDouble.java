package hash;


class DataItem{
	public int iData;
	
	public DataItem(int ii){
		iData = ii;
	}
}

class HashTable{
	private final int CONSTANT = 6;
	DataItem[] hashArray;
	int arraySize;
	DataItem nonItem;
	
	HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable(){
		System.out.println("Table: ");
		for(int j=0; j<arraySize; j++){
			if(hashArray[j] != null)
				System.out.print(hashArray[j].iData+" ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}
	
	public int hashFunc1(int key){
		return key % arraySize;
	}
	
	public int hashFunc2(int key){
		return CONSTANT-(key%CONSTANT);
	}
	
	public void insert(int key){
		int count = 0;
		int location = hashFunc1(key);
		int stepSize = hashFunc2(key);
		DataItem item = new DataItem(key);
		
		while(hashArray[location]!= null && hashArray[location].iData!=-1 && count<arraySize){
			count++;
			location = (location+stepSize) % arraySize;
		}
		// TODO why cannot: hashArray[location].iData = key;
		hashArray[location] = item;
	}
	
	public DataItem find(int key){
		int location = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while(hashArray[location]!=null){
			if(hashArray[location].iData==key)
				return hashArray[location];
			location = (location+stepSize) % arraySize;
		}
		return null;	
	}
	
	public boolean delete(int key){
		DataItem item = find(key);
		if(item!=null){
			item = nonItem;
			return true;
		}
		return false;
	}
}

class HashDouble{
	public static void main(String[] args){
		int aKey;
		int hashSize=10;
		HashTable hashTable = new HashTable(hashSize);
		
		for(int j=0; j<4; j++){
			aKey = (int)(java.lang.Math.random()*2*hashSize);
			hashTable.insert(aKey);
		}
		
		hashTable.displayTable();
	}
}
