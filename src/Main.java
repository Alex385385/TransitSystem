import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database db = new Database();
	//Make A Menu
        System.out.println(" Trip Menu ");
        System.out.println("Please Select An Integer: ");
        System.out.println(" 1. Add ");
        System.out.println(" 2. Delete ");
        System.out.println(" 3. Display ");
        System.out.println(" 4. Update ");
        System.out.println(" 5. Exit ");

        int input = scan.nextInt();
        while(input <=5) {
            if(input ==1) {
                //ADD
                System.out.print(" What Would You Like To Add?\n");
                System.out.print(" 1. Trip Offering\n");
                System.out.print(" 2. Bus\n");
                System.out.print(" 3. Driver\n");
                System.out.print(" 4. Actual Trip Stop Information\n");
                int addselect = scan.nextInt();

                while(addselect <=4){
                    if(addselect==1){
                        //TRIP OFFERING
                        System.out.print(" Please enter a Trip Number\n");
                        int tripNumber = scan.nextInt();
                        scan.nextLine();
                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();
                        System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();
                        System.out.print(" Please enter a Schedule Arrival Time in the form of hh:mm:ss\n");
                        String scheduledArrivalTime = scan.nextLine();
                        System.out.print(" Please enter the Name of Bus Driver\n");
                        String driverName = scan.nextLine();
                        System.out.print(" Please enter a Bus ID Number\n");
                        int busID = scan.nextInt();
                        db.addTripOffering(tripNumber, date, scheduledStartTime, scheduledArrivalTime, driverName, busID);
                    }//END ADD TRIP OFFERING
                    if(addselect==2){
                        //BUS
                        System.out.print(" Please enter a Bus ID Number\n");
                        int busID = scan.nextInt();
                        scan.nextLine();
                        System.out.print(" Please enter the Model\n");
                        String model = scan.nextLine();
                        System.out.print(" Please enter the Year\n");
                        int year = scan.nextInt();
                        db.addBus(busID, model, year);
                    }//END ADD BUS

                    if(addselect==3){
                        //DRIVER
                        scan.nextLine();
                        System.out.print(" Please enter Name of Driver\n");
                        String driverName = scan.nextLine();
                        System.out.print(" Please enter the Telephone Number\n");
                        int telephone = scan.nextInt();
                        db.addDriver(driverName, telephone);
                        break;
                    }//END ADD DRIVER
                    if(addselect==4){
                        //DRIVER
                        scan.nextLine();
                        System.out.print(" Please enter the Trip Number\n");
                        int tripNumber = scan.nextInt();
                        scan.nextLine();
                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();
                        System.out.print(" Please enter the Scheduled Arrival Time in the form of hh:mm:ss\n");
                        String scheduledArrivalTime = scan.nextLine();
                        System.out.print(" Please enter the Scheduled Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();
                        System.out.print(" Please enter the Actual Start Time in the form of hh:mm:ss\n");
                        String actualStartTime = scan.nextLine();
                        System.out.print(" Please enter the Actual Arrival Time in the form of hh:mm:ss\n");
                        String actualArrivalTime = scan.nextLine();
                        System.out.print(" Please enter the Stop Number\n");
                        int stopnumber = scan.nextInt();
                        System.out.print(" Please enter the Number of Passengers In\n");
                        int numberOfPassengerIn = scan.nextInt();
                        System.out.print(" Please enter the Number of Passengers Out\n");
                        int numberOfPassengerOut = scan.nextInt();
                        db.insertActualTripOffering(tripNumber, date, scheduledStartTime,stopnumber, scheduledArrivalTime,actualStartTime, actualArrivalTime,numberOfPassengerIn,
                        numberOfPassengerOut);
                        break;
                    }
                    else{
                        System.out.println("Error");
                    }
                }//End ADD While
            }//END ADD IF

            if (input ==2){
                //DELETE
                System.out.print(" What Would You Like To Delete?\n");
                System.out.print(" 1. Trip Offering\n");
                System.out.print(" 2. Bus\n");
                int deleteselect = scan.nextInt();

                while(deleteselect <=2) {
                    if (deleteselect == 1) {
                        //TRIP OFFERING
                        System.out.print(" Please enter a Trip Number\n");
                        int tripNumber = scan.nextInt();
                        scan.nextLine();
                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();
                        System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();
                        db.deleteTripOffering(tripNumber, date, scheduledStartTime);
                    }
                    if (deleteselect == 2) {
                        //BUS
                        System.out.print(" Please enter a Bus ID Number\n");
                        int busID = scan.nextInt();
                        db.deleteBus(busID);
                    }
                    else {
                        System.out.println("Error");
                    }
                }//END DELETE WHILE
            }//END DELETE IF

            if (input ==3){
                //DISPLAY
                System.out.print(" What Would You Like To Display?\n");
                System.out.print(" 1. Trip Offering\n");
                System.out.print(" 2. Driver Schedule and Date\n");
                System.out.print(" 3. Stops\n");
                int displayselect = scan.nextInt();

                while(displayselect <=3) {
                    if (displayselect == 1) {
                        //DISPLAY TRIP OFFERING
                        scan.nextLine();
                        System.out.println("Please enter the Start Location Name");
                        String StartLocationName = scan.nextLine();
                        System.out.println("Please enter the Destination Name");
                        String DestinationName = scan.nextLine();
                        System.out.println("Please enter a Date in the form of YYYY-MM-DD");
                        String Date = scan.nextLine();
                        db.displayTripSchedule(StartLocationName,  DestinationName,  Date);
                    }
                    if (displayselect == 2) {
                        //DRIVER SCHEDULE AND DATE
                        scan.nextLine();
                        System.out.println("Please enter the Driver Name");
                        String driverName = scan.nextLine();
                        System.out.println("Please enter a Date in the form of YYYY-MM-DD");
                        String date = scan.nextLine();
                        db.displayWeeklySchedule(driverName, date);
                    }
                    if (displayselect == 3) {
                        //STOPS
                        scan.nextLine();
                        System.out.println("Please enter the Trip Number");
                        int tripNumber = scan.nextInt();
                        db.displayStopsOfTrip(tripNumber);
                        break;
                    }
                    else {
                        System.out.println("Error");
                    }
                }//END DISPLAY WHILE
            }//END DISPLAY IF

            if(input == 4) {
                //UPDATE
                System.out.print(" What Would You Like To Update?\n");
                System.out.print(" 1. Trip Offering: Drive Name\n");
                System.out.print(" 2. Trip Offering: BusID\n");
                int updateSelect = scan.nextInt();

                while(updateSelect <=2) {
                    if (updateSelect == 1) {
                        //TRIP OFFERING
                        scan.nextLine();
                        System.out.print(" Please enter Name of Driver\n");
                        String driverName = scan.nextLine();

                        System.out.print(" Please enter a Trip Number\n");
                        int tripNumber = scan.nextInt();
                        scan.nextLine();

                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();

                        System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();

                        db.updateDriverTripOffering(driverName, tripNumber, date, scheduledStartTime);
                    }
                    if (updateSelect == 2) {
                        //TRIP OFFERING
                        scan.nextLine();
                        System.out.print(" Please enter Bus ID\n");
                        int busID = scan.nextInt();

                        System.out.print(" Please enter a Trip Number\n");
                        int tripNumber = scan.nextInt();
                        scan.nextLine();

                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();

                        System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();

                        db.updateBusTripOffering(busID, tripNumber, date, scheduledStartTime);
                    }
                    else {
                        System.out.println("Error");
                    }
                }//END UPDATE WHILE
            }//END UPDATE IF

            if(input ==5){
                //EXIT
                System.exit(1);
            }//END EXIT IF
            else{
                System.out.println("Error");
            }//ERROR
        }//End MENU While
    }
}
