import java.io.*;

// https://www.bingo.es/cartones-bingo/

public class CardsGenerator {
    private BufferedReader reader;

    public CardsGenerator() {
        try {
            reader = new BufferedReader(new FileReader("cards.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int[] getNumbersInRow() {
        try {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                return null;
            }
            String[] parts = line.split(",");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
