import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import java.util.ArrayList;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.beans.binding.Bindings;
import javafx.scene.*;
import javafx.scene.effect.*;

/**
 * This Board class stores the state of the entire game.
 * Specifically, the state of each country in the game.
 * @version 2
 * @author Markus Pistner
 * @since 2019-03-09
 */


public class MapSetup {
    private StackPane stackpane = new StackPane();
    private ArrayList<Image> countryImages = new ArrayList<Image>();
    private ArrayList<String> countryImageNames = new ArrayList<String>();
    private ArrayList<ImageView> countryImageViews = new ArrayList<ImageView>();
    private ArrayList<Double> hues = new ArrayList<Double>();
    private Image backgroundImage = new Image("BACKGROUND-W-COUNTRIES.jpg");
    private ImageView background = new ImageView(backgroundImage);
    private GameConfig gameConfig;
    private Player player;

    //sets hues which will determine player country color
    private double hue1 = -0.96;
    private double hue2 = 0.2;
    private double hue3 = 0.5;
    private double hue4 = 0.8;
    private double hue5 = 1.0;
    private double hue6 = -0.4;
    private ColorAdjust colorAdjust = new ColorAdjust();
    private Image image;
    private ImageView imageView;


    public ColorAdjust getColorAdjust(){
        return colorAdjust;
    }

    /** sets the contrast, hue, brightness, saturation
    * @param contrast is the contrast value of type double, between -1 and 1
    * @param hue is the hue value of type double, between -1 and 1
    * @param brightness is the brightness value of type double, between -1 and 1
    * @param saturation is the saturation value of type double, between -1 and 1
    */
   public void setColorAdjust(double contrast, double hue, double brightness, double saturation){
    colorAdjust.setContrast(contrast);
    colorAdjust.setHue(hue);
    colorAdjust.setBrightness(brightness);
    colorAdjust.setSaturation(saturation);
   }

   // takes an image in and converts itto ImageView type
   public void setImageView(Image im){
    image = im;
    imageView = new ImageView(image);
    imageView.setPreserveRatio(true);
    imageView.setEffect(getColorAdjust());
   }


   public ImageView getImageView(){
       return imageView;
   }

   // takes in an image and converts it to ImageView type. Changes the color of that ImageView
   public void colorCountry(Image image,double contrast, double hue, double brightness, double saturation){
       setColorAdjust(contrast, hue, brightness, saturation);
       setImageView(image);

   }


    public ImageView getBackground(){
        return background;
    }

    public Image getBackgroundImage(){
        return backgroundImage;
    }

    public ArrayList<Image> getCountryImages(){
        return countryImages;
    }

    public ArrayList<String> getCountryImageNames(){
        return countryImageNames;
    }

    public ArrayList<ImageView> getCountryImageViews(){
        return countryImageViews;
    }


    // creates an ArrayList of 41 ImageView types by using countryImages array
    public void setupCountryImageViews(){
      setupCountryImages();
      for(int i=0; i<getCountryImages().size(); i++){
        Image imageToAdd = getCountryImages().get(i);
        setImageView(imageToAdd);
        countryImageViews.add(imageView);
    }}


    // sets the colored images into the StackPane
    public void setupStackPane(){
        stackpane.getChildren().addAll(background,
        countryImageViews.get(0),
        countryImageViews.get(1),countryImageViews.get(2),countryImageViews.get(3),
        countryImageViews.get(4),countryImageViews.get(5),countryImageViews.get(6),
        countryImageViews.get(7),countryImageViews.get(8),countryImageViews.get(9),
        countryImageViews.get(10),countryImageViews.get(11),countryImageViews.get(12),
        countryImageViews.get(13),countryImageViews.get(14),countryImageViews.get(15),
        countryImageViews.get(16),countryImageViews.get(17),countryImageViews.get(18),
        countryImageViews.get(19),countryImageViews.get(20),countryImageViews.get(21),
        countryImageViews.get(22),countryImageViews.get(23),countryImageViews.get(24),
        countryImageViews.get(25),countryImageViews.get(26),countryImageViews.get(27),
        countryImageViews.get(28),countryImageViews.get(29),countryImageViews.get(30),
        countryImageViews.get(31),countryImageViews.get(32),countryImageViews.get(33),
        countryImageViews.get(34),countryImageViews.get(35),countryImageViews.get(36),
        countryImageViews.get(37),countryImageViews.get(38),countryImageViews.get(39),
        countryImageViews.get(40),countryImageViews.get(41));
    }

    // Creates ArrayList of hues
      public void setupHues(){
          hues.add(hue1);
          hues.add(hue2);
          hues.add(hue3);
          hues.add(hue4);
          hues.add(hue5);
          hues.add(hue6);
      }


