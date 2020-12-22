
import java.util.Scanner;


public class FoTests3 {
	
	  public static String[] line = {"_", "_", "_", "_", "_", "_", "_", "_", "_"};
	  public static String[] cord = new String[2];
	  public static int o = 0;
	  public static int x = 0;
	  public static int turn = 1;

	  public static void main(String[] args) throws Exception {
		  
		   	  Scanner sc = new Scanner(System.in);

		      printMatch();      
		      
			  while (turn < 10) {
				  System.out.println("Enter the coordinates:");
				  String one = sc.next();
				  String two = sc.next(); 
				  if (isNumeric(one) && isNumeric(two)) {
					  if (validateNumber(Integer.parseInt(one), Integer.parseInt(two))) {
						  System.out.println("Coordinates should be from 1 to 3!");
					  } else {
						  if ((turn % 2) == 0) {
							  validationPlaceO(Integer.parseInt(one), Integer.parseInt(two));
							  yWins();
							  draw();
						
						  } else {
							  validationPlaceX(Integer.parseInt(one), Integer.parseInt(two));
							  xWins();	
							  draw();

						  }
					  }
				  } else {
					  System.out.println("You should enter numbers!");
				  }
			  }
	 
		             
	   } //end main
	  
	  public static boolean xWins() {
		  if (((line[0].contains("X") && line[1].contains("X") && line[2].contains("X")) ||
			 (line[3].contains("X") && line[4].contains("X") && line[5].contains("X")) ||
			 (line[6].contains("X") && line[7].contains("X") && line[8].contains("X")) ||
			 (line[0].contains("X") && line[3].contains("X") && line[6].contains("X")) ||
			 (line[1].contains("X") && line[4].contains("X") && line[7].contains("X")) ||
			 (line[2].contains("X") && line[5].contains("X") && line[8].contains("X")) ||
			 (line[2].contains("X") && line[4].contains("X") && line[6].contains("X")) ||
			 (line[0].contains("X") && line[4].contains("X") && line[8].contains("X"))
			 ) &&
			 !(
			 (line[0].contains("O") && line[1].contains("O") && line[2].contains("O")) ||
			 (line[3].contains("O") && line[4].contains("O") && line[5].contains("O")) ||
			 (line[6].contains("O") && line[7].contains("O") && line[8].contains("O")) ||
			 (line[0].contains("O") && line[3].contains("O") && line[6].contains("O")) ||
			 (line[1].contains("O") && line[4].contains("O") && line[7].contains("O")) ||
			 (line[2].contains("O") && line[5].contains("O") && line[8].contains("O")) ||
			 (line[2].contains("O") && line[4].contains("O") && line[6].contains("O")) ||
			 (line[0].contains("O") && line[4].contains("O") && line[8].contains("O"))
			    	)
			   ) {
		  				  System.out.println("X wins");
		  				  System.exit(0);
		  				return true;
		  } 
		  return false;
	  } //end x wins
	  
	  public static boolean yWins () {
		  if (((line[0].contains("O") && line[1].contains("O") && line[2].contains("O")) ||
	    	 (line[3].contains("O") && line[4].contains("O") && line[5].contains("O")) ||
	    	 (line[6].contains("O") && line[7].contains("O") && line[8].contains("O")) ||
	    	 (line[0].contains("O") && line[3].contains("O") && line[6].contains("O")) ||
	    	 (line[1].contains("O") && line[4].contains("O") && line[7].contains("O")) ||
	    	 (line[2].contains("O") && line[5].contains("O") && line[8].contains("O")) ||
	    	 (line[2].contains("O") && line[4].contains("O") && line[6].contains("O")) ||
	    	 (line[0].contains("O") && line[4].contains("O") && line[8].contains("O"))
	    	 ) &&
		  	 !(
		  	 (line[0].contains("X") && line[1].contains("X") && line[2].contains("X")) ||
			 (line[3].contains("X") && line[4].contains("X") && line[5].contains("X")) ||
			 (line[6].contains("X") && line[7].contains("X") && line[8].contains("X")) ||
			 (line[0].contains("X") && line[3].contains("X") && line[6].contains("X")) ||
			 (line[1].contains("X") && line[4].contains("X") && line[7].contains("X")) ||
			 (line[2].contains("X") && line[5].contains("X") && line[8].contains("X")) ||
			 (line[2].contains("X") && line[4].contains("X") && line[6].contains("X")) ||
			 (line[0].contains("X") && line[4].contains("X") && line[8].contains("X"))
		  	 )
		  ) {
		  				System.out.println("O wins");
		  				System.exit(0);
		  				return true;
		  	}
		  return false;
	  } //end o wins
	  
	  public static boolean emptyBoard() {
		  int counter = 0;
		  for (int i = 0; i < line.length; i++) {
			  if (line[i].contains("_")) {
				  counter++;
			  }
		  }
		  if (counter == 0) {
			  return true;
		  }
		  return false;
	  }
	  
	  public static boolean draw() {
		  if (!xWins() && !yWins() && emptyBoard()) {
			  System.out.println("Draw");
			  return true;
		  }
		  return false;
	  }
	  
	  public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	  public static void validationPlaceX(int one, int two) {
		  if        (one == 1 && two == 1 && line[0].contains("_")) {
			  line[0] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 1 && two == 2 && line[1].contains("_")) {
			  line[1] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 1 && two == 3 && line[2].contains("_")) {
			  line[2] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 1 && line[3].contains("_"))  {
			  line[3] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 2 && line[4].contains("_")) {
			  line[4] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 3 && line[5].contains("_")) {
			  line[5] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 1 && line[6].contains("_")) {
			  line[6] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 2 && line[7].contains("_")) {
			  line[7] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 3 && line[8].contains("_")) {
			  line[8] = "X";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else {
			  System.out.println("This cell is occupied! Choose another one!");
		  }
	  }
	  
	  public static void validationPlaceO(int one, int two) {
		  if        (one == 1 && two == 1 && line[0].contains("_")) {
			  line[0] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 1 && two == 2 && line[1].contains("_")) {
			  line[1] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 1 && two == 3 && line[2].contains("_")) {
			  line[2] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 1 && line[3].contains("_"))  {
			  line[3] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 2 && line[4].contains("_")) {
			  line[4] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 2 && two == 3 && line[5].contains("_")) {
			  line[5] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 1 && line[6].contains("_")) {
			  line[6] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 2 && line[7].contains("_")) {
			  line[7] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else if (one == 3 && two == 3 && line[8].contains("_")) {
			  line[8] = "O";
			  changeValueCord(one, two);
			  printMatch();
			  turn++;
		  } else {
			  System.out.println("This cell is occupied! Choose another one!");
		  }
	  }
	  
	  public static boolean validateNumber(Integer one, Integer two) {
		  if ((one == 1 || one == 2 || one == 3) && (two == 1 || two == 2 || two == 3)) {
			  return false;
		  } else {
			  return true;
		  }
	  }
	  
	  public static void changeValueCord(Integer one, Integer two) {
		  cord[0] = one.toString();
		  cord[1] = two.toString();
	  }
	  
	  public static void printMatch() {
	      String aux = "";
	      
	      System.out.println("---------");
	      for (int i = 0; i < line.length; i++) {
	    	  if (aux.length() <= 6) {
		    	  aux += line[i] + " ";
	    	  }
	    	  if (aux.length() == 6) {
	    		  System.out.println("| " + aux + "|");
	    		  aux = "";
	    	  }
	      }
	      System.out.println("---------");
	  }
}
