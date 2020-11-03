import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import database.Login;

import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {

        loginDialog();

    }

    private static Panel panel = new Panel();

    public static void loginDialog() throws IOException {
        //TODO: Add login dialog
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("Username/email:"));
        TextBox usernameOrEmail = new TextBox();
        panel.addComponent(usernameOrEmail);

        panel.addComponent(new Label("Password:"));
        TextBox password = new TextBox();
        panel.addComponent(password);

        panel.addComponent(new Button("Register", new Runnable() {
            @Override
            public void run() {
                panel.removeAllComponents();
                try {
                    registerDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));

        panel.addComponent(new Button("Login", new Runnable() {
            @Override
            public void run() {
                System.out.println("Test");
                if (!Login.areCredentialsValid(usernameOrEmail.getText(), password.getText())){
                    System.out.println("Error");
                }
            }
        }));

        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
    }

    public static void registerDialog() throws IOException {
        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("Username:"));
        TextBox username = new TextBox();
        panel.addComponent(username);

        panel.addComponent(new Label("Email:"));
        TextBox email = new TextBox();
        panel.addComponent(email);

        panel.addComponent(new Label("Password:"));
        TextBox password = new TextBox();
        panel.addComponent(password);

        panel.addComponent(new Label("ConfirmPassword:"));
        TextBox confirmPassword = new TextBox();
        panel.addComponent(confirmPassword);

        panel.addComponent(new Button("Create account", new Runnable() {
            @Override
            public void run() {
                System.out.println("Hej");
            }
        }));
    }



    public static void ticketDialog() throws IOException {
        //TODO: Add ticket dialog
            //What transport method to use
            //What persons will travel
    }

}
