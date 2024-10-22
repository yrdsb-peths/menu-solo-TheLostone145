import greenfoot.*;

public class InstructionScreen extends World 
{
    private MenuScreen menuScreen;  
    private String[] instructions = 
    {
        "Screen 1",
        "Screen 2",
        "Screen 3"
    };

    private int currentIndex = 0;
    private Label instructionLabel;
    public InstructionScreen(MenuScreen menuScreen) 
    {
        super(600, 400, 1);
        this.menuScreen = menuScreen;
        instructionLabel = new Label(instructions[currentIndex], 24);
        addObject(instructionLabel, 300, 200); 
        addObject(new Button(this::cycleInstruction), 300, 300);
        addObject(new Button(this::goBack), 300, 350);
    }
    public void cycleInstruction() 
    {
        currentIndex++;
        if (currentIndex >= instructions.length) 
        {
            currentIndex = 0;
        }
        removeObject(instructionLabel);
        instructionLabel = new Label(instructions[currentIndex], 24);
        addObject(instructionLabel, 300, 200);
    }

    public void goBack() 
    {
        Greenfoot.setWorld(menuScreen);  
    }
}
