package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {
    @Test
    public void whenPositionIsC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        boolean rsl = Cell.C8.equals(bishopBlack.position());
        Assert.assertTrue(rsl);
    }

    @Test
    public void whenCopiedPositionIsH3() {
        Figure bishopBlackC8 = new BishopBlack(Cell.C8);
        Figure bishopBlackH3 = bishopBlackC8.copy(Cell.H3);
        boolean rsl = Cell.H3.equals(bishopBlackH3.position());
        Assert.assertTrue(rsl);
    }

    @Test
    public void whenWayC1G5IsCorrect() {
        Figure bishopBlackC1 = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlackC1.way(Cell.G5);
        boolean rsl = cells.length == 4
                && cells[0].equals(Cell.D2)
                && cells[1].equals(Cell.E3)
                && cells[2].equals(Cell.F4)
                && cells[3].equals(Cell.G5);
        Assert.assertTrue(rsl);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsNotCorrect() {
        Figure bishopBlackC8 = new BishopBlack(Cell.C8);
        bishopBlackC8.way(Cell.A3);
    }
}