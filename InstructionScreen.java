import greenfoot.*;

public class InstructionScreen extends World {
    private MenuScreen menuScreen;  

    public InstructionScreen(MenuScreen menuScreen) {
        super(600, 400, 1);
        this.menuScreen = menuScreen;  
        addObject(new Button(this::goBack), 300, 350);
    }

    public void goBack() {
        Greenfoot.setWorld(menuScreen);  
    }
}
