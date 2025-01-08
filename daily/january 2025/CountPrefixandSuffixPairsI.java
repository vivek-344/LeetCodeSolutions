// January 8th, 2025
// 3042. Count Prefix and Suffix Pairs I
// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/

public class CountPrefixandSuffixPairsI {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length, count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                String str1 = words[i];
                String str2 = words[j];
                int n1 = str1.length();
                int n2 = str2.length();
                if (n2 < n1) continue;
                boolean flag = true;
                for (int k = 0; k < n1; k++) {
                    if(str1.charAt(k) != str2.charAt(k)) flag = false;
                    if(str1.charAt(k) != str2.charAt(n2-n1+k)) flag = false;
                }
                if (flag) count++;
            }
        }
        return count;
    }
}
