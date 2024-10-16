import greenfoot.*;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatarQueue;
    private GreenfootImage currentAvatar;
    private Label avatarLabel;

    public MenuScreen() {
        super(600, 400, 1);

        addObject(new Button(this::goInstructions), 300, 300);
        
        avatarQueue = new Queue<>();
        loadAvatars();
        currentAvatar = avatarQueue.peek();
        avatarLabel = new Label(currentAvatar, 100, 100);
        addObject(avatarLabel, 300, 200);
        
        // Cycle Avatar Button
        addObject(new Button(this::cycleAvatar), 300, 350);
    }

    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
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
        avatarLabel.setImage(currentAvatar);  // Assuming Label can handle an image
    }
}
