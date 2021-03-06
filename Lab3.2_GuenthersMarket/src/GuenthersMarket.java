import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class GuenthersMarket {

	double total = 0;
	boolean keepGoing = true;

	Map<String, Double> map = new HashMap<>();
	ArrayList<String> order = new ArrayList<String>();
	static ArrayList<Double> price = new ArrayList<Double>();

	public static void main(String[] args) {
		double total = 0;
		boolean keepGoing = true;

		Map<String, Double> map = new HashMap<>();
		ArrayList<String> order = new ArrayList<String>();
		ArrayList<Double> price = new ArrayList<Double>();

		map.put("bacon", 4.99);
		map.put("steak", 2.99);
		map.put("lamb", 6.99);
		map.put("pork", 8.99);
		map.put("chicken", 4.99);
		map.put("fresh oj", 1.50);
		map.put("pepsi", 2.00);
		map.put("water", 1.00);

		System.out.println("Welcome to Guenther's Market!\n");
		System.out.println("Item      Price");
		System.out.println("---------------");

		for (String key : map.keySet()) {

			String string1 = "";
			string1 += String.format("%-16s", key);
			string1 += String.format("%.2f", map.get(key));
			System.out.println(string1);
		}
		System.out.println("\n");

		Scanner scnr = new Scanner(System.in);

		do {
			System.out.println("Please enter the item that you would like to purchase:");
			String ans1 = scnr.nextLine();

			if (map.containsKey(ans1)) {
				total += map.get(ans1);
				order.add(ans1);
				price.add(map.get(ans1));
				System.out.println("You have added " + ans1 + " to your order for $" + map.get(ans1));
				System.out.println("Would like like to continue your order? (Please enter yes/no):");

				String ans2 = scnr.nextLine();

				if (ans2.equalsIgnoreCase("no")) {
					keepGoing = false;
					System.out.println("Thank you! Here is your order:");

					for (int i = 0; i < order.size(); i++) {
						String string2 = "";
						string2 += String.format("%-10s", order.get(i));
						string2 += String.format("%.2f", price.get(i));
						System.out.println(string2);
					}
					String avg = String.format("%.2f", findAvg(price));
					System.out.println("The average price of your order was $" + avg);
					double high = findHigh(price);
					System.out.println("The most expensive item you ordered was $" + high);
					double low = findLow(price);
					System.out.println("The cheapest item you ordered was $" + low);
				}
			} else {
				System.out
						.println("I'm sorry, but we don't have that. Please enter an item from the menu to try again:");
			}
		} while (keepGoing);
	}

	public static double findAvg(ArrayList<Double> price) {
		double result = 0;
		for (double num : price) {
			result += num;
		}
		return (result / price.size());
	}

	public static double findHigh(ArrayList<Double> price2) {
		int highest = -1;
		double highestPrice = -1;
		for (int i = 0; i < price2.size(); i++) {
			if (price2.get(i) > highestPrice) {
				highest = i;
				highestPrice = price2.get(i);
			}
		}
		return highestPrice;
	}

	public static double findLow(ArrayList<Double> price2) {
		int lowest = -1;
		double lowestPrice = Double.MAX_VALUE;
		for (int i = 0; i < price2.size(); i++) {
			if (price2.get(i) < lowestPrice) {
				lowest = i;
				lowestPrice = price2.get(i);
			}
		}
		return lowestPrice;
	}
}