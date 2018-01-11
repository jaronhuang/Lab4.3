import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

public class BackEnd 
{
	static File file = new File("highscores.csv");
	
	 
	public static void writeCSV(String name, int score)
	{
		CSVUtilities csv = null;
		try 
		{
			csv = new CSVUtilities(file);
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int line = 0;
		List<Integer> scorez = csv.getDataInteger(1);
		for (int i = 0; i < scorez.size(); i++)
		{
			if (scorez.get(i) < score)
			{
				line = i + 1;
			}
		}
		csv.getCSVData().add(line, name + "," + score);
		FileWriter pw = null;
		try {
			Files.write(Paths.get("highscores.csv"), csv.getCSVData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
