package Life;

public enum Status {
  NONE,
  BORN,
  LIVE,
  DIED;

  public Status prepare(int around) {
    switch (this) {
      case NONE:
        return (around == 3) ? BORN : NONE;
      case LIVE:
        return (around < 2 || around > 4) ? DIED : LIVE;
      default:
        return this;
    }
  }

  public Status replace() {
    switch (this) {
      case BORN:
        return LIVE;
      case DIED:
        return NONE;
      default:
        return this;
    }
  }

  public boolean isAlive() {
    return this == LIVE || this == DIED; //
  }
}
