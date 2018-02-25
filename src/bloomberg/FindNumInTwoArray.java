package bloomberg;

/*
 * 第一题在前升后降的array里找某一个数
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=187844&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/
public class FindNumInTwoArray {
    public int findNum(int[] nums, int target) {
        int peekpos = findPeek(nums, 0, nums.length - 1);
        int pos = lbinarysearch(nums, 0, peekpos, target);
        if (pos != -1) return pos;
        pos = reverse_lbinarysearch(nums, peekpos, nums.length - 1, target);
        return pos;
    }

    private int lbinarysearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r < 0 || r > nums.length - 1) return -1;
        return nums[r] == target ? r : -1;
    }

    private int reverse_lbinarysearch(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r < 0 || r > nums.length - 1) return -1;
        return nums[r] == target ? r : -1;
    }

    private int findPeek(int[] nums, int start, int end) {
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (nums[mid] < nums[mid + 1]) {
            return findPeek(nums, mid + 1, end);
        } else {
            return findPeek(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        FindNumInTwoArray q = new FindNumInTwoArray();
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6, 5, 4, 3, 1}, 2)); //1
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6, 5, 4, 3, 1}, 6)); //4
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6, 4, 3, 1}, 2)); //1
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6, 4, 3, 1}, 6)); //4
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6, 4, 3, 1}, 4)); //3
        System.out.println(q.findNum(new int[]{6, 4, 3, 1}, 2)); //-1
        System.out.println(q.findNum(new int[]{6, 4, 3, 1}, 4)); //1
        System.out.println(q.findNum(new int[]{1, 6, 4, 3}, 1)); //0
        System.out.println(q.findNum(new int[]{1, 2, 3, 4, 6}, 2)); //1
    }
}
