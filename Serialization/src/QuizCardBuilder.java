import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardBuilder {

	private JFrame frame;
	private JTextArea question;
	private JTextArea answer;

	private ArrayList<QuizCard> cardList;

	public static void main(String[] args) {
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}

	public void go() {

		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();

		Font bigFont = new Font("sansserif", Font.BOLD, 24);

		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);

		JScrollPane qScroller = new JScrollPane(question);
		qScroller
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		answer = new JTextArea(6, 20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);

		JScrollPane aScroller = new JScrollPane(answer);
		aScroller
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton nextButton = new JButton("Next Card");

		cardList = new ArrayList<QuizCard>();

		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");

		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);

		// define Button Action
		nextButton.addActionListener(new NextCardListener());

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);

		JMenu helpMenu = new JMenu("Help");

		JMenuItem aboutMenuItem = new JMenuItem("About");
		JMenuItem versionMenuItem = new JMenuItem("Version");
		aboutMenuItem.addActionListener(new AboutMenuListener());
		versionMenuItem.addActionListener(new VersionMenuListener());

		helpMenu.add(aboutMenuItem);
		helpMenu.add(versionMenuItem);

		// Add both menus to the MenuBar now
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// Add the MenuBar to the Frame
		frame.setJMenuBar(menuBar);

		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class NextCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			clearScreen();
		}
	}

	private void clearScreen() {
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}

	class NewMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			cardList.clear();
			clearScreen();
		}
	}

	class SaveMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);

			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}

	public void saveFile(File file) {

		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);

			for (QuizCard x : cardList) {
				writer.write(x.getQuestion());
				writer.write("/");
				writer.write(x.getAnswer());
				writer.write("\n");
			}

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class AboutMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO
			// Add action to menu item
		}
	}

	class VersionMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO
			// Add action to menu item
		}
	}
}
