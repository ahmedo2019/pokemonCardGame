**README file for the Card Match Memory Game**

Welcome to the Card Match Memory Game Instructions.

To run the game and execute the program using eclipes here are the instructions:

1) Download the repository as a ZIP folder from the GitHub repository or D2L called 
	pokemonCardGame; this repository is under the owner of ahmedo2019 and
	unzip the file. This is the link of the repository:

	******	https://github.com/ahmedo2019/pokemonCardGame.git  ******

2) Once the file has been downloaded from the repository, import the files using
	eclipse "CardGameTextBased" - this be the text version of the game - while 
	the 3 packages "drivers" , "gui" and "handlers" will be the gui version 
	of the game.

3) To run the text verion of the game, you need to run the file "Game.java" in the 
	folder "CardGameTextBased". The Game.java file will need to be compiled in
	command prompt using the "javac Game.java" and then run using the 
	"java Game.java."

4) In order to run the gui (javafx) version of the game, you need to open the file
	and create a new java project, you may call it for "PokemonGame" for example.

5) Import all the files from CardGameTextBased into your "src" folder that will be 
	ur default package make three new packages drivers , handlers and gui.

6) Import everything from drivers file into the driver package, Import everthing 
	from gui folder into the gui package and import evertthing form handlers 
	folder to handler package .

7) Change the folder path in this 1 file from path 
	"file:C:\Users\Aaron\eclipse-workspace\CardMatchMemoryGame\bin\loopmusicjavaupdated\ "
	and replace it with your personal path file.
		- Main

8) Change the folder path in these 8 files to path 
	"file:C:\Users\Aaron\eclipse-workspace\CardMatchMemoryGame\bin\loopmusicjavaupdated\ "
	and replace it with your personal path file.
		- LaunchCPU
		- LaunchPVP
		- PVPSelect
		- GameSelect
		- CreditScene
		- CPUSelect
		- compgraphics
		- firstScene

9) Change the folder path in these 2 files to path 
	"file:C:\Users\Aaron\eclipse-workspace\CardMatchMemoryGame\bin\loopmusicjavaupdated\ "
	and replace it with your personal path file.
		- firstScene
		- buttonHandlers


10) In order to run the gui version of the game,  run the class "Main.java" in your
	command prompt using the "javac Main.java" to compile the code and then use
	"java Main.java" to run the game.

11) After compiling and executing the program will RUN and the instructions will be 
	displayed as the program runs.

****************** Message from our developers ******************
 
Remember that the grid that is shown in the console for the text 
based version starts at (0,0) at the top left corner. This means 
that both the X-coordinate and the Y-coordinate are equal to zero. 
The grid will always return the player to (0,0)(top-most left 
corner) after a selection of a X,Y point. To select a new card, 
you must remember that you will be located to (0,0) so therefore 
must move your X (always left) and Y (always down) coordinates with 
this in mind to choose the right card.

Please also ensure that all the images are have an \\ in the " "
rather than a \. This will cause errors and will not allow the code
to run. Also ensure that path file of the images are correct and lead
to the image, an error in the file paths will also cause an error
to occur.

***************************************************************** 

Thank you for playing our Pokemon Card Match Memory Game.

Game Developers:
- Aaron Gao
- Adarsha Kanel
- Ahmed Obad
- Joshua Bernard

CPSC 233 - T04 - S2019 - Dr.Nathaly Verwaal