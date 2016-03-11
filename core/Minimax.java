package core;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Pseudo-code for Minimax Algorithm-
 * 
 * function minimax(state) {
 * 	v = maxvalue(state);
 * 	return successor in succesors(state) with value = v;
 * }
 * 
 * function maxvalue(state) {
 * 	if (isTerminalState(state)) {
 * 		retrurn evaluate(state);
 * 	}
 * 	
 * 	for (Successor successor : successors(state))	{
 * 		v = max(v, minvalue(successor));
 * 	}
 * 	return v;
 * }
 * 
 * 
 * function minvalue(state) {
 * 	if (isTerminalState(state)) {
 * 		retrurn evaluate(state);
 * 	}
 * 	
 * 	for (Successor successor : successors(state))	{
 * 		v = min(v, maxvalue(successor));
 * 	}
 * 	return v;
 * }
 * 
 */

public class Minimax	{
 	public static boolean hasWon(String state, char player)	{
		char [] arr = state.toCharArray();

		boolean hasWon = false;

		for (int i = 0; i < arr.length; i+=3)	{
			hasWon |= (arr[i] == player && arr[i+1] == player && arr[i+2] == player);

			if (hasWon) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++)	{
			hasWon |= (arr[i] == player && arr[i+3] == player && arr[i+6] == player);
			
			if (hasWon) {
				return true;
			}
		}

		// Check diagonals
		hasWon |= (arr[0] == player && arr[4] == player && arr[8] == player);
		hasWon |= (arr[2] == player && arr[4] == player && arr[6] == player);

		return hasWon;
	}

	public static void main(String [] args)	{
		Scanner scr = new Scanner(System.in);
		Pattern pattern = Pattern.compile("[X,O,-]{9}");

		String state = scr.nextLine();
		state = state.toUpperCase();

		Matcher matcher = pattern.matcher(state);
		if (!matcher.matches())	{
			try {
				if (null != scr) {
					scr.close();
					scr = null;
				}
			} catch (Exception e) {
				// Fine!
			}
			
			throw new IllegalArgumentException("Board should be of length 9 and contain only X, O or -");
		}

		if (hasWon(state, 'X'))	{
			System.out.println("X wins");
			System.exit(0);
		}

		if (hasWon(state, 'O'))	{
			System.out.println("O wins");
			System.exit(0);
		}
		
		try {
			if (null != scr) {
				scr.close();
				scr = null;
			}
		} catch (Exception e) {
			// Fine!
		}
	}

	private static List<String> minimax(String state, char player)	{
		List<String> possibleMoves = getPossibleMoves(state, player);
		return possibleMoves;
	}

	private static List<String> getPossibleMoves(String state, char player)	{
		return null;
	}	
}
