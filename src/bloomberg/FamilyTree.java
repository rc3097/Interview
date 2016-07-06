package bloomberg;

/*
 * 直接HackRanker码题。上来就让design class Family Tree，说一个家庭有1-2个人，每个人都有0-2个children,让开始设计class. 一脸懵逼，说好的Two sum呢.
这个题目就表述的不太清楚，到底是设计啥玩意，问他他也讲不清楚。一开始我还想搞个Binary tree那样，但因为搞不清楚他到底想要什么，就瞎设计了一个Family class,
里面是数组People[] parents, People[] children，因为我以为他说的是一个family只有一层！各种乱改。。估计小哥看的崩溃了。
后来通过他让设计的问题了解到是要搞整个family有哪些人，其实就是拿个hashMap存这个family所有成员，每个成员是个单独的People class,里面有name和children...哥哥你是坑我嘛
然后就让设计一个method判断一个人是不是这个family的成员，然后一个method判断两个人是不是cousin....
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190544&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class FamilyTree {
	private class Person {
		int id;
		Person[] parents;
		Person[] children;
		public Person(int id, Person[] parents, Person[] children) {
			this.id = id;
			this.parents=parents;
			this.children = children;
		}
	}

	Person[] members;
	
}
