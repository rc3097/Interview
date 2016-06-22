package leetcode;
public class RateLimiter {
	private int RPS = 0;
	private long timestamp = System.currentTimeMillis();
	private int tokens = 0;
	private int capicity;

	public RateLimiter(int RPS, int capicity) {
		this.RPS = RPS;
		this.capicity = capicity;
	}

	public boolean makeRequest() {
		long now = System.currentTimeMillis();
		tokens += (now - timestamp) *RPS / 1000 ;
		if (tokens > capicity)
			tokens = capicity;
		timestamp = now;
		if (tokens == 0)
			return false;
		tokens--;
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		RateLimiter limiter = new RateLimiter(3, 3);
		Thread.sleep(1000);
		for (int i = 0; i < 5; i++) {
			System.out.println(limiter.makeRequest());
		}
		Thread.sleep(1000L);
		for (int i = 0; i < 5; i++) {
			System.out.println(limiter.makeRequest());
		}

	}

}
