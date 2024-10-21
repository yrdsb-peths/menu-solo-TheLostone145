import greenfoot.*;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatarQueue;
    private Queue<Label> screenQueue; 
    private GreenfootImage currentAvatar;
    private Label currentScreen;
    private Label avatarLabel;
    private Label screenLabel;

    public MenuScreen() {
        super(600, 400, 1);

        
        avatarQueue = new Queue<>();
        screenQueue = new Queue<>(); 

        addObject(new Button(this::cycleScreens), 300, 350);
       
        loadAvatars();
        loadScreen(); 
        currentAvatar = avatarQueue.peek();
        currentScreen = screenQueue.peek();
       
        avatarLabel = new Label(currentAvatar, 100, 100);
        screenLabel = new Label(currentScreen, 100, 100);
       
        addObject(avatarLabel, 300, 200);
        addObject(screenLabel, 300, 200);
       
        addObject(new Button(this::cycleAvatar), 300, 300);
    }

    private void loadAvatars() {
        avatarQueue.enqueue(new GreenfootImage("images/face_a.png"));
        avatarQueue.enqueue(new GreenfootImage("images/face_b.png"));
        avatarQueue.enqueue(new GreenfootImage("images/face_c.png"));
    }

    private void loadScreen() {
        screenQueue.enqueue(new Label(1, 100));
        screenQueue.enqueue(new Label(2, 100));
        screenQueue.enqueue(new Label(3, 100));
    }

    public void cycleAvatar() {
        GreenfootImage firstAvatar = avatarQueue.dequeue();
        avatarQueue.enqueue(firstAvatar);
        currentAvatar = avatarQueue.peek();
        avatarLabel.setImage(currentAvatar);
    
        if (screenLabel != null) {
            removeObject(screenLabel);
            screenLabel = null; 
        }
    }

    public void cycleScreens() {
       
        Label firstScreen = screenQueue.dequeue();
        screenQueue.enqueue(firstScreen);
        currentScreen = screenQueue.peek();
    
        if (screenLabel == null) {
            removeObject(screenLabel);
        }
    
        screenLabel = currentScreen;
        addObject(screenLabel, 300, 200);  
    }
    
}