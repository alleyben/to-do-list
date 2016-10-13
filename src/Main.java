import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new UserInterface());
	}

}
//!!!!!!!!!!!!!!!! bug, scroll pane of tasks shrinks to nothing if jframe window smaller than its preferred size //////////////////
//!!!!!!!!!!!!!!!! workaround: set minimum size for window (kinda annoying though
//!!!!!!!!!!!!!!!! or set all panels in scroll window (this)

//you gotta do what you gotta do
//jframe container / user interface
//submit button
//j frame goes into list
//finished button (strikethrough) and close button for each item
//
//top is set width length
//bottom is three times longer, same width, scrolls --> jlist


//encapsulate whole window in scroll pane
//max window size? or just pack

//list items uniform size instead of just swelling to fill container

//font cross out

//database and saving