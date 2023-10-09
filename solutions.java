import java.math.BigInteger;
import java.nio.file.NotDirectoryException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Every function is a different leetCode problem
 *
 *
 */
public class solutions {
//    ArrayList<Integer> dummy = new ArrayList<>();

//    public ArrayList<Integer> InorderTreversal(Node root) {
//        if (root == null) return ans;
//        InorderTreversal(root.left);
//        System.out.println(root);
//        InorderTreversal(root.right);
//        return ans;
//    }

    //    checks if there is a duplicate by storing the variables
//    and the seeing if the next number is already being stored in the hashset
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (seen.contains(number)) return true;
            seen.add(number);
        }
        return false;
    }


    //    check if a word is spelled the same backwards as forwards
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);


        return Arrays.equals(sChars, tChars);
    }


//    public int[] twoSum(int[] nums, int target) {
//
//        Map<Integer, Integer> list = new HashMap<>();
//
//        for(int i = 0; i < nums.length; i++){
//            if (list.containsKey(nums[i])){
//                return new int[] {list.get(nums[i]), i};
//            }
//            else {
//                list.put(target - nums[i], i);
//            }
//        }
//        return nums;
//    }

    // checks if diffrent words use the exact same amount of letters
//    and puts all words of the words that are the same in a list
//    it groups them together by sorting the word and looking it up in a hashmap
//    if it contains the sorted word the word gets added to the list with the other word(s).
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> list = new HashMap<>();

        for (String word : strs) {
            char[] toArray = word.toCharArray();
            Arrays.sort(toArray);
            String sortedWord = new String(toArray);

            if (!list.containsKey(sortedWord)) {
                list.put(sortedWord, new ArrayList<>());
            }
            list.get(sortedWord).add(word);

        }


        return new ArrayList<>(list.values());
    }


//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> list = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++){
//            int count = list.containsKey(nums[i]) ? list.get(nums[i]) + 1 : 1;
//            list.put(list.getOrDefault(nums[i], 1, ++));
//            list.put(nums[i], count);
//
//        }
//        for (int j = 0; j <= k; j++) {
//
//            for (int i = 0; i < list.size(); i++) {
//
//            }
//        }


    //    checks the longestConsecutive example: 1,2,3,4,6 = 4;
//    it does this by looping over the array and checking if
//    the number is the same as the next number - 1 meaning it incremented by one
//    every time it is the same the temp variable increases by one and if this
//    variable is bigger than ans, ans = temp
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int ans = 0;
        int temp = 0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                temp++;
                ans = Math.max(temp, ans);
            } else if (nums[i] == nums[i + 1]) {
                ans = Math.max(temp, ans);
            } else {
                temp = 1;
                ans = Math.max(temp, ans);
            }


        }

        return ans;
    }



    //    checks if a string containing parameters are correctly opened and closed
//    by using a stack to see if the top is the same type when a parameter is closed
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }


//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] ans = new int[temperatures.length];
//
//        for (int i = 0; i < temperatures.length; i++){
//            for (int j = i + 1; j < temperatures.length; j++){
//                if (temperatures[i] < temperatures[j]){
//                    ans[i] = j - i;
//                    break;
//                }
//            }
//        }
//
//        return ans;
//
//
//
//    }
//public int[] dailyTemperatures(int[] temperatures) {
//    int[] ans = new int[temperatures.length];
//
//    for (int i = 0; i < temperatures.length; i++){
//
//    }
//
//    return ans;
//
//
//
//}
//    public int[] dailyTemperatures(int[] temp) {
//        Stack<Integer> stack = new Stack<>();
//        int[] ans = new int[temp.length];
//
//        for (int i = 0; i < temp.length; i++){
//
//            while (!stack.empty() && stack.peek() <= temp[i]){
//                stack.pop();
//            }
//
//            if (!stack.empty()){
//                ans[i] = stack.peek() - 1;
//            }
//
//            stack.push(i);
//        }
//        return ans;
//    }

    //    checks if a word is typed the same forwards as backwards
//    by implementing a StringBuilderClass
//    public boolean isPalindrome(String s) {
//        StringBuilder reverse = new StringBuilder();
//        s = s.toLowerCase();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetterOrDigit(s.charAt(i))) {
//                reverse.append(s.charAt(i));
//            }
//        }
//        return String.valueOf(reverse).equals(String.valueOf(reverse.reverse()));
//    }

    //    finds two numbers in a sorted array that add up to the given target
//    by implementing a two pointer
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        while (startIndex < endIndex) {

            if (numbers[startIndex] + numbers[endIndex] > target) {
                endIndex--;
            } else if (numbers[startIndex] + numbers[endIndex] < target) {
                startIndex++;
            } else {
                ans[0] = startIndex + 1;
                ans[1] = endIndex + 1;
                return ans;
            }
        }
        return ans;
    }



















    // checks if a number is unique and not seen before
//    this is without bit-manipulation and uses a
//    hashmap to check the amount on times a variable is stored
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;

            map.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                ans = entry.getKey();
                break;
            }
        }

        return ans;
    }






    // checks the best time to buy in a stockmarket
//    by calculating the biggest number difference from small to big
    public int maxProfit1(int[] prices) {
        int leftPointer = 0;
        int rightPointer = 1;
        int max = 0;
        while (rightPointer < prices.length){
            if (prices[rightPointer] < prices[leftPointer]){
                leftPointer = rightPointer;
                rightPointer++;
            }
            else if ((prices[rightPointer] - prices[leftPointer]) > max){
                max = prices[rightPointer] - prices[leftPointer];
            }
            else {
                rightPointer++;
            }
        }
        return max;
    }

    // checks the longest substring without repeating letters
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++){

            while (stack.contains(s.charAt(i))){
                stack.remove(0);
            }
            stack.add(s.charAt(i));
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }





//    public boolean checkInclusion(String s1, String s2) {
//
//        Map<Character, Integer> s1Array = new HashMap<>();
//        Map<Character, Integer> s2Array = new HashMap<>();
//
//        for (int i = 0; i < s1.length(); i++){
//            int count = s1Array.containsKey(s1.charAt(i)) ? s1Array.get(s1.charAt(i)) + 1 : 1;
//            s1Array.put(s1.charAt(i), count);
//        }
//        for (int i = 0; i < s2.length(); i++){
//            int count = s2Array.containsKey(s1.charAt(i)) ? s2Array.get(s1.charAt(i)) + 1 : 1;
//            s2Array.put(s2.charAt(i), count);
//        }
//
//        for (int i = 0; i < )
//
//    }

    // adds 1 to a array that repesents a normal number
//    example [1,2,3]= 123
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }



//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1!=null && list2!=null){
//            if(list1.val<list2.val){
//                list1.next=mergeTwoLists(list1.next,list2);
//                return list1;
//            }
//            else{
//                list2.next=mergeTwoLists(list1,list2.next);
//                return list2;
//            }
//        }
//        if(list1==null)
//            return list2;
//        return list1;
//    }











    // finds the maximum number in an array when looking at a certain amount of data
//    brute force
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) return nums;
//        int[] ans = new int[nums.length - (k - 1)];
//
//        for (int i = 0; i <= nums.length - k; i++){
//            int max = nums[i];
//            for (int j = 1; j < k; j++){
//                max = Math.max(max, nums[i + j]);
//            }
//            ans[i] = max;
//        }
//        return ans;
//    }



    // binary search checks if the middle of the sorted array is
// the same as the target if not it removes half of the array
//    by comparing the middle number to the target
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            else if (target > nums[middle]) {
                low = middle + 1;
            }
            else if (target < nums[middle]){
                high = middle - 1;
            }
        }


        return -1;
    }

//    public int minDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//
//
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//
//        if (root.left != null && root.right != null){
//            return Math.min(left, right) + 1;
//        }
//        return Math.max(left, right) + 1;
//
//    }




//  recursive
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                list1.next = mergeTwoLists(list1.next, list2);
//                return list1;
//            } else {
//                list2.next = mergeTwoLists(list1, list2.next);
//                return list2;
//            }
//        }
//        if(list1==null){
//            return list2;
//        }
//        return list1;
//    }

//    iterative
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode dummy = new ListNode();
//        ListNode tail = dummy;
//        while (list1 != null && list2 != null){
//            if (list1.val <= list2.val){
//                dummy.next = new ListNode(list1.val);
//                list1 = list1.next;
//            }
//            else {
//                dummy.next = new ListNode(list2.val);
//                list2 = list2.next;
//            }
//            dummy = dummy.next;
//        }
//        while(list1 != null){
//            dummy.next = new ListNode(list1.val);
//            list1 = list1.next;
//            dummy = dummy.next;
//        }
//        while(list2 != null){
//            dummy.next = new ListNode(list2.val);
//            list2 = list2.next;
//            dummy = dummy.next;
//        }
//        return tail.next;
//    }



    //    public ListNode reverseList(ListNode head) {
//
//        if(head == null){
//            return null;
//        }
//        ListNode newHead = head;
//
//        if (head.next != null){
//            newHead = reverseList(head.next);
//            head.next.next = head;
//        }
//        head.next = null;
//
//
//
//        return newHead;
//    }
//    1->2->3
//    ->4->5
// calculates the most amount of water
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = 0;

        while (low < high){
            int water = Math.min(height[low], height[high]) * (high - low);
            max = Math.max(max, water);
            if (height[low] <= height[high]){
                low++;
            }
            else if (height[low] > height[high]){
                high--;
            }
        }


        return max;
    }
//    public ListNode reverseList(ListNode head) {
//
//        if(head == null){
//            return null;
//        }
//        ListNode newHead = head;
//
//        if (head.next != null){
//            newHead = reverseList(head.next);
//            head.next.next = head;
//        }
//        head.next = null;
//
//
//
//        return newHead;
//    }
//    1->2->3
//    ->4->5


    public int trap(int[] height) {
        if (height == null){
            return 0;
        }

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int water = 0;
        int i = 0;

        while (i < height.length){
            maxLeft = Math.max(maxLeft,height[leftPointer]);
            maxRight = Math.max(maxRight,height[rightPointer]);

            water += Math.max(Math.min(maxLeft, maxRight) - height[i], 0);

            if (height[leftPointer] > height[rightPointer]){
                rightPointer--;
            }
            else{
                leftPointer++;
            }


            i++;
        }

        return water;
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++){
            int high = matrix[i].length - 1;
            int low = 0;
            while (low <= high){
                int middle = low + (high - low) / 2;

                if (matrix[i][middle] == target){
                    return true;
                }
                else if (target > matrix[i][middle]){
                    low = middle + 1;
                }
                else {
                    high = middle - 1;
                }

            }
        }

        return false;

    }















//
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//
//        return root;
//    }



























//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }







//    public boolean canJump(int[] nums) {
//        if (nums.length == 1 && nums[0] == 1){
//            return true;
//        }
//        else  if (nums.length == 1 && nums[0] == 0){
//            return true;
//        }
//        int jumNr = nums[0];
//        while (jumNr <= nums.length - 1){
//            jumNr += nums[jumNr];
//
//            if (jumNr >= nums.length || nums[jumNr] == nums[nums.length - 1]){
//                return true;
//            }
//            else if (nums[jumNr] == 0){
//                return false;
//            }
//
//        }
//
//        return false;
//    }






//    public ListNode canJump(ListNode head) {
//
//        if (head == null){
//            return null;
//        }
//
//        ListNode newHead = head;
//
//        if (head.next != null){
//            newHead = canJump(head.next);
//            head.next.next = head;
//        }
//        head.next = null;
//
//    return newHead;
//    }
// 1->2->

    public int searchRotated(int[] nums, int target) {

        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer <= rightPointer){
            int middle = (leftPointer + rightPointer) / 2;

            if (nums[middle] == target){
                return middle;
            }
            if (nums[leftPointer] <= nums[middle]){
                if (target > nums[middle] || target < nums[leftPointer]){
                    leftPointer = middle + 1;
                }
                else {
                    rightPointer = middle - 1;
                }
            }
            else {
                if (target < nums[middle] || target > nums[rightPointer]){
                    rightPointer = middle - 1;
                }
                else {
                    leftPointer = middle + 1;
                }
            }
        }


        return -1;
    }



















//    public boolean isPalindrome(int x) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(x);
//
//        return String.valueOf(stringBuilder).equals(String.valueOf(stringBuilder.reverse()));
//    }



// removes elements in a list by using iteration

//    public ListNode removeElementsIterative(ListNode head, int val) {
//
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode prev = dummy;
//        ListNode current = head;
//
//        while (current != null){
//            ListNode nxt = current.next;
//
//            if (current.val == val){
//                prev.next = nxt;
//            }
//            else {
//                prev = current;
//            }
//            current = current.next;
//
//        }
//
//       return dummy.next;
//    }
// 1->2->
// removes elements in a list by using recursion
//    public ListNode removeElementsRecursive(ListNode head, int val) {
//        if (head == null) return null;
//
//
//        ListNode next = removeElementsRecursive(head.next, val);
//
//        if (head.val == val){
//            head = next;
//        }
//        else {
//            head.next = next;
//        }
//
//        return head;
//    }
// 1 -> 2 ->






































    // finds the location of a target and if the target is not
// in the sorted array then it will return the location of where this element should be.
// implements binary search if the target is found then it will be returned
// otherwise it will keep looping until the left pointer is the same or bigger
// then the right pointer it will return the left pointer otherwise known as
// the place where the new element should be
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right){
            middle = left + (right - left) / 2;

            if (nums[middle] == target){
                return middle;
            }
            else if (nums[middle] < target){
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }

        }

        return left;
    }


    // finds the first word in a sentence by striping
// the sides of tabs or spaces and then looping from
// each character until there is a space
    public int lengthOfLastWord(String s) {
        s = s.strip();
        char[] array = s.toCharArray();
        int ans = 0;
        for (int i = array.length - 1; i >= 0; i--){
            if (array[i] == ' '){
                break;
            }
            else {
                ans++;
            }


        }

        return ans;
    }







    // stores the count of every character and returns the first one that is counted once
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            int count = map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1: 1;

            map.put(s.charAt(i), count);


        }
        for (int i = 0; i < s.length(); i++){

            if (map.get(s.charAt(i)) == 1){
                return s.indexOf(s.charAt(i));
            }

        }
        return -1;
    }





    public int myAtoi(String s) {

        long ans = 0;
        int neg = 0 , i = 0;
        for(; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                char ch = s.charAt(i);
                if(ch == '+' || ch == '-') i++;
                if(ch == '-') neg = 1;
                break;
            }
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(c > '9' || c < '0') break;
            ans = ans * 10 + (c - '0');
            if(ans > 2147483647){
                return neg == 1? -2147483648:2147483647;
            }
        }
        if(neg == 1) return (int) ans * -1;
        return (int)ans;
    }












    // adds three numbers to each other to a total of 0
// without duplicate uses.
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];

                while (low<high){
                    if (nums[low] + nums[high] == target){
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low<high && nums[low] == nums[low + 1]) low++;
                        while (low<high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < target){
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return list;
    }




// checks if the two trees are the same.
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//        if (p == null && q == null) return true;
//
//        if (p == null || q == null || p.val != q.val) return false;
//
//        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
//
//    }
//// checks if the tree is symmetrical.
//    public boolean isSymmetric(TreeNode root) {
//
//        if (root == null) return true;
//
//        return isSymmetricHelper(root.left, root.right);
//    }
//    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
//
//        if (left == null && right == null) return true;
//
//        if (left == null || right == null) return false;
//
//        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
//
//    }


    public double trimMean(int[] arr) {

        Arrays.sort(arr);

        int delete = arr.length / 20;

        for (int i = 0; i < delete; i++){
            arr[i] = 0;
            arr[(arr.length-1) - i] = 0;
        }

        int min = arr[0];
        int max = arr[0];
        double ans = 0;

        for (int i = 0; i < arr.length; i++){
            ans += arr[i];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        ans = ans / (arr.length - delete * 2);

        return ans;

    }








    // makes a 2d matrix out of a normal array with the given amount of rows and columns
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (m * n != original.length) return new int[0][0];
        int[][] ans = new int[m][n];
        int x = 0;
        for (int i = 0; i < ans.length; i++){

            for (int j = 0; j < n; j++){
                ans[i][j] = original[x];
                x++;
            }
        }

        return ans;
    }


    //// checks if all the values in a tree are the same if they are then it returns true.
//    public boolean isUnivalTree(TreeNode root) {
//        if (root.left == null && root.right == null) return true;
//
//        return helper(root.right, root.val) && helper(root.left, root.val);
//    }
//
//    public boolean helper(TreeNode root, int val) {
//        if (root == null) return true;
//
//        return root.val == val && helper(root.left,val) && helper(root.right, val);
//    }
//
// Convert Sorted Array to Binary Search Tree
//    public TreeNode sortedArrayToBST(int[] nums) {
//
//        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
//    }
//    //    makes a binary search tree out of a sorted array
//    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
//        if (left > right) return null;
//
//        int middle = (left + right) / 2;
//
//        TreeNode root = new TreeNode();
//        root.val = nums[middle];
//
//        root.left = sortedArrayToBSTHelper(nums, left, middle - 1);
//        root.right = sortedArrayToBSTHelper(nums, middle + 1, right);
//
//
//
//        return root;
//    }


















// merges two trees if the same node exists then the value is added to one another
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root2 == null) return root1;
//        if (root1 == null) return root2;
//
//        TreeNode ans = new TreeNode(root1.val + root2.val);
//        ans.left = mergeTrees(root1.left, root2.left);
//        ans.right = mergeTrees(root1.right, root2.right);
//        return ans;
//    }


    //merges two integer arrays
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }





    //removes duplicates in an array
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }









    //[0,0,1,1,1,2,2,3,3,4]
