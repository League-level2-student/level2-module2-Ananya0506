package _08_LeagueSnake;

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
        frameRate(20);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
        FoodX = ((int)random(50)*10);
        FoodY = ((int)random(50)*10);
        rect(FoodX, FoodY, 5,5);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
        background(0,0,0);
        drawFood();
        move();
        drawSnake();
        eat();
    }

    void drawFood() {
        // Draw the food
fill(0,238,255);
rect(FoodX, FoodY, 10,10);
        		
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    fill(255,200,0);
    rect(x,y,20,20);
    
    }

    void drawTail() {
        // Draw each segment of the tail
    	fill(50,150,250);
    	rect(30,20,15,10);
    	rect(30,20,15,10);
    	rect(30,20,15,10);
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

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
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
    
    if (keyCode == 37) {
    	direction = LEFT;
    } else if (keyCode == 38) {
    	direction = UP;
    } else if (keyCode == 39) {
    	direction = RIGHT;
    } else if (keyCode == 40) {
    	direction = DOWN;
    }
    
    
    
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

    
        if (direction == UP) {
            // Move head up
            y--;
        } else if (direction == DOWN) {
            // Move head down
                y++;
        } else if (direction == LEFT) {
            x--;
        } else if (direction == RIGHT) {
            x++;
        }
     checkBoundaries();
     
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(x>500 || x<0 || y>500 || y<0) {
        	
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if (x==FoodX && y==FoodY) {
        	FoodEaten++;
        	drawFood();
        }
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
