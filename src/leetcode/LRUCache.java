package leetcode;
import java.util.HashMap;

public class LRUCache {
	int capacity = 0;
	int cursize = 0;
	DoubleListNode head;
	DoubleListNode lastnode;
	HashMap<Integer, DoubleListNode> keyMap;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		keyMap = new HashMap<Integer, DoubleListNode>();
		lastnode = new DoubleListNode(-1, -1);
		head = new DoubleListNode(1, 1);
		head.pre = null;
		head.next = lastnode;
		lastnode.pre = head;
		lastnode.next = null;
	}

	public int get(int key) {
		if (keyMap.containsKey(key)) {
			DoubleListNode node = keyMap.get(key);
			if (node != head.next)
				movetohead(node, head, false);
			return node.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (keyMap.containsKey(key)) {
			DoubleListNode node = keyMap.get(key);
			node.val = value;
			if (node != head.next)
				movetohead(node, head, false);
		} else {
			DoubleListNode node = new DoubleListNode(key, value);
			keyMap.put(key, node);
			movetohead(node, head, true);
			cursize++;
		}

		if (cursize > capacity) {
			keyMap.remove(lastnode.pre.key);
			cursize--;
			removeLast(lastnode);
		}
	}

	private void removeLast(DoubleListNode lastnode) {
		DoubleListNode preone = lastnode.pre;
		preone.pre.next = lastnode;
		lastnode.pre = preone.pre;
	}

	private void movetohead(DoubleListNode node, DoubleListNode head,
			boolean isnew) {
		DoubleListNode nextone = head.next;
		head.next = node;
		if (!isnew) {
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		node.next = nextone;
		node.pre = head;
		nextone.pre = node;
	}

	private class DoubleListNode {
		int val = 0;
		int key = 0;
		DoubleListNode pre, next;

		public DoubleListNode(int key, int val) {
			this.val = val;
			this.key = key;
		}
	}
}