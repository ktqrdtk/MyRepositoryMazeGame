package bensPackage;

import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import controls.Controls;
import controls.MoveAction;

public class Player
{
	public static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	public MyJFrame frame;
	private InputMap inputMap;
	private ActionMap actionMap;
	private int curGrid;
	
	public void frameInstantiated()
	{
		bindControls();
	}
	
	public void bindControls()
	{
		inputMap = frame.getMainPane().getInputMap(IFW);
		actionMap = frame.getMainPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke("W"), Controls.UP_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("S"), Controls.DOWN_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("A"), Controls.LEFT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke("D"), Controls.RIGHT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), Controls.UP_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), Controls.DOWN_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), Controls.LEFT_ACTION);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), Controls.RIGHT_ACTION);
		actionMap.put(Controls.UP_ACTION, new MoveAction(Controls.UP_ACTION));
		actionMap.put(Controls.DOWN_ACTION, new MoveAction(Controls.DOWN_ACTION));
		actionMap.put(Controls.LEFT_ACTION, new MoveAction(Controls.LEFT_ACTION));
		actionMap.put(Controls.RIGHT_ACTION, new MoveAction(Controls.RIGHT_ACTION));
	}
}