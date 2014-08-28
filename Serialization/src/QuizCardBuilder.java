import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class QuizCardBuilder {

	private JFrame frame;
	private JTextArea question;
	private JTextArea answer;
//	private ArrayList<QuizCard> cardList;
	
	
	public static void main(String [] args){
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}
	
	public void go(){
		
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		
		Font bigFont = new Font("sansserif", Font.BOLD, 24);
		
		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer = new JTextArea(6, 20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		
	//	cardList = new ArrayList<QuizCard>();
		
		JLabel qLabel = qLabel = new JLabel("Question:");
		JLabel aLabel = aLabel = new JLabel("Anser");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