//    112
    public int removeDuplicates(int[] nums) {

        int left = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i - 1]){
                nums[left] = nums[i];
                left++;
            }
        }

        return left;
    }
    // check if a certain number is the majority of the array in this case its more than half of all the elements
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            Integer count = map.containsKey(nums[i]) ? map.get(nums[i]) +1 : 1;

            map.put(nums[i], count);
        }
        int majority = 0;

        for (Integer key : map.keySet()){
            if (map.get(key) > ((nums.length / 2))){
                majority = key;
            }
        }

        return majority;
    }











    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - (needle.length() -1); i++){
            boolean contains = true;

            for (int j = 0; j < needle.length(); j++){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    contains = false;
                    break;
                }
            }
            if (contains){
                return i;
            }

        }
        return -1;
    }

    // checks if it's a substring in order
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int index = 0;

        for (int i = 0; i < t.length(); i++){

            if (s.charAt(index) == t.charAt(i)){
                index++;
                if (index == s.length()) return true;
            }

        }

        return false;
    }


    // checks if a note can be made with the letter/symbols in the magazine
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++){
            int count = magazineMap.containsKey(magazine.charAt(i)) ? magazineMap.get(magazine.charAt(i)) + 1 : 1;

            magazineMap.put(magazine.charAt(i), count);
        }
        for (int i = 0; i < ransomNote.length(); i++){

            if (magazineMap.containsKey(ransomNote.charAt(i)) && magazineMap.get(ransomNote.charAt(i)) > 0){
                magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) -1);
            }
            else return false;

        }
        return true;
    }












//    public int[] plusOne(int[] digits) {
//        for (int i = digits.length - 1; i >= 0; i--){
//            if (digits[i] < 9){
//                digits[i]++;
//                return digits;
//            }
//            digits[i] = 0;
//        }
//
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//
//        return digits;
//    }




    // finds the carrot of a number without using the sqrt function
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int start = 1;
        int end = x;
        int mid = -1;

        while (start <= end) {

            mid = start + (end - start) / 2;
            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
                return mid;
            else
                start = mid + 1;
        }
        return Math.round(end);
    }


    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }










    public int removeDuplicates2(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length){
            int count = 1;
            while (right + 1 < nums.length && nums[right] == nums[right + 1]){
                count++;
                right++;
            }

            for (int i = 0; i < Math.min(2, count); i++){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;

    }



    public void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++){

            if (i + k < nums.length){
                nums2[i+k] = nums[i];
            }
            else {
                int index = (i+k) - nums.length;
                nums2[index] = nums[i];
            }

        }
        nums = nums2;
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums2[i]);
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }




    }




















    public int maxProfit2(int[] prices) {

        int low = 0;
        int high = 1;
        int count = 0;
        while (high < prices.length){

            if (prices[low] >= prices[high]){
                low++;
                high++;
            }
            else if (high + 1 == prices.length && (prices[low] < prices[high]) || prices[low] < prices[high] && prices[high] > prices[high + 1]){
                count += (prices[high] - prices[low]);
                low = high;
                high++;
            }
            else {
                high++;
            }

        }


        return count;
    }









    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        for(int num : citations){
            if(num > n) freq[n]++;
            else{
                freq[num]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += freq[i];
            if(sum >= i) return i;
        }
        return 0;
    }







    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.' && !isValidPlacement(board, board[row][column], row, column))
                    return false;
            }
        }
        return true;
    }

    private boolean isNumberInRow(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (column != i && board[row][i] == number) return true;
        }
        return false;
    }

    private boolean isNumberInColumn(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][column] == number) return true;
        }
        return false;
    }

    private boolean isNumberInBox(char[][] board, char number, int row, int column) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (row != i && column != j && board[i][j] == number) return true;
            }
        }
        return false;
    }

    private boolean isValidPlacement(char[][] board, char number, int row, int column) {
        return !isNumberInRow(board, number, row, column) &&
                !isNumberInColumn(board, number, row, column) &&
                !isNumberInBox(board, number, row, column);
    }












    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){

            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            if (!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }










    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();


        for (int i = 0; i < nums.length; i++){
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] +1 == (nums[i + 1])){
                i++;
            }
            if (start != nums[i]){
                ans.add(start + "->" + nums[i]);
            }
            else if (start == nums[i]){
                ans.add(String.valueOf(start));
            }

        }

        return ans;
    }



    // Not done
//
//
//
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++){
            ListNode newhead = rotateRightHelper(head);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }
    public ListNode rotateRightHelper(ListNode head) {
        if (head == null) return head;
        if (head.next.next == null){
            ListNode dummy = head.next;
            head.next = null;
            return dummy;
        }
        return rotateRightHelper(head.next);
    }











//    private int minDiff;
//    private TreeNode prev;
//
//    public int getMinimumDifference(TreeNode root) {
//        minDiff = Integer.MAX_VALUE;
//        prev = null;
//        inOrderTraversal(root);
//        return minDiff;
//    }
//
//    private void inOrderTraversal(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        inOrderTraversal(node.left);
//
//        if (prev != null) {
//            minDiff = Math.min(minDiff, node.val - prev.val);
//        }
//
//        prev = node;
//
//        inOrderTraversal(node.right);
//    }





    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) return true;

        if (lowerBound != null && lowerBound >= root.val || upperBound != null && upperBound <= root.val){
            return false;
        }
        return isValidBST(root.left, lowerBound, root.val) && isValidBST(root.right, root.val, upperBound);

    }


    public double myPow(double x, long n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        double current_product = x;

        while(n > 0) {
            if(n % 2 == 1) {
                result = result * current_product;
            }
            current_product = current_product * current_product;
            n = n / 2;
        }

        return result;
    }




    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int index = 0;
        while(index < s1.length() && index < s2.length()){
            if(s1.charAt(index) == s2.charAt(index)){
                index++;
            } else {
                break;
            }
        }
        return s1.substring(0, index);
    }




    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int ans = 0;

        for (int i = 0; i < s.length(); i++){
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                ans -= map.get(s.charAt(i));
            }
            else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }

















//
//    pattern = "abba"
//    s = "dog dog dog dog"

    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        String[] x = s.split(" ");
        if (pattern.length() != x.length) return false;
        for (int i = 0; i < pattern.length(); i++){

            if (!map.containsKey(x[i])){
                if (map.containsValue(pattern.charAt(i))){
                    return false;
                }
                map.put(x[i], pattern.charAt(i));
            }
            if (map.get(x[i]) != pattern.charAt(i)){
                return false;
            }

        }
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
                return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }


    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=find(slow);
            fast=find(find(fast));
        }while(slow!=fast);
        return slow == 1;
    }
    private int find(int num){
        int ans=0;
        while(num>0){
            int rem=num%10;
            ans+=rem*rem;
            num/=10;
        }
        return ans;
    }
//    HashSet<ListNode> map = new HashSet<>();
//
// recursive
//    public boolean hasCycle(ListNode head) {
//        if (map.contains(head)) return true;
//        if (head == null) return false;
//        map.add(head);
//        return hasCycle(head.next);
//    }
//    iterative
//    public boolean hasCycle2(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//
//            if (fast == slow) {
//                return true;
//            }
//        }
//
//        return false;
//    }















    // counts the nodes in a tree.
//    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }



//    public ListNode mergeKLists(ListNode[] lists) {
//        boolean running = true;
//        while (running){
//            int min = Integer.MAX_VALUE;
//            for (ListNode node : lists){
//                min = Math.min(node.val, min);
//            }
//
//        }
//
//    }










    //    transfers integer to Roman numerals.
//    using a simple hashmap that can be iterated over in order.
    public String intToRoman(int num) {
        Object[][] storeIntRoman = {{1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"}, {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}};

        StringBuilder ans = new StringBuilder();
        while (num != 0){

            for (int i = 0; i < storeIntRoman.length; i++){

                int amount = num / (int)storeIntRoman[i][0];
                for (int j = 0; j < amount; j++){
                    ans.append(storeIntRoman[i][1]);
                }
                num = num % (int)storeIntRoman[i][0];
            }

        }


        return String.valueOf(ans);
    }






//    ArrayList<Integer> list1 = new ArrayList<>();
//    ArrayList<Integer> list2 = new ArrayList<>();
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        addTwoNumbersHelper(l1, 1);
//        addTwoNumbersHelper(l2, 2);
//
//
//
//    }
//
//    public void addTwoNumbersHelper(ListNode node, int list) {
//        if (node != null){
//            if (list == 1){
//                list1.add(node.val);
//                addTwoNumbersHelper(node.next, 1);
//            }
//            else if (list == 2){
//                list2.add(node.val);
//                addTwoNumbersHelper(node.next, 2);
//            }
//        }
//
//    }



    // swaps pairs in a linked list example 1->2->3->4->null
//    after swap it looks like this: 2->1->4->3->null
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextHead = head.next;

        head.next = swapPairs(nextHead.next);

        nextHead.next = head;

        return nextHead;
    }

//          ---NOT WORKING---
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        int dept = 0;
//        ListNode dummy = head;
//        while (dept < left){
//            head = head.next;
//            dept++;
//        }
//        reverseBetween(head, left, right, dept);
//        return dummy;
//    }
//// 1->2->
//    public ListNode reverseBetween(ListNode head, int left, int right, int dept) {
//        if (head == null) return null;
//        if (dept < left || dept > right) return head.next;
//
//        ListNode newHead = head;
//
//        if (newHead.next != null){
//            newHead = reverseBetween(newHead.next, left, right, dept + 1);
//            head.next.next = head;
//            head.next = null;
//        }
//
//
//        return newHead;
//    }






















    // removes the n number of note from the end for example List lenght = 5 and n = 2 then i remove the 4 because 5 is 1 4 is 2.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        if (head.next == null) return null;
        int size = removeNthFromEndHelper(head) + 1;
        dummy.next = head;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode current = head;
        ListNode nxt = head.next;

        int number = 1;
        while (number != size - n){
            prev = prev.next;
            current = current.next;
            nxt = nxt.next;
            number++;
        }
        if (prev.next == head){
            return nxt;
        }
        prev.next = nxt;


        return dummy.next;
    }

    public int removeNthFromEndHelper(ListNode head) {
        if (head == null) return 0;

        return 1 + removeNthFromEndHelper(head.next);
    }









//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null) return null;
//
//        ListNode ans = new ListNode();
//
//        ListNode prev = new ListNode();
//        prev.next = head;
//        ans.next = prev.next;
//        while (head.next != null){
//
//            while (head.val == head.next.val){
//                head = head.next;
//                if (head.next != null && head.next.next != null){
//                    if (head.val != head.next.val && head.next.val == head.next.next.val){
//                        head = head.next;
//                    }
//                }
//            }
//            prev.next = head.next;
//            prev = prev.next;
//
//
//            head = head.next;
//        }
//
//        return ans.next;
//    }



//  finds duplicates in a LinkedList and removes that value entirely.
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//
//        ListNode prev = dummy;
//        ListNode curr = head;
//
//        while (curr != null) {
//            boolean isDuplicate = false;
//
//            while (curr.next != null && curr.val == curr.next.val) {
//                isDuplicate = true;
//                curr = curr.next;
//            }
//
//            if (isDuplicate) {
//                prev.next = curr.next;
//            } else {
//                prev = curr;
//            }
//
//            curr = curr.next;
//        }
//
//        return dummy.next;
//    }

    //  returns the average value of every layer in a tree.
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;

        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        double levelSum = 0;

        while (!queue.isEmpty()){
            levelSum = 0;

            int size = queue.size();
            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);

            }
            double result = levelSum / size;
            ans.add(result);

        }
        return ans;
    }
    //  Imagine you stand on the right of the tree. this will display all of the values in your sight.
//  Shows the most right value of every layer.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                if (i == 0){
                    ans.add(current.val);
                }

                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);

            }


        }



        return ans;
    }
    //  shows all values in a tree layer by layer.
//  by implementing breadth first search.
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> allNodes = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                allNodes.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            ans.add(allNodes);



        }

        return ans;
    }


    //  breath first search displays all values in a tree in a zigzag formation
//  left to right then right to left.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;
        while (!queue.isEmpty()){
            List<Integer> allNodes = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                allNodes.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);


            }
            if (ans.size() % 2 == 1){
                Collections.reverse(allNodes);
            }
            ans.add(allNodes);



        }

        return ans;
    }


//    Iterates through the whole list to get the length and all values of the linked list after storing
//    we get the list.length -  (k -1) value.
//    private List<Integer> list = new ArrayList<>();
//    public int kthSmallest(TreeNode root, int k) {
//
//        kthSmallestHelper(root);
//        Collections.sort(list);
//        return list.get(k -1);
//    }
//    public void kthSmallestHelper(TreeNode root) {
//        if (root != null){
//            list.add(root.val);
//            kthSmallestHelper(root.left);
//            kthSmallestHelper(root.right);
//        }
//    }




    //return the first letter that is shown twice in a string.
    public char repeatedCharacter(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char letter : s.toCharArray()){

            int count = map.containsKey(letter) ? map.get(letter) + 1 : 1;
            if (count > 1){
                return letter;
            }
            map.put(letter, count);

        }

        return 'n';
    }
    //    public TreeNode increasingBST(TreeNode root) {
//        if(root == null) return null;
//
//        increasingBST(root.left);
//
//
//
//
//
//    }
//binary search tree returns subtree
//    public TreeNode searchBST(TreeNode root, int target) {
//        if (root == null) return null;
//
//        if (root.val == target){
//            return root;
//        }
//        else if (root.val < target){
//            return searchBST(root.right, target);
//        }
//        else{
//            return searchBST(root.left, target);
//        }
//
//    }




















    // finds the median in the two sorted arrays put together.
//    median is the number in the middle if the total amount of numbers is even.
//    then it will take the 2 middle numbers and return the average.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    // reverses a integer number. and returns zero if the inverted number is bigger then the 32bit integer limit.
    public int reverse(int x) {
        String value = String.valueOf(x);
        boolean isNegative = false;
        if (value.charAt(0) == '-'){
            value = value.substring(1);
            System.out.println(value);
            isNegative = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value);

        long integerchecker = Long.parseLong(String.valueOf(stringBuilder.reverse()));
        if (integerchecker > Integer.MAX_VALUE){
            return 0;
        }
        if (isNegative){
            return -Integer.parseInt(String.valueOf(stringBuilder));
        }
        return Integer.parseInt(String.valueOf(stringBuilder));
    }











//    List<Integer> list = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//        if (root != null){
//            inorderTraversal(root.left);
//            list.add(root.val);
//            inorderTraversal(root.right);
//        }
//
//        return list;
//    }



//    List<Integer> list = new ArrayList<>();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root != null){
//            preorderTraversal(root.right);
//            preorderTraversal(root.left);
//            list.add(root.val);
//        }
//
//        return list;
//    }



//    List<ListNode> list = new ArrayList<>();
//    public ListNode detectCycle(ListNode head) {
//        if (head != null){
//
//        while (head.next != null){
//            if (list.contains(head)){
//                return head;
//            }
//            list.add(head);
//
//
//            head = head.next;
//            }
//        }
//
//
//        return null;
//    }


//    List<Integer> list = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root != null){
//            postorderTraversal(root.left);
//            postorderTraversal(root.right);
//            list.add(root.val);
//        }
//
//        return list;
//    }




    // reverses the words in a sentence
// example "hello world" : "world hello"
    public String reverseWords(String s) {

        String[] str = s.trim().split("\\s+");

        String word = "";

        for (int i = str.length - 1; i>0; i--){
            word += str[i] + " ";

        }

        return word + str[0];
    }

    // checks if the number given is a power of three
    public boolean isPowerOfThree(int n) {

        while (n >= 3){
            if(n%3!=0) return false;
            n = n / 3;
            if (n == 3) return true;
        }

        return n == 1;
    }












    // deletes node in a singly linked list
//    but instead of getting the head of the linked list you get the node that you want to be deleted
//    does not mean its wiped from memory, but it is removed from the given list
    public void deleteNode(ListNode node) {
        if (node != null){
            if (node.next != null){
                node.val = node.next.val;
                if(node.next.next == null){
                    node.next = null;
                }
                node = node.next;
                deleteNode(node);

            }


        }
    }


