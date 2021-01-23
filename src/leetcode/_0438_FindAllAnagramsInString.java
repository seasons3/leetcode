package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main idea:
 * 
 * Consider a sliding window over s.
 * 
 * We use hashmap to store all the characters from the pattern string p and
 * count their frequencies.
 * 
 * Use a sliding window and counter value to store the number of unique
 * characters from the pattern string.
 * 
 * When traversing the source string s, if we find a character that exists in
 * string p, we decrease its frequency in the HashMap.
 * 
 * If its frequency becomes 0, it means we found the same amount of such unique
 * characters and we can decrease counter by 1.
 * 
 * If we find counter == 0, we found a match and check if the window size is a
 * match.
 * 
 * Now add back the character in the beginning of the window.
 * 
 * If this character's frequency is larger than 0, we know we're lack of this
 * character.
 * 
 * So we increase count by 1
 * 
 * 
 * @author leen
 *
 */
public class _0438_FindAllAnagramsInString {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
			return ans;
		}
		// map to store character in p and its frequency
		// s = abab p=ab
		Map<Character, Integer> map = new HashMap<>();
		// map [a:1, b:1]
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		// maintain a counter to check whether match the target string.
		// Two Pointers: l - left pointer of the window; r - right pointer of the window
		int l = 0, r = 0, counter = map.size();
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
				char lc = s.charAt(l);
				if (map.containsKey(lc)) {
					map.put(lc, map.get(lc) + 1);
					if (map.get(lc) > 0) {
						counter++;
					}
				}
				if (r - l == p.length()) {
					ans.add(l);
				}
				l++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// s = abab p=ab
		findAnagrams("abab", "ab");

	}

}
