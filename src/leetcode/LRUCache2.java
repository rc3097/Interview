package leetcode;
import java.util.HashMap;

public class LRUCache2 {
	class DoubleLinkedNode {
		public int key = 0;
		public int val = 0;
		public DoubleLinkedNode prev = null;
		public DoubleLinkedNode next = null;

		public DoubleLinkedNode(int key, int value, DoubleLinkedNode prev,
				DoubleLinkedNode next) {
			this.key = key;
			this.val = value;
			this.prev = prev;
			this.next = next;
		}
	}

	private int capacity = 0;
	private int currsize = 0;
	private HashMap<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();
	DoubleLinkedNode head = null;
	DoubleLinkedNode tail = null;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		head = new DoubleLinkedNode(-1, 0, null, null);
		tail = new DoubleLinkedNode(-1, 0, null, null);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (currsize == 0)
			return -1;
		if (map.containsKey(key)) {
			int res = map.get(key).val;
			movetohead(map.get(key), false);
			return res;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedNode node = map.get(key);
			node.val = value;
			movetohead(node, false);
		} else {
			DoubleLinkedNode node = new DoubleLinkedNode(key, value, head,
					head.next);
			head.next.prev = node;
			head.next = node;
			map.put(key, node);
			currsize++;
			if (currsize > capacity) {
				DoubleLinkedNode lastnode = tail.prev;
				tail.prev = tail.prev.prev;
				tail.prev.next = tail;
				map.remove(lastnode.key);
				currsize--;
			}
		}
	}

	public String print() {
		String res = "";
		DoubleLinkedNode p = head;
		while (p != null) {
			res += p.key + ",";
			p = p.next;
		}
		return res;
	}

	public void movetohead(DoubleLinkedNode node, boolean isNew) {
		if (!isNew) {
			DoubleLinkedNode preone = node.prev;
			DoubleLinkedNode nextone = node.next;
			preone.next = nextone;
			nextone.prev = preone;
		}
		DoubleLinkedNode nextone = head.next;
		head.next = node;
		node.prev = head;
		node.next = nextone;
		nextone.prev = node;
	}
}