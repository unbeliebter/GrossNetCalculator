/*
 author: Sven Pradela
 */

public class NettoCalculator extends Main {

    public static double salary = Double.parseDouble(grosssalary);
    public static double taxfreeAllowance = Double.parseDouble(Main.taxfreeAllowance);

    NettoCalculator() {
    }

    public static double pensionContribution() {
        return Math.round(((salary / 100) * 9) * 100) / 100.0;
    }

    public static double healthEnsurance() {
        if (healthInsuranceStatus.equals("Gesetzlich 14,6%")) {
            return Math.round(((salary / 100) * 14.6) * 100) / 100.0;

        } else if (healthInsuranceStatus.equals("Gesetzlich 14% (ermäßigt)")) {
            return Math.round(((salary / 100) * 14) * 100) / 100.0;

        } else if (healthInsuranceStatus.equals("Privat Versichert")) {
            return Math.round(((salary / 100) * 15.6) * 100) / 100.0;
        }
        return 0;
    }

    public static double unemploymentEnsurance() {
        return Math.round(((salary / 100) * 1.1) * 100) / 100.0;
    }

    public static double careInsurance() {
        return Math.round(((salary / 100) * 1.5) * 100) / 100.0;
    }

    public static double churchTax() {

        if (churchTax == false) {
            return 0;
        } else if (state.equals("Baden-Württemberg") || state.equals("Bayern")) {
            return Math.round(((salary / 100) * 8) * 100) / 100.0;

        } else {
            return Math.round(((salary / 100) * 9) * 100) / 100.0;
        }
    }

    public static double solidarityTax() {
        if ((taxclass == 1 || taxclass == 2) && salary > 6250) {
            return Math.round(((salary / 100) * 5.5) * 100) / 100.0;

        } else if (taxclass == 3 && (Integer.parseInt(grosssalary)) > 11.333) {
            return Math.round(((salary / 100) * 5.5) * 100) / 100.0;

        } else {
            return 0;
        }
    }

    public static double incomeTax() {
        if (taxclass == 1) {
            return Math.round(((((salary - (taxfreeAllowance / 12)) / 100) * 17.14) * 100) / 100.0);

        } else if (taxclass == 2 && taxclass == 3) {
            return Math.round(((((salary - (taxfreeAllowance / 12)) / 100) * 4.2) * 100) / 100.0);

        } else if (taxclass == 4 && taxclass == 5) {
            return Math.round(((((salary - (taxfreeAllowance / 12)) / 100) * 14) * 100) / 100.0);

        } else if (taxclass == 6) {
            return 450;
        }
        return 0;
    }

    public static double net() {
        double result;
        result = +pensionContribution() + healthEnsurance() + unemploymentEnsurance() + careInsurance() + churchTax() + solidarityTax() + incomeTax();
        return Integer.parseInt(grosssalary) - result;
    }
}
