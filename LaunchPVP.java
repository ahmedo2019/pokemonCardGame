
package gui;

import javax.swing.JFrame;
import javafx.scene.layout.Pane; 
import drivers.Main;
import handlers.buttonHandlers;
import handlers.buttonHandlers.StartPVPHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class LaunchPVP extends PVPSelect {

	// instance variables 
    private Text Player1text = new Text();
    private Text Player2text = new Text();
    private Text scoreText = new Text();
    private Text scoreText2 = new Text();
    private int Player1Score;
    private int Player2Score;   
    private int numpairs = 0; 
    private Image gameOverImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\gameover.png");
    private ImageView goIV = new ImageView(gameOverImg);
    public static int difficulty = 0;
    public static boolean boardSetUp = false;
    public static boolean CPUBoardSetUp = false;
    
    public static boolean reloadGame = false;
    
    // convert the class into an object class.
    static LaunchPVP obj = new LaunchPVP(null);
    
    // Creates a new pane 
    static Pane gamePane = new Pane();
    public LaunchPVP(Main menu) {
        super(menu);
    }
 
    
    // This can be used to set up an object so it can be compatible between static and non static variables  
    public static void myPrintScore(boolean myBoardSetUp){
        boardSetUp = myBoardSetUp;
        obj.printScore();
    }
    
    // same thing as myPrintScore but with the CPU because it links towards the next method printScore() and printScore2()
    public static void CPUPrintScore(boolean myCPUBoardSetUp){
        CPUBoardSetUp = myCPUBoardSetUp;
        obj.printScore2();
    }
    
    public void printScore() {
        Player1Score += 1; // adds towards the score of the first player. 
        numpairs += 1; // adds a pair so the game can later detect when the game ends. 
        setup(); // calls set up() again which will draw everything. 
    }
    
    public void printScore2() {
        Player2Score += 1; // adds towards the score if the second player. 
        numpairs += 1; // adds a pair so the game can later detect when the game ends 
        setup(); // calls setup() again which will draw everything.
    }
    
    @Override
    public void setup() { //launch game.
        
    	if (boardSetUp == false) { // This is to ensure it only draws once after the set up is launched.
		VBox menuBox5 = new VBox(); 
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame.gif");
		BGImg.setFitWidth(2000);
		BGImg.setFitHeight(1000);
		
		gamePane.getChildren().add(BGImg);					// Add background image which is the gif. 
		gamePane.getChildren().add(menuBox5);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
    	}
    	
    	
        
    	// draws all the buttons. 
        Image gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
        ImageView grIV = new ImageView(gameResultImg);
    
        Image exitImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EXIT.png");              //Adding the image for the exit button
        ImageView exitIV = new ImageView(exitImg);
        
        Image startImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\START.png");            //Adding the image for the start button
        ImageView startIV = new ImageView(startImg);
        
        Button exit = new Button ();                        //Adding a EXIT button
        Button start = new Button();                        //Adding a START button
        
        // this is the difficulty 4 which will set up the board as it links to the graphics class. 
        if (difficulty == 4) {
        
        // This lets the game detect the number of pairs so it will know when the game will end and draw out the images. 
        if (numpairs == 8) {
            if (Player1Score > Player2Score) {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
                grIV = new ImageView(gameResultImg);
            }
            else if (Player1Score < Player2Score) {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player2win.png");
                grIV = new ImageView(gameResultImg);
            }
            else 
            {
                gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\tiegame.png");
                grIV = new ImageView(gameResultImg);
                
            }
 
//----------------------------------------------------------START BUTTON:
            start.setGraphic(startIV);                          //Adding the start image onto the start button
            start.setBackground(null);                          //Removing the background of the button
            start.setOnMouseEntered(a->{                        //Adding the drop-shadow on the button when mouse hovers on the button
                start.setEffect(new DropShadow(50, Color.CRIMSON));
                start.setScaleX(1.1);
                start.setScaleY(1.1);
                });
            start.setOnMouseExited(a-> {                        //Removing the drop-shadow on the button when mouse does not on the button  
                start.setEffect(null);
                start.setScaleX(1.0);
                start.setScaleY(1.0);
            });
            
//----------------------------------------------------------EXIT BUTTON:    
            exit.setGraphic(exitIV);                            //Adding the exit image onto the exit button
            exit.setBackground(null);                           //Removing the background of the button
            exit.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
                exit.setEffect(new DropShadow(50, Color.CRIMSON));
                exit.setScaleX(1.1);
                exit.setScaleY(1.1);
            });
            exit.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
                exit.setEffect(null);
                exit.setScaleX(1.0);
                exit.setScaleY(1.0);
            
            });
            