//removes the middle node in a singly linked list
//    float middle;
//    public ListNode middleNode(ListNode head) {
//        middleNodeHelper(head);
//        middle = (float) Math.floor(middle/2);
//        for (int i = 0; i < middle; i++){
//            head = head.next;
//        }
//
//        return head;
//    }
//
//    public void middleNodeHelper(ListNode head) {
//
//        middle++;
//        if (head.next != null){
//            middleNodeHelper(head.next);
//        }
//
//    }

    //    deletes duplicates from a singly linked list
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head == null) return head;


        while (temp.next !=null) {

            if (temp.val != temp.next.val) {
                temp = temp.next;
            }
            else temp.next = temp.next.next;
        }
        return head;
    }




    // finds the first peak in an array of integers
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return 0;
        for (int i = 0; i < nums.length -1; i++){

            if (nums[i] > nums[i + 1]){
                return i;
            }
            else if (nums[i+1] > nums[i] && (i + 2) == nums.length){
                return (i +1);
            }


        }

        return -1;
    }













    // check if its power of four leetcode 342.
    public boolean isPowerOfFour(int n) {
        while (n >= 4) {
            if (n % 4 != 0) return false;
            n = n / 4;
            if (n == 4) return true;
        }

        return n == 1;
    }



















    // finds the third max number in an integer array if there isn't a third max number it returns the max number
//    leetcode 414
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }


    // solves a game of sudoku
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }

            if (board[row][i] == num) {
                return false;
            }

            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;

            if (board[subgridRow][subgridCol] == num) {
                return false;
            }
        }


        return true;
    }




    // returns a list of all the values on each level of a tree data structer from the bottom to the top
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            int length = queue.size();
            List<Integer> levelOfTree = new ArrayList<>();
            for (int i = 0; i < length; i++){

                TreeNode node = queue.poll();
                levelOfTree.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(levelOfTree);





        }
        Collections.reverse(list);
        return list;
    }
//  flattens a tree by putting them all to the right of the root
//    List<TreeNode> list = new ArrayList<>();
//
//    public void flatten(TreeNode root) {
//        preorderTraversal(root);
//
//        for (int i = 1; i < list.size(); i++){
//            root.right = list.get(i);
//            root.left = null;
//
//            root = root.right;
//
//
//        }
//    }
//
//    public void preorderTraversal(TreeNode root) {
//        if (root != null){
//            list.add(root);
//            preorderTraversal(root.left);
//            preorderTraversal(root.right);
//        }
//
//    }














    // leetcode 153
    public int findMin(int[] nums) throws InterruptedException {

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int middle = (left + right) /2;
            if (nums[left] <= nums[middle]){
                if (nums[left] >= nums[right]){
                    left = middle + 1;
                }
                else{

                    right = middle - 1;
                }
            }
            else{
                if (nums[middle] <= nums[right]){
                    right = middle;
                }
                else {
                    left = middle + 1;
                }
            }

        }
        return nums[left];
    }


    public int arrangeCoins(int n) {

        int stairs = 0;
        int stair = 1;
        while (true){

            if (n - stair >= 0){
                stairs++;
                n -= stair;
                stair++;
            }
            else {
                return stairs;
            }



        }


    }







    public int findMaxConsecutiveOnes(int[] nums) {

        int ans = 0;
        int consecutive = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                consecutive++;
            }
            else {
                consecutive = 0;
            }
            ans = Math.max(ans, consecutive);

        }

        return ans;
    }



    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        if (s.length() != goal.length()) return false;
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < goal.length()) {
            if (s.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = 0;
                }
            }
        }
        return (s.substring(0, goal.length() - j).equals(goal.substring(j)));
    }




















    public char nextGreatestLetter(char[] letters, char target) throws InterruptedException {

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target >= letters[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return letters[left % letters.length];
    }
























    // finds the first and last index of the target in the array nums
    public int[] searchRange(int[] nums, int target) throws InterruptedException {
        int start = -1;
        int end = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){

            int middle = (left + right) / 2;
            int index = middle;

            if (nums[index] == target){

                while (index >= 0 && nums[index] == target){

                    index--;
                }
                start = index + 1;
                index = start;
                while (index < nums.length && nums[index] == target){
                    index++;
                }
                if ((index) != middle){
                    end = index - 1;
                }
                return new int[]{start, end};
            }
            else if (nums[middle] > target){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }

        }

        return new int[]{start, end};
    }
















    // find the minimal number in an array that contains duplicates in o(log n)
    public int findMinWithDuplicates(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (nums[right] < nums[middle]) {
                left = middle + 1;
            } else if (nums[right] > nums[middle]) {
                right = middle;
            } else {
                right--;
            }

        }
        return nums[left];
    }








    // returns true if num is a perfect square.
    public boolean isPerfectSquare(int num) {

        double sqrt = Math.sqrt(num);

        return sqrt == Math.floor(sqrt);
    }







    // returns the amount of trailing 0 in n!
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }













    // turns a given number into words example 100 = one hundred
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    public String helper(int num) {
        String ans;

        if (num < 10) ans = belowTen[num];
        else if (num < 20) ans = belowTwenty[num - 10];
        else if (num < 100) ans = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) ans = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) ans = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) ans = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else ans = helper(num/1000000000) + " Billion " + helper(num % 1000000000);




        return ans.trim();
    }



















    // counts the amount of ones is seen when subtracting 1 from n until its 0;
//    example 11, 10, 9, 8, 7, 6, 5, 4, 4, 3, 2, 1, 0. n 11
    public int countDigitOne(int n) {
        int ones = 0;

        while (n >0){
            String number = String.valueOf(n);
            for (int i = 0; i < number.length(); i++){
                if (number.charAt(i) == '1'){
                    ones++;
                }
            }

            n--;
        }

        return ones;
    }









//    public List<Integer> countSmaller(int[] nums) {
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++){
//            int amount = 0;
//
//            for (int j = i + 1; j < nums.length; j++){
//
//                if (nums[i] > nums[j]){
//                    amount++;
//                }
//            }
//            list.add(amount);
//
//        }
//
//        return list;
//    }




    // connects all levels in the tree with their next
    public Node2 connect(Node2 root) {
        if (root == null) {
            return null;
        }

        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node2 prev = null;

            for (int i = 0; i < size; i++) {
                Node2 current = queue.poll();

                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }














    // merges alternately example word1 = hlo word2 = el returns hello
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()){

            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));

            i++;
        }
        if (i < word1.length()) ans.append(word1.substring(i));
        if (i < word2.length()) ans.append(word2.substring(i));


        return ans.toString();
    }




    // checks if a kid with i th candies can have the most candies if given the extraCandies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();

        int mostCandie = 0;

        for (int candy : candies) {
            if (candy > mostCandie) mostCandie = candy;
        }

        for (int candy : candies) {
            if ((candy + extraCandies) >= mostCandie) {
                list.add(true);
            } else list.add(false);
        }

        return list;
    }




















    // checks if it can place a 1 in array.
//    it can place when there are no adjacent 1's in the array example: 0, 0 ,0 you can place two 1,0,1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;
        if (flowerbed.length >= 2 && flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            n--;
        }

        for (int i = 1; i < flowerbed.length - 1; i++){
            System.out.println(Arrays.toString(flowerbed));
            int prev = i - 1;
            int next = i + 1;




            if ((flowerbed[prev] == 0 && flowerbed[next] == 0 && flowerbed[i] == 0)){
                flowerbed[i] = 1;
                n--;
            }



            System.out.println(i);
            System.out.println(n);



        }
        if (flowerbed.length >=2 && flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0){
            n--;
        }
        return n <= 0;
    }





















    // reverses the vowels in a word
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            start++;
            end--;
        }

        return new String(word);
    }


    // moves all the zeros to the right of the array while maintaining order in the array
    public void moveZeroes(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }





    }














    // finds biggest average in a range of k in array nums
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;

        if(k> n)
            return 0;

        for(int i =1; i<=n; i++)
            sum[i] = sum[i-1] +  nums[i-1];


        System.out.println(n);
        double max = -10001;
        int  j = 0;
        for(int i = k; i<=n; i++){
            max = Math.max(max, (double) (sum[i]- sum[j++] )/k );
        }
        return max;
    }






    // An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
// An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    public boolean isMonotonic(int[] nums) {

        boolean decreasing = nums[0] > nums[nums.length - 1];


        if (decreasing){
            for (int i = 0; i < nums.length - 1; i++){
                if (nums[i] < nums[i + 1]) return false;
            }
        }
        else {
            for (int i = 0; i < nums.length - 1; i++){
                if (nums[i] > nums[i + 1]) return false;
            }
        }
        return true;
    }





    public int maxLevelSum(TreeNode root) {

        int max = Integer.MIN_VALUE;
        int lvl = 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            int lvlSum = 0;
            lvl++;
            for (int i = 0; i < size; i++){

                TreeNode node = queue.poll();
                lvlSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }

            if (lvlSum > max){
                max = lvlSum;
                ans = lvl;
            }

        }
        return ans;
    }


















    // 2,3,1,1,4
    public boolean canJump(int[] nums) {

        int goal = nums.length - 1;

        for (int i = nums.length -1; i >= 0; i--){

            if (i + nums[i] >= goal){
                goal = i;
            }

        }

        return goal == 0;
    }


// uses the values in an array to reach to end of the array if it is possible then it return the amount on jumps.
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (i + nums[i] > farthest) farthest = i + nums[i];
            if (farthest >= nums.length - 1) {
                ++ans;
                break;
            }
            if (i == end) {
                ans++;
                end = farthest;
            }
        }

        return ans;
    }


//Given an integer array nums, returns an array answer such that answer[i]
// is equal to the product of all the elements of nums except nums[i].
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }







// checks if the car with the given gas can make a complete circle and returns the index
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gas2 = 0;
        int cost2 = 0;

        for (int i = 0; i < gas.length; i++){
            cost2 += cost[i];
            gas2 += gas[i];
        }

        if (cost2 > gas2) return - 1;

        int total = 0;
        int res = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++){

            total += (gas[i] - cost[i]);

            if (total < 0){
                total = 0;
                start = i + 1;
            }


        }


        return start;
    }








// simplifies the path by splitting it up in sections and removing the necessary parts
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] segments = path.split("/");

        for (String segment : segments) {
            if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!segment.equals(".") && !segment.isEmpty()) {
                stack.push(segment);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String segment : stack) {
            simplifiedPath.append("/").append(segment);
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }




























    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        List<String> curWords = new ArrayList<>();
        int curLen = 0;

        for (String word : words) {
            if (curLen + word.length() + curWords.size() > maxWidth) {
                int totalSpaces = maxWidth - curLen;
                int gaps = curWords.size() - 1;
                if (gaps == 0) {
                    res.add(curWords.get(0) + " ".repeat(totalSpaces));
                } else {
                    int spacePerGap = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < curWords.size(); i++) {
                        line.append(curWords.get(i));
                        if (i < gaps) {
                            line.append(" ".repeat(spacePerGap));
                            if (i < extraSpaces) {
                                line.append(' ');
                            }
                        }
                    }
                    res.add(line.toString());
                }
                curWords.clear();
                curLen = 0;
            }
            curWords.add(word);
            curLen += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", curWords));
        while (lastLine.length() < maxWidth) {
            lastLine.append(' ');
        }
        res.add(lastLine.toString());

        return res;
    }









//    public List<String> letterCombinations(String digits) {
//        String [] strMap = {"0","1","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        List<String> list = new ArrayList<>();
//        String ans = "";
//
//        for (int i = 0; i < digits.length(); i++){
//
//            for (int j = )
//
//
//
//        }
//
//
//
//    }
//
//
//
//



// given an m x n matrix, returns all elements of the matrix in a spiral order.
    public List<Integer> spiralOrder(int[][] matrix) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom){

            for (int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;
    }







//    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
//
//
//
//    Example 1:
//
//    Input: num = 38
//    Output: 2
//    Explanation: The process is
//        38 --> 3 + 8 --> 11
//        11 --> 1 + 1 --> 2
//    Since 2 has only one digit, return it.
//    Example 2:
//
//    Input: num = 0
//    Output: 0
    public int addDigits(int num) {

        if(num==0){
            return 0;
        }
        else if(num%9==0){
            return 9;
        }
        return num%9;
    }






// rotates a matrix 90 degrees clockwise
    public void rotate(int[][] matrix) {

        int left = 0;
        int right = matrix.length - 1;


        while (left < right){
            for (int i = 0; i < (right-left); i++){

                int top = left;
                int bottom = right;
                int topLeft = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];

                matrix[bottom - i][left] = matrix[bottom][right - i];

                matrix[bottom][right - i] = matrix[top + i][right];

                matrix[top + i][right] = topLeft;

            }
            left++;
            right--;

        }




    }












//    public int[] dailyTemperatures(int[] temp) {
//        Stack<Integer> stack = new Stack<>();
//        int[] ans = new int[temp.length];
//
//
//        for (int i = 0; i < temp.length; i++){
//            int days = 1;
//
//
//                while (temp[i] > stack.peek()){
//
//                }
//
//
//            }
//
//
//
//        }
//
//
//    }




















// recognises two values that have been switched in a binary search tree if they are connected
//    public void recoverTree(TreeNode root) {
//        if (root != null){
//
//            if (root.left != null){
//                if (root.left.val > root.val){
//                    int temp = root.val;
//                    root.val = root.left.val;
//                    root.left.val = temp;
//                }
//                recoverTree(root.left);
//            }
//            if (root.right != null){
//                if (root.right.val < root.val){
//                    int temp = root.val;
//                    root.val = root.right.val;
//                    root.right.val = temp;
//                }
//                recoverTree(root.right);
//            }
//
//
//        }
//    }







    public int countNegatives(int[][] grid) {

        int count = 0;
        int row = 0;
        int col = grid[0].length -1;

        while(col >= 0 && row < grid.length){
            if(grid[row][col] < 0){
                count += grid.length - row;
                col--;
            }else{
                row++;
            }
        }
        return count;
    }















//    public List<List<Integer>> generate(int numRows) {
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        List<Integer> row = new ArrayList<>();
//        row.add(1);
//        list.add(row);
//        row = new ArrayList<>();
//
//        for (int i = 0; i < numRows - 1; i++){
//
//            for (int j = 0; j < list.get(i).size() + 1; j++){
//
//            }
//
//
//
//
//        }
//
//
//
//    }










//    List<String> list = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        String path = "";
//        binaryTreePathsHelper(root, path);
//
//        return list;
//    }
//
//    public void binaryTreePathsHelper(TreeNode root, String path) {
//        if (root != null){
//            path += root.val + "->";
//            binaryTreePathsHelper(root.left, path);
//
//            if (root.left == null && root.right == null){
//                list.add(path.substring(0, path.length() -2));
//            }
//            binaryTreePathsHelper(root.right, path);
//
//        }
//    }












    public boolean isEvenOddTree(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int layer = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int prev = (layer % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if (layer % 2 == 0){
                    if (curr.val % 2 == 0 || curr.val <= prev){
                        return false;
                    }
                }
                else {
                    if (curr.val % 2 == 1 || curr.val >= prev){
                        return false;
                    }
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);

                prev = curr.val;
            }
            layer++;
        }

        return true;
    }






//    int min=-1;
//    int secondMin=Integer.MAX_VALUE;
//    boolean changed=false;
//    public int findSecondMinimumValue(TreeNode root) {
//
//        if(root == null)return secondMin;
//
//        min = root.val;
//
//        help(root);
//
//        if(!changed){
//            return -1;
//        }
//
//        return secondMin;
//    }
//    public void help(TreeNode root){
//        if(root == null)return;
//
//        if(min < root.val && root.val <= secondMin){
//            secondMin = root.val;
//            changed = true;
//        }
//
//        help(root.left);
//        help(root.right);
//    }





    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        leafSimilarHelper(root1, list1);
        leafSimilarHelper(root2, list2);
        int i = 0;
        if (list2.size() != list1.size()) return false;
        while (i < list1.size()){

            if (list1.get(i) != list2.get(i)){
                return false;
            }


            i++;
        }
        return true;
    }

    public void leafSimilarHelper(TreeNode root, List<Integer> list) {

        if (root != null){

            leafSimilarHelper(root.left, list);
            if (root.left == null && root.right == null){
                list.add(root.val);
            }
            leafSimilarHelper(root.right, list);


        }

    }



















    public long kthLargestLevelSum(TreeNode root, int k) {
// change to int and it does not work. WHAT???
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++){

                TreeNode node = queue.poll();
                sum += node.val;


                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            list.add(sum);

        }
        Collections.sort(list);

        if(k>list.size()) return -1;
        Collections.sort(list);
        return list.get(list.size()-k);
    }



















    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = val1 + val2 + carry;
            carry = val / 10;
            val = val % 10;

            current.next = new ListNode(val);


            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;


            current = current.next;

        }

        return dummy.next;
    }




















    public int sumNumbers(TreeNode root) {
        String sum = "";
        List<String> list = new ArrayList<>();
        int ans = 0;
        sumNumbersHelper(root, list, sum);

        for (int i = 0; i < list.size(); i++){
            ans += Integer.parseInt(list.get(i));
        }
        return ans;
    }


    public void sumNumbersHelper(TreeNode root, List<String> list, String sum) {
        if (root != null){

            sum += root.val;

            if (root.left == null && root.right == null){
                list.add(sum);
            }

            sumNumbersHelper(root.left, list, sum);
            sumNumbersHelper(root.right, list, sum);






        }
    }










    public ListNode sortList(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while (head != null){

            list.add(head.val);

            head = head.next;
        }
        Collections.sort(list);

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int i = 0; i < list.size(); i++){

            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return dummy.next;
    }







