package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewAllJobsJPanel extends JPanel {
	
	JTextArea list;
	JScrollPane scroll;
	private JButton btnBackToMain;

	/**
	 * Create the panel.
	 */
	public ViewAllJobsJPanel() {
		JPanel form = new JPanel();
		JLabel title = new JLabel("DETAILS FOR ALL JOBS");
		
		@SuppressWarnings("unchecked")
		String allJobs = "Dummy data";//formatAllCourses(allCourses);
		
		JTextArea commentTextArea = new JTextArea(allJobs,5,20);
	
		scroll = new JScrollPane(commentTextArea);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(450, 200));
        
        btnBackToMain = new JButton("Back to Main");
        ButtonListener bl = new ButtonListener();
        btnBackToMain.addActionListener(bl);
        
		
		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		form.add(btnBackToMain, BorderLayout.SOUTH);
		
		add(form);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnBackToMain){
				removeAll();
				   setVisible(false);
		           MainMenuJPanel newPanel = new MainMenuJPanel();
		           add(newPanel);
		           System.out.println("switching to MainMenu JPanel");//for debugging purposes
		           validate();
		           setVisible(true);
		          
			}
			
		}
		
	}
	
	public String formatAllCourses(ArrayList<Course> c){
		StringBuilder sb = new StringBuilder();
		if(fileHelper.doesAFileExist()){
		for(Course a: c){
			sb.append(a.getCourseName() + " --- CRN " + a.getCRN());
			sb.append("\n     Start Time: " + a.getStartTime() + "  End Time: "+ a.getEndTime());
			sb.append("\n     Location: " + a.getLocation().getCampus() + " Building " + a.getLocation().getBuilding() + " Room #" + a.getLocation().getRoomNumber() + " | " + a.getLocation().getType() + " | Max Cap:" + a.getLocation().getCapacity());
			sb.append("\n     Instructor: " + a.getTeacher().getFirstName() + " " + a.getTeacher().getLastName() + " | " + a.getTeacher().getEmail());
			sb.append("\n\n");
		}
		} else {
			sb.append("No courses saved.  Return to previous screen to enter data.");
		}
		
		return sb.toString();
	}

}
