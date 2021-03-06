package GUI;

import Mapping.Waypoint;
import Simulation.DataTransfer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShiftsPage extends BorderPane {

    private ListView<VBox> hoursList;
    private TextField shiftHoursEnt, numSimsEnt;
    private VBox entryContainer;
    private Text shiftHoursLabel, numSimsLabel;
    private StackPane hoursListContainer;

    public ShiftsPage() {

        super();

        // Right Side
        hoursListContainer = new StackPane();
        hoursList = new ListView<>();
        hoursList.setPrefWidth(550);
        hoursListContainer.getChildren().add(hoursList);

        // Left Side
        entryContainer = new VBox();
        shiftHoursLabel = new Text("Shift Hours");
        shiftHoursEnt = new TextField();
        numSimsLabel = new Text("Number of Simulations");
        numSimsEnt = new TextField();

        shiftHoursEnt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                try {
                    int i = Integer.parseInt(t1);
                    int j = Integer.parseInt(s);

                    reload(i, j);
                } catch (NumberFormatException e) {}
            }
        });

        entryContainer.getChildren().addAll(
                shiftHoursLabel,
                shiftHoursEnt,
                numSimsLabel,
                numSimsEnt);

        this.setRight(hoursListContainer);
        this.setLeft(entryContainer);

        initFromFile("");
    }

    // This long method is just for setting the sizing and layout of each element in the page
    // It is called on every screen resize
    public void refresh() {

        double pageWidth = Values.windowWidth * (1 - Values.sideMenuWidthPercent);
        double pageHeight = Values.windowHeight;

        hoursListContainer.setMaxWidth(pageWidth * Values.shiftsPageHoursListWidthPercent);
        hoursListContainer.setMaxHeight(pageHeight * Values.shiftsPageHourListHeightPercent);
        hoursList.setPrefWidth(pageWidth * Values.shiftsPageHoursListWidthPercent);
        hoursList.setPrefHeight(pageHeight * Values.shiftsPageHourListHeightPercent);
        BorderPane.setAlignment(hoursListContainer, Pos.CENTER_LEFT);

        entryContainer.setPrefWidth(pageWidth * Values.shiftsPageEntryContainerWidthPercent);
        entryContainer.setMaxHeight(pageHeight * Values.shiftsPageEntryContainerHeightPercent);
        BorderPane.setAlignment(entryContainer, Pos.CENTER_RIGHT);

        // Styles
        this.setStyle(Styles.shiftsPage);
        hoursListContainer.setStyle(Styles.shiftsPageHoursList);
        entryContainer.setStyle(Styles.shiftsPageEntryContainer);
    }

    // This method allows the data in the shifts page to all be live instead of updated only when a button is pushed
    public void reload(int newNumHours, int oldNumHours) {

        if (newNumHours < oldNumHours) {

            for (int i = newNumHours+1; i <= oldNumHours; ++i) {

                DataTransfer.removeShift(i);
            }
        } else if (newNumHours > oldNumHours) {

            for (int i = oldNumHours + 1; i <= newNumHours; ++i) {

                DataTransfer.addShift(i, 0);
            }
        }

        if (newNumHours < hoursList.getItems().size()) {

            int i = hoursList.getItems().size();
            while (i > newNumHours) {

                hoursList.getItems().remove(hoursList.getItems().size()-1);
                i--;
            }

        } else {

            for (int i = hoursList.getItems().size(); i < newNumHours; ++i) {

                VBox temp = new VBox();
                Text hourLabel = new Text("Hour " + (i+1));
                TextField hourNum = new TextField();
                hourNum.setPromptText("Number of orders in hour " + (i+1));
                if (DataTransfer.getShift(i+1) != null)
                    hourNum.setText(Integer.toString(DataTransfer.getShift(i+1)));
                temp.getChildren().addAll(hourLabel, hourNum);

                hourNum.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                        int shiftHour =
                                Integer.parseInt(((Text)((VBox)hourNum.getParent()).getChildren().get(0))
                                        .getText().replace("Hour ", "").strip());
                        System.out.println(shiftHour);
                        try {
                            int oldVal = Integer.parseInt(s);
                            int newVal = Integer.parseInt(t1);


                            DataTransfer.addShift(shiftHour, newVal);

                        } catch (NumberFormatException e) {
                            DataTransfer.addShift(shiftHour, 0);
                        }
                    }
                });

                hoursList.getItems().add(temp);
            }
        }
    }

    // Load settings for food page from a specified file or default file
    public void initFromFile(String filename) {

        try {

            FileInputStream fis = new FileInputStream(Values.defaultFileName);
            if(!filename.equals(""))
                fis = new FileInputStream(filename);

            Scanner fileIn = new Scanner(fis);
            if (!fileIn.hasNextLine()) { return; }
            String fileLine = fileIn.nextLine();

            // See defaults_universal.dd for how we layout stored data
            while (fileIn.hasNextLine() && !fileLine.equals("@Shifts")) { fileLine = fileIn.nextLine(); }
            if (!fileIn.hasNextLine()) { return; }

            fileLine = fileIn.nextLine();
            hoursList.getItems().clear();
            while (fileIn.hasNextLine()) {

                if (fileLine.strip().equals("@/Shifts")) { break; }

                if (fileLine.contains("*")) {

                    fileLine = fileLine.replace("*", "").strip();
                    int shiftNum = Integer.parseInt(fileLine.split("&")[0]);
                    int numOrders = Integer.parseInt(fileLine.split("&")[1]);

                    VBox temp = new VBox();
                    Text hourLabel = new Text("Hour " + shiftNum);
                    TextField hourNum = new TextField();
                    hourNum.setPromptText("Number of orders in hour " + shiftNum);
                    hourNum.setText(Integer.toString(numOrders));
                    temp.getChildren().addAll(hourLabel, hourNum);

                    hoursList.getItems().add(temp);

                    hourNum.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                            int shiftHour =
                                    Integer.parseInt(((Text)((VBox)hourNum.getParent()).getChildren().get(0))
                                            .getText().replace("Hour ", "").strip());
                            System.out.println(shiftHour);
                            try {
                                int oldVal = Integer.parseInt(s);
                                int newVal = Integer.parseInt(t1);


                                DataTransfer.addShift(shiftHour, newVal);

                            } catch (NumberFormatException e) {
                                DataTransfer.addShift(shiftHour, 0);
                            }
                        }
                    });

                    DataTransfer.addShift(shiftNum, numOrders);

                } else {

                    String numShifts = fileLine.strip().split("&")[0];
                    String numSims = fileLine.strip().split("&")[1];
                    shiftHoursEnt.setText(numShifts);
                    numSimsEnt.setText(numSims);

                    DataTransfer.setNumSimulations(Integer.parseInt(numSims));
                }

                fileLine = fileIn.nextLine();
            }
        } catch (FileNotFoundException e) {

            System.out.println("Problem With File");
            e.printStackTrace();
        }
    }

}
