import greenfoot.*;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatarQueue;
    private GreenfootImage currentAvatar;
    private Label avatarLabel;
    private Label screenLabel;

    public MenuScreen() {
        super(600, 400, 1);

        addObject(new Button(this::goToHighScores), 300, 350);
        avatarQueue = new Queue<>();
       
        loadAvatars();
       
        currentAvatar = avatarQueue.peek();
        screenLabel = new Label("Menu", 75);
       
        avatarLabel = new Label(currentAvatar, 100, 100);
        avatarLabel.setImage(currentAvatar);
       
        addObject(avatarLabel, 300, 200);
        addObject(screenLabel, 300, 100);
       
        addObject(new Button(this::cycleAvatar), 300, 250);

        addObject(new Button(this::goToInstructionScreen), 300, 300);
    }

    private void loadAvatars() {
        avatarQueue.enqueue(new GreenfootImage("images/face_a.png"));
        avatarQueue.enqueue(new GreenfootImage("images/face_b.png"));
        avatarQueue.enqueue(new GreenfootImage("images/face_c.png"));
    }

    public void cycleAvatar() {
        GreenfootImage firstAvatar = avatarQueue.dequeue();
        avatarQueue.enqueue(firstAvatar);
        currentAvatar = avatarQueue.peek();
        avatarLabel.setImage(currentAvatar);
    
    }


    public void goToHighScores() {
        Greenfoot.setWorld(new HighScoreScreen(this)); 
    }
    public void goToInstructionScreen() {
        Greenfoot.setWorld(new InstructionScreen(this)); 
    }
    
}