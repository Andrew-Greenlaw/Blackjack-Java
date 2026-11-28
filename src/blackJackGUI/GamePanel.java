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
import javax.swing.JTextField;
import java.awt.GridLayout;

public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private BlackjackGui gui;
	
	private JLabel currBetLbl;
	private JLabel betMultLbl;
	private JLabel rndResultLbl;

	private JTextField betTxtField;
	private JButton chngBetBtn;
	private JButton dealBtn;
	private JButton hitBtn;
	private JButton standBtn;

	private JLabel balanceLbl;

	private JLabel dealerLabel;

	private JPanel dealerHandPanel;
	private JPanel playerHandPanel;
	
	
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
		controlsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		controlsPanel.setPreferredSize(new Dimension(0, 70));
		controlsPanel.setBackground(Color.DARK_GRAY);
		
		JPanel betInputPanel = new JPanel();
		betInputPanel.setOpaque(false);
		controlsPanel.add(betInputPanel);
		
		JLabel usdSignLbl = new JLabel("$");
		usdSignLbl.setForeground(Color.WHITE);
		usdSignLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		betInputPanel.add(usdSignLbl);
		
		betTxtField = new JTextField();
		betTxtField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		betTxtField.setText("25");
		betTxtField.setPreferredSize(new Dimension(0, 28));
		betTxtField.setColumns(10);
		// Use in logic for disabling during a round: betTxtField.setEnabled(false);
		betInputPanel.add(betTxtField);
		
		chngBetBtn = new JButton("Change Bet");
		chngBetBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chngBetBtn.setPreferredSize(new Dimension(110, 40));
		//Use in logic for disabling during a round: chngBetBtn.setEnabled(false);
		betInputPanel.add(chngBetBtn);
		
		dealBtn = new JButton("Deal");
		dealBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dealBtn.setPreferredSize(new Dimension(110, 40));
		//Use in logic for disabling during a round: dealBtn.setEnabled(false);
		controlsPanel.add(dealBtn);
		
		hitBtn = new JButton("Hit");
		hitBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hitBtn.setPreferredSize(new Dimension(110, 40));
		controlsPanel.add(hitBtn);
		
		standBtn = new JButton("Stand");
		standBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		standBtn.setPreferredSize(new Dimension(110, 40));
		controlsPanel.add(standBtn);
		
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
		dealerPanel.setBackground(new Color(124, 252, 0));
		dealerPanel.setLayout(new BorderLayout(0, 0));
		
		dealerLabel = new JLabel("Dealer: Fred", SwingConstants.CENTER);
		dealerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		dealerPanel.add(dealerLabel, BorderLayout.NORTH);
		
		dealerHandPanel = new JPanel();
		dealerHandPanel.setBackground(new Color(0, 180, 0));
		dealerHandPanel.setLayout(new FlowLayout());
		dealerPanel.add(dealerHandPanel, BorderLayout.CENTER);
		
		return dealerPanel;
	}
	
	private JPanel createStatusPanel()
	{
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(2, 1));
		statusPanel.setPreferredSize(new Dimension(0, 60));
		statusPanel.setBackground(new Color(0, 100, 0));
		
		JPanel betDisplayPanel = new JPanel();
		betDisplayPanel.setOpaque(false);
		statusPanel.add(betDisplayPanel);
		
		currBetLbl = new JLabel("Current Bet: $25");
		currBetLbl.setForeground(Color.WHITE);
		currBetLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		betDisplayPanel.add(currBetLbl);
		
		betMultLbl = new JLabel(" x2");
		betMultLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		betMultLbl.setForeground(Color.YELLOW);
		//Use in logic for when a multiplier card is pulled: betMultLbl.setVisible(true);
		betDisplayPanel.add(betMultLbl);
		
		rndResultLbl = new JLabel("Round Won! Natural Blackjack. Payout: 2.5x bet.");
		rndResultLbl.setForeground(Color.WHITE);
		rndResultLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		rndResultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statusPanel.add(rndResultLbl);
		
		return statusPanel;
	}
	
	private JPanel createPlayerPanel()
	{
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(new Color(124, 252, 0));
		playerPanel.setLayout(new BorderLayout(0, 0));
		
		// >>> Player label (NORTH)
		JLabel playerLabel = new JLabel("Player - 18", SwingConstants.CENTER);
		playerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		playerPanel.add(playerLabel, BorderLayout.SOUTH);
		
		playerHandPanel = new JPanel();
		playerHandPanel.setBackground(new Color(0, 180, 0));
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
		storeBtn.setBackground(new Color(255, 255, 255));
		storeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showScreen("STORE");
			}
		});
		headerPanel.add(storeBtn, BorderLayout.EAST);
		
		balanceLbl = new JLabel("Balance: $0");
		balanceLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		balanceLbl.setForeground(Color.WHITE);
		headerPanel.add(balanceLbl, BorderLayout.WEST);
		return headerPanel;
	}
}
