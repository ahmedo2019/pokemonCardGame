package gui;

import drivers.Main;
import handlers.buttonHandlers.StartCPUHandler;
import handlers.buttonHandlers.StartPVPHandler;
import javafx.application.Platform;
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
import javafx.scene.paint.Color;

public class CreditScene extends firstScene {
	StackPane gamePane = new StackPane();					//A stackPane for the game window	
	
	public CreditScene(Main menu) {							//Calling the menu from the parent using super
		super(menu);
	}

	@Override
	public void setup() {
		
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EndCredits.png");
		
//----------------------------------------------------------Creating Buttons:	
		Button back = new Button();							//Back button to main menu

//----------------------------------------------------------Adding Button Images:
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		ImageView backIV = new ImageView(backImg);
		
//----------------------------------------------------------BACK BUTTON:
		back.setGraphic(backIV);			//Adding the exit image onto the BACK button
		back.setBackground(null);							//Removing the background of the button
		back.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			back.setEffect(new DropShadow(50, Color.CRIMSON));//Adding the drop-shadow on the button when mouse hovers on the button
			back.setScaleX(1.1);							//Zooming int when mouse hovered
			back.setScaleY(1.1);
		});
		back.setOnMouseExited(a-> {							//When mouse clicks off
			back.setEffect(null);							//Removing the background of the button
			back.setScaleX(1.0);
			back.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});

		
//----------------------------------------------------------Sizing the Buttons:	
		backIV.setFitHeight(50);							//Setting the Height to 50 for the back button
		backIV.setFitWidth(100);							//Setting the Height to 100 for the back button

//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		BGImg.setFitHeight(1000);							//Making the back ground image fit height of screen
		BGImg.setFitWidth(1900);							//Making the back ground image fit width of screen
		
		gamePane.getChildren().add(BGImg);
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(back);
		
		menuBox.setAlignment(Pos.BOTTOM_CENTER);			//Aligning the menu start & quit buttons to the center
		
		gamePane.getChildren().add(menuBox);				//Adding menu box to the game pane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center

//----------------------------------------------------------Attaching the event handlers for GOING BACK TO MAIN MENU
		back.setOnAction(new EventHandler<ActionEvent>()	//Allowing the back button to back to the game select screen
		{
				@Override
				public void handle(ActionEvent event) {		//Taking in a mouse click event to go back to the game select screen
					firstScene scene = new firstScene(getMenu());
					firstScene.playMusic = true;
					scene.setup();
				}
		});
//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));			//Seting the scene to fit size of screen
		display();											//The display function displays the screen.
	}
	

}
