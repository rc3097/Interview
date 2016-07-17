package bloomberg;
import java.util.*;
/*
 * 鐩存帴HackRanker鐮侀銆備笂鏉ュ氨璁ヾesign class Family Tree锛岃涓�涓搴湁1-2涓汉锛屾瘡涓汉閮芥湁0-2涓猚hildren,璁╁紑濮嬭璁lass. 涓�鑴告嚨閫硷紝璇村ソ鐨凾wo sum鍛�.
杩欎釜棰樼洰灏辫〃杩扮殑涓嶅お娓呮锛屽埌搴曟槸璁捐鍟ョ帺鎰忥紝闂粬浠栦篃璁蹭笉娓呮銆備竴寮�濮嬫垜杩樻兂鎼炰釜Binary tree閭ｆ牱锛屼絾鍥犱负鎼炰笉娓呮浠栧埌搴曟兂瑕佷粈涔堬紝灏辩瀻璁捐浜嗕竴涓狥amily class,
閲岄潰鏄暟缁凱eople[] parents, People[] children锛屽洜涓烘垜浠ヤ负浠栬鐨勬槸涓�涓猣amily鍙湁涓�灞傦紒鍚勭涔辨敼銆傘�備及璁″皬鍝ョ湅鐨勫穿婧冧簡銆�
鍚庢潵閫氳繃浠栬璁捐鐨勯棶棰樹簡瑙ｅ埌鏄鎼炴暣涓猣amily鏈夊摢浜涗汉锛屽叾瀹炲氨鏄嬁涓猦ashMap瀛樿繖涓猣amily鎵�鏈夋垚鍛橈紝姣忎釜鎴愬憳鏄釜鍗曠嫭鐨凱eople class,閲岄潰鏈塶ame鍜宑hildren...鍝ュ摜浣犳槸鍧戞垜鍢�
鐒跺悗灏辫璁捐涓�涓猰ethod鍒ゆ柇涓�涓汉鏄笉鏄繖涓猣amily鐨勬垚鍛橈紝鐒跺悗涓�涓猰ethod鍒ゆ柇涓や釜浜烘槸涓嶆槸cousin....
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

		public boolean equals(Person o1) {
			return this.id == o1.id;
		}
	}

	HashMap<Integer, Person> members = new HashMap();

	public boolean checkFamily(Person o) {
		if (members.containsKey(o.id)) return true;
		return false;
	}

	public boolean isCousin(Person o1, Person o2) {
		if (o1.equals(o2)) return false;
		if (isSilbing(o1,o2)) return false;
		for (Person i:o1.parents) {
			for (Person  j:o2.parents ) {
				if (isSilbing(i,j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSilbing(Person o1, Person o2) {
		if (o1.equals(o2)) return false;
		if (o1.parents[0].equals(o2.parents[0]) && o1.parents[1].equals(o2.parents[1])) {
			return true;
		}
		return false;
	}
	
}
