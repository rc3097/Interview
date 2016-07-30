package bloomberg;
import java.util.*;

/*
*第一题，设计一个数据结构能够处理网页的backward,forward 和 show history.
*楼主用了两个stack, 每访问一个网页就把网址压进stack1,然后backward就把stack1的top压进stack2. show history就把stack2里的都压进stack1,然后都pop出来。
*女面说如果只在两个网页切换，history应该显示多次交替访问的纪录，两个stack搞不了。再加个array记录history。 两人表示可以。
*http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197658&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
public class WebHistory{
	private Stack<String> preStacks= new Stack();
	private Stack<String> nextStacks = new Stack();
	private ArrayList<String> history = new ArrayList();

	public WebHistory(){}
	String currentUrl = null;

	private void setUrl(String url) {
		this.currentUrl = url;
		history.add(url);
	}
	public void read(String url) {
		if (this.currentUrl!=null) {
			preStacks.push(this.currentUrl);
		}
		setUrl(url);
	}

	public String previousView() {
		if (!preStacks.isEmpty()) {
			nextStacks.push(this.currentUrl);
			setUrl(preStacks.pop());
			return this.currentUrl;
		}
		return null;
	}

	public String nextView() {
		if (!nextStacks.isEmpty()) {
			preStacks.push(this.currentUrl);
			setUrl(nextStacks.pop());
			return this.currentUrl;
		}
		return null;
	}
}