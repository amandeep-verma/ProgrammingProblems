// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

public class validSudoko {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		boolean check = isValidSudoku(board);

		System.out.println(check);

	}

	public static boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {

					for (int m = 0; m < 9; m++) {
						if (((m != (i)) && (board[i][j] == board[m][j]))
								|| ((m != (j)) && (board[i][j] == board[i][m])))
							return false;
					}

					for (int n = 0; n < 3; n++) {
						for (int o = 0; o < 3; o++) {
							int qr = i / 3;
							int qc = j / 3;

							if (board[i][j] == board[qr * 3 + n][qc * 3 + o]) {
								if (i != qr * 3 + n && j != qc * 3 + o) {
									System.out.println("hjgfjs");
									return false;
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}