package blackJackGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

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
		
		// > Header (NORTH)
		JPanel headerPanel = createHeaderPanel();
		add(headerPanel, BorderLayout.NORTH);
		
		// > Table (CENTER)
		JPanel tablePanel = createTablePanel();
		add(tablePanel, BorderLayout.CENTER);
		
		// > Controls (SOUTH)
		JPanel controlsPanel = createControlsPanel();
		add(controlsPanel, BorderLayout.SOUTH);
	}

	private JPanel createControlsPanel()
	{
		JPanel controlsPanel = new JPanel();
		controlsPanel.setPreferredSize(new Dimension(0, 70));
		controlsPanel.setBackground(Color.DARK_GRAY);
		return controlsPanel;
	}

	/**
	 * Creates and returns the main playing table containing 
	 * the dealer, status, and player panels.
	 */
	private JPanel createTablePanel()
	{
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(Color.GRAY);
		tablePanel.setLayout(new GridBagLayout());
		
		// >> Dealer panel (TOP)
		JPanel dealerPanel = createDealerPanel();
		GridBagConstraints gbc_dealerPanel = new GridBagConstraints();
		gbc_dealerPanel.gridx = 0;
		gbc_dealerPanel.gridy = 0;
		gbc_dealerPanel.weightx = 1.0;
		gbc_dealerPanel.weighty = 1.0;
		gbc_dealerPanel.fill = GridBagConstraints.BOTH;
		tablePanel.add(dealerPanel, gbc_dealerPanel);
		
		// >> Status panel (MIDDLE)
		JPanel statusPanel = createStatusPanel();
		GridBagConstraints gbc_statusPanel = new GridBagConstraints();
		gbc_statusPanel.gridx = 0;
		gbc_statusPanel.gridy = 1;
		gbc_statusPanel.weightx = 1.0;
		gbc_statusPanel.weighty = 0.0;
		gbc_statusPanel.fill = GridBagConstraints.BOTH;
		tablePanel.add(statusPanel, gbc_statusPanel);
		
		// >> Player panel (BOTTOM)
		JPanel playerPanel = createPlayerPanel();
		GridBagConstraints gbc_playerPanel = new GridBagConstraints();
		gbc_playerPanel.gridx = 0;
		gbc_playerPanel.gridy = 2;
		gbc_playerPanel.weightx = 1.0;
		gbc_playerPanel.weighty = 1.0;
		gbc_playerPanel.fill = GridBagConstraints.BOTH;
		tablePanel.add(playerPanel, gbc_playerPanel);
		
		return tablePanel;
	}
	
	private JPanel createDealerPanel()
	{
		JPanel dealerPanel = new JPanel();
		dealerPanel.setBackground(new Color(0, 106, 213));
		dealerPanel.setLayout(new BorderLayout(0, 0));
		
		// >>> Dealer label (NORTH)
		JLabel dealerLabel = new JLabel("Dealer", SwingConstants.CENTER);
		dealerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		dealerPanel.add(dealerLabel, BorderLayout.NORTH);
		
		// >>> Dealer's hand (CENTER)
		JPanel dealerHandPanel = new JPanel();
		dealerHandPanel.setBackground(Color.CYAN);
		dealerHandPanel.setLayout(new FlowLayout());
		dealerPanel.add(dealerHandPanel, BorderLayout.CENTER);
		
		return dealerPanel;
	}
	
	private JPanel createStatusPanel()
	{
		JPanel statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(0, 60));
		statusPanel.setBackground(Color.ORANGE);
		statusPanel.setLayout(new FlowLayout());
		return statusPanel;
	}
	
	private JPanel createPlayerPanel()
	{
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.GREEN);
		playerPanel.setLayout(new BorderLayout(0, 0));
		
		// >>> Player label (NORTH)
		JLabel playerLabel = new JLabel("Player", SwingConstants.CENTER);
		playerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		playerPanel.add(playerLabel, BorderLayout.SOUTH);
		
		// >>> Player's hand (CENTER)
		JPanel playerHandPanel = new JPanel();
		playerHandPanel.setBackground(Color.YELLOW);
		playerHandPanel.setLayout(new FlowLayout());
		playerPanel.add(playerHandPanel, BorderLayout.CENTER);
		
		return playerPanel;
	}
	
	private JPanel createHeaderPanel()
	{
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		headerPanel.setPreferredSize(new Dimension(0, 60));
		headerPanel.setBackground(Color.DARK_GRAY);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JButton storeBtn = new JButton("STORE");
		storeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		storeBtn.setBackground(Color.WHITE);
		storeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showScreen("STORE");
			}
		});
		headerPanel.add(storeBtn, BorderLayout.EAST);
		
		JLabel balanceLbl = new JLabel("Balance: 0$");
		balanceLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		balanceLbl.setForeground(Color.WHITE);
		headerPanel.add(balanceLbl, BorderLayout.WEST);
		return headerPanel;
	}
}
