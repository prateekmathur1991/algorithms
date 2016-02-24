package ctci;
public class StringCompresser	{
	public static void main(String [] args)	{
		System.out.println(compress(args[0]));
	}

	public static String compress(String str)	{
		StringBuilder builder = new StringBuilder();
		char [] arr = str.toCharArray();
		
		char c = arr[0];
		builder.append(Character.toString(c));

		int current_count = 1;
		for (int i = 1; i < arr.length; i++)	{
			if (arr[i] == c)	{
				current_count++;
			} else {
				c = arr[i];
				builder.append(Integer.toString(current_count));
				builder.append(Character.toString(c));
				current_count = 1;
			}
		}

		builder.append(Integer.toString(current_count));

		String cStr = builder.toString();
		return cStr.length() >= str.length() ? str : cStr;
	}
}
