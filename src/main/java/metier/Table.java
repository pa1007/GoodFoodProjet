package metier;

public class Table implements Afficher {

    private String numTable;
    private long   placeMax;
    private String numSalle;

    public Table(String numTable, long placeMax, String numSalle) {
        this.numTable = numTable;
        this.placeMax = placeMax;
        this.numSalle = numSalle;
    }

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "numTable":
                return numTable;
            case "placeMax":
                return String.valueOf(placeMax);
            case "numSalle":
                return numSalle;
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
    }

    public String getNumTable() {
        return numTable;
    }

    public void setNumTable(String numTable) {
        this.numTable = numTable;
    }

    public long getPlaceMax() {
        return placeMax;
    }

    public void setPlaceMax(long placeMax) {
        this.placeMax = placeMax;
    }

    public String getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(String numSalle) {
        this.numSalle = numSalle;
    }

    @Override
    public String toString() {
        return "Table{" +
               "numTable='" + numTable + '\'' +
               ", placeMax=" + placeMax +
               ", numSalle='" + numSalle + '\'' +
               '}';
    }
}
