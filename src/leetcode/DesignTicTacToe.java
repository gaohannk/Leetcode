package leetcode;

import java.util.Scanner;

public class DesignTicTacToe {
	public class Board {
		int board[][] = new int[3][3];

		public void init() {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = -1;
				}
			}
		}

		public boolean isWin(int p) {
			// check each row
			for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 3; i++) {
					if (board[i][j] != p)
						break;
					count++;
				}
				if (count == 3) {
					return true;
				}
			}
			// check each column
			for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 3; i++) {
					if (board[j][i] != p)
						break;
					count++;
				}
				if (count == 3) {
					return true;
				}
			}
			// check dignose
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[i][i] != p)
					break;
				count++;
			}
			if (count == 3) {
				return true;
			}
			// check dignose
			count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[i][2 - i] != p)
					break;
				count++;
			}
			if (count == 3) {
				return true;
			}
			return false;
		}
	}

	public class Player {
	
		String name;
		int id;

		void setPlayer(int id, String name) {
			Scanner scan = new Scanner(System.in);
			this.name = scan.nextLine();
			this.id = scan.nextInt();
		}
	}

	public class TicTacToe {
		Board board;
		Player player1;
		Player player2;

		public void addOnBoard(int i, int j, int p) {
			board.board[i][j] = p;
		}

		public void play() {
			System.out.println("Welcome! Tic Tac Toe is a two player game.");
	        System.out.print("Enter player one's name: ");
		}
	}
}
