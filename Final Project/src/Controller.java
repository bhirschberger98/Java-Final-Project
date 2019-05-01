import java.io.File;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Controller {
	private Card[] cards=new Card[52];
    
    @FXML
    private Button Refresh;

    @FXML
    private Button Verify;

    @FXML
    private Button Solution;

    @FXML
    private TextField Output;

    @FXML
    private TextField Input;

    @FXML
    private Text Expression;
	
    @FXML
    private ImageView card1=new ImageView();

    @FXML
    private ImageView card2=new ImageView();

    @FXML
    private ImageView card3=new ImageView();

    @FXML
    private ImageView card4=new ImageView();
    
    private double a;
    
    private double b;
    
    private double c;
    
    private double d;
    
    private int w;
    
    private int x;
    
    private int y;
    
    private int z;

	//loads in cards when program is loaded
	public Controller(){
		File[] files = new File("PlayingCards/").listFiles();
		for(int i=0;i<cards.length;i++) {
			int value=0;
			try {
				value=Integer.parseInt(files[i].getName().substring(0, files[i].getName().indexOf("_")));
			}
			catch(NumberFormatException e) {
				switch(files[i].getName().substring(0, files[i].getName().indexOf("_"))){
				case "ace":
					value=1;
					break;
				case "jack":
					value=11;
					break;
				case "queen":
					value=12;
					break;
				case "king":
					value=13;
					break;
				}
			}
			cards[i]=new Card(new Image(files[i].toURI().toString()),value);
		}

	}
	
	public void displayCards() {
		w = new Random().nextInt(51);
		x = new Random().nextInt(51);
		y = new Random().nextInt(51);
		z = new Random().nextInt(51);
		card1.setImage(cards[w].getImage());
		card2.setImage(cards[x].getImage());
		card3.setImage(cards[y].getImage());
		card4.setImage(cards[z].getImage());
		

	}

	public void checkExpression(ActionEvent event) {
		//Checks that the card values are present in the equation
				if(Input.getText().contains(cards[w].getValue().toString())	
						&& Input.getText().contains(cards[x].getValue().toString())
						&& Input.getText().contains(cards[y].getValue().toString())
						&& Input.getText().contains(cards[z].getValue().toString())) 
				{
					if (Input.getText() == null) // In case the user does not enter any sort of expression
						Output.setText("Please Enter An Expression");
					else if (solve(Input.getText()) == 24) //Checks that the equation equals 24
						Output.setText("Correct!");
					else
						Output.setText("Incorrect!");
				}
				else
					Output.setText("Incorrect numbers used");
	}
	
	public int solve(String eq) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		String str;

		try {
			str = engine.eval(eq).toString();
			double doubleResult = Double.parseDouble(str);
			return (int)doubleResult;
		} catch (ScriptException ex) {}
		return 0;
	}

	
	public void findSolution(ActionEvent event) {
		
		// Value Of Card #1
		if (w >= 0 && w <= 3) {
			a = 10;
		}
		else if (w >= 4 && w <= 7) {
			a = 2;
		}
		else if (w >= 8 && w <= 11) {
			a = 3;
		}
		else if (w >= 12 && w <= 15) {
			a = 4;
		}
		else if (w >= 16 && w <= 19) {
			a = 5;
		}
		else if (w >= 20 && w <= 23) {
			a = 6;
		}
		else if (w >= 24 && w <= 27) {
			a = 7;
		}
		else if (w >= 28 && w <= 31) {
			a = 8;
		}
		else if (w >= 32 && w <= 35) {
			a = 9;
		}
		else if (w >= 36 && w <= 39) {
			a = 1;
		}
		else if (w >= 40 && w <= 43) {
			a = 11;
		}
		else if (w >= 44 && w <= 47) {
			a = 13;
		}
		else if (w >= 48 && w <= 51) {
			a = 12;
		}
		
		// Value Of Card #2
		if (x >= 0 && x <= 3) {
			b = 10;
		}
		else if (x >= 4 && x <= 7) {
			b = 2;
		}
		else if (x >= 8 && x <= 11) {
			b = 3;
		}
		else if (x >= 12 && x <= 15) {
			b = 4;
		}
		else if (x >= 16 && x <= 19) {
			b = 5;
		}
		else if (x >= 20 && x <= 23) {
			b = 6;
		}
		else if (x >= 24 && x <= 27) {
			b = 7;
		}
		else if (x >= 28 && x <= 31) {
			b = 8;
		}
		else if (x >= 32 && x <= 35) {
			b = 9;
		}
		else if (x >= 36 && x <= 39) {
			b = 1;
		}
		else if (x >= 40 && x <= 43) {
			b = 11;
		}
		else if (x >= 44 && x <= 47) {
			b = 13;
		}
		else if (x >= 48 && x <= 51) {
			b = 12;
		}

		// Value Of Card #3
		if (y >= 0 && y <= 3) {
			c = 10;
		}
		else if (y >= 4 && y <= 7) {
			c = 2;
		}
		else if (y >= 8 && y <= 11) {
			c = 3;
		}
		else if (y >= 12 && y <= 15) {
			c = 4;
		}
		else if (y >= 16 && y <= 19) {
			c = 5;
		}
		else if (y >= 20 && y <= 23) {
			c = 6;
		}
		else if (y >= 24 && y <= 27) {
			c = 7;
		}
		else if (y >= 28 && y <= 31) {
			c = 8;
		}
		else if (y >= 32 && y <= 35) {
			c = 9;
		}
		else if (y >= 36 && y <= 39) {
			c = 1;
		}
		else if (y >= 40 && y <= 43) {
			c = 11;
		}
		else if (y >= 44 && y <= 47) {
			c = 13;
		}
		else if (y >= 48 && y <= 51) {
			c = 12;
		}

		// Value Of Card #4
		if (z >= 0 && z <= 3) {
			d = 10;
		}
		else if (z >= 4 && z <= 7) {
			d = 2;
		}
		else if (z >= 8 && z <= 11) {
			d = 3;
		}
		else if (z >= 12 && z <= 15) {
			d = 4;
		}
		else if (z >= 16 && z <= 19) {
			d = 5;
		}
		else if (z >= 20 && z <= 23) {
			d = 6;
		}
		else if (z >= 24 && z <= 27) {
			d = 7;
		}
		else if (z >= 28 && z <= 31) {
			d = 8;
		}
		else if (z >= 32 && z <= 35) {
			d = 9;
		}
		else if (z >= 36 && z <= 39) {
			d = 1;
		}
		else if (z >= 40 && z <= 43) {
			d = 11;
		}
		else if (z >= 44 && z <= 47) {
			d = 13;
		}
		else if (z >= 48 && z <= 51) {
			d = 12;
		}
		
		
		
		if ((a+b)+c+d == 24) {
			Output.setText("Try this equation: (" + a + " + " + b + ") + " + c + " + "  + d);
		}
			else if ((a+b)-c+d == 24) {
				Output.setText("Try this equation: (" + a + " + " + b + ") - " + c + " + "  + d);
			}
				else if ((a+b)-c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") - " + c + " - "  + d);
				}
				else if ((a+b)-c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") - " + c + " / "  + d);
				}
				else if ((a+b)-c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") - " + c + " * "  + d);
				}
			else if ((a+b)/c+d == 24) {
				Output.setText("Try this equation: (" + a + " + " + b + ") / " + c + " + "  + d);
			}
				else if ((a+b)/c-d == 24){
					Output.setText("Try this equation: (" + a + " + " + b + ") / " + c + " - "  + d);
				}
				else if ((a+b)/c/d == 24){
					Output.setText("Try this equation: (" + a + " + " + b + ") / " + c + " / "  + d);
				}
				else if ((a+b)/c*d == 24){
					Output.setText("Try this equation: (" + a + " + " + b + ") / " + c + " * "  + d);
				}
				
			else if ((a+b)*c+d == 24) {
				Output.setText("Try this equation: (" + a + " + " + b + ") * " + c + " + "  + d);
			}
				else if ((a+b)*c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") * " + c + " - "  + d);
				}
				else if ((a+b)*c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") * " + c + " / "  + d);
				}
				else if ((a+b)*c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " + " + b + ") * " + c + " * "  + d);
				}
		

		
				else if ((a-b)+c+d == 24) {
			Output.setText("Try this equation: (" + a + " - " + b + ") + " + c + " + "  + d);
		}
			else if ((a-b)-c+d == 24) {
				Output.setText("Try this equation: (" + a + " - " + b + ") - " + c + " + "  + d);
			}
				else if ((a-b)-c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") - " + c + " - "  + d);
				}
				else if ((a-b)-c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") - " + c + " / "  + d);
				}
				else if ((a-b)-c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") - " + c + " * "  + d);
				}
			else if ((a-b)/c+d == 24) {
				Output.setText("Try this equation: (" + a + " - " + b + ") / " + c + " + "  + d);
			}
				else if ((a-b)/c-d == 24){
					Output.setText("Try this equation: (" + a + " - " + b + ") / " + c + " - "  + d);
				}
				else if ((a-b)/c/d == 24){
					Output.setText("Try this equation: (" + a + " - " + b + ") / " + c + " / "  + d);
				}
				else if ((a-b)/c*d == 24){
					Output.setText("Try this equation: (" + a + " - " + b + ") / " + c + " * "  + d);
				}
				
			else if ((a-b)*c+d == 24) {
				Output.setText("Try this equation: (" + a + " - " + b + ") * " + c + " + "  + d);
			}
				else if ((a-b)*c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") * " + c + " - "  + d);
				}
				else if ((a-b)*c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") * " + c + " / "  + d);
				}
				else if ((a-b)*c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " - " + b + ") * " + c + " * "  + d);
				}
		
		
				else if ((a/b)+c+d == 24) {
			Output.setText("Try this equation: (" + a + " / " + b + ") + " + c + " + "  + d);
		}
			else if ((a/b)-c+d == 24) {
				Output.setText("Try this equation: (" + a + " / " + b + ") - " + c + " + "  + d);
			}
				else if ((a/b)-c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") - " + c + " - "  + d);
				}
				else if ((a/b)-c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") - " + c + " / "  + d);
				}
				else if ((a/b)-c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") - " + c + " * "  + d);
				}
			else if ((a/b)/c+d == 24) {
				Output.setText("Try this equation: (" + a + " / " + b + ") / " + c + " + "  + d);
			}
				else if ((a/b)/c-d == 24){
					Output.setText("Try this equation: (" + a + " / " + b + ") / " + c + " - "  + d);
				}
				else if ((a/b)/c/d == 24){
					Output.setText("Try this equation: (" + a + " / " + b + ") / " + c + " / "  + d);
				}
				else if ((a/b)/c*d == 24){
					Output.setText("Try this equation: (" + a + " / " + b + ") / " + c + " * "  + d);
				}
				
			else if ((a/b)*c+d == 24) {
				Output.setText("Try this equation: (" + a + " / " + b + ") * " + c + " + "  + d);
			}
				else if ((a/b)*c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") * " + c + " - "  + d);
				}
				else if ((a/b)*c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") * " + c + " / "  + d);
				}
				else if ((a/b)*c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " / " + b + ") * " + c + " * "  + d);
				}
		

		
		
				else if ((a*b)+c+d == 24) {
			Output.setText("Try this equation: (" + a + " * " + b + ") + " + c + " + "  + d);
		}
			else if ((a*b)-c+d == 24) {
				Output.setText("Try this equation: (" + a + " * " + b + ") - " + c + " + "  + d);
			}
				else if ((a*b)-c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + ") - " + c + " - "  + d);
				}
				else if ((a*b)-c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + ") - " + c + " / "  + d);
				}
				else if ((a*b)-c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + ") - " + c + " * "  + d);
				}
			else if ((a*b)/c+d == 24) {
				Output.setText("Try this equation: (" + a + " * " + b + ") / " + c + " + "  + d);
			}
				else if ((a*b)/c-d == 24){
					Output.setText("Try this equation: (" + a + " * " + b + ") / " + c + " - "  + d);
				}
				else if ((a*b)/c/d == 24){
					Output.setText("Try this equation: (" + a + " * " + b + ") / " + c + " / "  + d);
				}
				else if ((a*b)/c*d == 24){
					Output.setText("Try this equation: (" + a + " * " + b + ") / " + c + " * "  + d);
				}
				
			else if ((a*b)*c+d == 24) {
				Output.setText("Try this equation: (" + a + " * " + b + ") * " + c + " + "  + d);
			}
				else if ((a*b)*c-d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + ") * " + c + " - "  + d);
				}
				else if ((a*b)*c/d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + ") * " + c + " / "  + d);
				}
				else if ((a*b)*c*d == 24)
				{
					Output.setText("Try this equation: (" + a + " * " + b + " )* " + c + " * "  + d);
				}
		
		
		
		
		
		
		
		
		
				else if (a+b+(c+d) == 24) {
			Output.setText("Try this equation: " + a + " + " + b + " + (" + c + " + "  + d + ")");
		}
			else if (a+b-(c+d) == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " - (" + c + " + "  + d + ")");
			}
				else if (a+b-(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - (" + c + " - "  + d + ")");
				}
				else if (a+b-(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - (" + c + " / "  + d + ")");
				}
				else if (a+b-(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - (" + c + " * "  + d + ")");
				}
			else if (a+b/(c+d) == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " / (" + c + " + "  + d + ")");
			}
				else if (a+b/(c-d) == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / (" + c + " - "  + d + ")");
				}
				else if (a+b/(c/d) == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / (" + c + " / "  + d + ")");
				}
				else if (a+b/(c*d) == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / (" + c + " * "  + d + ")");
				}
				
			else if (a+b*(c+d) == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " * (" + c + " + "  + d + ")");
			}
				else if (a+b*(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * (" + c + " - "  + d + ")");
				}
				else if (a+b*(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * (" + c + " / "  + d + ")");
				}
				else if (a+b*(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * (" + c + " * "  + d + ")");
				}
		

		
				else if (a-b+(c+d) == 24) {
			Output.setText("Try this equation: " + a + " - " + b + " + (" + c + " + "  + d + ")");
		}
			else if (a-b-(c+d) == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " - (" + c + " + "  + d + ")");
			}
				else if (a-b-(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - (" + c + " - "  + d + ")");
				}
				else if (a-b-(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - (" + c + " / "  + d + ")");
				}
				else if (a-b-(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - (" + c + " * "  + d + ")");
				}
			else if (a-b/(c+d) == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " / (" + c + " + "  + d + ")");
			}
				else if (a-b/(c-d) == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / (" + c + " - "  + d + ")");
				}
				else if (a-b/(c/d) == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / (" + c + " / "  + d + ")");
				}
				else if (a-b/(c*d) == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / (" + c + " * "  + d + ")");
				}
				
			else if (a-b*(c+d) == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " * (" + c + " + "  + d + ")");
			}
				else if (a-b*(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * (" + c + " - "  + d + ")");
				}
				else if (a-b*(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * (" + c + " / "  + d + ")");
				}
				else if (a-b*(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * (" + c + " * "  + d + ")");
				}
		
		
				else if (a/b+(c+d) == 24) {
			Output.setText("Try this equation: " + a + " / " + b + " + (" + c + " + "  + d + ")");
		}
			else if (a/b-(c+d) == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " - (" + c + " + "  + d + ")");
			}
				else if (a/b-(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - (" + c + " - "  + d + ")");
				}
				else if (a/b-(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - (" + c + " / "  + d + ")");
				}
				else if (a/b-(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - (" + c + " * "  + d + ")");
				}
			else if (a/b/(c+d) == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " / (" + c + " + "  + d + ")");
			}
				else if (a/b/(c-d) == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / (" + c + " - "  + d + ")");
				}
				else if (a/b/(c/d) == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / (" + c + " / "  + d + ")");
				}
				else if (a/b/(c*d) == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / (" + c + " * "  + d + ")");
				}
				
			else if (a/b*(c+d) == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " * (" + c + " + "  + d + ")");
			}
				else if (a/b*(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * (" + c + " - "  + d + ")");
				}
				else if (a/b*(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * (" + c + " / "  + d + ")");
				}
				else if (a/b*(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * (" + c + " * "  + d + ")");
				}
		

		
		
				else if (a*b+(c+d) == 24) {
			Output.setText("Try this equation: " + a + " * " + b + " + (" + c + " + "  + d + ")");
		}
			else if (a*b-(c+d) == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " - (" + c + " + "  + d + ")");
			}
				else if (a*b-(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - (" + c + " - "  + d + ")");
				}
				else if (a*b-(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - (" + c + " / "  + d + ")");
				}
				else if (a*b-(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - (" + c + " * "  + d + ")");
				}
			else if (a*b/(c+d) == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " / (" + c + " + "  + d + ")");
			}
				else if (a*b/(c-d) == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / (" + c + " - "  + d + ")");
				}
				else if (a*b/(c/d) == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / (" + c + " / "  + d + ")");
				}
				else if (a*b/(c*d) == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / (" + c + " * "  + d + ")");
				}
				
			else if (a*b*(c+d) == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " * (" + c + " + "  + d + ")");
			}
				else if (a*b*(c-d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * (" + c + " - "  + d + ")");
				}
				else if (a*b*(c/d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * (" + c + " / "  + d + ")");
				}
				else if (a*b*(c*d) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * (" + c + " * "  + d + ")");
				}
		
				else if ((c+a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " + " + a + ") + " + b + " + "  + d);
				}
					else if ((c+a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " + "  + d);
					}
						else if ((c+a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " - "  + d);
						}
						else if ((c+a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " / "  + d);
						}
						else if ((c+a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " * "  + d);
						}
					else if ((c+a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " + "  + d);
					}
						else if ((c+a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " - "  + d);
						}
						else if ((c+a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " / "  + d);
						}
						else if ((c+a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c+a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " + "  + d);
					}
						else if ((c+a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " - "  + d);
						}
						else if ((c+a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " / "  + d);
						}
						else if ((c+a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " * "  + d);
						}
				

				
						else if ((c-a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " - " + a + ") + " + b + " + "  + d);
				}
					else if ((c-a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " + "  + d);
					}
						else if ((c-a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " - "  + d);
						}
						else if ((c-a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " / "  + d);
						}
						else if ((c-a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " * "  + d);
						}
					else if ((c-a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " + "  + d);
					}
						else if ((c-a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " - "  + d);
						}
						else if ((c-a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " / "  + d);
						}
						else if ((c-a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c-a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " + "  + d);
					}
						else if ((c-a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " - "  + d);
						}
						else if ((c-a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " / "  + d);
						}
						else if ((c-a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " * "  + d);
						}
				
				
						else if ((c/a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " / " + a + ") + " + b + " + "  + d);
				}
					else if ((c/a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " + "  + d);
					}
						else if ((c/a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " - "  + d);
						}
						else if ((c/a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " / "  + d);
						}
						else if ((c/a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " * "  + d);
						}
					else if ((c/a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " + "  + d);
					}
						else if ((c/a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " - "  + d);
						}
						else if ((c/a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " / "  + d);
						}
						else if ((c/a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c/a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " + "  + d);
					}
						else if ((c/a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " - "  + d);
						}
						else if ((c/a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " / "  + d);
						}
						else if ((c/a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " * "  + d);
						}
				

				
				
						else if ((c*a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " * " + a + ") + " + b + " + "  + d);
				}
					else if ((c*a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " + "  + d);
					}
						else if ((c*a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " - "  + d);
						}
						else if ((c*a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " / "  + d);
						}
						else if ((c*a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " * "  + d);
						}
					else if ((c*a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " + "  + d);
					}
						else if ((c*a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " - "  + d);
						}
						else if ((c*a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " / "  + d);
						}
						else if ((c*a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c*a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " + "  + d);
					}
						else if ((c*a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " - "  + d);
						}
						else if ((c*a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " / "  + d);
						}
						else if ((c*a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + " )* " + b + " * "  + d);
						}
				
				
				
				
				
				
				
				
				
						else if (c+a+(b+d) == 24) {
					Output.setText("Try this equation: " + c + " + " + a + " + (" + b + " + "  + d + ")");
				}
					else if (c+a-(b+d) == 24) {
						Output.setText("Try this equation: " + c + " + " + a + " - (" + b + " + "  + d + ")");
					}
						else if (c+a-(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " - (" + b + " - "  + d + ")");
						}
						else if (c+a-(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " - (" + b + " / "  + d + ")");
						}
						else if (c+a-(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " - (" + b + " * "  + d + ")");
						}
					else if (c+a/(b+d) == 24) {
						Output.setText("Try this equation: " + c + " + " + a + " / (" + b + " + "  + d + ")");
					}
						else if (c+a/(b-d) == 24){
							Output.setText("Try this equation: " + c + " + " + a + " / (" + b + " - "  + d + ")");
						}
						else if (c+a/(b/d) == 24){
							Output.setText("Try this equation: " + c + " + " + a + " / (" + b + " / "  + d + ")");
						}
						else if (c+a/(b*d) == 24){
							Output.setText("Try this equation: " + c + " + " + a + " / (" + b + " * "  + d + ")");
						}
						
					else if (c+a*(b+d) == 24) {
						Output.setText("Try this equation: " + c + " + " + a + " * (" + b + " + "  + d + ")");
					}
						else if (c+a*(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " * (" + b + " - "  + d + ")");
						}
						else if (c+a*(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " * (" + b + " / "  + d + ")");
						}
						else if (c+a*(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " + " + a + " * (" + b + " * "  + d + ")");
						}
				

				
						else if (c-a+(b+d) == 24) {
					Output.setText("Try this equation: " + c + " - " + a + " + (" + b + " + "  + d + ")");
				}
					else if (c-a-(b+d) == 24) {
						Output.setText("Try this equation: " + c + " - " + a + " - (" + b + " + "  + d + ")");
					}
						else if (c-a-(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " - (" + b + " - "  + d + ")");
						}
						else if (c-a-(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " - (" + b + " / "  + d + ")");
						}
						else if (c-a-(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " - (" + b + " * "  + d + ")");
						}
					else if (c-a/(b+d) == 24) {
						Output.setText("Try this equation: " + c + " - " + a + " / (" + b + " + "  + d + ")");
					}
						else if (c-a/(b-d) == 24){
							Output.setText("Try this equation: " + c + " - " + a + " / (" + b + " - "  + d + ")");
						}
						else if (c-a/(b/d) == 24){
							Output.setText("Try this equation: " + c + " - " + a + " / (" + b + " / "  + d + ")");
						}
						else if (c-a/(b*d) == 24){
							Output.setText("Try this equation: " + c + " - " + a + " / (" + b + " * "  + d + ")");
						}
						
					else if (c-a*(b+d) == 24) {
						Output.setText("Try this equation: " + c + " - " + a + " * (" + b + " + "  + d + ")");
					}
						else if (c-a*(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " * (" + b + " - "  + d + ")");
						}
						else if (c-a*(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " * (" + b + " / "  + d + ")");
						}
						else if (c-a*(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " - " + a + " * (" + b + " * "  + d + ")");
						}
				
				
						else if (c/a+(b+d) == 24) {
					Output.setText("Try this equation: " + c + " / " + a + " + (" + b + " + "  + d + ")");
				}
					else if (c/a-(b+d) == 24) {
						Output.setText("Try this equation: " + c + " / " + a + " - (" + b + " + "  + d + ")");
					}
						else if (c/a-(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " - (" + b + " - "  + d + ")");
						}
						else if (c/a-(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " - (" + b + " / "  + d + ")");
						}
						else if (c/a-(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " - (" + b + " * "  + d + ")");
						}
					else if (c/a/(b+d) == 24) {
						Output.setText("Try this equation: " + c + " / " + a + " / (" + b + " + "  + d + ")");
					}
						else if (c/a/(b-d) == 24){
							Output.setText("Try this equation: " + c + " / " + a + " / (" + b + " - "  + d + ")");
						}
						else if (c/a/(b/d) == 24){
							Output.setText("Try this equation: " + c + " / " + a + " / (" + b + " / "  + d + ")");
						}
						else if (c/a/(b*d) == 24){
							Output.setText("Try this equation: " + c + " / " + a + " / (" + b + " * "  + d + ")");
						}
						
					else if (c/a*(b+d) == 24) {
						Output.setText("Try this equation: " + c + " / " + a + " * (" + b + " + "  + d + ")");
					}
						else if (c/a*(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " * (" + b + " - "  + d + ")");
						}
						else if (c/a*(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " * (" + b + " / "  + d + ")");
						}
						else if (c/a*(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " / " + a + " * (" + b + " * "  + d + ")");
						}
				

				
				
						else if (c*a+(b+d) == 24) {
					Output.setText("Try this equation: " + c + " * " + a + " + (" + b + " + "  + d + ")");
				}
					else if (c*a-(b+d) == 24) {
						Output.setText("Try this equation: " + c + " * " + a + " - (" + b + " + "  + d + ")");
					}
						else if (c*a-(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " - (" + b + " - "  + d + ")");
						}
						else if (c*a-(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " - (" + b + " / "  + d + ")");
						}
						else if (c*a-(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " - (" + b + " * "  + d + ")");
						}
					else if (c*a/(b+d) == 24) {
						Output.setText("Try this equation: " + c + " * " + a + " / (" + b + " + "  + d + ")");
					}
						else if (c*a/(b-d) == 24){
							Output.setText("Try this equation: " + c + " * " + a + " / (" + b + " - "  + d + ")");
						}
						else if (c*a/(b/d) == 24){
							Output.setText("Try this equation: " + c + " * " + a + " / (" + b + " / "  + d + ")");
						}
						else if (c*a/(b*d) == 24){
							Output.setText("Try this equation: " + c + " * " + a + " / (" + b + " * "  + d + ")");
						}
						
					else if (c*a*(b+d) == 24) {
						Output.setText("Try this equation: " + c + " * " + a + " * (" + b + " + "  + d + ")");
					}
						else if (c*a*(b-d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " * (" + b + " - "  + d + ")");
						}
						else if (c*a*(b/d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " * (" + b + " / "  + d + ")");
						}
						else if (c*a*(b*d) == 24)
						{
							Output.setText("Try this equation: " + c + " * " + a + " * (" + b + " * "  + d + ")");
						}

		
		
						else if ((b+d)+c+a == 24) {
							Output.setText("Try this equation: (" + b + " + " + d + ") + " + c + " + "  + a);
						}
							else if ((b+d)-c+a == 24) {
								Output.setText("Try this equation: (" + b + " + " + d + ") - " + c + " + "  + a);
							}
								else if ((b+d)-c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") - " + c + " - "  + a);
								}
								else if ((b+d)-c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") - " + c + " / "  + a);
								}
								else if ((b+d)-c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") - " + c + " * "  + a);
								}
							else if ((b+d)/c+a == 24) {
								Output.setText("Try this equation: (" + b + " + " + d + ") / " + c + " + "  + a);
							}
								else if ((b+d)/c-a == 24){
									Output.setText("Try this equation: (" + b + " + " + d + ") / " + c + " - "  + a);
								}
								else if ((b+d)/c/a == 24){
									Output.setText("Try this equation: (" + b + " + " + d + ") / " + c + " / "  + a);
								}
								else if ((b+d)/c*a == 24){
									Output.setText("Try this equation: (" + b + " + " + d + ") / " + c + " * "  + a);
								}
								
							else if ((b+d)*c+a == 24) {
								Output.setText("Try this equation: (" + b + " + " + d + ") * " + c + " + "  + a);
							}
								else if ((b+d)*c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") * " + c + " - "  + a);
								}
								else if ((b+d)*c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") * " + c + " / "  + a);
								}
								else if ((b+d)*c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " + " + d + ") * " + c + " * "  + a);
								}
						

						
								else if ((b-d)+c+a == 24) {
							Output.setText("Try this equation: (" + b + " - " + d + ") + " + c + " + "  + a);
						}
							else if ((b-d)-c+a == 24) {
								Output.setText("Try this equation: (" + b + " - " + d + ") - " + c + " + "  + a);
							}
								else if ((b-d)-c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") - " + c + " - "  + a);
								}
								else if ((b-d)-c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") - " + c + " / "  + a);
								}
								else if ((b-d)-c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") - " + c + " * "  + a);
								}
							else if ((b-d)/c+a == 24) {
								Output.setText("Try this equation: (" + b + " - " + d + ") / " + c + " + "  + a);
							}
								else if ((b-d)/c-a == 24){
									Output.setText("Try this equation: (" + b + " - " + d + ") / " + c + " - "  + a);
								}
								else if ((b-d)/c/a == 24){
									Output.setText("Try this equation: (" + b + " - " + d + ") / " + c + " / "  + a);
								}
								else if ((b-d)/c*a == 24){
									Output.setText("Try this equation: (" + b + " - " + d + ") / " + c + " * "  + a);
								}
								
							else if ((b-d)*c+a == 24) {
								Output.setText("Try this equation: (" + b + " - " + d + ") * " + c + " + "  + a);
							}
								else if ((b-d)*c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") * " + c + " - "  + a);
								}
								else if ((b-d)*c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") * " + c + " / "  + a);
								}
								else if ((b-d)*c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " - " + d + ") * " + c + " * "  + a);
								}
						
						
								else if ((b/d)+c+a == 24) {
							Output.setText("Try this equation: (" + b + " / " + d + ") + " + c + " + "  + a);
						}
							else if ((b/d)-c+a == 24) {
								Output.setText("Try this equation: (" + b + " / " + d + ") - " + c + " + "  + a);
							}
								else if ((b/d)-c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") - " + c + " - "  + a);
								}
								else if ((b/d)-c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") - " + c + " / "  + a);
								}
								else if ((b/d)-c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") - " + c + " * "  + a);
								}
							else if ((b/d)/c+a == 24) {
								Output.setText("Try this equation: (" + b + " / " + d + ") / " + c + " + "  + a);
							}
								else if ((b/d)/c-a == 24){
									Output.setText("Try this equation: (" + b + " / " + d + ") / " + c + " - "  + a);
								}
								else if ((b/d)/c/a == 24){
									Output.setText("Try this equation: (" + b + " / " + d + ") / " + c + " / "  + a);
								}
								else if ((b/d)/c*a == 24){
									Output.setText("Try this equation: (" + b + " / " + d + ") / " + c + " * "  + a);
								}
								
							else if ((b/d)*c+a == 24) {
								Output.setText("Try this equation: (" + b + " / " + d + ") * " + c + " + "  + a);
							}
								else if ((b/d)*c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") * " + c + " - "  + a);
								}
								else if ((b/d)*c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") * " + c + " / "  + a);
								}
								else if ((b/d)*c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " / " + d + ") * " + c + " * "  + a);
								}
						

						
						
								else if ((b*d)+c+a == 24) {
							Output.setText("Try this equation: (" + b + " * " + d + ") + " + c + " + "  + a);
						}
							else if ((b*d)-c+a == 24) {
								Output.setText("Try this equation: (" + b + " * " + d + ") - " + c + " + "  + a);
							}
								else if ((b*d)-c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + ") - " + c + " - "  + a);
								}
								else if ((b*d)-c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + ") - " + c + " / "  + a);
								}
								else if ((b*d)-c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + ") - " + c + " * "  + a);
								}
							else if ((b*d)/c+a == 24) {
								Output.setText("Try this equation: (" + b + " * " + d + ") / " + c + " + "  + a);
							}
								else if ((b*d)/c-a == 24){
									Output.setText("Try this equation: (" + b + " * " + d + ") / " + c + " - "  + a);
								}
								else if ((b*d)/c/a == 24){
									Output.setText("Try this equation: (" + b + " * " + d + ") / " + c + " / "  + a);
								}
								else if ((b*d)/c*a == 24){
									Output.setText("Try this equation: (" + b + " * " + d + ") / " + c + " * "  + a);
								}
								
							else if ((b*d)*c+a == 24) {
								Output.setText("Try this equation: (" + b + " * " + d + ") * " + c + " + "  + a);
							}
								else if ((b*d)*c-a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + ") * " + c + " - "  + a);
								}
								else if ((b*d)*c/a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + ") * " + c + " / "  + a);
								}
								else if ((b*d)*c*a == 24)
								{
									Output.setText("Try this equation: (" + b + " * " + d + " )* " + c + " * "  + a);
								}

								else if ((a+d)+c+b == 24) {
									Output.setText("Try this equation: (" + a + " + " + d + ") + " + c + " + "  + b);
								}
									else if ((a+d)-c+b == 24) {
										Output.setText("Try this equation: (" + a + " + " + d + ") - " + c + " + "  + b);
									}
										else if ((a+d)-c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") - " + c + " - "  + b);
										}
										else if ((a+d)-c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") - " + c + " / "  + b);
										}
										else if ((a+d)-c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") - " + c + " * "  + b);
										}
									else if ((a+d)/c+b == 24) {
										Output.setText("Try this equation: (" + a + " + " + d + ") / " + c + " + "  + b);
									}
										else if ((a+d)/c-b == 24){
											Output.setText("Try this equation: (" + a + " + " + d + ") / " + c + " - "  + b);
										}
										else if ((a+d)/c/b == 24){
											Output.setText("Try this equation: (" + a + " + " + d + ") / " + c + " / "  + b);
										}
										else if ((a+d)/c*b == 24){
											Output.setText("Try this equation: (" + a + " + " + d + ") / " + c + " * "  + b);
										}
										
									else if ((a+d)*c+b == 24) {
										Output.setText("Try this equation: (" + a + " + " + d + ") * " + c + " + "  + b);
									}
										else if ((a+d)*c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") * " + c + " - "  + b);
										}
										else if ((a+d)*c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") * " + c + " / "  + b);
										}
										else if ((a+d)*c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " + " + d + ") * " + c + " * "  + b);
										}
								

								
										else if ((a-d)+c+b == 24) {
									Output.setText("Try this equation: (" + a + " - " + d + ") + " + c + " + "  + b);
								}
									else if ((a-d)-c+b == 24) {
										Output.setText("Try this equation: (" + a + " - " + d + ") - " + c + " + "  + b);
									}
										else if ((a-d)-c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") - " + c + " - "  + b);
										}
										else if ((a-d)-c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") - " + c + " / "  + b);
										}
										else if ((a-d)-c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") - " + c + " * "  + b);
										}
									else if ((a-d)/c+b == 24) {
										Output.setText("Try this equation: (" + a + " - " + d + ") / " + c + " + "  + b);
									}
										else if ((a-d)/c-b == 24){
											Output.setText("Try this equation: (" + a + " - " + d + ") / " + c + " - "  + b);
										}
										else if ((a-d)/c/b == 24){
											Output.setText("Try this equation: (" + a + " - " + d + ") / " + c + " / "  + b);
										}
										else if ((a-d)/c*b == 24){
											Output.setText("Try this equation: (" + a + " - " + d + ") / " + c + " * "  + b);
										}
										
									else if ((a-d)*c+b == 24) {
										Output.setText("Try this equation: (" + a + " - " + d + ") * " + c + " + "  + b);
									}
										else if ((a-d)*c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") * " + c + " - "  + b);
										}
										else if ((a-d)*c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") * " + c + " / "  + b);
										}
										else if ((a-d)*c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " - " + d + ") * " + c + " * "  + b);
										}
								
								
										else if ((a/d)+c+b == 24) {
									Output.setText("Try this equation: (" + a + " / " + d + ") + " + c + " + "  + b);
								}
									else if ((a/d)-c+b == 24) {
										Output.setText("Try this equation: (" + a + " / " + d + ") - " + c + " + "  + b);
									}
										else if ((a/d)-c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") - " + c + " - "  + b);
										}
										else if ((a/d)-c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") - " + c + " / "  + b);
										}
										else if ((a/d)-c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") - " + c + " * "  + b);
										}
									else if ((a/d)/c+b == 24) {
										Output.setText("Try this equation: (" + a + " / " + d + ") / " + c + " + "  + b);
									}
										else if ((a/d)/c-b == 24){
											Output.setText("Try this equation: (" + a + " / " + d + ") / " + c + " - "  + b);
										}
										else if ((a/d)/c/b == 24){
											Output.setText("Try this equation: (" + a + " / " + d + ") / " + c + " / "  + b);
										}
										else if ((a/d)/c*b == 24){
											Output.setText("Try this equation: (" + a + " / " + d + ") / " + c + " * "  + b);
										}
										
									else if ((a/d)*c+b == 24) {
										Output.setText("Try this equation: (" + a + " / " + d + ") * " + c + " + "  + b);
									}
										else if ((a/d)*c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") * " + c + " - "  + b);
										}
										else if ((a/d)*c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") * " + c + " / "  + b);
										}
										else if ((a/d)*c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " / " + d + ") * " + c + " * "  + b);
										}
								

								
								
										else if ((a*d)+c+b == 24) {
									Output.setText("Try this equation: (" + a + " * " + d + ") + " + c + " + "  + b);
								}
									else if ((a*d)-c+b == 24) {
										Output.setText("Try this equation: (" + a + " * " + d + ") - " + c + " + "  + b);
									}
										else if ((a*d)-c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + ") - " + c + " - "  + b);
										}
										else if ((a*d)-c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + ") - " + c + " / "  + b);
										}
										else if ((a*d)-c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + ") - " + c + " * "  + b);
										}
									else if ((a*d)/c+b == 24) {
										Output.setText("Try this equation: (" + a + " * " + d + ") / " + c + " + "  + b);
									}
										else if ((a*d)/c-b == 24){
											Output.setText("Try this equation: (" + a + " * " + d + ") / " + c + " - "  + b);
										}
										else if ((a*d)/c/b == 24){
											Output.setText("Try this equation: (" + a + " * " + d + ") / " + c + " / "  + b);
										}
										else if ((a*d)/c*b == 24){
											Output.setText("Try this equation: (" + a + " * " + d + ") / " + c + " * "  + b);
										}
										
									else if ((a*d)*c+b == 24) {
										Output.setText("Try this equation: (" + a + " * " + d + ") * " + c + " + "  + b);
									}
										else if ((a*d)*c-b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + ") * " + c + " - "  + b);
										}
										else if ((a*d)*c/b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + ") * " + c + " / "  + b);
										}
										else if ((a*d)*c*b == 24)
										{
											Output.setText("Try this equation: (" + a + " * " + d + " )* " + c + " * "  + b);
										}

		
		
		
		else if ((c+b)+a+d == 24) {
			Output.setText("Try this equation: (" + c + " + " + b + ") + " + a + " + "  + d);
		}
			else if ((c+b)-a+d == 24) {
				Output.setText("Try this equation: (" + c + " + " + b + ") - " + a + " + "  + d);
			}
				else if ((c+b)-a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") - " + a + " - "  + d);
				}
				else if ((c+b)-a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") - " + a + " / "  + d);
				}
				else if ((c+b)-a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") - " + a + " * "  + d);
				}
			else if ((c+b)/a+d == 24) {
				Output.setText("Try this equation: (" + c + " + " + b + ") / " + a + " + "  + d);
			}
				else if ((c+b)/a-d == 24){
					Output.setText("Try this equation: (" + c + " + " + b + ") / " + a + " - "  + d);
				}
				else if ((c+b)/a/d == 24){
					Output.setText("Try this equation: (" + c + " + " + b + ") / " + a + " / "  + d);
				}
				else if ((c+b)/a*d == 24){
					Output.setText("Try this equation: (" + c + " + " + b + ") / " + a + " * "  + d);
				}
				
			else if ((c+b)*a+d == 24) {
				Output.setText("Try this equation: (" + c + " + " + b + ") * " + a + " + "  + d);
			}
				else if ((c+b)*a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") * " + a + " - "  + d);
				}
				else if ((c+b)*a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") * " + a + " / "  + d);
				}
				else if ((c+b)*a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " + " + b + ") * " + a + " * "  + d);
				}
		

		
				else if ((c-b)+a+d == 24) {
			Output.setText("Try this equation: (" + c + " - " + b + ") + " + a + " + "  + d);
		}
			else if ((c-b)-a+d == 24) {
				Output.setText("Try this equation: (" + c + " - " + b + ") - " + a + " + "  + d);
			}
				else if ((c-b)-a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") - " + a + " - "  + d);
				}
				else if ((c-b)-a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") - " + a + " / "  + d);
				}
				else if ((c-b)-a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") - " + a + " * "  + d);
				}
			else if ((c-b)/a+d == 24) {
				Output.setText("Try this equation: (" + c + " - " + b + ") / " + a + " + "  + d);
			}
				else if ((c-b)/a-d == 24){
					Output.setText("Try this equation: (" + c + " - " + b + ") / " + a + " - "  + d);
				}
				else if ((c-b)/a/d == 24){
					Output.setText("Try this equation: (" + c + " - " + b + ") / " + a + " / "  + d);
				}
				else if ((c-b)/a*d == 24){
					Output.setText("Try this equation: (" + c + " - " + b + ") / " + a + " * "  + d);
				}
				
			else if ((c-b)*a+d == 24) {
				Output.setText("Try this equation: (" + c + " - " + b + ") * " + a + " + "  + d);
			}
				else if ((c-b)*a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") * " + a + " - "  + d);
				}
				else if ((c-b)*a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") * " + a + " / "  + d);
				}
				else if ((c-b)*a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " - " + b + ") * " + a + " * "  + d);
				}
		
		
				else if ((c/b)+a+d == 24) {
			Output.setText("Try this equation: (" + c + " / " + b + ") + " + a + " + "  + d);
		}
			else if ((c/b)-a+d == 24) {
				Output.setText("Try this equation: (" + c + " / " + b + ") - " + a + " + "  + d);
			}
				else if ((c/b)-a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") - " + a + " - "  + d);
				}
				else if ((c/b)-a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") - " + a + " / "  + d);
				}
				else if ((c/b)-a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") - " + a + " * "  + d);
				}
			else if ((c/b)/a+d == 24) {
				Output.setText("Try this equation: (" + c + " / " + b + ") / " + a + " + "  + d);
			}
				else if ((c/b)/a-d == 24){
					Output.setText("Try this equation: (" + c + " / " + b + ") / " + a + " - "  + d);
				}
				else if ((c/b)/a/d == 24){
					Output.setText("Try this equation: (" + c + " / " + b + ") / " + a + " / "  + d);
				}
				else if ((c/b)/a*d == 24){
					Output.setText("Try this equation: (" + c + " / " + b + ") / " + a + " * "  + d);
				}
				
			else if ((c/b)*a+d == 24) {
				Output.setText("Try this equation: (" + c + " / " + b + ") * " + a + " + "  + d);
			}
				else if ((c/b)*a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") * " + a + " - "  + d);
				}
				else if ((c/b)*a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") * " + a + " / "  + d);
				}
				else if ((c/b)*a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " / " + b + ") * " + a + " * "  + d);
				}
		

		
		
				else if ((c*b)+a+d == 24) {
			Output.setText("Try this equation: (" + c + " * " + b + ") + " + a + " + "  + d);
		}
			else if ((c*b)-a+d == 24) {
				Output.setText("Try this equation: (" + c + " * " + b + ") - " + a + " + "  + d);
			}
				else if ((c*b)-a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + ") - " + a + " - "  + d);
				}
				else if ((c*b)-a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + ") - " + a + " / "  + d);
				}
				else if ((c*b)-a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + ") - " + a + " * "  + d);
				}
			else if ((c*b)/a+d == 24) {
				Output.setText("Try this equation: (" + c + " * " + b + ") / " + a + " + "  + d);
			}
				else if ((c*b)/a-d == 24){
					Output.setText("Try this equation: (" + c + " * " + b + ") / " + a + " - "  + d);
				}
				else if ((c*b)/a/d == 24){
					Output.setText("Try this equation: (" + c + " * " + b + ") / " + a + " / "  + d);
				}
				else if ((c*b)/a*d == 24){
					Output.setText("Try this equation: (" + c + " * " + b + ") / " + a + " * "  + d);
				}
				
			else if ((c*b)*a+d == 24) {
				Output.setText("Try this equation: (" + c + " * " + b + ") * " + a + " + "  + d);
			}
				else if ((c*b)*a-d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + ") * " + a + " - "  + d);
				}
				else if ((c*b)*a/d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + ") * " + a + " / "  + d);
				}
				else if ((c*b)*a*d == 24)
				{
					Output.setText("Try this equation: (" + c + " * " + b + " )* " + a + " * "  + d);
				}
		
				else if ((c+a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " + " + a + ") + " + b + " + "  + d);
				}
					else if ((c+a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " + "  + d);
					}
						else if ((c+a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " - "  + d);
						}
						else if ((c+a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " / "  + d);
						}
						else if ((c+a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") - " + b + " * "  + d);
						}
					else if ((c+a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " + "  + d);
					}
						else if ((c+a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " - "  + d);
						}
						else if ((c+a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " / "  + d);
						}
						else if ((c+a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " + " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c+a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " + "  + d);
					}
						else if ((c+a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " - "  + d);
						}
						else if ((c+a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " / "  + d);
						}
						else if ((c+a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " + " + a + ") * " + b + " * "  + d);
						}
				

				
						else if ((c-a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " - " + a + ") + " + b + " + "  + d);
				}
					else if ((c-a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " + "  + d);
					}
						else if ((c-a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " - "  + d);
						}
						else if ((c-a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " / "  + d);
						}
						else if ((c-a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") - " + b + " * "  + d);
						}
					else if ((c-a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " + "  + d);
					}
						else if ((c-a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " - "  + d);
						}
						else if ((c-a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " / "  + d);
						}
						else if ((c-a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " - " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c-a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " + "  + d);
					}
						else if ((c-a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " - "  + d);
						}
						else if ((c-a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " / "  + d);
						}
						else if ((c-a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " - " + a + ") * " + b + " * "  + d);
						}
				
				
						else if ((c/a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " / " + a + ") + " + b + " + "  + d);
				}
					else if ((c/a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " + "  + d);
					}
						else if ((c/a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " - "  + d);
						}
						else if ((c/a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " / "  + d);
						}
						else if ((c/a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") - " + b + " * "  + d);
						}
					else if ((c/a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " + "  + d);
					}
						else if ((c/a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " - "  + d);
						}
						else if ((c/a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " / "  + d);
						}
						else if ((c/a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " / " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c/a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " + "  + d);
					}
						else if ((c/a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " - "  + d);
						}
						else if ((c/a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " / "  + d);
						}
						else if ((c/a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " / " + a + ") * " + b + " * "  + d);
						}
				

				
				
						else if ((c*a)+b+d == 24) {
					Output.setText("Try this equation: (" + c + " * " + a + ") + " + b + " + "  + d);
				}
					else if ((c*a)-b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " + "  + d);
					}
						else if ((c*a)-b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " - "  + d);
						}
						else if ((c*a)-b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " / "  + d);
						}
						else if ((c*a)-b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") - " + b + " * "  + d);
						}
					else if ((c*a)/b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " + "  + d);
					}
						else if ((c*a)/b-d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " - "  + d);
						}
						else if ((c*a)/b/d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " / "  + d);
						}
						else if ((c*a)/b*d == 24){
							Output.setText("Try this equation: (" + c + " * " + a + ") / " + b + " * "  + d);
						}
						
					else if ((c*a)*b+d == 24) {
						Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " + "  + d);
					}
						else if ((c*a)*b-d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " - "  + d);
						}
						else if ((c*a)*b/d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + ") * " + b + " / "  + d);
						}
						else if ((c*a)*b*d == 24)
						{
							Output.setText("Try this equation: (" + c + " * " + a + " )* " + b + " * "  + d);
						}

						else if ((d+a)+b+c == 24) {
							Output.setText("Try this equation: (" + d + " + " + a + ") + " + b + " + "  + c);
						}
							else if ((d+a)-b+c == 24) {
								Output.setText("Try this equation: (" + d + " + " + a + ") - " + b + " + "  + c);
							}
								else if ((d+a)-b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") - " + b + " - "  + c);
								}
								else if ((d+a)-b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") - " + b + " / "  + c);
								}
								else if ((d+a)-b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") - " + b + " * "  + c);
								}
							else if ((d+a)/b+c == 24) {
								Output.setText("Try this equation: (" + d + " + " + a + ") / " + b + " + "  + c);
							}
								else if ((d+a)/b-c == 24){
									Output.setText("Try this equation: (" + d + " + " + a + ") / " + b + " - "  + c);
								}
								else if ((d+a)/b/c == 24){
									Output.setText("Try this equation: (" + d + " + " + a + ") / " + b + " / "  + c);
								}
								else if ((d+a)/b*c == 24){
									Output.setText("Try this equation: (" + d + " + " + a + ") / " + b + " * "  + c);
								}
								
							else if ((d+a)*b+c == 24) {
								Output.setText("Try this equation: (" + d + " + " + a + ") * " + b + " + "  + c);
							}
								else if ((d+a)*b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") * " + b + " - "  + c);
								}
								else if ((d+a)*b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") * " + b + " / "  + c);
								}
								else if ((d+a)*b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " + " + a + ") * " + b + " * "  + c);
								}
						

						
								else if ((d-a)+b+c == 24) {
							Output.setText("Try this equation: (" + d + " - " + a + ") + " + b + " + "  + c);
						}
							else if ((d-a)-b+c == 24) {
								Output.setText("Try this equation: (" + d + " - " + a + ") - " + b + " + "  + c);
							}
								else if ((d-a)-b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") - " + b + " - "  + c);
								}
								else if ((d-a)-b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") - " + b + " / "  + c);
								}
								else if ((d-a)-b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") - " + b + " * "  + c);
								}
							else if ((d-a)/b+c == 24) {
								Output.setText("Try this equation: (" + d + " - " + a + ") / " + b + " + "  + c);
							}
								else if ((d-a)/b-c == 24){
									Output.setText("Try this equation: (" + d + " - " + a + ") / " + b + " - "  + c);
								}
								else if ((d-a)/b/c == 24){
									Output.setText("Try this equation: (" + d + " - " + a + ") / " + b + " / "  + c);
								}
								else if ((d-a)/b*c == 24){
									Output.setText("Try this equation: (" + d + " - " + a + ") / " + b + " * "  + c);
								}
								
							else if ((d-a)*b+c == 24) {
								Output.setText("Try this equation: (" + d + " - " + a + ") * " + b + " + "  + c);
							}
								else if ((d-a)*b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") * " + b + " - "  + c);
								}
								else if ((d-a)*b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") * " + b + " / "  + c);
								}
								else if ((d-a)*b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " - " + a + ") * " + b + " * "  + c);
								}
						
						
								else if ((d/a)+b+c == 24) {
							Output.setText("Try this equation: (" + d + " / " + a + ") + " + b + " + "  + c);
						}
							else if ((d/a)-b+c == 24) {
								Output.setText("Try this equation: (" + d + " / " + a + ") - " + b + " + "  + c);
							}
								else if ((d/a)-b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") - " + b + " - "  + c);
								}
								else if ((d/a)-b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") - " + b + " / "  + c);
								}
								else if ((d/a)-b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") - " + b + " * "  + c);
								}
							else if ((d/a)/b+c == 24) {
								Output.setText("Try this equation: (" + d + " / " + a + ") / " + b + " + "  + c);
							}
								else if ((d/a)/b-c == 24){
									Output.setText("Try this equation: (" + d + " / " + a + ") / " + b + " - "  + c);
								}
								else if ((d/a)/b/c == 24){
									Output.setText("Try this equation: (" + d + " / " + a + ") / " + b + " / "  + c);
								}
								else if ((d/a)/b*c == 24){
									Output.setText("Try this equation: (" + d + " / " + a + ") / " + b + " * "  + c);
								}
								
							else if ((d/a)*b+c == 24) {
								Output.setText("Try this equation: (" + d + " / " + a + ") * " + b + " + "  + c);
							}
								else if ((d/a)*b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") * " + b + " - "  + c);
								}
								else if ((d/a)*b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") * " + b + " / "  + c);
								}
								else if ((d/a)*b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " / " + a + ") * " + b + " * "  + c);
								}
						

						
						
								else if ((d*a)+b+c == 24) {
							Output.setText("Try this equation: (" + d + " * " + a + ") + " + b + " + "  + c);
						}
							else if ((d*a)-b+c == 24) {
								Output.setText("Try this equation: (" + d + " * " + a + ") - " + b + " + "  + c);
							}
								else if ((d*a)-b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + ") - " + b + " - "  + c);
								}
								else if ((d*a)-b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + ") - " + b + " / "  + c);
								}
								else if ((d*a)-b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + ") - " + b + " * "  + c);
								}
							else if ((d*a)/b+c == 24) {
								Output.setText("Try this equation: (" + d + " * " + a + ") / " + b + " + "  + c);
							}
								else if ((d*a)/b-c == 24){
									Output.setText("Try this equation: (" + d + " * " + a + ") / " + b + " - "  + c);
								}
								else if ((d*a)/b/c == 24){
									Output.setText("Try this equation: (" + d + " * " + a + ") / " + b + " / "  + c);
								}
								else if ((d*a)/b*c == 24){
									Output.setText("Try this equation: (" + d + " * " + a + ") / " + b + " * "  + c);
								}
								
							else if ((d*a)*b+c == 24) {
								Output.setText("Try this equation: (" + d + " * " + a + ") * " + b + " + "  + c);
							}
								else if ((d*a)*b-c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + ") * " + b + " - "  + c);
								}
								else if ((d*a)*b/c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + ") * " + b + " / "  + c);
								}
								else if ((d*a)*b*c == 24)
								{
									Output.setText("Try this equation: (" + d + " * " + a + " )* " + b + " * "  + c);
								}
	
								else if ((d+c)+b+a == 24) {
									Output.setText("Try this equation: (" + d + " + " + c + ") + " + b + " + "  + a);
								}
									else if ((d+c)-b+a == 24) {
										Output.setText("Try this equation: (" + d + " + " + c + ") - " + b + " + "  + a);
									}
										else if ((d+c)-b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") - " + b + " - "  + a);
										}
										else if ((d+c)-b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") - " + b + " / "  + a);
										}
										else if ((d+c)-b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") - " + b + " * "  + a);
										}
									else if ((d+c)/b+a == 24) {
										Output.setText("Try this equation: (" + d + " + " + c + ") / " + b + " + "  + a);
									}
										else if ((d+c)/b-a == 24){
											Output.setText("Try this equation: (" + d + " + " + c + ") / " + b + " - "  + a);
										}
										else if ((d+c)/b/a == 24){
											Output.setText("Try this equation: (" + d + " + " + c + ") / " + b + " / "  + a);
										}
										else if ((d+c)/b*a == 24){
											Output.setText("Try this equation: (" + d + " + " + c + ") / " + b + " * "  + a);
										}
										
									else if ((d+c)*b+a == 24) {
										Output.setText("Try this equation: (" + d + " + " + c + ") * " + b + " + "  + a);
									}
										else if ((d+c)*b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") * " + b + " - "  + a);
										}
										else if ((d+c)*b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") * " + b + " / "  + a);
										}
										else if ((d+c)*b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " + " + c + ") * " + b + " * "  + a);
										}
								

								
										else if ((d-c)+b+a == 24) {
									Output.setText("Try this equation: (" + d + " - " + c + ") + " + b + " + "  + a);
								}
									else if ((d-c)-b+a == 24) {
										Output.setText("Try this equation: (" + d + " - " + c + ") - " + b + " + "  + a);
									}
										else if ((d-c)-b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") - " + b + " - "  + a);
										}
										else if ((d-c)-b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") - " + b + " / "  + a);
										}
										else if ((d-c)-b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") - " + b + " * "  + a);
										}
									else if ((d-c)/b+a == 24) {
										Output.setText("Try this equation: (" + d + " - " + c + ") / " + b + " + "  + a);
									}
										else if ((d-c)/b-a == 24){
											Output.setText("Try this equation: (" + d + " - " + c + ") / " + b + " - "  + a);
										}
										else if ((d-c)/b/a == 24){
											Output.setText("Try this equation: (" + d + " - " + c + ") / " + b + " / "  + a);
										}
										else if ((d-c)/b*a == 24){
											Output.setText("Try this equation: (" + d + " - " + c + ") / " + b + " * "  + a);
										}
										
									else if ((d-c)*b+a == 24) {
										Output.setText("Try this equation: (" + d + " - " + c + ") * " + b + " + "  + a);
									}
										else if ((d-c)*b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") * " + b + " - "  + a);
										}
										else if ((d-c)*b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") * " + b + " / "  + a);
										}
										else if ((d-c)*b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " - " + c + ") * " + b + " * "  + a);
										}
								
								
										else if ((d/c)+b+a == 24) {
									Output.setText("Try this equation: (" + d + " / " + c + ") + " + b + " + "  + a);
								}
									else if ((d/c)-b+a == 24) {
										Output.setText("Try this equation: (" + d + " / " + c + ") - " + b + " + "  + a);
									}
										else if ((d/c)-b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") - " + b + " - "  + a);
										}
										else if ((d/c)-b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") - " + b + " / "  + a);
										}
										else if ((d/c)-b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") - " + b + " * "  + a);
										}
									else if ((d/c)/b+a == 24) {
										Output.setText("Try this equation: (" + d + " / " + c + ") / " + b + " + "  + a);
									}
										else if ((d/c)/b-a == 24){
											Output.setText("Try this equation: (" + d + " / " + c + ") / " + b + " - "  + a);
										}
										else if ((d/c)/b/a == 24){
											Output.setText("Try this equation: (" + d + " / " + c + ") / " + b + " / "  + a);
										}
										else if ((d/c)/b*a == 24){
											Output.setText("Try this equation: (" + d + " / " + c + ") / " + b + " * "  + a);
										}
										
									else if ((d/c)*b+a == 24) {
										Output.setText("Try this equation: (" + d + " / " + c + ") * " + b + " + "  + a);
									}
										else if ((d/c)*b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") * " + b + " - "  + a);
										}
										else if ((d/c)*b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") * " + b + " / "  + a);
										}
										else if ((d/c)*b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " / " + c + ") * " + b + " * "  + a);
										}
								

								
								
										else if ((d*c)+b+a == 24) {
									Output.setText("Try this equation: (" + d + " * " + c + ") + " + b + " + "  + a);
								}
									else if ((d*c)-b+a == 24) {
										Output.setText("Try this equation: (" + d + " * " + c + ") - " + b + " + "  + a);
									}
										else if ((d*c)-b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + ") - " + b + " - "  + a);
										}
										else if ((d*c)-b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + ") - " + b + " / "  + a);
										}
										else if ((d*c)-b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + ") - " + b + " * "  + a);
										}
									else if ((d*c)/b+a == 24) {
										Output.setText("Try this equation: (" + d + " * " + c + ") / " + b + " + "  + a);
									}
										else if ((d*c)/b-a == 24){
											Output.setText("Try this equation: (" + d + " * " + c + ") / " + b + " - "  + a);
										}
										else if ((d*c)/b/a == 24){
											Output.setText("Try this equation: (" + d + " * " + c + ") / " + b + " / "  + a);
										}
										else if ((d*c)/b*a == 24){
											Output.setText("Try this equation: (" + d + " * " + c + ") / " + b + " * "  + a);
										}
										
									else if ((d*c)*b+a == 24) {
										Output.setText("Try this equation: (" + d + " * " + c + ") * " + b + " + "  + a);
									}
										else if ((d*c)*b-a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + ") * " + b + " - "  + a);
										}
										else if ((d*c)*b/a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + ") * " + b + " / "  + a);
										}
										else if ((d*c)*b*a == 24)
										{
											Output.setText("Try this equation: (" + d + " * " + c + " )* " + b + " * "  + a);
										}

		
										else if ((c+d)+b+a == 24) {
											Output.setText("Try this equation: (" + c + " + " + d + ") + " + b + " + "  + a);
										}
											else if ((c+d)-b+a == 24) {
												Output.setText("Try this equation: (" + c + " + " + d + ") - " + b + " + "  + a);
											}
												else if ((c+d)-b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") - " + b + " - "  + a);
												}
												else if ((c+d)-b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") - " + b + " / "  + a);
												}
												else if ((c+d)-b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") - " + b + " * "  + a);
												}
											else if ((c+d)/b+a == 24) {
												Output.setText("Try this equation: (" + c + " + " + d + ") / " + b + " + "  + a);
											}
												else if ((c+d)/b-a == 24){
													Output.setText("Try this equation: (" + c + " + " + d + ") / " + b + " - "  + a);
												}
												else if ((c+d)/b/a == 24){
													Output.setText("Try this equation: (" + c + " + " + d + ") / " + b + " / "  + a);
												}
												else if ((c+d)/b*a == 24){
													Output.setText("Try this equation: (" + c + " + " + d + ") / " + b + " * "  + a);
												}
												
											else if ((c+d)*b+a == 24) {
												Output.setText("Try this equation: (" + c + " + " + d + ") * " + b + " + "  + a);
											}
												else if ((c+d)*b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") * " + b + " - "  + a);
												}
												else if ((c+d)*b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") * " + b + " / "  + a);
												}
												else if ((c+d)*b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " + " + d + ") * " + b + " * "  + a);
												}
										

										
												else if ((c-d)+b+a == 24) {
											Output.setText("Try this equation: (" + c + " - " + d + ") + " + b + " + "  + a);
										}
											else if ((c-d)-b+a == 24) {
												Output.setText("Try this equation: (" + c + " - " + d + ") - " + b + " + "  + a);
											}
												else if ((c-d)-b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") - " + b + " - "  + a);
												}
												else if ((c-d)-b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") - " + b + " / "  + a);
												}
												else if ((c-d)-b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") - " + b + " * "  + a);
												}
											else if ((c-d)/b+a == 24) {
												Output.setText("Try this equation: (" + c + " - " + d + ") / " + b + " + "  + a);
											}
												else if ((c-d)/b-a == 24){
													Output.setText("Try this equation: (" + c + " - " + d + ") / " + b + " - "  + a);
												}
												else if ((c-d)/b/a == 24){
													Output.setText("Try this equation: (" + c + " - " + d + ") / " + b + " / "  + a);
												}
												else if ((c-d)/b*a == 24){
													Output.setText("Try this equation: (" + c + " - " + d + ") / " + b + " * "  + a);
												}
												
											else if ((c-d)*b+a == 24) {
												Output.setText("Try this equation: (" + c + " - " + d + ") * " + b + " + "  + a);
											}
												else if ((c-d)*b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") * " + b + " - "  + a);
												}
												else if ((c-d)*b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") * " + b + " / "  + a);
												}
												else if ((c-d)*b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " - " + d + ") * " + b + " * "  + a);
												}
										
										
												else if ((c/d)+b+a == 24) {
											Output.setText("Try this equation: (" + c + " / " + d + ") + " + b + " + "  + a);
										}
											else if ((c/d)-b+a == 24) {
												Output.setText("Try this equation: (" + c + " / " + d + ") - " + b + " + "  + a);
											}
												else if ((c/d)-b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") - " + b + " - "  + a);
												}
												else if ((c/d)-b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") - " + b + " / "  + a);
												}
												else if ((c/d)-b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") - " + b + " * "  + a);
												}
											else if ((c/d)/b+a == 24) {
												Output.setText("Try this equation: (" + c + " / " + d + ") / " + b + " + "  + a);
											}
												else if ((c/d)/b-a == 24){
													Output.setText("Try this equation: (" + c + " / " + d + ") / " + b + " - "  + a);
												}
												else if ((c/d)/b/a == 24){
													Output.setText("Try this equation: (" + c + " / " + d + ") / " + b + " / "  + a);
												}
												else if ((c/d)/b*a == 24){
													Output.setText("Try this equation: (" + c + " / " + d + ") / " + b + " * "  + a);
												}
												
											else if ((c/d)*b+a == 24) {
												Output.setText("Try this equation: (" + c + " / " + d + ") * " + b + " + "  + a);
											}
												else if ((c/d)*b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") * " + b + " - "  + a);
												}
												else if ((c/d)*b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") * " + b + " / "  + a);
												}
												else if ((c/d)*b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " / " + d + ") * " + b + " * "  + a);
												}
										

										
										
												else if ((c*d)+b+a == 24) {
											Output.setText("Try this equation: (" + c + " * " + d + ") + " + b + " + "  + a);
										}
											else if ((c*d)-b+a == 24) {
												Output.setText("Try this equation: (" + c + " * " + d + ") - " + b + " + "  + a);
											}
												else if ((c*d)-b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + ") - " + b + " - "  + a);
												}
												else if ((c*d)-b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + ") - " + b + " / "  + a);
												}
												else if ((c*d)-b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + ") - " + b + " * "  + a);
												}
											else if ((c*d)/b+a == 24) {
												Output.setText("Try this equation: (" + c + " * " + d + ") / " + b + " + "  + a);
											}
												else if ((c*d)/b-a == 24){
													Output.setText("Try this equation: (" + c + " * " + d + ") / " + b + " - "  + a);
												}
												else if ((c*d)/b/a == 24){
													Output.setText("Try this equation: (" + c + " * " + d + ") / " + b + " / "  + a);
												}
												else if ((c*d)/b*a == 24){
													Output.setText("Try this equation: (" + c + " * " + d + ") / " + b + " * "  + a);
												}
												
											else if ((c*d)*b+a == 24) {
												Output.setText("Try this equation: (" + c + " * " + d + ") * " + b + " + "  + a);
											}
												else if ((c*d)*b-a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + ") * " + b + " - "  + a);
												}
												else if ((c*d)*b/a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + ") * " + b + " / "  + a);
												}
												else if ((c*d)*b*a == 24)
												{
													Output.setText("Try this equation: (" + c + " * " + d + " )* " + b + " * "  + a);
												}

		
		
		
				else if (c+b+(a+d) == 24) {
			Output.setText("Try this equation: " + c + " + " + b + " + (" + a + " + "  + d + ")");
		}
			else if (c+b-(a+d) == 24) {
				Output.setText("Try this equation: " + c + " + " + b + " - (" + a + " + "  + d + ")");
			}
				else if (c+b-(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " - (" + a + " - "  + d + ")");
				}
				else if (c+b-(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " - (" + a + " / "  + d + ")");
				}
				else if (c+b-(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " - (" + a + " * "  + d + ")");
				}
			else if (c+b/(a+d) == 24) {
				Output.setText("Try this equation: " + c + " + " + b + " / (" + a + " + "  + d + ")");
			}
				else if (c+b/(a-d) == 24){
					Output.setText("Try this equation: " + c + " + " + b + " / (" + a + " - "  + d + ")");
				}
				else if (c+b/(a/d) == 24){
					Output.setText("Try this equation: " + c + " + " + b + " / (" + a + " / "  + d + ")");
				}
				else if (c+b/(a*d) == 24){
					Output.setText("Try this equation: " + c + " + " + b + " / (" + a + " * "  + d + ")");
				}
				
			else if (c+b*(a+d) == 24) {
				Output.setText("Try this equation: " + c + " + " + b + " * (" + a + " + "  + d + ")");
			}
				else if (c+b*(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " * (" + a + " - "  + d + ")");
				}
				else if (c+b*(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " * (" + a + " / "  + d + ")");
				}
				else if (c+b*(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " + " + b + " * (" + a + " * "  + d + ")");
				}
		

		
				else if (c-b+(a+d) == 24) {
			Output.setText("Try this equation: " + c + " - " + b + " + (" + a + " + "  + d + ")");
		}
			else if (c-b-(a+d) == 24) {
				Output.setText("Try this equation: " + c + " - " + b + " - (" + a + " + "  + d + ")");
			}
				else if (c-b-(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " - (" + a + " - "  + d + ")");
				}
				else if (c-b-(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " - (" + a + " / "  + d + ")");
				}
				else if (c-b-(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " - (" + a + " * "  + d + ")");
				}
			else if (c-b/(a+d) == 24) {
				Output.setText("Try this equation: " + c + " - " + b + " / (" + a + " + "  + d + ")");
			}
				else if (c-b/(a-d) == 24){
					Output.setText("Try this equation: " + c + " - " + b + " / (" + a + " - "  + d + ")");
				}
				else if (c-b/(a/d) == 24){
					Output.setText("Try this equation: " + c + " - " + b + " / (" + a + " / "  + d + ")");
				}
				else if (c-b/(a*d) == 24){
					Output.setText("Try this equation: " + c + " - " + b + " / (" + a + " * "  + d + ")");
				}
				
			else if (c-b*(a+d) == 24) {
				Output.setText("Try this equation: " + c + " - " + b + " * (" + a + " + "  + d + ")");
			}
				else if (c-b*(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " * (" + a + " - "  + d + ")");
				}
				else if (c-b*(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " * (" + a + " / "  + d + ")");
				}
				else if (c-b*(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " - " + b + " * (" + a + " * "  + d + ")");
				}
		
		
				else if (c/b+(a+d) == 24) {
			Output.setText("Try this equation: " + c + " / " + b + " + (" + a + " + "  + d + ")");
		}
			else if (c/b-(a+d) == 24) {
				Output.setText("Try this equation: " + c + " / " + b + " - (" + a + " + "  + d + ")");
			}
				else if (c/b-(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " - (" + a + " - "  + d + ")");
				}
				else if (c/b-(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " - (" + a + " / "  + d + ")");
				}
				else if (c/b-(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " - (" + a + " * "  + d + ")");
				}
			else if (c/b/(a+d) == 24) {
				Output.setText("Try this equation: " + c + " / " + b + " / (" + a + " + "  + d + ")");
			}
				else if (c/b/(a-d) == 24){
					Output.setText("Try this equation: " + c + " / " + b + " / (" + a + " - "  + d + ")");
				}
				else if (c/b/(a/d) == 24){
					Output.setText("Try this equation: " + c + " / " + b + " / (" + a + " / "  + d + ")");
				}
				else if (c/b/(a*d) == 24){
					Output.setText("Try this equation: " + c + " / " + b + " / (" + a + " * "  + d + ")");
				}
				
			else if (c/b*(a+d) == 24) {
				Output.setText("Try this equation: " + c + " / " + b + " * (" + a + " + "  + d + ")");
			}
				else if (c/b*(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " * (" + a + " - "  + d + ")");
				}
				else if (c/b*(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " * (" + a + " / "  + d + ")");
				}
				else if (c/b*(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " / " + b + " * (" + a + " * "  + d + ")");
				}
		

		
		
				else if (c*b+(a+d) == 24) {
			Output.setText("Try this equation: " + c + " * " + b + " + (" + a + " + "  + d + ")");
		}
			else if (c*b-(a+d) == 24) {
				Output.setText("Try this equation: " + c + " * " + b + " - (" + a + " + "  + d + ")");
			}
				else if (c*b-(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " - (" + a + " - "  + d + ")");
				}
				else if (c*b-(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " - (" + a + " / "  + d + ")");
				}
				else if (c*b-(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " - (" + a + " * "  + d + ")");
				}
			else if (c*b/(a+d) == 24) {
				Output.setText("Try this equation: " + c + " * " + b + " / (" + a + " + "  + d + ")");
			}
				else if (c*b/(a-d) == 24){
					Output.setText("Try this equation: " + c + " * " + b + " / (" + a + " - "  + d + ")");
				}
				else if (c*b/(a/d) == 24){
					Output.setText("Try this equation: " + c + " * " + b + " / (" + a + " / "  + d + ")");
				}
				else if (c*b/(a*d) == 24){
					Output.setText("Try this equation: " + c + " * " + b + " / (" + a + " * "  + d + ")");
				}
				
			else if (c*b*(a+d) == 24) {
				Output.setText("Try this equation: " + c + " * " + b + " * (" + a + " + "  + d + ")");
			}
				else if (c*b*(a-d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " * (" + a + " - "  + d + ")");
				}
				else if (c*b*(a/d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " * (" + a + " / "  + d + ")");
				}
				else if (c*b*(a*d) == 24)
				{
					Output.setText("Try this equation: " + c + " * " + b + " * (" + a + " * "  + d + ")");
				}

		
		
		
				else if (c+d+a+b == 24) {
			Output.setText("Try this equation: " + c + " + " + d + " + " + a + " + "  + b);
		}
			else if (c+d-a+b == 24) {
				Output.setText("Try this equation: " + c + " + " + d + " - " + a + " + "  + b);
			}
				else if (c+d-a-b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " - " + a + " - "  + b);
				}
				else if (c+d-a/b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " - " + a + " / "  + b);
				}
				else if (c+d-a*b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " - " + a + " * "  + b);
				}
			else if (c+d/a+b == 24) {
				Output.setText("Try this equation: " + c + " + " + d + " / " + a + " + "  + b);
			}
				else if (c+d/a-b == 24){
					Output.setText("Try this equation: " + c + " + " + d + " / " + a + " - "  + b);
				}
				else if (c+d/a/b == 24){
					Output.setText("Try this equation: " + c + " + " + d + " / " + a + " / "  + b);
				}
				else if (c+d/a*b == 24){
					Output.setText("Try this equation: " + c + " + " + d + " / " + a + " * "  + b);
				}
				
			else if (c+d*a+b == 24) {
				Output.setText("Try this equation: " + c + " + " + d + " * " + a + " + "  + b);
			}
				else if (c+d*a-b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " * " + a + " - "  + b);
				}
				else if (c+d*a/b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " * " + a + " / "  + b);
				}
				else if (c+d*a*b == 24)
				{
					Output.setText("Try this equation: " + c + " + " + d + " * " + a + " * "  + b);
				}
		

		
				else if (c-d+a+b == 24) {
			Output.setText("Try this equation: " + c + " - " + d + " + " + a + " + "  + b);
		}
			else if (c-d-a+b == 24) {
				Output.setText("Try this equation: " + c + " - " + d + " - " + a + " + "  + b);
			}
				else if (c-d-a-b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " - " + a + " - "  + b);
				}
				else if (c-d-a/b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " - " + a + " / "  + b);
				}
				else if (c-d-a*b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " - " + a + " * "  + b);
				}
			else if (c-d/a+b == 24) {
				Output.setText("Try this equation: " + c + " - " + d + " / " + a + " + "  + b);
			}
				else if (c-d/a-b == 24){
					Output.setText("Try this equation: " + c + " - " + d + " / " + a + " - "  + b);
				}
				else if (c-d/a/b == 24){
					Output.setText("Try this equation: " + c + " - " + d + " / " + a + " / "  + b);
				}
				else if (c-d/a*b == 24){
					Output.setText("Try this equation: " + c + " - " + d + " / " + a + " * "  + b);
				}
				
			else if (c-d*a+b == 24) {
				Output.setText("Try this equation: " + c + " - " + d + " * " + a + " + "  + b);
			}
				else if (c-d*a-b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " * " + a + " - "  + b);
				}
				else if (c-d*a/b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " * " + a + " / "  + b);
				}
				else if (c-d*a*b == 24)
				{
					Output.setText("Try this equation: " + c + " - " + d + " * " + a + " * "  + b);
				}
		
		
				else if (c/d+a+b == 24) {
			Output.setText("Try this equation: " + c + " / " + d + " + " + a + " + "  + b);
		}
			else if (c/d-a+b == 24) {
				Output.setText("Try this equation: " + c + " / " + d + " - " + a + " + "  + b);
			}
				else if (c/d-a-b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " - " + a + " - "  + b);
				}
				else if (c/d-a/b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " - " + a + " / "  + b);
				}
				else if (c/d-a*b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " - " + a + " * "  + b);
				}
			else if (c/d/a+b == 24) {
				Output.setText("Try this equation: " + c + " / " + d + " / " + a + " + "  + b);
			}
				else if (c/d/a-b == 24){
					Output.setText("Try this equation: " + c + " / " + d + " / " + a + " - "  + b);
				}
				else if (c/d/a/b == 24){
					Output.setText("Try this equation: " + c + " / " + d + " / " + a + " / "  + b);
				}
				else if (c/d/a*b == 24){
					Output.setText("Try this equation: " + c + " / " + d + " / " + a + " * "  + b);
				}
				
			else if (c/d*a+b == 24) {
				Output.setText("Try this equation: " + c + " / " + d + " * " + a + " + "  + b);
			}
				else if (c/d*a-b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " * " + a + " - "  + b);
				}
				else if (c/d*a/b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " * " + a + " / "  + b);
				}
				else if (c/d*a*b == 24)
				{
					Output.setText("Try this equation: " + c + " / " + d + " * " + a + " * "  + b);
				}
		

		
		
				else if (c*d+a+b == 24) {
			Output.setText("Try this equation: " + c + " * " + d + " + " + a + " + "  + b);
		}
			else if (c*d-a+b == 24) {
				Output.setText("Try this equation: " + c + " * " + d + " - " + a + " + "  + b);
			}
				else if (c*d-a-b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " - " + a + " - "  + b);
				}
				else if (c*d-a/b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " - " + a + " / "  + b);
				}
				else if (c*d-a*b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " - " + a + " * "  + b);
				}
			else if (c*d/a+b == 24) {
				Output.setText("Try this equation: " + c + " * " + d + " / " + a + " + "  + b);
			}
				else if (c*d/a-b == 24){
					Output.setText("Try this equation: " + c + " * " + d + " / " + a + " - "  + b);
				}
				else if (c*d/a/b == 24){
					Output.setText("Try this equation: " + c + " * " + d + " / " + a + " / "  + b);
				}
				else if (c*d/a*b == 24){
					Output.setText("Try this equation: " + c + " * " + d + " / " + a + " * "  + b);
				}
				
			else if (c*d*a+b == 24) {
				Output.setText("Try this equation: " + c + " * " + d + " * " + a + " + "  + b);
			}
				else if (c*d*a-b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " * " + a + " - "  + b);
				}
				else if (c*d*a/b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " * " + a + " / "  + b);
				}
				else if (c*d*a*b == 24)
				{
					Output.setText("Try this equation: " + c + " * " + d + " * " + a + " * "  + b);
				}
		

		
		
		
				else if (a+d+(c+b) == 24) {
			Output.setText("Try this equation: " + a + " + " + d + " + (" + c + " + "  + b + ")");
		}
			else if (a+d-(c+b) == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " - (" + c + " + "  + b + ")");
			}
				else if (a+d-(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - (" + c + " - "  + b + ")");
				}
				else if (a+d-(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - (" + c + " / "  + b + ")");
				}
				else if (a+d-(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - (" + c + " * "  + b + ")");
				}
			else if (a+d/(c+b) == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " / (" + c + " + "  + b + ")");
			}
				else if (a+d/(c-b) == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / (" + c + " - "  + b + ")");
				}
				else if (a+d/(c/b) == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / (" + c + " / "  + b + ")");
				}
				else if (a+d/(c*b) == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / (" + c + " * "  + b + ")");
				}
				
			else if (a+d*(c+b) == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " * (" + c + " + "  + b + ")");
			}
				else if (a+d*(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * (" + c + " - "  + b + ")");
				}
				else if (a+d*(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * (" + c + " / "  + b + ")");
				}
				else if (a+d*(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * (" + c + " * "  + b + ")");
				}
		

		
				else if (a-d+(c+b) == 24) {
			Output.setText("Try this equation: " + a + " - " + d + " + (" + c + " + "  + b + ")");
		}
			else if (a-d-(c+b) == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " - (" + c + " + "  + b + ")");
			}
				else if (a-d-(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - (" + c + " - "  + b + ")");
				}
				else if (a-d-(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - (" + c + " / "  + b + ")");
				}
				else if (a-d-(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - (" + c + " * "  + b + ")");
				}
			else if (a-d/(c+b) == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " / (" + c + " + "  + b + ")");
			}
				else if (a-d/(c-b) == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / (" + c + " - "  + b + ")");
				}
				else if (a-d/(c/b) == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / (" + c + " / "  + b + ")");
				}
				else if (a-d/(c*b) == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / (" + c + " * "  + b + ")");
				}
				
			else if (a-d*(c+b) == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " * (" + c + " + "  + b + ")");
			}
				else if (a-d*(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * (" + c + " - "  + b + ")");
				}
				else if (a-d*(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * (" + c + " / "  + b + ")");
				}
				else if (a-d*(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * (" + c + " * "  + b + ")");
				}
		
		
				else if (a/d+(c+b) == 24) {
			Output.setText("Try this equation: " + a + " / " + d + " + (" + c + " + "  + b + ")");
		}
			else if (a/d-(c+b) == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " - (" + c + " + "  + b + ")");
			}
				else if (a/d-(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - (" + c + " - "  + b + ")");
				}
				else if (a/d-(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - (" + c + " / "  + b + ")");
				}
				else if (a/d-(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - (" + c + " * "  + b + ")");
				}
			else if (a/d/(c+b) == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " / (" + c + " + "  + b + ")");
			}
				else if (a/d/(c-b) == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / (" + c + " - "  + b + ")");
				}
				else if (a/d/(c/b) == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / (" + c + " / "  + b + ")");
				}
				else if (a/d/(c*b) == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / (" + c + " * "  + b + ")");
				}
				
			else if (a/d*(c+b) == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " * (" + c + " + "  + b + ")");
			}
				else if (a/d*(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * (" + c + " - "  + b + ")");
				}
				else if (a/d*(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * (" + c + " / "  + b + ")");
				}
				else if (a/d*(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * (" + c + " * "  + b + ")");
				}
		

		
		
				else if (a*d+(c+b) == 24) {
			Output.setText("Try this equation: " + a + " * " + d + " + (" + c + " + "  + b + ")");
		}
			else if (a*d-(c+b) == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " - (" + c + " + "  + b + ")");
			}
				else if (a*d-(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - (" + c + " - "  + b + ")");
				}
				else if (a*d-(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - (" + c + " / "  + b + ")");
				}
				else if (a*d-(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - (" + c + " * "  + b + ")");
				}
			else if (a*d/(c+b) == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " / (" + c + " + "  + b + ")");
			}
				else if (a*d/(c-b) == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / (" + c + " - "  + b + ")");
				}
				else if (a*d/(c/b) == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / (" + c + " / "  + b + ")");
				}
				else if (a*d/(c*b) == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / (" + c + " * "  + b + ")");
				}
				
			else if (a*d*(c+b) == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " * (" + c + " + "  + b + ")");
			}
				else if (a*d*(c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * (" + c + " - "  + b + ")");
				}
				else if (a*d*(c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * (" + c + " / "  + b + ")");
				}
				else if (a*d*(c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * (" + c + " * "  + b + ")");
				}

		
		
		
		
		
				else if (a+b+c+d == 24) {
			Output.setText("Try this equation: " + a + " + " + b + " + " + c + " + "  + d);
		}
			else if (a+b-c+d == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " - " + c + " + "  + d);
			}
				else if (a+b-c-d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - " + c + " - "  + d);
				}
				else if (a+b-c/d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - " + c + " / "  + d);
				}
				else if (a+b-c*d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " - " + c + " * "  + d);
				}
			else if (a+b/c+d == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " / " + c + " + "  + d);
			}
				else if (a+b/c-d == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / " + c + " - "  + d);
				}
				else if (a+b/c/d == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / " + c + " / "  + d);
				}
				else if (a+b/c*d == 24){
					Output.setText("Try this equation: " + a + " + " + b + " / " + c + " * "  + d);
				}
				
			else if (a+b*c+d == 24) {
				Output.setText("Try this equation: " + a + " + " + b + " * " + c + " + "  + d);
			}
				else if (a+b*c-d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * " + c + " - "  + d);
				}
				else if (a+b*c/d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * " + c + " / "  + d);
				}
				else if (a+b*c*d == 24)
				{
					Output.setText("Try this equation: " + a + " + " + b + " * " + c + " * "  + d);
				}
		

		
				else if (a-b+c+d == 24) {
			Output.setText("Try this equation: " + a + " - " + b + " + " + c + " + "  + d);
		}
			else if (a-b-c+d == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " - " + c + " + "  + d);
			}
				else if (a-b-c-d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - " + c + " - "  + d);
				}
				else if (a-b-c/d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - " + c + " / "  + d);
				}
				else if (a-b-c*d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " - " + c + " * "  + d);
				}
			else if (a-b/c+d == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " / " + c + " + "  + d);
			}
				else if (a-b/c-d == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / " + c + " - "  + d);
				}
				else if (a-b/c/d == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / " + c + " / "  + d);
				}
				else if (a-b/c*d == 24){
					Output.setText("Try this equation: " + a + " - " + b + " / " + c + " * "  + d);
				}
				
			else if (a-b*c+d == 24) {
				Output.setText("Try this equation: " + a + " - " + b + " * " + c + " + "  + d);
			}
				else if (a-b*c-d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * " + c + " - "  + d);
				}
				else if (a-b*c/d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * " + c + " / "  + d);
				}
				else if (a-b*c*d == 24)
				{
					Output.setText("Try this equation: " + a + " - " + b + " * " + c + " * "  + d);
				}
		
		
				else if (a/b+c+d == 24) {
			Output.setText("Try this equation: " + a + " / " + b + " + " + c + " + "  + d);
		}
			else if (a/b-c+d == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " - " + c + " + "  + d);
			}
				else if (a/b-c-d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - " + c + " - "  + d);
				}
				else if (a/b-c/d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - " + c + " / "  + d);
				}
				else if (a/b-c*d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " - " + c + " * "  + d);
				}
			else if (a/b/c+d == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " / " + c + " + "  + d);
			}
				else if (a/b/c-d == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / " + c + " - "  + d);
				}
				else if (a/b/c/d == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / " + c + " / "  + d);
				}
				else if (a/b/c*d == 24){
					Output.setText("Try this equation: " + a + " / " + b + " / " + c + " * "  + d);
				}
				
			else if (a/b*c+d == 24) {
				Output.setText("Try this equation: " + a + " / " + b + " * " + c + " + "  + d);
			}
				else if (a/b*c-d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * " + c + " - "  + d);
				}
				else if (a/b*c/d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * " + c + " / "  + d);
				}
				else if (a/b*c*d == 24)
				{
					Output.setText("Try this equation: " + a + " / " + b + " * " + c + " * "  + d);
				}
		

		
		
				else if (a*b+c+d == 24) {
			Output.setText("Try this equation: " + a + " * " + b + " + " + c + " + "  + d);
		}
			else if (a*b-c+d == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " - " + c + " + "  + d);
			}
				else if (a*b-c-d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - " + c + " - "  + d);
				}
				else if (a*b-c/d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - " + c + " / "  + d);
				}
				else if (a*b-c*d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " - " + c + " * "  + d);
				}
			else if (a*b/c+d == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " / " + c + " + "  + d);
			}
				else if (a*b/c-d == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / " + c + " - "  + d);
				}
				else if (a*b/c/d == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / " + c + " / "  + d);
				}
				else if (a*b/c*d == 24){
					Output.setText("Try this equation: " + a + " * " + b + " / " + c + " * "  + d);
				}
				
			else if (a*b*c+d == 24) {
				Output.setText("Try this equation: " + a + " * " + b + " * " + c + " + "  + d);
			}
				else if (a*b*c-d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * " + c + " - "  + d);
				}
				else if (a*b*c/d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * " + c + " / "  + d);
				}
				else if (a*b*c*d == 24)
				{
					Output.setText("Try this equation: " + a + " * " + b + " * " + c + " * "  + d);
				}
		
		
		
		
		
		
				else if (a+d+c+b == 24) {
			Output.setText("Try this equation: " + a + " + " + d + " + " + c + " + "  + b);
		}
			else if (a+d-c+b == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " - " + c + " + "  + b);
			}
				else if (a+d-c-b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + c + " - "  + b);
				}
				else if (a+d-c/b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + c + " / "  + b);
				}
				else if (a+d-c*b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + c + " * "  + b);
				}
			else if (a+d/c+b == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " / " + c + " + "  + b);
			}
				else if (a+d/c-b == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + c + " - "  + b);
				}
				else if (a+d/c/b == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + c + " / "  + b);
				}
				else if (a+d/c*b == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + c + " * "  + b);
				}
				
			else if (a+d*c+b == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " * " + c + " + "  + b);
			}
				else if (a+d*c-b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + c + " - "  + b);
				}
				else if (a+d*c/b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + c + " / "  + b);
				}
				else if (a+d*c*b == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + c + " * "  + b);
				}
		

		
				else if (a-d+c+b == 24) {
			Output.setText("Try this equation: " + a + " - " + d + " + " + c + " + "  + b);
		}
			else if (a-d-c+b == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " - " + c + " + "  + b);
			}
				else if (a-d-c-b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + c + " - "  + b);
				}
				else if (a-d-c/b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + c + " / "  + b);
				}
				else if (a-d-c*b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + c + " * "  + b);
				}
			else if (a-d/c+b == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " / " + c + " + "  + b);
			}
				else if (a-d/c-b == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + c + " - "  + b);
				}
				else if (a-d/c/b == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + c + " / "  + b);
				}
				else if (a-d/c*b == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + c + " * "  + b);
				}
				
			else if (a-d*c+b == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " * " + c + " + "  + b);
			}
				else if (a-d*c-b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + c + " - "  + b);
				}
				else if (a-d*c/b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + c + " / "  + b);
				}
				else if (a-d*c*b == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + c + " * "  + b);
				}
		
		
				else if (a/d+c+b == 24) {
			Output.setText("Try this equation: " + a + " / " + d + " + " + c + " + "  + b);
		}
			else if (a/d-c+b == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " - " + c + " + "  + b);
			}
				else if (a/d-c-b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + c + " - "  + b);
				}
				else if (a/d-c/b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + c + " / "  + b);
				}
				else if (a/d-c*b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + c + " * "  + b);
				}
			else if (a/d/c+b == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " / " + c + " + "  + b);
			}
				else if (a/d/c-b == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + c + " - "  + b);
				}
				else if (a/d/c/b == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + c + " / "  + b);
				}
				else if (a/d/c*b == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + c + " * "  + b);
				}
				
			else if (a/d*c+b == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " * " + c + " + "  + b);
			}
				else if (a/d*c-b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + c + " - "  + b);
				}
				else if (a/d*c/b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + c + " / "  + b);
				}
				else if (a/d*c*b == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + c + " * "  + b);
				}		
		
				else if (a*d+c+b == 24) {
			Output.setText("Try this equation: " + a + " * " + d + " + " + c + " + "  + b);
		}
			else if (a*d-c+b == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " - " + c + " + "  + b);
			}
				else if (a*d-c-b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + c + " - "  + b);
				}
				else if (a*d-c/b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + c + " / "  + b);
				}
				else if (a*d-c*b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + c + " * "  + b);
				}
			else if (a*d/c+b == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " / " + c + " + "  + b);
			}
				else if (a*d/c-b == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + c + " - "  + b);
				}
				else if (a*d/c/b == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + c + " / "  + b);
				}
				else if (a*d/c*b == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + c + " * "  + b);
				}
				
			else if (a*d*c+b == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " * " + c + " + "  + b);
			}
				else if (a*d*c-b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + c + " - "  + b);
				}
				else if (a*d*c/b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + c + " / "  + b);
				}
				else if (a*d*c*b == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + c + " * "  + b);
				}
		
		
		
				else if (a+d+b+c == 24) {
			Output.setText("Try this equation: " + a + " + " + d + " + " + b + " + "  + c);
		}
			else if (a+d-b+c == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " - " + b + " + "  + c);
			}
				else if (a+d-b-c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + b + " - "  + c);
				}
				else if (a+d-b/c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + b + " / "  + c);
				}
				else if (a+d-b*c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " - " + b + " * "  + c);
				}
			else if (a+d/b+c == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " / " + b + " + "  + c);
			}
				else if (a+d/b-c == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + b + " - "  + c);
				}
				else if (a+d/b/c == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + b + " / "  + c);
				}
				else if (a+d/b*c == 24){
					Output.setText("Try this equation: " + a + " + " + d + " / " + b + " * "  + c);
				}
				
			else if (a+d*b+c == 24) {
				Output.setText("Try this equation: " + a + " + " + d + " * " + b + " + "  + c);
			}
				else if (a+d*b-c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + b + " - "  + c);
				}
				else if (a+d*b/c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + b + " / "  + c);
				}
				else if (a+d*b*c == 24)
				{
					Output.setText("Try this equation: " + a + " + " + d + " * " + b + " * "  + c);
				}
		

		
				else if (a-d+b+c == 24) {
			Output.setText("Try this equation: " + a + " - " + d + " + " + b + " + "  + c);
		}
			else if (a-d-b+c == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " - " + b + " + "  + c);
			}
				else if (a-d-b-c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + b + " - "  + c);
				}
				else if (a-d-b/c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + b + " / "  + c);
				}
				else if (a-d-b*c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " - " + b + " * "  + c);
				}
			else if (a-d/b+c == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " / " + b + " + "  + c);
			}
				else if (a-d/b-c == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + b + " - "  + c);
				}
				else if (a-d/b/c == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + b + " / "  + c);
				}
				else if (a-d/b*c == 24){
					Output.setText("Try this equation: " + a + " - " + d + " / " + b + " * "  + c);
				}
				
			else if (a-d*b+c == 24) {
				Output.setText("Try this equation: " + a + " - " + d + " * " + b + " + "  + c);
			}
				else if (a-d*b-c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + b + " - "  + c);
				}
				else if (a-d*b/c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + b + " / "  + c);
				}
				else if (a-d*b*c == 24)
				{
					Output.setText("Try this equation: " + a + " - " + d + " * " + b + " * "  + c);
				}
		
		
				else if (a/d+b+c == 24) {
			Output.setText("Try this equation: " + a + " / " + d + " + " + b + " + "  + c);
		}
			else if (a/d-b+c == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " - " + b + " + "  + c);
			}
				else if (a/d-b-c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + b + " - "  + c);
				}
				else if (a/d-b/c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + b + " / "  + c);
				}
				else if (a/d-b*c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " - " + b + " * "  + c);
				}
			else if (a/d/b+c == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " / " + b + " + "  + c);
			}
				else if (a/d/b-c == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + b + " - "  + c);
				}
				else if (a/d/b/c == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + b + " / "  + c);
				}
				else if (a/d/b*c == 24){
					Output.setText("Try this equation: " + a + " / " + d + " / " + b + " * "  + c);
				}
				
			else if (a/d*b+c == 24) {
				Output.setText("Try this equation: " + a + " / " + d + " * " + b + " + "  + c);
			}
				else if (a/d*b-c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + b + " - "  + c);
				}
				else if (a/d*b/c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + b + " / "  + c);
				}
				else if (a/d*b*c == 24)
				{
					Output.setText("Try this equation: " + a + " / " + d + " * " + b + " * "  + c);
				}		
		
				else if (a*d+b+c == 24) {
			Output.setText("Try this equation: " + a + " * " + d + " + " + b + " + "  + c);
		}
			else if (a*d-b+c == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " - " + b + " + "  + c);
			}
				else if (a*d-b-c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + b + " - "  + c);
				}
				else if (a*d-b/c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + b + " / "  + c);
				}
				else if (a*d-b*c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " - " + b + " * "  + c);
				}
			else if (a*d/b+c == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " / " + b + " + "  + c);
			}
				else if (a*d/b-c == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + b + " - "  + c);
				}
				else if (a*d/b/c == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + b + " / "  + c);
				}
				else if (a*d/b*c == 24){
					Output.setText("Try this equation: " + a + " * " + d + " / " + b + " * "  + c);
				}
				
			else if (a*d*b+c == 24) {
				Output.setText("Try this equation: " + a + " * " + d + " * " + b + " + "  + c);
			}
				else if (a*d*b-c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + b + " - "  + c);
				}
				else if (a*d*b/c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + b + " / "  + c);
				}
				else if (a*d*b*c == 24)
				{
					Output.setText("Try this equation: " + a + " * " + d + " * " + b + " * "  + c);
				}

		
		
				else if (d+a+b+c == 24) {
			Output.setText("Try this equation: " + d + " + " + a + " + " + b + " + "  + c);
		}
			else if (d+a-b+c == 24) {
				Output.setText("Try this equation: " + d + " + " + a + " - " + b + " + "  + c);
			}
				else if (d+a-b-c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " - " + b + " - "  + c);
				}
				else if (d+a-b/c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " - " + b + " / "  + c);
				}
				else if (d+a-b*c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " - " + b + " * "  + c);
				}
			else if (d+a/b+c == 24) {
				Output.setText("Try this equation: " + d + " + " + a + " / " + b + " + "  + c);
			}
				else if (d+a/b-c == 24){
					Output.setText("Try this equation: " + d + " + " + a + " / " + b + " - "  + c);
				}
				else if (d+a/b/c == 24){
					Output.setText("Try this equation: " + d + " + " + a + " / " + b + " / "  + c);
				}
				else if (d+a/b*c == 24){
					Output.setText("Try this equation: " + d + " + " + a + " / " + b + " * "  + c);
				}
				
			else if (d+a*b+c == 24) {
				Output.setText("Try this equation: " + d + " + " + a + " * " + b + " + "  + c);
			}
				else if (d+a*b-c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " * " + b + " - "  + c);
				}
				else if (d+a*b/c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " * " + b + " / "  + c);
				}
				else if (d+a*b*c == 24)
				{
					Output.setText("Try this equation: " + d + " + " + a + " * " + b + " * "  + c);
				}
		

		
				else if (d-a+b+c == 24) {
			Output.setText("Try this equation: " + d + " - " + a + " + " + b + " + "  + c);
		}
			else if (d-a-b+c == 24) {
				Output.setText("Try this equation: " + d + " - " + a + " - " + b + " + "  + c);
			}
				else if (d-a-b-c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " - " + b + " - "  + c);
				}
				else if (d-a-b/c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " - " + b + " / "  + c);
				}
				else if (d-a-b*c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " - " + b + " * "  + c);
				}
			else if (d-a/b+c == 24) {
				Output.setText("Try this equation: " + d + " - " + a + " / " + b + " + "  + c);
			}
				else if (d-a/b-c == 24){
					Output.setText("Try this equation: " + d + " - " + a + " / " + b + " - "  + c);
				}
				else if (d-a/b/c == 24){
					Output.setText("Try this equation: " + d + " - " + a + " / " + b + " / "  + c);
				}
				else if (d-a/b*c == 24){
					Output.setText("Try this equation: " + d + " - " + a + " / " + b + " * "  + c);
				}
				
			else if (d-a*b+c == 24) {
				Output.setText("Try this equation: " + d + " - " + a + " * " + b + " + "  + c);
			}
				else if (d-a*b-c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " * " + b + " - "  + c);
				}
				else if (d-a*b/c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " * " + b + " / "  + c);
				}
				else if (d-a*b*c == 24)
				{
					Output.setText("Try this equation: " + d + " - " + a + " * " + b + " * "  + c);
				}
		
		
				else if (d/a+b+c == 24) {
			Output.setText("Try this equation: " + d + " / " + a + " + " + b + " + "  + c);
		}
			else if (d/a-b+c == 24) {
				Output.setText("Try this equation: " + d + " / " + a + " - " + b + " + "  + c);
			}
				else if (d/a-b-c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " - " + b + " - "  + c);
				}
				else if (d/a-b/c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " - " + b + " / "  + c);
				}
				else if (d/a-b*c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " - " + b + " * "  + c);
				}
			else if (d/a/b+c == 24) {
				Output.setText("Try this equation: " + d + " / " + a + " / " + b + " + "  + c);
			}
				else if (d/a/b-c == 24){
					Output.setText("Try this equation: " + d + " / " + a + " / " + b + " - "  + c);
				}
				else if (d/a/b/c == 24){
					Output.setText("Try this equation: " + d + " / " + a + " / " + b + " / "  + c);
				}
				else if (d/a/b*c == 24){
					Output.setText("Try this equation: " + d + " / " + a + " / " + b + " * "  + c);
				}
				
			else if (d/a*b+c == 24) {
				Output.setText("Try this equation: " + d + " / " + a + " * " + b + " + "  + c);
			}
				else if (d/a*b-c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " * " + b + " - "  + c);
				}
				else if (d/a*b/c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " * " + b + " / "  + c);
				}
				else if (d/a*b*c == 24)
				{
					Output.setText("Try this equation: " + d + " / " + a + " * " + b + " * "  + c);
				}		
		
				else if (d*a+b+c == 24) {
			Output.setText("Try this equation: " + d + " * " + a + " + " + b + " + "  + c);
		}
			else if (d*a-b+c == 24) {
				Output.setText("Try this equation: " + d + " * " + a + " - " + b + " + "  + c);
			}
				else if (d*a-b-c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " - " + b + " - "  + c);
				}
				else if (d*a-b/c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " - " + b + " / "  + c);
				}
				else if (d*a-b*c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " - " + b + " * "  + c);
				}
			else if (d*a/b+c == 24) {
				Output.setText("Try this equation: " + d + " * " + a + " / " + b + " + "  + c);
			}
				else if (d*a/b-c == 24){
					Output.setText("Try this equation: " + d + " * " + a + " / " + b + " - "  + c);
				}
				else if (d*a/b/c == 24){
					Output.setText("Try this equation: " + d + " * " + a + " / " + b + " / "  + c);
				}
				else if (d*a/b*c == 24){
					Output.setText("Try this equation: " + d + " * " + a + " / " + b + " * "  + c);
				}
				
			else if (d*a*b+c == 24) {
				Output.setText("Try this equation: " + d + " * " + a + " * " + b + " + "  + c);
			}
				else if (d*a*b-c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " * " + b + " - "  + c);
				}
				else if (d*a*b/c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " * " + b + " / "  + c);
				}
				else if (d*a*b*c == 24)
				{
					Output.setText("Try this equation: " + d + " * " + a + " * " + b + " * "  + c);
				}

		
		
				else if (d+c+b+a == 24) {
			Output.setText("Try this equation: " + d + " + " + c + " + " + b + " + "  + a);
		}
			else if (d+c-b+a == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " - " + b + " + "  + a);
			}
				else if (d+c-b-a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + b + " - "  + a);
				}
				else if (d+c-b/a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + b + " / "  + a);
				}
				else if (d+c-b*a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + b + " * "  + a);
				}
			else if (d+c/b+a == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " / " + b + " + "  + a);
			}
				else if (d+c/b-a == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + b + " - "  + a);
				}
				else if (d+c/b/a == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + b + " / "  + a);
				}
				else if (d+c/b*a == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + b + " * "  + a);
				}
				
			else if (d+c*b+a == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " * " + b + " + "  + a);
			}
				else if (d+c*b-a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + b + " - "  + a);
				}
				else if (d+c*b/a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + b + " / "  + a);
				}
				else if (d+c*b*a == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + b + " * "  + a);
				}
		

		
				else if (d-c+b+a == 24) {
			Output.setText("Try this equation: " + d + " - " + c + " + " + b + " + "  + a);
		}
			else if (d-c-b+a == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " - " + b + " + "  + a);
			}
				else if (d-c-b-a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + b + " - "  + a);
				}
				else if (d-c-b/a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + b + " / "  + a);
				}
				else if (d-c-b*a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + b + " * "  + a);
				}
			else if (d-c/b+a == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " / " + b + " + "  + a);
			}
				else if (d-c/b-a == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + b + " - "  + a);
				}
				else if (d-c/b/a == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + b + " / "  + a);
				}
				else if (d-c/b*a == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + b + " * "  + a);
				}
				
			else if (d-c*b+a == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " * " + b + " + "  + a);
			}
				else if (d-c*b-a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + b + " - "  + a);
				}
				else if (d-c*b/a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + b + " / "  + a);
				}
				else if (d-c*b*a == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + b + " * "  + a);
				}
		
		
				else if (d/c+b+a == 24) {
			Output.setText("Try this equation: " + d + " / " + c + " + " + b + " + "  + a);
		}
			else if (d/c-b+a == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " - " + b + " + "  + a);
			}
				else if (d/c-b-a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + b + " - "  + a);
				}
				else if (d/c-b/a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + b + " / "  + a);
				}
				else if (d/c-b*a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + b + " * "  + a);
				}
			else if (d/c/b+a == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " / " + b + " + "  + a);
			}
				else if (d/c/b-a == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + b + " - "  + a);
				}
				else if (d/c/b/a == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + b + " / "  + a);
				}
				else if (d/c/b*a == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + b + " * "  + a);
				}
				
			else if (d/c*b+a == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " * " + b + " + "  + a);
			}
				else if (d/c*b-a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + b + " - "  + a);
				}
				else if (d/c*b/a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + b + " / "  + a);
				}
				else if (d/c*b*a == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + b + " * "  + a);
				}		
		
				else if (d*c+b+a == 24) {
			Output.setText("Try this equation: " + d + " * " + c + " + " + b + " + "  + a);
		}
			else if (d*c-b+a == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " - " + b + " + "  + a);
			}
				else if (d*c-b-a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + b + " - "  + a);
				}
				else if (d*c-b/a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + b + " / "  + a);
				}
				else if (d*c-b*a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + b + " * "  + a);
				}
			else if (d*c/b+a == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " / " + b + " + "  + a);
			}
				else if (d*c/b-a == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + b + " - "  + a);
				}
				else if (d*c/b/a == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + b + " / "  + a);
				}
				else if (d*c/b*a == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + b + " * "  + a);
				}
				
			else if (d*c*b+a == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " * " + b + " + "  + a);
			}
				else if (d*c*b-a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + b + " - "  + a);
				}
				else if (d*c*b/a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + b + " / "  + a);
				}
				else if (d*c*b*a == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + b + " * "  + a);
				}

		
				else if (d+c+a+b == 24) {
			Output.setText("Try this equation: " + d + " + " + c + " + " + a + " + "  + b);
		}
			else if (d+c-a+b == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " - " + a + " + "  + b);
			}
				else if (d+c-a-b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + a + " - "  + b);
				}
				else if (d+c-a/b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + a + " / "  + b);
				}
				else if (d+c-a*b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " - " + a + " * "  + b);
				}
			else if (d+c/a+b == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " / " + a + " + "  + b);
			}
				else if (d+c/a-b == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + a + " - "  + b);
				}
				else if (d+c/a/b == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + a + " / "  + b);
				}
				else if (d+c/a*b == 24){
					Output.setText("Try this equation: " + d + " + " + c + " / " + a + " * "  + b);
				}
				
			else if (d+c*a+b == 24) {
				Output.setText("Try this equation: " + d + " + " + c + " * " + a + " + "  + b);
			}
				else if (d+c*a-b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + a + " - "  + b);
				}
				else if (d+c*a/b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + a + " / "  + b);
				}
				else if (d+c*a*b == 24)
				{
					Output.setText("Try this equation: " + d + " + " + c + " * " + a + " * "  + b);
				}
		

		
				else if (d-c+a+b == 24) {
			Output.setText("Try this equation: " + d + " - " + c + " + " + a + " + "  + b);
		}
			else if (d-c-a+b == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " - " + a + " + "  + b);
			}
				else if (d-c-a-b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + a + " - "  + b);
				}
				else if (d-c-a/b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + a + " / "  + b);
				}
				else if (d-c-a*b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " - " + a + " * "  + b);
				}
			else if (d-c/a+b == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " / " + a + " + "  + b);
			}
				else if (d-c/a-b == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + a + " - "  + b);
				}
				else if (d-c/a/b == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + a + " / "  + b);
				}
				else if (d-c/a*b == 24){
					Output.setText("Try this equation: " + d + " - " + c + " / " + a + " * "  + b);
				}
				
			else if (d-c*a+b == 24) {
				Output.setText("Try this equation: " + d + " - " + c + " * " + a + " + "  + b);
			}
				else if (d-c*a-b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + a + " - "  + b);
				}
				else if (d-c*a/b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + a + " / "  + b);
				}
				else if (d-c*a*b == 24)
				{
					Output.setText("Try this equation: " + d + " - " + c + " * " + a + " * "  + b);
				}
		
		
				else if (d/c+a+b == 24) {
			Output.setText("Try this equation: " + d + " / " + c + " + " + a + " + "  + b);
		}
			else if (d/c-a+b == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " - " + a + " + "  + b);
			}
				else if (d/c-a-b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + a + " - "  + b);
				}
				else if (d/c-a/b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + a + " / "  + b);
				}
				else if (d/c-a*b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " - " + a + " * "  + b);
				}
			else if (d/c/a+b == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " / " + a + " + "  + b);
			}
				else if (d/c/a-b == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + a + " - "  + b);
				}
				else if (d/c/a/b == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + a + " / "  + b);
				}
				else if (d/c/a*b == 24){
					Output.setText("Try this equation: " + d + " / " + c + " / " + a + " * "  + b);
				}
				
			else if (d/c*a+b == 24) {
				Output.setText("Try this equation: " + d + " / " + c + " * " + a + " + "  + b);
			}
				else if (d/c*a-b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + a + " - "  + b);
				}
				else if (d/c*a/b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + a + " / "  + b);
				}
				else if (d/c*a*b == 24)
				{
					Output.setText("Try this equation: " + d + " / " + c + " * " + a + " * "  + b);
				}		
		
				else if (d*c+a+b == 24) {
			Output.setText("Try this equation: " + d + " * " + c + " + " + a + " + "  + b);
		}
			else if (d*c-a+b == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " - " + a + " + "  + b);
			}
				else if (d*c-a-b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + a + " - "  + b);
				}
				else if (d*c-a/b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + a + " / "  + b);
				}
				else if (d*c-a*b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " - " + a + " * "  + b);
				}
			else if (d*c/a+b == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " / " + a + " + "  + b);
			}
				else if (d*c/a-b == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + a + " - "  + b);
				}
				else if (d*c/a/b == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + a + " / "  + b);
				}
				else if (d*c/a*b == 24){
					Output.setText("Try this equation: " + d + " * " + c + " / " + a + " * "  + b);
				}
				
			else if (d*c*a+b == 24) {
				Output.setText("Try this equation: " + d + " * " + c + " * " + a + " + "  + b);
			}
				else if (d*c*a-b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + a + " - "  + b);
				}
				else if (d*c*a/b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + a + " / "  + b);
				}
				else if (d*c*a*b == 24)
				{
					Output.setText("Try this equation: " + d + " * " + c + " * " + a + " * "  + b);
				}

		
				else if (b+c+a+d == 24) {
			Output.setText("Try this equation: " + b + " + " + c + " + " + a + " + "  + d);
		}
			else if (b+c-a+d == 24) {
				Output.setText("Try this equation: " + b + " + " + c + " - " + a + " + "  + d);
			}
				else if (b+c-a-d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " - " + a + " - "  + d);
				}
				else if (b+c-a/d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " - " + a + " / "  + d);
				}
				else if (b+c-a*d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " - " + a + " * "  + d);
				}
			else if (b+c/a+d == 24) {
				Output.setText("Try this equation: " + b + " + " + c + " / " + a + " + "  + d);
			}
				else if (b+c/a-d == 24){
					Output.setText("Try this equation: " + b + " + " + c + " / " + a + " - "  + d);
				}
				else if (b+c/a/d == 24){
					Output.setText("Try this equation: " + b + " + " + c + " / " + a + " / "  + d);
				}
				else if (b+c/a*d == 24){
					Output.setText("Try this equation: " + b + " + " + c + " / " + a + " * "  + d);
				}
				
			else if (b+c*a+d == 24) {
				Output.setText("Try this equation: " + b + " + " + c + " * " + a + " + "  + d);
			}
				else if (b+c*a-d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " * " + a + " - "  + d);
				}
				else if (b+c*a/d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " * " + a + " / "  + d);
				}
				else if (b+c*a*d == 24)
				{
					Output.setText("Try this equation: " + b + " + " + c + " * " + a + " * "  + d);
				}
		

		
				else if (b-c+a+d == 24) {
			Output.setText("Try this equation: " + b + " - " + c + " + " + a + " + "  + d);
		}
			else if (b-c-a+d == 24) {
				Output.setText("Try this equation: " + b + " - " + c + " - " + a + " + "  + d);
			}
				else if (b-c-a-d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " - " + a + " - "  + d);
				}
				else if (b-c-a/d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " - " + a + " / "  + d);
				}
				else if (b-c-a*d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " - " + a + " * "  + d);
				}
			else if (b-c/a+d == 24) {
				Output.setText("Try this equation: " + b + " - " + c + " / " + a + " + "  + d);
			}
				else if (b-c/a-d == 24){
					Output.setText("Try this equation: " + b + " - " + c + " / " + a + " - "  + d);
				}
				else if (b-c/a/d == 24){
					Output.setText("Try this equation: " + b + " - " + c + " / " + a + " / "  + d);
				}
				else if (b-c/a*d == 24){
					Output.setText("Try this equation: " + b + " - " + c + " / " + a + " * "  + d);
				}
				
			else if (b-c*a+d == 24) {
				Output.setText("Try this equation: " + b + " - " + c + " * " + a + " + "  + d);
			}
				else if (b-c*a-d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " * " + a + " - "  + d);
				}
				else if (b-c*a/d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " * " + a + " / "  + d);
				}
				else if (b-c*a*d == 24)
				{
					Output.setText("Try this equation: " + b + " - " + c + " * " + a + " * "  + d);
				}
		
		
				else if (b/c+a+d == 24) {
			Output.setText("Try this equation: " + b + " / " + c + " + " + a + " + "  + d);
		}
			else if (b/c-a+d == 24) {
				Output.setText("Try this equation: " + b + " / " + c + " - " + a + " + "  + d);
			}
				else if (b/c-a-d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " - " + a + " - "  + d);
				}
				else if (b/c-a/d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " - " + a + " / "  + d);
				}
				else if (b/c-a*d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " - " + a + " * "  + d);
				}
			else if (b/c/a+d == 24) {
				Output.setText("Try this equation: " + b + " / " + c + " / " + a + " + "  + d);
			}
				else if (b/c/a-d == 24){
					Output.setText("Try this equation: " + b + " / " + c + " / " + a + " - "  + d);
				}
				else if (b/c/a/d == 24){
					Output.setText("Try this equation: " + b + " / " + c + " / " + a + " / "  + d);
				}
				else if (b/c/a*d == 24){
					Output.setText("Try this equation: " + b + " / " + c + " / " + a + " * "  + d);
				}
				
			else if (b/c*a+d == 24) {
				Output.setText("Try this equation: " + b + " / " + c + " * " + a + " + "  + d);
			}
				else if (b/c*a-d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " * " + a + " - "  + d);
				}
				else if (b/c*a/d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " * " + a + " / "  + d);
				}
				else if (b/c*a*d == 24)
				{
					Output.setText("Try this equation: " + b + " / " + c + " * " + a + " * "  + d);
				}		
		
				else if (b*c+a+d == 24) {
			Output.setText("Try this equation: " + b + " * " + c + " + " + a + " + "  + d);
		}
			else if (b*c-a+d == 24) {
				Output.setText("Try this equation: " + b + " * " + c + " - " + a + " + "  + d);
			}
				else if (b*c-a-d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " - " + a + " - "  + d);
				}
				else if (b*c-a/d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " - " + a + " / "  + d);
				}
				else if (b*c-a*d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " - " + a + " * "  + d);
				}
			else if (b*c/a+d == 24) {
				Output.setText("Try this equation: " + b + " * " + c + " / " + a + " + "  + d);
			}
				else if (b*c/a-d == 24){
					Output.setText("Try this equation: " + b + " * " + c + " / " + a + " - "  + d);
				}
				else if (b*c/a/d == 24){
					Output.setText("Try this equation: " + b + " * " + c + " / " + a + " / "  + d);
				}
				else if (b*c/a*d == 24){
					Output.setText("Try this equation: " + b + " * " + c + " / " + a + " * "  + d);
				}
				
			else if (b*c*a+d == 24) {
				Output.setText("Try this equation: " + b + " * " + c + " * " + a + " + "  + d);
			}
				else if (b*c*a-d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " * " + a + " - "  + d);
				}
				else if (b*c*a/d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " * " + a + " / "  + d);
				}
				else if (b*c*a*d == 24)
				{
					Output.setText("Try this equation: " + b + " * " + c + " * " + a + " * "  + d);
				}

		
		else if (c+(d+a+b) == 24) {
			Output.setText("Try this equation: " + c + " + (" + d + " + " + a + " + "  + b + ")");
		}
			else if (c+(d-a+b) == 24) {
				Output.setText("Try this equation: " + c + " + (" + d + " - " + a + " + "  + b + ")");
			}
				else if (c+(d-a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " - " + a + " - "  + b + ")");
				}
				else if (c+(d-a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " - " + a + " / "  + b + ")");
				}
				else if (c+(d-a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " - " + a + " * "  + b + ")");
				}
			else if (c+(d/a+b) == 24) {
				Output.setText("Try this equation: " + c + " + (" + d + " / " + a + " + "  + b + ")");
			}
				else if (c+(d/a-b) == 24){
					Output.setText("Try this equation: " + c + " + (" + d + " / " + a + " - "  + b + ")");
				}
				else if (c+(d/a/b) == 24){
					Output.setText("Try this equation: " + c + " + (" + d + " / " + a + " / "  + b + ")");
				}
				else if (c+(d/a*b) == 24){
					Output.setText("Try this equation: " + c + " + (" + d + " / " + a + " * "  + b + ")");
				}
				
			else if (c+(d*a+b) == 24) {
				Output.setText("Try this equation: " + c + " + (" + d + " * " + a + " + "  + b + ")");
			}
				else if (c+(d*a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " * " + a + " - "  + b + ")");
				}
				else if (c+(d*a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " * " + a + " / "  + b + ")");
				}
				else if (c+(d*a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " + (" + d + " * " + a + " * "  + b + ")");
				}
		

		
		else if (c-(d+a+b) == 24) {
			Output.setText("Try this equation: " + c + " - (" + d + " + " + a + " + "  + b + ")");
		}
			else if (c-(d-a+b) == 24) {
				Output.setText("Try this equation: " + c + " - (" + d + " - " + a + " + "  + b + ")");
			}
				else if (c-(d-a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " - " + a + " - "  + b + ")");
				}
				else if (c-(d-a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " - " + a + " / "  + b + ")");
				}
				else if (c-(d-a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " - " + a + " * "  + b + ")");
				}
			else if (c-(d/a+b) == 24) {
				Output.setText("Try this equation: " + c + " - (" + d + " / " + a + " + "  + b + ")");
			}
				else if (c-(d/a-b) == 24){
					Output.setText("Try this equation: " + c + " - (" + d + " / " + a + " - "  + b + ")");
				}
				else if (c-(d/a/b) == 24){
					Output.setText("Try this equation: " + c + " - (" + d + " / " + a + " / "  + b + ")");
				}
				else if (c-(d/a*b) == 24){
					Output.setText("Try this equation: " + c + " - (" + d + " / " + a + " * "  + b + ")");
				}
				
			else if (c-(d*a+b) == 24) {
				Output.setText("Try this equation: " + c + " - (" + d + " * " + a + " + "  + b + ")");
			}
				else if (c-(d*a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " * " + a + " - "  + b + ")");
				}
				else if (c-(d*a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " * " + a + " / "  + b + ")");
				}
				else if (c-(d*a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " - (" + d + " * " + a + " * "  + b + ")");
				}
		
		
		else if (c/(d+a+b) == 24) {
			Output.setText("Try this equation: " + c + " / (" + d + " + " + a + " + "  + b + ")");
		}
			else if (c/(d-a+b) == 24) {
				Output.setText("Try this equation: " + c + " / (" + d + " - " + a + " + "  + b + ")");
			}
				else if (c/(d-a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " - " + a + " - "  + b + ")");
				}
				else if (c/(d-a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " - " + a + " / "  + b + ")");
				}
				else if (c/(d-a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " - " + a + " * "  + b + ")");
				}
			else if (c/(d/a+b) == 24) {
				Output.setText("Try this equation: " + c + " / (" + d + " / " + a + " + "  + b + ")");
			}
				else if (c/(d/a-b) == 24){
					Output.setText("Try this equation: " + c + " / (" + d + " / " + a + " - "  + b + ")");
				}
				else if (c/(d/a/b) == 24){
					Output.setText("Try this equation: " + c + " / (" + d + " / " + a + " / "  + b + ")");
				}
				else if (c/(d/a*b) == 24){
					Output.setText("Try this equation: " + c + " / (" + d + " / " + a + " * "  + b + ")");
				}
				
			else if (c/(d*a+b) == 24) {
				Output.setText("Try this equation: " + c + " / (" + d + " * " + a + " + "  + b + ")");
			}
				else if (c/(d*a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " * " + a + " - "  + b + ")");
				}
				else if (c/(d*a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " * " + a + " / "  + b + ")");
				}
				else if (c/(d*a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " / (" + d + " * " + a + " * "  + b + ")");
				}
		

		
		
		else if (c*(d+a+b) == 24) {
			Output.setText("Try this equation: " + c + " * (" + d + " + " + a + " + "  + b + ")");
		}
			else if (c*(d-a+b) == 24) {
				Output.setText("Try this equation: " + c + " * (" + d + " - " + a + " + "  + b + ")");
			}
				else if (c*(d-a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " - " + a + " - "  + b + ")");
				}
				else if (c*(d-a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " - " + a + " / "  + b + ")");
				}
				else if (c*(d-a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " - " + a + " * "  + b + ")");
				}
			else if (c*(d/a+b) == 24) {
				Output.setText("Try this equation: " + c + " * (" + d + " / " + a + " + "  + b + ")");
			}
				else if (c*(d/a-b) == 24){
					Output.setText("Try this equation: " + c + " * (" + d + " / " + a + " - "  + b + ")");
				}
				else if (c*(d/a/b) == 24){
					Output.setText("Try this equation: " + c + " * (" + d + " / " + a + " / "  + b + ")");
				}
				else if (c*(d/a*b) == 24){
					Output.setText("Try this equation: " + c + " * (" + d + " / " + a + " * "  + b + ")");
				}
				
			else if (c*(d*a+b) == 24) {
				Output.setText("Try this equation: " + c + " * (" + d + " * " + a + " + "  + b + ")");
			}
				else if (c*(d*a-b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " * " + a + " - "  + b + ")");
				}
				else if (c*(d*a/b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " * " + a + " / "  + b + ")");
				}
				else if (c*(d*a*b) == 24)
				{
					Output.setText("Try this equation: " + c + " * (" + d + " * " + a + " * "  + b + ")");
				}

		
		
		else if (d+(c+a+b) == 24) {
			Output.setText("Try this equation: " + d + " + (" + c + " + " + a + " + "  + b + ")");
		}
			else if (d+(c-a+b) == 24) {
				Output.setText("Try this equation: " + d + " + (" + c + " - " + a + " + "  + b + ")");
			}
				else if (d+(c-a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " - " + a + " - "  + b + ")");
				}
				else if (d+(c-a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " - " + a + " / "  + b + ")");
				}
				else if (d+(c-a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " - " + a + " * "  + b + ")");
				}
			else if (d+(c/a+b) == 24) {
				Output.setText("Try this equation: " + d + " + (" + c + " / " + a + " + "  + b + ")");
			}
				else if (d+(c/a-b) == 24){
					Output.setText("Try this equation: " + d + " + (" + c + " / " + a + " - "  + b + ")");
				}
				else if (d+(c/a/b) == 24){
					Output.setText("Try this equation: " + d + " + (" + c + " / " + a + " / "  + b + ")");
				}
				else if (d+(c/a*b) == 24){
					Output.setText("Try this equation: " + d + " + (" + c + " / " + a + " * "  + b + ")");
				}
				
			else if (d+(c*a+b) == 24) {
				Output.setText("Try this equation: " + d + " + (" + c + " * " + a + " + "  + b + ")");
			}
				else if (d+(c*a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " * " + a + " - "  + b + ")");
				}
				else if (d+(c*a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " * " + a + " / "  + b + ")");
				}
				else if (d+(c*a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + c + " * " + a + " * "  + b + ")");
				}
		

		
		else if (d-(c+a+b) == 24) {
			Output.setText("Try this equation: " + d + " - (" + c + " + " + a + " + "  + b + ")");
		}
			else if (d-(c-a+b) == 24) {
				Output.setText("Try this equation: " + d + " - (" + c + " - " + a + " + "  + b + ")");
			}
				else if (d-(c-a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " - " + a + " - "  + b + ")");
				}
				else if (d-(c-a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " - " + a + " / "  + b + ")");
				}
				else if (d-(c-a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " - " + a + " * "  + b + ")");
				}
			else if (d-(c/a+b) == 24) {
				Output.setText("Try this equation: " + d + " - (" + c + " / " + a + " + "  + b + ")");
			}
				else if (d-(c/a-b) == 24){
					Output.setText("Try this equation: " + d + " - (" + c + " / " + a + " - "  + b + ")");
				}
				else if (d-(c/a/b) == 24){
					Output.setText("Try this equation: " + d + " - (" + c + " / " + a + " / "  + b + ")");
				}
				else if (d-(c/a*b) == 24){
					Output.setText("Try this equation: " + d + " - (" + c + " / " + a + " * "  + b + ")");
				}
				
			else if (d-(c*a+b) == 24) {
				Output.setText("Try this equation: " + d + " - (" + c + " * " + a + " + "  + b + ")");
			}
				else if (d-(c*a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " * " + a + " - "  + b + ")");
				}
				else if (d-(c*a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " * " + a + " / "  + b + ")");
				}
				else if (d-(c*a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + c + " * " + a + " * "  + b + ")");
				}
		
		
		else if (d/(c+a+b) == 24) {
			Output.setText("Try this equation: " + d + " / (" + c + " + " + a + " + "  + b + ")");
		}
			else if (d/(c-a+b) == 24) {
				Output.setText("Try this equation: " + d + " / (" + c + " - " + a + " + "  + b + ")");
			}
				else if (d/(c-a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " - " + a + " - "  + b + ")");
				}
				else if (d/(c-a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " - " + a + " / "  + b + ")");
				}
				else if (d/(c-a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " - " + a + " * "  + b + ")");
				}
			else if (d/(c/a+b) == 24) {
				Output.setText("Try this equation: " + d + " / (" + c + " / " + a + " + "  + b + ")");
			}
				else if (d/(c/a-b) == 24){
					Output.setText("Try this equation: " + d + " / (" + c + " / " + a + " - "  + b + ")");
				}
				else if (d/(c/a/b) == 24){
					Output.setText("Try this equation: " + d + " / (" + c + " / " + a + " / "  + b + ")");
				}
				else if (d/(c/a*b) == 24){
					Output.setText("Try this equation: " + d + " / (" + c + " / " + a + " * "  + b + ")");
				}
				
			else if (d/(c*a+b) == 24) {
				Output.setText("Try this equation: " + d + " / (" + c + " * " + a + " + "  + b + ")");
			}
				else if (d/(c*a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " * " + a + " - "  + b + ")");
				}
				else if (d/(c*a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " * " + a + " / "  + b + ")");
				}
				else if (d/(c*a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + c + " * " + a + " * "  + b + ")");
				}
		

		
		
		else if (d*(c+a+b) == 24) {
			Output.setText("Try this equation: " + d + " * (" + c + " + " + a + " + "  + b + ")");
		}
			else if (d*(c-a+b) == 24) {
				Output.setText("Try this equation: " + d + " * (" + c + " - " + a + " + "  + b + ")");
			}
				else if (d*(c-a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " - " + a + " - "  + b + ")");
				}
				else if (d*(c-a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " - " + a + " / "  + b + ")");
				}
				else if (d*(c-a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " - " + a + " * "  + b + ")");
				}
			else if (d*(c/a+b) == 24) {
				Output.setText("Try this equation: " + d + " * (" + c + " / " + a + " + "  + b + ")");
			}
				else if (d*(c/a-b) == 24){
					Output.setText("Try this equation: " + d + " * (" + c + " / " + a + " - "  + b + ")");
				}
				else if (d*(c/a/b) == 24){
					Output.setText("Try this equation: " + d + " * (" + c + " / " + a + " / "  + b + ")");
				}
				else if (d*(c/a*b) == 24){
					Output.setText("Try this equation: " + d + " * (" + c + " / " + a + " * "  + b + ")");
				}
				
			else if (d*(c*a+b) == 24) {
				Output.setText("Try this equation: " + d + " * (" + c + " * " + a + " + "  + b + ")");
			}
				else if (d*(c*a-b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " * " + a + " - "  + b + ")");
				}
				else if (d*(c*a/b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " * " + a + " / "  + b + ")");
				}
				else if (d*(c*a*b) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + c + " * " + a + " * "  + b + ")");
				}

		
		
		else if (d+(a+b+c) == 24) {
			Output.setText("Try this equation: " + d + " + (" + a + " + " + b + " + "  + c + ")");
		}
			else if (d+(a-b+c) == 24) {
				Output.setText("Try this equation: " + d + " + (" + a + " - " + b + " + "  + c + ")");
			}
				else if (d+(a-b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " - " + b + " - "  + c + ")");
				}
				else if (d+(a-b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " - " + b + " / "  + c + ")");
				}
				else if (d+(a-b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " - " + b + " * "  + c + ")");
				}
			else if (d+(a/b+c) == 24) {
				Output.setText("Try this equation: " + d + " + (" + a + " / " + b + " + "  + c + ")");
			}
				else if (d+(a/b-c) == 24){
					Output.setText("Try this equation: " + d + " + (" + a + " / " + b + " - "  + c + ")");
				}
				else if (d+(a/b/c) == 24){
					Output.setText("Try this equation: " + d + " + (" + a + " / " + b + " / "  + c + ")");
				}
				else if (d+(a/b*c) == 24){
					Output.setText("Try this equation: " + d + " + (" + a + " / " + b + " * "  + c + ")");
				}
				
			else if (d+(a*b+c) == 24) {
				Output.setText("Try this equation: " + d + " + (" + a + " * " + b + " + "  + c + ")");
			}
				else if (d+(a*b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " * " + b + " - "  + c + ")");
				}
				else if (d+(a*b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " * " + b + " / "  + c + ")");
				}
				else if (d+(a*b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " + (" + a + " * " + b + " * "  + c + ")");
				}
		

		
		else if (d-(a+b+c) == 24) {
			Output.setText("Try this equation: " + d + " - (" + a + " + " + b + " + "  + c + ")");
		}
			else if (d-(a-b+c) == 24) {
				Output.setText("Try this equation: " + d + " - (" + a + " - " + b + " + "  + c + ")");
			}
				else if (d-(a-b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " - " + b + " - "  + c + ")");
				}
				else if (d-(a-b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " - " + b + " / "  + c + ")");
				}
				else if (d-(a-b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " - " + b + " * "  + c + ")");
				}
			else if (d-(a/b+c) == 24) {
				Output.setText("Try this equation: " + d + " - (" + a + " / " + b + " + "  + c + ")");
			}
				else if (d-(a/b-c) == 24){
					Output.setText("Try this equation: " + d + " - (" + a + " / " + b + " - "  + c + ")");
				}
				else if (d-(a/b/c) == 24){
					Output.setText("Try this equation: " + d + " - (" + a + " / " + b + " / "  + c + ")");
				}
				else if (d-(a/b*c) == 24){
					Output.setText("Try this equation: " + d + " - (" + a + " / " + b + " * "  + c + ")");
				}
				
			else if (d-(a*b+c) == 24) {
				Output.setText("Try this equation: " + d + " - (" + a + " * " + b + " + "  + c + ")");
			}
				else if (d-(a*b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " * " + b + " - "  + c + ")");
				}
				else if (d-(a*b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " * " + b + " / "  + c + ")");
				}
				else if (d-(a*b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " - (" + a + " * " + b + " * "  + c + ")");
				}
		
		
		else if (d/(a+b+c) == 24) {
			Output.setText("Try this equation: " + d + " / (" + a + " + " + b + " + "  + c + ")");
		}
			else if (d/(a-b+c) == 24) {
				Output.setText("Try this equation: " + d + " / (" + a + " - " + b + " + "  + c + ")");
			}
				else if (d/(a-b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " - " + b + " - "  + c + ")");
				}
				else if (d/(a-b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " - " + b + " / "  + c + ")");
				}
				else if (d/(a-b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " - " + b + " * "  + c + ")");
				}
			else if (d/(a/b+c) == 24) {
				Output.setText("Try this equation: " + d + " / (" + a + " / " + b + " + "  + c + ")");
			}
				else if (d/(a/b-c) == 24){
					Output.setText("Try this equation: " + d + " / (" + a + " / " + b + " - "  + c + ")");
				}
				else if (d/(a/b/c) == 24){
					Output.setText("Try this equation: " + d + " / (" + a + " / " + b + " / "  + c + ")");
				}
				else if (d/(a/b*c) == 24){
					Output.setText("Try this equation: " + d + " / (" + a + " / " + b + " * "  + c + ")");
				}
				
			else if (d/(a*b+c) == 24) {
				Output.setText("Try this equation: " + d + " / (" + a + " * " + b + " + "  + c + ")");
			}
				else if (d/(a*b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " * " + b + " - "  + c + ")");
				}
				else if (d/(a*b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " * " + b + " / "  + c + ")");
				}
				else if (d/(a*b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " / (" + a + " * " + b + " * "  + c + ")");
				}
		

		
		
		else if (d*(a+b+c) == 24) {
			Output.setText("Try this equation: " + d + " * (" + a + " + " + b + " + "  + c + ")");
		}
			else if (d*(a-b+c) == 24) {
				Output.setText("Try this equation: " + d + " * (" + a + " - " + b + " + "  + c + ")");
			}
				else if (d*(a-b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " - " + b + " - "  + c + ")");
				}
				else if (d*(a-b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " - " + b + " / "  + c + ")");
				}
				else if (d*(a-b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " - " + b + " * "  + c + ")");
				}
			else if (d*(a/b+c) == 24) {
				Output.setText("Try this equation: " + d + " * (" + a + " / " + b + " + "  + c + ")");
			}
				else if (d*(a/b-c) == 24){
					Output.setText("Try this equation: " + d + " * (" + a + " / " + b + " - "  + c + ")");
				}
				else if (d*(a/b/c) == 24){
					Output.setText("Try this equation: " + d + " * (" + a + " / " + b + " / "  + c + ")");
				}
				else if (d*(a/b*c) == 24){
					Output.setText("Try this equation: " + d + " * (" + a + " / " + b + " * "  + c + ")");
				}
				
			else if (d*(a*b+c) == 24) {
				Output.setText("Try this equation: " + d + " * (" + a + " * " + b + " + "  + c + ")");
			}
				else if (d*(a*b-c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " * " + b + " - "  + c + ")");
				}
				else if (d*(a*b/c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " * " + b + " / "  + c + ")");
				}
				else if (d*(a*b*c) == 24)
				{
					Output.setText("Try this equation: " + d + " * (" + a + " * " + b + " * "  + c + ")");
				}

		
		
		
		
		else if (a+(d+c+b) == 24) {
			Output.setText("Try this equation: " + a + " + (" + d + " + " + c + " + "  + b + ")");
		}
			else if (a+(d-c+b) == 24) {
				Output.setText("Try this equation: " + a + " + (" + d + " - " + c + " + "  + b + ")");
			}
				else if (a+(d-c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " - " + c + " - "  + b + ")");
				}
				else if (a+(d-c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " - " + c + " / "  + b + ")");
				}
				else if (a+(d-c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " - " + c + " * "  + b + ")");
				}
			else if (a+(d/c+b) == 24) {
				Output.setText("Try this equation: " + a + " + (" + d + " / " + c + " + "  + b + ")");
			}
				else if (a+(d/c-b) == 24){
					Output.setText("Try this equation: " + a + " + (" + d + " / " + c + " - "  + b + ")");
				}
				else if (a+(d/c/b) == 24){
					Output.setText("Try this equation: " + a + " + (" + d + " / " + c + " / "  + b + ")");
				}
				else if (a+(d/c*b) == 24){
					Output.setText("Try this equation: " + a + " + (" + d + " / " + c + " * "  + b + ")");
				}
				
			else if (a+(d*c+b) == 24) {
				Output.setText("Try this equation: " + a + " + (" + d + " * " + c + " + "  + b + ")");
			}
				else if (a+(d*c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " * " + c + " - "  + b + ")");
				}
				else if (a+(d*c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " * " + c + " / "  + b + ")");
				}
				else if (a+(d*c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " + (" + d + " * " + c + " * "  + b + ")");
				}
		

		
		else if (a-(d+c+b) == 24) {
			Output.setText("Try this equation: " + a + " - (" + d + " + " + c + " + "  + b + ")");
		}
			else if (a-(d-c+b) == 24) {
				Output.setText("Try this equation: " + a + " - (" + d + " - " + c + " + "  + b + ")");
			}
				else if (a-(d-c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " - " + c + " - "  + b + ")");
				}
				else if (a-(d-c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " - " + c + " / "  + b + ")");
				}
				else if (a-(d-c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " - " + c + " * "  + b + ")");
				}
			else if (a-(d/c+b) == 24) {
				Output.setText("Try this equation: " + a + " - (" + d + " / " + c + " + "  + b + ")");
			}
				else if (a-(d/c-b) == 24){
					Output.setText("Try this equation: " + a + " - (" + d + " / " + c + " - "  + b + ")");
				}
				else if (a-(d/c/b) == 24){
					Output.setText("Try this equation: " + a + " - (" + d + " / " + c + " / "  + b + ")");
				}
				else if (a-(d/c*b) == 24){
					Output.setText("Try this equation: " + a + " - (" + d + " / " + c + " * "  + b + ")");
				}
				
			else if (a-(d*c+b) == 24) {
				Output.setText("Try this equation: " + a + " - (" + d + " * " + c + " + "  + b + ")");
			}
				else if (a-(d*c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " * " + c + " - "  + b + ")");
				}
				else if (a-(d*c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " * " + c + " / "  + b + ")");
				}
				else if (a-(d*c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " - (" + d + " * " + c + " * "  + b + ")");
				}
		
		
		else if (a/(d+c+b) == 24) {
			Output.setText("Try this equation: " + a + " / (" + d + " + " + c + " + "  + b + ")");
		}
			else if (a/(d-c+b) == 24) {
				Output.setText("Try this equation: " + a + " / (" + d + " - " + c + " + "  + b + ")");
			}
				else if (a/(d-c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " - " + c + " - "  + b + ")");
				}
				else if (a/(d-c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " - " + c + " / "  + b + ")");
				}
				else if (a/(d-c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " - " + c + " * "  + b + ")");
				}
			else if (a/(d/c+b) == 24) {
				Output.setText("Try this equation: " + a + " / (" + d + " / " + c + " + "  + b + ")");
			}
				else if (a/(d/c-b) == 24){
					Output.setText("Try this equation: " + a + " / (" + d + " / " + c + " - "  + b + ")");
				}
				else if (a/(d/c/b) == 24){
					Output.setText("Try this equation: " + a + " / (" + d + " / " + c + " / "  + b + ")");
				}
				else if (a/(d/c*b) == 24){
					Output.setText("Try this equation: " + a + " / (" + d + " / " + c + " * "  + b + ")");
				}
				
			else if (a/(d*c+b) == 24) {
				Output.setText("Try this equation: " + a + " / (" + d + " * " + c + " + "  + b + ")");
			}
				else if (a/(d*c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " * " + c + " - "  + b + ")");
				}
				else if (a/(d*c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " * " + c + " / "  + b + ")");
				}
				else if (a/(d*c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " / (" + d + " * " + c + " * "  + b + ")");
				}
		

		
		
		else if (a*(d+c+b) == 24) {
			Output.setText("Try this equation: " + a + " * (" + d + " + " + c + " + "  + b + ")");
		}
			else if (a*(d-c+b) == 24) {
				Output.setText("Try this equation: " + a + " * (" + d + " - " + c + " + "  + b + ")");
			}
				else if (a*(d-c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " - " + c + " - "  + b + ")");
				}
				else if (a*(d-c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " - " + c + " / "  + b + ")");
				}
				else if (a*(d-c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " - " + c + " * "  + b + ")");
				}
			else if (a*(d/c+b) == 24) {
				Output.setText("Try this equation: " + a + " * (" + d + " / " + c + " + "  + b + ")");
			}
				else if (a*(d/c-b) == 24){
					Output.setText("Try this equation: " + a + " * (" + d + " / " + c + " - "  + b + ")");
				}
				else if (a*(d/c/b) == 24){
					Output.setText("Try this equation: " + a + " * (" + d + " / " + c + " / "  + b + ")");
				}
				else if (a*(d/c*b) == 24){
					Output.setText("Try this equation: " + a + " * (" + d + " / " + c + " * "  + b + ")");
				}
				
			else if (a*(d*c+b) == 24) {
				Output.setText("Try this equation: " + a + " * (" + d + " * " + c + " + "  + b + ")");
			}
				else if (a*(d*c-b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " * " + c + " - "  + b + ")");
				}
				else if (a*(d*c/b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " * " + c + " / "  + b + ")");
				}
				else if (a*(d*c*b) == 24)
				{
					Output.setText("Try this equation: " + a + " * (" + d + " * " + c + " * "  + b + ")");
				}
				else
				{
					Output.setText("No Solution!, Please Refresh ---------------->");
				}

	

		

	}
}