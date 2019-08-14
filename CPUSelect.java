package gui;

import java.io.File;

import drivers.Main;

import handlers.buttonHandlers;
import handlers.buttonHandlers.EasyCPUHandler;
import handlers.buttonHandlers.HardCPUHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class CPUSelect extends GameSelect {
	StackPane gamePane = new StackPane();					//A stackPane for the game window	
	
//----------------------------------------------------------Creating Buttons:
	public Button easy = new Button();						//Adding a EASY button
	public Button hard = new Button();						//Adding a HARD button
	public Button back = new Button();						//Adding a BACK button
	
	public CPUSelect(Main menu) {							
		super(menu);										//Calling the menu from the parent using super
	}

	@Override
	public void setup() {

		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\behindgame2.gif");
		/*Pikachu Pokemon Gif HD by Heat
		 * http://hdgifs.com/gif/pika/
		 * Accessed on August 12th, 2019
		 */

//----------------------------------------------------------Adding Button Images:
		Image easyImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EASY.png");				//Adding the image for the EASY button
		Image hardImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\HARD.png");				//Adding the image for the HARD button
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		
		BGImg.setFitWidth(2000);							//Making the back ground image fit width of screen
		BGImg.setFitHeight(1000);							//Making the back ground image fit height of screen
		
//----------------------------------------------------------EASY BUTTON:
		easy.setGraphic(new ImageView(easyImg));			//Adding the start image onto the EASY button
		easy.setBackground(null);							//Removing the background of the button
		easy.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			easy.setEffect(new DropShadow(50, Color.CRIMSON));		//Drop shadow is changed to a red color
			easy.setScaleX(1.1);							//Zooming in when mouse hovered
			easy.setScaleY(1.1);
		});
		easy.setOnMouseExited(a-> {							//When mouse clicks off
			easy.setEffect(null);							//Removing the background of the button
			easy.setScaleX(1.0);
			easy.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});
				

//----------------------------------------------------------HARD BUTTON:
		hard.setGraphic(new ImageView(hardImg));			//Adding the exit image onto the HARD button
		hard.setBackground(null);							//Removing the background of the button
		hard.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			hard.setEffect(new DropShadow(50, Color.CRIMSON));
			hard.setScaleX(1.1);							//Zooming in when mouse hovered
			hard.setScaleY(1.1);
		});
		hard.setOnMouseExited(a-> {							//When mouse clicks off
			hard.setEffect(null);							//Removing the background of the button
			hard.setScaleX(1.0);
			hard.setScaleY(1.0);							//Zooming out when mouse not hovering
			
			
		});
//----------------------------------------------------------BACK BUTTON:
		back.setGraphic(new ImageView(backImg));			//Adding the exit image onto the BACK button
		back.setBackground(null);							//Removing the background of the button
		back.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			back.setEffect(new DropShadow(50, Color.CRIMSON));//Adding the drop-shadow on the button when mouse hovers on the button
			back.setScaleX(1.1);							//Zooming in when mouse hovered
			back.setScaleY(1.1);
		});
		back.setOnMouseExited(a-> {							//When mouse clicks off
			back.setEffect(null);							//Removing the background of the button
			back.setScaleX(1.0);
			back.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});

//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(easy);					//Adding the easy button to the PVP SELECT
		menuBox.getChildren().add(hard);					//Adding the hard button to the PVP SELECT
		menuBox.getChildren().add(back);					//Adding the back button to the game select menu
			
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
				//Adding HBox to the pane
		gamePane.getChildren().add(BGImg);
		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; START, CREDITS, EXIT to the gamepane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
		
		/*
		BtnExitHandler exitHandle = new BtnExitHandler();	//Attaching the event handlers for QUIT
		exit.setOnAction(exitHandle);
		*/
	
//----------------------------------------------------------Attaching the event handlers for EASY
		EasyCPUHandler easyHandle = new EasyCPUHandler(getMenu());
		easy.setOnAction(easyHandle);						//Re-routing upon click on the easy handle
		
//----------------------------------------------------------Attaching the event handlers for HARD
		HardCPUHandler hardHandle = new HardCPUHandler(getMenu());//Attaching the event handlers for START
		hard.setOnAction(hardHandle);						//Re-routing upon click on the hard handle

//----------------------------------------------------------Attaching the event handlers for GOING BACK TO MAIN MENU
		back.setOnAction(new EventHandler<ActionEvent>()	//Allowing the back button to back to the game select screen
		{
			@Override
			public void handle(ActionEvent event) {			//Taking in a mouse click event to go back to the game select screen
				GameSelect scene = new GameSelect(getMenu());
				scene.setup();
			}
		});


//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));			//Seting the scene to fit size of screen
		display();											//The display function displays the screen.
	}
	

}
