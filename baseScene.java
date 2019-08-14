package gui;

//this is all the importas we need to run the program
import java.net.URL;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import drivers.Main;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class baseScene extends JPanel {
	
	//variables instances
	private Scene scene;
	Main menu;
	boolean maintheme = true;
	
	//constructor
	public baseScene(Main menu) {
		this.menu = menu;
	}
	
	//get scene
	public Scene getScene() {
		return scene;
	}
	
	//set scene
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	//get menu
	public Main getMenu() {
		return menu;
	}
	
	//set menu
	public void setMenu(Main menu) {
		this.menu = menu;
	}
	
	//abstract setup
	public abstract void setup();
	
	protected void display() {
		
		menu.setScene(this.scene);
	}
}
