public class Main {
    public static void main(String[] args) {
        Game game = new Game(6);
        game.play();
        game.printExtractedNumbers();
        game.printNotExtractedNumbers();
        game.printAllCards();
    }
}
