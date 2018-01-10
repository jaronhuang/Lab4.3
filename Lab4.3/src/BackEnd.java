import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
	public static void main(String[] args)
	{
		 
	}
	 
	public void writeCSV()
	{
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new File("highscores.csv"));
		}
		catch (FileNotFoundException e)
		{
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Name,HighScore\n");
		sb.append("Jaron,999\n");
		pw.write(sb.toString());
		pw.close();
	}
}