    // Takes all building images and adds them to ArrayList countryImages
    public void setupCountryImages(){
      countryImages.add(new Image(new File("HYBRID.png").toURI().toString()));
      countryImages.add(new Image(new File("CCIT.png").toURI().toString()));
      countryImages.add(new Image(new File("ENA.png").toURI().toString()));
      countryImages.add(new Image(new File("ENB.png").toURI().toString()));
      countryImages.add(new Image(new File("ENC.png").toURI().toString()));
      countryImages.add(new Image(new File("END.png").toURI().toString()));
      countryImages.add(new Image(new File("ENF.png").toURI().toString()));
      countryImages.add(new Image(new File("SSE.png").toURI().toString()));
      countryImages.add(new Image(new File("TI.png").toURI().toString()));
      countryImages.add(new Image(new File("EEEL.png").toURI().toString()));
      countryImages.add(new Image(new File("ICT.png").toURI().toString()));
      countryImages.add(new Image(new File("ES.png").toURI().toString()));
      countryImages.add(new Image(new File("SA.png").toURI().toString()));
      countryImages.add(new Image(new File("SB.png").toURI().toString()));
      countryImages.add(new Image(new File("TR.png").toURI().toString()));
      countryImages.add(new Image(new File("MS.png").toURI().toString()));
      countryImages.add(new Image(new File("ST.png").toURI().toString()));
      countryImages.add(new Image(new File("SS.png").toURI().toString()));
      countryImages.add(new Image(new File("BS.png").toURI().toString()));
      countryImages.add(new Image(new File("OO.png").toURI().toString()));
      countryImages.add(new Image(new File("KNA.png").toURI().toString()));
      countryImages.add(new Image(new File("KNB.png").toURI().toString()));
      countryImages.add(new Image(new File("MSC.png").toURI().toString()));
      countryImages.add(new Image(new File("MACHALL.png").toURI().toString()));
      countryImages.add(new Image(new File("MB.png").toURI().toString()));
      countryImages.add(new Image(new File("MT.png").toURI().toString()));
      countryImages.add(new Image(new File("MFH.png").toURI().toString()));
      countryImages.add(new Image(new File("TFDL.png").toURI().toString()));
      countryImages.add(new Image(new File("CHG.png").toURI().toString()));
      countryImages.add(new Image(new File("CHC.png").toURI().toString()));
      countryImages.add(new Image(new File("RT.png").toURI().toString()));
      countryImages.add(new Image(new File("RC.png").toURI().toString()));
      countryImages.add(new Image(new File("ARTSPARK.png").toURI().toString()));
      countryImages.add(new Image(new File("AD.png").toURI().toString()));
      countryImages.add(new Image(new File("PF.png").toURI().toString()));
      countryImages.add(new Image(new File("EDUC.png").toURI().toString()));
      countryImages.add(new Image(new File("SCRF.png").toURI().toString()));
      countryImages.add(new Image(new File("IH.png").toURI().toString()));
      countryImages.add(new Image(new File("DC.png").toURI().toString()));
      countryImages.add(new Image(new File("TRAD.png").toURI().toString()));
      countryImages.add(new Image(new File("APTS.png").toURI().toString()));
    }


    /** Iterates through all the buildings and checks whether a player owns that building
    *  If the player owns that country, it changes the color and updates countryImageViews
    * @param listOfPlayers is an ArrayList<Player> that points to all the players
    */
      public void updateCountryImageViews(ArrayList<Player> listOfPlayers, ArrayList<Country> countriesList){
        setupHues();
        for (int i=0; i<countriesList.size(); i++){
          Country checkCountry = countriesList.get(i);
          Image imageToAdd = countryImages.get(i);
          for (int m=0; m<listOfPlayers.size(); m++){
            Player currentPlayer = listOfPlayers.get(m);
            if (checkCountry.getPlayerPossession() == currentPlayer){
              if(m == 0){
                colorCountry(imageToAdd, 0.0, hue1, 0.0, 0.0);
                ImageView imageviewNew = new ImageView(imageToAdd);
                imageviewNew.setPreserveRatio(true);
                imageviewNew.setSmooth(true);
                imageviewNew.setCache(true);
                StackPane.setAlignment(imageviewNew, Pos.TOP_CENTER);
                countryImageViews.set(i,imageviewNew);
              }

            }
          }
        }
      }




    /**
    * @return stackpane, the final stackpane
    */
    public StackPane setupMap(){
    setupStackPane();
    return getStackPane();


    }


    public StackPane getStackPane(){
      return stackpane;
    }

}
