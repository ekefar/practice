package design;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/design-tic-tac-toe/description/
 */
public class TicTacToe {


    public static void main(String[] args) {
        final TicTacToe ticTacToe = new TicTacToe(2);
        System.out.println(ticTacToe.move(0,1,1));
        System.out.println(ticTacToe.move(1,1,2));
        System.out.println(ticTacToe.move(1,0,1));
    }
    private int board[][];

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move2(int row, int col, int player) {
        board[row][col] = player;

        if (checkColumn(col) || checkRow(row) || checkDiagonal(row, col)) {
            return player;
        }

        return 0;
    }

    private boolean checkRow(int row) {
        int player = board[row][0];
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col) {
        int player = board[0][col];
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int row, int col) {
        final int player = board[row][col];
        final int size = board.length;

        int mainMatches = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == player) {
                mainMatches ++;
            }
        }

        if (mainMatches == size) {
            return true;
        }

        int matches = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][size-i-1] == player) {
                matches ++;
            }
        }

        if(matches == size) {
            return true;
        }
        return false;


    }

    /*======================*/

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
        {
            diagonal += toAdd;
        }

        if (col == (cols.length - row - 1))
        {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size  ||
                Math.abs(antiDiagonal) == size)
        {
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */