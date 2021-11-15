package life.model;

import life.utils.Status;

import java.util.ArrayList;

public class Cell {

    ArrayList<Cell> nearNeighbors;

    Status status;

    public Cell() {
        status = Status.NONE;
        nearNeighbors = new ArrayList<>();
    }

    // добавляем всех соседей
    void addNearNeighbors(Cell cell) {
        nearNeighbors.add(cell);
    }

    public boolean isAlive() {
        return status == Status.LIVE || status == Status.DIES;
    }


    public Status getStatus() {
        return status;
    }

    public ArrayList<Cell> getNearNeighbors() {
        return nearNeighbors;
    }
}
