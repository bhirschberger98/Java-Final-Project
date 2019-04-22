import javafx.scene.image.Image;

public class Card {
	private int value;
	private Image image;
	public Card(Image image,int value) {
		this.value=value;
		this.image=image;
	}
	public int getValue() {
		return value;
	}
	public Image getImage() {
		return image;
	}
	@Override
	public String toString() {
		return "Value:"+value+ ", Image: "+image.impl_getUrl();
	}
}
