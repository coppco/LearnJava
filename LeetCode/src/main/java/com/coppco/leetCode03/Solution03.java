package com.coppco.leetCode03;

import java.util.HashMap;
import java.util.HashSet;

public class Solution03 {
    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        return method03(s);
    }

    /**
     * 暴力法, 检查所有子串的长度
     *
     * @param s
     * @return
     */
    private static int method01(String s) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) result = Math.max(result, j - i);
            }
        }

        return result;
    }

    /**
     * 判断子串是否重复
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    /**
     * 滑块方法
     *
     * @param s
     * @return
     */
    private static int method02(String s) {
        int result = 0, i = 0, j = 0;
        int length = s.length();

        HashSet<Character> set = new HashSet<>();

        while (i < length && j < length) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(0, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return result;
    }

    /**
     * 滑块优化
     *
     * @param s
     * @return
     */
    private static int method03(String s) {
        int length = s.length(), result = 0;

        //当前char索引
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < length; j++) {
            System.out.println(" i = " + i + "   j = " + j);
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
                System.out.println(" i = " + i + "   j = " + j);
            }

            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