//----------------------------------------------------------Sizing the Images:  
            grIV.setTranslateX(860);
            grIV.setTranslateY(80);
            grIV.setFitHeight(150);
            grIV.setFitWidth(500);
                    
            goIV.setTranslateX(860);
            goIV.setTranslateY(100);
            
            start.setTranslateX(860);
            start.setTranslateY(120);
            exit.setTranslateX(860);
            exit.setTranslateY(130);
            
            VBox menuBox3 = new VBox(20); 
            menuBox3.getChildren().addAll(grIV,goIV, start, exit);
            gamePane.getChildren().add(menuBox3);
            menuBox3.setAlignment(Pos.CENTER);      
        }
    
//----------------------------------------------------------Adding Player Score (INT VALUE):
        if (Player1Score>0)
            scoreText.setText(Integer.toString(Player1Score));
            scoreText.setFont(Font.font(25));
            scoreText.setStroke(Color.CRIMSON);
            scoreText.setTranslateX(1450);
            scoreText.setTranslateY(0);
        
        // computer score
        if (Player2Score >0)
            scoreText2.setText(Integer.toString(Player2Score));
            scoreText2.setFont(Font.font(25));
            scoreText2.setStroke(Color.CRIMSON);
            scoreText2.setTranslateX(1450);
            scoreText2.setTranslateY(0);
 
//----------------------------------------------------------Adding Button Images:
            Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");              //Adding the image for the BACK button
            ImageView backIV = new ImageView(backImg);
            
        
//----------------------------------------------------------BACK BUTTON:
            back.setGraphic(backIV);                            //Adding the exit image onto the BACK button
            back.setBackground(null);                           //Removing the background of the button
            back.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
                back.setEffect(new DropShadow(50, Color.CRIMSON));
                back.setScaleX(1.1);
                back.setScaleY(1.1);
            });
            back.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
                back.setEffect(null);
                back.setScaleX(1.0);
                back.setScaleY(1.0);
            });
//----------------------------------------------------------Sizing the Buttons: 
            backIV.setFitHeight(50);                        //Sizing the back button
            backIV.setFitWidth(90);
            backIV.setTranslateX(1050);
            backIV.setTranslateY(500);
 
 
//----------------------------------------------------------PLAYER TEXT DISPLAY:
        VBox menuBox2 = new VBox(); 
 
        menuBox2.getChildren().add(scoreText);
        menuBox2.getChildren().add(scoreText2);
        gamePane.getChildren().add(menuBox2);
        menuBox2.setAlignment(Pos.CENTER);
        
        
        if (boardSetUp == false) {
 
//----------------------------------------------------------SCORE DISPLAY:
        //graphics.createGrid();
        graphics.myEasyGUI();
        Grid.createGrid(new int[4][4], 4, 4);   
        
        // text features
        Player1text.setText("Player 1 Score: ");
        Player1text.setFont(Font.font(25));
        Player1text.setStroke(Color.BLACK);
        Player1text.setTranslateX(1200);
        Player1text.setTranslateY(0);
        
        Player2text.setText("Player 2 Score: ");
        Player2text.setFont(Font.font(25));
        Player2text.setStroke(Color.BLACK);
        Player2text.setTranslateX(1200);
        Player2text.setTranslateY(0);
    
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
        //BGImg.setFitHeight(860);
        //BGImg.setFitWidth(1380);
        
        VBox menuBox = new VBox();                          //Adding the buttons to the VBox
        menuBox.getChildren().addAll(Player1text,Player2text);
        
        
        //menuBox.getChildren().add(BGImg);
        gamePane.getChildren().add(menuBox);
        
        
        back.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                GameSelect scene = new GameSelect(getMenu());
                scene.setup();
        
            }
        });
        
        setScene(new Scene( gamePane, 2000, 1000));
        
        boardSetUp = true;
        
        display();      
        }   
        } 
        
        
       // if difficulty is 6 then it would launch 6x6 board as the compgraphics would take the instance variable from this class.  
       if (difficulty == 6) {              
    	   if (numpairs == 8) {
           if (Player1Score > Player2Score) {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
               grIV = new ImageView(gameResultImg);
           }
           else if (Player1Score < Player2Score) {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player2win.png");
               grIV = new ImageView(gameResultImg);
           }
           else 
           {
               gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\tiegame.png");
               grIV = new ImageView(gameResultImg);
               
           }

//----------------------------------------------------------START BUTTON:
           start.setGraphic(startIV);                          //Adding the start image onto the start button
           start.setBackground(null);                          //Removing the background of the button
           start.setOnMouseEntered(a->{                        //Adding the drop-shadow on the button when mouse hovers on the button
               start.setEffect(new DropShadow(50, Color.CRIMSON));
               start.setScaleX(1.1);
               start.setScaleY(1.1);
               });
           start.setOnMouseExited(a-> {                        //Removing the drop-shadow on the button when mouse does not on the button  
               start.setEffect(null);
               start.setScaleX(1.0);
               start.setScaleY(1.0);
           });
           
//----------------------------------------------------------EXIT BUTTON:    
           exit.setGraphic(exitIV);                            //Adding the exit image onto the exit button
           exit.setBackground(null);                           //Removing the background of the button
           exit.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
               exit.setEffect(new DropShadow(50, Color.CRIMSON));
               exit.setScaleX(1.1);
               exit.setScaleY(1.1);
           });
           exit.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
               exit.setEffect(null);
               exit.setScaleX(1.0);
               exit.setScaleY(1.0);
           
           });
           
