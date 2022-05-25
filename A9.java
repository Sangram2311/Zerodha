package string;

public class A9 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

			String s = "I am an Indian";

			int count = 1;

			for (int i = 0; i < s.length() - 1; i++) {
				if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' ')) {
					count++;
				}
			}
			System.out.println("number of words in string: " + count);

		}

	}


