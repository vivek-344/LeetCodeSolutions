// January 2nd, 2025
// 2559. Count Vowel Strings in Ranges
// https://leetcode.com/problems/count-vowel-strings-in-ranges/

import java.util.*;

public class CountVowelStringsinRanges {
    // Optimized Version
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = words.length;
        int m = queries.length;
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = words[i];
            if(set.contains(str.charAt(0)) && set.contains(str.charAt(str.length() - 1)))
                count++;
            arr[i] = count;
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] temp = queries[i];
            int sec = 0;
            if(temp[0] != 0) sec = arr[temp[0] - 1];
            res[i] = arr[temp[1]] - sec;
        }
        return res;
    }
}

/*
// Old Solution
public int[] vowelStrings(String[] words, int[][] queries) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = words.length;
    int count = 0;
    map.put(-1, 0);
    for (int i = 0; i < n; i++) {
        String str = words[i];
        int m = str.length() - 1;
        if((str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u') && (str.charAt(m) == 'a' || str.charAt(m) == 'e' || str.charAt(m) == 'i' || str.charAt(m) == 'o' || str.charAt(m) == 'u'))
            count++;
        map.put(i, count);
    }
    n = queries.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
        int[] arr = queries[i];
        res[i] = map.get(arr[1]) - map.get(arr[0] - 1);
    }
    return res;
}
 */
