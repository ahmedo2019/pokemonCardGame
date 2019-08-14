package gui;

import drivers.Main;
import handlers.buttonHandlers;
import handlers.buttonHandlers.EasyPVPHandler;
import handlers.buttonHandlers.HardPVPHandler;
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

public class PVPSelect extends GameSelect {
	StackPane gamePane = new StackPane();

//----------------------------------------------------------Creating Buttons:
	public Button easy = new Button();						//Adding a EASY button
	public Button hard = new Button();						//Adding a HARD button
	public Button back = new Button();						//Adding a BACK button
		
	public PVPSelect(Main menu) {
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
		ImageView easyIV = new ImageView(easyImg);			//Adding the easy button image to the image view
		Image hardImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\HARD.png");				//Adding the image for the HARD button
		ImageView hardIV = new ImageView(hardImg);			//Adding the easy button image to the image view
		Image backImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\BACK.png");				//Adding the image for the BACK button
		ImageView backIV = new ImageView(backImg);			//Adding the easy button image to the image view
		
//----------------------------------------------------------EASY BUTTON:
		easy.setGraphic(easyIV);							//Adding the easy image onto the EASY button
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

//----------------------------------------------------------Sizing the Buttons:	
		easyIV.setFitHeight(90);							//Setting the Height to 90 for the easy button
		easyIV.setFitWidth(200);							//Setting the Height to 200 for the easy button
		
		hardIV.setFitHeight(90);							//Setting the Height to 90 for the hard button
		hardIV.setFitWidth(200);							//Setting the Height to 200 for the hard button
		
		backIV.setFitHeight(90);							//Setting the Height to 90 for the hard button
		backIV.setFitWidth(200);							//Setting the Height to 200 for the hard button
				

//----------------------------------------------------------HARD BUTTON:
		hard.setGraphic(hardIV);							//Adding the hard image onto the HARD button
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
		back.setGraphic(backIV);							//Adding the hard image onto the BACK button
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
		BGImg.setFitHeight(1000);
		BGImg.setFitWidth(2000);
		
		gamePane.getChildren().add(BGImg);					//Adding the back ground image to the game pane
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(easy);					//Adding the easy button to the menu
		menuBox.getChildren().add(hard);					//Adding the hard button to the menu
		menuBox.getChildren().add(back);					//Adding the back button to the menu
		
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center

		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; EASY, HARD, BACK to the game pane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
	
//----------------------------------------------------------Attaching the event handlers for EASY
		EasyPVPHandler easyHandle = new EasyPVPHandler(getMenu());
		easy.setOnAction(easyHandle);						//Re-routing upon click on the easy handle

//----------------------------------------------------------Attaching the event handlers for EASY
		HardPVPHandler hardHandle = new HardPVPHandler(getMenu());
		hard.setOnAction(hardHandle);		
		
		
//----------------------------------------------------------Attaching the event handlers for EASY
		back.setOnAction(new EventHandler<ActionEvent>()
		{
				@Override
				public void handle(ActionEvent event) {
					GameSelect scene = new GameSelect(getMenu());
					scene.setup();
				}
		});
		
//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));
		display();
	}
	

}
