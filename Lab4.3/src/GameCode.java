import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameCode extends Application
{
	private int score;
	private String kScore;
	private String kTime;
	private long starttime;
	private boolean isPressed = false;
	
	public static void main(String[] args) 
	{
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) 
	{
        primaryStage.setTitle("Wack-a-Button");
        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(350);
        btn.setLayoutY(350); 
        btn.setStyle("-fx-background-color: gold; -fx-font-weight: bold; -fx-stroke: white; -fx-padding:15; -fx-font-size:18;");
        Text text = new Text(702, 770, kScore);
        Text tTime = new Text(702, 790, kTime);
        text.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        tTime.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
               
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
        	int randomX = 0;
        	int randomY = 0;
            @Override
            public void handle(ActionEvent event) 
            {
            	randomX = 0 + (int)(Math.random() * 600);
            	randomY = 0 + (int)(Math.random() * 730);
            	btn.setLayoutX(randomX);
                btn.setLayoutY(randomY);
                score++;
                kScore = "Score: " + score;
                text.setText(kScore);
                text.setFill(Color.WHITE);
                tTime.setFill(Color.WHITE);
                if (!isPressed)
                {
                	starttime = System.nanoTime();
                	new AnimationTimer()
                    {
                    	public void handle(long now)
                    	{
                    		if (now - 10E9 > starttime)
                    		{
                    			btn.setDisable(true);
                    		}
                    		else
                    		{
                                kTime = "Time: " + String.valueOf(((now - starttime)/10E8));
                    			tTime.setText(kTime);
                    		}
                    	}
                    }.start();
                }
                isPressed = true;
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        root.getChildren().add(tTime);
        root.setStyle("-fx-background-color: transparent;");
        primaryStage.setScene(new Scene(root, 800, 800, Color.BLACK));
        root.getChildren().add(text);
        primaryStage.show();
    }
}


