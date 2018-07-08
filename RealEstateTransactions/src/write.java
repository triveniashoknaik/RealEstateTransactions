
public class write 
{
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
