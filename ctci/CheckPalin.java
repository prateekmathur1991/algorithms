package ctci;
import java.util.Arrays;

public class CheckPalin {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: CheckPalin <First String> <Second String>");
		}

		System.out.println(isPalin(args[0], args[1]));
	}

	public static boolean isPalin(String str1, String str2)		{
		/* if (str1.length() != str2.length())	{
			return false;
		}

		int len = str1.length();
		HashSet<Character> chars = new HashSet<Character>();
		char [] arr2 = str2.toCharArray();
		Arrays.sort(arr2);

		for (int i = 0; i < len; i++)	{
			char c = str1.charAt(i);
			if (Arrays.binarySearch(arr2, c) < 0)	{
				System.err.println("Not found");
				return false;
			} else {
				chars.add(Character.valueOf(c));
				System.out.println("Found");
			}
		}

		return true; */

		return sort(str1).equals(sort(str2));
	}

	public static String sort(String s)	{
		char [] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
