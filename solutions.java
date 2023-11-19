import java.math.BigInteger;
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
//        int[][] dp = new int[heights.length][heights[0].length];
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





//    int sum = 0;
//    public int sumEvenGrandparent(TreeNode root) {
//
//        sumEvenGrandparentDfs(root);
//
//        return sum;
//    }
//
//    public void sumEvenGrandparentDfs(TreeNode root) {
//        if (root == null) return;
//
//        sumEvenGrandparentDfs(root.left);
//
//        if (root.val % 2 == 0){
//
//            if (root.left != null){
//                if (root.left.left != null){
//                    sum += root.left.left.val;
//                }
//                if (root.left.right != null){
//                    sum += root.left.right.val;
//                }
//            }
//            if (root.right != null){
//                if (root.right.left != null){
//                    sum += root.right.left.val;
//                }
//                if (root.right.right != null){
//                    sum += root.right.right.val;
//                }
//            }
//
//        }
//        sumEvenGrandparentDfs(root.right);
//    }




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









//    int ans = 0;
//    public int countSubIslands(int[][] grid1, int[][] grid2) {
//
//        int amount = 0;
//
//        for (int i = 0; i < grid1.length; i++){
//            for (int j = 0; j < grid1[0].length; j++){
//
//                if (grid2[i][j] == 1){
//                    ans = 1;
//                    countSubIslandsDfs(grid1, grid2, i, j);
//                    if (ans == 1) amount++;
//                }
//            }
//        }
//
//
//        return amount;
//    }
//    public void countSubIslandsDfs(int[][] grid, int[][] island, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || island[i][j] == 0) return;
//
//        if (grid[i][j] == 0) ans = 0;
//
//        grid[i][j] = 0;
//        island[i][j] = 0;
//
//        countSubIslandsDfs(grid, island, i+1, j);
//        countSubIslandsDfs(grid, island, i-1, j);
//        countSubIslandsDfs(grid, island, i, j+1);
//        countSubIslandsDfs(grid, island, i, j-1);
//
//    }






    // sorts it then adds all the numbers added to curr and every time we move one place we add curr to ans
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



    // calculates the number of ones connections from rows
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






    // detects how many parenthesis we need to make them correctly
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



















// makes a stack like datastructure, but it removes the most frequent type first
//    if there are multiple with the same amount of frequenter it acts as a normal stack
//    Map<Integer, Integer> map;
//    Map<Integer, Stack<Integer>> freq;
//    int maxFreq;
//    public FreqStack() {
//        map = new HashMap<>();
//        freq = new HashMap<>();
//        maxFreq = 0;
//    }
//
//    public void push(int val) {
//        int currFreq = map.getOrDefault(val, 0) + 1;
//        map.put(val, currFreq);
//        if (currFreq > maxFreq){
//            maxFreq = currFreq;
//        }
//        if (!freq.containsKey(currFreq)){
//            freq.put(currFreq, new Stack<>());
//        }
//        freq.get(currFreq).add(val);
//    }
//
//    public int pop() {
//        Stack<Integer> curr = freq.get(maxFreq);
//        int ans = curr.pop();
//        map.put(ans, map.get(ans)-1);
//        if (curr.isEmpty()){
//            maxFreq--;
//        }
//        return ans;
//    }





//    int max = 0;
//    int currmax;
//    public int findMaxFish(int[][] grid) {
//
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//
//                if (grid[i][j] != 0){
//                    currmax = 0;
//                    dfs(grid,i,j);
//                    if (currmax > max){
//                        max = currmax;
//                    }
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
//    public void dfs(int[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
//            return;
//        }
//
//        int temp = grid[i][j];
//        grid[i][j] = 0;
//
//        currmax += temp;
//
//
//        dfs(grid, i+1, j);
//        dfs(grid, i-1, j);
//        dfs(grid, i, j+1);
//        dfs(grid, i, j-1);
//
//    }








//    boolean ans = false;
//    public boolean containsCycle(char[][] grid) {
//
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//                if (grid[i][j] != '0'){
//                    containsCycle(grid, i, j, i,j, 0, grid[i][j]);
//                }
//            }
//        }
//
//        return ans;
//    }
//
//    public void containsCycle(char[][] grid, int i, int j, int iStart, int jStart, int stepsSinceStart, char currChar) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != currChar) return;
//
//
//        char temp = grid[i][j];
//        grid[i][j] = '0';
//        if (stepsSinceStart > 1){
//            if (i == iStart-1 && j == jStart || i == iStart+1 && j == jStart || i == iStart && j == jStart-1 || i == iStart && j == jStart+1){
//                ans = true;
//                return;
//            }
//        }
//
//        containsCycle(grid, i+1, j, iStart, jStart, stepsSinceStart+1, currChar);
//        containsCycle(grid, i-1, j, iStart, jStart, stepsSinceStart+1, currChar);
//        containsCycle(grid, i, j+1, iStart, jStart, stepsSinceStart+1, currChar);
//        containsCycle(grid, i, j-1, iStart, jStart, stepsSinceStart+1, currChar);
//        grid[i][j] = temp;
//    }









    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }









//    List<String> ans = new ArrayList<>();
//    HashMap<Character, char[]> phoneMap = new HashMap<>();
//
//    String pDigits;
//    public List<String> letterCombinations(String digits) {
//        if (digits.length() == 0) return ans;
//        phoneMap.put('2',new char[]{'a','b','c'});
//        phoneMap.put('3',new char[]{'d','e','f'});
//        phoneMap.put('4',new char[]{'g','h','i'});
//        phoneMap.put('5',new char[]{'j','k','l'});
//        phoneMap.put('6',new char[]{'m','n','o'});
//        phoneMap.put('7',new char[]{'p','q','r','s'});
//        phoneMap.put('8',new char[]{'t','u','v'});
//        phoneMap.put('9',new char[]{'w','x','y','z'});
//        pDigits = digits;
//        letterCombinationsBackTrack(0, new StringBuilder());
//
//        return ans;
//    }
//    public void letterCombinationsBackTrack(int index, StringBuilder com) {
//        if (com.length() == pDigits.length()){
//            ans.add(com.toString());
//            return;
//        }
//
//
//        char[] numbersToAdd = phoneMap.get(pDigits.charAt(index));
//        for (int i = 0; i < numbersToAdd.length; i++){
//            com.append(numbersToAdd[i]);
//            letterCombinationsBackTrack(index + 1, com);
//            com.setLength(com.length()-1);
//        }
//
//    }





    // 118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1){
            return ans;
        }
        ans.add(new ArrayList<>(Arrays.asList(1,1)));
        if (numRows == 2){
            return ans;
        }


        for (int i = 0; i < numRows-2; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            var prevList = ans.get(ans.size()-1);
            for (int j = 1; j < prevList.size(); j++){
                row.add(prevList.get(j-1) + prevList.get(j));
            }
            row.add(1);

            ans.add(row);
        }
        return ans;
    }







    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr;
        ListNode next;

        while (length >= k){

            curr = prev.next;
            next = curr.next;

            for (int i = 1; i < k; i++){

                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            length -= k;


        }
        return dummy.next;
    }