//
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }















    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;

        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        String word = "";

        while (leftIndex < s1.length() || leftIndex < s2.length()){

            if (s1.length() != 0 && leftIndex < s1.length() && s1.charAt(leftIndex) == s3.charAt(index)){
                word += s1.charAt(leftIndex);
                leftIndex++;
            }
            else if (s2.length() != 0 && rightIndex < s2.length() && s2.charAt(rightIndex) == s3.charAt(index)){
                word += s2.charAt(rightIndex);
                rightIndex++;
            }
            else if (word.length() == s3.length()) return true;
            else return false;

            index++;
        }



        return true;
    }






    public int rob(int[] nums) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++){

            int temp = Math.max(left + nums[i], right);

            left = right;
            right = temp;
        }
        return right;
    }
//[10,2,3,10,20]
// temp = 0
// left = 0
// right = 0

//    public boolean wordBreak(String s, List<String> wordDict) {
//
//    }

    public int lengthOfLIS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;

        if (nums[right] < 0) return -1;

        int middle = 0;
        while (left < right){
            middle = (left + right) / 2;

            if (nums[middle] > 0){
                right = middle - 1;
            }
            else if (nums[middle] < 0){
                left = middle + 1;
            }
            else if (nums[middle] == 0){
                return nums.length - middle;
            }


        }


        return nums.length - middle;
    }


// first try
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        if (lists.length == 0) return null;
//
//        ListNode dummy = new ListNode();
//        ListNode current = dummy;
//
//        while (current != null){
//            int index = -1;
//            ListNode min = new ListNode(Integer.MAX_VALUE);
//            for (int i = 0; i < lists.length; i++){
//                if (lists[i] != null && lists[i].val < min.val){
//                    min = lists[i];
//                    index = i;
//                }
//            }
//            if (index == -1) break;
//            current.next = min;
//            current = current.next;
//            lists[index] = lists[index].next;
//        }
//
//        return dummy.next;
//    }

//    Second try. runtime performance from 149ms to 10ms
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < lists.length; i++){
//            while (lists[i] != null){
//                list.add(lists[i].val);
//                lists[i] = lists[i].next;
//            }
//        }
//
//        Collections.sort(list);
//
//        ListNode dummy = new ListNode();
//        ListNode current = dummy;
//
//        for (int i = 0; i < list.size(); i++){
//
//            current.next = new ListNode(list.get(i));
//            current = current.next;
//
//        }
//
//
//        return dummy.next;
//    }





    public int accountBalanceAfterPurchase(int purchaseAmount) {
                return purchaseAmount % 10 >= 5 ? 100 - (purchaseAmount + (10 - (purchaseAmount % 10))) : 100 - (purchaseAmount - (purchaseAmount % 10));
    }




    public String finalString(String s) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == 'i'){
                ans.reverse();
            }
            else {
                ans.append(s.charAt(i));
            }

        }
        return new String(ans);
    }















    public int furthestDistanceFromOrigin(String moves) {

        int length = 0;
        int choices = 0;

        for (int i = 0; i < moves.length(); i++){

            if (moves.charAt(i) == 'L'){
                length--;
            }
            else if (moves.charAt(i) == 'R'){
                length++;
            }
            else {
                choices++;
            }
        }

        if (length >= 0){
            length += choices;
        }
        else {
            length -= choices;
            length = Integer.parseInt(String.valueOf(length).substring(1));
        }

        return length;
    }



//Example 1:
//
//Input: moves = "UD"
//Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
public boolean judgeCircle(String moves) {

    int vertical = 0;
    int horizontal = 0;

    for (int i = 0; i < moves.length(); i++){

        switch (moves.charAt(i)){
            case 'U':
                vertical++;
                break;
            case 'D':
                vertical--;
                break;
            case 'R':
                horizontal++;
                break;
            case 'L':
                horizontal--;
                break;
        }
    }


    return vertical == 0 && horizontal == 0;
}

//Output: true



//    The student is eligible for an attendance award if they meet both of the following criteria:
//
//    The student was absent ('A') for strictly fewer than 2 days total.
//    The student was never late ('L') for 3 or more consecutive days.
    public boolean checkRecord(String s) {

        int absent = 0;
        int late = 0;

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == 'L'){
                if (late == 2) return false;
                late++;
            }
            else if (s.charAt(i) == 'A'){
                if (absent == 1) return false;
                absent++;
                late = 0;
            }
            else {
                late = 0;
            }



        }

        return true;

    }



//    575. Distribute Candies
    public int distributeCandies(int[] candyType) {

        int ans = 0;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < candyType.length; i++){
            if (!hashSet.contains(candyType[i])){
                hashSet.add(candyType[i]);
                ans++;
                if (ans > candyType.length /2){
                    return (candyType.length / 2);
                }
            }
        }


        return ans;
    }


//2656. Maximum Sum With Exactly K Elements
    public int maximizeSum(int[] nums, int k) {

        int ans = 0;

        Arrays.sort(nums);

        for (int i = 0; i < k; i++){

            ans += nums[nums.length - 1];
            nums[nums.length - 1]++;


        }

        return ans;
    }












    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0; i < left - 1; i++)
            prev = prev.next;

        ListNode curr = prev.next;
        // reversing
        for(int i = 0; i < right - left; i++){
            ListNode forw = curr.next;
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
    }






// gets random index of a linkedList

//    ListNode head;
//    int size = 1;
//    public Solution(ListNode head) {
//        this.head = head;
//        ListNode temp = head;
//
//        while (temp.next != null){
//            temp = temp.next;
//            size++;
//        }
//
//    }
//
//    public int getRandom() {
//        int random = (int) Math.floor(Math.random() * size);
//        ListNode ans = head;
//        for (int i = 0; i < random; i++){
//            ans = ans.next;
//        }
//
//        return ans.val;
//    }



// finds the minimal diffrence in a bst
//    List<Integer> list = new ArrayList<>();
//
//    public int minDiffInBST(TreeNode root) {
//
//        minDiffInBSTHelper(root);
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 1; i < list.size(); i++){
//
//            if (list.get(i) - list.get(i - 1) < min){
//                min = list.get(i) - list.get(i - 1);
//            }
//
//        }
//
//        return min;
//    }



//    private void minDiffInBSTHelper(TreeNode root) {
//
//        if (root != null){
//
//            minDiffInBSTHelper(root.left);
//            list.add(root.val);
//            minDiffInBSTHelper(root.right);
//
//
//
//        }
//    }





// looks if a target is in a 1D array.
    public boolean search2(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) return true;

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
//          [1,0,1,1,1]
            int middle = (left + right) / 2;

            if (nums[middle] == target || nums[left] == target || nums[right] == target){
                return true;
            }
            else if (nums[middle] > target && nums[left] < target){
                right = middle - 1;
            }
            else if (nums[middle] < target && nums[right] > target){
                left = middle + 1;
            }
            else {
                left++;
            }
        }



        return false;
    }




// turns a tree into a linkedList
//    TreeNode tree = new TreeNode();
//    TreeNode dummy = tree;
//    public TreeNode increasingBST(TreeNode root) {
//
//        increasingBSTHelper(root);
//
//        return dummy.right;
//    }


//    public void increasingBSTHelper(TreeNode root) {
//        if (root != null){
//
//            increasingBSTHelper(root.left);
//            tree.right = new TreeNode(root.val);
//            tree = tree.right;
//            increasingBSTHelper(root.right);
//
//
//
//        }
//    }

    // makes a spiral matrix in order
//    [1,2,3]
//    [8,9,4]
//    [7,6,5]
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int number = 1;

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom){

            for (int i = left; i <= right; i++){
                matrix[top][i] = number;
                number++;
            }
            top++;

            for (int i = top; i <= bottom; i++){
                matrix[i][right] = number;
                number++;
            }
            right--;

            for (int i = right; i >= left; i--){
                matrix[bottom][i] = number;
                number++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--){
                matrix[i][left] = number;
                number++;
            }
            left++;

        }
        return  matrix;

    }






    //    Returns the maximum number of integers you can choose following the mentioned rules.
//    The chosen integers have to be in the range [1, n].
//    Each integer can be chosen at most once.
//    The chosen integers should not be in the array banned.
//    The sum of the chosen integers should not exceed maxSum.
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int ans = 0;


        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < banned.length; i++){
            hashSet.add(banned[i]);
        }


        for (int i = 1; i <= n; i++){


            if (!hashSet.contains(i) && (sum + i) <= maxSum){
                sum += i;
                ans++;
            }

        }

        if (ans > 1){
            return ans;
        }
        return 0;
    }








    public int getCommon(int[] nums1, int[] nums2) {

        int index1 = 0;
        int index2 = 0;


        while (index1 < nums1.length && index2 < nums2.length){

            if (nums1[index1] == nums2[index2]){
                return nums1[index1];
            }
            else if (nums1[index1] < nums2[index2]){
                index1++;
            }
            else {
                index2++;
            }



        }




        return -1;
    }




//  12
//    +(1) - (2)
//    alternates between plus and minus
    public int alternateDigitSum(int n) {

        int sum = 0;

        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++){
            int addNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (i % 2 == 0){
                sum += addNumber;
            }
            else {
                sum -= addNumber;
            }



        }


        return sum;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null && subRoot ==null|| root!=null && subRoot==null) return true;
        if (root==null && subRoot!=null) return false;

        if(isSame(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    private boolean isSame(TreeNode root, TreeNode subRoot){

        if(root==null && subRoot==null) return true;
        if(root==null && subRoot!=null || root!=null && subRoot==null) return false;

        if(root.val!=subRoot.val) return false;

        return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }






    public void recoverTree(TreeNode root) {

        recoverTreeHelper(root, root.val);


    }
    public void recoverTreeHelper(TreeNode root, int rootval) {
        if (root != null){

            if (root.left != null){
                if (root.left.val > root.val){
                    int temp = root.val;
                    root.val = root.left.val;
                    root.left.val = temp;
                }
                recoverTreeHelper(root.left, rootval);
            }
            if (root.right != null){
                if (root.right.val < root.val){
                    int temp = root.val;
                    root.val = root.right.val;
                    root.right.val = temp;
                }
                else if (root.val < rootval)
                recoverTreeHelper(root.right, rootval);
            }


        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBSTHelper(list, 0, list.size() - 1);
    }
    public TreeNode sortedListToBSTHelper(List<Integer> list, int left, int right) {

        if (left > right) return null;

        int middle = (left + right) / 2;

        TreeNode node = new TreeNode();

        node.val = list.get(middle);

        node.left = sortedListToBSTHelper(list, left, middle - 1);
        node.right = sortedListToBSTHelper(list, middle + 1, right);

        return node;
    }




    public boolean isPalindrome(ListNode head) {

        StringBuilder stringBuilder = new StringBuilder();

        while (head != null){
            stringBuilder.append(head.val);
            head = head.next;
        }

        int left = 0;
        int right = stringBuilder.length() - 1;

        while (left <= right){

            if (stringBuilder.charAt(left) == stringBuilder.charAt(right)){
                left++;
                right--;
            }
            else {
                return false;
            }

        }


        return true;
    }



//    int[] nums;
//    public Solution(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int[] reset() {
//        return nums;
//    }
//
//    public int[] shuffle() {
//        int[] array = nums.clone();
//        for (int i = 0; i < array.length; i++){
//            int temp = array[i];
//            int random = (int) Math.floor(Math.random() * array.length);
//            array[i] = array[random];
//            array[random] = temp;
//
//        }
//
//        return array;
//    }



// removes duplicate letters and returns the string in alphabetical order
    public String removeDuplicateLetters(String s) {

        List<Character> list = new ArrayList<>();


        for (int i = 0; i < s.length(); i++){

            if (!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }

        }
        Collections.sort(list);

        StringBuilder ans = new StringBuilder();

        for (Character character : list){
            ans.append(character);
        }


        return String.valueOf(ans);
    }





// gets a random index of a target example :
//    nums = {1,1,2,3,3} if target == 1 it can either return 0 or 1
//    if target == 3 it will either return 3 or 4
//    Map<Integer, List<Integer>> map = new HashMap<>();
//    public Solution(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                map.get(nums[i]).add(i);
//            }
//            else {
//                List<Integer> list1 = new ArrayList<>();
//                list1.add(i);
//                map.put(nums[i], list1);
//            }
//        }
//
//
//    }
//
//    public int pick(int target) {
//        Random random = new Random();
//        List<Integer> indexes = map.get(target);
//
//        return indexes.get(random.nextInt(indexes.size()));
//    }








//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//
//
//
//
//    }


    public List<String> fizzBuzz(int n) {

        List<String> list1 = new ArrayList<>();


        for (int i = 1; i <= n; i++){
            StringBuilder stringBuilder = new StringBuilder();

            if (i % 3 == 0){
                stringBuilder.append("Fizz");
            }
            if (i % 5 == 0){
                stringBuilder.append("Buzz");
            }
            if (stringBuilder.length() == 0){
                stringBuilder.append(i);
            }
            list1.add(String.valueOf(stringBuilder));
        }

        return list1;
    }







// finds the lowest common ancestor in a bst
//    TreeNode ans;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        lowestCommonAncestorHelper(root, p, q);
//
//        return ans;
//    }
//    public void lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
//        if (root != null){
//            if (root.val > p.val && root.val > q.val){
//                ans = root;
//                lowestCommonAncestorHelper(root.left, p, q);
//            }
//            else if (root.val < p.val && root.val < q.val){
//                ans = root;
//                lowestCommonAncestorHelper(root.right, p, q);
//            }
//            else {
//                ans = root;
//            }
//        }
//    }




// finds the most K frequent numbers in nums
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, List<Integer>> frequency = new HashMap<>();

        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++){

            int count = counts.containsKey(nums[i]) ? counts.get(nums[i]) + 1 : 1;

            counts.put(nums[i], count);
        }

        for (Integer number : counts.keySet()){
            List<Integer> list1 = new ArrayList<>();

            if (frequency.containsKey(counts.get(number))){
                frequency.get(counts.get(number)).add(number);
            }
            else {
                frequency.put(counts.get(number), list1);
                frequency.get(counts.get(number)).add(number);
            }
        }

        List<Integer> frequencies = new ArrayList<>(frequency.keySet());
        Collections.sort(frequencies);

        int index = 0;
        int index2 = 0;
        while (index < k){

            List<Integer> a = frequency.get(frequencies.get((frequencies.size()-1) - index2));

            for (int i = 0; i < a.size(); i++){

                if (index > k){
                    break;
                }

                ans[index] = a.get(i);

                index++;
            }

            index2++;
        }




        return ans;
    }


// finds the missing number in the range of n
    public int missingNumber(int[] nums) {

        int lenght = nums.length;
        int sum = lenght * (lenght+1) / 2;

        for (int i = 0; i < lenght; i++){
            sum -= nums[i];
        }
        return sum;
    }

//    finds all the duplicates by using the nums[i] as a index
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0){
                ans.add(index + 1);
            }
            nums[index] = -nums[index];

        }

        return ans;
    }













