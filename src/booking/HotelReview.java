package booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class HotelReview {
	public class Hotel {
		int ID;
		int count;

		public Hotel(int ID, int count) {
			this.ID = ID;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		HotelReview q = new HotelReview();
		HashMap<Integer, Hotel> hotelMap = new HashMap();
		Scanner in = new Scanner(System.in);
		HashSet<String> wordset = new HashSet();
		String words = in.nextLine();
		for (String word : words.split(" "))
			wordset.add(word);

		int num = Integer.valueOf(in.nextLine());

		for (int i = 0; i < num; i++) {
			int ID = Integer.valueOf(in.nextLine());
			String review = in.nextLine();

			if (!hotelMap.containsKey(ID)) {
				Hotel temp = q.new Hotel(ID, 0);
				hotelMap.put(ID, temp);
			}

			review.replace(".", " ");
			review.replace("!", " ");
			review.replace("?", " ");
			review.replace(",", " ");
			review.replace("\"", " ");
			review.replace("\'", " ");

			for (String word : review.split(" ")) {
				if (wordset.contains(word)) {
					hotelMap.get(ID).count++;
				}
			}
		}
		
		
		ArrayList<Hotel> res = new ArrayList<Hotel>();
		for (Map.Entry<Integer, Hotel> entry: hotelMap.entrySet()) {
			res.add(entry.getValue());
		}
		
		Collections.sort(res, new Comparator<Hotel>() {

			@Override
			public int compare(Hotel o1, Hotel o2) {
				// TODO Auto-generated method stub
				if (o1.count==o2.count) return o1.ID-o2.ID;
				return -o1.count+o2.count;
			}
			
		});
		
		for (Hotel hotel: res) {
			System.out.print(hotel.ID+" ");
		}
	}
}
