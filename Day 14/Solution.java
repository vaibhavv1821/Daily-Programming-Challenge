public class Solution {
    
    
    private static int countAtMostKDistinct(String s, int k) {
        int[] freq = new int[26];  
        int left = 0, count = 0, distinct = 0;
        
        for (int right = 0; right < s.length(); right++) {
            
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinct++;  
            }
            freq[s.charAt(right) - 'a']++;
            

            while (distinct > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinct--;  
                }
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }

    public static int countSubstringsWithKDistinct(String s, int k) {
        
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {

        System.out.println(countSubstringsWithKDistinct("pqpqs", 2));  
        System.out.println(countSubstringsWithKDistinct("aabacbebebe", 3));  
        System.out.println(countSubstringsWithKDistinct("a", 1));  
        System.out.println(countSubstringsWithKDistinct("abc", 3));  
        System.out.println(countSubstringsWithKDistinct("abc", 2));  
    }
}