//    int ans = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        sumOfLeftLeavesHelper(root);
//
//        return ans;
//    }
//    private void sumOfLeftLeavesHelper(TreeNode root) {
//        if (root != null){
//
//            sumOfLeftLeavesHelper(root.left);
//
//            if (root.left != null && root.left.left == null && root.left.right == null){
//                ans += root.left.val;
//            }
//
//            sumOfLeftLeavesHelper(root.right);
//        }
//    }




    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                if (current.val > max){
                    max = current.val;
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            ans.add(max);

        }


        return ans;
    }




    public int findBottomLeftValue(TreeNode root) {

        int leftmost = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                if (i == 0){
                    leftmost = current.val;
                }


                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);

            }
        }

        return leftmost;
    }


    public int deepestLeavesSum(TreeNode root) {

        List<List<Integer>> list1 = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> allValsLvl = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){

                TreeNode current = queue.poll();
                allValsLvl.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);

            }
            list1.add(allValsLvl);

        }

        List<Integer> lastLvl = list1.get(list1.size() -1);
        int sum = 0;
        for (int i = 0; i < lastLvl.size(); i++){
            sum += lastLvl.get(i);
        }

        return sum;
    }




    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = new ListNode();
        dummy.next = list1;

        ListNode current = dummy.next;

        ListNode first;
        ListNode second;
        ListNode last2;

        int index = 1;
        while (index < a){
            current = current.next;
            index++;
        }
        first = current;

        while (index <= b + 1){
            current = current.next;
            index++;
        }
        second = current;

        current = list2;
        while (current.next != null){
            current = current.next;
        }
        last2 = current;

        first.next = list2;
        last2.next = second;



        return dummy.next;
    }












    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length * mat[0].length != r * c){
            return mat;
        }

        int[][] ans = new int[r][c];

        int row = 0;
        int column = 0;

        for (int i = 0; i < mat.length; i++){

            for (int j = 0; j < mat[0].length; j++){

                if (column >= c){
                    column = 0;
                    row++;
                }

                ans[row][column] = mat[i][j];
                column++;


            }

        }


        return ans;

    }




    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null){
            insertIntoBSTHelper(root, val);

        }
        else {
            root = new TreeNode(val);
        }
        return root;
    }
    private void insertIntoBSTHelper(TreeNode root, int val) {

        if (root.val > val && root.left == null){
            root.left = new TreeNode(val);
        }
        else if (root.val < val && root.right == null){
            root.right = new TreeNode(val);
        }
        else if (root.val < val){
            insertIntoBSTHelper(root.right, val);
        }
        else {
            insertIntoBSTHelper(root.left, val);
        }

    }


//    Map<Node, Node> oldtonew = new HashMap<>();
//    public Node cloneGraph(Node node) {
//
//        if (node == null){
//            return null;
//        }
//
//        dps(node);
//
//
//        return dps(node);
//    }
//    private Node dps(Node node) {
//        if (oldtonew.containsKey(node)){
//            return oldtonew.get(node);
//        }
//
//        Node copy = new Node(node.val);
//
//        oldtonew.put(node, copy);
//
//        for (Node neighbour : node.neighbors){
//            copy.neighbors.add(dps(neighbour));
//        }
//
//        return copy;
//    }




//    int sumOfTree = 0;
//    HashMap<Integer, Integer> map = new HashMap<>();
//    public TreeNode convertBST(TreeNode root) {
//
//        convertBSTHelper(root);
//        convertBSTHelper2(root);
//
//
//        return root;
//    }
//    private void convertBSTHelper2(TreeNode root) {
//        if (root != null){
//
//            convertBSTHelper2(root.left);
//
//            root.val = sumOfTree - map.get(root.val);
//
//            convertBSTHelper2(root.right);
//
//
//
//
//        }
//    }
//
//    private void convertBSTHelper(TreeNode root) {
//        if (root != null){
//
//            convertBSTHelper(root.left);
//
//            map.put(root.val, sumOfTree);
//            sumOfTree += root.val;
//
//            convertBSTHelper(root.right);
//
//        }
//    }







// faster way to convert uses time complexity of O(N)
//    int sum = 0;
//    public TreeNode convertBST(TreeNode root) {
//
//        convertBSTHelper(root);
//
//        return root;
//    }
//    private void convertBSTHelper(TreeNode root) {
//        if (root != null){
//
//            convertBSTHelper(root.right);
//
//            sum += root.val;
//
//            root.val = sum;
//
//            convertBSTHelper(root.left);
//        }
//    }









    public boolean areNumbersAscending(String s) {

        StringBuilder number = new StringBuilder();
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++){

            if (Character.isDigit(s.charAt(i))){
                number.append(s.charAt(i));
            }
            else if (number.length() > 0){
                int current = Integer.parseInt(String.valueOf(number));
                if (prev >= current){
                    return false;
                }
                prev = current;
                number = new StringBuilder();
            }
        }
        if (number.length() > 0) {
            int current = Integer.parseInt(String.valueOf(number));
            if (prev > current) {
                return false;
            }
        }

        return true;
    }



    public int averageValue(int[] nums) {

        int ans = 0;
        int amount = 0;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] % 2 == 0 && nums[i] % 3 == 0){
                ans += nums[i];
                amount++;
            }

        }

        if (amount == 0){
            return 0;
        }

        return  ans / amount;
    }





//    int ans = 0;
//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        rangeSumBSTHelper(root, low, high);
//
//        return ans;
//    }
//    public void rangeSumBSTHelper(TreeNode root, int low, int high) {
//        if (root != null){
//
//            rangeSumBSTHelper(root.left, low, high);
//
//            if (root.val >= low && root.val <= high){
//                ans += root.val;
//            }
//
//
//            rangeSumBSTHelper(root.right, low, high);
//
//
//        }
//    }






//    public int numIslands(char[][] grid) {
//
//        if (grid == null){
//            return 0;
//        }
//
//        int islands = 0;
//
//
//
//        for (int i = 0; i < grid.length; i ++){
//
//            for (int j = 0; j < grid[0].length; j++){
//
//                if (grid[i][j] == '1'){
//                    islands++;
//                    dfs(grid, i, j);
//                }
//
//
//            }
//        }
//
//
//
//        return islands;
//    }
//
//    private void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
//            return;
//        }
//        else {
//            grid[i][j] = '0';
//
//            dfs(grid, i + 1, j);
//            dfs(grid, i - 1, j);
//            dfs(grid, i, j - 1);
//            dfs(grid, i, j + 1);
//        }
//    }




//    public int closedIsland(int[][] grid) {
//
//        int ans = 0;
//        for (int i = 0; i < grid.length; i++){
//
//            for (int j = 0; j < grid[0].length; j++){
//                if (grid[i][j] == 0){
//                    if (dfs(grid, i, j)){
//                        ans++;
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }
//    private boolean dfs(int[][] grid, int i, int j) {
//        if (grid[i][j] == 1){
//            return true;
//        }
//
//        if (i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1){
//            return false;
//        }
//
//        grid[i][j] = 1;
//
//
//        boolean left = dfs(grid, i, j - 1);
//        boolean right = dfs(grid, i, j + 1);
//        boolean up = dfs(grid, i - 1, j);
//        boolean down = dfs(grid, i + 1, j);
//
//        return  left && right && up && down;
//    }





//
//    public int maxAreaOfIsland(int[][] grid) {
//
//        int max = 0;
//        for (int i = 0; i < grid.length; i++){
//
//            for (int j = 0; j < grid[0].length; j++){
//
//                if (grid[i][j] == 1){
//                    int currentIsland = solveBfs(grid, i, j);
//
//                    if (max < currentIsland){
//                        max = currentIsland;
//                    }
//                }
//            }
//        }
//
//        return max;
//    }
//
//    private int solveBfs(int[][] grid, int i, int j) {
//
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
//            return 0;
//        }
//
//        grid[i][j] = 0;
//
//        return 1 + solveBfs(grid, i + 1, j) + solveBfs(grid, i - 1, j) + solveBfs(grid, i, j + 1) + solveBfs(grid, i, j - 1);
//    }




    // Surrounded Regions
//    public void solve(char[][] grid) {
//
//        for (int i = 0; i < grid[0].length; i++){
//            if (grid[0][i] == 'O'){
//                dfs(grid,0,i);
//            }
//            if (grid[grid.length-1][i] == 'O'){
//                dfs(grid,grid.length-1,i);
//            }
//        }
//
//        for (int i = 0; i < grid.length; i++){
//            if (grid[i][0] == 'O'){
//                dfs(grid,i,0);
//            }
//            if (grid[i][grid[0].length-1] == 'O'){
//                dfs(grid,i,grid[0].length-1);
//            }
//        }
//
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//                if (grid[i][j] == 'T'){
//                    grid[i][j] = 'O';
//                }
//                else if (grid[i][j] == 'O'){
//                    grid[i][j] = 'X';
//                }
//            }
//        }
//
//
//
//    }
//    private void dfs(char[][] grid, int i, int j) {
//
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'O'){
//            return;
//        }
//
//        grid[i][j] = 'T';
//
//
//        dfs(grid, i, j - 1);
//        dfs(grid, i, j + 1);
//        dfs(grid, i - 1, j);
//        dfs(grid, i + 1, j);
//    }


    public int maxAscendingSum(int[] nums) {

        if (nums.length == 1) return nums[0];

        int max = 0;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++){

            if (nums[i] > nums[i- 1]){
                current += nums[i];
            }
            else {
                if (current > max){
                    max = current;
                }
                current = nums[i];
            }


        }
        if (current > max){
            max = current;
        }

        return max;
    }






// finds all the battleships in a matrix
    public int countBattleships(char[][] board) {

        int ans = 0;
        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[0].length; j++){

                if (board[i][j] == 'X'){
                    dfsBattleship(board, i, j);
                    ans++;
                }

            }

        }

        return ans;
    }
    private void dfsBattleship(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.'){
            return;
        }

        board[i][j] = '.';

        dfsBattleship(board, i, j+1);
        dfsBattleship(board, i, j-1);
        dfsBattleship(board, i+1, j);
        dfsBattleship(board, i-1, j);

    }


//Return the maximum number of matchings between players and trainers that satisfy these conditions:

//    The ith player can match with the jth trainer if the player's ability is less than or equal to
//    the trainer's training capacity. Additionally, the ith player can be matched with at most one trainer,
//    and the jth trainer can be matched with at most one player.
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int ans = 0;

        int index1 = players.length-1;
        int index2 = trainers.length-1;
        while (index1 >=0 && index2 >= 0){


            if (players[index1] <= trainers[index2]){
                ans++;
                index1--;
                index2--;
            }
            else {
                index1--;
            }

        }
        return ans;
    }


// checks if all numbers diaganally are the same
// example: [1,2,3,4]
//          [5,1,2,3] is true

//          [1,2,3,4]
//          [5,1,2,7] is false
    public boolean isToeplitzMatrix(int[][] matrix) {


        for (int i = 0; i < matrix.length; i++){
            int index = i;
            int j = 0;
            int number = matrix[i][j];
            while (index < matrix.length && j < matrix[0].length){
                if (matrix[index][j] != number){
                    return false;
                }
                index++;
                j++;
            }
        }
        for (int j = 1; j < matrix[0].length; j++){
            int index = j;
            int i = 0;
            int number = matrix[i][j];
            while (index < matrix[0].length && i < matrix.length){
                if (matrix[i][index] != number){
                    return false;
                }
                index++;
                i++;
            }
        }

        return true;
    }





//    public boolean halvesAreAlike(String s) {
//
//        HashSet<Character> hashSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I','O', 'U'));
//
//        String half1 = s.substring(0, s.length()/2);
//        String half2 = s.substring(s.length()/2, s.length()-1);
//
//        String vowels1 = "";
//        String vowels2 = "";
//
//        for (int i = 0; i < half1.length(); i++){
//
//            if (hashSet.contains(half1.charAt(i))){
//                vowels1 += half1.charAt(i);
//            }
//
//        }
//        for (int i = 0; i < half2.length(); i++){
//
//            if (hashSet.contains(half2.charAt(i))){
//                vowels2 += half2.charAt(i);
//
//            }
//
//        }
//        if (vowels1.length() != vowels2.length()) return false;
//
//
//        int index = 0;
//        while (index < vowels1.length()){
//
//            if (vowels1.charAt(index) != vowels2.charAt(index)){
//                return false;
//            }
//
//        }
//
//        return true;
//    }



//you have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
//
//difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
//worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
//Every worker can be assigned at most one job, but one job can be completed multiple times.
//
//For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
//Returns the maximum profit we can achieve after assigning the workers to the jobs.
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> difficultyToProfit = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < profit.length; i++) {
            difficultyToProfit.put(difficulty[i], Math.max(difficultyToProfit.getOrDefault(difficulty[i], 0), profit[i]));
        }

        Arrays.sort(worker);
        Arrays.sort(difficulty);

        int maxProfit = 0;
        int i = 0;


        for (int w : worker) {
            while (i < difficulty.length && difficulty[i] <= w) {
                maxProfit = Math.max(maxProfit, difficultyToProfit.getOrDefault(difficulty[i], 0));
                i++;
            }
            ans += maxProfit;
        }

        return ans;
    }






// checks if tile coordinates of a chess board is white
    public boolean squareIsWhite(String coordinates) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('a',0);
        map.put('b',1);
        map.put('c',2);
        map.put('d',3);
        map.put('e',4);
        map.put('f',5);
        map.put('g',6);
        map.put('h',7);

        int nr1 = map.get(coordinates.charAt(0));
        int nr2 = coordinates.charAt(1);

        if (nr1 % 2 == 0 && nr2 % 2 == 0){
            return true;
        }
        else if (nr1 % 2 == 1 && nr2 % 2 == 1){
            return true;
        }

        return false;
    }








    public int matrixSum(int[][] nums) {
        for (int[] array : nums){
            Arrays.sort(array);
        }

        int ans = 0;

        for (int i = 0; i < nums[0].length; i++){
            int max = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[i][j] > max){
                    max = nums[i][j];
                }

            }
            ans += max;
        }
        return ans;
    }










// adds spaces in s with the given places in spaces
    public String addSpaces(String s, int[] spaces) {

        StringBuilder ans = new StringBuilder();

        int index1 = 0;
        int index2 = 0;

        while (index1 < s.length() && index2 < spaces.length){

            if (index1 == spaces[index2]){
                ans.append(" ");
                index2++;
            }
            else{
                ans.append(s.charAt(index1));
                index1++;
            }
        }

        ans.append(s.substring(index1));



        return String.valueOf(ans);

    }










    public int[][] sortTheStudents(int[][] score, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] scores = new int[score.length];

        for (int i = 0; i < score.length; i++){
            List<Integer> list1 = new ArrayList<>();

            for (int j = 0; j < score[0].length; j++){
                list1.add(score[i][j]);
            }
            scores[i] = score[i][k];
            map.put(scores[i], list1);
        }

        Arrays.sort(scores);


        for (int i = 0; i < scores.length; i++){
            List<Integer> info = map.get(scores[(scores.length-1) - i]);

            for (int j = 0; j < score[0].length; j++){
                score[i][j] = info.get(j);
            }

        }

        return score;
    }




// gets all numbers from linked list and doubles them:
//    (5) -> (2) -> (3) ->
//    turns into:
//    (1) -> (0) -> (4) -> (6) ->
    public ListNode doubleIt(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = head;

        StringBuilder stringBuilder = new StringBuilder();

        while (current != null){
            stringBuilder.append(current.val);
            current = current.next;
        }

        char[] numbers = String.valueOf (Integer.parseInt(String.valueOf(stringBuilder)) * 2).toCharArray();


        for (int i = 0; i < numbers.length; i++){

            head.val = Integer.parseInt(String.valueOf(numbers[i]));

            if (head.next != null){
                head = head.next;
            }
            else {
                if(i != numbers.length-1){
                    head.next = new ListNode();
                    head = head.next;

                }
            }


        }

        return dummy.next;
    }








    public int isWinner(int[] player1, int[] player2) {

        int totalP1 = 0;
        int totalP2 = 0;


        int strikeP1 = 0;
        int strikeP2 = 0;

        for (int i = 0; i < player1.length; i++){

            if (strikeP1 > 0){
                strikeP1--;
                totalP1 += player1[i] *2;
            }
            else {
                totalP1 += player1[i];
            }
            if (player1[i] == 10){
                strikeP1 = 2;
            }

            if (strikeP2 > 0){
                strikeP2--;
                totalP2 += player2[i] *2;
            }
            else {
                totalP2 += player2[i];
            }
            if (player2[i] == 10){
                strikeP2 = 2;
            }


        }

        if (totalP1 > totalP2){
            return 1;
        }
        else if (totalP1 < totalP2){
            return 2;
        }

        return 0;
    }






// checks wich indexes are not sorted/
    public int heightChecker(int[] heights) {

        int ans = 0;


        int[] expected = heights.clone();
        Arrays.sort(expected);

        for (int i = 0; i < heights.length; i++){

            if (heights[i] != expected[i]){
                ans++;
            }

        }

        return ans;

    }





//    Returns the number of students doing their homework at time queryTime.
//    More formally, returns the number of students where queryTime lays in the
//    interval [startTime[i], endTime[i]] inclusive.
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {


        int total = 0;

        for (int i = 0; i < startTime.length; i++){

            if (startTime[i] <= queryTime && endTime[i] >= queryTime){
                total++;
            }



        }

        return total;
    }





// keeps checking if adding the next number is benifical otherwise it wil start counting for the next subarray.
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localmax = 0;

        for (int i = 0; i < nums.length; i++){

            localmax = Math.max(nums[i], nums[i] + localmax);

            if (localmax > max) max = localmax;

        }
        return max;
    }







