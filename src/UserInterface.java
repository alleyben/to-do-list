import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface implements Runnable{
	
	private JFrame frame = new JFrame("Do It All!");
	private Container cont = frame.getContentPane();
	private JPanel listPanel = new JPanel();
	private JScrollPane window = new JScrollPane(); // implement this as full window
	
	@Override
	public void run() {
		//frame.setPreferredSize(new Dimension(400, 800));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents();
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void createComponents() {
		cont.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		///////// top and input entry ////////////////////
		
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 0.5;
		gbc.gridy = 0;
		cont.add(createInputPanel(), gbc);
		
		///////// bottom and list ////////////////////////
		
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.weighty = 1;
		gbc.gridy = 1;
		cont.add(createListPanel(), gbc);
				
		//top is constant height,
		//top and bottom are same width
	}
	
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(300, 200));
		JLabel prompt = new JLabel("What shall we do today?");
		JTextArea task = new JTextArea(10, 20);
		task.setLineWrap(true);
		task.setWrapStyleWord(true);
		JButton doItButton = new JButton("Let's do it!");
		
		///////////////// do it button listener///////////////////////
		
		doItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListItem item = new ListItem(task, listPanel, frame);
				String input = task.getText();
				item.createPanel(input);
				task.setText("");
				frame.validate();
				frame.repaint();
			}
		});
		
		panel.add(prompt, BorderLayout.NORTH);
		panel.add(task); /////////////////////////////////////// make it look better
		panel.add(doItButton, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JScrollPane createListPanel() {
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JScrollPane scroll = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(300, 500));
		scroll.setVisible(true);
		return scroll;
	}
}
