package bensPackage;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyJButton extends JButton{
	
	public MyJButton(String name, int horPos, String actionCom, boolean enabled)
	{
		super(name);
		this.setHorizontalTextPosition(horPos);
		this.setActionCommand(actionCom);
		this.setEnabled(enabled);
	}
	
	public MyJButton(String name, int horPos, String actionCom)
	{
		this(name, horPos, actionCom, true);
	}
	
}
