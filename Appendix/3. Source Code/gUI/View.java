package gUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class View extends JFrame {
	private Librarypanel librarypanel;
	private User user;
	private Administrator administrator;

	private JPanel cardPanel;
	private CardLayout cardLayout;
	private String mode;

	public View(Controller ctr) {
		super("Library system");

		createComponents(ctr);
		intializeComponents();
		addComponents();
		this.mode = "cardLibrarypanel";
	}

	private void createComponents(Controller ctr) {
		librarypanel = new Librarypanel();
		user = new User(ctr);
		administrator = new Administrator(ctr);

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
	}

	private void intializeComponents() {
		setResizable(false);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponents() {
		cardPanel.add(librarypanel, "cardLibrarypanel");
		cardPanel.add(user, "cardUser");
		cardPanel.add(administrator, "cardAdministrator");
		setContentPane(cardPanel);
	}

	public void start(Controller controller) {
		GUIButtonHandler handler = new GUIButtonHandler(controller);
		librarypanel.addActionListener(handler);
		user.addActionListener(handler);
		administrator.addActionListener(handler);

		setVisible(true);
		System.out.println(mode);
	}

//	public String[] getInput() {
//		if (mode.equals("cardUser")) {
//			return user.getInput();
//		}
//
//		else
//			return null;
//	}

	public void setMode(String mode) {
		this.mode = mode;
		cardLayout.show(cardPanel, mode);
	}

	public String getMode() {
		return mode;
	}

//	public void clear() {
//		if (mode.equals("cardUser")) {
//			user.clear();
//		}
//	}
	
	public void execute(String what) {
		if (getMode().equals("cardLibrarypanel")) {
			if (what.equals("User")) {
				setMode("cardUser");
			}
			if (what.equals("Administrator")) {
				setMode("cardAdministrator");
			}
		}
		if (getMode().equals("cardUser")) {
			if (what.equals("Back"))
				setMode("cardLibrarypanel");
		}
		if (getMode().equals("cardAdministrator")) {
			if (what.equals("Back"))
				setMode("cardLibrarypanel");
		}
	}

	private class GUIButtonHandler implements ActionListener {
		private Controller controller;

		public GUIButtonHandler(Controller controller) {
			this.controller = controller;
		}

		public void actionPerformed(ActionEvent e) {
			String mode = e.getActionCommand();
			System.out.println(mode);
			execute(mode);
		}
	}
	
	

}