//1944
    public int[] canSeePersonsCount(int[] heights) {

        int[] ans = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0 ; i--){
            int seePeopleAmount = 0;
            while (!stack.isEmpty() && heights[i] > stack.peek()){
                seePeopleAmount++;
                stack.pop();
            }
            if (!stack.isEmpty()){
                seePeopleAmount++;
            }
            stack.add(heights[i]);
            ans[i] = seePeopleAmount;

        }

        return ans;
    }







//    public int primePalindrome(int n) {
//        while (true) {
//            if (n == reverse(n) && isPrime(n)) {
//                return n;
//            }
//            n++;
//            if (10_000_000 <= n && n < 100_000_000) {
//                n = 100_000_000; // Skip to the next 8-digit number
//            }
//        }
//    }
//
//    public int reverse(int num) {
//        int reversed = 0;
//        while (num > 0) {
//            reversed = reversed * 10 + num % 10;
//            num /= 10;
//        }
//        return reversed;
//    }
//
//    public boolean isPrime(int num) {
//        if (num < 2) return false;
//        if (num == 2 || num == 3) return true;
//        if (num % 2 == 0) return false;
//
//        int sqrt = (int) Math.sqrt(num);
//        for (int i = 3; i <= sqrt; i += 2) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }






    public int CountDigits(int num) {
        int count =0;

        int x=num;

        while(x!=0){
            int t= x%10;
            if(t!=0 && num%t==0) count++;
            x/=10;
        }


        return count;
    }













// it adds all the elements in the two arrays to a single string then compares them to see if the elements together form the same string
//1662
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();

        int index = 0;

        while (index < word1.length || index < word2.length){


            if (index < word1.length){
                one.append(word1[index]);
            }
            if (index < word2.length){
                two.append(word2[index]);
            }
            index++;
        }

        return one.toString().equals(two.toString());
    }







// 84
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexes = new Stack<>();
        Stack<Integer> height = new Stack<>();

        int max = 0;
        int index = 0;
        while (index < heights.length){

            int startingIndex = index;
            while (!height.isEmpty() && height.peek() > heights[index]){

                int currentHeight = height.pop();
                int currentIndex = indexes.pop();
                startingIndex = currentIndex;

                if (max < (index - currentIndex) * currentHeight){
                    max = (index - currentIndex) * currentHeight;
                }
            }
            indexes.add(startingIndex);
            height.add(heights[index]);

            index++;
        }

        while (!height.isEmpty()){
            int currentHeight = height.pop();
            int currentIndex = indexes.pop();

            if (max < (index - currentIndex) * currentHeight){
                max = (index - currentIndex) * currentHeight;
            }
        }

        return max;
    }





    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        int[] ans = new int[temperatures.length];

        int index = 0;
        while (index < temperatures.length){

            while (!stack.isEmpty() && stack.peek() < temperatures[index]){
                int currentIndex = indexes.pop();
                stack.pop();
                ans[currentIndex] = index-currentIndex;
            }

            stack.add(temperatures[index]);
            indexes.add(index);

            index++;
        }


        return ans;
    }







    public int numOfSubarrays(int[] arr, int k, int threshold) {

            if (arr.length < k) return 0;
            int ans = 0;
            int currSum = 0;

            for (int i = 0; i < k-1; i++){
                currSum += arr[i];
            }

            for (int i = 0; i < arr.length - k + 1; i++){
                currSum += arr[i + k -1];
                if (currSum / k >= threshold){
                    ans++;
                }
                currSum -= arr[i];
            }

            return ans;

    }

//    show jasper
//--------------------------------------------------------\\
//    239
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k-1; i++){

            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }



        for (int i = 0; i < nums.length - k + 1; i++){

            while (!queue.isEmpty() && queue.peekLast() < nums[i + k - 1]) {
                queue.pollLast();
            }
            queue.addLast(nums[i + k -1]);
            ans[i] = queue.getFirst();

            if (queue.peekFirst() == nums[i]){
                queue.pollFirst();
            }

        }

        return ans;
    }





// finds all subsets in the array nums
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//
//
//        dfs(0, ans, list, nums);
//
//        return ans;
//    }
//
//    public void dfs(int index, List<List<Integer>> ans, List<Integer> list, int[] nums) {
//
//        if (index >= nums.length){
//            ans.add(new ArrayList<>(list));
//        }
//        else {
//            list.add(nums[index]);
//            dfs(index + 1, ans, list, nums);
//
//            list.remove(list.size()-1);
//            dfs(index + 1, ans, list, nums);
//        }
//    }




// finds all combinations int the array candidates that sum up to target
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//
//        dfs(0, ans, list, candidates, target, 0);
//
//        return ans;
//    }
//
//    public void dfs(int index, List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int total) {
//        if (total == target){
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        if (index >= candidates.length || total > target){
//            return;
//        }
//
//        list.add(candidates[index]);
//        dfs(index, ans, list, candidates, target, total + candidates[index]);
//
//        list.remove(list.size()-1);
//        dfs(index+1, ans, list, candidates, target, total);
//    }



// O(N^2)
    public int[] treeQueries(TreeNode root, int[] queries) {

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++){

            remove(root,root, queries[i], ans, i);
        }
        return ans;
    }
    private void remove(TreeNode node,TreeNode root, int val, int[] ans, int index) {
        if (node != null){
            remove(node.left,root, val, ans, index);

            if (node.left != null && node.left.val == val){
                TreeNode left = node.left;
                node.left = null;
                ans[index] = treeHeight(root)-1;
                node.left = left;
            }
            else if (node.right != null && node.right.val == val){
                TreeNode right = node.right;
                node.right = null;
                ans[index] = treeHeight(root)-1;
                node.right = right;
            }
            else {
                remove(node.right,root, val, ans, index);
            }

        }
    }


    public int treeHeight(TreeNode root) {

        if (root != null){

            int a=treeHeight(root.left), b= treeHeight(root.right);
            if (a > b){
                return 1+ a;
            }
            else {
                return 1 + b;
            }
        }

        return 0;
    }










    public void sortColors(int[] nums) {

        while (true){
            boolean isSorted = true;
            for (int i = 0; i < nums.length; i++){
                int index = i;
                while (index-1 >= 0 && nums[index] < nums[index-1]){
                    int temp = nums[index-1];
                    isSorted = false;
                    nums[index-1] = nums[index];
                    nums[index] = temp;
                }

            }
            if (isSorted){
                break;
            }
        }


    }









    public int[] findDiagonalOrder(int[][] mat) {

        int[] ans = new int[mat.length * mat[0].length];

        int index = 0;
        int row = 0, col = 0;


        while (index < ans.length){

            while (row >= 0&& col < mat[0].length){
                ans[index] = mat[row][col];
                index++;
                row--;
                col++;
            }
            row++;

            if (col >= mat[0].length){
                col--;
                row++;
            }

            while (row < mat.length && col >= 0){
                ans[index] = mat[row][col];
                index++;
                row++;
                col--;
            }
            col++;

            if (row >= mat.length){
                row--;
                col++;
            }
        }


        return ans;
    }









    public boolean isCircularSentence(String sentence) {

        if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)) return false;

        String[] words = sentence.split(" ");

        for (int i = 1; i < words.length; i++){
            if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                return false;
            }
        }

        return true;
    }








    public int maxPower(String s) {

        char prev = '1';
        int max = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != prev){
                if (max < current){
                    max = current;
                }
                current = 1;
            }
            else {
                current++;
            }
            prev = s.charAt(i);
        }
        return max;
    }









//    does bfs for inserting.
//    TreeNode root;
//    public CBTInserter(TreeNode root) {
//        this.root = root;
//    }
//
//    public int insert(int val) {
//
//        TreeNode node = root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(node);
//
//
//        while (!queue.isEmpty()){
//
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++){
//
//                TreeNode curr = queue.poll();
//
//                if (curr.left == null){
//                    curr.left = new TreeNode(val);
//                    return curr.val;
//                }
//                if (curr.right == null){
//                    curr.right = new TreeNode(val);
//                    return curr.val;
//                }
//
//                queue.offer(curr.left);
//                queue.offer(curr.right);
//            }
//        }
//        return -1;
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }


// finds the minimum amount of steps to make n 1
//    by deviding if n % 2 == 0 and if it's an odd number you can choose to either doe plus one or minus one,
//    so we use bfs to add and remove one
//    int ans = Integer.MAX_VALUE;
//    public int integerReplacement(int n) {
//        if (n == 2147483647) return 32;
//
//        dfs(n, 0);
//
//        return ans;
//    }
//
//    public void dfs(int n, int steps) {
//
//        if (steps > ans) return;
//        if (n == 1) {
//            ans = steps;
//            return;
//        }
//        if (n % 2 == 0 && n != 0){
//            dfs(n/2, steps+1);
//        }
//        else {
//            dfs(n+1, steps+1);
//            dfs(n-1, steps+1);
//
//        }
//    }




    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;

        int number = 0;
        for (int i = 1; i <= k; i++){

            number = ((number*10 + 1)%k);
            if (number == 0) return i;

        }
        return -1;
    }

//    uses bfs to make a queue of nodes to add to for insert
//    by doing it this way we only have to look through the tree ones
//    and inserting becomes o(1)
//    TreeNode root;
//    Queue<TreeNode> queue = new LinkedList<>();
//    public CBTInserter(TreeNode root) {
//        this.root = root;
//
//        Queue<TreeNode> bfs = new LinkedList<>();
//        bfs.offer(root);
//        while (!bfs.isEmpty()){
//
//            int size = bfs.size();
//
//            for (int i = 0; i < size; i++){
//
//                TreeNode curr = bfs.poll();
//
//                if (curr.left == null || curr.right == null){
//                    queue.offer(curr);
//                }
//                if (curr.left != null) bfs.offer(curr.left);
//                if (curr.right != null) bfs.offer(curr.right);
//            }
//        }
//    }
//
//    public int insert(int val) {
//
//        TreeNode curr = queue.peek();
//
//        if (curr.left == null){
//            curr.left = new TreeNode(val);
//            queue.offer(curr.left);
//            if (curr.right != null){
//                queue.poll();
//            }
//        }
//        else if (curr.right == null){
//            curr.right = new TreeNode(val);
//            queue.offer(curr.right);
//            if (curr.left != null){
//                queue.poll();
//            }
//        }
//        return curr.val;
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }

















// makes a simple banking system
//    long[] balance;
//    public Bank(long[] balance) {
//
//        this.balance = balance;
//
//
//    }
//
//    public boolean transfer(int account1, int account2, long money) {
//        if (accountValidation(account1) && accountValidation(account2) && balance[account1-1] >= money){
//            balance[account1-1] = balance[account1-1] - money;
//            balance[account2-1] = balance[account2-1] + money;
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deposit(int account, long money) {
//        if (accountValidation(account)){
//            balance[account-1] = balance[account-1] + money;
//            return true;
//        }
//        return false;
//    }
//
//    public boolean withdraw(int account, long money) {
//        if (accountValidation(account) && balance[account-1] >= money){
//            balance[account-1] = balance[account-1] - money;
//            return true;
//        }
//        return false;
//    }
//    public boolean accountValidation(int account){
//
//        return account-1 < balance.length && account >= 0;
//    }






//      returns a list of coordinates of the values that can flow water from it's place to the top/left border and bottom/right
//    water can only flow to values lower then itself you can see it as the heights
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        boolean[][] pacific = new boolean[heights.length][heights[0].length];
//        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
//
//        for (int i = 0; i < heights[0].length; i++){
//
//            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
//
//            dfs(heights, heights.length -1, i, Integer.MIN_VALUE, atlantic);
//        }
//
//        for (int i = 0; i < heights.length; i++){
//
//            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
//
//            dfs(heights, i, heights[0].length-1, Integer.MIN_VALUE, atlantic);
//        }
//
//        for (int i = 0; i < heights.length; i++){
//            for (int j = 0; j < heights[0].length; j++){
//
//                if (pacific[i][j] && atlantic[i][j]){
//                    ans.add(Arrays.asList(i,j));
//                }
//
//            }
//        }
//
//
//        return ans;
//    }
//
//    private void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
//        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || ocean[i][j] || heights[i][j] < prev) return;
//
//        ocean[i][j] = true;
//
//        dfs(heights, i-1, j, heights[i][j], ocean);
//        dfs(heights, i+1, j, heights[i][j], ocean);
//        dfs(heights, i, j-1, heights[i][j], ocean);
//        dfs(heights, i, j+1, heights[i][j], ocean);
//    }









    public int orangesRotting(int[][] grid) {

        int[][] stepsVisited = new int[grid.length][grid[0].length];
        for (int[] array : stepsVisited){
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){

                if (grid[i][j] == 2){
                    dfs(grid, i, j,0, stepsVisited);
                }
            }
        }
        for (int i = 0; i < stepsVisited.length; i++){
            for (int j = 0; j < stepsVisited[0].length; j++){
                if (grid[i][j] == 1 && stepsVisited[i][j] == Integer.MAX_VALUE) return -1;
                if (stepsVisited[i][j] != Integer.MAX_VALUE && stepsVisited[i][j] > max){
                    max = stepsVisited[i][j];
                }
            }
        }
        if (max == Integer.MIN_VALUE) return 0;

        return max;
    }

    public void dfs(int[][] grid, int i, int j, int steps, int[][] visited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] < steps || grid[i][j] == 0){
            return;
        }

        visited[i][j] = steps;

        dfs(grid, i+1, j, steps + 1, visited);
        dfs(grid, i-1, j, steps + 1, visited);
        dfs(grid, i, j+1, steps + 1, visited);
        dfs(grid, i, j-1, steps + 1, visited);
    }

//    int goodNodes = 0;
//    public int goodNodes(TreeNode root) {
//
//        goodNodesHelper(root, root.val);
//
//        return goodNodes;
//    }
//    public void goodNodesHelper(TreeNode root, int maxInPath) {
//        if (root != null){
//            if (root.val >= maxInPath){
//                maxInPath = root.val;
//                goodNodes++;
//            }
//            goodNodesHelper(root.left, maxInPath);
//            goodNodesHelper(root.right, maxInPath);
//
//        }
//    }




    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (visited[i] == 0){
                if (isCyclic(adj, visited, i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {

        if (visited[curr] == 2){
            return true;
        }

        visited[curr] = 2;

        for (int i = 0; i < adj.get(curr).size(); i++){
            if (visited[adj.get(curr).get(i)] != 1){
                if (isCyclic(adj, visited, adj.get(curr).get(i))){
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    }









//79. Word Search
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (dfs(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int start, String word) {
        if (start == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = dfs(board, i+1, j, start +1,word)||
                dfs(board, i-1, j, start+1,word)||
                dfs(board, i, j+1, start+1,word)||
                dfs(board, i, j-1, start+1,word);

        board[i][j] = temp;

        return found;
    }



    public int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];
        for (int[] a : grid){
            Arrays.fill(a, 1);
        }

        for (int i = m -2; i >= 0; i--){
            for (int j = n -2; j >= 0; j--){

                grid[i][j] = grid[i + 1][j] + grid[i][j+1];


            }
        }

        return grid[0][0];
    }



    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        generateParenthesis(ans, n, 0,new StringBuilder());

        return ans;
    }
    public void generateParenthesis(List<String> list, int open, int close, StringBuilder parenthesis) {
        if (open == 0 && close == 0){
            list.add(parenthesis.toString());
            return;
        }

        if (open > 0){
            parenthesis.append("(");
            generateParenthesis(list, open-1, close+1, parenthesis);
            parenthesis.setLength(parenthesis.length()-1);
        }

        if (close > 0){
            parenthesis.append(")");
            generateParenthesis(list, open, close-1, parenthesis);
            parenthesis.setLength(parenthesis.length()-1);
        }
    }





//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> ans = new ArrayList<>();
//        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
//
//
//        for (int i = 0; i < board.length; i++){
//            for (int j = 0; j < board[0].length; j++) {
//                findWords(board, i, j, new StringBuilder(), hashSet, 10, ans);
//            }
//        }
//
//        return ans;
//    }
//    public void findWords(char[][] board, int i, int j,StringBuilder word, HashSet<String> hashSet, int max, List<String> ans) {
//        if (hashSet.contains(word.toString()) && !ans.contains(word.toString())){
//            ans.add(word.toString());
//        }
//        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.length() > max || board[i][j] == ' '){
//            return;
//        }
//
//        char temp = board[i][j];
//        board[i][j] = ' ';
//        word.append(temp);
//
//
//        findWords(board, i+1, j, word, hashSet, max, ans);
//        findWords(board, i-1, j, word, hashSet, max, ans);
//        findWords(board, i, j+1, word, hashSet, max, ans);
//        findWords(board, i, j-1, word, hashSet, max, ans);
//
//        board[i][j] = temp;
//        word.setLength(word.length()-1);
//
//    }
//    int max = 0;
//    public int getMaximumGold(int[][] grid) {
//
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//
//                if (grid[i][j] != 0){
//                    dfs(grid,i,j,0);
//                }
//
//
//            }
//        }
//
//
//        return max;
//    }
//
//    public void dfs(int[][] grid, int i, int j, int curr) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
//            return;
//        }
//
//        int temp = grid[i][j];
//        grid[i][j] = 0;
//
//        curr += temp;
//
//        if (curr > max){
//            max = curr;
//        }
//
//        dfs(grid, i+1, j, curr);
//        dfs(grid, i-1, j, curr);
//        dfs(grid, i, j+1, curr);
//        dfs(grid, i, j-1, curr);
//
//        grid[i][j] = temp;
//    }







    public String longestPalindrome(String s) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++){

            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if (ans.length() < (right - left) + 1){
                    ans.setLength(0);
                    ans.append(s, left, right+1);
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if (ans.length() < (right - left) + 1){
                    ans.setLength(0);
                    ans.append(s, left, right+1);
                }
                left--;
                right++;
            }


        }
        return ans.toString();
    }






    public int minPathSum(int[][] grid) {
        for (int i = grid.length-1; i >= 0; i--){
            for (int j = grid[0].length -1; j >= 0 ; j--){
                int minSteps1 = setvalue(grid, i+1, j);
                int minSteps2 = setvalue(grid, i, j+1);
                if (minSteps1 <= minSteps2){
                    if (minSteps1 != Integer.MAX_VALUE){
                        grid[i][j] = grid[i][j] + minSteps1;
                    }
                    else {
                        grid[i][j] = grid[i][j];
                    }
                }
                else {
                    grid[i][j] = grid[i][j] + minSteps2;
                }
            }
        }
        return grid[0][0];
    }

    private int setvalue(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        return grid[i][j];
    }



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] ans = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++){
            if (obstacleGrid[i][0] == 0){
                ans[i][0] = 1;
            }
            else break;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++){
            if (obstacleGrid[0][j] == 0){
                ans[0][j] = 1;
            }
            else break;
        }

        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] == 0){
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
                }
            }
        }
        return ans[ans.length-1][ans[0].length-1];
    }




