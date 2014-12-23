package gridlayout;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame implements ActionListener {

	private JButton[] buttons;
	private static final String[] names = { "one", "two", "three", "four",
			"five", "six" };

	private boolean toggle = true;
	private Container container;
	private GridLayout gridLayout1;
	private GridLayout gridLayout2;

	public GridLayoutFrame() {
		super("Grid Layout Frame Class");

		gridLayout1 = new GridLayout(2, 3, 5, 5);
		gridLayout2 = new GridLayout(3, 2);

		container = getContentPane();

		setLayout(gridLayout1);
		buttons = new JButton[names.length];

		for (int i = 0; i < names.length; i++) {
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (toggle) {
			setLayout(gridLayout2);
		} else {
			setLayout(gridLayout1);
		}

		toggle = !toggle;
		container.validate();
	}

	public static void main(String[] args) {
		GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(200, 200);
		gridLayoutFrame.setVisible(true);

	}

}
