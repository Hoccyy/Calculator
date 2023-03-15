import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;//Imports for javafx stuff and formatting

public class Calculator extends Application {
    private TextField operandOne;
    private TextField operandTwo;//Both Operand boxes defined
    private TextField result;// Result box defined
    DecimalFormat df = new DecimalFormat("#.#");//Formatting for results

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");//Setting title of the window
        
        // Making The labels
        Label operOneLab = new Label("First Operand");
        Label operTwoLab = new Label("Second Operand");
        Label resultsLab = new Label("Result");

        //Setting the widths of the labels
        operOneLab.setPrefWidth(190);   operTwoLab.setPrefWidth(190);   resultsLab.setPrefWidth(190);

        //Set all to 0 on start
        operandTwo = new TextField("0");
        operandOne = new TextField("0");
        result = new TextField ("0");

        //making buttons 
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button clearButton = new Button("Clear");
        
        // making layout 
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));//separation sizes
        layout.setHgap(10);
        layout.setVgap(10);//Setting gaps
        //Adding each text field
        layout.addRow(0, operOneLab, operandOne);
        layout.addRow(1, operTwoLab, operandTwo);
        layout.addRow(2, resultsLab, result);
        
        
        // Box button layout initialization
        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(addButton, subtractButton, clearButton);//adds each button
        layout.add(buttonLayout,0, 5, 3, 1);
        
        // Create scene                  w x h
        Scene scene = new Scene(layout, 225, 170);
        
        //Addition
        addButton.setOnAction(addition -> {
            //Empty input handling
            if (operandOne.getText().length() == 0 || operandOne.getText() == " "){operandOne.setText("0");}
            if (operandTwo.getText().length() == 0 || operandTwo.getText() == " "){operandTwo.setText("0");}
            //Changes result box
            result.setText( String.valueOf(df.format((Double.parseDouble(operandOne.getText()) + Double.parseDouble(operandTwo.getText())) )));
        });
        //Subtraction
        subtractButton.setOnAction(subtraction -> {
            //Empty input handling
            if (operandOne.getText().length() == 0 || operandOne.getText() == " "){operandOne.setText("0");}
            if (operandTwo.getText().length() == 0 || operandTwo.getText() == " "){operandTwo.setText("0");}
            //Changes result box
            result.setText( String.valueOf(df.format((Double.parseDouble(operandOne.getText()) - Double.parseDouble(operandTwo.getText())) )));
        });
        //Resetting 
        clearButton.setOnAction(empty -> {
            //Turns each box to 0
            operandOne.setText("0");    operandTwo.setText("0");    result.setText("0");
        });
        
        // shows the window
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Launching
    public static void main(String[] args) {
        launch(args);
    }
}