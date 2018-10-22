
import com.coppco.leetCode01.Solution01;
import com.coppco.leetCode02.ListNode;
import com.coppco.leetCode02.Solution02;
import com.coppco.leetCode03.Solution03;
import org.apache.log4j.Logger;


/**
 * Hello world!
 *
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        leetCode03();
    }


    private static void leetCode01() {
        int[] array = {3, 6, 7, 11};
        int target = 10;

        int[] result = Solution01.twoSum(array, target);

        logger.info(result[0]);
        logger.info(result[1]);
    }

    private static void leetCode02() {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(9);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        b.next.next.next = new ListNode(1);

        ListNode result = Solution02.addTwoNumbers(a, b);

        logger.info(result.val);

        logger.info(result.next.val);

        logger.info(result.next.next.val);
        logger.info(result.next.next.next.val);
        logger.info(result.next.next.next.next.val);
    }

    private static void leetCode03() {
        String target = "abcdaefghijka";

        logger.info(Solution03.lengthOfLongestSubstring(target));
    }
}
