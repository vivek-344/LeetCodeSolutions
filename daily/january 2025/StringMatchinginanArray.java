// January 7th, 2025
// 1408. String Matching in an Array
// https://leetcode.com/problems/string-matching-in-an-array/description/

import java.util.*;

public class StringMatchinginanArray {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }

        return list;
    }
}
