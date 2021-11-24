package life.model;

import life.utils.Status;

public class Cell {

    private Status status;

    public Cell() {
        this.status = Status.NONE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
