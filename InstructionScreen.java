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
    public InstructionScreen(MenuScreen menuScreen) 
    {
        super(600, 400, 1);
        instructionLabel = new Label(instructions[currentIndex], 24);
        addObject(instructionLabel, 300, 200); 
        addObject(new Button(this::cycleInstruction), 300, 300);
        addObject(new Button(this::goBack), 300, 350);
    }
    public void cycleInstruction(){
        int indexNum=currentIndex;
        indexNum++;
        removeObject(instructionLabel);
        instructionLabel=new Label(instructions[indexNum], 24);
        addObject(instructionLabel, 300, 200);
    }

    public void goBack() 
    {
        Greenfoot.setWorld(menuScreen);  
    }
}
