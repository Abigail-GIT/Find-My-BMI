public class BMICalculator {

    //Calculations using user's height and weight
    public double calculateBMI(User user) {
        return (user.getWeight() * 703) / (user.getHeight() * user.getHeight());
    }

    //Defining each Conditional
    public String getBMICategory(double bmi) {     
        //Underweight   
        if (bmi < 18.5) {
            return "Underweight";
        }
        //Normal
        else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        }
        //Overweight
        else if (bmi>=24.9 && bmi < 30){
            return "Overweight";
        }
        //Obese
        else {
            return "Obese";
        }
    }
 }