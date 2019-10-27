package metier;

import java.sql.Date;

public class Affecter {

    private long numTab;
    private Date dataff;
    private long numserv;

    public Affecter(long numTab, Date dataff, long numserv) {
        this.numTab = numTab;
        this.dataff = dataff;
        this.numserv = numserv;
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