//    int max = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//
//        diameterOfBinaryTreeHelper(root);
//        return max-1;
//    }
//    public int diameterOfBinaryTreeHelper(TreeNode root) {
//        if (root == null)
//            return 0;
//
//
//        int left = diameterOfBinaryTreeHelper(root.left);
//        int right = diameterOfBinaryTreeHelper(root.right);
//
//        max = Math.max(max, left + right + 1);
//
//        return Math.max(left, right) + 1;
//    }











    public void setZeroes(int[][] matrix) {

        boolean firstrow = false;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){

                    matrix[0][j] = 0;

                    if (i > 0){
                        matrix[i][0] = 0;
                    }
                    else {
                        firstrow = true;
                    }
                }
            }
        }



        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }


        if (matrix[0][0] == 0){
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if (firstrow){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

    }














    public int longestValidParentheses(String s) {

        int max = 0;

        int left = 0;
        int right = 0;

        int index = 0;

        while (index < s.length()){
            if (s.charAt(index) == '('){
                left++;
            }
            else {
                right++;
            }

            if (left == right){
                max = Math.max(max, left + right);
            }
            else if (left < right){
                left = 0;
                right = 0;
            }

            index++;
        }
        index = s.length()-1;

        left = 0;
        right = 0;

        while (index >= 0){

            if (s.charAt(index) == ')'){
                right++;
            }
            else {
                left++;
            }

            if (left == right){
                max = Math.max(max, left + right);
            }
            else if (left > right){
                left = 0;
                right = 0;
            }

            index--;
        }

        return max;
    }

















    public int minOperations(int[] nums) {

        Arrays.sort(nums);
        int unique = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }

        int ans = nums.length;
        for (int i = 0, j = 0; i < unique; i++) {
            while (j < unique && nums[j] - nums[i] <= nums.length - 1) {
                j++;
            }
            ans = Math.min(ans, nums.length - (j - i));
        }

        return ans;

    }












    public int subarraySum(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++){

            sum += nums[i];

            if (map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        permute(nums, new ArrayList<>(), list);
        return list;
    }
    public void permute(int[] nums, List<Integer> list, List<List<Integer>> ans) {

        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        else {
            for (int i = 0; i < nums.length; i++){
                if (list.contains(nums[i]))
                    continue;

                list.add(nums[i]);
                permute(nums, list, ans);
                list.remove(list.size()-1);
            }
        }

    }








    public List<Integer> partitionLabels(String s) {

        List<Integer> list = new ArrayList<>();
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++){

            int firstInstance = s.indexOf(s.charAt(i));
            int lastInstance = s.lastIndexOf(s.charAt(i));
            if (lastInstance <= max) continue;
            min = Math.min(min, firstInstance);

            if (firstInstance > max) {
                list.add((max - min) + 1);

                min = firstInstance;
            }
            max = lastInstance;

        }
        list.add((max - min) + 1);
        return list;
    }











//    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//
//        int[] peopleOg = Arrays.copyOf(people, people.length);
//        Arrays.sort(people);
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Integer> minHeapBegin = new PriorityQueue<>();
//        PriorityQueue<Integer> minHeapEnd = new PriorityQueue<>();
//
//        for (int[] i : flowers){
//            minHeapBegin.add(i[0]);
//            minHeapEnd.add(i[1]);
//        }
//
//
//
//        int count = 0;
//
//        for (int i = 0; i < people.length; i++){
//            while (!minHeapBegin.isEmpty() && minHeapBegin.peek() <= people[i]){
//                System.out.println(minHeapBegin.poll());
//                count++;
//            }
//
//            while (!minHeapEnd.isEmpty() && minHeapEnd.peek() < people[i]){
//                minHeapEnd.poll();
//                count--;
//            }
//            map.put(people[i], count);
//        }
//        int[] ans = new int[people.length];
//
//
//        for (int i = 0; i < peopleOg.length; i++){
//            ans[i] = map.get(peopleOg[i]);
//        }
//
//        return ans;
//    }
//
//
//
//
//
//
//
//
//
//    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        int[] people1 = Arrays.copyOf(people, people.length);
//        Arrays.sort(people1);
//
//        Arrays.sort(flowers, Comparator.comparingDouble(a -> a[0]));
//
//        int j = 0;
//        for(int p : people1){
//            while(j < flowers.length && p >= flowers[j][0]){
//                minHeap.add(flowers[j][1]);
//                j++;
//            }
//
//            while(!minHeap.isEmpty() && minHeap.peek() < p) minHeap.poll();
//
//            map.put(p, minHeap.size());
//        }
//
//        for(int i = 0; i < people.length; i++){
//            int n = map.get(people[i]);
//            people[i] = n;
//        }
//
//        return people;
//    }















    int amountOfSums = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);

        return amountOfSums;
    }
    public void dfs(TreeNode root, int target) {
        if (root == null)
            return;

        count(root, target, 0);

        dfs(root.left, target);
        dfs(root.right, target);
    }

    public void count(TreeNode root, int target, long currSum) {
        if (root == null){
            return;
        }
        currSum += root.val;
        if (currSum == target){
            amountOfSums++;
        }
        count(root.left, target, currSum);
        count(root.right, target, currSum);
    }










// implements a LinkedList to remove last used key.
//    LinkedHashMap<Integer, Integer> map;
//    int capacity;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return size() > LRUCache.this.capacity;
//            }
//        };
//    }
//    public int get(int key) {
//        return map.getOrDefault(key, -1);
//    }
//    public void put(int key, int value) {
//        map.put(key, value);
//    }





//    interface MountainArray { public int get(int index) {}public int length() {}}
//
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int left = 0;
//        int right = mountainArr.length() - 1;
//        int peakIndex = -1;
//
//        while (left < right) {
//            int mid = (left + right) / 2;
//            int midValue = mountainArr.get(mid);
//            int midValuePlus = (mid + 1 < mountainArr.length()) ? mountainArr.get(mid + 1) : Integer.MAX_VALUE;
//
//            if (midValue < midValuePlus) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//
//        peakIndex = left;
//
//        left = 0;
//        right = peakIndex;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int midValue = mountainArr.get(mid);
//
//            if (midValue == target) {
//                return mid;
//            } else if (midValue > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        left = peakIndex;
//        right = mountainArr.length() - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int midValue = mountainArr.get(mid);
//
//            if (midValue == target) {
//                return mid;
//            } else if (midValue > target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;
//    }




    public int minCostClimbingStairs(int[] cost) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 2; i <= cost.length; i++){

            int currentMin = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);

            prev2 = prev1;
            prev1 = currentMin;


        }
        return prev1;
    }








    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                updateVal(board, i , j);
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }


    }
    private void updateVal(int[][] board, int i, int j) {


        int[][] neigbours =  {{1,0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        int amountOfNeighbours = 0;

        for (int index = 0; index < neigbours.length; index++){
            amountOfNeighbours += checkNeighbour(board, i + neigbours[index][0],j + neigbours[index][1]);
        }


        if (board[i][j] == 1 && amountOfNeighbours < 2 || board[i][j] == 1 && amountOfNeighbours > 3){
            board[i][j] = 2;
        }
        else if (board[i][j] == 0 && amountOfNeighbours == 3){
            board[i][j] = 3;
        }


    }

    private int checkNeighbour(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return 0;

        return board[i][j] == 1 || board[i][j] == 2 ? 1 : 0;
    }















    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backTrackPalidrone(s,0, curr, ans);

        return ans;
    }

    private void backTrackPalidrone(String s, int index, List<String> list, List<List<String>> ans) {

        if (index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                backTrackPalidrone(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }








    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        int first = intervals[0][0];
        int maxRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){


            if (maxRight < intervals[i][0]){
                list.add(new int[] {first, maxRight});
                first = intervals[i][0];
                maxRight = intervals[i][1];
            }
            else{
                maxRight = Math.max(maxRight, intervals[i][1]);
            }
        }
        if (list.size() == 0 || list.get(list.size()-1)[0] != first || list.get(list.size()-1)[1] != maxRight){
            list.add(new int[] {first, maxRight});
        }


        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
























    public int findMinArrowShots(int[][] points) {
        if (points.length == 1)
            return 1;

        Arrays.sort(points, (a, b) -> Long.compare(a[0], b[0]));
        int amountOfArrows = 0;

        long right = points[0][1];
        for (int i = 1; i < points.length; i++){

            if (points[i][0] > right) {
                amountOfArrows++;
                right = points[i][1];
            } else {
                right = Math.min(right, points[i][1]);
            }

            if (i == points.length-1){
                amountOfArrows++;
            }
        }

        return amountOfArrows;
    }
















    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] intervalNew = new int[intervals.length+1][2];

        for (int i = 0; i < intervals.length; i++){
            intervalNew[i] = intervals[i];
        }
        intervalNew[intervalNew.length-1] = newInterval;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervalNew, (a, b) -> a[0] - b[0]);


        int first = intervalNew[0][0];
        int maxRight = intervalNew[0][1];
        for (int i = 1; i < intervalNew.length; i++){


            if (maxRight < intervalNew[i][0]){
                list.add(new int[] {first, maxRight});
                first = intervalNew[i][0];
                maxRight = intervalNew[i][1];
            }
            else{
                maxRight = Math.max(maxRight, intervalNew[i][1]);
            }
        }
        if (list.size() == 0 || list.get(list.size()-1)[0] != first || list.get(list.size()-1)[1] != maxRight){
            list.add(new int[] {first, maxRight});
        }


        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }




















