package model;

import java.util.Collections;

/**
 * @author avillota
 * @since may 2022
 */
public class CrosswordController{
	
	/**
	 * Matrix of cells representing the crossword puzzle
	 */
	private Cell [][] crossword;
	
	/**
	 * method for initializing a crossword puzzle
	 * @param puzzle is a matrix of Strings containing 
	 * the initial state of a crossword puzzle
	 */
	public void initCrossword(String[][] puzzle) {
		
		crossword = new Cell[puzzle.length][puzzle[0].length];
		int counter = 1;
		
		for(int i = 0; i<puzzle.length;i++){
			for(int j = 0; j<puzzle[0].length;j++){
				if(puzzle[i][j].equals(" ")){

					crossword[i][j] = new Cell(CellType.BLACK,puzzle[i][j],counter); 
				} else{

					crossword[i][j] = new Cell(CellType.CLOSED,puzzle[i][j],counter);
					counter++;
				}
			}

		}
	}
	/**
	 * Method to verify if a crossword puzzle is initialized
	 * @return boolean, true if it is initialized, else false
	 */
	public boolean isInitialized(){
		return crossword!=null;
	}
	
	/**
	 * Method to provide the dimensions of the crossword puzzle
	 * @return
	 */
	public int[] getGameDimensions() {
		int[] dims = new int[2];
		dims[0]= crossword.length;
		dims[1]= crossword[0].length;
		
		return dims;
	}
	
	public Cell[][] getCells(){
		return crossword;
	}
	/**
	 * 
	 * @param letter
	 * @return change of state of cell and position of the letter 
	 */
	public String getHint(String letter) {
		
		boolean sen = false;
		String hint = "";

		for(int i = 0;i<crossword.length && !sen;i++){
			for(int j = 0; j<crossword[0].length && !sen;j++){
				if(letter.equals(crossword[i][j].getLetter()) && crossword[i][j].getState() == CellType.CLOSED){
					hint = "There is a" + letter + " in the crossword in the position " + crossword[i][j].getNumber();
					crossword[i][j].setState(CellType.OPEN); 
					sen = true;  
				} else{
					hint = "I'm sorry, there is no " + letter + " in the crossword\n";
				}
			}
		}

		return hint;
	}
	
	/**
	 * 
	 * @param letter
	 * @param num
	 * @return
	 */
	public String evaluateCell(String letter, int num) {
		
		return null;
	}
	
	public String showCrossword() {
		int rows= crossword.length;
		int columns= crossword[0].length;
	
		String out="";
		String separator = "+---+ ";
		String line = "" + String.join("", Collections.nCopies(columns, separator));
		
		
		String numbers ="";
		String letters = "";
		int count =0;
		for(int i=0 ;i<rows ; i++) {
			numbers ="";
			letters ="";
			for(int j=0 ;j<columns ; j++) {
				count++;
				Cell actual = crossword[i][j];
				
				// numeros de dos cifras
				if (count>10) {
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}else //una cifra
				{
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}
			}
			//por cada fila se imprimen las lineas
			out+= line + "\n";
			out+= numbers + "\n";
			out+= letters + "\n";
			
			
		}
		out+= line + "\n";
		return out;
	}

	public String playCrossword() {
		int rows= crossword.length;
		int columns= crossword[0].length;
	
		String out="";
		String separator = "+---+ ";
		String line = "" + String.join("", Collections.nCopies(columns, separator));
		
		
		String numbers ="";
		String letters = "";
		int count =0;
		for(int i=0 ;i<rows ; i++) {
			numbers ="";
			letters ="";
			for(int j=0 ;j<columns ; j++) {
				count++;
				Cell actual = crossword[i][j];
				
				// numeros de dos cifras
				if (count>10) {
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
						
					}else if(actual.getState()==CellType.CLOSED){
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ " ";
					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}else //una cifra
				{
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
						
					}else if(actual.getState()==CellType.CLOSED){
						numbers += "  "+actual.getNumber() +"   ";
						letters += "    "+ " ";
					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}
			}
			//por cada fila se imprimen las lineas
			out+= line + "\n";
			out+= numbers + "\n";
			out+= letters + "\n";
			
			
		}
		out+= line + "\n";
		return out;
	}

}
