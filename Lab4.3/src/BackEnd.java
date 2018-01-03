import java.io.BufferedReader; 
import java.io.IOException; 
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
		 List<HighScore> scores = readScoresFromCSV("highscores.csv");
		 
		 int place = 0;
		 for (HighScore s : scores)
		 {
			 place++;
			 System.out.print(place + ". ");
			 System.out.println(s);
		 }
	 }
	 
	 private static List<HighScore> readScoresFromCSV(String fileName)
	 {
		 List<HighScore> scores = new ArrayList<>();
		 Path pathToFile = Paths.get(fileName);
		 
		 try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		 {
			 String line = br.readLine();
			 
			 while (line != null)
			 {
				 String[] attributes = line.split(","); 
				 
				 HighScore score = createScore(attributes);
				 
				 scores.add(score);
				 
				 line = br.readLine();
			 }
		 } 
		 
		 catch (IOException ioe)
		 {
			 ioe.printStackTrace();
		 }
		 return scores;
	 }
	 
	 private static HighScore createScore(String[] metadata)
	 {
		 String name = metadata[0];
		 int score = Integer.parseInt(metadata[1]);
		 
		 return new HighScore(name, score);
	 }
}

class HighScore
{
	private String name;
	private int score;
	
	public HighScore(String name, int score)
	{
		this.name = name;
		this.score = score;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}

	@Override
	public String toString() 
	{
		return "[Name: " + name + ", Score: " + score + "]";
	}
}
