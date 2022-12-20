import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static int tester(){
        int score = 0;
        try {
            File file = new File("highscore.txt");
            Scanner input = new Scanner(file);
            String last = ""; 
            while (input.hasNextLine()) {
                last = input.nextLine();
            }
            String replacedLine = last.replace(" ", "");
            int hyphinIndex = replacedLine.indexOf("-");
            input.close();
            score = Integer.valueOf(replacedLine.substring(hyphinIndex + 1));
        }
        catch (FileNotFoundException e){
            System.out.println("File does not exist.");
        }
        return score;
    }
    public static void newHighScore(player player){
        if (player.getPoints() > tester()){
            try{
                File file = new File("highscore.txt");
                FileWriter writer = new FileWriter(file, true);
                writer.write("\n" + player.getName() + " - " + String.valueOf(player.getPoints()));
                writer.close();
            }
            catch (IOException e) {
                System.out.println("File cannot be opened.");
            }
        }
    }
    public static void main(String[] args) {
        player player = new player(0, "James", 50, null);
        newHighScore(player);
    }
}