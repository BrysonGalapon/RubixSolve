package src;

/**
 * Represents a mutable Face of a Rubix Cube
 */
public class Face {

  // A 3x3 array representing a face
  private final Color[][] face = new Color[3][3];

  /**
   * Obtain a new Face filled with a particular color
   * @param color the color to fill this face
   */
  public Face(Color color) {

  }

  /**
   * Get a particular column
   * @param column the 1-indexed column to extract colors from
   * @return a list of colors representing the top-down colors on that column
   */
  public Color[] getColumn(int column) {
    // TODO
    return null;
  }

  /**
   * Get a particular row
   * @param row the 1-indexed row to extract colors from
   * @return a list of colors representing the left-right colors on that row
   */
  public Color[] getRow(int row) {
    // TODO
    return null;
  }

  /**
   * Replace the colors on a particular column
   * @param column the 1-indexed column to replace
   * @param colors the list of colors to replace the top-down column of colors
   * @param flip whether or not to flip the order of the colors list
   */
  public void setColumn(int column, Color[] colors, boolean flip) {
    // TODO
  }

  /**
   * Replace the colors on a particular row
   * @param row the 1-indexed row to replace
   * @param colors the list of colors to replace the left-right row of colors
   * @param flip whether or not to flip the order of the colors list
   */
  public void setRow(int row, Color[] colors, boolean flip) {
    // TODO
  }

  /**
   * Rotate this face a particular direction
   * @param direction direction to rotate this face
   */
  public void rotate(Direction direction) {
    // TODO 
  }

  /**
   * Returns a copy of this face
   */
  public Face copy() {
    // TODO
    return null;
  }

}
