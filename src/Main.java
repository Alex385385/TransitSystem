//Project Created by Alejandro Millan and Caroline Resler

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database db = new Database();
        int input;
        //Make A Menu
        do {
            System.out.println(" Trip Menu ");
            System.out.println("Please Select An Integer: ");
            System.out.println(" 1. Add ");
            System.out.println(" 2. Delete ");
            System.out.println(" 3. Display ");
            System.out.println(" 4. Update ");
            System.out.println(" 5. Exit ");
            input = scan.nextInt();

            switch (input) {
                //ADD
                case 1:
                    int addselect;
                    do{
                    System.out.print(" What Would You Like To Add?\n");
                    System.out.print(" 1. Trip Offering\n");
                    System.out.print(" 2. Bus\n");
                    System.out.print(" 3. Driver\n");
                    System.out.print(" 4. Actual Trip Stop Information\n");
                    System.out.print(" 5. Exit\n");
                    addselect = scan.nextInt();

                        if (addselect == 1) {
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

                        if (addselect == 2) {
                            //BUS
                            System.out.print(" Please enter a Bus ID Number\n");
                            int busID1 = scan.nextInt();
                            scan.nextLine();
                            System.out.print(" Please enter the Model\n");
                            String model = scan.nextLine();
                            System.out.print(" Please enter the Year\n");
                            int year = scan.nextInt();
                            db.addBus(busID1, model, year);

                        }//END ADD BUS

                        if (addselect == 3) {
                            //DRIVER
                            scan.nextLine();
                            System.out.print(" Please enter Name of Driver\n");
                            String driverName1 = scan.nextLine();
                            System.out.print(" Please enter the Telephone Number\n");
                            int telephone = scan.nextInt();
                            db.addDriver(driverName1, telephone);
                        }//END ADD DRIVER

                        if (addselect == 4) {
                            //tripstop
                            scan.nextLine();
                            System.out.print(" Please enter the Trip Number\n");
                            int tripNumber1 = scan.nextInt();
                            scan.nextLine();
                            System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                            String date1 = scan.nextLine();
                            System.out.print(" Please enter the Scheduled Arrival Time in the form of hh:mm:ss\n");
                            String scheduledArrivalTime1 = scan.nextLine();
                            System.out.print(" Please enter the Scheduled Start Time in the form of hh:mm:ss\n");
                            String scheduledStartTime1 = scan.nextLine();
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
                            db.insertActualTripOffering(tripNumber1, date1, scheduledStartTime1, stopnumber, scheduledArrivalTime1, actualStartTime, actualArrivalTime, numberOfPassengerIn,
                                    numberOfPassengerOut);
                        }
                        if (addselect == 5){
                            break;
                        }
                    }while (addselect <= 5);
                    break;//End ADD


                case 2:
                    int deleteselect;
                    //DELETE
                    do{
                    System.out.print(" What Would You Like To Delete?\n");
                    System.out.print(" 1. Trip Offering\n");
                    System.out.print(" 2. Bus\n");
                    System.out.print(" 3. Exit\n");
                    deleteselect = scan.nextInt();
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
                        if (deleteselect == 3) {
                            break;
                        }
                    }while (deleteselect <= 3);//END DELETE
                    break;

                case 3:
                    int displayselect;
                    //DISPLAY
                    do{
                    System.out.print(" What Would You Like To Display?\n");
                    System.out.print(" 1. Trip Offering\n");
                    System.out.print(" 2. Driver Schedule and Date\n");
                    System.out.print(" 3. Stops\n");
                    System.out.print(" 4. Exit\n");
                    displayselect = scan.nextInt();
                        if (displayselect == 1) {
                            //DISPLAY TRIP OFFERING
                            scan.nextLine();
                            System.out.println("Please enter the Start Location Name");
                            String StartLocationName = scan.nextLine();
                            System.out.println("Please enter the Destination Name");
                            String DestinationName = scan.nextLine();
                            System.out.println("Please enter a Date in the form of YYYY-MM-DD");
                            String Date = scan.nextLine();
                            db.displayTripSchedule(StartLocationName, DestinationName, Date);
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
                        }
                        if (displayselect == 4) {
                            break;
                        }
                    }while (displayselect <= 4);//END DISPLAY
                    break;


                case 4:
                    int updateSelect;
                    //UPDATE
                    do{
                    System.out.print(" What Would You Like To Update?\n");
                    System.out.print(" 1. Trip Offering: Drive Name\n");
                    System.out.print(" 2. Trip Offering: BusID\n");
                    System.out.print(" 3. Exit\n");
                    updateSelect = scan.nextInt();

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
                            int tripNumber2 = scan.nextInt();
                            scan.nextLine();

                            System.out.print(" Please enter a Date in the form of YYYY-MM-DD\n");
                            String date2 = scan.nextLine();

                            System.out.print(" Please enter a Schedule Start Time in the form of hh:mm:ss\n");
                            String scheduledStartTime2 = scan.nextLine();

                            db.updateBusTripOffering(busID, tripNumber2, date2, scheduledStartTime2);
                        }
                        if(updateSelect==3){
                            break;
                        }
                    }while (updateSelect <= 3);//END UPDATE
                    break;

                case 5:
                    //EXIT
                    System.exit(1);
                    //END EXIT


                default:
                    System.out.println("Bruh why?");
                    break;
            }
        } while (input <= 5);//End MENU While
    }
}

