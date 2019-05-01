import javafx.scene.image.Image;


public class Card {
	private Integer value;
	private Image image;
	public Card(Image image,int value) {
		this.value=value;
		this.image=image;
	}
	public Integer getValue() {
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
