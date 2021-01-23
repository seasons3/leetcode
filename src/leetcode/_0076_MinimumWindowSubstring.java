package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window approach In any sliding window-based problem we have two
 * pointers.
 * 
 * 1) We start with two pointers, left and right initially pointing to the first
 * element of the string SS. 
 * 2) We use the right pointer to expand the window
 * until we get a desirable window i.e. a window that contains all of the
 * characters of TT. 
 * 3) Once we have a window with all the characters, we can
 * move the left pointer ahead one by one. If the window is still a desirable
 * one we keep on updating the minimum window size.
 * 4)If the window is not desirable anymore, we repeat step \; 2step2 onwards.
 * https://medium.com/@zhongjie.ruan/leetcode-76-minimum-window-substring-b4798b5827fd
 * @author leen
 *
 */

public class _0076_MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int l = 0, r = 0, counter = map.size();
		int minLength = Integer.MAX_VALUE;
		int startIndex = 0;
		while (r < s.length()) {
			char rc = s.charAt(r);
			if (map.containsKey(rc)) {
				map.put(rc, map.get(rc) - 1);
				if (map.get(rc) == 0) {
					counter--;
				}
			}
			r++;
			while (counter == 0) {
				if (r - l < minLength) {
					startIndex = l;
					minLength = r - l;
				}
				char lc = s.charAt(l);
				if (map.containsKey(lc)) {
					map.put(lc, map.get(lc) + 1);
					if (map.get(lc) > 0) {
						counter++;
					}
				}

				l++;
			}

		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);

	}
}
