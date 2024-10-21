import greenfoot.*;

public class InstructionScreen extends World 
{
    private MenuScreen menuScreen;  
    private Queue<Label> screenQueue; 
    private Label currentScreen;
    private Label screenLabel;
    private String[] instructions = {
        "Welcome to the game!",
        "Use arrow keys to move.",
        "Collect coins to score points."
    };
    private int currentIndex = 0;
    private Label instructionLabel;
    public InstructionScreen() 
    {
        super(600, 400, 1);
        instructionLabel = new Label(instructions[currentIndex], 24);
        addObject(instructionLabel, 300, 200);
        screenQueue = new Queue<>(); 
        addObject(new Button(this::goBack), 300, 350);
        addObject(new Button(this::cycleScreens), 300, 350);

        loadScreen();
        currentScreen = screenQueue.peek();
        screenLabel = new Label(currentScreen, 100, 100);
        addObject(screenLabel, 300, 200);
    }

    public void goBack() 
    {
        Greenfoot.setWorld(menuScreen);  
    }

    private void loadScreen() {
        screenQueue.enqueue(new Label(1, 100));
        screenQueue.enqueue(new Label(2, 100));
        screenQueue.enqueue(new Label(3, 100));
    }
    public void cycleScreens() {
       
        Label firstScreen = screenQueue.dequeue();
        screenQueue.enqueue(firstScreen);
        currentScreen = screenQueue.peek();
        removeObject(screenLabel);
        screenLabel = null; 
        screenLabel = currentScreen;
        addObject(screenLabel, 300, 200);  
    }
}
