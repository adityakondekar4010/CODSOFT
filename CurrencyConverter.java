import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded exchange rates (replace with actual API calls)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);

        // Currency selection
        System.out.println("Available currencies: USD, EUR, GBP");
        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Check if the entered currencies are valid
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency selection.");
            scanner.close();
            return;
        }

        // Currency rates
        double baseToTargetRate = exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);

        // Amount input
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Currency conversion
        double convertedAmount = amountToConvert * baseToTargetRate;

        // Display result
        System.out.println("\nResults:");
        System.out.println(amountToConvert + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }
}
