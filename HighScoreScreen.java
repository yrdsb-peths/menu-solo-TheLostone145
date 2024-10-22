import java.util.Map;
import java.util.HashMap;
import greenfoot.*;

public class HighScoreScreen extends World {
    private Map<String, Integer> highScores;
    private MenuScreen menuScreen;

    public HighScoreScreen(MenuScreen menuScreen) {
        super(600, 400, 1);
        this.menuScreen = menuScreen;
        highScores = new HashMap<>();
        loadScores();
        displayScores();
        
        addObject(new Button(this::goBack), 300, 350);
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

    public void goBack() {
        Greenfoot.setWorld(menuScreen);  
    }
}
