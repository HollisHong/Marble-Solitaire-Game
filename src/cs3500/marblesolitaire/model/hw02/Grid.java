package cs3500.marblesolitaire.model.hw02;


/**
 * represent a grid class (when it is not valid, we will not care if it is empty) .
 */
public class Grid {
  public boolean isValid;
  public boolean isEmpty;

  /**
   * the default value for a grid is valid and empty.
   */
  public Grid() {
    this.isValid = true;
    this.isEmpty = false;
  }

}


