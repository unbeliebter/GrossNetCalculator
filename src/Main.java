/*
 author: Sven Pradela
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static int taxclass;
    public static String grosssalary;
    public static String taxfreeAllowance;
    public static String birthdate;
    public static String addContribution;
    public static String state;
    public static String healthInsuranceStatus;
    public static boolean children;
    public static boolean churchTax;
    public static boolean pensionEnsuranceObligation;

    public static void main(String[] args) {
        JFrame welcomeFrame = new JFrame("Brutto-Netto-Rechner");
        JFrame calculatorFrame = new JFrame("Brutto-Netto-Rechner");

        welcomeFrame.setSize(350, 100);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setResizable(false);

        calculatorFrame.setSize(350, 470);
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setResizable(false);

        JPanel welcomePanel = new JPanel();
        JPanel calculatorPanel = new JPanel();

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Willkommen beim Brutto-Netto-Rechner");
        welcomePanel.add(welcomeLabel);

        JButton startButton = new JButton();
        startButton.setText("Jetzt berechnen");

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                welcomeFrame.setVisible(false);

                calculatorFrame.add(calculatorPanel);
                calculatorFrame.setVisible(true);
            }
        });

        welcomePanel.add(startButton);

        welcomeFrame.add(welcomePanel);
        welcomeFrame.setVisible(true);

        JLabel grossSalaryLabel = new JLabel("Bruttolohn: (Monatlich)");
        calculatorPanel.add(grossSalaryLabel);

        JTextField gorssSalaryTextField = new JTextField("", 30);
        calculatorPanel.add(gorssSalaryTextField);

        JLabel taxClassLabel = new JLabel("Steuerklasse: ");
        taxClassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatorPanel.add(taxClassLabel);

        String[] taxClasses = {"1", "2", "3", "4", "5", "6"};
        JComboBox<String> comboboxTaxClass = new JComboBox<String>(taxClasses);
        calculatorPanel.add(comboboxTaxClass);

        JLabel placeholder = new JLabel("                                                             ");
        calculatorPanel.add(placeholder);

        JLabel taxfreeAlowanceLabel = new JLabel("Steuerfreibetrag");
        calculatorPanel.add(taxfreeAlowanceLabel);

        JTextField taxfreeAlowanceTextField = new JTextField("", 30);
        calculatorPanel.add(taxfreeAlowanceTextField);

        JLabel stateLabel = new JLabel("Bundesland:");
        calculatorPanel.add(stateLabel);

        String[] optionStates = {"Bayern", "Baden-Württemberg", "Brandenburg", "Berlin", "Bremen", "Hamburg", "Thüringen", "Niedersachsen", "Nordrhein-Westfalen", "Niedersachsen", "Sachsen", "Saarland", "Schleswig-Holstein", "Mecklenburg-Vorpommern", "Hessen"};
        JComboBox<String> comboboxStates = new JComboBox<String>(optionStates);
        calculatorPanel.add(comboboxStates);

        JLabel placeholder2 = new JLabel("                    ");
        calculatorPanel.add(placeholder2);

        JLabel birthdateLabel = new JLabel("Geburtsjahr:");
        calculatorPanel.add(birthdateLabel);

        JTextField birthdateTextField = new JTextField("", 30);
        calculatorPanel.add(birthdateTextField);

        JLabel churchTaxLabel = new JLabel("Kirchensteuer:");
        calculatorPanel.add(churchTaxLabel);

        String[] optionYesNo = {"Ja", "Nein"};
        JComboBox<String> comboboxChruchSteuer = new JComboBox<String>(optionYesNo);
        calculatorPanel.add(comboboxChruchSteuer);

        JLabel placeholder3 = new JLabel("                                                          ");
        calculatorPanel.add(placeholder3);

        JLabel childrenLabel = new JLabel("Kinder:");
        calculatorPanel.add(childrenLabel);

        JComboBox<String> comboboxChildren = new JComboBox<String>(optionYesNo);
        calculatorPanel.add(comboboxChildren);

        JLabel placeholder4 = new JLabel("                                            ");
        calculatorPanel.add(placeholder4);

        JLabel socialInsuranceLabel = new JLabel("Angaben zur Sozialversicherung");
        socialInsuranceLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        calculatorPanel.add(socialInsuranceLabel);

        JLabel healthInsuranceLabel = new JLabel("Krankenversicherung");
        calculatorPanel.add(healthInsuranceLabel);

        String[] healthInsuranceOptions = {"Gesetzlich 14,6%", "Gesetzlich 14% (ermäßigt)", "Privat Versichert"};
        JComboBox<String> comboboxHealthInsurance = new JComboBox<String>(healthInsuranceOptions);
        calculatorPanel.add(comboboxHealthInsurance);

        JLabel addContributionLabel = new JLabel("Zusatzbeitrag");
        calculatorPanel.add(addContributionLabel);

        JTextField addContributionTextField = new JTextField("", 30);
        calculatorPanel.add(addContributionTextField);

        JLabel pensionEnsuranceObligationLabel = new JLabel("Rentenversicherungspflicht");
        calculatorPanel.add(pensionEnsuranceObligationLabel);

        JComboBox<String> comboboxPensionEnsurance = new JComboBox<String>(optionYesNo);
        calculatorPanel.add(comboboxPensionEnsurance);

        JLabel placeholder5 = new JLabel("                     ");
        calculatorPanel.add(placeholder5);

        JButton calculateButton = new JButton("Berechnen!");
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                grosssalary = gorssSalaryTextField.getText();
                taxfreeAllowance = taxfreeAlowanceTextField.getText();
                birthdate = birthdateTextField.getText();
                addContribution = addContributionTextField.getText();

                if (grosssalary == null || grosssalary.matches("[a-zA-Z]") || taxfreeAllowance == null || taxfreeAllowance.matches("[a-zA-Z]") || birthdate == null || birthdate.matches("[a-zA-Z]") || addContribution == null || addContribution.matches("[a-zA-Z]")) {
                    JFrame errorFrame = new JFrame("Brutto-Netto-Rechner");
                    errorFrame.setSize(300, 315);
                    errorFrame.setLocationRelativeTo(null);
                    errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    errorFrame.setResizable(false);

                    JPanel errorPanel = new JPanel();

                    JLabel errorLabel = new JLabel("Eine Eingabe enthält Buchstaben oder ist falsch!");
                    errorPanel.add(errorLabel);

                    JButton closeErrorButton = new JButton("Schließen");
                    closeErrorButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            errorFrame.setVisible(false);
                            calculatorFrame.setVisible(true);
                        }
                    });
                    errorPanel.add(closeErrorButton);
                    errorFrame.add(errorPanel);
                    errorFrame.setVisible(true);
                }

                Object childrenObject = comboboxChildren.getSelectedItem();
                children = check((String) childrenObject);

                Object pensionEnsuranceObligationObject = comboboxPensionEnsurance.getSelectedItem();
                pensionEnsuranceObligation = check((String) pensionEnsuranceObligationObject);

                Object churchTaxObject = comboboxChruchSteuer.getSelectedItem();
                churchTax = check((String) churchTaxObject);

                state = (String) comboboxStates.getSelectedItem();

                taxclass = Integer.parseInt((String) comboboxTaxClass.getSelectedItem());

                healthInsuranceStatus = (String) comboboxHealthInsurance.getSelectedItem();

                calculatorFrame.setVisible(false);

                JFrame resultFrame = new JFrame("Brutto-Netto-Rechner");
                resultFrame.setSize(300, 315);
                resultFrame.setLocationRelativeTo(null);
                resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                resultFrame.setResizable(false);

                JPanel panel = new JPanel();

                JTextArea resultText = new JTextArea();
                resultText.setEditable(false);
                resultText.setText("Brutoeinkommen: " + grosssalary + "€ \n" +
                        "-----------------------------------------------------------" + "\n" +
                        "<-- Sozialausgaben -->" + "\n" +
                        "Krankenversicherung: " + NettoCalculator.healthEnsurance() + "€ \n" +
                        "Rentenversicherung: " + NettoCalculator.pensionContribution() + "€ \n" +
                        "Arbeitslosenversicherung: " + NettoCalculator.unemploymentEnsurance() + "€ \n" +
                        "Pflegeversicherung: " + NettoCalculator.careInsurance() + "€ \n" +
                        "-----------------------------------------------------------" + "\n" +
                        "<-- Steuerliche Abzüge -->" + "\n" +
                        "Lohnsteuer: " + NettoCalculator.incomeTax() + "€ \n" +
                        "Kirchensteuer: " + NettoCalculator.churchTax() + "€ \n" +
                        "Solidaritätszuschlag: " + NettoCalculator.solidarityTax() + "€ \n" +
                        "-----------------------------------------------------------" + "\n" +
                        "Netto: " + NettoCalculator.net() + "€");

                panel.add(resultText);

                JButton closeButton = new JButton("Schließen");
                panel.add(closeButton);
                closeButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        resultFrame.setVisible(false);
                    }
                });

                resultFrame.add(panel);
                resultFrame.setVisible(true);

            }
        });
        calculatorPanel.add(calculateButton);
    }

    public static boolean check(String yesNoString) {
        return yesNoString.contains("Ja");
    }

}
