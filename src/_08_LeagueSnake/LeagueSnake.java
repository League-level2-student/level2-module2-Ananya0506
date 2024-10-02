package _08_LeagueSnake;

import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.event.KeyEvent;


public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
 
    
     * Put all the game variables here.
     */
Segment head;
int x = 100;
int y = 100;
int FoodX;
int FoodY;
int direction = UP;
int FoodEaten = 0;    
ArrayList<Segment>tail = new ArrayList<>();

/*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        head = new Segment(x, y);
        frameRate(15);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
        FoodX = ((int)random(25)*20);
        FoodY = ((int)random(25)*20);
        
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0,0,0);
      text("Food Eaten: " + FoodEaten, 10,10);
        drawFood();
        move();
        drawSnake();
        eat();
    }

    void drawFood() {
        // Draw the food
fill(0,238,255);
rect(FoodX, FoodY, 20,20);
        		
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    fill(255,200,0);
    rect(x,y,20,20);
    manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
    	
    	for(int i = 0; i<tail.size(); i++) {
    		rect(tail.get(i).x,tail.get(i).y,20,20); 
    	}
 

    	
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
checkTailCollision();
drawTail();
Segment seg  = new Segment(x,y);
tail.add(seg);
tail.remove(0);
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        for(int a = 0; a<tail.size(); a++) {
        	if(tail.get(a).x == x  && tail.get(a).y == y) {
        	tail = new ArrayList<>();
        	FoodEaten = 1;
        	break;
        	}
    
        }
    }
    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed(KeyEvent e) {
    	
        // Set the direction of the snake according to the arrow keys pressed
    	int keyCode = e.getKeyCode();
    
    if (keyCode == 37 && direction!= RIGHT) {
    	direction = LEFT;
    } else if (keyCode == 38 && direction!=DOWN) {
    	direction = UP;
    } else if (keyCode == 39 && direction!= LEFT) {
    	direction = RIGHT;
    } else if (keyCode == 40 && direction!= UP) {
    	direction = DOWN;
    }
    
    
    
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

    
        if (direction == UP) {
            // Move head up
            y-=20;
        } else if (direction == DOWN) {
            // Move head down
                y+=20;
        } else if (direction == LEFT) {
            x-=20;
        } else if (direction == RIGHT) {
            x+=20;
        }
     checkBoundaries();
     
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(x>500) {
        	x=0;
        } else if (x<0) {
        	x=480;
        } else if (y>500) {
        	y=0;
        } else if (y<0) {
        	y=480;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if (x==FoodX && y==FoodY) {
        	FoodEaten++;
        	dropFood();
        Segment seg2 = new Segment(x,y);
        	tail.add(seg2);
        }
    }
    

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
