package edu.hw1;

public class Task8 {
    private Task8() {
    }

    static final int BOARD_LENGTH = 8;

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] chessboard) {
        if (chessboard.length != BOARD_LENGTH) {
            return false;
        }

        int[][] movePoses = new int[][] {{-1, -2}, {-2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}};

        for (int i = 0; i < BOARD_LENGTH; i++) {
            if (chessboard[i].length != BOARD_LENGTH) {
                return false;
            }
            for (int j = 0; j < BOARD_LENGTH; j++) {
                if (chessboard[i][j] == 0) {
                    continue;
                }
                for (int[] movePose : movePoses) {
                    if (0 <= i + movePose[0] && i + movePose[0] < BOARD_LENGTH && 0 <= j + movePose[1]
                        && j + movePose[1] < BOARD_LENGTH && chessboard[i + movePose[0]][j + movePose[1]] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