//    public String decodeString(String s) {
//
//        Stack<String> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++){
//
//            if (!String.valueOf(s.charAt(i)).equals("]")){
//                stack.add(String.valueOf(s.charAt(i)));
//            }
//            else {
//
//                StringBuilder stringBuilder = new StringBuilder();
//
//               while (!stack.peek().equals("[")){
//                   stringBuilder.insert(0, stack.pop());
//               }
//               stack.pop();
//
//
//               StringBuilder nr = new StringBuilder();
//
//               while (!stack.isEmpty() && Character.isDigit(Integer.parseInt(stack.peek()))){
//
//                   nr.insert(0, stack.pop());
//               }
//
//               int number = Integer.parseInt(nr.toString());
//
//               for (int j = 0; j < number; j++){
//                   stack.add(nr.toString());
//               }
//
//            }
//
//
//        }
//
//        return stack.toString();
//    }








    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode beginning = new ListNode();
        beginning.next = head;

        ListNode dummy = beginning;

        ListNode prev = beginning;
        ListNode curr = head;
        ListNode nxt = curr.next;

        while (curr != null && curr.val < x){
            beginning = curr;
            prev = curr;
            curr = nxt;
            if (nxt != null){
                nxt = nxt.next;
            }
        }


        while (curr != null){

            if (curr.val < x){
                curr.next = beginning.next;
                prev.next = nxt;
                beginning.next = curr;
                beginning = beginning.next;

                curr = nxt;
                if (nxt != null){
                    nxt = nxt.next;
                }
            }
            else {

                prev = curr;
                curr = nxt;
                if (nxt != null){
                    nxt = nxt.next;
                }
            }
        }


        return dummy.next;
    }














    //77. Combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(n, k, 1, list, ans);

        return ans;
    }

    public void backTrack(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {

        if (list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        if (start > n)
            return;


        for (int i = start; i<= n; i++){
            list.add(i);
            backTrack(n, k, i+1, list, ans);
            list.remove(list.size()-1);

        }

    }









    public void nextPermutation(int[] nums) {

        int index = -1;
        for (int i = nums.length-1; i > 0; i--){

            if (nums[i] > nums[i-1]){
                index = i-1;
                break;
            }
        }

        if (index == -1){
            reverseArray(nums, 0, nums.length-1);
            return;
        }
        else {

            for (int i = nums.length-1; i >= 0; i--){
                if (nums[i] > nums[index]){
                    swap(nums, i, index);
                    break;
                }
            }
            reverseArray(nums, index+1, nums.length-1);
        }
    }

    private void reverseArray(int[] nums, int i, int j) {
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }














    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left < right){

            int mid = (left + right) / 2;

            int next = mid + 1 >= arr.length ? Integer.MIN_VALUE : arr[mid + 1];

            if (arr[mid] > next){
                right = mid;
            }
            else {
                left = mid+1;
            }


        }

        return left;
    }




















    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while (true){
            List<Integer> list = new ArrayList<>();
            for (int nr : map.keySet()){
                int count = map.get(nr);
                if (count < 1) {
                    continue;
                }
                list.add(nr);
                map.put(nr, count-1);
            }
            if (list.size() == 0){
                break;
            }
            ans.add(list);

        }
        return ans;
    }



// gets the given row of pascals triangle
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long ans = 1;

        for(int i = 0;i<=rowIndex;i++){
            row.add((int)ans);
            ans = ans * (rowIndex-i);
            ans = ans / (i+1);
        }

        return row;
    }



// reorders list into the odd ones first then the even numbered node's
    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode();
        ListNode oddHead = odd;
        ListNode even = new ListNode();
        ListNode evenHead = even;

        int index = 1;

        while (head != null){

            if (index % 2 == 0){
                even.next = head;
                even = even.next;
            }
            else {
                odd.next = head;
                odd = odd.next;
            }

            index++;
            head = head.next;
        }
        odd.next = evenHead.next;
        even.next = null;




        return oddHead.next;
    }





//1372. Longest ZigZag Path in a Binary Tree
//    int ans = 0;
//    public int longestZigZag(TreeNode root) {
//
//        dfs(root.left, false, 0);
//        dfs(root.right, true, 0);
//
//        return ans;
//    }
//    public void dfs(TreeNode root, boolean fromLeft, int currZigZag) {
//        if (currZigZag > ans){
//            ans = currZigZag;
//        }
//        if (root == null) {
//            return;
//        }
//
//        if (fromLeft){
//            dfs(root.left, false, currZigZag + 1);
//            dfs(root.right, true, 0);
//        }
//        else {
//            dfs(root.right, true, currZigZag+1);
//            dfs(root.left, false, 0);
//        }
//
//    }



    public boolean checkTree(int root, int[] leftChild, int[] rightChild) {


        boolean[] visited = new boolean[leftChild.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;


        while (!queue.isEmpty()){

            int curr = queue.poll();

            if (leftChild[curr] != -1){
                if (visited[leftChild[curr]])
                    return false;
                visited[leftChild[curr]] = true;
                queue.offer(leftChild[curr]);
            }

            if (rightChild[curr] != -1){
                if (visited[rightChild[curr]])
                    return false;
                visited[rightChild[curr]] = true;
                queue.offer(rightChild[curr]);
            }

        }

        for (int i = 0; i < visited.length; i++){
            if (!visited[i])
                return false;
        }


        return true;
    }



    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] children = new boolean[n];

        for (int child : leftChild) {
            if (child != -1)
                children[child] = true;
        }

        for (int child : rightChild) {
            if (child != -1) {
                if (children[child])
                    return false;

                children[child] = true;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!children[i]) {
                if (root == -1){
                    root = i;
                }
                else {
                    return false;
                }
            }
        }

        if (root == -1)
            return false;

        return checkTree(root, leftChild, rightChild);
    }






    //1367. Linked List in Binary Tree
