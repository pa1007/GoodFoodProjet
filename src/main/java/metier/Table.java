package metier;

public class Table {

    private String numTable;
    private long   placeMax;
    private String numSalle;

    public Table(String numTable, long placeMax, String numSalle) {
        this.numTable = numTable;
        this.placeMax = placeMax;
        this.numSalle = numSalle;
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

}
