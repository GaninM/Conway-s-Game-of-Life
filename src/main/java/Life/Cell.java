package Life;

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

  // Подсчет ближайших соседей
  // и присваивание статуса в зависимости от колличества соседей
  void firstStep() {
    int around = countNearNeighbors();
    status = setStatus(around);
  }

  void secondStep() {
    status = replace();
  }

  // считаем сколько живых ячеек рядом
  int countNearNeighbors() {
    int count = 0;
    for (Cell cell : nearNeighbors) {
      if (cell.isAlive()) {
        count++;
      }
    }
    return count;
  }

  //первоначальное присваивание ячейкам статуса, за первый шаг цикла
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

  //Вторичное присваивание статуса ячейка в зависимости от ее настоящего состояния
  public Status replace() {
    switch (status) {
      case BORN:
        return Status.LIVE; // Если ячейка рождается в этом шаге, то в следующем шаге она жива
      case DIES:
        return Status.NONE; // Если ячейка умирает в этом шаге, то в следующий ее уже не будет
      default:
        return status;
    }
  }

  public boolean isAlive() {
    return status == Status.LIVE || status == Status.DIES;
  }
}
