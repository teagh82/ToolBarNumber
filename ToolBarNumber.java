import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBarNumber extends JFrame {	
	private Container c;
	
	public ToolBarNumber() {
		setTitle("���ڰ� �ƴ� Ű�� �ԷµǴ� ��� ���â �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		createToolBar();
		setSize(400,200);
		setVisible(true);
	}
	
	// ���ٸ� �����Ͽ� �������ҿ� �����Ѵ�.
	private void createToolBar() {
		// ���� ����
		JToolBar toolBar = new JToolBar("Number input");
		toolBar.setBackground(Color.LIGHT_GRAY);
		JTextField text= new JTextField();
		
		// ���ٿ� �޴��� ����� ������Ʈ�� �����Ѵ�.
		toolBar.add(new JLabel("�й�"));
		toolBar.add(text);
		
		text.addKeyListener(new KeyAdapter() {		
			public void keyTyped(KeyEvent e) {
				int ch =  (int)e.getKeyChar();
				if(ch < 48 || ch > 58) {
					JOptionPane.showMessageDialog(null,  e.getKeyChar() + "�� ����Ű�� �ƴմϴ�.\n ���ڸ� �Է��ϼ���.", 
							"���", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		
		// ���ٸ� ���������� SOUTH�� �����Ѵ�.
		c.add(toolBar, BorderLayout.SOUTH);
	}
	
	public static void main(String [] args) {
		new ToolBarNumber();
	}
}