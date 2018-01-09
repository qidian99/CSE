/*
 * GUI of Calendar, print the message on JFrame, make user submit events,
 * resolve conflicts.
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calendar{
	public static void main(String [] args) {
		JFrame frame = new JFrame("My Calendar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 425);
		
		/*
		 * The text field used to display results
		 * Maybe JLabel is better.
		 */
		JLabel text = new JLabel();
		//text.setHorizontalAlignment(JLabel.CENTER);
		text.setPreferredSize(new Dimension(225,225));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.CENTER);
		JPanel controlPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel subPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		textPanel.setPreferredSize(new Dimension(225,225));
		subPanel.setPreferredSize(new Dimension(125,200));
		subPanel.setLayout(new GridLayout(3,1));
		//((GridLayout) subPanel.getLayout()).setVgap(10);
		
		
		JPanel roomPanel = new JPanel();
		JLabel roomLabel = new JLabel("Please Select Room");
		JComboBox<String> room = new JComboBox<String>(new String[] {"A", "B", "C"});
		//room.setSize(new Dimension(text.getWidth(), text.getHeight()));
		room.setPreferredSize(new Dimension(100,20));
		roomPanel.add(roomLabel);
		roomPanel.add(room);
		
		JPanel datePanel = new JPanel();
		JLabel dateLabel = new JLabel("Please Select Date");
		JComboBox<Integer> time = new JComboBox<Integer>(new Integer[] {1,2,3,4});
		time.setPreferredSize(new Dimension(100,20));
		datePanel.add(dateLabel);
		datePanel.add(time);

		JPanel durationPanel = new JPanel();
		JLabel durationLabel = new JLabel("Please Enter Duration");
		JNumberTextField duration = new JNumberTextField("30");
		duration.setPreferredSize(new Dimension(100,20));
		durationPanel.add(durationLabel);
		durationPanel.add(duration);
		
		subPanel.add(datePanel);
		subPanel.add(roomPanel);
		subPanel.add(durationPanel);
		
		textPanel.add(text);
		
		controlPanel.add(subPanel);
		controlPanel.add(textPanel);
			
		frame.add(controlPanel, BorderLayout.CENTER);
		
		/*
		 * The button that is used to submit event
		 */
		JButton btn = new JButton("Add Event");
		//EventHandler listener = new EventHandler();
		//btn.addActionListener(listener);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("Event Added");
			}
		});
		frame.add(btn, BorderLayout.SOUTH);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		
		//add actionlistener to btn
		/* an error here: 
				The method addActionListener(ActionListener) in the type AbstractButton is 
				not applicable for the arguments (new ActionListener(){})
				ActionListener cannot be resolved to a type
				ActionEvent cannot be resolved to a type
		   Reason: forgot to import java.awt.event.*;
		 */

	}
	

/*
}
class EventHandler implements ActionListener{
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		System.out.println("Event added!");
	}

	
}
*/
}

class JNumberTextField extends JTextField {
    private static final long serialVersionUID = 1L;
    
    public JNumberTextField(String n) {
    	super(n);
    }
    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isDigit(ev.getKeyChar())) {
            super.processKeyEvent(ev);
        }
        ev.consume();
        return;
    }

    /**
     * As the user is not even able to enter a dot ("."), only integers (whole numbers) may be entered.
     */
    public Long getNumber() {
        Long result = null;
        String text = getText();
        if (text != null && !"".equals(text)) {
            result = Long.valueOf(text);
        }
        return result;
    }
}