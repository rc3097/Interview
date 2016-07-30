package bloomberg;

import java.util.*;
/*
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192697&pid=2499904&page=1&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3089%255D%255Bvalue%255D%255B3%255D%3D3%26searchoption%255B3089%255D%255Btype%255D%3Dcheckbox%26searchoption%255B3046%255D%255Bvalue%255D%3D14%26searchoption%255B3046%255D%255Btype%255D%3Dradio#pid2499904
股票那个题目，一直有新的股票交易加到系统中（String id, int volume(正数))。 一天结束后要求你返回volumn总和最大的20个。然后扩展到随时返回。。
*/
public class Top20Volume {
	class Stock {
		String id;
		int volume;
		public Stock(String id) {
			this.id = id;
			this.volume = 0;
		}

		public void add(int volume) {
			this.volume+=volume;
		}
	}
	HashMap<String, Stock> map = new HashMap();

	public void add(String id, int volume) {
		Stock cur = new Stock(id);
		if (map.containsKey(id)) {
			cur = map.get(id);
		}
		cur.add(volume);
	}

	public Stock[] findTop20() {
		PriorityQueue<Stock> minheap = new PriorityQueue(20, new Comparator<Stock>(){
			public int compare(Stock o1, Stock o2) {
				return o1.volume-o2.volume;
			}
		});

		for (Map.Entry<String, Stock> entry: map.entrySet()) {
			Stock stock = entry.getValue();
			minheap.offer(stock);
			if (minheap.size()>20) {
				minheap.poll();
			}
		}

		Stock[] stocklist = new Stock[20];
		int idx = 0;
		while (!minheap.isEmpty())
			stocklist[idx++] = minheap.poll();
		return stocklist;
	}

	public static void main(String[] args) {
		System.out.println(true?true:false?true?1:2:false?1:4);
	}
}