import java.awt.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

/**
 * Display all components of 24-point game. The components are a refresh button, a panel with four labels with card 
 * image icons, a text field for an expression, and a verify button.
 */
 
public class TwentyFourPointsPanel extends JFrame{
	   /**
	    * These four variables will hold random numbers
	    */
		int num1=0; 
		int num2=0; 
		int num3=0; 
		int num4=0;
		int sum = 0; // sum be the result of current cards
		int answer;
		/**
		* The rules button
		*/
		private JButton rulesOfGame;
	   /**
	   * The refresh button
	   */
	  private JButton refresh;
	  /**
	   * The verify button
	   */
	  private JButton verify;
	  /**
	   * The cards panel
	   */
	  private JTextField expression;
	  /**
	   * The first card label
	   */
	  private JLabel card1;
	  /**
	   * The second card label
	   */
	  private JLabel card2;
	  /**
	   * The third card label
	   */
	  private JLabel card3;
	  /**
	   * The fourth card label
	   */
	  private JLabel card4;
	  /**
	   * The 52 image icons
	   */
	  private ImageIcon[] cardIcons = new ImageIcon[52];
	  /**
	   * The 52 integers from 1 to 52
	   */
	  private ArrayList<Integer> list = new ArrayList<Integer>();
	  
	  /**
	   * Current card values
	   */
	  private ArrayList<Integer> currentCardValues = new ArrayList<Integer>();
	  /**
	   * if the numbers are repeated in expression then show a different message
	   * for that repeated  boolean is used as flag
	   */
	  boolean repeated = false; 
	  /**
	   * If expression contains other elements then the card elements
	   * then dont evaluate and show message. For that the variable notContain comes handy
	   */
	  boolean isContained = false;
	  public void refresh() {
		  /**
		     * 4 Random Cards Number generator
		     *  Random class object is inititated to generate randoms
		     */
			Random rn = new Random();
			sum=0;
			/**
			 * The while loop is used to generate random
			 *  that are non-conflicting and doesn't=0
			 */
			
			while((num1==num2 && num2==num3 && num1==num4 && num2==num4 && num3==num4) && (num1==0 && num2==0 && num3==0 && num4==0)) {
				num1 = rn.nextInt((53 - 1 )+1);   // (UpperBound - LowerBound)+LowerBounds
				num2 = rn.nextInt((53 - 1 )+1); 
				num3 = rn.nextInt((53 - 1 )+1);
				num4 = rn.nextInt((53 - 1 )+1);
				/**
				 * In any case if any of below number is zero 
				 * then it will be re obtained randomly
				 */
				
				if(num1==0)
					num1 = rn.nextInt((53 - 1 )+1);
				if(num2==0)
					num2 = rn.nextInt((53 - 1 )+1);
				if(num3==0)
					num3 = rn.nextInt((53 - 1 )+1);
				if(num4==0)
					num4 = rn.nextInt((53 - 1 )+1);
			} 
			
			/**
			 * Setting the values for the cards
			 * i-e  An Ace, King, Queen, and Jack represent 1, 13, 12, and 11
			 * and  Each card represents a number
			 * 
			 */
			/**
			 * When it's Jack
			 */
			if(num1==11 || num1==24 ||  num1==37 || num1==50) {
				// represent's jack
				list.add(11); // for jack
				sum+=sum+11;
				
			}
			if(num2==11 || num2==25 || num2==37 || num2==50) {
				// represent's jack
				list.add(11); // for jack
				sum+=sum+11;
			}
			if(num3==11 || num3==24 || num3==37 || num3==50) {
				// represent's jack
				list.add(11); // for jack
				sum+=sum+11;
			}
			if(num4==11 || num4==24 || num4==37 || num4==50) {
				// represent's jack
				list.add(11); // for jack
				sum+=sum+11;
			}
			
			/**
			 * When it's Queen
			 */
			if(num1==12 || num1==25 || num1==38 || num1==51) {
				// represent's Queen
				list.add(12); // for Queen
				sum+=sum+12;
			}
			if(num2==12 || num2==25 || num1==38 || num2==51) {
				list.add(12); 
				sum+=sum+12;
			}
			if(num3==12 || num3==25 || num3==38 || num3==51) {
				list.add(12);	
				sum+=sum+12;
			}
			if(num4==12 || num4==25 || num4==38 || num4==51) {
				
				list.add(12);
				sum+=sum+12;
			}
			/**
			 * When it's King
			 */
			if(num1==13 || num1==26 || num1==39 || num1==52) {
				// represent's King
				list.add(13); // for King
				sum+=sum+13;
			}
			if(num2==13 || num2==26 || num2==39 || num2==52) {
				// represent's King
				list.add(13); // for King
				sum+=sum+13;
			}
			if(num3==13 || num3==26 || num3==39 || num3==52) {
				// represent's King
				list.add(13); // for King
				sum+=sum+13;
			}
			if(num4==13 || num4==26 || num4==39 || num4==52) {
				// represent's King
				list.add(13); // for King
				sum+=sum+13;
			}
			/**
			 * When it's Ace
			 */
			if(num1==14 || num1==27 || num1==40 || num1==1) {
				// represent's Acce
				list.add(1); // for Ace
				sum+=sum+1;
			}
			if(num2==14 || num2==27 || num2==40 || num2==1) {
				// represent's Acce
				list.add(1); // for Ace
				sum+=sum+1;
			}
			if(num3==14 || num3==27 || num3==40 || num3==1) {
				// represent's Acce
				list.add(1); // for Ace
				sum+=sum+1;
			}
			if(num4==14 || num4==27 || num4==40 || num4==1) {
				// represent's Acce
				list.add(1); // for Ace
				sum+=sum+1;
			}
			/**
			 * for All 2's
			 */
			if(num1==15 || num1==28 || num1==41 || num1==2) {
				list.add(2);
				sum+=sum+2;
			}
			if(num2==15 || num2==28 || num2==41 || num2==2) {
				list.add(2);
				sum+=sum+2;
			}
			if(num3==15 || num3==28 || num3==41 || num3==2) {
				list.add(2);
				sum+=sum+2;
			}
			if(num4==15 || num4==28 || num4==41 || num4==2) {
				list.add(2);
				sum+=sum+2;
			}

			/**
			 * for All 3's
			 */
			if(num1==16 || num1==29 || num1==42 || num1==3) {
				list.add(3); 
				sum+=sum+3;
			}
			if(num2==16 || num2==29 || num2==42 || num2==3) {
				list.add(3); 
				sum+=sum+3;
			}
			if(num3==16 || num3==29 || num3==42 || num3==3) {
				list.add(3); 
				sum+=sum+3;
			}
			if(num4==16 || num4==29 || num4==42 || num4==3) {
				list.add(3); 
				sum+=sum+3;
			}
			/**
			 * for All 4's
			 */
			if(num1==17 || num1==30 || num1==43 || num1==4) {
				list.add(4); 
				sum+=sum+4;
			}
			if(num2==17 || num2==30 || num2==43 || num2==4) {
				list.add(4); 
				sum+=sum+4;
			}
			if(num3==17 || num3==30 || num3==43 || num3==4) {
				list.add(4); 
				sum+=sum+4;
			}
			if(num4==17 || num4==30 || num4==43 || num4==4) {
				list.add(4); 
				sum+=sum+4;
			}

			/**
			 * for All 5's
			 */
			if(num1==18 || num1==31 || num1==44 || num1==5) {
				list.add(5); 
				sum+=sum+5;
			}
			if(num2==18 || num2==31 || num2==44 || num2==5) {
				list.add(5); 
				sum+=sum+5;
			}
			if(num3==18 || num3==31 || num3==44 || num3==5) {
				list.add(5); 
				sum+=sum+5;
			}
			if(num4==18 || num4==31 || num4==44 || num4==5) {
				list.add(5); 
				sum+=sum+5;
			}
			
			
			
			

			/**
			 * for All 6's
			 */
			if(num1==19 || num1==32 || num1==45 || num1==6) {
				list.add(6); 
				sum+=sum+6;
			}
			if(num2==19 || num2==32 || num2==45 || num2==6) {
				list.add(6); 
				sum+=sum+6;
			}
			if(num3==19 || num3==32 || num3==45 || num3==6) {
				list.add(6); 
				sum+=sum+6;
			}
			if(num4==19 || num4==32 || num4==45 || num4==6) {
				list.add(6); 
				sum+=sum+6;
			}
			
			
			

			/**
			 * for All 7's
			 */
			if(num1==20 || num1==33 || num1==46 || num1==7) {
				list.add(7); 
				sum+=sum+7;
			}
			if(num2==20 || num2==33 || num2==46 || num2==7) {
				list.add(7); 
				sum+=sum+7;
			}
			if(num3==20 || num3==33 || num3==46 || num3==7) {
				list.add(7); 
				sum+=sum+7;
			}
			if(num4==20 || num4==33 || num4==46 || num4==7) {
				list.add(7); 
				sum+=sum+7;
			}
			
			
			

			/**
			 * for All 8's
			 */
			if(num1==21 || num1==34 || num1==47 || num1==8) {
				list.add(8); 
				sum+=sum+8;
			}
			if(num2==21 || num2==34 || num2==47 || num2==8) {
				list.add(8); 
				sum+=sum+8;
			}
			if(num3==21 || num3==34 || num3==47 || num3==8) {
				list.add(8);
				sum+=sum+8;
			
			}
			if(num4==21 || num4==34 || num4==47 || num4==8) {
				list.add(8); 
				sum+=sum+8;
			}
			

			/**
			 * for All 9's
			 */
			if(num1==22 || num1==35 || num1==48 || num1==9) {
				list.add(9); 
				sum+=sum+9;
			}
			if(num2==22 || num2==35 || num2==48 || num2==9) {
				list.add(9); 
				sum+=sum+9;
			}
			if(num3==22 || num3==35 || num3==48 || num3==9) {
				list.add(9); 
				sum+=sum+9;
			}
			if(num4==22 || num4==35 || num4==48 || num4==9) {
				list.add(9); 
				sum+=sum;
			}
			
			
			
			
			

			/**
			 * for All 10's
			 */
			if(num1==23 || num1==36 || num1==49 || num1==10) {
				list.add(10); 
				sum+=sum+10;
			}
			if(num2==23 || num2==36 || num2==49 || num2==10) {
				list.add(10); 
				sum+=sum+10;
			}
			if(num3==23 || num3==36 || num3==49 || num3==10) {
				list.add(10); 
				sum+=sum+10;
			}
			if(num4==23 || num4==36 || num4==49 || num4==10) {
				list.add(10); 
				sum+=sum+10;
			}
			
			
			
			
			
			
			/**
			 * the card numbers added into the list
			 */
			sum = (list.get(0)+list.get(1)+list.get(2)+list.get(3));
			//JOptionPane.showMessageDialog(null, "TotalSum2:"+sum);
			
	  }

