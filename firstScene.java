package gui;

import drivers.Main;
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
import loopmusicjavaupdated.musicStuff;

public class firstScene extends baseScene{
	StackPane gamePane = new StackPane();				//A stackPane for the game window	
	public static boolean playMusic = false;			//Adding boolean false to stop music
	
	
	public firstScene(Main menu) {						//Calling the menu from the parent using super
		super(menu);
	}

	
	@Override
	public void setup() {
		
		if (playMusic == false) {
			String filepath = ("C:\\Users\\aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\Poketheme.wav");		//Playing the audio file for background music
			musicStuff musicObject = new musicStuff();																//Calling the music stuff class
			musicObject.playMusic(filepath);																		//Playing the music based on filepath
		}
		

		
		ImageView BGImg = new ImageView("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\pokemonBackground2.png");
		
//----------------------------------------------------------Adding Button Images:
		Image startImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\START.png");			//Adding the image for the start button
		ImageView startIV = new ImageView(startImg);
		Image creditsImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\CREDITS.png");		//Adding the image for the credits button
		ImageView creditsIV = new ImageView(creditsImg);
		Image exitImg = new Image("file:C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\bin\\loopmusicjavaupdated\\EXIT.png");				//Adding the image for the exit button
		ImageView exitIV = new ImageView(exitImg);
//----------------------------------------------------------Creating Buttons:
		Button start = new Button();						//Adding a START button
		Button credits = new Button();						//Adding a CREDITS button
		Button exit = new Button ();						//Adding a EXIT button
		
		
//----------------------------------------------------------START BUTTON:
		start.setGraphic(startIV);							//Adding the start image onto the START button
		start.setBackground(null);							//Removing the background of the button
		start.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			start.setEffect(new DropShadow(50, Color.CRIMSON));		//Drop shadow is changed to a red color
			start.setScaleX(1.1);							//Zooming in when mouse hovered
			start.setScaleY(1.1);
		});
		start.setOnMouseExited(a-> {						//When mouse clicks off
			start.setEffect(null);							//Removing the background of the button
			start.setScaleX(1.0);
			start.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});
		
//----------------------------------------------------------CREDITS BUTTON:
		credits.setGraphic(creditsIV);						//Adding the credit image onto the credit button
		credits.setBackground(null);						//Removing the background of the button
		credits.setOnMouseEntered(a->{						//Adding the drop-shadow on the button when mouse hovers on the button
			credits.setEffect(new DropShadow(50, Color.CRIMSON));		//Drop shadow is changed to a red color
			credits.setScaleX(1.1);							//Zooming in when mouse hovered
			credits.setScaleY(1.1);
		});
		credits.setOnMouseExited(a-> {						//When mouse clicks off
			credits.setEffect(null);						//Removing the background of the button
			credits.setScaleX(1.0);
			credits.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});
//----------------------------------------------------------EXIT BUTTON:
		exit.setGraphic(exitIV);							//Adding the exit image onto the exit button
		exit.setBackground(null);							//Removing the background of the button
		exit.setOnMouseEntered(a->{							//Adding the drop-shadow on the button when mouse hovers on the button
			exit.setEffect(new DropShadow(50, Color.CRIMSON));		//Drop shadow is changed to a red color
			exit.setScaleX(1.1);							//Zooming in when mouse hovered
			exit.setScaleY(1.1);
		});
		exit.setOnMouseExited(a-> {							//When mouse clicks off
			exit.setEffect(null);							//Removing the background of the button
			exit.setScaleX(1.0);
			exit.setScaleY(1.0);							//Zooming out when mouse not hovering
			
		});
		
//----------------------------------------------------------Sizing the Buttons:	
		startIV.setFitHeight(90);							//Setting the Height to 90 for the start button
		startIV.setFitWidth(200);							//Setting the Height to 200 for the start button
				
		creditsIV.setFitHeight(90);							//Setting the Height to 90 for the credits button
		creditsIV.setFitWidth(200);							//Setting the Height to 200 for the credits button
				
		exitIV.setFitHeight(90);							//Setting the Height to 90 for the exit button
		exitIV.setFitWidth(200);							//Setting the Height to 200 for the exit button
		
//----------------------------------------------------------Menu Box, Alignment & Setting up Game Pane
		BGImg.setFitHeight(1000);							//Setting the background to the full window screen (Height)
		BGImg.setFitWidth(1950);							//Setting the background to the full window screen (With)
		
		VBox menuBox = new VBox();							//Adding the buttons to the VBox
		menuBox.getChildren().add(start);					//Adding the start button to the menu
		menuBox.getChildren().add(credits);					//Adding the credits button to the menu
		menuBox.getChildren().add(exit);					//Adding the exit button to the menu
		
		menuBox.setAlignment(Pos.CENTER);					//Aligning the menu start & quit buttons to the center
		
		gamePane.getChildren().add(BGImg);					//Adding the Background Image on to the game pane
		gamePane.getChildren().add(menuBox);				//Adding the menuBox with the; START, CREDITS, EXIT to the game pane
		gamePane.setAlignment(Pos.CENTER);					//Aligning to the center
		
		
//----------------------------------------------------------Attaching the event handlers for START
		start.setOnAction(new EventHandler<ActionEvent>()	//Calling a set on action for mouse click on the start button
				{
			@Override
			public void handle(ActionEvent event) {			//Mouse click for the start button
				playMusic = true;							//Making the boolean as true to play music
				GameSelect scene = new GameSelect(getMenu()); //Going to the game select screen after clicking start
				scene.setup();								//Setting up the scene.
				
			}
	});

//----------------------------------------------------------Attaching the event handlers for CREDITS
		credits.setOnAction(new EventHandler<ActionEvent>()	//Calling a set on action for mouse click on the credits button
				{
			@Override
			public void handle(ActionEvent event) {
				System.out.println("GAME DEVELOPED BY:\nAaron Gao\nAdarsha Kanel\nAhmed Obad\nJoshua Bernard\nCPSC 233 - T04");
				playMusic = true;									//Making the boolean as true to play music
				CreditScene scene = new CreditScene(getMenu());		//Adding the credits scene with menu as parameter
				scene.setup();										//setting up the scene again
				
			}
	});

//----------------------------------------------------------Attaching the event handlers for EXIT
		exit.setOnAction(new EventHandler<ActionEvent>()	//Calling a set on action for mouse click on the exit button
		{
				@Override
				public void handle(ActionEvent event) {		//Mouse click for the exti button
					Platform.exit();						//exiting the game
					
				}
		});
		
//----------------------------------------------------------Setting up the scene and showing display
		setScene(new Scene( gamePane, 2000, 1000));
		display();
	}

}

