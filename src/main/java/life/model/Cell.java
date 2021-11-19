package life.model;

import life.utils.Status;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Cell> nearNeighbors;

    private Status status;

    public Cell() {
        status = Status.NONE;
        nearNeighbors = new ArrayList<>();
    }

    //Add all neighbors
    public void addNearNeighbors(Cell cell) {
        nearNeighbors.add(cell);
    }

    public boolean isAlive() {
        return status == Status.LIVE || status == Status.DIES;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Cell> getNearNeighbors() {
        return nearNeighbors;
    }

}
