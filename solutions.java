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
// Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    //    makes a binary search tree out of a sorted array
    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int middle = (left + right) / 2;

        TreeNode root = new TreeNode();
        root.val = nums[middle];

        root.left = sortedArrayToBSTHelper(nums, left, middle - 1);
        root.right = sortedArrayToBSTHelper(nums, middle + 1, right);



        return root;
    }


















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

















    public String removeDuplicateLetters(String s) {


        String ans = "";

        for (int i = 0; i < s.length(); i++){

            if (!ans.contains(String.valueOf(s.charAt(i)))){
                ans += s.charAt(i);
            }



        }

        return ans;
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
        int ans[] = new int[n];
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
    public void recoverTree(TreeNode root) {
        if (root != null){

            if (root.left != null){
                if (root.left.val > root.val){
                    int temp = root.val;
                    root.val = root.left.val;
                    root.left.val = temp;
                }
                recoverTree(root.left);
            }
            if (root.right != null){
                if (root.right.val < root.val){
                    int temp = root.val;
                    root.val = root.right.val;
                    root.right.val = temp;
                }
                recoverTree(root.right);
            }


        }
    }







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


















}

