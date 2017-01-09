package gui;

import controller.JaviairController;
import helpers.Consts;
import helpers.UtilityClass;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;
import persistors.DBPersistor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class MainScene extends Application {

    private ArrayList<TextField> firstNameArrayList;
    private TextField[] firstNameArray = new TextField[Consts.MAX_PASSENGER_NO];
    private TextField[] lastNameArray = new TextField[Consts.MAX_PASSENGER_NO];
    private TextField[] numberDNIArray = new TextField[Consts.MAX_PASSENGER_NO];
    private DatePicker[] dateOfBirthArray = new DatePicker[Consts.MAX_PASSENGER_NO];
    private RadioButton[] radioBtnArray = new RadioButton[Consts.MAX_PASSENGER_NO];
    private CheckBox[] checkboxArraySpanish = new CheckBox[Consts.MAX_PASSENGER_NO];



    private static final ObservableList airportList = FXCollections.observableArrayList();
    private VBox vBoxRadioBtns1, vBoxRadioBtns2;
    private String mFlightTimes, flightTime1, flightTime2, selectedDeptTime, selectedReturnTime;
    private final ToggleGroup toggleGroupFlights = new ToggleGroup();
    private final ToggleGroup toggleGroupFlightTimes_1 = new ToggleGroup();
    private final ToggleGroup toggleGroupFlightTimes_2 = new ToggleGroup();
    ObservableList<Integer> spinnerObservableList = FXCollections.observableArrayList();
    private ImageView imageViewReturn, imageViewDept;
    private Button buttonCancel, buttonContinue, buttonPurchase;
    private ComboBox<String> comboOrigin;
    private ComboBox<String> comboDestination;
    private DatePicker datePickerDeparture;
    private DatePicker datePickerReturn;
    private GridPane gridPaneMiddle;
    private Label labelOrigin, labelDestination, labelDateDeparture, labelDateReturn;
    private ListView listView;
    private RadioButton radioButtonReturn, radioButtonOneWay, radioButtonDeptTime1, radioButtonDeptTime2, radioButtonReturnTime1, radioButtonReturnTime2;
    public String dptFlight, rtnFlight, flightTime_1, flightTime_2;
    private double dateDepartPrice;
    private double dateReturnPrice;
    private double flightPrice;
    private double currentPrice;
    private double bagPrice = 0;
    private double spanishRebate = 0;
    double price = 0;
    private LocalDate ldDepartDate, ldReturnDate, dateDept, dateReturn;
    private GridPane gridPaneLeft;
    private Stage window;
    private Scene scene1, scene2;
    private VBox nextSceneVBox;
    private ObservableList<TextField> tfFirstNamesList = FXCollections.observableArrayList();
    private ObservableList<TextField> tfLastNamesList = FXCollections.observableArrayList();
    private ObservableList<TextField> numberDNIList = FXCollections.observableArrayList();
    private ObservableList<DatePicker> dpDateOfBirthList = FXCollections.observableArrayList();
    private ObservableList<RadioButton> radioBtnBagList = FXCollections.observableArrayList();
    private ObservableList<CheckBox> checkboxListSpanish = FXCollections.observableArrayList();
    protected TextField tfCCName,tfCCAddress1, tfCCAddress2, tfCCAddress3, tfCCType, tfCCNumber, tfCCVNumber;
    private DatePicker dpCCExpiryDate;
    private Spinner<Integer> spinnerPassengerNo;
    private List<Passenger> passengerList = FXCollections.observableArrayList();
    private Passenger passenger;
    private Flight flight, flightForChild, flightForBaby;
    private CreditCard creditCard;
    private FlightTimes flightTimes;
    private InfantFlight infantFlight;
    private ChildFlight childFlight;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {




        JaviairController.getInstance().setPersistor(new DBPersistor());

        window = primaryStage;

        // add Constants to the ObservableList
        airportList.addAll(Consts.CORK, Consts.MADRID, Consts.ST_BRIEUC, Consts.JERSEY, Consts.PARIS, Consts.STANSTED, Consts.MALAGA);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                createTopGridPane(), createMiddleGridPane(), createBottomPane(), createAnchorPane());
        scene1 = new Scene(vBox, 800, 825);

        listView = new ListView();

        this.nextSceneVBox = new VBox();
        scene2 = new Scene(this.nextSceneVBox, 700, 700);

        scene1.getStylesheets().add("/stylesheet.css");
        primaryStage.setScene(scene1);
        primaryStage.setTitle("JaviAir App");
        primaryStage.show();
    }

    private GridPane nextSceneCreditCardContainer() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(30);
        gridPane.getColumnConstraints().addAll(column1, column2); // each get 30% of width

        gridPane.setHgap(20);
        gridPane.setVgap(20);

        tfCCName = new TextField();
        tfCCName.setPromptText("Name");
        tfCCAddress1 = new TextField();
        tfCCAddress1.setPromptText("Address Line 1");
        tfCCAddress2 = new TextField();
        tfCCAddress2.setPromptText("City/Town");
        tfCCAddress3 = new TextField();
        tfCCAddress3.setPromptText("County");

        tfCCType = new TextField();
        tfCCType.setPromptText("Card Type");
        tfCCNumber = new TextField();
        tfCCNumber.setPromptText("Card Number");
        dpCCExpiryDate = new DatePicker();
        dpCCExpiryDate.setPromptText("Expiry Date");
        tfCCVNumber = new TextField();
        tfCCVNumber.setPromptText("CCV Number");

        buttonPurchase = new Button("Purchase Now");
        buttonPurchase.setOnAction(event -> {
            createCreditCard();
            addFlightDetailsToDatabase();
            addPassengerDetailsToDatabase();
            addCreditCardDetailsToDatabase();
            getTableViewFlight();
            getTableViewPassenger();
        });

        gridPane.add(tfCCName, 0, 1);
        gridPane.add(tfCCAddress1, 0, 2);
        gridPane.add(tfCCAddress2, 0, 3);
        gridPane.add(tfCCAddress3, 0, 4);

        gridPane.add(tfCCType, 1, 1);
        gridPane.add(tfCCNumber, 1, 2);
        gridPane.add(dpCCExpiryDate, 1, 3);
        gridPane.add(tfCCVNumber, 1, 4);

        gridPane.add(buttonPurchase, 0, 6, 3, 3);
        GridPane.setMargin(buttonPurchase, new Insets(0, 0, 0, 155));


        return gridPane;
    }


    private void createCreditCard() {
        String cardNum = tfCCNumber.getText();

        creditCard = new CreditCard(
                tfCCName.getText(),
                tfCCAddress1.getText(),
                tfCCAddress2.getText(),
                tfCCAddress3.getText(),
                tfCCType.getText(),
                tfCCNumber.getText(),
                dpCCExpiryDate.getValue(),
                tfCCVNumber.getText());

        if(!cardNum.isEmpty() && creditCard.validateCreditCardNumber(cardNum)) {
            UtilityClass.orderReceived();
        } else {
            UtilityClass.errorMessageCreditCardNumber();
        }
    }

    private GridPane createTopGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getStyleClass().add("grid");

        radioButtonOneWay = new RadioButton("One Way");
        radioButtonOneWay.setToggleGroup(toggleGroupFlights);
        radioButtonReturn = new RadioButton("Return");
        radioButtonReturn.setToggleGroup(toggleGroupFlights);
        radioButtonReturn.fire(); // return btn on by default


        toggleGroupFlights.selectedToggleProperty().addListener(observable -> {
            if (toggleGroupFlights.getSelectedToggle() == radioButtonOneWay) {
                datePickerReturn.setDisable(true);
                imageViewReturn.setVisible(false);
                radioButtonReturnTime1.setVisible(false);
                radioButtonReturnTime2.setVisible(false);
                radioButtonReturnTime1.setManaged(false);
                radioButtonReturnTime2.setManaged(false);

            } else if (toggleGroupFlights.getSelectedToggle() == radioButtonReturn) {
                datePickerReturn.setDisable(false);
                imageViewReturn.setVisible(true);
                radioButtonReturnTime1.setVisible(true);
                radioButtonReturnTime2.setVisible(true);
                radioButtonReturnTime1.setManaged(true);
                radioButtonReturnTime2.setManaged(true);

            }
        });

        radioButtonDeptTime1 = new RadioButton();
        radioButtonDeptTime2 = new RadioButton();
        radioButtonReturnTime1 = new RadioButton();
        radioButtonReturnTime2 = new RadioButton();

        vBoxRadioBtns1 = new VBox(20);
        vBoxRadioBtns1.getChildren().addAll(radioButtonDeptTime1, radioButtonDeptTime2);
        vBoxRadioBtns1.setMinWidth(200);
        vBoxRadioBtns1.setMinHeight(75);
        vBoxRadioBtns1.setMinHeight(75);

        vBoxRadioBtns2 = new VBox(20);
        vBoxRadioBtns2.getChildren().addAll(radioButtonReturnTime1, radioButtonReturnTime2);
        vBoxRadioBtns2.setMinWidth(200);
        vBoxRadioBtns2.setMinHeight(75);

        labelOrigin = new Label("From: ");
        comboOrigin = new ComboBox<>();
        comboOrigin.setEditable(true);
        comboOrigin.setPromptText("select airport");
        comboOrigin.getItems().addAll(airportList);

        comboOrigin.getStyleClass().add("comboOrigin"); // add css class
        comboOrigin.setOnAction(event -> {

            // Need to enforce a new date selection, when user changes the airport
            datePickerDeparture.getEditor().clear();
            datePickerReturn.getEditor().clear();
            datePickerDeparture.setValue(null);
            datePickerReturn.setValue(null);


            if (comboOrigin.getItems().contains(comboOrigin.getValue())) {
                disableFlights();
                getSelectedFlightPrice();
            } else {
                UtilityClass.errorMessageInput();
            }
        });

        labelDestination = new Label("To: ");
        comboDestination = new ComboBox<>();
        comboDestination.setPromptText("select airport");
        comboDestination.setEditable(true);
        comboDestination.setOnAction(event -> {

            // Need to enforce a new date selection, when user changes the airport
            datePickerDeparture.getEditor().clear();
            datePickerReturn.getEditor().clear();
            datePickerDeparture.setValue(null);
            datePickerReturn.setValue(null);
            toggleGroupFlightTimes_1.selectToggle(null);
            toggleGroupFlightTimes_2.selectToggle(null);

            if (comboDestination.getItems().contains(comboDestination.getValue())) {
                getSelectedFlightPrice();
            }
        });

        labelDateDeparture = new Label("Depart");
        datePickerDeparture = new DatePicker();
        datePickerDeparture.setPromptText("pick a date");
        datePickerDeparture.setEditable(true);
        datePickerDeparture.setOnAction(event -> {
            event.consume();
            checkForInvalidDates();
            getSelectDate(event);

        });

        labelDateReturn = new Label("Return");
        datePickerReturn = new DatePicker();
        datePickerReturn.setPromptText("pick a date");
        datePickerReturn.setEditable(true);
        datePickerReturn.setOnAction(event -> {
            event.consume();
            checkForInvalidDates();
            getSelectDate(event);


        });

        Button btnFlightSelect = new Button("Select Flight");
        btnFlightSelect.setOnAction(event -> {
            if (comboDestination.getSelectionModel().isEmpty()) {
                UtilityClass.errorMessageFlight();
            }
            displaySelectedFlights();


        });

        comboOrigin.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3) {
                comboDestination.setId("error");
            } else {
                comboDestination.setId("default");
            }
        });

        comboDestination.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3) {
                comboOrigin.setId("error");
            } else {
                comboOrigin.setId("default");
            }
        });

        gridPane.add(radioButtonOneWay, 0, 1);
        gridPane.add(radioButtonReturn, 2, 1);
        gridPane.add(labelOrigin, 0, 2);
        gridPane.add(labelDestination, 2, 2);
        gridPane.add(comboOrigin, 0, 3);
        gridPane.add(UtilityClass.insertIcon(), 1, 3);
        gridPane.add(comboDestination, 2, 3);
        gridPane.add(labelDateDeparture, 0, 4);
        gridPane.add(labelDateReturn, 2, 4);
        gridPane.add(datePickerDeparture, 0, 5);
        gridPane.add(UtilityClass.insertIcon(), 1, 5);
        gridPane.add(datePickerReturn, 2, 5);
        gridPane.add(btnFlightSelect, 1, 7);

        // gridPane.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        gridPane.add(new Separator(), 0, 8, 3, 1);

        return gridPane;
    }

    private void disableFlights() {
        String dptFlight = comboOrigin.getSelectionModel().getSelectedItem();

        switch (dptFlight) {
            case Consts.CORK:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.MADRID, Consts.ST_BRIEUC, Consts.JERSEY, Consts.PARIS, Consts.STANSTED, Consts.MALAGA);
                break;
            case Consts.MADRID:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.CORK, Consts.ST_BRIEUC, Consts.JERSEY, Consts.PARIS, Consts.STANSTED, Consts.MALAGA);
                break;
            case Consts.PARIS:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.CORK, Consts.MADRID, Consts.ST_BRIEUC, Consts.JERSEY, Consts.STANSTED, Consts.MALAGA);
                break;
            case Consts.STANSTED:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.CORK, Consts.MADRID, Consts.ST_BRIEUC, Consts.JERSEY, Consts.PARIS, Consts.MALAGA);
                break;
            case Consts.MALAGA:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.CORK, Consts.MADRID, Consts.ST_BRIEUC, Consts.JERSEY, Consts.PARIS, Consts.STANSTED);
                break;
            case Consts.ST_BRIEUC:
            case Consts.JERSEY:
                comboDestination.getItems().clear();
                comboDestination.getItems().addAll(Consts.CORK, Consts.MADRID, Consts.PARIS, Consts.STANSTED, Consts.MALAGA);
                break;
        }

    }



    // Disable March and/or April in the DatePicker
    // JavaFX DatePicker Tutorial website: http://o7planning.org/en/11085/javafx-datepicker-tutorial#a3667895g
    private Callback<DatePicker, DateCell> getMonthCellFactory() {

        final Callback<DatePicker, DateCell> monthCellFactory = new Callback<DatePicker, DateCell>() {

            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        LocalDate currentDate = LocalDate.now();
                        LocalDate nowPlusSixMonths = currentDate.plusMonths(6);

                        if (item.isBefore(currentDate) || item.isAfter(nowPlusSixMonths)) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }

                        if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.ST_BRIEUC)) {
                            // Disable March and April
                            if (item.getMonth().equals(Month.APRIL) || item.getMonth().equals(Month.MARCH)) {
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.STANSTED) || dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.PARIS)) {
                            // Disable April
                            if (item.getMonth().equals(Month.APRIL)) {
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                        }
                    }
                };
            }
        };
        return monthCellFactory;
    }

    // take the returned 'flightSelection' from getSelectedFlight() and add 20% if day is Fri - Sun
    private Double getSelectDate(ActionEvent event) {
        ldDepartDate = datePickerDeparture.getValue();
        ldReturnDate = datePickerReturn.getValue();

        if (event.getSource().equals(datePickerDeparture)) {

            if (ldDepartDate != null) {
                String dayOfWeekDpt = ldDepartDate.getDayOfWeek().name();

                // flight refers to the Flight object
                if (flight.isWeekend(dayOfWeekDpt)) {
                    dateDepartPrice = flight.calculateWeekendFlightPrice(flightPrice, flightPrice);
                } else {
                    dateDepartPrice = flightPrice;
                }

            }
        } else if (event.getSource().equals(datePickerReturn)) {

            if (ldReturnDate != null) {
                String dayOfWeekRtn = ldReturnDate.getDayOfWeek().name();
                if (flight.isWeekend(dayOfWeekRtn)) {
                    dateReturnPrice = flight.calculateWeekendFlightPrice(flightPrice, flightPrice);
                } else {
                    dateReturnPrice = flightPrice;
                }
            }
        }

        currentPrice = flight.calculateDepartPlusReturnPrice(dateDepartPrice, dateReturnPrice);

        return currentPrice;
    }


    private void checkForInvalidDates() {
        LocalDate departDate = datePickerDeparture.getValue();
        LocalDate returnDate = datePickerReturn.getValue();

        flight = new AdultFlight();

        if(flight != null) {
            if (!flight.isDateValid(departDate, returnDate)) {
                datePickerReturn.getEditor().setText(null);
                UtilityClass.errorMessageDatesNotPossible();
            }
        }

    }


    private Double getSelectedFlightPrice() {
        dptFlight = comboOrigin.getSelectionModel().getSelectedItem();
        rtnFlight = comboDestination.getSelectionModel().getSelectedItem();

        Flight f = new AdultFlight();
        flightPrice = f.flightSelection(dptFlight, rtnFlight);

        // Disable March and/or April in the DatePicker.
        // Also disable date before current time and after 6 months from now.
        // JavaFX DatePicker Tutorial website: http://o7planning.org/en/11085/javafx-datepicker-tutorial#a3667895
        Callback<DatePicker, DateCell> monthCellFactory = this.getMonthCellFactory();
        datePickerDeparture.setDayCellFactory(monthCellFactory);
        datePickerReturn.setDayCellFactory(monthCellFactory);

        return this.flightPrice;
    }


    private FlightTimes displaySelectedFlights() {
        dateDept = datePickerDeparture.getValue();
        dateReturn = datePickerReturn.getValue();
        dptFlight = comboOrigin.getSelectionModel().getSelectedItem();
        rtnFlight = comboDestination.getSelectionModel().getSelectedItem();

        if (dptFlight == null) {
            UtilityClass.errorMessageFlight();

        } else if (dateDept == null || dateReturn == null && radioButtonReturn.isSelected()) {
            UtilityClass.errorMessageDate();

        } else {
            setFlightPriceAdult();

            FlightTimes f = new FlightTimes();
            flightTimes = f.getFlightTimes(dptFlight, rtnFlight);

            displayFlightDetails();
        }

        return new FlightTimes(flightTime1, flightTime2);
    }


    private void displayFlightDetails() {

        flightTime_1 = flightTimes.getFlightTimeDepart();
        flightTime_2 = flightTimes.getFlightTimeReturn();

        radioButtonDeptTime1.setText(flight.displayDeptDetails() + "\n" + flightTime_1);
        radioButtonReturnTime1.setText(flight.displayReturnDetails() + "\n" + flightTime_1);

        radioButtonDeptTime1.setToggleGroup(toggleGroupFlightTimes_1);
        radioButtonDeptTime2.setToggleGroup(toggleGroupFlightTimes_1);

        toggleGroupFlightTimes_1.selectedToggleProperty().addListener(observable -> {

            if (toggleGroupFlightTimes_1.getSelectedToggle() == radioButtonDeptTime1) {
                selectedDeptTime = flightTime_1;

            } else if (toggleGroupFlightTimes_1.getSelectedToggle() == radioButtonDeptTime2) {
                selectedDeptTime = flightTime_2;
            }

        });

        // model.Flight has two time slots
        if (flightTime_2 != null) {

            radioButtonDeptTime2.setText(flight.displayDeptDetails() + "\n" + flightTime_2);
            radioButtonReturnTime2.setText(flight.displayReturnDetails() + "\n" + flightTime_2);
            radioButtonDeptTime2.setVisible(true);

            if(radioButtonReturn.isSelected()) {
                radioButtonReturnTime1.setVisible(true);
                radioButtonReturnTime2.setVisible(true);
            }

            radioButtonReturnTime1.setToggleGroup(toggleGroupFlightTimes_2);
            radioButtonReturnTime2.setToggleGroup(toggleGroupFlightTimes_2);
            toggleGroupFlightTimes_2.selectedToggleProperty().addListener(observable -> {

                if (toggleGroupFlightTimes_2.getSelectedToggle() == radioButtonReturnTime1) {
                    selectedReturnTime = flightTime_1;
                } else if (toggleGroupFlightTimes_2.getSelectedToggle() == radioButtonReturnTime2) {
                    selectedReturnTime = flightTime_2;
                }

            });

        }
        //  Flight has only one time slot
        else {
            radioButtonReturnTime2.setVisible(false);
            radioButtonDeptTime2.setVisible(false);
        }
    }



    private GridPane createMiddleGridPane() {
        gridPaneMiddle = new GridPane();
        gridPaneMiddle.setAlignment(Pos.CENTER);
        gridPaneMiddle.getStyleClass().add("grid");

        imageViewDept = new ImageView();
        Image imageDept = new Image("departures.png");
        imageViewDept.setImage(imageDept);
        imageViewDept.setFitWidth(100);
        imageViewDept.setFitHeight(100);
        imageViewDept.setSmooth(true);
        imageViewDept.setCache(true);

        imageViewReturn = new ImageView();
        Image imageReturn = new Image("arrivals.png");
        imageViewReturn.setImage(imageReturn);
        imageViewReturn.setFitWidth(100);
        imageViewReturn.setFitHeight(100);
        imageViewReturn.setSmooth(true);
        imageViewReturn.setCache(true);

        gridPaneMiddle.add(imageViewDept, 0, 2);
        gridPaneMiddle.add(imageViewReturn, 2, 2);
        gridPaneMiddle.add(vBoxRadioBtns1, 0, 3);
        gridPaneMiddle.add(vBoxRadioBtns2, 2, 3);


        // .add(Node, colIndex, rowIndex, colSpan, rowSpan):
        gridPaneMiddle.add(new Separator(), 0, 5, 3, 1);

        return gridPaneMiddle;
    }

    private HBox createBottomPane() {
        // LHS Pane

        gridPaneLeft = new GridPane();
        gridPaneLeft.getStyleClass().add("gridPaneLeft");

        StackPane stackPaneLeft = new StackPane();
        stackPaneLeft.setPrefHeight(400);
        stackPaneLeft.setMaxWidth(120);
        stackPaneLeft.getStyleClass().add("stackPaneLeft");
        StackPane.setAlignment(gridPaneLeft, Pos.TOP_LEFT);
        stackPaneLeft.getChildren().addAll(gridPaneLeft);

        Label spinnerLabel = new Label("No. of passengers:");

        spinnerObservableList.addAll(0, 1, 2, 3, 4, 5, 6, 7, 8);

        spinnerPassengerNo = new Spinner<>();
        spinnerPassengerNo.getStyleClass().add("mySpinner");

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.ListSpinnerValueFactory<>(spinnerObservableList);

        spinnerPassengerNo.setValueFactory(valueFactory);

        spinnerPassengerNo.valueProperty();

        spinnerPassengerNo.valueProperty().addListener(observable -> spinnerPassengerNumberListener());

        gridPaneLeft.add(spinnerLabel, 1, 2);
        gridPaneLeft.add(spinnerPassengerNo, 1, 3);
        GridPane.setMargin(spinnerPassengerNo, new Insets(10, 0, 50, 50));

        // RHS Pane
        StackPane stackPaneRight = new StackPane();
        stackPaneRight.setPrefHeight(310);
        stackPaneRight.setMaxWidth(600);
        stackPaneRight.getStyleClass().add("stackPaneRight");

        Label labelBorder = new Label("Passenger Details");
        labelBorder.getStyleClass().add("border-title");
        StackPane.setAlignment(labelBorder, Pos.TOP_LEFT);
        StackPane.setMargin(labelBorder, new Insets(0, 0, 0, 40));
        Label labelBag = new Label("Bag");
        labelBag.getStyleClass().add("label-header");
        Label labelSpanish = new Label("Spanish");
        labelSpanish.getStyleClass().add("label-header");
        StackPane.setAlignment(labelBag, Pos.TOP_RIGHT);
        StackPane.setAlignment(labelSpanish, Pos.TOP_CENTER);
        StackPane.setMargin(labelSpanish, new Insets(0, 0, 0, 230));
        StackPane.setMargin(labelBag, new Insets(0, 5, 0, 0));
        stackPaneRight.getChildren().addAll(labelBorder, labelBag, labelSpanish);




        for (int i = 0; i < firstNameArray.length; i++) {
            firstNameArray[i] = new TextField();
            lastNameArray[i] = new TextField();
            numberDNIArray[i] = new TextField();
            dateOfBirthArray[i] = new DatePicker();
            radioBtnArray[i] = new RadioButton();
            checkboxArraySpanish[i] = new CheckBox();
        }

        // ObservableLists of above controls
        tfFirstNamesList.addAll(firstNameArray);
        tfLastNamesList.addAll(lastNameArray);
        dpDateOfBirthList.addAll(dateOfBirthArray);
        radioBtnBagList.addAll(radioBtnArray);
        checkboxListSpanish.addAll(checkboxArraySpanish);
        numberDNIList.addAll(numberDNIArray);


        for (int i = 0; i < Consts.MAX_PASSENGER_NO; i++) {
            tfFirstNamesList.get(i).setDisable(true);
            tfFirstNamesList.get(i).getStyleClass().addAll("sm-label");
            tfLastNamesList.get(i).setDisable(true);
            tfLastNamesList.get(i).getStyleClass().addAll("sm-label");
            numberDNIList.get(i).setDisable(true);
            numberDNIList.get(i).getStyleClass().addAll("sm-label");
            dpDateOfBirthList.get(i).setDisable(true);
            dpDateOfBirthList.get(i).getStyleClass().add("myDatePicker");
            radioBtnBagList.get(i).setDisable(true);
            checkboxListSpanish.get(i).setDisable(true);
        }

        GridPane gridPaneRight = new GridPane();
        gridPaneRight.setAlignment(Pos.TOP_RIGHT);
        gridPaneRight.setHgap(10);
        gridPaneRight.setVgap(10);
        gridPaneRight.setPadding(new Insets(20, 0, 0, 0));



        for(int i = 0; i < Consts.NO_OF_COL; i++) {

            for (int j = 0; j < Consts.NO_OF_ROWS; j++) {

                gridPaneRight.add(firstNameArray[j], i, j);
                gridPaneRight.add(lastNameArray[j], i+1, j);
                gridPaneRight.add(numberDNIArray[j], i+2 , j);
                gridPaneRight.add(checkboxArraySpanish[j], i+3 , j);
                gridPaneRight.add(dateOfBirthArray[j], i+4 , j);
                gridPaneRight.add(radioBtnArray[j], i+5 , j);

            }
        }


        disableBaggageOptionForInfants();

        checkboxSpanishControlsDNINumberField();


        StackPane.setAlignment(gridPaneRight, Pos.TOP_LEFT);
        stackPaneRight.getChildren().addAll(gridPaneRight);

        HBox hBox = new HBox();
        HBox.setHgrow(stackPaneLeft, Priority.ALWAYS);
        HBox.setHgrow(stackPaneRight, Priority.ALWAYS);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(stackPaneLeft, stackPaneRight);

        return hBox;
    }


    private void disableBaggageOptionForInfants() {

        for (int i = 0; i < Consts.MAX_PASSENGER_NO; i++) {

            dpDateOfBirthList.get(i).valueProperty().addListener((observable, oldValue, newValue) -> {

                addPassengers();
                int j = 0;
                for (Passenger passenger : passengerList) {
                    j++;
                    if (passenger.isPassengerInfant()) {
                        radioBtnBagList.get(j - 1).setDisable(true);
                    } else {
                        radioBtnBagList.get(j - 1).setDisable(false);
                    }
                }
            });
        }
    }


    private void checkboxSpanishControlsDNINumberField() {

        for (int i = 0; i < Consts.MAX_PASSENGER_NO; i++) {
            checkboxListSpanish.get(i).selectedProperty().addListener((observable, oldValue, newValue) -> {
                // checked
                if (newValue) {
                    for (int j = 0; j < Consts.MAX_PASSENGER_NO; j++) {
                        if (checkboxListSpanish.get(j).isSelected()) {
                            numberDNIList.get(j).setDisable(false);
                        }
                    }
                }
                // un-checked
                else {
                    for (int k = 0; k < Consts.MAX_PASSENGER_NO; k++) {
                        if (!checkboxListSpanish.get(k).isSelected()) {
                            numberDNIList.get(k).setDisable(true);
                        }
                    }
                }
            });
        }
    }


    private void spinnerPassengerNumberListener() {

        if (tfFirstNamesList != null) {
            for (int i = 1; i < tfFirstNamesList.size() + 1; i++) {

                if (spinnerPassengerNo.getValue() == i) {
                    tfFirstNamesList.get(i - 1).setDisable(false);
                    tfLastNamesList.get(i - 1).setDisable(false);
                    dpDateOfBirthList.get(i - 1).setDisable(false);
                    radioBtnBagList.get(i - 1).setDisable(false);
                    checkboxListSpanish.get(i - 1).setDisable(false);
                }
            }

            for (int i = 0; i < tfFirstNamesList.size(); i++) {

                if (spinnerPassengerNo.getValue() == i) {
                    tfFirstNamesList.get(i).setDisable(true);
                    tfLastNamesList.get(i).setDisable(true);
                    numberDNIList.get(i).setDisable(true);
                    dpDateOfBirthList.get(i).setDisable(true);
                    radioBtnBagList.get(i).setDisable(true);
                    checkboxListSpanish.get(i).setDisable(true);
                    radioBtnBagList.get(i).setSelected(false);
                    checkboxListSpanish.get(i).setSelected(false);
                }
            }
        }
    }


    private void setFlightPriceAdult() {
        String dptFlight = comboOrigin.getSelectionModel().getSelectedItem();
        String rtnFlight = comboDestination.getSelectionModel().getSelectedItem();

        // constructor
        flight = new AdultFlight(
                dptFlight,       // setOrigin() from variable in this method
                rtnFlight,       // setDestination() from variable in this method
                dateDepartPrice,    // setDepartPrice() from the return of getSelectDate()
                dateReturnPrice,    // setReturnPrice() from the return of getSelectDate()
                currentPrice,       // setPrice() from the return of getSelectedFlightPrice()
                selectedDeptTime,   // returned from displayFlightDetails()
                selectedReturnTime);// returned from displayFlightDetails()

    }

    private void setFlightPriceChild() {
        String dptFlight = comboOrigin.getSelectionModel().getSelectedItem();
        String rtnFlight = comboDestination.getSelectionModel().getSelectedItem();

        // ChildFlight object
        childFlight = new ChildFlight();
        double childPrice = childFlight.setPriceSingle();
        double childTotalPrice = childFlight.setPriceReturn();

        // constructor
        flightForChild = new ChildFlight(
                dptFlight,
                rtnFlight,
                childPrice,
                childPrice,
                childTotalPrice,
                selectedDeptTime,
                selectedReturnTime);

    }

    private void setFlightPriceInfants() {
        String dptFlight = comboOrigin.getSelectionModel().getSelectedItem();
        String rtnFlight = comboDestination.getSelectionModel().getSelectedItem();

        // InfantFlight object
        infantFlight = new InfantFlight();
        double infantPrice = infantFlight.setPriceSingle();
        double infantTotalPrice = infantFlight.setPriceReturn();

        // constructor
        flightForBaby = new InfantFlight(
                dptFlight,
                rtnFlight,
                infantPrice,
                infantPrice,
                infantTotalPrice,
                selectedDeptTime,
                selectedReturnTime);

    }


    // get spanish rebate value from the Passenger object, based on the criteria of flights being to or from MAD / AGP
    public double spanishRebateSelected() {
        double spaRebate = 0.0;

        for(Passenger p : passengerList) {
            spaRebate = p.setSpaRebate(dptFlight, rtnFlight);
        }

        return spaRebate;
    }


    private double calculateBagPrice() {
        double bagPrice = 0.0;

        if (passenger != null) {
            if (radioButtonReturn.isSelected()) {
                bagPrice = passenger.setBaggagePriceReturn();
            } else if (radioButtonOneWay.isSelected()) {
                bagPrice = passenger.setBaggagePriceSingle();
            }
        }
        return bagPrice;
    }


    private double calculateAdultFinalPrice() {
        bagPrice = calculateBagPrice();
        spanishRebate = spanishRebateSelected();
        return price = currentPrice + bagPrice - spanishRebate;
    }


    private double calculateChildFinalPrice() {
        if(childFlight != null) {
            double childPrice = childFlight.setPriceReturn();
            bagPrice = calculateBagPrice();
            spanishRebate = spanishRebateSelected();
            price = childPrice + bagPrice - spanishRebate;
        }
        return price;
    }



    private void addPassengers() {
        passengerList = new ArrayList<>();

        for (int i = 0; i < spinnerPassengerNo.getValue(); i++) {

            passenger = new Passenger(
                    tfFirstNamesList.get(i).getText(),
                    tfLastNamesList.get(i).getText(),
                    numberDNIList.get(i).getText(),
                    dpDateOfBirthList.get(i).getValue(),
                    radioBtnBagList.get(i).isSelected(),
                    checkboxListSpanish.get(i).isSelected()
            );

            passengerList.add(passenger);
        }

    }



    private void writeDetails() {

        double spanishRebate = spanishRebateSelected();
        double adultPrice = calculateAdultFinalPrice();
        double childPrice = calculateChildFinalPrice();

        int i = 0;
        for (Passenger passenger : passengerList) {
            i++;

            if (passenger != null) {

                window.setScene(scene2);

                // add Passenger and Flight objects to the ListView displayed in the next scene (after Continue button is clicked)
                if (passenger.isPassengerInfant()) {

                    setFlightPriceInfants();

                    if (radioButtonReturn.isSelected()) {
                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toString(),
                                flightForBaby.toString(),
                                "\tTotal: \t\t\t\t\t\t = €" + infantFlight.setPriceReturn());
                    } else if (radioButtonOneWay.isSelected()) {

                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toStringSingleFlight(),
                                flightForBaby.toStringSingleFlight(),
                                "\tTotal: \t\t\t\t\t\t = €" + infantFlight.setPriceReturn());
                    }

                } else if (passenger.isPassengerAChild()) {

                    setFlightPriceChild();

                    if (radioButtonReturn.isSelected()) {
                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toString(),
                                "\t" + "Spanish Rebate: \t €" + spanishRebate + "\n" +
                                        flightForChild.toString(),
                                "\tTotal: \t\t\t\t\t\t = €" + childPrice);
                    } else if (radioButtonOneWay.isSelected()) {

                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toStringSingleFlight(),
                                "\t" + "Spanish Rebate: \t €" + spanishRebate + "\n" +
                                        flightForChild.toStringSingleFlight(),
                                "\tTotal: \t\t\t\t\t\t = €" + childPrice);
                    }

                } else if (passenger.isPassengerOver5()) {

                    setFlightPriceAdult();

                    if (radioButtonReturn.isSelected()) {
                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toString(),
                                "\t" + "Spanish Rebate: \t €" + spanishRebate + "\n" +
                                        flight.toString(),
                                "\tTotal: \t\t\t\t\t\t = €" + adultPrice);
                    } else if (radioButtonOneWay.isSelected()) {
                        listView.getItems().addAll(
                                "\nPassenger " + i + passenger.toStringSingleFlight(),
                                "\t" + "Spanish Rebate: \t €" + spanishRebate + "\n" +
                                        flight.toStringSingleFlight(),
                                "\tTotal: \t\t\t\t\t\t = €" + adultPrice);
                    }
                }
            }
        }

        // add items to the next scene
        try {
            Button buttonBack = new Button("Back");
            nextSceneVBox.getChildren().addAll(
                    listView, buttonBack, nextSceneCreditCardContainer(), getTableViewPassenger(), getTableViewFlight());

            buttonBack.setOnAction(event -> {
                listView.getItems().clear();
                window.setScene(scene1);
            });
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }



    public void validateForEmptyFields() {

        addPassengers();

        if (comboOrigin.getValue() != null || comboDestination.getValue() != null) {
            if (datePickerDeparture.getValue() != null || datePickerReturn.getValue() != null) {

                    int i = 0;
                    int countInfant = 0;
                    int countChildren = 0;
                    int countAdult = 0;

                    for (Passenger mPassenger : passengerList) {
                        i++;

                        if(mPassenger.isPassengerInfant())
                            countInfant++;

                        if (mPassenger.isPassengerAChild())
                            countChildren++;

                        if(mPassenger.isPassengerOver18())
                            countAdult++;


                        if (spinnerPassengerNo.getValue() == i) {

                            String fName = mPassenger.getFirstName();
                            String lName = mPassenger.getLastName();

                            if(!mPassenger.validateFirstName(fName) || !mPassenger.validateLastName(lName)) {
                                UtilityClass.errorMessagePassengerName();
                            }

                            else if(mPassenger.isSpanishCheckboxSelected() && !mPassenger.validateDNINumber()){
                                UtilityClass.errorMessageDNINumber();
                            }

                            else if (countChildren >= 3 || countInfant >= 3 ||
                                    countChildren == 2 && countInfant > 0  ||
                                    countInfant == 2 && countChildren > 0 )
                            {
                                UtilityClass.errorMessageMaxTwoChildren();
                            }

                            else if (countAdult == 0) {
                                UtilityClass.errorMessageUnder18();
                            }
                            else {
                                // go to next scene
                                writeDetails();
                            }
                        }
                    }

            } else {
                UtilityClass.errorMessageDate();
            }
        } else {
            UtilityClass.errorMessageFlight();
        }
    }


    private void addFlightDetailsToDatabase() {
        if (flight != null) {
            JaviairController.getInstance().addFlight(flight);
        }
        if (flightForChild != null) {
            JaviairController.getInstance().addFlight(flightForChild);
        }
        if (flightForBaby != null) {
            JaviairController.getInstance().addFlight(flightForBaby);
        }
        JaviairController.getInstance().saveFlight();
    }


    private void addPassengerDetailsToDatabase() {
        if (passengerList != null) {
            for (Passenger passenger : passengerList) {
                JaviairController.getInstance().addPassenger(passenger);
            }
            JaviairController.getInstance().savePassenger();
        }

    }


    private void addCreditCardDetailsToDatabase() {
        if (creditCard != null) {
            JaviairController.getInstance().addCreditCard(creditCard);
        }
        JaviairController.getInstance().saveCreditCard();
    }



    private TableView getTableViewFlight() {

        TableView<Flight> table = new TableView<>();

        TableColumn<Flight, String> originCol = new TableColumn<>("Origin");
        TableColumn<Flight, String> destinationCol = new TableColumn<>("Destination");
        TableColumn<Flight, Double> departPriceCol = new TableColumn<>("Depart Price");
        TableColumn<Flight, Double> returnPriceCol = new TableColumn<>("Return Price");
        TableColumn<Flight, Double> priceCol = new TableColumn<>("Total Price");
        TableColumn<Flight, String> departTimeCol = new TableColumn<>("Dept Time");
        TableColumn<Flight, String> returnTimeCol = new TableColumn<>("Return Time");

        originCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("origin"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
        departPriceCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("departPrice"));
        returnPriceCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("returnPrice"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Flight, Double>("price"));
        departTimeCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("departTime"));
        returnTimeCol.setCellValueFactory(new PropertyValueFactory<Flight, String>("returnTime"));

        ObservableList<Flight> flightList = getFlightList();
        table.setItems(flightList);


        table.getColumns().addAll(originCol, destinationCol, departPriceCol, returnPriceCol, priceCol,
                departTimeCol, returnTimeCol);

        return table;
    }


    private TableView getTableViewPassenger() {

        TableView<Passenger> table = new TableView<>();

        TableColumn<Passenger, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<Passenger, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<Passenger, LocalDate> dateOfBirthCol = new TableColumn<>("Date of Birth");
        TableColumn<Passenger, Double> bagPriceCol = new TableColumn<>("Bag Price");
        TableColumn<Passenger, Boolean> bagSelectedCol = new TableColumn<>("Bag Selected");
        TableColumn<Passenger, Double> spanishRebateCol = new TableColumn<>("Spanish Rebate");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Passenger, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Passenger, String>("lastName"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Passenger, LocalDate>("dateOfBirth"));
        bagPriceCol.setCellValueFactory(new PropertyValueFactory<Passenger, Double>("baggagePrice"));
        bagSelectedCol.setCellValueFactory(new PropertyValueFactory<Passenger, Boolean>("baggageSelected"));
        spanishRebateCol.setCellValueFactory(new PropertyValueFactory<Passenger, Double>("spaRebate"));


        ObservableList<Passenger> passengerList = getPassengerList();
        table.setItems(passengerList);

        table.getColumns().addAll(firstNameCol, lastNameCol, dateOfBirthCol, bagPriceCol, bagSelectedCol, spanishRebateCol);

        return table;
    }


    private ObservableList<Passenger> getPassengerList() {
        ObservableList<Passenger> pList = FXCollections.observableArrayList();

        for(Passenger passenger : passengerList) {
            pList.add(passenger);
        }

        return pList;
    }


    private ObservableList<Flight> getFlightList() {
        ObservableList<Flight> fList = FXCollections.observableArrayList(flight);

        return fList;
    }



    private AnchorPane createAnchorPane() {
        AnchorPane anchorPane = new AnchorPane();
        buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(event -> UtilityClass.confirmBoxCloseApp());

        buttonContinue = new Button("Continue");
        buttonContinue.setOnAction(event -> validateForEmptyFields());

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(0, 10, 10, 10));
        hBox.getChildren().addAll(buttonCancel, buttonContinue);

        anchorPane.getChildren().addAll(buttonContinue, buttonCancel);
        AnchorPane.setBottomAnchor(buttonContinue, 10.0);
        AnchorPane.setRightAnchor(buttonContinue, 315.0);
        AnchorPane.setBottomAnchor(buttonCancel, 10.0);
        AnchorPane.setRightAnchor(buttonCancel, 415.0);

        return anchorPane;
    }
}