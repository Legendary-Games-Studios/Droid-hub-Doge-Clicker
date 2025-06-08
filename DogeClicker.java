import java.util.Scanner;

public class ClickerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int autoClickers = 0;
        String input;

        System.out.println("=== Doge Clicker 🐶 ===");
        System.out.println("Type 'click' to earn a point.");
        System.out.println("Type 'shop' to buy upgrades.");
        System.out.println("Type 'stats' to see your stats.");
        System.out.println("Type 'exit' to quit the game.\n");

        while (true) {
            System.out.print("Command: ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("click")) {
                int earned = 1 + autoClickers;
                points += earned;
                System.out.println("You clicked Doge! 🐾 Points earned: " + earned + " | Total: " + points);
            } else if (input.equals("shop")) {
                System.out.println("\n=== Shop ===");
                System.out.println("1. Buy Auto-Clicker (10 points)");
                System.out.print("Choose item (or type 'back'): ");
                String shopChoice = scanner.nextLine().toLowerCase();

                if (shopChoice.equals("1") || shopChoice.contains("auto")) {
                    if (points >= 10) {
                        points -= 10;
                        autoClickers++;
                        System.out.println("✅ Bought 1 Auto-Clicker! You now have " + autoClickers);
                    } else {
                        System.out.println("❌ Not enough points! You need 10.");
                    }
                } else {
                    System.out.println("Leaving shop.");
                }
                System.out.println();
            } else if (input.equals("stats")) {
                System.out.println("📊 Points: " + points + " | Auto-Clickers: " + autoClickers + "\n");
            } else if (input.equals("exit")) {
                System.out.println("👋 Thanks for playing! Final score: " + points);
                break;
            } else {
                System.out.println("❓ Unknown command. Try 'click', 'shop', 'stats', or 'exit'.\n");
            }
        }

        scanner.close();
    }
}