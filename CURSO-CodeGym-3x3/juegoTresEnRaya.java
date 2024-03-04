package es.codegym.games.ticktacktoe;

import com.codegym.engine.cell.*;

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
        updateView();
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
    
    // método que mostrará todas las celdas de la matriz model en la pantalla o tablero de juego
    public void updateView(){
        for (int x = 0; x<3 ; x++)
            for(int y = 0; y<3; y++){
               updateCellView(x, y, model[x][y]);
            }
    }
    /*el método public void onMouseLeftClick(int x, int y). El motor del juego lo llamará cada 
    vez que el usuario haga clic en el campo de juego. También transmitirá las coordenadas de la celda 
    en la que el usuario hizo clic con el mouse; (x,y).*/
    public void onMouseLeftClick(int x, int y){
        model[x][y] = currentPlayer;
        updateView();
        currentPlayer = 3 - currentPlayer;
        // currentPlayer = 3 - currentPlayer; es la logica para cambiar de jugador 1 a jugador 2
    }

}
