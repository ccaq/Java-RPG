//add code here jake
package RPGC;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

public class RPGC {

	boolean running = false;

	String title = "The RPG";

	private JFrame frmRpgCanute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPGC window = new RPGC();
					window.frmRpgCanute.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RPGC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		PlayerInfo player1 = new PlayerInfo();
		player1.gold = 10;
		
		// These are all of the items
		ArrayList<Item> inv = new ArrayList<Item>();
		Item woodenSword = new Item("Wooden Sword");
		Item smallHealthPotion = new Item("Small Health Potion");

		inv.add(woodenSword);
		inv.add(smallHealthPotion);

		woodenSword.give(0);
		smallHealthPotion.give(1);
		
		Inventory inv1 = new Inventory();
		// End of items

		frmRpgCanute = new JFrame();
		frmRpgCanute.setTitle("RPG - Canute and CCAP");
		frmRpgCanute.setBounds(100, 100, 800, 600);
		frmRpgCanute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRpgCanute.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel navBar = new JPanel();
		frmRpgCanute.getContentPane().add(navBar, "name_16351445078554");
		navBar.setOpaque(false);
		navBar.setLayout(null);
		navBar.setVisible(false);
		
		JLabel lblLevel = new JLabel(player1.toString());
		lblLevel.setFont(new Font("Cambria", Font.BOLD, 18));
		lblLevel.setForeground(new Color(255, 255, 255));
		lblLevel.setVerticalAlignment(SwingConstants.TOP);
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBackground(new Color(0, 0, 0));
		lblLevel.setBounds(0, 51, 266, 511);
		navBar.add(lblLevel);
		lblLevel.setVisible(false);
		
		JLabel lblInv = new JLabel(inv1.displayInv(inv));
		lblInv.setBackground(new Color(0, 0, 0));
		lblInv.setForeground(new Color(255, 255, 255));
		lblInv.setVerticalAlignment(SwingConstants.TOP);
		lblInv.setHorizontalAlignment(SwingConstants.CENTER);
		lblInv.setFont(new Font("Cambria", Font.BOLD, 18));
		lblInv.setBounds(264, 51, 267, 511);
		navBar.add(lblInv);
		lblInv.setVisible(false);

		JButton btnPlayerStats = new JButton("Player Stats");
		btnPlayerStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Player Stats button was clicked");
				if (lblLevel.isOpaque()) {
					lblLevel.setOpaque(false);
				} else {
					lblLevel.setOpaque(true);
				}
				if (lblLevel.isVisible()) {
					lblLevel.setVisible(false);
				} else {
					lblLevel.setVisible(true);
				}
				
			}
		});
		btnPlayerStats.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnPlayerStats.setBounds(0, 0, 266, 50);
		navBar.add(btnPlayerStats);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Inventory button was clicked");
				if (lblInv.isOpaque()) {
					lblInv.setOpaque(false);
				} else {
					lblInv.setOpaque(true);
				}
				if (lblInv.isVisible()) {
					lblInv.setVisible(false);
				} else {
					lblInv.setVisible(true);
				}
				
			}
		});
		btnInventory.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnInventory.setBounds(264, 0, 267, 50);
		navBar.add(btnInventory);
		
		JButton btnQuest = new JButton("Quests");
		btnQuest.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnQuest.setBounds(529, 0, 266, 50);
		navBar.add(btnQuest);
		
		
		
		final JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		frmRpgCanute.getContentPane().add(panelMenu, "name_17034844565383");
		panelMenu.setLayout(null);
		panelMenu.setVisible(true);

		final JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		frmRpgCanute.getContentPane().add(panel1, "name_17038793241167");
		panel1.setLayout(null);
		panel1.setVisible(false);

		JButton playButton = new JButton("Start Game");
		playButton.setBounds(280, 246, 223, 69);
		panelMenu.add(playButton);
		playButton.setFont(new Font("Cambria", Font.PLAIN, 22));

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(280, 357, 223, 69);
		panelMenu.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("The exit button was clicked.");
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("Cambria", Font.PLAIN, 22));

		JLabel lblTheRpg = new JLabel(title);
		lblTheRpg.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheRpg.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 64));
		lblTheRpg.setBounds(98, 72, 580, 96);
		panelMenu.add(lblTheRpg);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				running = true;
				System.out.println("The start game button was clicked.");
				panelMenu.setVisible(false);
				panel1.setVisible(true);
				navBar.setVisible(true);
			}
		});

		JLabel labelWelcome = new JLabel("Welcome to CCAP and Canute's RPG!");
		labelWelcome.setFont(new Font("Cambria", Font.BOLD, 20));
		labelWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		labelWelcome.setBounds(119, 55, 546, 40);
		panel1.add(labelWelcome);

		JLabel lblOpen = new JLabel(
				"<html>You suddenly awake. You are in a strange land. The only things you have are an empty coin pouch and the clothes on your back.</html>");
		lblOpen.setVerticalAlignment(SwingConstants.TOP);
		lblOpen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpen.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblOpen.setBounds(205, 195, 374, 82);
		panel1.add(lblOpen);

		JButton button = new JButton("Nope");
		button.setBounds(335, 363, 89, 23);
		panel1.add(button);		

		while (running) {

		}

	}
}
