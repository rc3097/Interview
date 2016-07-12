/*
3. 鏈変竴涓猻tream锛� 閲岄潰鐨勬暟鎹槸銆婅偂绁ㄥ悕锛� 浠锋牸銆嬬殑鏁板锛� 鍔ㄦ�佽緭鍑哄嚭鐜伴鐜囨渶楂樼殑10鍙偂绁� 锛�
example锛� <APPL, 32>, <msfT, 50> < APPL, 38>.....閭ｄ箞APPL鐨勯鐜囨槸2锛� MSFT鐨勯鐜囨槸1
鐢ㄤ竴涓猻ize涓�10鐨刪eap锛� 鍜� 涓�涓猦ashmap鏉ヨ褰曟瘡涓偂绁ㄥ嚭鐜扮殑棰戠巼count   鏉ヨВ鍐炽�傚洜涓烘椂闂翠笉澶熶簡锛屾墍浠ュ彧璇翠簡鎬濊矾
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=187551&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
package bloomberg;

import java.util.*;
public class FreqStreamStock {
	class Stock implements Comparable<Stock>{
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

		@Override
		public int compareTo(Stock o) {
			// TODO Auto-generated method stub
			return o.price-this.price;
		} 
	}
	private PriorityQueue<Stock> heap; 
	private HashMap<String, Stock> map ;

	public FreqStreamStock() {
		heap = new PriorityQueue<>(10, new Comparator<Stock>() {

			@Override
			public int compare(Stock o1, Stock o2) {
				// TODO Auto-generated method stub
				return - o1.count +  o2.count;
			}}
		);
		map = new HashMap();
	}

	public void stream(String name, float price) {
		Stock stock = new Stock(name);
		if (map.containsKey(name)) {
			stock =  map.get(name);
		} 
		stock.updatePrice(price);
		map.put(name, stock);
		if (heap.size()>=10) {
			if (heap.contains(stock)) {
				heap.remove(stock);
				heap.offer(stock);
			} else {
				heap.offer(stock);
				heap.poll();
			}
		}
	}
	
	public static void main(String[] args) {
		FreqStreamStock q = new FreqStreamStock();
		PriorityQueue<FreqStreamStock.Stock> heap = new PriorityQueue<>();
		FreqStreamStock.Stock a = q.new Stock("AAPL");
		FreqStreamStock.Stock b = q.new Stock("GOOG");
		b.updatePrice(150);
		a.updatePrice(100);
		
		heap.offer(b);
		heap.offer(a);
		System.out.println(heap.peek().price);
		a.updatePrice(200);
		System.out.println(heap.peek().price);
		
		
		
	}
}