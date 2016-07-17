package uber;


/*
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190734&page=1#pid2476580
 * 
 */
public class IHashTable<K, V> {
	public class HashEntry<K, V> {
		K key;
		V val;
		HashEntry next;

		public HashEntry(K key, V val) {
			this.key = key;
			this.val = val;
		}

		public void add(HashEntry nextEntry) {
			if (this.key.equals(nextEntry.getKey()))  {
				this.val = (V) nextEntry.getVal();
				return;
			}
			if (this.next == null)
				this.next = nextEntry;
			else {
				this.next.add(nextEntry);
			}
		}

		public V get(K key) {
			if (this == null)
				return null;
			else {
				if (this.key.equals(key))
					return val;
				return (V) this.next.get(key);
			}
		}

		public V getVal() {
			return val;
		}

		public K getKey() {
			return key;
		}
	}

	private final static int TABLE_SIZE = 128;
	HashEntry[] table;

	public IHashTable() {
		table = new HashEntry[TABLE_SIZE];
	}

	public void put(K key, V val) {
		int hash = key.hashCode() % TABLE_SIZE;
		if (table[hash] != null) {
			HashEntry<K, V> head = table[hash];
			head.add(new HashEntry<K, V>(key, val));
		} else {
			table[hash] = new HashEntry<K, V>(key, val);
		}
	}

	public V get(K key) {
		int hash = key.hashCode() % TABLE_SIZE;
		if (table[hash] == null)
			return null;
		else {
			return (V) table[hash].get(key);
		}
	}
	
	public static void main(String[] args) {
		IHashTable<Integer, Integer> hashtable = new IHashTable<Integer, Integer>();
		hashtable.put(1, 1);
		hashtable.put(1, 2);
		hashtable.put(1, 3);
		hashtable.put(1, 4);
		hashtable.put(2, 2);
		hashtable.put(129, 129);
		hashtable.put(129+128, 129+128);
		System.out.println(hashtable.get(129));
		System.out.println(hashtable.get(129+128));
		System.out.println(hashtable.get(1));
		System.out.println(hashtable.get(2));
		
		
		
	}
}
