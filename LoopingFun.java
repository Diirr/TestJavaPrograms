package javaUebungenAusDemNetz;

public class LoopingFun {

	public static void main(String[] args) {
		String ausgabe = "";
		for (int i = 1; i <= 10000; i++) {

			if (i % 3 == 0 && i % 5 == 0) {
				ausgabe += "foobar\n";
			}

			else if (i % 3 == 0) {
				ausgabe += "foo\n";
			}

			else if (i % 5 == 0) {
				ausgabe += "bar\n";
			}

			else if (i % 3 != 0 || i % 5 != 0) {
				ausgabe += (int) i + "\n";
			}
		}

		System.out.println(ausgabe);
	}

}