//    looks if there is a linked list in a binary tree
//    boolean ans = false;
//    public boolean isSubPath(ListNode head, TreeNode root) {
//        if (head == null)
//            return true;
//        isSubPathDfs(head, root);
//
//        return ans;
//    }
//    public void isSubPathDfs(ListNode head, TreeNode root) {
//        if (ans || root == null){
//            return;
//        }
//
//        if (root.val == head.val){
//            boolean matches = checkMatch(head, root);
//            if (matches)
//                ans = true;
//        }
//        isSubPathDfs(head, root.left);
//        isSubPathDfs(head, root.right);
//    }
//
//    public boolean checkMatch(ListNode head, TreeNode node) {
//        if (head == null)
//            return true;
//        if (node == null)
//            return false;
//
//        if (head.val != node.val)
//            return false;
//
//        return checkMatch(head.next, node.left) || checkMatch(head.next, node.right);
//
//    }













// reorders a linked list by taking the first element then the last then the second then the first to last and repeat
    public void reorderList(ListNode head) {


        int size = 0;

        ListNode curr = head;

        while (curr != null){
            size++;
            curr = curr.next;
        }
        if (size == 0 || size == 1)
            return;


        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();

        curr = head;
        int index = 0;
        while (curr != null){

            if (index < size/2){
                queue.offer(curr);
            }
            else {
                stack.add(curr);
            }
            index++;
            curr = curr.next;
        }
        queue.poll();
        boolean fromEnd = true;
        while (!stack.isEmpty() || !queue.isEmpty()){

            if (fromEnd){
                if (!stack.isEmpty()){
                    head.next = stack.pop();
                    head = head.next;
                }
                fromEnd = false;
            }
            else {
                if (!queue.isEmpty()){
                    head.next = queue.poll();
                    head = head.next;
                }
                fromEnd = true;
            }
        }
    }










    public class TrieNode{

        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }
    }

//    TrieNode root;
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        int index = 0;
//
//        TrieNode curr = root;
//
//        while (index < word.length()){
//
//            if (!curr.children.containsKey(word.charAt(index))){
//                curr.children.put(word.charAt(index), new TrieNode());
//            }
//
//            curr = curr.children.get(word.charAt(index));
//            if (index == word.length()-1){
//                curr.isWord = true;
//            }
//            index++;
//        }
//    }
//// search in a trie tree
//    public boolean search(String word) {
//        int index = 0;
//        TrieNode curr = root;
//
//        while (index < word.length()){
//
//            if (!curr.children.containsKey(word.charAt(index))){
//                return false;
//            }
//            curr = curr.children.get(word.charAt(index));
//            index++;
//        }
//        return curr.isWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        int index = 0;
//        TrieNode curr = root;
//
//        while (index < prefix.length()){
//
//            if (!curr.children.containsKey(prefix.charAt(index))){
//                return false;
//            }
//            curr = curr.children.get(prefix.charAt(index));
//            index++;
//        }
//        return true;
//    }






//844. Backspace String Compare
//    compares the two strings if they are the same with the backspaces = '#'
    public boolean backspaceCompare(String s, String t) {
        StringBuilder stringBuilderS = new StringBuilder();
        StringBuilder stringBuilderT = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '#'){
                if (stringBuilderS.length() > 0){
                    stringBuilderS.setLength(stringBuilderS.length()-1);
                }
            }
            else {
                stringBuilderS.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == '#'){
                if (stringBuilderT.length() > 0) {
                    stringBuilderT.setLength(stringBuilderT.length()-1);
                }
            }
            else {
                stringBuilderT.append(t.charAt(i));
            }
        }


        return stringBuilderS.toString().equals(stringBuilderT.toString());
    }







//747. Largest Number At Least Twice of Others
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] > max){
                max2 = max;
                max = nums[i];
                index = i;
            }
            else if (nums[i] > max2){
                max2 = nums[i];
            }
        }

        return max2*2 <= max ? index : -1;
    }









// implements a queue where you can add/pop from the front middle and back
//    List<Integer> list;
//    public FrontMiddleBackQueue() {
//        list = new ArrayList<>();
//    }
//
//    public void pushFront(int val) {
//        list.add(0,val);
//    }
//
//    public void pushMiddle(int val) {
//        list.add(list.size()/2, val);
//    }
//
//    public void pushBack(int val) {
//        list.add(val);
//    }
//
//    public int popFront() {
//        if (list.size() == 0)
//            return -1;
//
//        int ans = list.get(0);
//        list.remove(0);
//        return ans;
//    }
//
//    public int popMiddle() {
//        if (list.size() == 0)
//            return -1;
//
//        int ans = list.get((list.size()-1)/2);
//        list.remove((list.size()-1)/2);
//        return ans;
//    }
//
//    public int popBack() {
//        if (list.size() == 0)
//            return -1;
//
//        int ans = list.get(list.size()-1);
//        list.remove(list.size()-1);
//        return ans;
//    }















    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        int index = 0;

        for (int i = 0; i < nums.length; i++){
            ans[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            ans[index++] = nums[i];
        }
        return ans;
    }




// a complete tree is a tree where every node is added from left to right so the max lvl distance is 1
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean foundNull = false;
        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++){

                TreeNode curr = queue.poll();
                if (curr.left == null){
                    foundNull = true;
                }
                else if (foundNull){
                    return false;
                }
                if (curr.right == null){
                    foundNull = true;
                }
                else if (foundNull){
                    return false;
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }


        }
        return true;
    }










//1222. Queens That Can Attack the King
//    2d matrix of all the quens on the board
//    and a king
//    it finds all of the queens that can attack the king at that moment
public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    int[][] board = new int[8][8];

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < queens.length; i++){
        int row = queens[i][0];
        int col = queens[i][1];
        board[row][col] = 1;

    }

    for (int i = king[0]; i < board.length; i++){
        if (board[i][king[1]] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,king[1])));
            break;
        }
    }
    for (int i = king[0]; i >= 0; i--){
        if (board[i][king[1]] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,king[1])));
            break;
        }
    }
    for (int j = king[1]; j < board[0].length; j++){
        if (board[king[0]][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(king[0],j)));
            break;
        }
    }
    for (int j = king[1]; j >= 0; j--){
        if (board[king[0]][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(king[0],j)));
            break;
        }
    }
    for (int i = king[0], j = king[1]; i < board.length && j < board[0].length; i++){

        if (board[i][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,j)));
            break;
        }
        j++;
    }
    for (int i = king[0], j = king[1]; i < board.length && j >= 0; i++){

        if (board[i][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,j)));
            break;
        }
        j--;
    }
    for (int i = king[0], j = king[1]; i >= 0 && j < board[0].length; i--){
        if (board[i][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,j)));
            break;
        }
        j++;
    }
    for (int i = king[0], j = king[1]; i >= 0 && j >= 0; i--){
        if (board[i][j] == 1){
            ans.add(new ArrayList<>(Arrays.asList(i,j)));
            break;
        }
        j--;
    }

    return ans;
}




//1920. Build Array from Permutation
    public int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            ans[i] = nums[nums[i]];
        }

        return ans;
    }





    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }




//1476. Subrectangle Queries
    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        for (int i = row1; i <= row2; i++){
            for (int j = col1; j <= col2; j++){
                rectangle[i][j] = newValue;
            }
        }

    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }








//1472. Design Browser History
//    Stack<String> prev;
//    Stack<String> next;
//    String curr;
//
//    public BrowserHistory(String homepage) {
//        curr = homepage;
//        prev = new Stack<>();
//        next = new Stack<>();
//    }
//
//    public void visit(String url) {
//        prev.add(curr);
//        curr = url;
//        next = new Stack<>();
//    }
//
//    public String back(int steps) {
//        while (steps > 0 && !prev.isEmpty()){
//            next.add(curr);
//            curr = prev.pop();
//            steps--;
//        }
//        return curr;
//    }
//
//    public String forward(int steps) {
//        while (steps > 0 && !next.isEmpty()){
//            prev.add(curr);
//            curr = next.pop();
//            steps--;
//        }
//        return curr;
//    }









