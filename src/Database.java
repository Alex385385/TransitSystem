import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            DateFormat sst =  new SimpleDateFormat("hh:mm:ss");
            DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date r = sdf.parse(scheduledStartTime);
            Time time = new Time(r.getTime());

            DateFormat sat =  new SimpleDateFormat("hh:mm:ss");
            Date r2 = sat.parse(scheduledArrivalTime);
            Time othertime = new Time(r2.getTime());

            stmt = c.createStatement();
            String sql = "INSERT INTO TripOffering(tripNumber, date, scheduledStartTime, scheduledArrivalTime, driverName, busID)" + " VALUES(?,?,?,?,?,?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,tripNumber);
            ps.setDate(2,sqlDate);
            ps.setTime(3,time);
            ps.setTime(4,othertime);
            ps.setString(5,driverName);
            ps.setInt(6,busID);
            ps.executeUpdate();
            c.commit();
            stmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println(" Added to database successfully");
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

    public void addDriver(String driverName, int telephone) {
        try {

            stmt = c.createStatement();
            String sql = "INSERT INTO Driver(DriverName, DriverTelephoneNumber)" + " VALUES(?,?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,driverName);
            ps.setInt(2,telephone);
            ps.executeUpdate();
            c.commit();
            stmt.close();

        }
        catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
    }
        System.out.println(" Added to database successfully");
    }

    public void addBus(int busID, String model, int year) {
        try {

            stmt = c.createStatement();
            String sql = "INSERT INTO Bus(BusID, Model, Year)" + " VALUES(?,?,?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,busID);
            ps.setString(2,model);
            ps.setInt(3,year);
            ps.executeUpdate();
            c.commit();
            stmt.close();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println(" Added to database successfully");
    }

    public void deleteBus(int busID) {

    }

    public void insertTripOffering() {

    }

}
