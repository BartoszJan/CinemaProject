import com.mojafirma.gui.MenuPanel;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater (new Runnable() {
            public void run() {
                MenuPanel menuPanel = new MenuPanel();
                menuPanel.setVisible(true);
            }
        });
    }
}
