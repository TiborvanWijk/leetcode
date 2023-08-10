import java.nio.file.ClosedWatchServiceException;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.sql.Struct;
import java.util.*;

/**
 * Every function is a different leetCode problem
 *
 *
 */
public class solutions {
    ArrayList<Integer> dummy = new ArrayList<>();

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
    public boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                reverse.append(s.charAt(i));
            }
        }
        return String.valueOf(reverse).equals(String.valueOf(reverse.reverse()));
    }

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
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        int[] ans = new int[nums.length - (k - 1)];

        for (int i = 0; i <= nums.length - k; i++){
            int max = nums[i];
            for (int j = 1; j < k; j++){
                max = Math.max(max, nums[i + j]);
            }
            ans[i] = max;
        }
        return ans;
    }



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












    public int findMin(int[] nums) {








        return -1;
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







    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 1){
            return true;
        }
        else  if (nums.length == 1 && nums[0] == 0){
            return true;
        }
        int jumNr = nums[0];
        while (jumNr <= nums.length - 1){
            jumNr += nums[jumNr];

            if (jumNr >= nums.length || nums[jumNr] == nums[nums.length - 1]){
                return true;
            }
            else if (nums[jumNr] == 0){
                return false;
            }

        }

        return false;
    }






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



















    public boolean isPalindrome(int x) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);

        return String.valueOf(stringBuilder).equals(String.valueOf(stringBuilder.reverse()));
    }



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
//// Convert Sorted Array to Binary Search Tree
//    public TreeNode sortedArrayToBST(int[] nums) {
//
//        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
//    }
////    makes a binary search tree out of a sorted array
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
    public int majorityElement(int[] nums) {
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











    private int minDiff;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }

        prev = node;

        inOrderTraversal(node.right);
    }





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
        if(slow==1){
            return true;
        }
        return false;
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }



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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            boolean isDuplicate = false;

            while (curr.next != null && curr.val == curr.next.val) {
                isDuplicate = true;
                curr = curr.next;
            }

            if (isDuplicate) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

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
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) return null;

        if (root.val == target){
            return root;
        }
        else if (root.val < target){
            return searchBST(root.right, target);
        }
        else{
            return searchBST(root.left, target);
        }

    }




















// finds the median in the two sorted arrays put together.
//    median is the number in the middle if the total amount of numbers is even.
//    then it will take the 2 middle numbers and return the average.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
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
                    return (double) Math.max(maxX, maxY);
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



    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            preorderTraversal(root.right);
            preorderTraversal(root.left);
            list.add(root.val);
        }

        return list;
    }





}
