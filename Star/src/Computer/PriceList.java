package Computer;

public class PriceList  {
    //wypisanie usług z cenami
    //Diagnosis pobiera ceny stąd
    private int Replace;
    private int Instalation;
    private int Building;
    private int Cleaning;
    private int Reparing;

    public int getReplace() {
        return Replace;
    }

    public void setReplace(int replace) {
        Replace = replace;
    }

    public int getInstalation() {
        return Instalation;
    }

    public void setInstalation(int installation) {
        Instalation = installation;
    }

    public int getBuilding() {
        return Building;
    }

    public void setBuilding(int building) {
        Building = building;
    }

    public int getCleaning() {
        return Cleaning;
    }

    public void setCleaning(int cleaning) {
        Cleaning = cleaning;
    }

    public int getReparing() {
        return Reparing;
    }

    public void setReparing(int reparing) {
        Reparing = reparing;
    }
}