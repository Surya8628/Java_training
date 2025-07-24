package Anagram;
import java.util.HashMap;
import java.util.Scanner;

public  class Anagram {

    public static boolean isAnagram(String str1, String str2) {
        // Normalize: convert to lowercase and remove spaces
        str1 = str1.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");

        // Quick length check
        if (str1.length() != str2.length()) {
            return false;
        }

        // Count characters in first string
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using second string
        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; // Character not found in first string
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = scanner.nextLine();

        System.out.print("Enter second string: ");
        String second = scanner.nextLine();

        if (isAnagram(first, second)) {
            System.out.println(" The strings are anagrams.");
        } else {
            System.out.println(" The strings are not anagrams.");
        }

        scanner.close();
    }
}