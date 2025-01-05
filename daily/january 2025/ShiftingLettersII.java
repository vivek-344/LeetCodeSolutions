// January 5th, 2025
// 2381. Shifting Letters II
// https://leetcode.com/problems/shifting-letters-ii/

public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] forward = new int[n+1];
        int[] backward = new int[n+1];
        for(int[] shift: shifts) {
            int a = shift[0], b = shift[1], c = shift[2];
            if (c == 0) {
                backward[a] += 1;
                if (b + 1 < n) backward[b + 1] -= 1;
            } else {
                forward[a] += 1;
                if (b + 1 < n) forward[b + 1] -= 1;
            }
        }
        int x = 0, y = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            x += forward[i];
            y += backward[i];
            int op = x - y;
            int ch = s.charAt(i) - 'a';
            ch = (ch + op % 26 + 26) % 26;
            str.append((char)(ch + 'a'));
        }
        return str.toString();
    }
}
