package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface State {
	void keyPressed(KeyEvent e);
	void keyReleased(KeyEvent e);
	void mouseClicked(MouseEvent e);
	void update();
	void enterState();
}
