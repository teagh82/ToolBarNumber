import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBarNumber extends JFrame {	
	private Container c;
	
	public ToolBarNumber() {
		setTitle("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		createToolBar();
		setSize(400,200);
		setVisible(true);
	}
	
	// 툴바를 생성하여 컨텐츠팬에 부착한다.
	private void createToolBar() {
		// 툴바 생성
		JToolBar toolBar = new JToolBar("Number input");
		toolBar.setBackground(Color.LIGHT_GRAY);
		JTextField text= new JTextField();
		
		// 툴바에 메뉴로 사용할 컴포넌트를 삽입한다.
		toolBar.add(new JLabel("학번"));
		toolBar.add(text);
		
		text.addKeyListener(new KeyAdapter() {		
			public void keyTyped(KeyEvent e) {
				int ch =  (int)e.getKeyChar();
				if(ch < 48 || ch > 58) {
					JOptionPane.showMessageDialog(null,  e.getKeyChar() + "는 숫자키가 아닙니다.\n 숫자를 입력하세요.", 
							"경고", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		
		// 툴바를 컨텐츠팬의 SOUTH에 부착한다.
		c.add(toolBar, BorderLayout.SOUTH);
	}
	
	public static void main(String [] args) {
		new ToolBarNumber();
	}
}