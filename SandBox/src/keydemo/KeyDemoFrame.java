package keydemo;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener {

	private String line1;
	private String line2;
	private String line3;

	private JTextArea textArea;

	public KeyDemoFrame() {
		super("Key Listener Demo");

		textArea = new JTextArea();
		textArea.setSize(10, 15);
		textArea.setText("Press any key");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		add(textArea);

		addKeyListener(this);

		setSize(400, 500);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		line1 = "Key pressed " + KeyEvent.getKeyText(arg0.getKeyCode());
		setLines2and3(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		line1 = "Key released " + KeyEvent.getKeyText(arg0.getKeyCode());
		setLines2and3(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		line1 = "Key typed " + arg0.getKeyChar();
		setLines2and3(arg0);

	}

	public static void main(String[] args) {
		KeyDemoFrame kdf = new KeyDemoFrame();
		kdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kdf.setVisible(true);
	}

	private void setLines2and3(KeyEvent event) {

		String isActionString = (event.isActionKey()) ? "" : "not";
		line2 = "this key is " + isActionString + " action key ";

		String keyModifier = KeyEvent.getKeyModifiersText(event.getModifiers());
		line3 = "key modified " + keyModifier;

		textArea.setText(line1 + "\n" + line2 + "\n" + line3);
	}

}
