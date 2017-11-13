public class WinnerInfo {
    private String agName;
    private double percentageGain;

    public WinnerInfo() {
        this.agName = "";
        this.percentageGain = 0;
    }

    public WinnerInfo(String agName, double percentageGain) {
        this.agName = agName;
        this.percentageGain = percentageGain;
    }

    public void setAgName(String agName) {
        this.agName = agName;
    }

    public void setPercentageGain(double percentageGain) {
        this.percentageGain = percentageGain;
    }

    public String getAgName() {
        return agName;
    }

    public double getPercentageGain() {
        return percentageGain;
    }

    public String toString() {
        return "agName:" + agName + "\npercentageGain:" + percentageGain;
    }
}
