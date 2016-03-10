package spambot;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SpamBot extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JButton spamButton;
	JLabel previewLabel;
	JTextField spamField;
	TextTransfer textTransfer;

	public SpamBot() {
		super("spambot by bkeys");
		setLayout(new BorderLayout());
		Handler h = new Handler();
		textTransfer = new TextTransfer();
		mainPanel = new JPanel();

		// making the spam button
		spamButton = new JButton("spam");
		spamButton.addActionListener(h);
		mainPanel.add(spamButton);

		// making the field for the text
		spamField = new JTextField("text you want to spam here", 20);
		mainPanel.add(spamField);

		// preview header
		previewLabel = new JLabel("preview");
		previewLabel
				.setToolTipText("This is a preview of the text you want to spam");
		mainPanel.add(previewLabel);

		add(mainPanel);
	}

	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == spamButton) {
				Robot robot = null;
				textTransfer.setClipboardContents(spamField.getText());

				try {
					robot = new Robot();
				} catch (AWTException e) {
					e.printStackTrace();
				}
				
				for(int i = 0; i < 500; ++i) {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
				}
			}
		}
	}

	public static void main(String[] args) {
		
	    SpamBot s = new SpamBot();

		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(275, 180);
		s.setVisible(true);

		// spamContent = s.spamField.getText();
	}
}
