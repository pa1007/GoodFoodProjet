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
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numTab":
                    res.append(numTab);
                    break;
                case "dataff":
                    res.append(dataff);
                    break;
                case "numserv":
                    res.append(numserv);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
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

    @Override
    public String toString() {
        return "Affecter{" +
               "numTab=" + numTab +
               ", dataff=" + dataff +
               ", numserv=" + numserv +
               '}';
    }
}
