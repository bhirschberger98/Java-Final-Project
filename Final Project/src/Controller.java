import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Controller {
	private Card[] cards=new Card[52];
    
	@FXML
    private Pane pane;
	//loads in cards when program is loaded
	{
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
		displayCards();
	}
	
	public void displayCards() {
		
	}
}