//980. Unique Paths III
    public int uniquePathsIII(int[][] grid) {
        int nrOfEmptySquares = 0;
        int xStart = 0;
        int yStart = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    nrOfEmptySquares++;
                }
                else if (grid[i][j] == 1){
                    xStart = i;
                    yStart = j;
                }

            }
        }


        return dfsPath(grid, xStart, yStart, nrOfEmptySquares);
    }
    public int dfsPath(int[][] grid, int i, int j, int nrOfEmptySquares) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return 0;

        if (grid[i][j] == 2){
            return nrOfEmptySquares == -1 ? 1 : 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;

        nrOfEmptySquares--;

        int total = dfsPath(grid, i+1, j, nrOfEmptySquares)+ dfsPath(grid, i-1, j, nrOfEmptySquares)+
                    dfsPath(grid, i, j+1, nrOfEmptySquares)+ dfsPath(grid, i, j-1, nrOfEmptySquares);

        grid[i][j] = temp;
        return total;
    }





    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfsLongestIncreasingPath(matrix, i, j, Integer.MIN_VALUE, memory));
            }
        }

        return max;
    }

    public int dfsLongestIncreasingPath(int[][] matrix, int i, int j, int prev, int[][] mem) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) return 0;

        if (mem[i][j] != 0) return mem[i][j];

        int currMax = 1;

        currMax = Math.max(currMax, 1 + dfsLongestIncreasingPath(matrix, i + 1, j, matrix[i][j], mem));
        currMax = Math.max(currMax, 1 + dfsLongestIncreasingPath(matrix, i - 1, j, matrix[i][j], mem));
        currMax = Math.max(currMax, 1 + dfsLongestIncreasingPath(matrix, i, j + 1, matrix[i][j], mem));
        currMax = Math.max(currMax, 1 + dfsLongestIncreasingPath(matrix, i, j - 1, matrix[i][j], mem));

        mem[i][j] = currMax;
        return mem[i][j];
    }










//    class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//    }
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//
//        HashMap<Node, Node> map = new HashMap<>();
//        map.put(null, null);
//
//        Node curr = head;
//
//
//        while (curr != null){
//
//            Node copy = new Node(curr.val);
//            map.put(curr, copy);
//            curr = curr.next;
//        }
//        curr = head;
//        while (curr != null){
//
//            Node copy = map.get(curr);
//            copy.next = map.get(curr.next);
//            copy.random = map.get(curr.random);
//            curr = curr.next;
//        }
//
//        return map.get(head);
//    }







//    int ans = Integer.MIN_VALUE;
//    public int maxPathSum(TreeNode root) {
//
//        dfsSum(root);
//
//        return ans;
//    }
//
//    private int dfsSum(TreeNode root) {
//        if (root == null) return 0;
//
//        int maxLeft = dfsSum(root.left);
//        int maxRight = dfsSum(root.right);
//
//        maxLeft = Math.max(maxLeft, 0);
//        maxRight = Math.max(maxRight, 0);
//
//        ans = Math.max(ans, root.val + maxLeft + maxRight);
//
//        return root.val + Math.max(maxLeft, maxRight);
//    }






    public int candy(int[] ratings) {
        int[] array = new int[ratings.length];
        Arrays.fill(array,1);

        for (int i = 1; i < ratings.length; i++){
            if (ratings[i-1] < ratings[i]){
                array[i] = array[i-1] + 1;
            }
        }

        for (int i = ratings.length-2; i >= 0; i--){
            if (ratings[i + 1] < ratings[i] && array[i + 1] >= array[i]){
                array[i] = array[i + 1] + 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < array.length; i++){
            ans += array[i];
        }
        return ans;
    }







    public int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;

        int left = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++){

            currSum += nums[i];
            while (currSum >= target){
                ans = Math.min(ans, (i - left) + 1);
                currSum -= nums[left];
                left++;
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


//2771
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int max = 0;
        int currMax = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++){
            if (nums1[i] >= prev && nums2[i] >= prev){
                prev = Math.min(nums1[i], nums2[i]);
                currMax++;
                max = Math.max(max, currMax);
            }
            else if (nums1[i] >= prev){
                prev = nums1[i];
                currMax++;
                max = Math.max(max, currMax);
            }
            else if (nums2[i] >= prev){
                prev = nums2[i];
                currMax++;
                max = Math.max(max, currMax);
            }
            else {
                currMax = 0;
                prev = Integer.MIN_VALUE;
                i--;
            }
        }

        return max;
    }








//2684. Maximum Number of Moves in a Grid
    public int maxMoves(int[][] grid) {
        int max = 0;
        int[][] mem = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){

            max = Math.max(max, maxMovesDfs(grid, i, 0, Integer.MIN_VALUE, 0, mem));

        }
        return max-1;
    }

    public int maxMovesDfs(int[][] grid, int i, int j, int prev, int currMoves, int[][] mem) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev) return 0;

        if (mem[i][j] != 0) return mem[i][j];


        mem[i][j] = Math.max(mem[i][j], 1 + maxMovesDfs(grid, i - 1, j + 1, grid[i][j], currMoves + 1, mem));
        mem[i][j] = Math.max(mem[i][j], 1 + maxMovesDfs(grid, i , j + 1, grid[i][j], currMoves + 1, mem));
        mem[i][j] = Math.max(mem[i][j], 1 + maxMovesDfs(grid, i + 1, j + 1, grid[i][j], currMoves + 1, mem));


        return mem[i][j];
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorDfs(root, p, q);
    }


    public TreeNode lowestCommonAncestorDfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null){

            if (root == p || root == q) return root;

            TreeNode node = lowestCommonAncestorDfs(root.left, p, q);

            TreeNode node1 = lowestCommonAncestorDfs(root.right, p, q);

            if (node != null && node1 != null){
                return root;
            }
            else if (node != null) return node;
            else if (node1 != null) return node1;

        }
        return null;
    }






//    List<Integer> list = new ArrayList<>();
//    int index = 0;
//    public BSTIterator(TreeNode root) {
//        dfs(root);
//    }
//    void dfs(TreeNode node){
//        if (node == null) return;
//
//        dfs(node.left);
//        list.add(node.val);
//        dfs(node.right);
//
//
//    }
//    public int next() {
//        int ans = list.get(index);
//        index++;
//        return ans;
//    }
//
//    public boolean hasNext() {
//        return index +1 < list.size();
//    }














    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];

        for (int i = 0; i < box.length; i++){
            for (int j = box[0].length -1; j >= 0; j--){

                if (box[i][j] == '#'){

                    int index = j;
                    while (index + 1 < box[i].length && box[i][index+1] != '*'){

                        char temp = box[i][index + 1];
                        box[i][index + 1] = box[i][index];
                        box[i][index] = temp;

                        index+=1;
                    }
                }
            }
        }
        int r = 0;
        int c = ans[0].length-1;
        for (int i = 0; i < box.length; i++){
            for (int j = 0; j < box[0].length; j++){
                if (r / box[0].length == 1){
                    c--;
                    r = 0;
                }

                ans[r][c] = box[i][j];

                r++;
            }
        }

        return ans;
    }









    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] mem = new int[matrix.length][matrix[0].length];

        for (int[] array : mem){
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        for (int i = 0; i < matrix[0].length; i++){
            ans = Math.min(ans, minFallingPathSumDfs(matrix, 0, i, mem));
        }

        return ans;
    }

    public int minFallingPathSumDfs(int[][] matrix, int i, int j, int[][] mem) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;

        if (mem[i][j] != Integer.MAX_VALUE) return mem[i][j];

        mem[i][j] = Math.min(mem[i][j], matrix[i][j] + minFallingPathSumDfs(matrix, i+1, j - 1, mem));
        mem[i][j] = Math.min(mem[i][j], matrix[i][j] + minFallingPathSumDfs(matrix, i+1, j, mem));
        mem[i][j] = Math.min(mem[i][j], matrix[i][j] + minFallingPathSumDfs(matrix, i+1, j+1, mem));

        return mem[i][j];
    }









//    Map<Integer, Integer> map = new HashMap<>();
//    public int minDays(int n) {
//        map.put(0,0);
//        map.put(1,1);
//
//        return minDaysDfs(n);
//    }
//    public int minDaysDfs(int n) {
//
//        if(map.containsKey(n)){
//            return map.get(n);
//        }
//
//        int one = 1 + (n % 2) + minDays(n/2);
//        int two = 1 + (n % 3) + minDays(n/3);
//
//        map.put(n, Math.min(one, two));
//        return map.get(n);
//    }






    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();

        getAllElementsDfs(root1, root2, ans);
        Collections.sort(ans);
        return ans;
    }

    public void getAllElementsDfs(TreeNode root1, TreeNode root2, List<Integer> ans) {
        if (root1 == null && root2 == null) return;


        if (root1 == null){
            getAllElementsDfs(root1, root2.left, ans);
            ans.add(root2.val);
            getAllElementsDfs(root1, root2.right, ans);
        }
        else if (root2 == null){
            getAllElementsDfs(root1.right, root2, ans);
            ans.add(root1.val);
            getAllElementsDfs(root1.left, root2, ans);
        }
        else {
            getAllElementsDfs(root1.left, root2.left, ans);
            ans.add(root1.val);
            ans.add(root2.val);
            getAllElementsDfs(root1.right, root2.right, ans);
        }


    }







    public int findDuplicate(int[] nums) {


        int slow = 0;
        int fast = 0;

        while (true){

            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast){
                break;
            }

        }

        int slow2 = 0;

        while (slow != slow2){
            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow;
    }





//    int maximumAbDiffrence = Integer.MAX_VALUE;
//    public int minimumEffortPath(int[][] heights) {
//
//        mimumEffortPathDfs(heights, 0, 0, heights[0][0], 0);
//
//        return maximumAbDiffrence;
//    }
//
//    public void mimumEffortPathDfs(int[][] heights, int i, int j, int prev, int currMax) {
//
//        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] == 0 ) return;
//
//        if (Math.abs(heights[i][j] - prev) > currMax){
//            currMax = Math.abs(prev - heights[i][j]);
//        }
//        if (i == heights.length-1 && j == heights[0].length-1 && currMax < maximumAbDiffrence){
//            maximumAbDiffrence = currMax;
//            return;
//        }
//
//        int temp = heights[i][j];
//        heights[i][j] = 0;
//
//        mimumEffortPathDfs(heights, i+1, j, temp, currMax);
//        mimumEffortPathDfs(heights, i-1, j, temp, currMax);
//        mimumEffortPathDfs(heights, i, j+1, temp, currMax);
//        mimumEffortPathDfs(heights, i, j-1, temp, currMax);
//
//        heights[i][j] = temp;
//
//    }










    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = head;
        int length = 0;

        while (curr != null){
            curr = curr.next;
            length++;
        }
        curr = head;
        if (length == 1) return null;
        length = length /2;
        while (curr.next != null){
            length--;

            if (length == 0){
                curr.next = curr.next.next;
                break;
            }

            curr = curr.next;
        }

        return head;
    }











//430. Flatten a Multilevel Doubly Linked List
//    Node newHead;
//    public Node flatten(Node head) {
//
//        if (head == null) return null;
//
//        flattenDfs(head);
//        while (newHead.prev != null){
//            newHead = newHead.prev;
//        }
//
//        return newHead;
//    }
//
//    public void flattenDfs(Node head) {
//        if (head == null) return;
//
//        if (newHead == null){
//            newHead = new Node();
//            newHead.val = head.val;
//        }
//        else {
//            newHead.next = new Node();
//            newHead.next.val = head.val;
//            newHead.next.prev = newHead;
//            newHead = newHead.next;
//        }
//
//
//        flattenDfs(head.child);
//        flattenDfs(head.next);
//    }




    public int[] nextLargerNodes(ListNode head) {

        ListNode curr = head;

        int size = 0;

        while (curr != null){
            size++;
            curr = curr.next;
        }
        int[] ans = new int[size];
        Stack<Integer> val = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();

        curr = head;
        int index = 0;
        while (curr != null){

            while (!val.isEmpty() && curr.val > val.peek()){
                val.pop();
                int currIndex = stackIndex.pop();

                ans[currIndex] = curr.val;
            }

            val.add(curr.val);
            stackIndex.add(index);

            index++;
            curr = curr.next;
        }



        return ans;
    }













    public ListNode swapNodes(ListNode head, int k) {

        ListNode curr = head;

        ListNode first = new ListNode();
        int size = 0;

        while (curr != null){
            size++;
            if (size == k){
                first = curr;
            }
            curr = curr.next;
        }

        ListNode second = new ListNode();
        curr = head;
        int index = 1;
        while (curr != null){
            if (index == (size - (k-1))){
                second = curr;
                break;
            }

            curr = curr.next;
            index++;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }



















    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        ListNode prev = head;


        while (curr != null){

            BigInteger integer = new BigInteger(String.valueOf(curr.val));
            BigInteger integer2 = new BigInteger(String.valueOf(prev.val));
            BigInteger node = integer.gcd(integer2);


            prev.next = new ListNode(node.intValue());
            prev.next.next = curr;



            prev = curr;
            curr = curr.next;
        }
        return head;
    }









    public ListNode mergeNodes(ListNode head) {

        ListNode ans = new ListNode();
        ListNode dummy = ans;
        int currSum = 0;

        ListNode curr = head;
        while (curr != null){
            currSum += curr.val;
            if (curr.val == 0){
                ans.next = new ListNode(currSum);
                ans = ans.next;
                currSum = 0;

            }

            curr = curr.next;
        }
        return dummy.next.next;
    }



    public ListNode removeNodes(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();


        while (head != null){

            while (!deque.isEmpty() && deque.peekLast() < head.val){
                deque.pollLast();
            }
            deque.addLast(head.val);
            head = head.next;
        }

        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (!deque.isEmpty()){

            curr.next = new ListNode(deque.pollFirst());
            curr = curr.next;
        }
        return ans.next;
    }














    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        Stack<Integer> val = new Stack<>();
        Stack<Integer> indexes = new Stack<>();


        for (int i = 0; i < nums.length; i++){

            while (!val.isEmpty() && val.peek() < nums[i]){

                val.pop();
                int index = indexes.pop();
                ans[index] = nums[i];

            }
            val.add(nums[i]);
            indexes.add(i);
        }

        for (int i = 0; i < nums.length; i++){


            while (!val.isEmpty() && val.peek() < nums[i]){

                val.pop();
                int index = indexes.pop();
                ans[index] = nums[i];
            }
        }


        return ans;
    }













    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        while (l <= r){
            int currSum = nums[l] + nums[r];
            l++;
            r--;
            if (ans < currSum) ans = currSum;
        }
        return ans;
    }