//    PriorityQueue<Integer> minHeap;
//    int current;
//
//    public SeatManager(int n) {
//        minHeap = new PriorityQueue<>((a,b) -> a-b);
//        current = 1;
//    }
//
//    public int reserve() {
//        if (!minHeap.isEmpty()){
//            return minHeap.poll();
//        }
//        return current++;
//    }
//
//    public void unreserve(int seatNumber) {
//        minHeap.add(seatNumber);
//    }




//641. Design Circular Deque
//    Deque<Integer> deque;
//    int max;
//    public MyCircularDeque(int k) {
//        deque = new LinkedList<>();
//        max = k;
//
//    }
//
//    public boolean insertFront(int value) {
//        if (deque.size() < max){
//            deque.addFirst(value);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean insertLast(int value) {
//        if (deque.size() < max){
//            deque.addLast(value);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deleteFront() {
//        if (deque.size() > 0){
//            deque.pollFirst();
//            return true;
//        }
//        return false;
//    }
//
//    public boolean deleteLast() {
//        if (deque.size() > 0){
//            deque.pollLast();
//            return true;
//        }
//        return false;
//    }
//
//    public int getFront() {
//        if (deque.size() > 0){
//            return deque.getFirst();
//        }
//        return -1;
//    }
//
//    public int getRear() {
//        if (deque.size() > 0){
//            return deque.getLast();
//        }
//        return -1;
//    }
//
//    public boolean isEmpty() {
//        return deque.isEmpty();
//    }
//
//    public boolean isFull() {
//        return deque.size() == max;
//    }



















//707. Design Linked List
//    ListNode head;
//
//    public MyLinkedList() {
//
//    }
//
//    public int get(int index) {
//
//        ListNode curr = head;
//        while (index > 0 && curr != null){
//            curr = curr.next;
//            index--;
//        }
//        return curr == null || index != 0 ? -1 : curr.val;
//    }
//
//    public void addAtHead(int val) {
//        ListNode newHead = new ListNode(val);
//        newHead.next = head;
//        head = newHead;
//    }
//
//    public void addAtTail(int val) {
//        if (head == null){
//            head = new ListNode(val);
//            return;
//        }
//        ListNode curr = head;
//        while (curr.next != null){
//            curr = curr.next;
//        }
//        curr.next = new ListNode(val);
//    }
//
//    public void addAtIndex(int index, int val) {
//        if (index == 0){
//            addAtHead(val);
//            return;
//        }
//
//        ListNode prev = new ListNode();
//        ListNode curr = head;
//
//        while (index > 0 && curr != null){
//
//            prev = curr;
//            curr = curr.next;
//            index--;
//        }
//        if (index == 0){
//            prev.next = new ListNode(val);
//            prev.next.next = curr;
//        }
//
//    }
//
//    public void deleteAtIndex(int index) {
//
//        if (index == 0){
//            head = head == null ? head : head.next;
//            return;
//        }
//
//        ListNode prev = new ListNode();
//        ListNode curr = head;
//
//        while (index > 0 && curr != null && curr.next != null){
//
//            prev = curr;
//            curr = curr.next;
//            index--;
//        }
//        if (index == 0){
//            prev.next = curr.next;
//        }
//    }

















//2296. Design a Text Editor
//    StringBuilder file;
//    int currPosition;
//    public TextEditor() {
//        file = new StringBuilder();
//        currPosition = 0;
//    }
//    public void addText(String text) {
//        file.insert(currPosition, text);
//        currPosition += text.length();
//
//    }
//
//    //leet|
//    public int deleteText(int k) {
//        int startIndex = Math.max(0, currPosition-k);
//        int endIndex = currPosition;
//
//        file.delete(startIndex, endIndex);
//
//        currPosition = startIndex;
//        return endIndex-startIndex;
//    }
//
//    public String cursorLeft(int k) {
//        if (currPosition - k <= 0){
//            currPosition = 0;
//            return "";
//        }
//        currPosition -= k;
//        int min = Math.min(10, currPosition);
//
//        return file.substring(currPosition - min, currPosition);
//    }
//
//    public String cursorRight(int k) {
//        if (currPosition + k >= file.length()){
//            currPosition = file.length();
//        }
//        else {
//            currPosition += k;
//        }
//
//        int min = Math.min(10, currPosition);
//        return file.substring(currPosition-min, currPosition);
//    }















//1282. Group the People Given the Group Size They Belong To
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++){


            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            if (list.size() == groupSizes[i]){
                ans.add(list);
                map.remove(groupSizes[i]);
            }

        }

        return ans;
    }


//1329. Sort the Matrix Diagonally
    public int[][] diagonalSort(int[][] mat) {

        for (int i = 0; i < mat.length; i++){

            int index = i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < mat[0].length && index < mat.length; j++){

                list.add(mat[index++][j]);

            }

            Collections.sort(list);

            index = i;
            for (int j = 0; j < mat[0].length && j < list.size(); j++){
                mat[index][j] = list.get(j);
                index++;
            }

        }

        for (int i = 1; i < mat[0].length; i++){


            int index = i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < mat.length && index < mat[0].length; j++){

                list.add(mat[j][index++]);

            }

            Collections.sort(list);

            index = i;
            for (int j = 0; j < mat.length && j < list.size(); j++){
                mat[j][index] = list.get(j);
                index++;
            }

        }



        return mat;
    }











//2482. Difference Between Ones and Zeros in Row and Column
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowDiff = new int[grid.length];
        int[] colDiff = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                rowDiff[i] += 1-(2*grid[i][j]);
                colDiff[j] += 1-(2*grid[i][j]);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = -rowDiff[i] + -colDiff[j];
            }
        }

        return grid;
    }



//1910. Remove All Occurrences of a Substring
    public String removeOccurrences(String s, String part) {
        String old = s;
        String newS = s.replaceFirst(part, "");
        while (!old.equals(newS)){
            old = newS;
            newS = newS.replaceFirst(part, "");
        }

        return newS;
    }




















//807. Max Increase to Keep City Skyline
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxCol = new int[grid.length];
        int[] maxRow = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++){
            int currMax = 0;
            for (int j = 0; j < grid[0].length; j++){
                currMax = Math.max(currMax, grid[i][j]);
            }
            maxCol[i] = currMax;
        }
        for (int i = 0; i < grid[0].length; i++){
            int currMax = 0;
            for (int j = 0; j < grid.length; j++){
                currMax = Math.max(currMax, grid[j][i]);
            }
            maxRow[i] = currMax;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return ans;
    }
















//1091. Shortest Path in Binary Matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        if (grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});

        int steps = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++){

                int[] coords = queue.poll();

                if (coords[0] == grid.length-1 && coords[1] == grid[0].length-1){
                    return steps;
                }

                for (int[] dir : dirs) {
                    int x = coords[0] + dir[0];
                    int y = coords[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0){
                        queue.offer(new int[] {x, y});
                        grid[x][y] = 1;
                    }

                }
            }

        }

        return -1;
    }





//2149. Rearrange Array Elements by Sign
    public int[] rearrangeArray(int[] nums) {
        int[] neg = new int[nums.length/2];
        int[] pos = new int[nums.length/2];
        int indexNeg = 0;
        int indexPos = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                neg[indexNeg++] = nums[i];
            }
            else {
                pos[indexPos++] = nums[i];
            }
        }
        boolean needPos = true;
        indexNeg = 0;
        indexPos = 0;
        for (int i = 0; i < nums.length; i++){
            if (needPos){
                nums[i] = pos[indexPos++];
                needPos = false;
            }
            else {
                nums[i] = neg[indexNeg++];
                needPos = true;
            }
        }
        return nums;
    }













