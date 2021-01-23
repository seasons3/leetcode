package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window approach
 * 
 * move the right pointer to scan through the string until we found the
 * repeating character. then move the left pointer to the right of the same
 * character last found. Note that the two pointers can only move forward.
 * 
 * we could define a mapping of the characters to its index. Then we can skip
 * the characters immediately when we found a repeated character.
 * 
 * @author leen
 *
 */
public class _0003_LongestSubstringWithoutRepeatingCharacter {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int l = 0, r = 0, counter = 0;
		int maxLength = 0;
		while (r < s.length()) {
			// abca counter=1;
			// map[a=2, b=1, c=1]
			char rc = s.charAt(r);
			map.put(rc, map.getOrDefault(rc, 0) + 1);
			if (map.get(rc) > 1)
				counter++;
			r++;
			while (counter > 0) {
				char lc = s.charAt(l);
				map.put(lc, map.get(lc) - 1);
				// map[a=1, b=1, c=1]
				if (map.get(lc) == 1)
					counter--;
				l++;
			}
			maxLength = Math.max(maxLength, r - l);
		}
		// bcac b=1 c=2 a=1 count=1
		// b =0
		return maxLength;
	}
}
