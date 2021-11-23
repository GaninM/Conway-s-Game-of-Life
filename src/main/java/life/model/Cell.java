package life.model;

import life.utils.Status;

import java.util.ArrayList;
import java.util.List;


public class Cell {

    public Status status;

    private final List<Cell> nearNeighbors;


    public Cell() {
        this.status = Status.NONE;
        this.nearNeighbors = new ArrayList<>();
    }

    public boolean isAlive() {
        return status == Status.LIVE || status == Status.DIES;
    }

    public Status getStatus() {
        return status;
    }


    public List<Cell> getNearNeighbors() {
        return nearNeighbors;
    }


    ///////////////////////////////////////////////////////////

    public void addNearNeighbors(Cell cell) {
        nearNeighbors.add(cell);
    }

    public void firstStep() {
        int around = countNearCells();
        status = setStatus(around);
    }

    public void secondStep() {
        status = replace();
    }

    // считаем сколько живых ячеек рядом
    int countNearCells() {
        int count = 0;
        for (Cell cell : nearNeighbors) {
            if (cell.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public Status setStatus(int around) {
        switch (status) {
            case NONE:
                return (around == 3) ? Status.BORN : Status.NONE;
            case LIVE:
                return (around < 2 || around > 4) ? Status.DIES : Status.LIVE;
            default:
                return status;
        }
    }

    public Status replace() {
        switch (status) {
            case BORN:
                return Status.LIVE;
            case DIES:
                return Status.NONE;
            default:
                return status;
        }
    }

}
