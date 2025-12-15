package backend;

public class TithiResult {
    private String tithiName;
    private String dateOfTithi;
    private String day;  // New field

    // Constructor with three parameters
    public TithiResult(String tithiName, String dateOfTithi, String day) {
        this.tithiName = tithiName;
        this.dateOfTithi = dateOfTithi;
        this.day = day;
    }

    public String getTithiName() {
        return tithiName;
    }

    public String getDateOfTithi() {
        return dateOfTithi;
    }

    public String getDay() {  // Getter for day
        return day;
    }
}
