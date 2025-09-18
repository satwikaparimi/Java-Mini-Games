import java.util.Random;
import java.util.Scanner;

public class VendingMachineGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Symbols for the vending/slot machine
        String[] symbols = {"🍒", "🍋", "⭐", "🍇", "🔔", "💎"};

        int balance = 100; // starting balance
        System.out.println("🎰 Welcome to the Vending Machine Jackpot Game!");
        System.out.println("You start with a balance of " + balance + " coins.");
        System.out.println("Available symbols: 🍒, 🍋, ⭐, 🍇, 🔔, 💎");

        while (balance > 0) {
            System.out.print("\nEnter your bet amount: ");
            int bet = sc.nextInt();

            if (bet > balance || bet <= 0) {
                System.out.println("❌ Invalid bet! Your current balance is " + balance);
                continue;
            }

            System.out.print("Choose your symbol: ");
            String guess = sc.next();

            // Generate 3 random symbols
            String[] machine = new String[3];
            for (int i = 0; i < 3; i++) {
                machine[i] = symbols[random.nextInt(symbols.length)];
            }

            // Show machine result
            System.out.println("The machine shows: " + machine[0] + " " + machine[1] + " " + machine[2]);

            // Check Jackpot
            if (machine[0].equals(machine[1]) && machine[1].equals(machine[2]) && machine[0].equals(guess)) {
                int winnings = bet * 10; // Jackpot = 10x
                balance = balance - bet + winnings;
                System.out.println("🎉 JACKPOT! All symbols matched your guess. You win " + winnings + " coins!");
            } else {
                balance -= bet;
                System.out.println("😢 Sorry, no jackpot! You lost " + bet + " coins.");
            }

            System.out.println("💰 Your remaining balance: " + balance + " coins");

            if (balance > 0) {
                System.out.print("Do you want to play again? (yes/no): ");
                String choice = sc.next();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("\n🏁 Game Over! Final balance: " + balance + " coins.");
        sc.close();
    }
}
