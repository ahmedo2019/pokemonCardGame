
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
//import loopmusicjavaupdated.musicStuff;

public class LaunchCPU extends CPUSelect {
    
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
    
    // creates a new game pane.
    static Pane gamePane = new Pane();
    
    
    public LaunchCPU(Main menu) {
        super(menu);
    }
 
    // We create an object for the method printScore so we can call it if static has compatibility issues. 
    public static void myPrintScore(boolean myBoardSetUp){
        boardSetUp = myBoardSetUp;
        obj.printScore();
    }
    
    // This is the object for computer. 
    public static void CPUPrintScore(boolean myCPUBoardSetUp){
        CPUBoardSetUp = myCPUBoardSetUp;
        obj.printScore2();
    }
    
    /*---------------------------------------------------------------------------------------------------------------------*/
    // These methods is to control both players on when the board is set up so we can call display again and update.     
    public void printScore() {
        Player1Score += 1;
        numpairs += 1;
        setup();
    }
    
    public void printScore2() {
        Player2Score += 1;
        numpairs += 1;
        setup();
    }
    
    /*-------------------------------------------------------------------------------------------------------------------*/
    
    @Override
    public void setup() { //launch game.
        
    	// this will draw the background once because it is behind everything else. 
    	if (boardSetUp == false) {
		VBox menuBox5 = new VBox(); 
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame.gif");
		BGImg.setFitWidth(2000);
		BGImg.setFitHeight(1000);
		
		gamePane.getChildren().add(BGImg);
		gamePane.getChildren().add(menuBox5);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
    	}
    	
    	
    	// These find images from my folder. 
        
        Image gameResultImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\player1win.png");
        ImageView grIV = new ImageView(gameResultImg);
    
        Image exitImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EXIT.png");              //Adding the image for the exit button
        ImageView exitIV = new ImageView(exitImg);
        
        Image startImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\START.png");            //Adding the image for the start button
        ImageView startIV = new ImageView(startImg);
        
        
        // These create the start and exit buttons. 
        
        Button exit = new Button ();                        //Adding a EXIT button
        Button start = new Button();                        //Adding a START button
        
        
        // Sets difficulty to 4 which will generate a 4x4 board as the compgraphics records the integer of the difficulty. 
        if (difficulty == 4) {
        
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
    // calls method to set the game size, rows and columns 
	compgraphics.setSize(800);
	compgraphics.setRows(4);
	compgraphics.setCols(4);
	Grid.createGrid(new int[4][4], 4, 4);	
	compgraphics.myContent();	
        
        // text features
        Player1text.setText("Player 1 Score: ");
        Player1text.setFont(Font.font(25));
        Player1text.setStroke(Color.BLACK);
        Player1text.setTranslateX(1200);
        Player1text.setTranslateY(0);
        
        Player2text.setText("Computer Score: ");
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
        
       // 6 x 6  
       if (difficulty == 6) {             
    	   if (numpairs == 18) {
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
    	    // calls method to set the game size, rows and columns 
	compgraphics.setSize(950);
	compgraphics.setRows(6);
	compgraphics.setCols(6);
	Grid.createGrid(new int[6][6], 6, 6);	
	compgraphics.myContent();	 
       
       // text features
       Player1text.setText("Player 1 Score: ");
       Player1text.setFont(Font.font(25));
       Player1text.setStroke(Color.BLACK);
       Player1text.setTranslateX(1200);
       Player1text.setTranslateY(0);
       
       Player2text.setText("Computer Score: ");
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
 
    }
}