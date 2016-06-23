package bloomberg;

import java.util.Random;


/*
 * 第一轮第二题： 爬楼梯题，   一个人爬楼梯，有一个已知function： jump()  会随机return true false;    如果jump return true， 这个人上一台阶。 反之 下一个台阶。我们要implement 一个function 叫做enforcejump();  就是这个function要确保这个人必须是上一个台阶。  要用到 jump（）   这个楼主跟面试官讨论了题目， 高清之后开始做。 做出来了。
 * http://www.1point3acres.com/bbs/thread-193782-1-1.html
 */
public class ForceJump {
	public boolean jump() {
		Random random = new Random();
		return random.nextBoolean();
	}
	public void enforeJump() {
		if (jump()) return;
		enforeJump();
		enforeJump();
	}
}
