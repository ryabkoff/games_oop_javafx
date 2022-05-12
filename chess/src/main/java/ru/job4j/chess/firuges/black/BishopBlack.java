package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = position.getX() - dest.getX();
        int deltaY = position.getY() - dest.getY();
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            x = x + (deltaX > 0 ? -1 : 1);
            y = y + (deltaY > 0 ? -1 : 1);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = source.getX() - dest.getX();
        int deltaY = source.getY() - dest.getY();
        return Math.abs(deltaX) == Math.abs(deltaY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
