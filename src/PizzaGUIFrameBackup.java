import javax.swing.*;
import java.awt.*;

public class PizzaGUIFrameBackup extends JFrame {

    //////////////// GUI component instance variable declarations /////////////////
    //attempting to follow proper practice for scope declarations of GUI elements
    //used some ill-advised initializations outside the class constructor during the tic-tac-toe lab



    private JPanel topPanel;
    private JPanel headingSubPanel;
    private JPanel crustAndSizeSubPanel;
    private JPanel toppingsSubPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;

    private JLabel headingTextLabel;

    private ButtonGroup crustGroup;
    private JRadioButton thinCrust, regularCrust, largeCrust, deepCrust;

    private JComboBox<String> pizzaSize;

    //toppings mostly meat focused since those are more worth a $1 price tag, veggies are usually less
    private JCheckBox pepperoni;
    private JCheckBox extraCheese;
    private JCheckBox sausage;
    private JCheckBox bacon;
    private JCheckBox ham;
    private JCheckBox beef;
    private JCheckBox phillySteak;
    private JCheckBox pineapple;

    private JTextArea orderSummary;
    private JScrollPane orderScroller;

    private JButton orderButton, clearButton, quitButton;


    public PizzaGUIFrameBackup() {

        super("Pizza GUI Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(1, 1));

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));

        headingSubPanel = new JPanel();
        headingTextLabel = new JLabel("Pizza Order Form");
        headingSubPanel.add(headingTextLabel);


        crustAndSizeSubPanel = new JPanel();

        pizzaSize = new JComboBox();
        pizzaSize.addItem("Small");
        pizzaSize.addItem("Medium");
        pizzaSize.addItem("Large");
        pizzaSize.addItem("Super");
        pizzaSize.setSelectedIndex(1);
        crustAndSizeSubPanel.add(pizzaSize);


        crustGroup = new ButtonGroup();
        thinCrust = new JRadioButton("Thin");
        regularCrust = new JRadioButton("Regular");
        largeCrust = new JRadioButton("Large");
        deepCrust = new JRadioButton("Deep-dish");
        crustGroup.add(thinCrust);
        crustGroup.add(regularCrust);
        crustGroup.add(largeCrust);
        crustGroup.add(deepCrust);
        crustAndSizeSubPanel.add(thinCrust);
        crustAndSizeSubPanel.add(regularCrust);
        crustAndSizeSubPanel.add(largeCrust);
        crustAndSizeSubPanel.add(deepCrust);

        topPanel.add(crustAndSizeSubPanel);

        toppingsSubPanel = new JPanel();
        toppingsSubPanel.setLayout(new GridLayout(2, 4));
        pepperoni = new JCheckBox("Pepperoni");
        extraCheese = new JCheckBox("Extra Cheese");
        sausage = new JCheckBox("Sausage");
        bacon = new JCheckBox("Bacon");
        ham = new JCheckBox("Ham");
        beef = new JCheckBox("Beef");
        phillySteak = new JCheckBox("Philly Steak");
        pineapple = new JCheckBox("Pineapple");

        toppingsSubPanel.add(pepperoni);
        toppingsSubPanel.add(extraCheese);
        toppingsSubPanel.add(sausage);
        toppingsSubPanel.add(bacon);
        toppingsSubPanel.add(ham);
        toppingsSubPanel.add(beef);
        toppingsSubPanel.add(phillySteak);
        toppingsSubPanel.add(pineapple);

        topPanel.add(toppingsSubPanel);

        middlePanel = new JPanel();
        orderSummary = new JTextArea();
        orderScroller = new JScrollPane(orderSummary);
        orderScroller.add(orderSummary);
        middlePanel.add(orderScroller);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        quitButton = new JButton("Quit");
        bottomPanel.add(orderButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(quitButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


}
