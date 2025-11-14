public class Card {
    private int[][] numbers;
    private boolean[][] markedNumbers;

    public Card(CardsGenerator generator) {
        numbers = new int[3][5];
        markedNumbers = new boolean[3][5];
        // numbers initialization
        for (int row = 0; row < 3; row++) {
            numbers[row] = generator.getNumbersInRow();
        }

       /* for (int row = 0; row < 3; row++) {
            int[] line = generator.getNumbersInRow();
            for (int col = 0; col < 5; col++) {
                numbers[row][col] = line[col];
            }
        } */

        // markedNumbers inicialization
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                markedNumbers[row][col] = false;
            }
        }

    }

    @Override
    public String toString() {
        String s = "";
        boolean first;
        for (int row = 0; row < 3; row++) {
            first = true;
            for (int col = 0; col < 5; col++) {
                if (first) {
                    first = false;
                } else {
                    s += ", ";
                }
                if (markedNumbers[row][col]) {
                    s += "[" + numbers[row][col] + "]";
                } else {
                    s += numbers[row][col];
                }
            }
            s += "\n";
        }
        return s;
    }

    public void markNumber(int number) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                if (numbers[row][col] == number) {
                    markedNumbers[row][col] = true;
                    return;
                }
            }
        }
    }

    public boolean isLine() {
        for (int row = 0; row < 3; row++) {
            int counter = 0;
            for (int col = 0; col < 5; col++) {
                if (markedNumbers[row][col]) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isBingo() {
        int counter = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                if (markedNumbers[row][col]) {
                    counter++;
                }
            }
        }
        return counter == 15;
    }

}