//1523. Count Odd Numbers in an Interval Range
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0){
            return (int) Math.ceil(0 +(high-low) / 2);
        }
        return (int) Math.ceil(1+ (high-low) / 2);
    }











//1887. Reduction Operations to Make the Array Elements Equal
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int currMax = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = nums.length-1; i >= 0; i--){
            if (nums[i] < currMax){
                ans += (nums.length-1) - i;
                currMax = nums[i];
            }
        }
        return ans;
    }


//getMaxLenbacktracking brute force
    int maxSize = 0;
    public int getMaxLen(int[] nums) {
        int[] visited = new int[nums.length];
        getMaxLenbacktracking(nums, 1l, 0, 1, visited);
        return maxSize;
    }

    public void getMaxLenbacktracking(int[] nums, Long product, int index, int size, int[] visited) {
        if (index >= nums.length)
            return;

        if (visited[index] == size){
            return;
        }
        visited[index] = size;

        product *= nums[index];

        if (product > 0 && size > maxSize){
            maxSize = size;
        }

        getMaxLenbacktracking(nums, product, index+1, size+1, visited);
        getMaxLenbacktracking(nums, 1l, index+1, 1, visited);

    }












//1535. Find the Winner of an Array Game
    public int getWinner(int[] arr, int k) {
        int currNr = arr[0];
        int currStreak = 0;
        for (int i = 0; i < arr.length-1; i++){
            if (currNr > arr[i+1]){
                currStreak++;
            }
            else {
                currNr = arr[i+1];
                currStreak = 1;
            }
            if (currStreak >= k){
                return currNr;
            }
        }
        return currNr;
    }

























//1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int max = 0;
        int currHeight = 0;

        for (int i = 0; i < gain.length; i++){

            currHeight += gain[i];
            max = Math.max(max, currHeight);

        }

        return max;
    }












    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < pref.length; i++){
            ans[i] = pref[i] ^ pref[i-1];
        }

        return ans;
    }


//501. Find Mode in Binary Search Tree
//    List<Integer> mostSeen;
//    int most = 0;
//    int prev = -1;
//    int count = 0;
//    public int[] findMode(TreeNode root) {
//        mostSeen = new ArrayList<>();
//
//        findModeHelper(root);
//
//        int[] ans = new int[mostSeen.size()];
//        for (int i = 0; i < mostSeen.size(); i++){
//            ans[i] = mostSeen.get(i);
//        }
//        return ans;
//    }
//
//    private void findModeHelper(TreeNode node) {
//        if (node == null)
//            return;
//
//        findModeHelper(node.left);
//        if (prev == -1){
//            prev = node.val;
//            count = 1;
//        }
//        else if (prev != node.val){
//            count = 1;
//            prev = node.val;
//        }
//        else {
//            count++;
//        }
//
//        if (count > most){
//            mostSeen = new ArrayList<>();
//            mostSeen.add(node.val);
//            most = count;
//        }
//        else if (count == most){
//            mostSeen.add(node.val);
//        }
//        findModeHelper(node.right);
//    }




//993. Cousins in Binary Tree
    int parentX;
    int deptX;
    int parentY;
    int deptY;
    public boolean isCousins(TreeNode root, int x, int y) {

        isCousinsHelper(root, x, y, 0, 0);

        if (deptX == deptY && parentX != parentY){
            return true;
        }
        return false;
    }


    public void isCousinsHelper(TreeNode root, int x, int y, int parentVal, int dept) {
        if (root == null)
            return;

        isCousinsHelper(root.left, x, y, root.val, dept+1);

        if (root.val == x){
            deptX = dept;
            parentX = parentVal;
        }
        else if (root.val == y){
            deptY = dept;
            parentY = parentVal;
        }

        isCousinsHelper(root.right, x, y, root.val, dept+1);

    }








//563. Binary Tree Tilt
    int total = 0;
    public int findTilt(TreeNode root) {
        findTiltHelper(root);

        return total;
    }

    public int findTiltHelper(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);

        total += Math.abs(left - right);

        return left + right + root.val;
    }





    //2139. Minimum Moves to Reach Target Score
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (target > 1 && maxDoubles > 0){
            if (target % 2 == 0){
                target /= 2;
                maxDoubles--;
            }
            else {
                target--;
            }
            moves++;
        }
        return target == 1 ? moves : moves + target-1;
    }




//1162. As Far from Land as Possible brute force
//    int max;
//    public int maxDistance(int[][] grid) {
//        max = Integer.MIN_VALUE;
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//                maxDistanceFinder(grid, i, j);
//            }
//        }
//        return max == 0 || max == Integer.MIN_VALUE ? -1 : max;
//    }
//    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
//    private void maxDistanceFinder(int[][] grid, int r, int c) {
//
//        boolean found = false;
//
//        int steps = 0;
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[] {r, c});
//
//        while (!queue.isEmpty()){
//
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++){
//
//                int[] curr = queue.poll();
//                int currRow = curr[0];
//                int currCol = curr[1];
//                if (visited[curr[0]][currCol]){
//                    continue;
//                }
//                visited[currRow][currCol] = true;
//                if (grid[currRow][currCol] == 1){
//                    max = Math.max(max, steps);
//                    found = true;
//                }
//                if (found)
//                    return;
//
//                for (int j = 0; j < dir.length; j++){
//
//                    int x = dir[j][0] + currRow;
//                    int y = dir[j][1] + currCol;
//
//                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
//                        queue.offer(new int[] {x, y});
//                    }
//                }
//            }
//            steps++;
//        }
//    }













//429. N-ary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            List<Integer> currList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){

                Node curr = queue.poll();
                currList.add(curr.val);

                for (Node node : curr.children){
                    queue.offer(node);
                }

            }

            list.add(currList);
        }
        return list;
    }









//2428. Maximum Sum of an Hourglass
    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length-2; i++){
            for (int j = 0; j < grid[0].length-2; j++){
                max = Math.max(max, hourglassSum(grid, i,j));
            }
        }

        return max;
    }

    private int hourglassSum(int[][] grid, int i, int j) {
        return grid[i][j] +
        grid[i][j+1] +
        grid[i][j+2] +
        grid[i+1][j+1] +
        grid[i+2][j+1] +
        grid[i+2][j+2] +
        grid[i+2][j];
    }



















//221. Maximal Square
//    int max = 0;
//    public int maximalSquare(char[][] matrix) {
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                if (matrix[i][j] == '1'){
//                    getMaxSquare(matrix, 1,1, i, j);
//                }
//            }
//        }
//        return max;
//    }
//
//    private void getMaxSquare(char[][] matrix, int currMax, int ofset, int i, int j) {
//
//        max = Math.max(max, currMax);
//        if (i+ofset >= matrix.length || j +ofset >= matrix[0].length) {
//            return;
//        }
//
//        int sum = 0;
//
//        for (int r = i; r <= i+ofset; r++){
//            if (matrix[r][j+ofset] != '1'){
//                return;
//            }
//            sum++;
//        }
//        for (int c = j; c <= j+ofset; c++){
//            if (matrix[i+ofset][c] != '1'){
//                return;
//            }
//            sum++;
//        }
//        sum--;
//        getMaxSquare(matrix, currMax+sum, ofset+1, i, j);
//    }












//1921. Eliminate Maximum Number of Monsters
    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] timeUntilArival = new double[dist.length];

        for (int i = 0; i < dist.length; i++){

            timeUntilArival[i] = (double) dist[i] / speed[i];

        }
        Arrays.sort(timeUntilArival);

        for (int i = 0; i < dist.length; i++){
            if (timeUntilArival[i] <= i){
                return i;
            }
        }
        return dist.length;
    }

