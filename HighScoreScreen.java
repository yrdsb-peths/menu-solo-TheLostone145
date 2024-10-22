import java.util.Map;
import java.util.HashMap;
import greenfoot.*;

public class HighScoreScreen extends World {
    private Map<String, Integer> highScores;
    private MenuScreen menuScreen;
    
    private String[] instructions = {
        "Screen 1",
        "Screen 2",
        "Screen 3"
    };
    private int currentInstructionIndex = 0;
    private Label instructionLabel;

    public HighScoreScreen(MenuScreen menuScreen) {
        super(600, 400, 1);
        this.menuScreen = menuScreen;
        highScores = new HashMap<>();
        loadScores();
        displayScores();
        displayInstruction();
        
        addObject(new Button(this::goBack), 300, 350);
        addObject(new Button(this::previousInstruction), 150, 300);
        addObject(new Button(this::nextInstruction), 450, 300);
    }

    private void loadScores() {
        highScores.put("Alice", 100);
        highScores.put("Bob", 80);
        highScores.put("Charlie", 120);
    }

    private void displayScores() {
        int y = 100;
        for (Map.Entry<String, Integer> entry : highScores.entrySet()) {
            Label scoreLabel = new Label(entry.getKey() + ": " + entry.getValue(), 24);
            addObject(scoreLabel, 300, y);
            y += 50;
        }
    }

    private void displayInstruction() {
        if (instructionLabel != null) {
            removeObject(instructionLabel);
        }
        instructionLabel = new Label(instructions[currentInstructionIndex], 24);
        addObject(instructionLabel, 300, 50);
    }

    public void previousInstruction() {
        currentInstructionIndex--;
        if (currentInstructionIndex < 0) {
            currentInstructionIndex = instructions.length - 1;
        }
        displayInstruction();
    }

    public void nextInstruction() {
        currentInstructionIndex++;
        if (currentInstructionIndex >= instructions.length) {
            currentInstructionIndex = 0;
        }
        displayInstruction();
    }

    public void goBack() {
        Greenfoot.setWorld(menuScreen);  
    }
}
