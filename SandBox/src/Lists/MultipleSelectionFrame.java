package Lists;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame {

	private JButton copyButton;
	private JList<String> colorList;
	private JList<String> copyList;

	private static final String[] colors = { "Black", "Blue", "Red", "Green",
			"Orange", "Purple", "Violet", "Brown", "White", "Yellow" };

	public MultipleSelectionFrame() {
		super("Multiple Selection Frame");
		setLayout(new FlowLayout());

		colorList = new JList<String>(colors);
		colorList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		add(new JScrollPane(colorList));

		copyButton = new JButton("Copy");
		copyButton.addActionListener(new ActionListener() {

			// @SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				List<String> cList = colorList.getSelectedValuesList();
				String[] stringObj = cList.toArray(new String[0]);
				copyList.setListData(stringObj);

			}
		});

		add(copyButton);
		copyList = new JList<String>();
		copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyList));

	}
}
