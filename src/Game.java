public class Game {
    private Card[] cards;
    private Drum drum;
    private boolean[] extractedBalls;

    public Game(int numCards) {
        extractedBalls = new boolean[91];
        for (int i = 0; i < extractedBalls.length; i++) {
            extractedBalls[i] = false;
        }
        CardsGenerator generator = new CardsGenerator();
        drum = new Drum(1, 90);
        cards = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            cards[i] = new Card(generator);
        }
    }

    public void playForLine() {
        boolean isAnyLine = false;
        while (!isAnyLine) {
            int ball = drum.extractBall();
            extractedBalls[ball] = true;
            for (int i = 0; i < cards.length; i++) {
                cards[i].markNumber(ball);
                if (cards[i].isLine()) {
                    System.out.println("LINE COMPLETED by card n. " + (i + 1));
                    System.out.println(cards[i]);
                    isAnyLine = true;
                }
            }
        }
    }

    public void playForBingo() {
        boolean isBingo = false;
        while (!isBingo) {
            int ball = drum.extractBall();
            extractedBalls[ball] = true;
            for (int i = 0; i < cards.length; i++) {
                cards[i].markNumber(ball);
                if (cards[i].isBingo()) {
                    System.out.println("BINGO by card n. " + (i + 1));
                    System.out.println(cards[i]);
                    isBingo = true;
                }
            }
        }
    }

    public void play() {
        playForLine();
        playForBingo();
    }

    public void printExtractedNumbers() {
        System.out.print("Extracted numbers: ");
        for (int i = 1; i < extractedBalls.length; i++) {
            if (extractedBalls[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void printNotExtractedNumbers() {
        System.out.print("Not extracted numbers: ");
        for (int i = 1; i < extractedBalls.length; i++) {
            if (!extractedBalls[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void printAllCards() {
        for (Card card: cards) {
            System.out.println(card);
        }
    }
}
