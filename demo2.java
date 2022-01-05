/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1_2006705;

/**
 *
 * @author noohg
 */
   
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;




public class demo2 {
   
   
public static void main(String[] args) throws FileNotFoundException {

        File input = new File("C:\\Users\\Rahaf Koshak\\OneDrive\\ط§ظ„ظ…ط³طھظ†ط¯ط§طھ\\NetBeansProjects\\demo2\\input.txt");
        if (input.exists())//if input file not exist
        {
            File output = new File("C:\\Users\\Rahaf Koshak\\OneDrive\\ط§ظ„ظ…ط³طھظ†ط¯ط§طھ\\NetBeansProjects\\demo2\\result6.txt");
            Scanner read = new Scanner(input);//to read from input file
            PrintWriter write = new PrintWriter(output);//to write to output file
            int Num = Integer.parseInt(read.nextLine());//read number of category
            String[] Category = new String[Num];//one-dimension array to store category
            String[][] Group = new String[Num][];//two-dimension array to store the group
            String[][][] Brandct = new String[Num][][];//three-dimension array to store the brand & product 
            double[][][] clary = new double[Num][][];//three-dimension array to store the saturated fat 
            // read the number of groups for each category
            String Line = read.nextLine();
            String[] LineSplit = Line.split(" ");
            for(int i=0 ; i< Num ; i++)
            {
                int size =Integer.parseInt(LineSplit[i]);
                //implement the arrays with the appropriate size that read from input file
                Group[i] = new String[size];
                Brandct[i] = new String[size][];
                clary[i] = new double[size][];
            }
             write.print("\n##################################################################\n"
                    + "#             Saturated Fat Levels in Junk Food Guide            #\n"
                    + "##################################################################\n\n"
                +"- Number of category types: " + Num + "\n");
            while (read.hasNext() == true)//while input file dosen't finish
            {
                
                String command = read.next();
                switch (command) 
              
                {
                    case "add_fastfoodcategories": {
                        add_fastfoodcategories(Category , read , write);
                        break;
                    }
                    case "add_groups": {
                       add_groups( Category ,Group,read , write);
                        break;
                    }
                    case "add_products": {
                               add_products( Group,Category , Brandct,Line, clary,LineSplit, read , write);
                        break;
                    }
                    case "print_result": {
                         print_result( Group,Category , Brandct, clary, read , write);
                        break;
                    }
                    
                    case "find_average_sflevel":{
                        
                   find_average( clary, read , write);
                        break;
                    }
                    
                    case "find_highest_sflevel": {
                      find_highest( Group, Category , Brandct, clary,read ,write);
                        break;
                    }
                    
                    case "find_lowest_sflevel":{ 
                           find_lowest( Group, Category , Brandct, clary,read ,write);
                    
                       
                        break;
                    }
                    
                    case "about_guide":{
                         about_guide(write);
                        break;
                    }
                    default:
                        write.println("Thank You! :)");
                     
                        write.print("Report generated on " + new Date().toString());
                       
                        write.flush();
        write.close();
        read.close();
        System.exit(0);
                }
            }
        }
        else 
             {
            System.out.println("No input file");
        }
    }
   
     public static int findingIndexOfCategory(String[] category, String name) {
        if (category.length != 0) {
            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(name)){
                
                    return i;
                }
            }
        }
        return -1;
    }
      public static int findingIndexOfGroup(String[][] group, String[] category, String Cname, String Gname) {
        int categoryIndex = findingIndexOfCategory(category, Cname);//get the index of category
        if (categoryIndex != -1) {
            for (int i = 0; i < group[categoryIndex].length; i++) {
                if (group[categoryIndex][i].equals(Gname))
                {
                    return i;
                }
            }
        }
        return -1;
    }
  public static String getStatus(double num) {
        if (num > 5) {
            return "High";
        } else if (num < 5) {
            return "Low";
        } else {
            return "Normal";
        }
    }
  
 


public static void add_fastfoodcategories(String [] Category ,Scanner read ,PrintWriter write){
write.println("- Command: add_fastfoodcategories");
                        for (int i = 0; i < Category.length; i++) {
                            Category[i] = read.next();
                            write.print("\t+ " + Category[i]);
                        }
                        write.println("\n");
  
}

