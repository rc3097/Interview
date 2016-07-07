/*
3. 有一个stream， 里面的数据是《股票名， 价格》的数对， 动态输出出现频率最高的10只股票 ：
example： <APPL, 32>, <msfT, 50> < APPL, 38>.....那么APPL的频率是2， MSFT的频率是1
用一个size为10的heap， 和 一个hashmap来记录每个股票出现的频率count   来解决。因为时间不够了，所以只说了思路
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=187551&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
package bloomberg;

public class FreqStreamStock {
	class Stock {
		String name;
		int count=0;
		int price; //price * 100
		public Stock(String name) {
			this.name = name;
		}

		public void updatePrice(float price) {
			this.price=(int)price*100;
			count++;
		} 
	}
	private PriorityQueue<Stock> heap; 
	private HashMap<name, Stock> map ;

	public FreqStreamStock() {
		heap = new PriorityQueue(10, new Comparator<Stock> {
			public int compare(Stock o1, Stock o2) {
				return - o1.count +  o2.count;
			}
		});
		map = new HashMap();
	}

	public void stream(String name, float price) {
		Stock stock = new Stock(name);
		if (map.containsKey(name)) {
			stock =  map.get(name);
		} 
		stock.updatePrice(price);
		map.push(name, stock);
		heap.offer(stock);
		if (heap.size()>10) 
			heap.poll();
	}
}