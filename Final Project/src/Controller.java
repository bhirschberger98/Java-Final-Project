import java.io.File;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
		card1.setImage(cards[new Random().nextInt(51)].getImage());
		card2.setImage(cards[new Random().nextInt(51)].getImage());
		card3.setImage(cards[new Random().nextInt(51)].getImage());
		card4.setImage(cards[new Random().nextInt(51)].getImage());
	}
	public void checkExpression(ActionEvent event) {
		if (Input.getText() == null)  				// In case the user does not enter any sort of expression
		{
			Output.setText("Please Enter An Expression");
		}
		else if (Input.getText() == "24")
		{
			Output.setText("Correct!");
		}
		else
		{
			Output.setText("Incorrect!");
		}
	}
}