	  /**
	   * Constructs a 24-point game panel.
	   */
	  public TwentyFourPointsPanel() {
		


		this.setSize(550,350);
		this.setTitle("24Points Card");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		refresh(); 
		// setting images on the cards from the images folder, cards are random
		this.card1 = new JLabel(new ImageIcon("images\\"+num1+".PNG"));
	    this.card2 = new JLabel(new ImageIcon("images\\"+num2+".PNG"));
	    this.card3 = new JLabel(new ImageIcon("images\\"+num3+".PNG"));
	    this.card4 = new JLabel(new ImageIcon("images\\"+num4+".PNG"));
	    
	    
	    // setting sizes
	    this.card1.setBounds(70,90,75,100);   
	    this.card2.setBounds(170,90,75,100);   
	    this.card3.setBounds(270,90,75,100);   
	    this.card4.setBounds(370,90,75,100);   
	    // adding cards in the panel
	    this.add(card1);
	    this.add(card2);
	    this.add(card3);
	    this.add(card4);
	    
	    
		// refresh button
	    this.refresh = new JButton("Refresh");
	    this.refresh.setBounds(400,10,80,30);
	    this.refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new TwentyFourPointsPanel(); 
			}
	    	
	    });
	    
	    this.expression = new JTextField(8);
	    this.expression.setBounds(30,270,300,35);
	    
	    rulesOfGame = new JButton("Rules");
	    rulesOfGame.setBounds(50,10,80,30);
	    rulesOfGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame r = new JFrame("Rules of The Game");
				r.setSize(550,350);
				r.setLayout(null);
				r.setLocationRelativeTo(null);
				r.setResizable(false);

				JLabel l = new JLabel("###Rules###");
				l.setBounds(190,0,200,30);
				l.setFont(new Font("Monospaced", Font.BOLD, 22));

				JLabel l2 = new JLabel("Each card carries a number that is equal to the card number, for instance");
					//""+);
				JLabel l3 = new JLabel("A=1, Jack =11, Queen=12, King=13 In text-field player has to enter an expression. ");
				JLabel l4 = new JLabel("The result of which shall be equal to sum of all four cards  ");
				JLabel l5 = new JLabel("BUT. *Expression digits(operands) should be same as those are present in cards");				
				JLabel l6 = new JLabel("*Operands must be entered once (Non - repeated)");
				JLabel l7 = new JLabel("i-e if we have two cards red 3 and black 3 then only once 3 shall be used in expression");
				JLabel l8 = new JLabel("If you think the current expression is hard you can click Refresh, to shuffle cards");
				JLabel l9 = new JLabel("Remember you have limited shuffles");
				JLabel l10 = new JLabel("");


				l2.setBounds(20,20,500,30);
				l3.setBounds(20,50,500,30);
				l4.setBounds(20,80,500,30);
				l5.setBounds(20,110,500,30);
				l6.setBounds(20,140,500,30);
				l7.setBounds(20,170,500,30);
				l8.setBounds(20,200,500,30);
				l9.setBounds(20,230,500,30);
				l10.setBounds(20,260,500,30);
				//////////////////////////////////////////////////////////////////////////////////


				r.add(l);
				r.add(l2);
				r.add(l3);
				r.add(l4);
				r.add(l5);
				r.add(l6);
				r.add(l7);
				r.add(l8);
				r.add(l9);
				r.add(l10);
				
				
				r.setVisible(true);

			}
	    	
	    });


	    //expression panel
	    this.verify = new JButton("Verify");
	    this.verify.setBounds(400,270,80,30);
	    this.verify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// validation of the expression when verify button is pressed
				if(expression.getText().equals("")) { // if empty
					JOptionPane.showMessageDialog(null,"Please Enter Expression");
				}
				else {
					if(evaluate()) { // evaluate wil calculate solution of the expression and compare with sum of cards
						JOptionPane.showMessageDialog(null,"Correct");
					}
					else {
						if(!repeated && !isContained) { // if number is not repeated and the number that is being used is in the cards set
							JOptionPane.showMessageDialog(null,"The numbers in the expression don\''t match the numbers in the set ");
						/**
						 *  if the expression is repeated then dont show message
						 *  as the message was already shown
						 */
						}
						
					}
				}
			}
	    	
	    });
	    
	    


	    
	    this.add(rulesOfGame);
	    this.add(refresh);
	    this.add(expression);
	    this.add(verify);
	    
	    
	    this.setVisible(true);
	 }
	  public boolean currentNumbers() {
		  if(answer==sum) {
				return true;
			}
			return false;
	  }
	  /**
	   * Evaluate method will evaluate the field values into postfix and also calculate
	   * it. then checks if the sum of cards is equal to this value or not
	   * 
	   */
	  public boolean evaluate() {
		  boolean isRepeated = false;
		  String text = expression.getText();
		  String comp = text.charAt(0)+"";
		  /**
		   * expressionOperands 
		   */
		  ArrayList<Integer> expressionOperands = new ArrayList<Integer>();
		  
		  for(int i=0; i<text.length(); i++) {
			  String compo2 = text.charAt(i)+"";
			  if(compo2.equals("1") || compo2.equals("2") || compo2.equals("3") || compo2.equals("4") || compo2.equals("5") || compo2.equals("6") || compo2.equals("7") || compo2.equals("8") || compo2.equals("9") ) {
			  		/**
			  		 * if the character is a number then add it into operand's list
			  		 * 
			  		 */
				  expressionOperands.add(Integer.parseInt(compo2));
			  }
					
			  
		  }
		  
		  
		  /**
		   * First Checking if in the entered expression numbers are used once or not
		   * if numbers are repeated show the message otherwise continue to evaluate
		   */
		  repeated = false;
		  isRepeated = false;
		  Integer tempVariable = 0; // a temporary variable
		  for(int i=0 ; i<(expressionOperands.size()-1); i++) {
			  tempVariable = expressionOperands.get(i);
			  if(tempVariable==expressionOperands.get(i+1)) {
				  isRepeated = true;
				  repeated=true;
				  
			  }
			  
		  }
		  
		  
		  /**
		   * Checking if there is any other number other than card numbers
		   * if there is return false with message
		   */
		  int n1 = list.get(0);
		  int n2 = list.get(1);
		  int n3 = list.get(2);
		  int n4 = list.get(3);
		  int tempoVariable = 0;
		  isContained = false;
		  for(int i=0; i<expressionOperands.size(); i++) {
			  tempoVariable = expressionOperands.get(i);
			  if(tempoVariable==n1 || tempoVariable==n2 || tempoVariable==n3 || tempoVariable==n4 ) {
				 /**
				  * then it's okay if there is any other number (other than cards)
				  * then showMessage 
				  */
			  }
			  else {
				  isContained = true;
				  break;
			  }
		  }
		  
		  
		  if(repeated || isContained) {
			  
			  if(repeated)
				  JOptionPane.showMessageDialog(null,"Each number must be used once and only once.");
			  if(isContained)
				  JOptionPane.showMessageDialog(null,"Enter an expression that uses the four numbers from the four selected cards.");
			 
			  	
			  return false;
		  }
		  
		  else {
		  	Expression expressionObject = new Expression(expression.getText());
			 this.answer = expressionObject.evaluate();
			return currentNumbers();
		  }
		  
	  }
	  public JButton getRefresh() {
		  return this.refresh;
	  }
	  public JButton getVerify() {
		  return this.verify;
	  }
	  public void getPanel() {
		  this.setVisible(false);
		  new TwentyFourPointsPanel();
	  }
	  public static void main(String[] args){
	  	new TwentyFourPointsPanel();
	  }
}

  