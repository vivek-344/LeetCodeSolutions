// December 4th, 2025
// 1930. Unique Length-3 Palindromic Subsequences
// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

import java.util.*;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        int n = s.length();

        for(int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            if(first[curr] == -1) {
                first[curr] = i;
            }
            last[curr] = i;
        }

        int res = 0;
        for(int i = 0; i < 26; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = first[i] + 1; j < last[i]; j++) {
                set.add(s.charAt(j));
            }
            res += set.size();
        }
        return res;
    }
}