public static void add_groups  (String [] Category ,String[][] Group,Scanner read ,PrintWriter write){
 write.println("- Command: add_groups");
                        String categoryName = read.next();//name of category
                        int categoryIndex = findingIndexOfCategory(Category, categoryName);//get the index of the category
                        if (categoryIndex > -1) {
                            write.println("\t-> Category: " + Category[categoryIndex]);//write the category
                            for (int i = 0; i < Group[categoryIndex].length; i++) {
                                Group[categoryIndex][i] = read.next();//store the name of group
                                write.print("\t+ " + Group[categoryIndex][i]);//write it to output file
                            }
                            write.println("\n");

}
}

public static void add_products(String[][] Group,String [] Category ,String[][][] Brand_Product,String Line,double[][][] clary,String[] LineSplit,Scanner read ,PrintWriter write){

        
write.println("- Command: add_product");
                        String categoryName = read.next();
                        String groupName = read.next();
                        int categoryIndex = findingIndexOfCategory(Category, categoryName);
                        if (categoryIndex > -1)
                        {
                            write.println("\t-> Category: " + Category[categoryIndex]);
                            int groupIndex = findingIndexOfGroup(Group, Category, categoryName, groupName);
                            if (groupIndex > -1)
                            {
                                write.println("\t-> Group: " + Group[categoryIndex][groupIndex]);
                                int productNum = Integer.parseInt(read.next());
                                read.nextLine();
                               
                                Brand_Product[categoryIndex][groupIndex] = new String[productNum];
                                clary[categoryIndex][groupIndex] = new double[productNum];
                               write.println("\t-> Number of products: " + productNum);
                                write.println("    ----------------------------------------------------------------------------------------");
                                write.println("\tSr #      \tBrand     \t\tProduct   \t\tSF (per 100g) ");
                                
                                for (int i = 0; i < productNum; i++) {
                                    Line = read.nextLine();
                                    LineSplit = Line.split(" ");
                                    Brand_Product[categoryIndex][groupIndex][i] = LineSplit[0];
                                    clary[categoryIndex][groupIndex][i] = Double.parseDouble(LineSplit[1]);
                                    String[] info = Brand_Product[categoryIndex][groupIndex][i].split("_");
                                    write.printf("\t%-10s\t%-10s\t\t%-10s\t\t%-8.2f", info[2], info[1], info[0], clary[categoryIndex][groupIndex][i]);
                                    write.println();
                                }
                                write.println("    ----------------------------------------------------------------------------------------\n");
                            }
                        }


}


public static void print_result(String[][] Group,String [] Category ,String[][][] Brand_Product,double[][][] clary,Scanner read ,PrintWriter write){



                        write.println("- Command: print_result");
                        String categoryName = read.next();
                        String groupName = read.next();//name of group
                        int categoryIndex = findingIndexOfCategory(Category, categoryName);//get the index of the category
                        if (categoryIndex > -1)//if the category exist
                        {
                            write.println("\t-> Category: " + Category[categoryIndex]);//write the category
                            int groupIndex = findingIndexOfGroup(Group, Category, categoryName, groupName);//get the index of the group
                            if (groupIndex > -1)//if the group exist
                            {
                                write.println("\t-> Group: " + Group[categoryIndex][groupIndex]);//write the group
                                int ProductNum = Brand_Product[categoryIndex][groupIndex].length;//get number of products
                                write.println("\t-> Number of products: " + ProductNum);//write number of products
                                write.println("    -------------------------------------------------------------------------------------------------------");
                                write.println("\tSr #      \tBrand     \t\tProduct   \t\tSF Level\tStatus  ");
                                write.println("    -------------------------------------------------------------------------------------------------------");
                                double sum = 0;//to sum saturated_fat to find average
                                double high = 0, low = 99999999;
                                String[] highCategory = new String[3], lowCategory = new String[3];
                                for(int i=0 ;i < Brand_Product[categoryIndex][groupIndex].length ; i++ )
                                {
                                    String[] info = Brand_Product[categoryIndex][groupIndex][i].split("_");//get product details
                                    double SF = clary[categoryIndex][groupIndex][i];//get saturated fat
                                    if (SF > high) //if SF is highest
                                    {
                                        high = SF;
                                        highCategory = Brand_Product[categoryIndex][groupIndex][i].split("_");
                                    }
                                    if (SF < low) // if SF is lowest
                                    {
                                        low = SF;
                                        lowCategory = Brand_Product[categoryIndex][groupIndex][i].split("_");
                                    }
                                    String status = getStatus(SF);//to store the status of the product based on its saturated fat
                                    write.printf("\t%-10s\t%-10s\t\t%-10s\t\t%-8.2f\t%-10s%n", info[2], info[1], info[0], clary[categoryIndex][groupIndex][i], status);//write the information to output file
                                    sum += clary[categoryIndex][groupIndex][i];
                                }
                                write.println("	-------------------------------------------------------------------------------------------------------");
                                double avg = sum / ProductNum;
                                write.printf("\t* The average SFLevel is %.2f%n", avg);
                                write.println("\t* The high category is " + highCategory[1] + " " + highCategory[2] + " (" + highCategory[0] + ")");
                                write.println("\t* The low category is " + lowCategory[1] + " " + lowCategory[2] + " (" + lowCategory[0] + ")");
                                write.println();

                            }
                 





}



}

