import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import customer.Customer;
import database.GoodsAndTransport;
import database.Login;
import database.Register;
import goods.Goods;
import goods.Person;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Main {

    private static Panel panel = new Panel();

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        loginDialog();

        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);

    }

    public static void loginDialog() throws IOException {
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
                try {
                    panel.removeAllComponents();
                    registerDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));

        panel.addComponent(new Button("Login", new Runnable() {
            @Override
            public void run() {
                try {
                    if (Login.areCredentialsValid(usernameOrEmail.getText(), password.getText())){
                        panel.removeAllComponents();
                        goodsOrTransportDialog();
                    } else {
                        panel.addComponent(new Label("Error: wrong password and/or username.").addStyle(SGR.UNDERLINE));
                    }
                } catch (InvalidKeySpecException | NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
            }
        }));
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
                try {
                    Register.createAccount(username.getText(), email.getText(), password.getText(), confirmPassword.getText());
                    panel.removeAllComponents();
                    loginDialog();
                } catch (InvalidKeySpecException | NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        panel.addComponent(new Button("Cancel", new Runnable() {
            @Override
            public void run() {
                try {
                    panel.removeAllComponents();
                    loginDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    public static void goodsOrTransportDialog() throws IOException {
        panel.setLayoutManager(new GridLayout(3));

        panel.addComponent(new Button("Goods delivery", new Runnable() {
            @Override
            public void run() {
                panel.removeAllComponents();
                goodsDialog();
            }
        }));
        panel.addComponent(new Button("Transport", new Runnable() {
            @Override
            public void run() {
                panel.removeAllComponents();
                transportDialog();
            }
        }));
        panel.addComponent(new Button("Cancel", new Runnable() {
            @Override
            public void run() {
                try {
                    panel.removeAllComponents();
                    loginDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    public static void goodsDialog() {
        panel.setLayoutManager(new GridLayout(2));

        Panel leftPanel = new Panel();
        panel.addComponent(leftPanel.withBorder(Borders.singleLine("Sender Details")));
        leftPanel.setLayoutManager(new GridLayout(2));

        Panel rightPanel = new Panel();
        panel.addComponent(rightPanel.withBorder(Borders.singleLine("Receiver Details")));
        rightPanel.setLayoutManager(new GridLayout(2));

        //LEFT PANEL

        Customer sender = new Customer();

        leftPanel.addComponent(new Label("Customer ID: " + sender.getCustomerNumber()).addStyle(SGR.BOLD).setSize(new TerminalSize(2, 1)));
        leftPanel.addComponent(new EmptySpace(new TerminalSize(0, 0)));

        leftPanel.addComponent(new Label("First name: "));
        TextBox sFirstName = new TextBox();
        leftPanel.addComponent(sFirstName);
        leftPanel.addComponent(new Label("Last name: "));
        TextBox sLastName = new TextBox();
        leftPanel.addComponent(sLastName);

        leftPanel.addComponent(new Label("Address: "));
        TextBox sAddress = new TextBox();
        leftPanel.addComponent(sAddress);

        leftPanel.addComponent(new Label("Phone number: "));
        TextBox sPhoneNumber = new TextBox();
        leftPanel.addComponent(sPhoneNumber);

        leftPanel.addComponent(new Label("Email: "));
        TextBox sEmail = new TextBox();
        leftPanel.addComponent(sEmail);

        //RIGHT PANEL

        Customer receiver = new Customer();

        rightPanel.addComponent(new Label("Customer ID: " + receiver.getCustomerNumber()).addStyle(SGR.BOLD).setSize(new TerminalSize(2, 1)));
        rightPanel.addComponent(new EmptySpace(new TerminalSize(0, 0)));

        rightPanel.addComponent(new Label("First name: "));
        TextBox rFirstName = new TextBox();
        rightPanel.addComponent(rFirstName);
        rightPanel.addComponent(new Label("Last name: "));
        TextBox rLastName = new TextBox();
        rightPanel.addComponent(rLastName);

        rightPanel.addComponent(new Label("Address: "));
        TextBox rAddress = new TextBox();
        rightPanel.addComponent(rAddress);

        rightPanel.addComponent(new Label("Phone number: "));
        TextBox rPhoneNumber = new TextBox();
        rightPanel.addComponent(rPhoneNumber);

        rightPanel.addComponent(new Label("Email: "));
        TextBox rEmail = new TextBox();
        rightPanel.addComponent(rEmail);

        //SUBMIT BUTTON

        panel.addComponent(new Button("Cancel", new Runnable() {
            @Override
            public void run() {
                try {
                    panel.removeAllComponents();
                    goodsOrTransportDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));

        panel.addComponent(new Button("Submit", new Runnable() {
            @Override
            public void run() {
                sender.setFirstName(sFirstName.getText())
                        .setLastName(sLastName.getText())
                        .setAddress(sAddress.getText())
                        .setPhoneNumber(sPhoneNumber.getText())
                        .setEmail(sPhoneNumber.getText());

                receiver.setFirstName(rFirstName.getText())
                        .setLastName(rLastName.getText())
                        .setAddress(rAddress.getText())
                        .setPhoneNumber(rPhoneNumber.getText())
                        .setEmail(rEmail.getText());

                panel.removeAllComponents();
                goodsDetailsDialog(receiver, sender);
            }
        }));

        panel.addComponent(new EmptySpace(new TerminalSize(2, 0)));
    }

    public static void goodsDetailsDialog(Customer receiver, Customer sender){
        panel.setLayoutManager(new GridLayout(2));

        Goods goods = new Goods();

        Panel leftPanel = new Panel();
        panel.addComponent(leftPanel.withBorder(Borders.singleLine("Goods Details")));
        leftPanel.setLayoutManager(new GridLayout(2));

        Panel rightPanel = new Panel();
        panel.addComponent(rightPanel.withBorder(Borders.singleLine("Summary")));
        rightPanel.setLayoutManager(new GridLayout(2));

        //LEFT PANEL

        Pattern floatPattern = Pattern.compile("[0-9]*\\.?[0-9]+");

        leftPanel.addComponent(new Label("Shipping date: ").addStyle(SGR.BOLD));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        leftPanel.addComponent(new Label(format.format(new Date(System.currentTimeMillis()))));

        leftPanel.addComponent(new Label("Description: "));
        TextBox description = new TextBox();
        leftPanel.addComponent(description);

        leftPanel.addComponent(new Label("Weight (kg): "));
        TextBox weight = new TextBox().setValidationPattern(floatPattern);
        leftPanel.addComponent(weight);

        leftPanel.addComponent(new Label("Width (cm): "));
        TextBox width = new TextBox().setValidationPattern(floatPattern);
        leftPanel.addComponent(width);

        leftPanel.addComponent(new Label("Length (cm): "));
        TextBox length = new TextBox().setValidationPattern(floatPattern);
        leftPanel.addComponent(length);

        leftPanel.addComponent(new Label("Height (cm): "));
        TextBox height = new TextBox().setValidationPattern(floatPattern);
        leftPanel.addComponent(height);

        //RIGHT PANEL

        rightPanel.addComponent(new Label("Transport fee: "));
        Label fee = new Label("0,00 kr");
        rightPanel.addComponent(fee);

        rightPanel.addComponent(new Label("Service fee: "));
        Label service = new Label("10,00 kr");
        rightPanel.addComponent(service);

        rightPanel.addComponent(new Label("Total cost: "));
        Label total = new Label("10,00 kr");
        rightPanel.addComponent(total);

        weight.setTextChangeListener(new TextBox.TextChangeListener() {
            @Override
            public void onTextChanged(String s, boolean b) {
                fee.setText(setNewFee(weight, length, width, height));
            }
        });
        length.setTextChangeListener(new TextBox.TextChangeListener() {
            @Override
            public void onTextChanged(String s, boolean b) {
                fee.setText(setNewFee(weight, length, width, height));
            }
        });
        width.setTextChangeListener(new TextBox.TextChangeListener() {
            @Override
            public void onTextChanged(String s, boolean b) {
                fee.setText(setNewFee(weight, length, width, height));
            }
        });
        height.setTextChangeListener(new TextBox.TextChangeListener() {
            @Override
            public void onTextChanged(String s, boolean b) {
                fee.setText(setNewFee(weight, length, width, height));
            }
        });

        panel.addComponent(new Button("Cancel", new Runnable() {
            @Override
            public void run() {
                panel.removeAllComponents();
                goodsDialog();
            }
        }));
        panel.addComponent(new Button("Submit", new Runnable() {
            @Override
            public void run() {
                try {
                    goods.setDescription(description.getText())
                            .setWeight(Float.parseFloat(weight.getText()))
                            .setHeight(Float.parseFloat(height.getText()))
                            .setWidth(Float.parseFloat(width.getText()))
                            .setLength(Float.parseFloat(length.getText()))
                            .setReceiver(receiver)
                            .setSender(sender);

                    GoodsAndTransport.createNewGoods(goods);

                    panel.removeAllComponents();
                    goodsOrTransportDialog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    public static void transportDialog(){

    }

    public static String setNewFee(TextBox weight, TextBox length, TextBox width, TextBox height){
        float goodsWeight = weight.getText().matches("-?\\d+") ? Float.parseFloat(weight.getText()) : 0;
        int iLength = length.getText().matches("-?\\d+") ? Integer.parseInt(length.getText()) : 0;
        int iWidth = width.getText().matches("-?\\d+") ? Integer.parseInt(width.getText()) : 0;
        int iHeight = height.getText().matches("-?\\d+") ? Integer.parseInt(height.getText()) : 0;

        int newFee = 0;
        boolean isSmall = true;

        if (iLength + (iLength + iWidth + iWidth + iHeight + iHeight) >= 200) {
            isSmall = false;
        }

        if (goodsWeight < 3 && isSmall){
            newFee = 140;
        } else if (goodsWeight < 5 && isSmall) {
            newFee = 167;
        } else if (goodsWeight < 10 && isSmall) {
            newFee = 212;
        } else if (goodsWeight < 15 && isSmall) {
            newFee = 258;
        } else if (goodsWeight < 20 && isSmall) {
            newFee = 298;
        } else if (goodsWeight < 3 && !isSmall){
            newFee = 203;
        } else if (goodsWeight < 5 && !isSmall) {
            newFee = 244;
        } else if (goodsWeight < 10 && !isSmall) {
            newFee = 312;
        } else if (goodsWeight < 15 && !isSmall) {
            newFee = 380;
        } else if (goodsWeight < 20 && !isSmall) {
            newFee = 441;
        }

        return newFee + ",00 kr";
    }

}
