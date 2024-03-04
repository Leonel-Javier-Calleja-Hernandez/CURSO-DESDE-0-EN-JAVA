package es.codegym.games.ticktacktoe;

import com.codegym.engine.cell.*;
//  Tenemos un método que se encarga de mostrar una celda.
public class TicTacToeGame extends Game {
    
    private int [][] model = new int [3][3];
    private int currentPlayer;
    
    public void startGame(){
        currentPlayer = 1;
        
        for (int x = 0; x<3 ; x++)
            for(int y = 0; y<3; y++)
                model[x][y]= 0;
    }
    
    public void initialize(){
        setScreenSize(3,3);
        startGame();
    }
    
    public void updateCellView(int x, int y, int value){
        if (value == 1)
            setCellValue(x, y, "X");
        else if (value == 2)
            setCellValue(x, y, "O");
        else 
        setCellValue(x, y, " ");
        /* Si el value es 0, muestre una línea vacía en la celda - " " (espacio),
        Si el value es 1, muestre una cruz "X" en la celda. (gran X latina),
        Si el value es 2, muestre el cero "O" en la celda. (o latina grande).*/
    }