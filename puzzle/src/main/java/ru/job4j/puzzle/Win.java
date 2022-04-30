package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1 && (checkRow(board, index) || checkCol(board, index))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRow(int[][] board, int row) {
        for (int col = 0; col < board.length; col++) {
            if (board[col][row] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int[][] board, int col) {
        for (int row = 0; row < board.length; row++) {
            if (board[col][row] == 0) {
                return false;
            }
        }
        return true;
    }
}
