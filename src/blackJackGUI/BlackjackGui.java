package blackJackGUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BlackjackGui extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private GamePanel gamePanel;
	private StorePanel storePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					BlackjackGui frame = new BlackjackGui();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Card deck images: https://mreliptik.itch.io/playing-cards-packs-52-cards
	 */
	public BlackjackGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		
		gamePanel = new GamePanel(this);
		storePanel = new StorePanel(this);
		
		contentPane.add(gamePanel, "GAME");
		contentPane.add(storePanel, "STORE");
	}
	
	public void showScreen(String screenName)
	{
		cardLayout.show(contentPane, screenName);
	}
}
