package GUI;

/**
 ** This class stores all the CSS styling used for the GUI
 **/

public class Styles {

    // Results Page
    public static String resultsDataFrame = ""
            + "-fx-background-color: " + Colors.secondaryColor + ";\n";
    public static String resultsDeliveryTime = ""
            + "-fx-font-size:50px;\n";
    public static String resultsDeliveryTypeLabel = "";
    public static String FIFODataFrame = "";
    public static String resultsButtonFrame = "";
    public static String resultsBarChart = "-fx-padding: 10px 50px 50px 10px;";
    public static String resultsPageBackground = "-fx-background-color: " + Colors.secondaryColor + ";\n";

    // Shifts Page
    public static String shiftsPage = ""
            + "-fx-background-color: " + Colors.secondaryColor + ";\n";
    public static String shiftsPageHoursList = ""
            + "-fx-padding: 0px 75px 0px 0px;\n";
    public static String shiftsPageEntryContainer = ""
            + "-fx-padding: 0px 0px 0px 150px;\n";

    // Map Page
    public static String mapPageCurrentPointLabel = "";
    public static String mapPageNameLabel = "";
    public static String mapPageMapView = ""
            + "-fx-border-style: solid;\n";
    public static String mapPageMapInfoContainer = "";
    public static String mapPageDPListContainer = ""
            + "-fx-padding: 0px 60px 0px 0px;\n";
    public static String mapPageMapContainer = ""
            + "-fx-padding: 50px 0px 50px 50px;\n";
    public static String mapPage = ""
            + "-fx-background-color: " + Colors.secondaryColor + ";\n";

    // Food Page
    public static String foodPageFoodListContainer = ""
            + "-fx-padding: 0px 75px 0px 0px;\n";
    public static String foodPageFoodLabel = "";
    public static String foodPageWeightLabel = "";
    public static String foodPage = ""
            + "-fx-background-color: " + Colors.secondaryColor + ";\n";
    public static String foodPageFoodItemEntry = ""
            + "-fx-padding: 0px 0px 0px 150px;\n";
    public static String foodPageButton = ""
            + "-fx-padding: 75px 0px 0px 0px;\n";

    // Meals Page
    public static String mealsPage = ""
            + "-fx-background-color: " + Colors.secondaryColor + ";\n";
    public static String mealsPageMealsListContainer = ""
            + "-fx-padding: 0px 50px 0px 0px;\n";
    public static String mealsPageEntryFrame = ""
            + "-fx-padding: 0px 75px 0px 75px;\n";
    public static String mealsPageButtonFrame = ""
            + "-fx-padding: 10px 0px 0px 0px;\n";
    public static String mealsPageEntryBox = ""
            + "-fx-padding: 0px 0px 10px 0px;\n";
    public static String mealsPageFoodItemFrame = ""
            + "-fx-border-style: hidden hidden solid hidden;\n";
    public static String test = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n";

    // Menu
    public static String secondaryMenuBtn = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n";
    public static String secondaryMenuBtnHover = ""
            + "-fx-background-color: " + Colors.quaternaryColor + ";\n";
    public static String secondaryMenu = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n";
    public static String sideMenuTitleBtn = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n"
            + "-fx-text-fill: " + Colors.contrastFontColor + ";\n";
    public static String sideMenuTitleBtnHover = ""
            + "-fx-text-fill: " + Colors.quaternaryColor + ";\n"
            + "-fx-background-color: " + Colors.primaryColor + ";\n";
    public static String sideMenuTitle = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n";
    public static String sideMenuTitleText = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n"
            + "-fx-fill: " + Colors.contrastFontColor + ";\n"
            + "-fx-font-size: " + Values.sideMenuTitleFontSize + ";\n";
    public static String sideMenu = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n";
    public static String sideMenuBtn = ""
            + "-fx-background-color: " + Colors.primaryColor + ";\n"
            + "-fx-color: " + Colors.complimentaryFontColor + ";\n"
            + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";
    public static String sideMenuBtnActive = ""
            + "-fx-background-color: " + Colors.tertiaryColor + ";\n"
            + "-fx-color: " + Colors.contrastFontColor + ";\n"
            + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";
    public static String sideMenuBtnHover = ""
            + "-fx-background-color: " + Colors.quaternaryColor + ";\n"
            + "-fx-color: " + Colors.complimentaryFontColor + ";\n"
            + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";

    // Page Title
    public static String pageTitleLabelContainer = "";
    public static String pageTitleLabel = "";
    public static String pageTitle = "";

    public static void reset() {

        sideMenuTitleText = ""
                + "-fx-background-color: " + Colors.primaryColor + ";\n"
                + "-fx-fill: " + Colors.contrastFontColor + ";\n"
                + "-fx-font-size: " + Values.sideMenuTitleFontSize + ";\n"
                + "-fx-font-weight: bold;\n";
        sideMenuBtn = ""
                + "-fx-background-color: " + Colors.primaryColor + ";\n"
                + "-fx-color: " + Colors.complimentaryFontColor + ";\n"
                + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";
        sideMenuBtnActive = ""
                + "-fx-background-color: " + Colors.tertiaryColor + ";\n"
                + "-fx-color: " + Colors.contrastFontColor + ";\n"
                + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";
        sideMenuBtnHover = ""
                + "-fx-background-color: " + Colors.quaternaryColor + ";\n"
                + "-fx-color: " + Colors.complimentaryFontColor + ";\n"
                + "-fx-font-size: " + Values.sideMenuFontSize + "px;\n";
    }
}
