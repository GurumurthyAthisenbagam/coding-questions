class Solution {
    public double calculateTax(int[][] brackets, int income) {

        double tax=0;
        double balance=income;
        double previousUpper=0;

        for(int i=0; i<brackets.length; i++) {
            double upper = brackets[i][0];
            System.out.println(upper);
            if (upper<=balance) {
                tax += calculateTaxByBracket(brackets[i][1], upper-previousUpper);
            } else {
                tax += calculateTaxByBracket(brackets[i][1], income- previousUpper);
                break;
            }
            previousUpper = upper;
        }

        return tax;
        
    }

    public double calculateTaxByBracket(double perc, double income) {
        double percent = perc/100;
        System.out.println("per: " +  percent+ "bal: " + income);
        
        double tax = income*percent;
        System.out.println("in: " +  tax);
        return tax;
    }
}
