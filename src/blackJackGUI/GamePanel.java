package blackJackGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private BlackjackGui gui;

	/**
	 * Create the panel.
	 */
	public GamePanel(BlackjackGui gui)
	{
		this.gui = gui;
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("STORE");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showScreen("STORE");
			}
		});
		add(btnNewButton, BorderLayout.CENTER);
	}

}
