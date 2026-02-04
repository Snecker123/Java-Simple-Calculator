package calculatorGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTree;

public class CalculatorApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private StringBuilder sb = new StringBuilder("0");
	private Double operator1 = 0.0;
	private Double operator2 = 0.0;
	private Double result = null;
	private Character sign = '\0';
	private Boolean decPoint = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp frame = new CalculatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorApp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("0");
		textPane.setBounds(45, 37, 242, 50);
		contentPane.add(textPane);
		
		JButton btnNumber0 = new JButton("0");
		btnNumber0.addActionListener(e -> {
			String number = sb.toString();
			if(!sb.toString().equals("0") || (number.contains("1") && number.contains("2") && number.contains("3") && number.contains("4")
					&& number.contains("5") && number.contains("6") && number.contains("7") && number.contains("8") && number.contains("9")) 
					|| !sign.equals('\0'))
			{
				sb.append('0');
				textPane.setText(sb.toString());
			}
		});
		btnNumber0.setBounds(108, 342, 53, 50);
		contentPane.add(btnNumber0);
		
		JButton btnNumber1 = new JButton("1");
		btnNumber1.addActionListener(e -> {
			sb.append('1');
			textPane.setText(sb.toString());
		});
		btnNumber1.setBounds(45, 159, 53, 50);
		contentPane.add(btnNumber1);
		
		JButton btnNumber2 = new JButton("2");
		btnNumber2.addActionListener(e -> {
			sb.append('2');
			textPane.setText(sb.toString());
		});
		btnNumber2.setBounds(108, 159, 53, 50);
		contentPane.add(btnNumber2);
		
		JButton btnNumber3 = new JButton("3");
		btnNumber3.addActionListener(e -> {
			sb.append('3');
			textPane.setText(sb.toString());
		});
		btnNumber3.setBounds(171, 159, 53, 50);
		contentPane.add(btnNumber3);
		
		JButton btnNumber4 = new JButton("4");
		btnNumber4.addActionListener(e -> {
			sb.append('4');
			textPane.setText(sb.toString());
		});
		btnNumber4.setBounds(45, 220, 53, 50);
		contentPane.add(btnNumber4);
		
		JButton btnNumber5 = new JButton("5");
		btnNumber5.addActionListener(e -> {
			sb.append('5');
			textPane.setText(sb.toString());
		});
		btnNumber5.setBounds(108, 220, 53, 50);
		contentPane.add(btnNumber5);
		
		JButton btnNumber6 = new JButton("6");
		btnNumber6.addActionListener(e -> {
			sb.append('6');
			textPane.setText(sb.toString());
		});
		btnNumber6.setBounds(171, 220, 53, 50);
		contentPane.add(btnNumber6);
		
		JButton btnNumber7 = new JButton("7");
		btnNumber7.addActionListener(e -> {
			sb.append('7');
			textPane.setText(sb.toString());
		});
		btnNumber7.setBounds(45, 281, 53, 50);
		contentPane.add(btnNumber7);
		
		JButton btnNumber8 = new JButton("8");
		btnNumber8.addActionListener(e -> {
			sb.append('8');
			textPane.setText(sb.toString());
		});
		btnNumber8.setBounds(108, 281, 53, 50);
		contentPane.add(btnNumber8);
		
		JButton btnNumber9 = new JButton("9");
		btnNumber9.addActionListener(e -> {
			sb.append('9');
			textPane.setText(sb.toString());
		});
		btnNumber9.setBounds(171, 281, 53, 50);
		contentPane.add(btnNumber9);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(e -> {
			decPoint = false;
			sign = '+';
			operator1 = Double.parseDouble(sb.toString());
			sb.delete(0, sb.length());
			textPane.setText("+");
		});
		btnPlus.setBounds(234, 159, 53, 50);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(e -> {
			if (sb.toString().equals("") || (sb.toString().equals("-") && sign.equals('\0')) ) {
				sb.setLength(0);
				sb.append('-');
				textPane.setText(sb.toString());
			} else {
				decPoint = false;
				sign = '-';
				operator1 = Double.parseDouble(sb.toString());
				sb.delete(0, sb.length());
				textPane.setText("-");
			}
		});
		btnMinus.setBounds(234, 220, 53, 50);
		contentPane.add(btnMinus);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(e -> {
			decPoint = false;
			sign = '*';
			operator1 = Double.parseDouble(sb.toString());
			sb.delete(0, sb.length());
			textPane.setText("*");
		});
		btnMult.setBounds(234, 281, 53, 50);
		contentPane.add(btnMult);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(e -> {
			decPoint = false;
			sign = '/';
			operator1 = Double.parseDouble(sb.toString());
			sb.delete(0, sb.length());
			textPane.setText("/");
		});
		btnDiv.setBounds(234, 342, 53, 50);
		contentPane.add(btnDiv);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(e -> {
			sb.delete(0, sb.length());
			sb.insert(0, "");
			textPane.setText(sb.toString());
			operator1 = 0.0;
			operator2 = 0.0;
			sign = '\0';
			decPoint = false;
			result = null;
		});
		btnClear.setBounds(45, 342, 53, 50);
		contentPane.add(btnClear);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(e -> {
			if(sb.toString().equals("")) {}
			else {
				sb.deleteCharAt(sb.length()-1);
				textPane.setText(sb.toString());
			}
		});
		btnDel.setBounds(171, 98, 116, 50);
		contentPane.add(btnDel);
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(e -> {
			if(decPoint == false) {
				sb.append('.');
				textPane.setText(sb.toString());
				decPoint = true;
			}
		});
		btnDecimal.setBounds(171, 342, 53, 50);
		contentPane.add(btnDecimal);
		
		JButton btnEqu = new JButton("Equ");
		btnEqu.addActionListener(e -> {
			if(sb.length() == 0 && sign.equals('\0')) {}
			else {
			
				operator2 = Double.parseDouble(sb.toString());

				Boolean err = false;
			
				switch(sign) {
					case '+' -> result = operator1 + operator2;
					case '-' -> result = operator1 - operator2;
					case '*' -> result = operator1 * operator2;
					case '/' -> { 
						if(operator2 == 0.0) {
							err = true;
						} else {
							result = operator1 / operator2;
						}
					}
					default -> {}
				}
			
				operator1 = 0.0;
				operator2 = 0.0;
				sign = '\0';
				decPoint = false;
			
				sb.delete(0, sb.length());
				sb.insert(0, "");
			
				if(err) {
					textPane.setText("Syntax Error!");
					operator1 = 0.0;
				} else {
					sb.append(result);
					textPane.setText(sb.toString());
					operator1 = result;
				}
			}
		});
		btnEqu.setBounds(45, 98, 116, 50);
		contentPane.add(btnEqu);

		
	}
}
