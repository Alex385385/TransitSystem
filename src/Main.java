import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	//Make A Menu
        System.out.println(" Trip Menu ");
        System.out.println("Please Select An Integer: ");
        System.out.println(" 1. Add ");
        System.out.println(" 2. Delete ");
        System.out.println(" 3. Edit ");
        System.out.println(" 4. Display ");
        System.out.println(" 5. Exit ");

        int input = scan.nextInt();
        while(input <=5) {
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
                    }
                    if(addselect==2){
                        //BUS
                    }
                    if(addselect==3){
                        //DRIVER
                    }
                    else{
                        System.out.println("Error");
                    }
                }//End ADD While
            }
            if (input ==2){
                //DELETE
            }
            if (input ==3){
                //EDIT
            }
            if (input ==4){
                //DISPLAY
            }
            if(input ==5){
                //EXIT
                System.exit(1);
            }
            else{
                System.out.println("Error");
            }
        }//End While
    }
}
