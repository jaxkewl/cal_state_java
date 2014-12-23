package RadioButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioButtonFrame extends JFrame {

	private JTextField textField;

	private String fontStype = "Serif";
	private int size = 14;

	// declare the fonts
	private Font plainFont = new Font(fontStype, Font.PLAIN, size);
	private Font boldFont = new Font(fontStype, Font.BOLD, size);
	private Font italicsFont = new Font(fontStype, Font.ITALIC, size);
	private Font boldItalicsFont = new Font(fontStype, Font.BOLD + Font.ITALIC,
			size);

	// declare the radio buttons
	private JRadioButton boldRadioButton;
	private JRadioButton italicsRadioButton;
	private JRadioButton boldItalicsRadioButton;
	private JRadioButton plainRadioButton;

	// declare the button group, so we know which button are mutually exclusive
	private ButtonGroup buttonGroup;

	public RadioButtonFrame() {
		super("Radio Button Frame");
		setLayout(new FlowLayout());

		textField= new JTextField("Pay attention to this text!",40);
		add(textField);
		
		// initialize the text that will appear
		boldRadioButton = new JRadioButton("Bold");
		add(boldRadioButton);

		italicsRadioButton = new JRadioButton("Italics");
		add(italicsRadioButton);

		boldItalicsRadioButton = new JRadioButton("Bold + Italics");
		add(boldItalicsRadioButton);

		plainRadioButton = new JRadioButton("Plain",true);
		add(plainRadioButton);

		// initialize the event handler with the correct constructor
		RadioEventHandler plainEventHandler = new RadioEventHandler(plainFont);
		RadioEventHandler boldEventHandler = new RadioEventHandler(boldFont);
		RadioEventHandler boldItalicsEventHandler = new RadioEventHandler(
				boldItalicsFont);
		RadioEventHandler italicsEventHandler = new RadioEventHandler(
				italicsFont);

		// add the event handler to the radio button
		boldRadioButton.addItemListener(boldEventHandler);
		italicsRadioButton.addItemListener(italicsEventHandler);
		plainRadioButton.addItemListener(plainEventHandler);
		boldItalicsRadioButton.addItemListener(boldItalicsEventHandler);

		// add the radio button to the button group
		buttonGroup = new ButtonGroup();
		buttonGroup.add(boldRadioButton);
		buttonGroup.add(italicsRadioButton);
		buttonGroup.add(boldItalicsRadioButton);
		buttonGroup.add(plainRadioButton);
	}

	private class RadioEventHandler implements ItemListener {

		private Font font;

		public RadioEventHandler(Font font) {
			this.font = font;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			textField.setFont(font);
		}

	}

}
