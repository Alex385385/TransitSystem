import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private String p = "rwvDqBlKODdjbVsd_-4wEJrhXVPHREth";
    private String u = "wgymixpg";
    private Connection c;
    private Statement stmt;

    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://drona.db.elephantsql.com:5432/wgymixpg",
                            u, p);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public void getTripSchedule(String StartLocationName, String DestinationName, String Date) {
        //--Display--
        //Scheduled StartTime
        //ScheduledArrivalTime
        //DriverName
        //BusID
    }

    public void deleteTripOffering(int tripNumber, String date, String scheduledStartTime) {

    }

    public void addTripOffering(int tripNumber, String date, String scheduledStartTime, String scheduledArrivalTime, String driverName, int busID) {

    }

    public void updateDriverTripOffering(String driverName, int tripNumber, String date, String scheduledStartTime) {

    }

    public void updateBusTripOffering(int busID, int tripNumber, String date, String scheduledStartTime) {

    }

    public void getStopsOfTrip(int tripNumber) {
        //the attributes of the table TripStopInfo
    }

    public void getWeeklySchedule(String driverName, String date) {
        //Display trip offering
    }

    public void addDriver(String driverName, String telephone) {

    }

    public void addBus(int busID, String model, int year) {

    }

    public void deleteBus(int busID) {

    }

    public void insertTripOffering() {

    }

}
