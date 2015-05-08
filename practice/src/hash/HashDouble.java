package hash;

class DataItem {
	public int value;

	public DataItem(int ii) {
		value = ii;
	}
}

class HashDoubleTable {
	private final int CONSTANT = 6;
	DataItem[] hashArray;
	int arraySize;
	DataItem nonItem;

	HashDoubleTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	public void displayTable() {
		System.out.println("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].value + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}

	public int hashFunc1(int key) {
		return key % arraySize;
	}

	public int hashFunc2(int key) {
		return CONSTANT - (key % CONSTANT);
	}

	public void insert(int key) {
		int count = 0;
		int location = hashFunc1(key);
		int stepSize = hashFunc2(key);

		while (hashArray[location] != null && hashArray[location].value != -1
				&& count < arraySize) {
			count++;
			location = (location + stepSize) % arraySize;
		}
		hashArray[location] = new DataItem(key);
	}

	public DataItem find(int key) {
		int location = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while (hashArray[location] != null) {
			if (hashArray[location].value == key)
				return hashArray[location];
			location = (location + stepSize) % arraySize;
		}
		return null;
	}

	public boolean delete(int key) {
		DataItem item = find(key);
		if (item != null) {
			item = nonItem;
			return true;
		}
		return false;
	}
}

class HashDouble {
	public static void main(String[] args) {
		/**
		 * Should be a Prime Number, makes it impossible for any number to
		 * divide it evenly, so the probe sequence will eventually check every
		 * cell.
		 */
		final int SIZE = 11;
		HashDoubleTable table = new HashDoubleTable(SIZE);

		for (int j = 0; j < SIZE/2; j++){
			table.insert((int) (java.lang.Math.random() * 2 * SIZE));
			table.displayTable();
		}

	}
}
