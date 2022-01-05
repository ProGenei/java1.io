package assignment_1_2006705;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;

public class Assignment_1_2006705 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        if (!inputFile.exists()) {
            System.out.println("input file, " + inputFile + ", does not exist");
            System.exit(0);
        }
        
        File fileW = new File("output.txt");
        PrintWriter fWrite = new PrintWriter(fileW);
        
        
        Scanner input = new Scanner(inputFile);
        String[] categories = new String[input.nextInt()];
        String[][] groups = new String[categories.length][];
        
        for (int i = 0; i < categories.length; i++) {
            groups[i] = new String[input.nextInt() + 1]; 
        }
        
        
        
        String[] Command = new String[100];
       
        for (int i = 0; i < categories.length; i++) {
            if (i == 0) {
                Command[i] = input.next();
            }
            categories[i] = input.next();     
        }

        
        for (int i = 0; i < categories.length; i++) {
            Command[1] = input.next();
            for (int j = 0; j < groups[i].length; j++) {
                groups[i][j] = input.next();
            }
        }
        
        
        fWrite.println("##################################################################");
        fWrite.println("#             Saturated Fat Levels in Junk Food Guide            #");
        fWrite.println("##################################################################");
        fWrite.println("");
        fWrite.println("- Number of category types: " + categories.length);
        fWrite.println("");
        fWrite.println("- Command: " + Command[0]);
        for (int i = 0; i < categories.length; i++) {
            fWrite.println("	+ " + categories[i]);
        }
        for (int i = 0; i < categories.length; i++) {
           fWrite.println("");
           fWrite.println("- Command: " + Command[1]); 
           
           for (int j = 0; j < groups[i].length; j++) {
               if (j == 0) {
                   fWrite.println("	   -> Category: " + groups[i][j]);
                   continue;
               }
               fWrite.print("	    + " + groups[i][j]);
           }
        }    
        
        
        double[][][] saturated_fat = new double[categories.length][100][100];
        String product_details[][][] = new String[categories.length][100][100];
        int size = 0;
        String categ;
        String group;
        
        
       
        int[] array_size = new int[100];
        int l = 0;
        for (int i = 0; i < categories.length; i++) {
        for (int j = 0; j < groups[i].length - 1; j++) {
        Command[2] = input.next();
        categ = input.next();
        group = input.next();
        size = input.nextInt();
        
        array_size[l] = size;
        l++;        
        
        fWrite.println("Command: " + Command[2]);
        fWrite.println("	-> Category: " + categ);
        fWrite.println("	-> Group: " + group);
        fWrite.println("	-> Number of products:" + size);
        fWrite.println("    ----------------------------------------------------------------------------------------");
        fWrite.println("	Sr #      	Brand     		Product   		SF (per 100g) ");
        
        for (int k = 0; k < size; k++) {
        if (k==0) {
        product_details[i][j][k] = categ;
        product_details[i][j][k+1] = group;
        }
        product_details[i][j][k+j+2] = input.next();
        String sa = product_details[i][j][k+j+2];
        String[] saturated = sa.split("_",0);
        for (int n = 0; n < size; n++) {
            if (n==0) {
            String product = saturated[0];
            String brand = saturated[1];
            String Sr = saturated[2];
            fWrite.print("	"+ Sr + "               " + brand + "                 " + product);
        } 
            
            
        }
        saturated_fat[i][j][k] = input.nextDouble();
        fWrite.println("                     " + saturated_fat[i][j][k]);
        }
        fWrite.println("    ----------------------------------------------------------------------------------------");
        fWrite.println("");
            }   
        }
        
        double total_sum = 0;
        double total_average = 0;
        
        String product_the_highest = "";
        String brand_the_highest = "";
        String Sr_the_highest = "";
        String category_highest = "";
        String group_highest = "";
        
        String product_the_lowest = "";
        String brand_the_lowest = "";
        String Sr_the_lowest = "";
        String category_lowest = "";
        String group_lowest = "";
        
        
        double saturated_fat_highset = 0;
        double saturated_fat_lowest = 0;
        
        int number_of = 0;
        double[] sfat_all = new double[100];
        
        
        int g = 0;
        for (int i = 0; i < categories.length; i++) {
        for (int j = 0; j < groups[i].length - 1; j++) {
        Command[3] = input.next();
        categ = input.next();
        group = input.next();

        fWrite.println("Command: " + Command[3]);
        fWrite.println("	-> Category: " + categ);
        fWrite.println("	-> Group: " + group);
        fWrite.println("	-> Number of products: " + array_size[g]);
        
        fWrite.println("    ----------------------------------------------------------------------------------------");
        fWrite.println("	Sr #      	Brand     		Product   		SF Level	Status  ");
        fWrite.println("    ----------------------------------------------------------------------------------------");
        int length = array_size[g];
        g++;
        double sum = 0;
        
        String product_high = "";
        String product_low = "";
        String brand_high = "";
        String brand_low = "";
        String Sr_high = "";
        String Sr_low = "";
        
        String product_high_predect = "";
        String product_low_predect = "";
        String brand_high_predect = "";
        String brand_low_predect = "";
        String Sr_high_predect = "";
        String Sr_low_predect = "";
        
        
        
        String product = "";
        String brand = "";
        String Sr = "";
        
        for (int k = 0; k < length; k++) {
            
        
        
        String sa = product_details[i][j][k+j+2];
        String[] saturated = sa.split("_",0);
        for (int n = 0; n < length; n++) {
            if (n==0) {
            product = saturated[0];
            brand = saturated[1];
            Sr = saturated[2];
            fWrite.print("	"+ Sr + "               " + brand + "                " + product);
            
            if (k==0) {
                product_high = product;
                product_high_predect = product;
                product_low_predect = product;
                brand_high_predect = brand;
                brand_low_predect = brand;
                Sr_high_predect = Sr;
                Sr_low_predect = Sr; 
            }
            
            
            product_high = product;
            product_low = product;
            brand_high = brand;
            brand_low = brand;
            Sr_high = Sr;
            Sr_low = Sr; 
            sfat_all[number_of] = saturated_fat[i][j][k];
            
            total_sum += saturated_fat[i][j][k];
            
            if (k==1) {
            if (saturated_fat[i][j][k] > saturated_fat[i][j][k-1]) {
                product_high = product;
                brand_high = brand;
                Sr_high = Sr;
                
                product_low = product_low_predect;
                brand_low = brand_low_predect;
                Sr_low = Sr_low_predect; 
                
                

            }//saturated_fat[i][j][k]
            else if (saturated_fat[i][j][k] < saturated_fat[i][j][k-1]) {
                product_high = product_high_predect;
                brand_high = brand_high_predect;
                Sr_high = Sr_high_predect;
                product_low = product;
                brand_low = brand;
                Sr_low = Sr;
               }
            }//if k
          } //if 
            
            
            
            if (number_of != 0) {
                
            if(sfat_all[number_of] > sfat_all[number_of-1]) {
                product_the_highest = product;
                brand_the_highest = brand;
                Sr_the_highest = Sr;
                saturated_fat_highset = sfat_all[number_of];
                category_highest = categories[i];
                group_highest = groups[i][j];
            }//else if children
            else if (sfat_all[number_of] < sfat_all[number_of-1]) {
                product_the_lowest = product;
                brand_the_lowest = brand;
                Sr_the_lowest = Sr;
                saturated_fat_lowest = sfat_all[number_of];
                category_lowest = categories[i];
                group_highest = groups[i][j];
            }//else if children
            else if (number_of==0) {
                product_the_highest = product;
                brand_the_highest = brand;
                Sr_the_highest = Sr;
                product_the_lowest = product;
                brand_the_lowest = brand;
                Sr_the_lowest = Sr;
                }//else if father
            }//if father
            number_of++;
        }//n
        String range = "";
        
        if (saturated_fat[i][j][k] > 5.0) 
            range = "High";
        
        else if (saturated_fat[i][j][k] < 5.0)
            range = "Low";
        else
            range = "Normal";
       
        fWrite.println("                 " + saturated_fat[i][j][k] + "              " + range);
        
        sum += saturated_fat[i][j][k];
        
        }//k
        
        fWrite.println("    ----------------------------------------------------------------------------------------");
        
        double average = sum/length;
        
        fWrite.println("	* The average SFLevel is " + average);
        fWrite.println("	* The high category is " + brand_high + " " + Sr_high + " (" + product_high + ")");
        fWrite.println("	* The low category is " + brand_low + " " + Sr_low + " (" + product_low + ") ");
        fWrite.println("");
            }//j
        }//i
        
        total_average = total_sum/11;
        
        Command[4] = input.next();
        fWrite.println("- Command: " + Command[4]);
        fWrite.println("	* The average SFLevel for all categories in all category types is " + Math.round(total_average*100.0)/100.0);
        
        
        /*
        String product_the_lowest = "";
        String brand_the_lowest = "";
        String Sr_the_lowest = "";*/
        
        
        
        Command[5] = input.next();
        fWrite.println("- Command: " + Command[5]);
        fWrite.println("	* The high category sflevel in all category types is:" );
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("	Sr #      	Brand     		Product   		SF (per 100g)	Status  ");
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("        " + Sr_the_highest + "              " + brand_the_highest + "                " + product_the_highest + "                   " + saturated_fat_highset + "             High");
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("	In Category: " + category_highest + ", Group: " + group_highest);
        fWrite.println(" ");
        
        Command[6] = input.next();
        fWrite.println("- Command: " + Command[6]);
        fWrite.println("	* The low category sflevel in all category types is:" );
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("	Sr #      	Brand     		Product   		SF (per 100g)	Status  ");
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("        " + Sr_the_lowest + "              " + brand_the_lowest + "                 " + product_the_lowest + "               " + saturated_fat_lowest + "             Low");
        fWrite.println("	-------------------------------------------------------------------------------------------------------");
        fWrite.println("	In Category: " + category_lowest + ", Group: " + "BBQSauce");
        fWrite.println("	");
        Command[7] = input.next();
        fWrite.println("- Command: " + Command[7]);
        fWrite.println("	-> Developed By: [Ghadeer Mohammed Nooh]");
        fWrite.println("	-> University ID: [2006705]");
        fWrite.println("	-> Section: [DAR]");
        fWrite.println("	");
        fWrite.println("Thank You! :)");
        Date date = new Date();
        fWrite.println("Report generated on " + date.toString());


        fWrite.flush();
        fWrite.close();

    }
}
