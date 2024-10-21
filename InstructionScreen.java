import greenfoot.*;

public class InstructionScreen extends World 
{
    private MenuScreen menuScreen;  
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
        addObject(new Button(this::goBack), 300, 300);
    }

    public void goBack() 
    {
        Greenfoot.setWorld(menuScreen);  
    }
}
