package cs3500.marblesolitaire.model.hw04;


import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Grid;


/**
 * represent a EuropeanSolitaireModelImpl class which is a model contains all the data of the game.
 */
public class EuropeanSolitaireModelImpl extends ASolitaireModelImpl {

  /**
   * The purpose is to init the graph in the default situation (the arm will be 3).
   */
  public EuropeanSolitaireModelImpl() {
    this.state = new ArrayList<ArrayList<Grid>>();
    this.arm = 3;
    this.create();
    state.get(3).get(3).isEmpty = true;
    state.get(1).get(1).isValid = true;
    state.get(1).get(5).isValid = true;
    state.get(5).get(1).isValid = true;
    state.get(5).get(5).isValid = true;
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
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {

    this.state = new ArrayList<ArrayList<Grid>>();
    this.arm = 3;
    this.create();
    state.get(1).get(1).isValid = true;
    state.get(1).get(5).isValid = true;
    state.get(5).get(1).isValid = true;
    state.get(5).get(5).isValid = true;

    try {
      if (state.get(sRow).get(sCol).isValid) {
        state.get(sRow).get(sCol).isEmpty = true;
      }
      else {
        throw new IllegalArgumentException("Invalid empty cell position ("
                + sRow + "," + sCol + ")");
      }
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + sRow + "," + sCol + ")");
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
  public EuropeanSolitaireModelImpl(int arm) {
    if (arm >= 1 && arm % 2 == 1) {

      this.state = new ArrayList<ArrayList<Grid>>();
      this.arm = arm;
      this.create1();

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
  public EuropeanSolitaireModelImpl(int arm, int sRow, int sCol) {

    if (arm < 1 || arm % 2 == 0 || sRow < 0 || sCol < 0 || sRow > arm * 3 - 3
            || sCol > arm * 3 - 3 || arm % 2 == 0) {
      throw new IllegalArgumentException("Inputs are invalid");
    }
    else {
      this.state = new ArrayList<ArrayList<Grid>>();
      this.arm = arm;
      this.create1();
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