public static void find_average(double[][][] clary,Scanner read ,PrintWriter write){
    write.println("- Command: find_average_sflevel");
                        int counter = 0;//countre to get number of all products
                        double sum = 0;//to sum all saturated_fat to find average
                        //three for loops to check all saturated fat of all products
                        for (int i = 0; i < clary.length; i++) {
                            for (int j = 0; j < clary[i].length; j++) {
                                for (int k = 0; k < clary[i][j].length; k++) {
                                    counter += 1;
                                    sum += clary[i][j][k];
                                }
                            }
                        }
                        double avg = sum / counter;
                        write.printf("	* The average SFLevel for all categories in all category types is %.2f%n%n", avg);
                       
    
    
    
    
}
public static void find_highest(String[][] Group,String [] Category ,String[][][] Brand_Product,double[][][] clary,Scanner read ,PrintWriter write){
write.println("- Command: find_high_sflevel\n"
                                + "	* The high category sflevel in all category types is:");
                        write.println("\t-------------------------------------------------------------------------------------------------------");
                        write.println("\tSr #      \tBrand     \t\tProduct   \t\tSF (per 100g)\tStatus  ");
                        write.println("\t-------------------------------------------------------------------------------------------------------");
                        int c = 0, g = 0, b = 0;
                        double high = -9999999;//small number
                        for (int i = 0; i < clary.length; i++) {
                            for (int j = 0; j < clary[i].length; j++) {
                                for (int k = 0; k < clary[i][j].length; k++) {
                                    if (high < clary[i][j][k])//if we find higher than the last one store its indexs
                                    {
                                        c = i;
                                        g = j;
                                        b = k;
                                        high = clary[i][j][k];
                                    }
                                }
                            }
                        }
                        String status = getStatus(high);
                        String[] product = Brand_Product[c][g][b].split("_");
                        //write to output file
                        write.printf("\t%-10s\t%-10s\t\t%-10s\t\t%-8.2f\t%-10s", product[2], product[1], product[0], high, status);//write the information to output file
                        write.println("\n\t-------------------------------------------------------------------------------------------------------");
                        write.println("\tIn Category: " + Category[c] + ", Group: " + Group[c][g] + "\n");


}

public static void find_lowest (String[][] Group,String [] Category ,String[][][] Brand_Product,double[][][] clary,Scanner read ,PrintWriter write){
                        write.println("- Command: find_low_sflevel\n"
                                + "	* The low category sflevel in all category types is:");
                        write.println("\t-------------------------------------------------------------------------------------------------------");
                        write.println("\tSr #      \tBrand     \t\tProduct   \t\tSF (per 100g)\tStatus  ");
                        write.println("\t-------------------------------------------------------------------------------------------------------");
                        int c = 0, g = 0, b = 0;
                        double low = 9999999;//big number
                        for (int i = 0; i < clary.length; i++) {
                            for (int j = 0; j < clary[i].length; j++) {
                                for (int k = 0; k < clary[i][j].length; k++) {
                                    if (low > clary[i][j][k])//if we find lower than the last one store its indexs
                                    {
                                        c = i;
                                        g = j;
                                        b = k;
                                        low = clary[i][j][k];
                                    }
                                }
                            }
                        }
                        String status = getStatus(low);
                        String[] product = Brand_Product[c][g][b].split("_");//to store product details
                        write.printf("\t%-10s\t%-10s\t\t%-10s\t\t%-8.2f\t%-10s", product[2], product[1], product[0], low, status);//write the information to output file
                        write.println("\n\t-------------------------------------------------------------------------------------------------------");
                        write.println("\tIn Category: " + Category[c] + ", Group: " + Group[c][g] + "\n");
}


public static void about_guide (PrintWriter write){
    write.println("- Command: about_guide");
                        write.println("\t-> Developed By: []");
                        write.println("\t-> University ID: []");
                        write.println("\t-> Section: []");
                        write.println();
}

}
