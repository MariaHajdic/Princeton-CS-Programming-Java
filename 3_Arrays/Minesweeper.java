public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[] minefield = new char[m*n];
        for (int i = 0; i < m*n; i++) {
            minefield[i] = '0';
        }
        int planted = 0;
        while (planted < k) {
            int pos = (int) (m * n * Math.random());
            if (minefield[pos] == '*') continue;
            minefield[pos] = '*';
            planted++;
        }

        for (int i = 0; i < m * n; i++) {
            if (minefield[i] == '*') {
                for (int j = -1; j <= 1; j++) {
                    for (int b = -1; b <= 1; b++) {
                        int adjacentRow = i / n + j;
                        int adjacentCol = i % n + b;

                        if (adjacentRow < 0 || adjacentRow >= m || adjacentCol < 0 || adjacentCol >= n)
                            continue;

                        int adjacentCell = i + j * n + b;
                        if (minefield[adjacentCell] != '*')
                            minefield[adjacentCell] = (char) ((int) minefield[adjacentCell] + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m * n; i++) {
            System.out.print(minefield[i] + "  ");
            if ((i + 1) % n == 0) System.out.println();
        }
    }
}