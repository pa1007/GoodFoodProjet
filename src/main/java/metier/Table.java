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
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numTable":
                    res.append(numTable);
                    break;
                case "placeMax":
                    res.append(placeMax);
                    break;
                case "numSalle":
                    res.append(numSalle);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
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