//    public String reverseWords(String s) {
//        String[] list = s.split(" ");
//        StringBuilder ans = new StringBuilder();
//        StringBuilder currWord = new StringBuilder();
//        for (int i = 0; i < list.length; i++){
//            currWord.append(list[i]);
//            currWord.reverse();
//            ans.append(currWord + " ");
//            currWord.setLength(0);
//        }
//        ans.setLength(ans.length()-1);
//        return ans.toString();
//    }














    public String removeStars(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '*'){
                stringBuilder.setLength(stringBuilder.length()-1);
            }
            else {
                stringBuilder.append(s.charAt(i));
            }




        }

        return stringBuilder.toString();
    }








    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < colors.length()-1; i++){
            char left = colors.charAt(i-1);
            char mid = colors.charAt(i);
            char right = colors.charAt(i+1);
            if (mid == 'A'){
                if (left == mid && mid == right) {
                    a++;
                }
            }
            else{
                if (left == mid && mid == right) {
                    b++;
                }
            }
        }
        return a > b;
    }











    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        int i = 0;
        while(i < asteroids.length && mass < 100000 && mass >= asteroids[i]){
            mass += asteroids[i++];
        }

        return mass >= 100000 || i == asteroids.length;
    }






    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++){

            while (!stack.isEmpty() && asteroids[i] < 0 && Math.abs(asteroids[i]) > stack.peek()){

                stack.pop();
            }
            if(stack.isEmpty() && asteroids[i] < 0){
                result.add(asteroids[i]);
            }
            else if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i]) && asteroids[i] < 0){
                stack.pop();
            }
            else if (!stack.isEmpty() && stack.peek() > Math.abs(asteroids[i]) && asteroids[i] < 0){
                continue;
            }
            else{
                stack.add(asteroids[i]);
            }

        }
        int size = result.size() + stack.size();
        int[] ans = new int[size];
        int index = 0;
        for (int i = 0; i < result.size(); i++){
            ans[index] = result.get(i);
            index++;
        }
        for (int i = 0; i < stack.size(); i++){
            ans[index] = stack.get(i);
            index++;
        }

        return ans;
    }

















    public int countCollisions(String directions) {

        int left = 0;
        int right = directions.length() - 1;
        while(left < directions.length() && directions.charAt(left) == 'L'){
            left++;
        }
        while(right >= 0 && directions.charAt(right) == 'R'){
            right--;
        }

        int res = 0;
        for(int i=left; i<=right; ++i) {
            if(directions.charAt(i) != 'S')    res++;
        }
        return res;
    }





    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {

        sumEvenGrandparentDfs(root);

        return sum;
    }

    public void sumEvenGrandparentDfs(TreeNode root) {
        if (root == null) return;

        sumEvenGrandparentDfs(root.left);

        if (root.val % 2 == 0){

            if (root.left != null){
                if (root.left.left != null){
                    sum += root.left.left.val;
                }
                if (root.left.right != null){
                    sum += root.left.right.val;
                }
            }
            if (root.right != null){
                if (root.right.left != null){
                    sum += root.right.left.val;
                }
                if (root.right.right != null){
                    sum += root.right.right.val;
                }
            }

        }
        sumEvenGrandparentDfs(root.right);
    }




    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int pairs = 0;

        for (int i = 0; i < nums.length; i++){

            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else {
                int count = map.get(nums[i]);
                pairs += count;

                map.put(nums[i], count + 1);
            }


        }
        return pairs;
    }









//    int ans = 0;
//    public int maxAncestorDiff(TreeNode root) {
//
//        maxAncestorDiffDfs(root, -1, Integer.MAX_VALUE);
//
//        return ans;
//    }
//    public void maxAncestorDiffDfs(TreeNode root, int max, int min) {
//        if (root == null) return;
//
//        if (max != -1){
//            ans = Math.max(ans, max - root.val);
//        }
//        if (min != Integer.MAX_VALUE){
//            ans = Math.max(ans, Math.abs(min - root.val));
//        }
//
//        max = Math.max(max, root.val);
//        min = Math.min(min, root.val);
//
//        maxAncestorDiffDfs(root.left, max, min);
//        maxAncestorDiffDfs(root.right, max, min);
//
//    }





























    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++){
            if (grid[i][0] == 1){
                numEnclavesDfs(grid, i, 0);
            }
            if(grid[i][column-1] == 1){
                numEnclavesDfs(grid, i, column-1);
            }
        }

        for (int i = 0; i < column; i++){
            if (grid[0][i] == 1){
                numEnclavesDfs(grid, 0, i);
            }
            if(grid[row-1][i] == 1){
                numEnclavesDfs(grid, row-1, i);
            }
        }

        int numberOfEnclaves = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if(grid[i][j] == 1){
                    numberOfEnclaves++;
                }
            }
        }


        return numberOfEnclaves;
    }

    public void numEnclavesDfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;


        grid[i][j] = 0;

        numEnclavesDfs(grid, i+1, j);
        numEnclavesDfs(grid, i-1, j);
        numEnclavesDfs(grid, i, j+1);
        numEnclavesDfs(grid, i, j-1);
    }






//    int[] list;
//    public MyHashMap() {
//        list = new int[1000001];
//        Arrays.fill(list, -1);
//    }
//
//    public void put(int key, int value) {
//
//        list[key] = value;
//
//    }
//
//    public int get(int key) {
//        return list[key];
//    }
//
//    public void remove(int key) {
//        list[key] = -1;
//    }







    public int findCenter(int[][] edges) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            int count = map.containsKey(edges[i][0]) ? map.get(edges[i][0])+1 : 1;
            int count2 = map.containsKey(edges[i][1]) ? map.get(edges[i][1])+1 : 1;

            if (count > 1) return edges[i][0];
            if (count2 > 1) return edges[i][1];

            map.put(edges[i][0], count);
            map.put(edges[i][1], count2);
        }
        return -1;
    }










    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        allPathsSourceTargetDfs(graph, 0, path, ans);

        return ans;
    }


    public void allPathsSourceTargetDfs(int[][] graph, int index, List<Integer> path, List<List<Integer>> ans) {
        if (index >= graph.length) return;

        if (index == graph.length-1){
            path.add(index);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        for (int j = 0; j < graph[index].length; j++){
            if (graph[index][j] == 0) return;
            path.add(index);
            allPathsSourceTargetDfs(graph, graph[index][j], path, ans);
            path.remove(path.size()-1);

        }
    }









    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        canVisitAllRoomsDfs(rooms, 0, visited);

        for (int i = 0; i < visited.length; i++){
            if (!visited[i]) return false;
        }
        return true;
    }

    public void canVisitAllRoomsDfs(List<List<Integer>> rooms, int index, boolean[] visited) {
        if (visited[index]) return;

        visited[index] = true;


        for (int i = 0; i < rooms.get(index).size(); i++){

            int keyOfRoom = rooms.get(index).get(i);

            canVisitAllRoomsDfs(rooms, keyOfRoom, visited);

        }

    }







    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++){
            int[] temp = prices.clone();

            for (int j = 0; j < flights.length; j++){
                if (prices[flights[j][0]] == Integer.MAX_VALUE){
                    continue;
                }
                if (prices[flights[j][0]] + flights[j][2] < temp[flights[j][1]]){
                    temp[flights[j][1]] = prices[flights[j][0]] + flights[j][2];
                }
            }
            prices = temp;
        }
        if (prices[dst] == Integer.MAX_VALUE) return -1;
        return prices[dst];
    }

//    calculates the majority element. Element > n / 3;
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0;
        int count2 = 0;
        int nr1 = 0;
        int nr2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != nr2) {
                count1 = 1;
                nr1 = nums[i];
            }
            else if (count2 == 0 && nums[i] != nr1) {
                count2 = 1;
                nr2 = nums[i];
            }
            else if (nr1 == nums[i]) {
                count1++;
            } else if (nr2 == nums[i]) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nr1 == nums[i]) {
                count1++;
            } else if (nr2 == nums[i]) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            ans.add(nr1);
        }
        if (count2 > nums.length / 3) {
            ans.add(nr2);
        }

        return ans;
    }





    public boolean validPath(int n, int[][] edges, int source, int destination) {

        boolean[] visited = new boolean[n];
        visited[source] = true;
        for (int i = 0; i < n; i++){

            for (int j = 0; j < edges.length; j++){

                if (visited[edges[j][0]] || visited[edges[j][1]]){
                    visited[edges[j][1]] = true;
                    visited[edges[j][0]] = true;
                }
            }

        }



        return visited[destination];
    }
















    public int pairSum(ListNode head) {
        int size = getLength(head);

        int[] list = new int[size/2];

        for (int i = 0; i < size/2; i++){

            list[i] = head.val;

            head = head.next;

        }
        int maxTwinSum = Integer.MIN_VALUE;
        for (int i = 0; i < size/2; i++){
            maxTwinSum = Math.max(maxTwinSum, list[list.length-1-i] + head.val);
            head = head.next;
        }

        System.out.println(list);

        return maxTwinSum;
    }


    public int getLength(ListNode head) {
        int ans = 0;
        while (head != null){
            ans++;
            head = head.next;
        }
        return ans;
    }








    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsDfs(root.left, root.right, true);
        return root;
    }

    public void reverseOddLevelsDfs(TreeNode node1, TreeNode node2, boolean odLvl) {
        if (node1 == null || node2 == null)
            return;

        if (odLvl){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        reverseOddLevelsDfs(node1.left, node2.right, !odLvl);
        reverseOddLevelsDfs(node1.right, node2.left, !odLvl);
    }








    public TreeNode removeLeafNodes(TreeNode root, int target) {

        removeLeafNodesDfs(root,target);

        if (root.val == target && root.left == null && root.right == null){
            return null;
        }
        return root;
    }



    public void removeLeafNodesDfs(TreeNode root, int target) {
        if (root == null)
            return;

        removeLeafNodesDfs(root.left, target);
        removeLeafNodesDfs(root.right, target);

        if (root.left != null && root.left.val == target && root.left.left == null && root.left.right == null){
            root.left = null;
        }
        if (root.right != null && root.right.val == target && root.right.left == null && root.right.right == null){
            root.right = null;
        }


    }





    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        for (int[] a : ans){
            Arrays.fill(a,-1);
        }

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while (head != null){

            for (int i = left; i <= right; i++){
                if (head == null)
                    break;
                ans[top][i] = head.val;
                head = head.next;
            }
            top++;

            for (int i = top; i <= bottom; i++){
                if (head == null)
                    break;
                ans[i][right] = head.val;
                head = head.next;
            }
            right--;

            for (int i = right; i >= left; i--){
                if (head == null)
                    break;
                ans[bottom][i] = head.val;
                head = head.next;
            }
            bottom--;

            for (int i = bottom; i >= top; i--){
                if (head == null)
                    break;
                ans[i][left] = head.val;
                head = head.next;
            }
            left++;

        }
        return ans;
    }






    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        return n % 3 == 0 ? (int)Math.pow(3, n/3) : (n % 3 == 1 ? (int)Math.pow(3, n/3 - 1) * 4 : (int)Math.pow(3, n/3) * 2);
    }











//    int ans = 0;
//    public int averageOfSubtree(TreeNode root) {
//
//        averageOfSubtreeDfs(root);
//        return ans;
//    }
//    public int[] averageOfSubtreeDfs(TreeNode node) {
//        if (node == null)
//            return new int[] {0,0};
//
//        int[] left = averageOfSubtreeDfs(node.left);
//        int[] right = averageOfSubtreeDfs(node.right);
//
//
//        int total = left[0] + right[0] + node.val;
//        int count = left[1] + right[1] + 1;
//
//        if (total / count == node.val){
//            ans++;
//        }
//
//        return new int[] {total, count};
//    }















    public int numOfPairs(String[] nums, String target) {

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        int count = 0;

        for(String firstHalf : nums) {
            if (target.startsWith(firstHalf)){

                String secondHalf = target.substring(firstHalf.length());
                if (map.containsKey(secondHalf)){

                    count += map.get(secondHalf);
                    if (firstHalf.equals(secondHalf))
                        count--;

                }


            }
        }

        return count;


    }











// finds the maximum amount of ice cream a person can buy with only buying each ice cream ones with the cost of costs[i]
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);


        int ans = 0;

        for (int i = 0; i < costs.length; i++){
            if (costs[i] <= coins){
                ans++;
                coins -= costs[i];
            }
        }

        return ans;
    }








// finds out if a which balls can fall down
// example visual
//    [\/\\]
//    [////]
//    [\\\\]
//    balls starting in column 0, 1 and 3 get stuck, but 2 makes it to the bottom.
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int i = 0; i < ans.length; i++){
            ans[i] = findBallHelp(grid, 0, i);
        }
        return ans;
    }

    public int findBallHelp(int[][] grid, int row, int col) {
        if (row == grid.length)
            return col;

        if (grid[row][col] == 1){
            if (col+1 == grid[0].length || grid[row][col+1] == -1){
                return -1;
            }
            else {
               return findBallHelp(grid, row+1, col+1);
            }
        }
        else {
            if (col-1 < 0 || grid[row][col-1] == 1){
                return -1;
            }
            else {
                return findBallHelp(grid, row+1, col-1);
            }
        }

    }



// finds the first missing positive by using the input array as memory to store which numbers
// have been found. It uses the value to go to that index and turn in negative. at the end the first positive number in
// the array is the first positive missing
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }


        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            if (index > 0 && index <= nums.length){

                if (nums[index-1] > 0){
                    nums[index-1] = -Math.abs(nums[index-1]);
                }
            }
        }

        for (int i = 1; i <= nums.length; i++){
            if (nums[i-1] >= 0){
                return i;
            }
        }

        return nums.length+1;
    }










//    int ans = 0;
//    public int numWays(int steps, int arrLen) {
//
//        numWaysBackTrack(0, arrLen, steps);
//
//        return ans;
//    }
//    public void numWaysBackTrack(int currIndex, int arrLen, int stepsLeft) {
//        if (stepsLeft == 0 && currIndex == 0)
//            ans++;
//        if (stepsLeft < 0 || currIndex >= arrLen || currIndex < 0)
//            return;
//
//        stepsLeft--;
//        numWaysBackTrack(currIndex, arrLen, stepsLeft);
//        numWaysBackTrack(currIndex+1, arrLen, stepsLeft);
//        numWaysBackTrack(currIndex-1, arrLen, stepsLeft);
//
//
//
//    }






    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currDept = 2;

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if (currDept == depth){
                    TreeNode left = new TreeNode(val);
                    left.left = curr.left;

                    TreeNode right = new TreeNode(val);
                    right.right = curr.right;

                    curr.left = left;
                    curr.right = right;
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }


            currDept++;
            if (currDept > depth)
                break;
        }
        return root;
    }









    int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int amount = 0;

        for (int i = 0; i < grid1.length; i++){
            for (int j = 0; j < grid1[0].length; j++){

                if (grid2[i][j] == 1){
                    ans = 1;
                    countSubIslandsDfs(grid1, grid2, i, j);
                    if (ans == 1) amount++;
                }
            }
        }


        return amount;
    }
    public void countSubIslandsDfs(int[][] grid, int[][] island, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || island[i][j] == 0) return;

        if (grid[i][j] == 0) ans = 0;

        grid[i][j] = 0;
        island[i][j] = 0;

        countSubIslandsDfs(grid, island, i+1, j);
        countSubIslandsDfs(grid, island, i-1, j);
        countSubIslandsDfs(grid, island, i, j+1);
        countSubIslandsDfs(grid, island, i, j-1);

    }







    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int curr = 0;

        int index = satisfaction.length-1;

        while (index >= 0 && satisfaction[index] + curr > 0){
            curr += satisfaction[index];
            ans += curr;
            index--;
        }
        return ans;
    }




    public int numberOfBeams(String[] bank) {
        int allBeams = 0;
        int prevAmountOfBeams = 0;
        for (String laser : bank) {
            int currAmountOfBeams = 0;
            for (char t : laser.toCharArray()) {
                if (t == '1') {
                    currAmountOfBeams++;
                }
            }
            allBeams += prevAmountOfBeams * currAmountOfBeams;
            if (currAmountOfBeams > 0) {
                prevAmountOfBeams = currAmountOfBeams;
            }
        }
        return allBeams;
    }







    public int minAddToMakeValid(String s) {


        int open = 0;
        int closed = 0;
        for (char l : s.toCharArray()){
            if (l == '('){
                open++;
            }
            else {
                if (open <= 0){
                    closed++;
                }
                else {
                    open--;
                }
            }
        }

        return open + closed;
    }














    public int swimInWater(int[][] grid) {
        int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new  int[] {grid[0][0], 0, 0});
        visited[0][0] = true;

        int ans = 0;

        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            ans = Math.max(ans, curr[0]);

            if (curr[1] == grid.length-1 && curr[2] == grid[0].length-1){
                break;
            }

            for (int i = 0; i < 4; i++){
                int x = curr[1] + adj[i][0];
                int y = curr[2] + adj[i][1];

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !visited[x][y]){
                    minHeap.add(new int[] {grid[x][y], x, y});
                    visited[x][y] = true;
                }
            }

        }


        return ans;
    }




































}
