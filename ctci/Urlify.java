package ctci;
import java.util.Arrays;

public class Urlify	{
	public static void main(String [] args)	{
		String str = "Mr Jhon Smith         ";
		int truelen = 13;

		System.out.println(toUrl(str.toCharArray(), truelen));
	}

	public static String toUrl(char [] arr, int truelen)	{
		// System.out.println(Arrays.toString(arr));
		int len = truelen;
		for (int i = 0; i < truelen; i++)	{
			// System.out.println("i:: " + i);
			if (arr[i] == ' ')	{
				for (int j = len - 1; j > i; j--)	{
					arr[j+2] = arr[j];
					// System.out.println(Arrays.toString(arr));
				}

				len += 3;
				
				arr[i] = '%';
				arr[i+1] = '2';
				arr[i+2] = '0';
				
				// System.out.println(Arrays.toString(arr));
			}
		}

		return new String(arr);
	}
}
