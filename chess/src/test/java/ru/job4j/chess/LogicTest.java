package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {
    @Test(expected = OccupiedCellException.class)
    public void whenCellIsNotFree() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.C1, Cell.D2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.D2);
    }

}