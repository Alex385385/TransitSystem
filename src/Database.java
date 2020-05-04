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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
//    Display the schedule of all trips for a given StartLocationName and Destination Name,
//    and Date. In addition to these attributes, the schedule includes: Scheduled StartTime,
//    ScheduledArrivalTime , DriverName, and BusID.

    public void displayTripSchedule(String StartLocationName, String DestinationName, String Date) {

        try {
            stmt = c.createStatement();
            String mem = "trip";
            ResultSet rs = stmt.executeQuery("SELECT t.StartLocationName, t.DestinationName, toff.Date, toff.ScheduledStartTime, toff.ScheduledArrivalTime,toff.DriverName, toff.BusID \n" +
                    "FROM trip AS t, TripOffering As toff \n" +
                    "WHERE t.TripNumber=toff.TripNumber AND \n" +
                    "t.StartLocationName LIKE '" + StartLocationName + "%' AND \n" +
                    "t.DestinationName LIKE '" + DestinationName + "%' AND \n" +
                    "toff.Date = '"+Date+"';");

            while (rs.next()) {
                String start = rs.getString("StartLocationName");
                String des = rs.getString("DestinationName");
                //date
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
                d= rs.getDate("Date");
                //time
                Time sstartt = rs.getTime("ScheduledStartTime");
                //time
                Time sarrt = rs.getTime("ScheduledArrivalTime");
                String dn = rs.getString("DriverName");
                int bid = rs.getInt("BusID");

                System.out.println("Start Location Name = " + start);
                System.out.println("Destination Name = " + des);
                System.out.println("Date = " + d);
                System.out.println("Scheduled Start Time = " + sstartt);
                System.out.println("Scheduled Start Time = " + sarrt);
                System.out.println("Driver Name = " + dn);
                System.out.println("Bus ID = " + bid);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
     catch(Exception e){
        e.printStackTrace();
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
        System.out.println("Opened database successfully");
}

    public void deleteTripOffering(int tripNumber, String date, String scheduledStartTime) {
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());

            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            Date dateParse = dateFormat.parse(scheduledStartTime);
            Time sqlTime = new Time(dateParse.getTime());

            stmt = c.createStatement();
            String sql = "DELETE FROM tripoffering " + " WHERE tripNumber = ? " +
                         "AND date = ? AND scheduledstarttime = ?;";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, tripNumber);
            ps.setDate(2, sqlDate);
            ps.setTime(3, sqlTime);
            ps.executeUpdate();

            c.commit();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Deleted From Database Successfully");
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
//Change the driver for a given Trip offering (i.e given TripNumber, Date, ScheduledStartTime);
    public void updateDriverTripOffering( String drivername,int tripNumber, String date, String scheduledStartTime) {
        try {
            //CHECK IF INFO IS VALID
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT toff.TripNumber, toff.Date, toff.ScheduledStartTime \n" +
                    "FROM  TripOffering As toff \n" +
                    "WHERE toff.TripNumber = '" + tripNumber + "' AND \n" +
                    "toff.Date = '" + date + "' AND \n" +
                    "toff.ScheduledStartTime = '"+scheduledStartTime+"';");

            while (rs.next()) {
                int tN = rs.getInt("TripNumber");
                //date
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                d= rs.getDate("Date");
                //time
                Time sstartt = rs.getTime("ScheduledStartTime");


                System.out.println("Trip ID = " + tN);
                System.out.println("Date = " + d);
                System.out.println("Scheduled Start Time = " + sstartt);

                System.out.println();
            }
            System.out.println("Information Is Valid");
            //Proceed to update
            String sql ="UPDATE TripOffering "
                                +"SET DriverName = ?"
                                +"WHERE toff.TripNumber = '" + tripNumber + "' AND \n" +
                                "toff.Date = '" + date + "' AND \n" +
                                "toff.ScheduledStartTime = '"+scheduledStartTime+"';";

            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1, drivername);

            rs.close();
            stmt.close();
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
//Change the bus for a given Trip offering.
    public void updateBusTripOffering(int busID, int tripNumber, String date, String scheduledStartTime) {

    }

//Display the stops of a given trip ( i.e. the attributes of the table TripStopInfo).
    public void DisplayStopsOfTrip(int tripNumber) {
//TripNumber, StopNumber, SequenceNumber, DrivingTime
        try {
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * \n" +
                    "FROM TripStopInfo \n" +
                    "WHERE TripNumber = '"+tripNumber+"';");

            while (rs.next()) {
                int tN = rs.getInt("TripNumber");
                int sN = rs.getInt("StopNumber");
                int seN = rs.getInt("SequenceNumber");
                Time dT = rs.getTime("DrivingTime");

                System.out.println("Trip Number = " + tN);
                System.out.println("Stop Number = " + sN);
                System.out.println("Sequence Number = " + seN);
                System.out.println("Driving Time = " + dT);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void DisplayWeeklySchedule(String driverName, String date) {
        //Display trip offering
        //TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime,DriverName, BusID
        try {
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * \n" +
                    "FROM TripOffering \n" +
                    "WHERE DriverName LIKE '"+driverName+"%' AND Date = '"+ date + "';");

            while (rs.next()) {
                String dN = rs.getString("DriverName");
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                d= rs.getDate("Date");
                Time ssT = rs.getTime("ScheduledStartTime");
                Time saT = rs.getTime("ScheduledArrivalTime");
                int bID = rs.getInt("BusID");
                int tN = rs.getInt("TripNumber");


                System.out.println("Driver Name= " + dN);
                System.out.println("Date = " + d);
                System.out.println("Scheduled Start Time = " + ssT);
                System.out.println("Scheduled Arrival Time = " + saT);
                System.out.println("Bus ID = " + bID);
                System.out.println("Trip Number = " + tN);
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
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
        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM bus" + " WHERE busID = ?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,busID);
            ps.executeUpdate();
            c.commit();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Deleted From Database Successfully");
    }

    public void insertTripOffering() {

    }

}
