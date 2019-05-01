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
    
    @FXML
    private Integer num1, num2, num3, num4;

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
		num1 = new Random().nextInt(51);
		num2 = new Random().nextInt(51);
		num3 = new Random().nextInt(51);
		num4 = new Random().nextInt(51);
		card1.setImage(cards[num1].getImage());
		card2.setImage(cards[num2].getImage());
		card3.setImage(cards[num3].getImage());
		card4.setImage(cards[num4].getImage());
	}
	
	public void checkExpression(ActionEvent event) {
		//Checks that the card values are present in the equation
		if(Input.getText().contains(cards[num1].getValue().toString())	
				&& Input.getText().contains(cards[num2].getValue().toString())
				&& Input.getText().contains(cards[num3].getValue().toString())
				&& Input.getText().contains(cards[num4].getValue().toString())) 
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
}