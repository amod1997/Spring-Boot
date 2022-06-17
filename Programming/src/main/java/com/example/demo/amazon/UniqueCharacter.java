package com.example.demo.amazon;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueCharacter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String to find first character");
		String str = scan.next();
		int firstCharacter = findFirstCharacter(str);
		System.out.println(firstCharacter);
		scan.close();
	}

	/***
	 * 
	 * @param str
	 * @return int
	 */
	private static int findFirstCharacter(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), i);
			} else {
				map.put(str.charAt(i), -1);
			}
		}
		int min = Integer.MAX_VALUE;

		for (char c : map.keySet()) {
			if (map.get(c) > -1 && map.get(c) < min) {
				min = map.get(c);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