//2849. Determine if a Cell Is Reachable at a Given Time
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy){
            return t != 1;
        }
        return Math.max(Math.abs(sx-fx), Math.abs(sy-fy)) <= t;
    }


//508. Most Frequent Subtree Sum
//    Map<Integer, Integer> map = new HashMap<>();
//    int maxFreq = 0;
//    public int[] findFrequentTreeSum(TreeNode root) {
//        getFrequentsy(root);
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int key : map.keySet()){
//            if (map.get(key) == maxFreq){
//                list.add(key);
//            }
//        }
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++){
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }
//
//    private int getFrequentsy(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int leftSum = getFrequentsy(root.left);
//        int rightSum = getFrequentsy(root.right);
//
//        int sum = root.val + leftSum + rightSum;
//        int count = map.getOrDefault(sum, 0) +1;
//        maxFreq = Math.max(maxFreq,count);
//        map.put(sum, count);
//        return sum;
//    }



//2536. Increment Submatrices by One
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for (int i = 0; i < queries.length; i++){
            int[] curr = queries[i];
            for (int r = curr[0]; r <= curr[2]; r++){
                for (int c = curr[1]; c <= curr[3]; c++){
                    ans[r][c]++;
                }
            }

        }

        return ans;
    }


//794. Valid Tic-Tac-Toe State <---------start--------->
    public boolean validTicTacToe(String[] board) {

        int o = 0;
        int x = 0;
        for (int i = 0; i < board.length; i++){
            for (char c : board[i].toCharArray()){
                if (c == 'O'){
                    o++;
                }
                else if (c == 'X'){
                    x++;
                }
            }
        }
        if (o > x || x > o+1){
            return false;
        }

        return !checkWins(board);
    }

    private boolean checkWins(String[] board) {
        boolean topWin = false;
        boolean botWin = false;
        int amountOfWins = 0;
        int n = board.length;
        for (int i = 0; i < n; i++){
            char input = board[i].charAt(0);
            if (input != ' ' && board[i].charAt(1) == input && board[i].charAt(2) == input){
                amountOfWins++;
            }
        }
        for (int i = 0; i < n; i++){
            char input = board[0].charAt(i);
            if (input != ' ' && board[1].charAt(i) == input && board[2].charAt(i) == input){
                amountOfWins++;
            }
        }

        if (board[0].charAt(0) != ' ' && board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2) ||
            board[2].charAt(0) != ' ' && board[2].charAt(0) == board[1].charAt(1) && board[2].charAt(0) == board[0].charAt(2)
        ){
            amountOfWins++;
        }
        System.out.println(amountOfWins);
        return amountOfWins > 1;
    }















//2556. Disconnect Path in a Binary Matrix by at Most One Flip
//    boolean found = false;
//    public boolean isPossibleToCutPath(int[][] grid) {
//        if (grid.length == 1 && grid[0].length <=2 || grid.length <= 2 && grid[0].length ==1)
//            return false;
//
//        boolean isPathUp = pathPresent(grid, grid.length-2, grid[0].length-1);
//        found = false;
//        boolean isPathLeft = pathPresent(grid, grid.length-1, grid[0].length-2);
//
//        if (isPathUp && isPathLeft){
//            return false;
//        }
//        return true;
//    }
//
//    private boolean pathPresent(int[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || found)
//            return false;
//
//        if (i == 0 && j == 0){
//            found = true;
//            return true;
//        }
//
//        grid[i][j] = 0;
//
//        boolean up = pathPresent(grid, i-1, j);
//        boolean left = pathPresent(grid, i, j-1);
//
//
//
//        return up || left;
//    }




//2196. Create Binary Tree From Descriptions
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] info : descriptions){
            int parent = info[0], child = info[1], left = info[2];
            TreeNode curr = map.getOrDefault(parent, new TreeNode(parent));
            if (left == 1){
                curr.left = map.getOrDefault(child, new TreeNode(child));
                children.add(child);
                map.put(child, curr.left);
            }
            else {
                curr.right = map.getOrDefault(child, new TreeNode(child));
                children.add(child);
                map.put(child, curr.right);
            }
            map.put(parent, curr);

        }

        int rootVal = -1;
        for (int[] info : descriptions){
            if (!children.contains(info[0])){
                rootVal = info[0];
                break;
            }
        }

        return map.get(rootVal);
    }









//1926. Nearest Exit from Entrance in Maze
    public int nearestExit(char[][] maze, int[] entrance) {
        int entranceR = entrance[0];
        int entranceC = entrance[1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {entranceR, entranceC, 0});
        maze[entranceR][entranceC] = '+';
        int[][] dir = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++){

                int[] curr = queue.poll();

                for (int[] j : dir){
                    int rx = curr[0] + j[0];
                    int cx = curr[1] + j[1];
                    if (rx >=0 && cx >= 0 && rx < maze.length && cx < maze[0].length && maze[rx][cx] != '+'){
                        if (rx == 0 || cx == 0 || rx == maze.length-1 || cx == maze[0].length-1){
                            return curr[2]+1;
                        }
                        maze[rx][cx] = '+';
                        queue.add(new int[] {rx, cx, curr[2] +1});
                    }

                }

            }
        }

        return -1;
    }











//1894. Find the Student that Will Replace the Chalk
    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        while(k > 0){
            if (index == chalk.length){
                index = 0;
            }
            k -= chalk[index];
            if (k < 0){
                return index;
            }
            index++;
        }
        return index == chalk.length ? 0 : index;
    }


//    1894. Find the Student that Will Replace the Chalk optimised for bigger k input
//    public int chalkReplacer(int[] chalk, int k) {
//        long sum = 0;
//
//        for (int nr : chalk){
//            sum += nr;
//        }
//
//        long target = k % sum;
//
//        for (int i = 0; i < chalk.length; i++){
//
//            if (target >= chalk[i]){
//                target -= chalk[i];
//            }
//            else {
//                return i;
//            }
//
//
//
//        }
//        return -1;
//    }



//2642. Design Graph With Shortest Path Calculator
    List<List<int[]>> roads;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        roads = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            roads.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        roads.get(edge[0]).add(new int[] {edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {

        int[] cost = new int[roads.size()];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[node1] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, node1});


        while (!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int currentNode = current[1];
            int currentCost = current[0];

            if (cost[currentNode] < currentCost){
                continue;
            }

            if (currentNode == node2)
                return currentCost;

            for (int[] edge : roads.get(currentNode)){
                int neighbour = edge[0];
                int neighbourCost = edge[1] + cost[currentNode];

                if (cost[neighbour] > neighbourCost){
                    cost[neighbour] = neighbourCost;
                    minHeap.offer(new int[] {neighbourCost, neighbour});
                }

            }


        }

        return cost[node2] == Integer.MAX_VALUE ? -1 : cost[node2];
    }













//1381. Design a Stack With Increment Operation
    int[] stack;
    int pointer = -1;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (pointer == stack.length-1)
            return;
        pointer++;
        stack[pointer] = x;
    }

    public int pop() {
        if (pointer == -1)
            return -1;

        int ans = stack[pointer];
        stack[pointer--] = 0;

        return ans;
    }

    public void increment(int k, int val) {
        if (k > stack.length){
            k = stack.length;
        }
        for (int i = 0; i < k; i++){
            if (stack[i] == 0)
                break;
            stack[i] += val;
        }
    }


