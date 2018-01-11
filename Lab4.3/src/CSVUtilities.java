import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lab 4.2
 * @author Jaron Huang
 * 1/8/18
 */
public class CSVUtilities 
{
	private ArrayList<String> CSVData = new ArrayList<String>();
	private int numColumns;
	
	public CSVUtilities(File csv) throws IOException
	{
		FileReader csvF = new FileReader(csv);
		
		try (BufferedReader br = new BufferedReader(csvF))
		{
			String line = br.readLine();
			while (line != null)
			{
				this.CSVData.add(line);
            	line = br.readLine();
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public ArrayList<String> getCSVData() {
		return CSVData;
	}

	public void setCSVData(ArrayList<String> cSVData) {
		CSVData = cSVData;
	}

	public List<String> getColumnHeaders()
	{
		return Arrays.asList(CSVData.get(0).split(","));
	}
	
	public List<String> getDataString(int column)
	{
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(hold[column]);
		}
		return data;
	}
	
	public List<Integer> getDataInteger(int column)
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(Integer.parseInt(hold[column]));
		}
		return data;
	}
	
	public List<Double> getDataDouble(int column)
	{
		ArrayList<Double> data = new ArrayList<Double>();
		for (int i = 1; i < CSVData.size(); i++)
		{
			String[] hold = CSVData.get(i).split(",");
			data.add(Double.parseDouble(hold[column]));
		}
		return data;
	}
	
}