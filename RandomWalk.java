import java.util.Random;

public class RandomWalk {

    private static final int MAX_N = 40;
    private static final int MAX_M = 20;

    private static final int MAX_MOVES = 50000;
    private static int N = 15;
    private static int M = 15;
    private static int xBUG = 20;
    private static int yBUG = 10;

    private static int[][] Room = new int[MAX_N][MAX_M];

    public static void main(String[] args) {
        Random rng = new Random();

        Room[xBUG][yBUG] = 1;

        for (int i = 0; i < MAX_MOVES; i++) {
            int move = rng.nextInt(8) + 1;

            switch (move) {
                case 1:   // sol-yukarı
                    xBUG--;
                    yBUG--;
                    break;

                case 2:   // yukarı
                    xBUG--;
                    break;

                case 3:   // sağ-yukarı
                    xBUG--;
                    yBUG++;
                    break;

                case 4:    // sol
                    yBUG--;
                    break;

                case 5:   // sağ
                    yBUG++;
                    break;

                case 6:   // sol-aşağı
                    xBUG++;
                    yBUG--;
                    break;

                case 7:   // aşağı
                    xBUG++;
                    break;
                    
                case 8:   // sağ-aşağı
                    xBUG++;
                    yBUG++;
                    break;
            }

            // Böceğin hala odada olup olmadığını kontrol etmeye çalıştım.
            if (xBUG >= 1 && xBUG <= N && yBUG >= 1 && yBUG <= M) {
                Room[xBUG][yBUG]++; // Böceğin bulunduğu kareyi arttır.
            }
        }

        System.out.println("Total number of moves: " + MAX_MOVES);

        System.out.println("Final room array:");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(Room[i][j] + " ");
            }
            System.out.println();
        }
    }
}