//2336. Smallest Number in Infinite Set
//    int startNr;
//    Set<Integer> set;
//    public SmallestInfiniteSet() {
//        set = new HashSet<>();
//        startNr = 1;
//    }
//
//    public int popSmallest() {
//        if (!set.isEmpty()){
//            int min = Collections.min(set);
//            set.remove(min);
//            return min;
//        }
//        return startNr++;
//    }
//
//    public void addBack(int num) {
//        if (num < startNr){
//            set.add(num);
//        }
//    }


//1352. Product of the Last K Numbers
//    List<Integer> list;
//    int prev;
//    public ProductOfNumbers() {
//        list = new ArrayList<>();
//        prev = 1;
//        list.add(1);
//    }
//
//    public void add(int num) {
//        if (num == 0){
//            list = new ArrayList<>();
//            list.add(1);
//            prev = 1;
//        }
//        else {
//            prev *= num;
//            list.add(prev);
//        }
//    }
//
//    public int getProduct(int k) {
//        return list.size() > k ? prev / list.get(list.size()-1-k) : 0;
//    }


//1261. Find Elements in a Contaminated Binary Tree
//    TreeNode root;
//    Set<Integer> set;
//    public FindElements(TreeNode root) {
//        this.root = root;
//        set = new HashSet<>();
//        setValues(root, 0);
//    }
//    private void setValues(TreeNode treeNode, int val){
//        if (treeNode == null)
//            return;
//
//        setValues(treeNode.left, 2*val+1);
//        treeNode.val = val;
//        set.add(val);
//        setValues(treeNode.right, 2*val+2);
//    }
//
//    public boolean find(int target) {
//        return set.contains(target);
//    }








//2785. Sort Vowels in a String
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();

        for (char a : s.toCharArray()){
            if ("aeiouAEIOU".indexOf(a) != -1){
                list.add(a);
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();
        for (char a : s.toCharArray()){
            if ("aeiouAEIOU".indexOf(a) != -1){
                ans.append(list.remove(list.size()-1));
            }
            else {
                ans.append(a);
            }
        }
        return ans.toString();
    }









//1930. Unique Length-3 Palindromic Subsequences brute force
//    Set<String> set = new HashSet<>();
//    int ans = 0;
//    public int countPalindromicSubsequence(String s) {
//        countPalindromicSubsequenceHelper(s, 0, new StringBuilder());
//        return ans;
//    }
//
//    private void countPalindromicSubsequenceHelper(String s, int index, StringBuilder curr) {
//        if (curr.length() == 3){
//            if (!set.contains(curr.toString()) && curr.charAt(0) == curr.charAt(2)){
//                ans++;
//                set.add(curr.toString());
//            }
//            return;
//        }
//        if (index >= s.length()){
//            return;
//        }
//
//        curr.append(s.charAt(index));
//        countPalindromicSubsequenceHelper(s, index+1, curr);
//        curr.setLength(curr.length()-1);
//        countPalindromicSubsequenceHelper(s, index+1, curr);
//    }








//1846. Maximum Element After Decreasing and Rearranging
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i-1]+1 < arr[i]){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }


















//1493. Longest Subarray of 1's After Deleting One Element
    public int longestSubarray(int[] nums) {

        int ans = 0;
        int beforeDelete = 0;
        int afterDelete = 0;
        boolean deleted = false;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] == 0){

                if (deleted){
                    ans = Math.max(ans, afterDelete + beforeDelete);
                    beforeDelete = afterDelete;
                    afterDelete = 0;

                }
                else if (beforeDelete != 0){
                    deleted = true;
                }
            }
            else {
                if (deleted){
                    afterDelete++;
                }
                else {
                    beforeDelete++;
                }
            }


        }
        ans = Math.max(ans, beforeDelete + afterDelete);

        return ans == nums.length ? nums.length-1 : ans;
    }



//1695. Maximum Erasure Value optimised
//    You are given an array of positive integers nums and want to erase a subarray containing unique elements.
//    The score you get by erasing the subarray is equal to the sum of its elements.
//Returns the maximum score you can get by erasing exactly one subarray.
    public int maximumUniqueSubarray(int[] nums) {

        boolean[] seen = new boolean[10001];
        int maxSum = 0;
        int currSum = 0;

        int startIndex = 0;



        for (int i : nums){

            while (seen[i]){
                seen[nums[startIndex]] = false;
                currSum -= nums[startIndex++];
            }

            currSum += i;
            seen[i] = true;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }


//540. Single Element in a Sorted Array
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right){

            int mid = (left + right) / 2;

            if (mid > 0 && mid < nums.length-1){

                if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                    return nums[mid];
                }
                else if (mid % 2 == 0 && nums[mid] != nums[mid+1] || mid % 2 == 1 && nums[mid] != nums[mid-1]){
                    right = mid-1;
                }
                else if (mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 == 1 && nums[mid] == nums[mid-1]){
                    left = mid+1;
                }
            }
            else {
                return nums[mid];
            }


        }

        return nums[left];
    }
















//1526. Minimum Number of Increments on Subarrays to Form a Target Array
    public int minNumberOperations(int[] target) {
        int ans = 0;
        int currentHeight = 0;

        for (int i = 0; i < target.length; i++){

            if (target[i] > currentHeight){
                ans += target[i] - currentHeight;
            }

            currentHeight = target[i];

        }

        return ans;
    }


//1980. Find Unique Binary String
    Set<String> set = new HashSet<>();
    String ans;
    boolean found = false;
    public String findDifferentBinaryString(String[] nums) {
        set.addAll(Arrays.asList(nums));

        findDifferentBinaryStringHelper(nums.length, new StringBuilder());
        return ans;
    }
    public void findDifferentBinaryStringHelper(int size, StringBuilder currWord){
        if (found)
            return;

        if (currWord.length() == size){
            if (!set.contains(currWord.toString())){
                ans = currWord.toString();
                found = true;
            }
            return;
        }
        currWord.append("1");
        findDifferentBinaryStringHelper(size, currWord);
        currWord.setLength(currWord.length()-1);
        currWord.append("0");
        findDifferentBinaryStringHelper(size, currWord);
        currWord.setLength(currWord.length()-1);
    }







//2177. Find Three Consecutive Integers That Sum to a Given Number
    public long[] sumOfThree(long num) {
        long curr = num/3;

        while ((curr*3)+3 > num){
            curr--;
        }
        if (curr*3+3 == num){
            return new long[] {curr, curr+1, curr+2};
        }
        return new long[] {};
    }




//152. Maximum Product Subarray
    public int maxProduct(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                max = 1;
                min = 1;
                biggest = Math.max(biggest, 0);
                continue;
            }
            int temp = max;

            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            biggest = Math.max(max, biggest);
        }
        return biggest;
    }







//2120. Execution of All Suffix Instructions Staying in a Grid
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            ans[i] = amountOfMoves(n, startPos[0], startPos[1], i, s);
        }
        return ans;
    }

    private int amountOfMoves(int n, int i, int j, int index, String directions) {
        if (index >= directions.length() || i < 0 || i >= n || j < 0 || j >= n){
            return 0;
        }
        char direction = directions.charAt(index);
        if (direction == 'L' && j - 1 >= 0){
            return 1 + amountOfMoves(n, i, j-1, index+1, directions);
        }
        else if (direction == 'R' && j + 1 < n){
            return 1 + amountOfMoves(n, i, j+1, index+1, directions);
        }
        else if (direction == 'D' && i + 1 < n){
            return 1 + amountOfMoves(n, i+1, j, index+1, directions);
        }
        else if (direction == 'U' && i - 1 >= 0){
            return 1 + amountOfMoves(n, i-1, j, index+1, directions);
        }
        return 0;
    }


}