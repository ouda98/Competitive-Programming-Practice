import java.util.HashSet;

public class ConnectedComponentsInList {
    public class DoublyListNode {
        int val;
        DoublyListNode prev;
        DoublyListNode next;

        DoublyListNode(int x) {
            val = x;
            prev = next = null;
        }
    }

    public class Solution {
        /**
         * @param head:  the given doubly linked list
         * @param nodes: the given nodes array
         * @return: the number of blocks in the given array
         */
        public int blockNumber(DoublyListNode head, int[] nodes) {
            // write your code here
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nodes.length; i++)
                set.add(nodes[i]);

            DoublyListNode h = head;
            int result = 0;
            while (h != null) {
                if (set.contains(h.val)) {
                    result++;
                    while (h != null && set.contains(h.val)) {
                        h = h.next;
                    }
                }
                if (h != null)
                    h = h.next;
            }
            return result;
        }
    }
}
