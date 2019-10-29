package metier;

import java.sql.Date;

public class Affecter implements Afficher {

    private long numTab;
    private Date dataff;
    private long numserv;

    public Affecter(long numTab, Date dataff, long numserv) {
        this.numTab = numTab;
        this.dataff = dataff;
        this.numserv = numserv;
    }

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "numTab":
                return String.valueOf(numTab);
            case "dataff":
                return String.valueOf(dataff);
            case "numserv":
                return String.valueOf(numserv);
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
    }

    public long getNumTab() {
        return numTab;
    }

    public void setNumTab(long numTab) {
        this.numTab = numTab;
    }

    public Date getDataff() {
        return dataff;
    }

    public void setDataff(Date dataff) {
        this.dataff = dataff;
    }

    public long getNumserv() {
        return numserv;
    }

    public void setNumserv(long numserv) {
        this.numserv = numserv;
    }
}
