import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListItem{
	
	private JTextArea entry;
	private JPanel container;
	private JLabel task;
	private JPanel panel;
	private JFrame frame;
	
	public ListItem (JTextArea entry, JPanel container, JFrame frame) {
		this.entry = entry;
		this.container = container;
		this.frame = frame;
	}
	
	public void createPanel(String text) {
		this.panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(180, 100));
		panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.task = new JLabel(text);
		
		panel.add(task); // get this centered
		panel.add(createSidebar(), BorderLayout.SOUTH);
		
		container.add(panel);		
	}
	
	private JPanel createSidebar() {
		JPanel sideBar = new JPanel(new GridLayout(1,2));
		
		JButton done = new JButton("Did it!");
		JButton dele = new JButton("Delete it!");
		
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = task.getText();
				//cross out text string
				task.setText(input + " Did it!"); //for now, cross out in the end ///////////////////////////////////////// edit
				frame.validate();
				frame.repaint();
			}
		});
		dele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.remove(panel);
				frame.validate();
				frame.repaint();
			}
		});
		
		sideBar.add(done);
		sideBar.add(dele);
		
		return sideBar;
	}
	
	public String getText() {
		return entry.getText();
	}
	
	public void removePanel() {
		container.remove(panel);
	}
}
