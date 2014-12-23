package ComboBox;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import LabelFrame.LabelFrame;

public class ComboBoxFrame extends JFrame {

	JComboBox jComboBox;
	JLabel jLabel;

	private String[] names = { "bug1.GIF", "bug2.GIF", "travelbug.gif",
			"buganim.gif" };

	private URL[] urlArray = new URL[4];

	public ComboBoxFrame() {
		super("Combo Box Frame");
		setLayout(new FlowLayout());

		urlArray[0] = getClass().getResource("/ComboBox/res/" + names[0]);
		urlArray[1] = getClass().getResource("/ComboBox/res/" + names[1]);
		urlArray[2] = getClass().getResource("/ComboBox/res/" + names[2]);
		urlArray[3] = getClass().getResource("/ComboBox/res/" + names[3]);

		jLabel = new JLabel(names[0]);
		jLabel.setIcon(new ImageIcon(urlArray[0]));
		add(jLabel);

		jComboBox = new JComboBox(names);
		//jComboBox.setMaximumRowCount(3);
		add(jComboBox);
		
		jComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					int selectedIndex = jComboBox.getSelectedIndex();

					jLabel.setText(urlArray[selectedIndex].toString());
					jLabel.setIcon(new ImageIcon(urlArray[selectedIndex]));
				}
			}
		});

	}

}
