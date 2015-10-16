package spam;
import javax.swing.JFrame;

public class Main {

	
	public static void main(String[] args) {
		
	    SpamBot s = new SpamBot();

		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(275, 180);
		s.setVisible(true);

		// spamContent = s.spamField.getText();
	}

}
