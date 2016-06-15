package leetcode;
import java.util.ArrayList;
import java.util.Random;

public class Googlecountry {
	private class Country {
		long population;
		String name;
		long precount;

		public Country(long population, String name, long sum) {
			this.population = population;
			this.name = name;
			this.precount = sum;
		}
	}

	ArrayList<Country> countries = new ArrayList<Googlecountry.Country>();
	long range = 0;

	public void load(String[] names, long[] populations) {
		long sum = 0;
		for (int i = 0; i < names.length; i++) {
			sum += populations[i];
			countries.add(new Country(populations[i], names[i], sum));
		}
		range = sum;
	}

	Random rs = new Random();

	public String randomCountry() {
		int l = 0;
		int r = countries.size()-1;
		long target = (long) (rs.nextDouble()*range);
		while (l <= r) {
			int mid  = (l+r)/2;
			if (countries.get(mid).precount >= target) {
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		return countries.get(l).name;
	}
}
