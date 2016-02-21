public class OneEditAway	{
	public static void main(String [] args)	{
		System.out.println(isOneOrZeroEditAway(args[0], args[1]));
	}

	public static boolean isOneOrZeroEditAway(String str1, String str2)	{
		int len1 = str1.length();
		int len2 = str2.length();
		
		int diff = len1 - len2;

		if (Math.abs(diff) > 1)	{
			return false;
		}

		int index1 = 0, index2 = 0;
		String s1 = len1 < len2 ? str1 : str2;
		String s2 = len1 < len2 ? str2 : str1;
		boolean foundDiff = false;

		while (index2 < s2.length() && index1 < s1.length())	{
			if (s1.charAt(index1) != s2.charAt(index2))	{
				if (foundDiff)	{
					return false;
				}

				foundDiff = true;
				if (len1 == len2)	{
					index1++;
				}
			} else {
				index1++;
			}

			index2++;
		}

		return true;
	}
}
