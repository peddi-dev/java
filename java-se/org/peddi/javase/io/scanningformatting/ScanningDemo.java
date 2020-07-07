package org.peddi.javase.io.scanningformatting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.System.out;
//import java.util.stream.Stream;

public class ScanningDemo {

	public void breakInputIntoTokens(String file) {

		try (var scanner = new Scanner(new BufferedReader(new FileReader(file)))) {

			scanner.tokens().forEach(token -> out.println(token));

//			while(scanner.hasNext()) {
//				out.println(scanner.next());
//			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void translateIndividualTokens(String numbersFile) {

		double sum = 0;

		try (var scanner = new Scanner(new BufferedReader(new FileReader(numbersFile)))) {

			scanner.useLocale(Locale.US);
			
			while (scanner.hasNext()) {

				if (scanner.hasNextDouble()) {
					sum += scanner.nextDouble();
				} else {
					scanner.next();
				}
			}
			
//			sum = scanner.tokens()
//					.filter(token -> { 
//						boolean result = true;
//						try { 
//						Double.valueOf(token); 
//						}catch(NumberFormatException ex) {
//							result =false;
//						}
//						return result;
//					})
//					.mapToDouble(token -> Double.valueOf(token)).sum();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		out.printf("%nSum: %f", sum);

	}

	public static void main(String[] args) {
		ScanningDemo app = new ScanningDemo();
		String file = "charinput.txt";
		app.breakInputIntoTokens(file);

		String numbersFile = "usnumbers.txt";
		app.translateIndividualTokens(numbersFile);
	}

}
