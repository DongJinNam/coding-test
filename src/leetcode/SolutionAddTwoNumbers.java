/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        List<ListNode> list = new ArrayList();
        List<Integer> valList = new ArrayList();
        int addVal = 0;
        while (l1 != null || l2 != null) {

            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            
            int result = v1 + v2 + addVal;
            addVal = result / 10;

            valList.add(result % 10);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (addVal > 0) valList.add(addVal);
        for (int i = valList.size()-1; i >= 0; i--) {
            if (i == valList.size() - 1)
                list.add(new ListNode(valList.get(i), null));
            else
                list.add(new ListNode(valList.get(i), list.get(valList.size()-2-i)));
        }
        return list.get(list.size()-1);
    }
}
