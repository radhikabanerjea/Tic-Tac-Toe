//importing everything required
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class TicTacToe {

	static final int NUM_ROWS = 3; //determines the amount of rows in the 2D array
	static final int NUM_COLUMNS = 3;//determines the amount of columns in the 2D array
	static String board[][] = new String[NUM_ROWS][NUM_COLUMNS];//2D array to keep track of the game
	static JLabel info = new JLabel("X's Turn");//label that displays information like whos turn it is and whether someone has won.  It begins by displaying that it is X's turn
	
	//array for all of the buttons. 
	static JButton [] buttons = {new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()}; 
	
	//array for all the panels.
	static JPanel [] panels = {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()};
	

	//indicates the player's turn. One being X, and two being O
	static int pTurn = 1;

	//pictures for the sides when someone wins/draws:
	static ImageIcon x1 = new ImageIcon("images/happychick.gif");
	static ImageIcon x2 = new ImageIcon("images/happychick.gif"); 
    static ImageIcon o1 = new ImageIcon("images/kitty.gif");    
	static ImageIcon o2 = new ImageIcon("images/kitty.gif");    
	static ImageIcon d1 = new ImageIcon("images/angerpig.gif"); 
	static ImageIcon d2 = new ImageIcon("images/angerpig.gif"); 
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame(); //creates the frame (the big box where all the baskets will be put)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure the program exits when the frame closes
		f.setTitle("Tic Tac Toe");  // Title of the frame
		f.setSize(850,1500);	 // Size of the frame
		f.setLocationRelativeTo(null); //places the frame in the middle of the screen
		f.setLayout(new BorderLayout()); //setting frame layout to border layout
		
		//The last two panels in the array are used to put pictures on the sides of the screen when someone wins. This puts them on the sides of the screen
		f.add(panels[3], BorderLayout.LINE_START);		
		f.add(panels[4], BorderLayout.LINE_END);		

		//making an icon for the GUI
		Image icon = Toolkit.getDefaultToolkit().getImage("images/icon.png");    
	    f.setIconImage(icon);

		JLabel intro = new JLabel("Welcome to Tic-Tac-Toe"); //label for the welcome to the game display
		intro.setForeground(Color.BLUE);//setting the colour of the text of the intro label
		intro.setFont(new Font("Britannic Bold", Font. PLAIN, 60));//changing the font and size of the label above
		panels[1].add(intro); //adding the label to the panel for the title
		f.add(panels[1], BorderLayout.PAGE_START);//adds the panel title to the frame (adds the basket to the big box) at the beginning of the GUI - PAGE_START		
		
		f.add(panels[0], BorderLayout.PAGE_END);//adding the panel for info at the bottom of the frame
		info.setFont(new Font("Britannic Bold", Font. PLAIN, 50));//setting the font for the information at the bottom
		info.setForeground(Color.blue);//making that text blue
		panels[0].add(info); //adding the information to the bottom panel
		
		panels[2].setLayout(new GridLayout(3,3));//setting the panel for the game to grid layout - a 3 by 3 grid
		f.add(panels[2], BorderLayout.CENTER);   //adds the panel p1 to the frame (adds the basket to the big box) at the middle - CENTER
		
		
		//Adding all the buttons to the grid in a for loop in order. 
		for (int i = 0; i<buttons.length; i++) {
			panels[2].add(buttons[i]);
		}

		//filling the board with * before the game begins so that the computer is able to look through it easily.
		blankTheBoard();
		
		//action listeners for all of the buttons.
    	buttons[0].addActionListener(new ActionListener() //action listener for the b1
	    			{
	    				@Override
	    				public void actionPerformed(ActionEvent event)
	    				{
	    				//variables that demonstrate the location of the place the button is in the 2D array
	    					int r = 0;
	    					int c = 0;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
	    					fillBoard(r,c);
	    					tasks();
	    					//displays x or o depending on whose turn it is.
	    					display(buttons[0]);
	    					
	    				}
	    			});
    	
    	buttons[1].addActionListener(new ActionListener() //action listener for the b2
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 0;
    					int c = 1;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
       					//displays x or o depending on whose turn it is.
    					display(buttons[1]);
    				}
    			});
    	
    	buttons[2].addActionListener(new ActionListener() //action listener for the b3
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{   
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 0;
    					int c = 2;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[2]);
    				}
    			});
    	
    	buttons[3].addActionListener(new ActionListener() //action listener for the b4
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{    
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 1;
    					int c = 0;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[3]);
    				}
    			});
    	
    	buttons[4].addActionListener(new ActionListener() //action listener for the b5
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{   
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 1;
    					int c = 1;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[4]);
    				}
    			});
    	
    	buttons[5].addActionListener(new ActionListener() //action listener for the b6
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{  	
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 1;
    					int c = 2;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[5]);
    				}
    			});
    	
    	buttons[6].addActionListener(new ActionListener() //action listener for the b7
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{  	
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 2;
    					int c = 0;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[6]);
    				}
    			});
    	
    	buttons[7].addActionListener(new ActionListener() //action listener for the b8
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{	    				
    					//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 2;
    					int c = 1;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[7]);
    				}
    			});
    	
    	buttons[8].addActionListener(new ActionListener() //action listener for the b9
    			{
    				@Override
    				public void actionPerformed(ActionEvent event)
    				{   		
	    				//variables that demonstrate the location of the place the button is in the 2D array
    					int r = 2;
    					int c = 2;
	    				//replaces the space where the player clicked in the GUI with the player's token in the 2D array
    					fillBoard(r,c);
    					tasks();
    					//displays x or o depending on whose turn it is.
    					display(buttons[8]);
    				}
    			});
		
		
		f.setVisible(true);		     //makes that the user can see the frame and all that it contains
	}

	
	// This method will check through all the possibilities of the player winning.
		public static boolean userHasWon()
		{
			// Loop through all rows looking for a win.
			for (int r = 0; r < NUM_ROWS; r++){
				for (int c = 0; c < NUM_COLUMNS - 2; c++){
					if (board[r][c].equals(board[r][c+1]) && board[r][c].equals(board[r][c+2]) && board[r][c].equals("*") != true){
						return true;
					}
				}
			}

			// Loop through all columns looking for a win.
			for (int c = 0; c < NUM_COLUMNS; c++)	{
				for (int r = 0; r < NUM_ROWS - 2; r++)	{
					if (board[r][c].equals(board[r+1][c]) && board[r][c].equals(board[r+2][c]) && board[r][c].equals("*")!= true)
					{	
						return true;
					}
				}
			}

			// Goes through the diagonal (down and to the right) looking for a win.
					if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals("*")!= true)
					{	
						return true;
					}	
			
			// Goes through the diagonal (up and to the right) looking for a win.

					if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && board[0][2].equals("*")!= true)
					{	
						return true;
					}
			
			// This line should never execute, but is required.
			return false;
		}
		
		//method that checks whether there is a draw.
		public static boolean draw() {
			//goes through all the spaces on the grid and sees if there is an empty space
			for (int r = 0; r < NUM_ROWS; r++)
			{
				for (int c = 0; c < NUM_COLUMNS; c++)
				{
					if (board[r][c].equals("*")) {
						return false;
					}
				}
			}
			//returns true if there is an empty space
			return true;
		}
			
		//method used to do the tasks that have to happen in all the action listeners so that these lines don't have to be repeated.
		public static void tasks() {
			//JLabels to put gifs onto the sides when someone won/draw
			JLabel one;
			JLabel two;
			
			//if it was x's turn display x won, disable all the buttons
			if (userHasWon()&&pTurn==1) {
				info.setText("X WINS!");
				info.setForeground(Color.PINK);
				info. setFont(new Font("Britannic Bold", Font. PLAIN, 150));
				disable();
				//adding gifs 
				one = new JLabel(x1);
				two = new JLabel(x2);
				panels[3].add(one);
				panels[4].add(two);
				
			}
			//if it was o's turn display o won, disable all the buttons
			else if (userHasWon()&&pTurn==2) {
				info.setText("O WINS!");
				info.setForeground(Color.darkGray);
				info. setFont(new Font("Britannic Bold", Font. PLAIN, 150));
				disable();
				//adding gifs 
				one = new JLabel(o1);
				two = new JLabel(o2);
				panels[3].add(one);
				panels[4].add(two);
			}
			//check for a draw and say that there is a draw
			else if (draw()) {
				info.setText("DRAW :(");
				info. setFont(new Font("Britannic Bold", Font. PLAIN, 150));
				//adding gifs 
				one = new JLabel(d1);
				two = new JLabel(d2);
				panels[3].add(one);
				panels[4].add(two);
			}
			//display whose turn it is
			else {
				whosTurn();
			}
		}
				
		//method that displays which player's turn it is
		public static void whosTurn() {
			switch(pTurn) {
			case 1:
				info.setText("O's Turn");
				break;
			case 2:
				info.setText("X's Turn");
				break;
			}
		}
		
		//method that displays X and O alternately on the screen when the user clicks on one of the buttons. 
		public static void display (JButton b) {
			
			switch(pTurn) {
				//If it is player one's turn then it will display X , set the background to pink and disable the button so that the user can't press the same button more than once.
				case 1:
					b.setText("X");
					b.setBackground(Color.pink);
					b. setFont(new Font("Britannic Bold", Font. PLAIN, 100));
					break;
				//If it is player two's turn then it will display O , set the background to dark grey and disable the button so that the user can't press the same button more than once.
				case 2:
					b.setText ("O");
					b.setBackground(Color.darkGray);
					b. setFont(new Font("Britannic Bold", Font. PLAIN, 100));
					break;
				}
			// Change the turn number. The following code changes 1 to 2 and 2 to 1.
			pTurn = (pTurn % 2) + 1;
			//disables the button after it is used so that it can't be used again
			b.setEnabled(false);
		}
		
		//method used to just completely empty the board before the game starts.
		public static void blankTheBoard()
		{
			for (int i = 0; i < board.length; i++) {
			      // Loop through columns
			      for (int j = 0; j < board[i].length; j++) {
			        // Initializes the board to *
			        board[i][j]="*";
			      } 
			}
		}
		
		//method that disables all of the buttons at once. 
		public static void disable() {
			for (int i = 0; i < buttons.length; i++) {
			   buttons[i].setEnabled(false);
			}
		}
		
		//method that replaces the 2D array slots with X and O where they clicked
		public static void fillBoard(int r, int c) {
			switch(pTurn) {
			
			//If it is player one's turn then the space that the player clicked will be replaced with an x on the 2D array
				case 1:
					board[r][c] = "X";
					break;
			//If it is player one's turn then the space that the player clicked will be replaced with an x on the 2D array			
				case 2:
					board[r][c] = "O";
					break;
			}
		}
}
