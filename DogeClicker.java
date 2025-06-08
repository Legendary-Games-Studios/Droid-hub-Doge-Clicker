import java.util.*;
import java.io.*;

public class ClickerGame {
    private static final String SAVE_FILE = "save.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int autoClickers = 0;
        String input;

        // Load save data if file exists
        File file = new File(SAVE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                points = Integer.parseInt(reader.readLine());
                autoClickers = Integer.parseInt(reader.readLine());
                System.out.println("📂 Save loaded! Points: " + points + " | Auto-Clickers: " + autoClickers + "\n");
            } catch (Exception e) {
                System.out.println("⚠️ Failed to load save. Starting fresh.");
            }
        }

        System.out.println("===================================");
        System.out.println("=== Doge Clicker 🐶              ===");
        System.out.println("=== Rating: E (Everyone)         ===");
        System.out.println("=== Developed by:                ===");
        System.out.println("=== Legendary Games Studios      ===");
        System.out.println("===================================\n");

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
                saveGame(points, autoClickers);
                System.out.println("👋 Thanks for playing! Progress saved.");
                break;
            } else {
                System.out.println("❓ Unknown command. Try 'click', 'shop', 'stats', or 'exit'.\n");
            }
        }

        scanner.close();
    }

    private static void saveGame(int points, int autoClickers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            writer.write(String.valueOf(points));
            writer.newLine();
            writer.write(String.valueOf(autoClickers));
        } catch (IOException e) {
            System.out.println("❌ Failed to save game.");
        }
    }
}
