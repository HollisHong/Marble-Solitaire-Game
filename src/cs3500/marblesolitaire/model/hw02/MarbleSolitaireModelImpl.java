package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw04.ASolitaireModelImpl;

/**
 * represent a MarbleSolitaireModelImpl class which is a model contains all the data of the game.
 */
public class MarbleSolitaireModelImpl extends ASolitaireModelImpl {

  // added private and final to the fields

  /**
   * The purpose is to init the graph.
   */
  public MarbleSolitaireModelImpl() {

    this.state = new ArrayList<ArrayList<Grid>>();
    this.arm = 3;
    this.create();
    state.get(3).get(3).isEmpty = true;

  }

  /**
   * Init the graph with given sRow and sCol.
   *
   * @param sRow
   *          row number
   * @param sCol
   *          column number
   * @throws IllegalArgumentException
   *           {@code (sRow, sCol) are invalid}
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {

    this.state = new ArrayList<ArrayList<Grid>>();
    this.arm = 3;
    this.create();

    try {
      if (state.get(sRow).get(sCol).isValid) {
        state.get(sRow).get(sCol).isEmpty = true;
      }
      else {
        throw new IllegalArgumentException("Invalid empty cell position ("
                + sRow + "," + sCol + ")");
      }
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

  }

  /**
   * Init the graph with given arm.
   *
   * @param arm
   *          arm length
   * @throws IllegalArgumentException
   *           {@code (arm) is invalid}
   */
  public MarbleSolitaireModelImpl(int arm) {
    if (arm >= 1 && arm % 2 == 1) {

      this.state = new ArrayList<ArrayList<Grid>>();
      this.arm = arm;
      this.create();
      int position = (arm * 3 - 3) / 2;
      state.get(position).get(position).isEmpty = true;
    }
    else {
      throw new IllegalArgumentException("Input is not a positive odd number");
    }
  }

  /**
   * Init the graph with given arm, sRow, and sCol.
   *
   * @param arm
   *          arm length
   * @param sRow
   *          row number
   * @param sCol
   *          column number
   * @throws IllegalArgumentException
   *           {@code (arm sRow sCol) are invalid}
   */
  public MarbleSolitaireModelImpl(int arm, int sRow, int sCol) {

    if (arm < 1 || arm % 2 == 0 || sRow < 0 || sCol < 0 || sRow > arm * 3 - 3
            || sCol > arm * 3 - 3) {
      throw new IllegalArgumentException("Inputs are invalid");
    }
    else {
      this.state = new ArrayList<ArrayList<Grid>>();
      this.arm = arm;
      this.create();
      if (state.get(sRow).get(sCol).isValid) {
        state.get(sRow).get(sCol).isEmpty = true;
      }
      else {
        throw new IllegalArgumentException(
                "Invalid empty cell position (" + sRow + "," + sCol + ")");
      }
    }

  }

}