//----------------------------------------------------------Sizing the Images:  
           grIV.setTranslateX(860);
           grIV.setTranslateY(80);
           grIV.setFitHeight(150);
           grIV.setFitWidth(500);
                   
           goIV.setTranslateX(860);
           goIV.setTranslateY(100);
           
           start.setTranslateX(860);
           start.setTranslateY(120);
           exit.setTranslateX(860);
           exit.setTranslateY(130);
           
           VBox menuBox3 = new VBox(20); 
           menuBox3.getChildren().addAll(grIV,goIV, start, exit);
           gamePane.getChildren().add(menuBox3);
           menuBox3.setAlignment(Pos.CENTER);      
       }
   
//----------------------------------------------------------Adding Player Score (INT VALUE):
       if (Player1Score>0)
           scoreText.setText(Integer.toString(Player1Score));
           scoreText.setFont(Font.font(25));
           scoreText.setStroke(Color.CRIMSON);
           scoreText.setTranslateX(1450);
           scoreText.setTranslateY(0);
       
       // computer score
       if (Player2Score >0)
           scoreText2.setText(Integer.toString(Player2Score));
           scoreText2.setFont(Font.font(25));
           scoreText2.setStroke(Color.CRIMSON);
           scoreText2.setTranslateX(1450);
           scoreText2.setTranslateY(0);

//----------------------------------------------------------Adding Button Images:
           Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");              //Adding the image for the BACK button
           ImageView backIV = new ImageView(backImg);
           
       
//----------------------------------------------------------BACK BUTTON:
           back.setGraphic(backIV);                            //Adding the exit image onto the BACK button
           back.setBackground(null);                           //Removing the background of the button
           back.setOnMouseEntered(a->{                         //Adding the drop-shadow on the button when mouse hovers on the button
               back.setEffect(new DropShadow(50, Color.CRIMSON));
               back.setScaleX(1.1);
               back.setScaleY(1.1);
           });
           back.setOnMouseExited(a-> {                         //Removing the drop-shadow on the button when mouse does not on the button  
               back.setEffect(null);
               back.setScaleX(1.0);
               back.setScaleY(1.0);
           });
//----------------------------------------------------------Sizing the Buttons: 
           backIV.setFitHeight(50);                        //Sizing the back button
           backIV.setFitWidth(90);
           backIV.setTranslateX(1050);
           backIV.setTranslateY(500);


//----------------------------------------------------------PLAYER TEXT DISPLAY:
       VBox menuBox2 = new VBox(); 

       menuBox2.getChildren().add(scoreText);
       menuBox2.getChildren().add(scoreText2);
       gamePane.getChildren().add(menuBox2);
       menuBox2.setAlignment(Pos.CENTER);
       
       
       if (boardSetUp == false) {

//----------------------------------------------------------SCORE DISPLAY:
       //graphics.createGrid();
       graphics.myEasyGUI();
       Grid.createGrid(new int[6][6], 6, 6);   
       
       // text features
       Player1text.setText("Player 1 Score: ");
       Player1text.setFont(Font.font(25));
       Player1text.setStroke(Color.BLACK);
       Player1text.setTranslateX(1200);
       Player1text.setTranslateY(0);
       
       Player2text.setText("Player 2 Score: ");
       Player2text.setFont(Font.font(25));
       Player2text.setStroke(Color.BLACK);
       Player2text.setTranslateX(1200);
       Player2text.setTranslateY(0);
   
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
       //BGImg.setFitHeight(860);
       //BGImg.setFitWidth(1380);
       
       VBox menuBox = new VBox();                          //Adding the buttons to the VBox
       menuBox.getChildren().addAll(Player1text,Player2text);
       
       
       //menuBox.getChildren().add(BGImg);
       gamePane.getChildren().add(menuBox);
       
       
       back.setOnAction(new EventHandler<ActionEvent>()
       {
           @Override
           public void handle(ActionEvent event) {
               GameSelect scene = new GameSelect(getMenu());
               scene.setup();
       
           }
       });
       
       // sets scene with 2000 width and 1000 height to fit my screen. 
       setScene(new Scene( gamePane, 2000, 1000));
       
       // board set up is true so it won't draw the game again once the score updates. 
       boardSetUp = true;
       
       display();      
       }   
    	   
    	   
    	   
    	   
    	   
       }
 
    }
}