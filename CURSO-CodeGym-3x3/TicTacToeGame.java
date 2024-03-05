package es.codegym.games.ticktacktoe;

import com.codegym.engine.cell.Color;
import com.codegym.engine.cell.Game;
import com.codegym.engine.cell.*;
// import com.codegym.engine.cell.*; importa todo lo necesario para el proyecto

public class TicTacToeGame extends Game {
    
    private int [][] model = new int [3][3];
    private int currentPlayer;
    // se creeo una variable boolean para true y false
    private boolean isGameStopped;
    
    public void startGame(){
        currentPlayer = 1;
        // false_el juego continua
        isGameStopped = false;
        
        for (int x = 0; x<3 ; x++)
            for(int y = 0; y<3; y++)
                model[x][y]= 0;
    
    }
    
    public void initialize(){
        setScreenSize(3,3);
        startGame();
        updateView();
    }
    
    public void updateCellView(int x, int y, int value) {
        if (value == 1)
            setCellValueEx(x, y, Color.WHITE, "X", Color.RED);
        else if (value == 2)
            setCellValueEx(x, y, Color.WHITE, "O", Color.BLUE);
        else
            setCellValueEx(x, y, Color.WHITE, " ", Color.WHITE);
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
        // true_el juego se detiene
        if(isGameStopped)
            return;
        if (model[x][y] != 0)
            return;
        model[x][y] = currentPlayer;
        updateView();
        
        if(checkWin(x,y,currentPlayer)){
        isGameStopped = true;
        showMessageDialog(Color.NONE, " EL JUGADOR #" + currentPlayer + " GANADOR 🥳!", Color.GREEN, 25);
        }
         // le pasamos las cordenadas, currentPlayer(Numero Del jugador) y mostramos en pantalla un showMessageDialog(MENSAJE) de el jugador ganador   
        currentPlayer = 3 - currentPlayer;
        // currentPlayer = 3 - currentPlayer; es la logica para cambiar de jugador 1 a jugador 2
        
    }
    
    public boolean checkWin(int x, int y, int n){
        if (model [x][0] == n && model [x][1] == n && model [x][2] == n)
        return true;
        if (model [0][y] == n && model [1][y] == n && model [2][y] == n)
        return true;
        if (model [0][0] == n && model [1][1] == n && model [2][2] == n)
        return true;
        if (model [2][0] == n && model [1][1] == n && model [0][2] == n)
        return true;
    return false;
    // revisa las cordenadas donde se le a dado clik de todo el juego
    }
}
