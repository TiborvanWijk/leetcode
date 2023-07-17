public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        x.next = y;
        System.out.println(new solutions().removeElements(x, 1));

    }
}