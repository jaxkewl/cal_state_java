package menustuff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class MenuFrame extends JFrame {

	private final Color[] colorValues = { Color.BLACK, Color.RED, Color.BLUE,
			Color.GREEN };
	private JRadioButtonMenuItem[] colorItems;
	private JRadioButtonMenuItem[] fontItems;
	private JCheckBoxMenuItem[] styleItems;
	private JLabel displayJLabel;
	private ButtonGroup fontButtonGroup;
	private ButtonGroup colorButtonGroup;
	private int style;

	public MenuFrame() {

		super("Using JMenus");

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic('A');
		fileMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MenuFrame.this,
						"This is an example of \nusing menus", "About",
						JOptionPane.PLAIN_MESSAGE);

			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		fileMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);

		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('r');
		String[] colors = toColorString();

		// color menu stuff
		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic('C');

		displayJLabel = new JLabel("Sample Text");

		// add each color item to the button group and add an item handler
		colorItems = new JRadioButtonMenuItem[colors.length];
		String[] fontNames = { "Serif", "Monospaced", "SansSerif" };
		fontItems = new JRadioButtonMenuItem[fontNames.length];

		colorButtonGroup = new ButtonGroup();
		ItemHandler itemHandler = new ItemHandler();

		for (int i = 0; i < colors.length; i++) {
			colorItems[i] = new JRadioButtonMenuItem(colors[i]);
			colorMenu.add(colorItems[i]);
			colorButtonGroup.add(colorItems[i]);
			colorItems[i].addItemListener(itemHandler);
		}

		colorItems[0].setSelected(true);
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();

		// font menu stuff
		
		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic('n');

		fontButtonGroup = new ButtonGroup();

		for (int i = 0; i < fontNames.length; i++) {
			fontItems[i] = new JRadioButtonMenuItem(fontNames[i]);
			fontMenu.add(fontItems[i]);
			fontButtonGroup.add(fontItems[i]);
			fontItems[i].addItemListener(itemHandler);
		}

		fontItems[0].setSelected(true);
		fontMenu.addSeparator();

		// add style stuff as check box menu items
		String[] styleNames = { "Bold", "Italics" };
		styleItems = new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler = new StyleHandler();

		for (int i = 0; i < styleNames.length; i++) {
			styleItems[i] = new JCheckBoxMenuItem(styleNames[i]);
			fontMenu.add(styleItems[i]);
			styleItems[i].addItemListener(styleHandler);
		}

		formatMenu.add(fontMenu);
		bar.add(formatMenu);

		// set the label so the user knows whats changing

		displayJLabel.setFont(new Font(styleNames[0], Font.PLAIN, 72));
		add(displayJLabel);
	}

	private class ItemHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			// handle the colors first
			for (int i = 0; i < colorItems.length; i++) {
				if (colorItems[i].isSelected()) {
					displayJLabel.setForeground(colorValues[i]);
					break;
				}
			}

			// handle the font next
			for (int i = 0; i < fontItems.length; i++) {
				if (e.getSource() == fontItems[i]) {
					displayJLabel.setFont(new Font(fontItems[i].getText(),
							style, 72));
				}
			}
			repaint();
		}

	}

	private class StyleHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// determine what styles were selected

			String currentFont = displayJLabel.getFont().getName();
			Font font;

			if (styleItems[0].isSelected() && styleItems[1].isSelected()) {
				style = Font.BOLD + Font.ITALIC;
				font = new Font(currentFont, style, 72);
			} else if (styleItems[0].isSelected()
					&& !styleItems[1].isSelected()) {
				style = Font.BOLD;
				font = new Font(currentFont, style, 72);
			} else if (!styleItems[0].isSelected()
					&& styleItems[1].isSelected()) {
				style = Font.ITALIC;
				font = new Font(currentFont, style, 72);
			} else {
				style = 0;
				font = new Font(currentFont, style, 72);
			}

			displayJLabel.setFont(font);
			repaint();
		}
	}

	private String[] toColorString() {
		String[] colorStrings = new String[colorValues.length];
		int i = 0;
		for (Color color : colorValues) {
			colorStrings[i++] = color.toString();
		}
		return colorStrings;
	}

	public static void main(String[] args) {
		MenuFrame menuFrame = new MenuFrame();
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(600, 400);
		menuFrame.setVisible(true);

	}
}
