public class Drum {
    private int[] balls;
    int ballsRemaining;

    public Drum(int min, int max) {
        ballsRemaining = max - min + 1;
        balls = new int[ballsRemaining];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = min + i;
        }
        shuffle();
    }

    public void shuffle() {
        for (int i = 0; i < 10000; i++) {
            int num1 = (int) (Math.random() * balls.length);
            int num2 = (int) (Math.random() * balls.length);
            int temp = balls[num1];
            balls[num1] = balls[num2];
            balls[num2] = temp;
        }
    }

    public int extractBall() {
        ballsRemaining--;
        return balls[ballsRemaining];
    }
}
