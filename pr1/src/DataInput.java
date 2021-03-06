import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public final class DataInput {

	private static void writeText(String wr){
		if (wr == null)
			System.out.print("Введіть дані: ");
		else
			System.out.print(wr);
	}

	static int checkInt(int input, int low, int high) {
		while (input <= low || input > high) {
			input = getInt("Try again: ");
		}

		return input;
	}

	public static String[] readFile(String path) throws Exception{
		File file = new File(path);
		Scanner scanner = new Scanner(file);

		ArrayList<String> ar = new ArrayList<String>();

		while(scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
			ar.add(scanner.nextLine());
		}

		Object[] arr = ar.toArray();
		String[] res = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			res[i] = (String) arr[i];
		}

		return res;
	}

	public static Long getLong() throws IOException{
		String s = getString("Enter a long value: ");
		Long value = Long.valueOf(s);

		return value;
	}

	public static char getChar(String s) throws IOException{
		writeText(s);
		String res = getString("Enter a char: ");

		return res.charAt(0);
	}

	public static Integer getInt(String wr){
		writeText(wr);
		String s = "";

		try {
			s = getString("");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer value = Integer.valueOf(s);

		return value;
	}

	public static String getString(String text) throws IOException{
		writeText(text);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		return s;
	}
}
