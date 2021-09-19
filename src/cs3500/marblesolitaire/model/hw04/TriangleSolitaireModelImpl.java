package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Grid;


/**
 * represent a TriangleSolitaireModelImpl class which is a model contains all the data of the game.
 * The data has the row, thw col, isValid and isEmpty.
 * We will use this data to run the game.
 */
public class TriangleSolitaireModelImpl extends ASolitaireModelImpl {

  protected int length;

  /**
   * The purpose is to init the graph in the default situation (the length will be 5).
   */
  public TriangleSolitaireModelImpl() {

    this.state = new ArrayList<ArrayList<Grid>>();
    this.length = 5;
    this.create2();
    state.get(0).get(0).isEmpty = true;
  }

  /**
   * Init the graph which is the board with given sRow and sCol.
   *
   * @param dim the length of the Triangle.
   * @throws IllegalArgumentException {@code (dim) are invalid}
   */
  public TriangleSolitaireModelImpl(int dim) {
    if (dim < 1) {
      throw new IllegalArgumentException("input should be positive integer");
    } else {
      this.state = new ArrayList<ArrayList<Grid>>();
      this.length = dim;
      this.create2();
      state.get(0).get(0).isEmpty = true;
    }
  }


  /**
   * Init the graph which is the game board with given sRow and sCol.
   *
   * @param row row number
   * @param col column number
   * @throws IllegalArgumentException {@code (row, col) are invalid}
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this.state = new ArrayList<ArrayList<Grid>>();
    this.length = 5;
    this.create2();
    try {
      state.get(row).get(col).isEmpty = true;
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Init the graph with given sRow and sCol.
   *
   * @param dim length of the Triangle
   * @param row row number
   * @param col column number
   * @throws IllegalArgumentException {@code (dim, row, col) are invalid}
   */
  public TriangleSolitaireModelImpl(int dim, int row, int col) {


    if (dim < 1) {
      throw new IllegalArgumentException("input should be positive integer");
    } else {
      this.state = new ArrayList<ArrayList<Grid>>();
      this.length = dim;
      this.create2();
      try {
        if (state.get(row).get(col).isValid) {
          state.get(row).get(col).isEmpty = true;
        } else {
          throw new IllegalArgumentException("the given position is not valid");
        }
      } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
  }

  /**
   * create the graph of every marble.
   * The graph is used a ArrayList of ArrayList.
   */
  protected void create2() {
    int a = 0;
    for (int i = 0; i < length; i++) {
      state.add(new ArrayList<>());
      for (int q = 0; q < length; q++) {
        state.get(i).add(new Grid());
        if (q > a) {
          state.get(i).get(q).isValid = false;
        }
      }
      a++;
    }
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    try {
      state.get(fromRow).get(fromCol);
      state.get(toRow).get(toCol);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("invalid(outbound) input given");
    }

    if (!(state.get(fromRow).get(fromCol).isValid && state.get(toRow).get(toCol).isValid)) {
      throw new IllegalArgumentException("from or to position is invalid");
    } else if (state.get(fromRow).get(fromCol).isEmpty) {
      throw new IllegalArgumentException("Need a marble at the “from” position");
    } else if (!(state.get(toRow).get(toCol).isEmpty)) {
      throw new IllegalArgumentException("Need a empty space at the “to” position");
    } else if (Math.abs(fromRow - toRow) != 2 && Math.abs(fromCol - toCol) != 2) {
      throw new IllegalArgumentException(
              "the “to” and “from” positions need exactly two positions away");
    }

    else if ((Math.abs(fromCol - toCol) == 0)
            || (Math.abs(fromRow - toRow) == 0)
            || (fromRow - toRow == 2 && fromCol - toCol == 2)
            || (fromRow - toRow == -2 && fromCol - toCol == -2)) {

      if (state.get((fromRow + toRow) / 2).get((fromCol + toCol) / 2).isEmpty) {
        throw new IllegalArgumentException("a marble needed between from and to");
      } else {
        state.get(fromRow).get(fromCol).isEmpty = true;
        state.get((fromRow + toRow) / 2).get((fromCol + toCol) / 2).isEmpty = true;
        state.get(toRow).get(toCol).isEmpty = false;
      }
    } else {
      throw new IllegalArgumentException("Invalid move(The distance between row or o");
    }

  }

  //need to add diagonal.
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (this.canMove(i, j)) {
          return false;
        }
      }
    }
    return true;
  }


  @Override
  public String getGameState() {
    String init = "";
    int num = length - 1;
    if (state == null) {
      return "";
    }

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < num; j++) {
        init = init + " ";
      }
      for (int g = 0; g < length; g++) {
        if (!(state.get(i).get(g).isValid)) {
          init = init + "  ";
        } else if (state.get(i).get(g).isEmpty) {
          if (g < length - 1 && state.get(i).get(g + 1).isValid) {
            init = init + "_ ";
          } else if (i == length - 1) {
            init = init + "_";
            break;
          } else {
            init = init + "_" + "\n";
            break;
          }
        } else if (!(state.get(i).get(g).isEmpty)) {

          if (g < length - 1 && state.get(i).get(g + 1).isValid) {
            init = init + "O ";
          } else if (i == length - 1) {
            init = init + "O";
            break;
          } else {
            init = init + "O" + "\n";
            break;
          }
        }
      }
      num--;
    }
    return init;
  }

  @Override
  public int getScore() {
    int counter = 0;

    for (int i = 0; i < length; i++) {
      for (int q = 0; q < length; q++) {
        if (state.get(i).get(q).isValid) {
          if (!(state.get(i).get(q).isEmpty)) {
            counter++;
          }
        }
      }
    }
    return counter;
  }

  /**
   * identify if a grid is able to move.
   */
  private boolean canMove(int fr, int fc) {
    boolean moveable = false;

    try {
      move(fr, fc, fr - 2, fc);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }

    try {
      move(fr, fc, fr + 2, fc);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }

    try {
      move(fr, fc, fr, fc - 2);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }
    try {
      move(fr, fc, fr, fc + 2);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }

    try {
      move(fr, fc, fr + 2, fc + 2);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }

    try {
      move(fr, fc, fr - 2, fc - 2);
      moveable = true;
    } catch (IllegalArgumentException e) {
      //do nothing;
    }
    return moveable;
  }
}
