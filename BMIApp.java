import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.paint.Color;


public class BMIApp extends Application {
    private TextField heightField;
    private TextField weightField;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }
    @Override 
    public void start(Stage primaryStage) {
        createUI(primaryStage);
    }

    //Creating GUI
    public void createUI(Stage stage) {

        //Define HEIGHT LABEL

        Text wordHeight = new Text("Height");
        wordHeight.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        wordHeight.setFill(Color.STEELBLUE);

        Text prefixHeight = new Text("Enter ");
        prefixHeight.setFont(Font.font("Arial", 16));

        Text suffixHeight = new Text(" (inches):");
        suffixHeight.setFont(Font.font("Arial", 16));

        TextFlow textFlowHeight = new TextFlow(prefixHeight, wordHeight, suffixHeight);
    
        Label heightLabel = new Label();
        heightLabel.setGraphic(textFlowHeight);

        
        //Define WEIGHT LABEL 

        Text wordWeight = new Text("Weight");
        wordWeight.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        wordWeight.setFill(Color.STEELBLUE);

        Text prefixWeight = new Text("Enter ");
        prefixWeight.setFont(Font.font("Arial", 16));

        Text suffixWeight = new Text(" (pounds):");
        suffixWeight.setFont(Font.font("Arial", 16));

        TextFlow textFlowWeight = new TextFlow(prefixWeight, wordWeight, suffixWeight);

        Label weightLabel = new Label();
        weightLabel.setGraphic(textFlowWeight);
        

        //Define Height and Weight Fields for User input

        heightField = new TextField();
        heightField.setPrefWidth(150);
        heightField.setStyle("-fx-alignment: center;");

        HBox heightBox = new HBox(heightField);
        heightBox.setAlignment(Pos.CENTER);

        weightField = new TextField();
        weightField.setPrefWidth(150);
        weightField.setStyle("-fx-alignment: center;");

        HBox weightBox = new HBox(weightField);
        weightBox.setAlignment(Pos.CENTER);


        //Calculate BMI (Button)

        Button calculateButton = new Button("Calculate BMI");
        resultLabel = new Label();
        resultLabel.setFont(Font.font("Arial", 16));

        calculateButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        calculateButton.setTextFill(Color.STEELBLUE);
        calculateButton.setOnAction(e -> handleCalculate());

        //Button to switch to a new Stage (Learn More)

        Button learnMoreBtn = new Button("Learn More");
        learnMoreBtn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        learnMoreBtn.setTextFill(Color.STEELBLUE);


        //Layout for Main Stage 1 (Calculator)

        Text title = new Text("Find My BMI");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setFill(Color.STEELBLUE);


        //Layout for user input fields

        VBox layout = new VBox(10);
        VBox.setMargin(title, new Insets(0, 0, 30, 0));
        VBox.setMargin(heightLabel, new Insets(0, 0, 0, 0));
        VBox.setMargin(weightBox, new Insets(0, 0, 30, 0));
        VBox.setMargin(calculateButton, new Insets(0, 0, 0, 0));
        VBox.setMargin(resultLabel, new Insets(0, 0, 15, 0));
        VBox.setMargin(learnMoreBtn, new Insets(-55, 0, 55, 400));


        layout.getChildren().add(title);
        layout.getChildren().addAll(heightLabel, heightBox, weightLabel, weightBox, calculateButton, resultLabel, learnMoreBtn);
        layout.setAlignment(Pos.BOTTOM_CENTER);


        //Main stage layout (BACKGROUND)
        
        Scene scene = new Scene(layout, 600, 400);
        stage.setTitle("BMI Calculator");
        layout.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(227, 242, 255),rgb(189, 210, 255));");
        stage.setScene(scene);
        stage.show();


        //Creating a second Stage with a back button 

        learnMoreBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Stage stage2 = new Stage();
                GridPane pane2 = new GridPane();
                pane2.setAlignment(Pos.CENTER);
                pane2.setPadding(new Insets(20));
                

                //Back Button to back to Stage 1

                Button backBtn1 = new Button("Go Back");
                backBtn1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                backBtn1.setTextFill(Color.STEELBLUE);
                pane2.getChildren().add(backBtn1);
                backBtn1.setOnAction(e -> stage2.close());
                

                //Title: What Is BMI?

                Text whatIsBMI = new Text("What Is BMI?");
                whatIsBMI.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                whatIsBMI.setFill(Color.ROYALBLUE);
                

                //Body Text: What Is BMI? + Categories

                Text bmiInformation = new Text("BMI, also known as Body Mass Index, is the measure of weight relative to height."
                + "\n" + "BMI is a strong indicator as to whether or not an individual has a healthy body"
                + "\n" + "weight, considering the individual is at least 18 years of age. As demonstrated by the"
                + "\n" + "calculator, BMI can be divided into four categories, regardless of gender."
                + "\n" + " " 
                + "\n" + "BMI  of less than 18.5 : Underweight"
                + "\n" + "BMI of 18.5-24.9 : Normal"
                + "\n" + "BMI of 24.9-30 : Overweight"
                + "\n" + "BMI of greater than 30 : Obese");
                bmiInformation.setFont(Font.font("Arial", FontWeight.BOLD, 14.5));
                bmiInformation.setFill(Color.STEELBLUE);

                
                //Title: Why Is It Important?

                Text whyImportant = new Text("Why Is It Important?");
                whyImportant.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                whyImportant.setFill(Color.ROYALBLUE);


                //Body Text: What Is BMI? + Categories

                Text ImportanceText = new Text("When an individual is aware of their BMI, they can assess what category they fall" 
                + "\n" + "under, and decide whether or not they would benefit from gaining weight, losing"
                + "\n" + "weight, or maintaning their current weight. This information will help with"
                + "\n" + "maximizing one's health, and decreasing the risks of medical problems such as"
                + "\n" + "cardiovascular disease and hypertension.");
                ImportanceText.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                ImportanceText.setFill(Color.STEELBLUE);


                //Button to switch to Stage 3 (Managing BMI)

                Button manageBMIBtn = new Button("Managing BMI");
                manageBMIBtn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                manageBMIBtn.setTextFill(Color.STEELBLUE);


                manageBMIBtn.setOnAction(ActionEvent -> {
                    Stage stage3 = new Stage();
                

                    // Title: Managing BMI

                    Text manageBmiTitle = new Text("Managing BMI");
                    manageBmiTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    manageBmiTitle.setFill(Color.ROYALBLUE);


                    //Back button to return to stage 2 (Learn More)

                    Button backBtn2 = new Button("Go Back");
                    backBtn2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                    backBtn2.setTextFill(Color.STEELBLUE);
                    backBtn2.setOnAction(ActionEvente -> stage3.close());
                

                    // Body text: Managing BMI

                    Text manageBmiInformation = new Text("The first steps towards achieving a healthy BMI involves healthy eating habits and"
                        + "\n" + "an active lifestyle. This involves:"
                        + "\n" + " "
                        + "\n" + "- Eating a well-balanced diet consisting of fruits, vegetables, whole grains,"
                        + "\n" + "  and healthy protein."
                        + "\n" + "- Getting a minimum of 150 minutes of cardiovascular exercise per week."
                        + "\n" + "- Striving for at least seven hours of sleep per night."
                        + "\n" + "- Drinking plenty of water, ideally four to six cups per day."
                        + "\n" + "- Limiting cholesterol and sugar intake.");
                    manageBmiInformation.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                    manageBmiInformation.setFill(Color.STEELBLUE);
                

                    //Disclaimer Text : Title

                    Text disclaimer = new Text("Interested In Learning More?");
                    disclaimer.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    disclaimer.setFill(Color.ROYALBLUE);

                    
                    //Discaimer Body Text 

                    Text disclaimerText = new Text("To find out what steps will best fit your needs," 
                    + "\n" + "   contact your personal healthcare provider.");
                    disclaimerText.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                    disclaimerText.setFill(Color.STEELBLUE);

                    //Third Stage Layout : "Managing BMI"

                    VBox layout3 = new VBox(10);
                    layout3.setAlignment(Pos.CENTER);
                    VBox.setMargin(backBtn2, new Insets(20, 0, 0, 0));
                
                    layout3.getChildren().addAll(manageBmiTitle, manageBmiInformation, disclaimer, disclaimerText, backBtn2);
                    layout3.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(227, 242, 255),rgb(189, 210, 255));");
                
                    Scene scene3 = new Scene(layout3, 600, 400);
                    stage3.setTitle("Managing BMI");
                    stage3.setScene(scene3);
                    stage3.show();
                });
                
                //Second Stage Layout : "Learn More"

                VBox layout2 = new VBox(10);
                VBox.setMargin(backBtn1, new Insets(10, 0, 5, 0));
                VBox.setMargin(manageBMIBtn, new Insets(-10, 0, 10, 0));
                layout2.setAlignment(Pos.BOTTOM_CENTER);

                Scene scene2 = new Scene(layout2, 600, 400);
                stage2.setTitle("What About My BMI?");
                layout2.getChildren().addAll(whatIsBMI, bmiInformation, whyImportant, ImportanceText, backBtn1, manageBMIBtn);
                layout2.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(227, 242, 255),rgb(189, 210, 255));");
                stage2.setScene(scene2);
                stage2.show();
            }
        }); 
    }
    private void handleCalculate() {

        //Validating User Input

        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            User user = new User(height, weight);
            BMICalculator calculator = new BMICalculator();
            double bmi = calculator.calculateBMI(user);
            String category = calculator.getBMICategory(bmi);

            displayResults(bmi, category);
        }
        catch (NumberFormatException e) {
            resultLabel.setText("Please enter your height and weight.");
        }
    }

    //Display User Results

    public void displayResults(double bmi, String category) {
        String bmiLabel = getBMILabel(bmi);
        String categoryLabel = getCategoryLabel(category);

        resultLabel.setText(bmiLabel + "\n" + categoryLabel);
    }
    public String getBMILabel(double bmi) {
        return "BMI: " + String.format("%.2f", bmi);
    }
    public String getCategoryLabel(String category) {
        return "Category: " + category;
    }
}