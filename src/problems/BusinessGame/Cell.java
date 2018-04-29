package problems.BusinessGame;

public class Cell {

  private CellType cellType;

   private Player player;

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cellType=" + cellType +
                ", player=" + player +
                '}';
    }
}

enum  CellType{

    JAIL("JAIL"),
    EMPTY("EMPTY"),
    LOTTERY("LOTTERY"),
    HOTEL_SILVER("SILVER"),
    HOTEL_GOLD("GOLD"),
    HOTEL_PLATINUM("PLATINUM");

    private String name;

    CellType(String name) {
        this.name = name;
    }
}
