import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class _gui extends JFrame{
	private static int WIDTH = 1280;
	private static int HEIGTH = 800;
	
	JPanel appPanel = new JPanel();
	JLabel headLine;
	JLabel outputHeadLine;
	JLabel logo;
	Icon accenture;
	JButton startoperation;
	JTextArea inputArea;
	JTextArea outputArea;
	JLabel editableField;
	
	public _gui(String Header){
		//GUI Begin
		super(Header);
		setLayout(new BorderLayout());
		setBounds(0, 0, WIDTH, HEIGTH);
		
		JMenuBar menubar = new JMenuBar();
		JMenu File = new JMenu("FILE");
		menubar.add(File);
		JMenuItem ResetGUI = new JMenuItem("Reset Current GUI");
		JMenuItem Info = new JMenuItem("Information and Guide");
		JMenuItem Exit = new JMenuItem("Exit");
		File.add(ResetGUI);
		File.add(Info);
		File.add(Exit);
		setJMenuBar(menubar);
		
		editableField = new JLabel("<html>Developed by ÝLKEM EROL.<br><br>Current workable programming languages;<br>>Basic Java Code<br>>Full CSS files.");
		editableField.setForeground(Color.WHITE);
		editableField.setBounds(690, 300, 300, 300);
		
		headLine = new JLabel("Please Copy and Paste Your Code in the Box");
		headLine.setForeground(Color.WHITE);
		headLine.setBounds(10, 10, 300, 15);
		
		inputArea = new JTextArea();
		JScrollPane ScrollInput = new JScrollPane(inputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ScrollInput.setBounds(10, 30, 570, 700);
		
		startoperation = new JButton(">>");
		startoperation.setBounds(610, 75, 50, 100);
		
		outputHeadLine = new JLabel("Your Results");
		outputHeadLine.setForeground(Color.WHITE);
		outputHeadLine.setBounds(690, 10, 300, 15);
		
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		JScrollPane ScrollOutput = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ScrollOutput.setBounds(690, 30, 570, 175);
		
		
		
		appPanel.setLayout(null);
		appPanel.setBackground(Color.darkGray);
		appPanel.add(headLine);
		appPanel.add(ScrollInput);
		appPanel.add(startoperation);
		appPanel.add(outputHeadLine);
		appPanel.add(editableField);
		appPanel.add(ScrollOutput);
		
		Listener list = new Listener();
		startoperation.addActionListener(list);
		ResetGUI.addActionListener(list);
		Info.addActionListener(list);
		Exit.addActionListener(list);
		
		add(appPanel);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//GUI End
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent click){
			if(click.getActionCommand() == "Reset Current GUI"){
				inputArea.setText("");
				outputArea.setText("");
			}
			if(click.getActionCommand() == "Information and Guide"){
				JOptionPane.showMessageDialog(appPanel, "NULL", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			if(click.getActionCommand() == "Exit"){
				System.exit(0);
			}
			if(click.getActionCommand() == ">>"){
				String input = inputArea.getText();
				if(input.length() == 0 || input.length() == 1){
					JOptionPane.showMessageDialog(appPanel, "Sorry! Please, Write at least two word. Because, every single word is palindrome :)", "Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					/*String[] splitStr = null;
					splitStr = input.split(" |\n");
					for(int i=0; i<splitStr.length; i++){
						String sendStr = splitStr[i];
						_codechecker obj = new _codechecker(sendStr);
						outputArea.append(obj.operation());
					}*/
					_codechecker obj = new _codechecker(input);
					outputArea.setText(obj.operation());
				}
			}
		}
	}
	public static void main(String args[]){
		new _gui("By Ýlkem EROL");
	}
}
