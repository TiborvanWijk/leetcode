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
    public int maxProfit(int[] prices) {
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

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }


        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left != null && root.right != null){
            return Math.min(left, right) + 1;
        }
        return Math.max(left, right) + 1;


    }




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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        while(list1 != null){
            dummy.next = new ListNode(list1.val);
            list1 = list1.next;
            dummy = dummy.next;
        }
        while(list2 != null){
            dummy.next = new ListNode(list2.val);
            list2 = list2.next;
            dummy = dummy.next;
        }
        return tail.next;
    }



    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode newHead = head;

        if (head.next != null){
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;



        return newHead;
    }
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);


        return root;
    }



























    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }







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






    public ListNode canJump(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode newHead = head;

        if (head.next != null){
            newHead = canJump(head.next);
            head.next.next = head;
        }
        head.next = null;

    return newHead;
    }
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




    public ListNode removeElementsIterative(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null){
            ListNode nxt = current.next;

            if (current.val == val){
                prev.next = nxt;
            }
            else {
                prev = current;
            }
            current = current.next;

        }

       return dummy.next;
    }
// 1->2->

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;


        ListNode next = removeElementsRecursive(head.next, val);

        if (head.val == val){
            head = next;
        }
        else {
            head.next = next;
        }

        return head;
    }
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

    }
// checks if the tree is symmetrical.
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isSymmetricHelper(root.left, root.right);
    }
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);

    }


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


// checks if all the values in a tree are the same if they are then it returns true.
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null && root.right == null) return true;

        return helper(root.right, root.val) && helper(root.left, root.val);
    }

    public boolean helper(TreeNode root, int val) {
        if (root == null) return true;

        return root.val == val && helper(root.left,val) && helper(root.right, val);
    }

// Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int middle = (left + right) / 2;

        TreeNode root = new TreeNode();
        root.val = nums[middle];

        root.left = sortedArrayToBSTHelper(nums, left, middle - 1);
        root.right = sortedArrayToBSTHelper(nums, middle + 1, right);



        return root;
    }



















    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root2 == null) return root1;
        if (root1 == null) return root2;

        TreeNode ans = new TreeNode(root1.val + root2.val);
        ans.left = mergeTrees(root1.left, root2.left);
        ans.right = mergeTrees(root1.right, root2.right);
        return ans;
    }



    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }






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





























}
