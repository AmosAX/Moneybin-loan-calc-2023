package MoneyBin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



public class LoanCalculator {

    public static void main(String[] args) {
        String File_To_Read = "prospects.txt";
        ArrayList<Customer> customers = readFile(File_To_Read);
        for (int i = 0; i < Objects.requireNonNull(customers).size(); i++) {
            System.out.println("**********************************************************************");
            System.out.println("The customer namned :" + customers.get(i).getName() + " wants to borrow " + customers.get(i).getLoan() + " EURO for a period of " +
                    customers.get(i).getYears() + " years and pay " + ("" + customers.get(i).getMonthlyPayment()) + "€ each month");
            System.out.println("**********************************************************************");
        }
    }

        public static ArrayList<Customer> readFile(String filename){
            //We are gonna put the data into a list to make it easy to work with
            ArrayList<Customer> customers = new ArrayList<>();
            try {
                File datafile = new File(filename);
                Scanner FileReader = new Scanner(datafile);
                //The first line of the file contains "MoneyBin.Customer,Total loan,Interest,Years" Not really information that we need
                if (FileReader.hasNextLine()) {
                    FileReader.nextLine();
                }
                while (FileReader.hasNextLine()) {
                    String data = FileReader.nextLine();
                    //there is a whole bunch of empty space at the end of txt file, we can just ignore that
                    if (!data.contains(",")) {
                        continue;
                    }


                    //In case we would have more complex files to read a case/switch would work very nice here but this will work for the time being
                    if (data.contains("\"")) {
                        String[] QuoteNames = data.trim().split("\"", -1);
                        QuoteNames[1] = QuoteNames[1].replace(",", " ");
                        String[] row = QuoteNames[2].split(",", -1);
                        customers.add(new Customer(QuoteNames[1], Double.parseDouble(row[1]), Double.parseDouble(row[2]), Integer.parseInt(row[3])));
                    } else {
                        String[] row = data.trim().split(",", -1);
                        customers.add(new Customer(row[0], Double.parseDouble(row[1]), Double.parseDouble(row[2]), Integer.parseInt(row[3])));
                    }
                    //System.out.println(data);
                }
                FileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return customers;
        }
    }
