import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class PizzaGUIFrame extends JFrame {

    //////////////GUI declarations///////////////

    //makes use of the linked PizzaGUIForm.form file to determine GUI layout
    private JPanel marginPanel;
    private JPanel mainPanel;
    private JPanel pizzaOptionsPanel;

    private JPanel pizzaSizePanel;
    private JComboBox pizzaSize;

    private JPanel crustOptionsPanel;
    private ButtonGroup crustGroup;
    private JRadioButton thinCrust;
    private JRadioButton regularCrust;
    private JRadioButton largeCrust;
    private JRadioButton deepCrust;

    private JPanel toppingsPanel;

    private JCheckBox pepperoni;
    private JCheckBox extraCheese;
    private JCheckBox sausage;
    private JCheckBox bacon;
    private JCheckBox ham;
    private JCheckBox beef;
    private JCheckBox phillySteak;
    private JCheckBox pineapple;

    private JScrollPane orderScroller;
    private JTextArea orderSummary;
    private JPanel buttonPanel;
    private JButton orderButton;
    private JButton clearButton;
    private JButton quitButton;
    private JRadioButton invisCrust;

    public PizzaGUIFrame()  {
        setContentPane(marginPanel);
        setTitle("Pizza GUI Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);

        setLocationRelativeTo(null);
        setVisible(true);

        orderButton.addActionListener((ActionEvent e) -> generateOrder());
        clearButton.addActionListener((ActionEvent e) -> clearSelections());
        quitButton.addActionListener((ActionEvent e) -> quitConfirm());

    }


    /**
     * Generates a receipt based on the given pizza order
     * Checks if at least one topping and crust is selected. By default, medium is selected for pizza size
     * If no topping or crust, will instead show a message box asking the user to pick one of each
     */
    private void generateOrder() {
        orderSummary.setText("Order Test");

        //checks if a crust was selected
        if (!(thinCrust.isSelected() || regularCrust.isSelected() ||
                largeCrust.isSelected() || deepCrust.isSelected())) {
            JOptionPane.showMessageDialog(orderSummary, "Please select a crust");
            return;
        }
        //checks if a topping was selected
        if (!(pepperoni.isSelected() || extraCheese.isSelected() ||
                sausage.isSelected() || bacon.isSelected() ||
                ham.isSelected() || pepperoni.isSelected() ||
                phillySteak.isSelected() || pineapple.isSelected())) {
            JOptionPane.showMessageDialog(orderSummary, "Please at least one topping");
            return;
        }

        //if at least one crust and topping is selected, calculate the total and show a receipt


        double subtotal = 0.00;
        double finalTotal = 0.00;
        double salesTaxRate = 0.07;
        double salesTax = 0.00;

        String selectedCrust = "";
        if (thinCrust.isSelected()) {
            selectedCrust = "Thin Crust";
        }
        else if (regularCrust.isSelected()) {
            selectedCrust = "Regular Crust";
        }
        else if (largeCrust.isSelected()) {
            selectedCrust = "Large Crust";
        }
        else if (deepCrust.isSelected()) {
            selectedCrust = "Deep Crust";
        }


        double basePizzaCost = 0;
        int toppingsNum = 0;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        //now, begin printing the receipt

        orderSummary.setText("========================================\n");

        //check pizzaSize and set appropriate base cost
        if (pizzaSize.getSelectedIndex() == 0) {
            basePizzaCost = 8.00;
            orderSummary.append("Small Pizza " + selectedCrust + "           " +
                    currencyFormatter.format(basePizzaCost) + "\n");
        }
        else if (pizzaSize.getSelectedIndex() == 1) {
            basePizzaCost = 12.00;
            orderSummary.append("Medium Pizza " + selectedCrust + "        " +
                    currencyFormatter.format(basePizzaCost) + "\n");
        }
        else if (pizzaSize.getSelectedIndex() == 2) {
            basePizzaCost = 16.00;
            orderSummary.append("Large Pizza " + selectedCrust + "        " +
                    currencyFormatter.format(basePizzaCost) + "\n");
        }
        else if (pizzaSize.getSelectedIndex() == 3) {
            basePizzaCost = 20.00;
            orderSummary.append("Super Pizza " + selectedCrust + "                    " +
                    currencyFormatter.format(basePizzaCost) + "\n");
        }
        else {
            basePizzaCost = 0;
            System.out.println("Invalid pizza selection, debug");
        }

        //check number of toppings, and print a receipt line of $1.00 for each

        if (pepperoni.isSelected()) {
            toppingsNum++;
            orderSummary.append("Pepperoni                                     $1.00\n");
        }
        if (extraCheese.isSelected()) {
            toppingsNum++;
            orderSummary.append("Extra Cheese                                $1.00\n");
        }
        if (sausage.isSelected()) {
            toppingsNum++;
            orderSummary.append("Sausage                                       $1.00\n");
        }
        if (bacon.isSelected()) {
            toppingsNum++;
            orderSummary.append("Bacon                                            $1.00\n");
        }
        if (ham.isSelected()) {
            toppingsNum++;
            orderSummary.append("Ham                                              $1.00\n");
        }
        if (beef.isSelected()) {
            toppingsNum++;
            orderSummary.append("Beef                                               $1.00\n");
        }
        if (phillySteak.isSelected()) {
            toppingsNum++;
            orderSummary.append("PhillySteak                                     $1.00\n");
        }
        if (pineapple.isSelected()) {
            toppingsNum++;
            orderSummary.append("Pineapple                                       $1.00\n");
        }

        orderSummary.append("\n\n");

        //Now, calculate the subtotal before adding tax
        subtotal = basePizzaCost + 1.00 * toppingsNum;
        salesTax = subtotal * salesTaxRate;
        finalTotal = subtotal + salesTax;

        orderSummary.append("Subtotal:                                            " + currencyFormatter.format(subtotal) + "\n");
        orderSummary.append("Tax:                                                   " + currencyFormatter.format(salesTax) + "\n");
        orderSummary.append("-------------------------------------------------------------------\n");
        orderSummary.append("Total:                                                " + currencyFormatter.format(finalTotal) + "\n");
        orderSummary.append("========================================");

    }

    private void clearSelections() {
        orderSummary.setText("");
        thinCrust.setSelected(false);
        regularCrust.setSelected(false);
        largeCrust.setSelected(false);
        deepCrust.setSelected(false);
        invisCrust.setSelected(true); //hack to make the radiobutton selection blank

        pizzaSize.setSelectedIndex(1);

        pepperoni.setSelected(false);
        extraCheese.setSelected(false);
        sausage.setSelected(false);
        bacon.setSelected(false);
        ham.setSelected(false);
        beef.setSelected(false);
        phillySteak.setSelected(false);
        pineapple.setSelected(false);
    }

    private void quitConfirm() {

        int quitYN = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to quit?",
                        "Quit Confirm", JOptionPane.YES_NO_OPTION);

        if (quitYN == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
