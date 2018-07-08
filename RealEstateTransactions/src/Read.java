import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Read 
{
	public static void main(String[] args)  
	{	
		String filename = "Sacramentorealestatetransactions.csv";
		File file = new File(filename);
		Scanner inputStream;
		try {
			inputStream = new Scanner(file);
			inputStream.nextLine();
			double sum = 0;
			double noofestates = 0;
			while(inputStream.hasNextLine())
			{
				String data = inputStream.nextLine();
				String[] cost = data.split(",");
				double price = Double.parseDouble(cost[9].trim());
				sum += price;
				noofestates++;
				System.out.println(price);
			}
			inputStream.close();
			double answer = sum / noofestates;
			System.out.println("Average = " + (sum / noofestates));
			calculate(sum,noofestates,answer,filename);

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	public static void calculate(Double sum, Double noofestates, Double answer, String filename)
	{
		try
		{
			FileWriter fw = new FileWriter(filename,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(sum+","+answer+","+noofestates);
			pw.flush();
			pw.close();
			
			JOptionPane.showMessageDialog(null,"record_saved");
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"record_not_saved");
		}
		
		
	}

}
