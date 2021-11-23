package life.model;

import life.utils.Status;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Status status;

    private final List<Cell> nearNeighbors;


    public Cell() {
        this.status = Status.NONE;
        this.nearNeighbors = new ArrayList<>();
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

    public void addNearNeighbors(Cell cell) {
        nearNeighbors.add(cell);
    }

}
