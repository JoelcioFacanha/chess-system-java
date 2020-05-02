package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {

		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}

		return mat;
	}

	private void placeNewChess(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewChess('b', 6, new Rook(board, Color.WHITE));
		placeNewChess('e', 8, new King(board, Color.WHITE));
		placeNewChess('e', 1, new King(board, Color.BLACK));
	}
}
