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
        System.out.println(" 4. Exit ");

        int input = scan.nextInt();
        while(input <=4) {
            if(input ==1) {
                //ADD
                System.out.print(" What Would You Like To Add?\n");
                System.out.print(" 1. Trip Offering\n");
                System.out.print(" 2. Bus\n");
                System.out.print(" 3. Driver\n");
                int addselect = scan.nextInt();

                while(addselect <=3){
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
                        System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                        String date = scan.nextLine();
                        System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                        String scheduledStartTime = scan.nextLine();
                        //deleteTripOffering(int tripNumber, String date, String scheduledStartTime);
                    }
                    if (deleteselect == 2) {
                        //BUS
                        System.out.print(" Please enter a Bus ID Number\n");
                        int busID = scan.nextInt();
                        //deleteBus(int busID);
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
                        System.out.println("Please enter the Date");
                        String Date = scan.nextLine();
                        db.displayTripSchedule(StartLocationName,  DestinationName,  Date);
                    }
                    if (displayselect == 2) {
                        //DRIVER SCHEDULE AND DATE
                        //DisplayDriver();
                    }
                    if (displayselect == 3) {
                        //STOPS
                        //DisplayStop();
                    }
                    else {
                        System.out.println("Error");
                    }
                }//END DISPLAY WHILE
            }//END DISPLAY IF

            if(input ==4){
                //EXIT
                System.exit(1);
            }//END EXIT IF
            else{
                System.out.println("Error");
            }//ERROR
        }//End MENU While
    }
}
