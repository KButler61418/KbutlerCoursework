package Scenes;

import Model.AlbumService;
import Model.CatchService;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Controller.MainController.Table;
import static Controller.MainController.database;
import static Model.CatchService.selectByID2;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AddLakesScene.AddLake;
import static Scenes.CatchScene.CatchDisplay;
import static Scenes.CatchScene.DisplayCatch3;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class AlbumScene {

    public static void Album(){

        String AlbumText1 = (AlbumService.selectByAlbumID2(1,  database).toString());
        String[] AlbumName1 = AlbumText1.split(",");

        String AlbumText2 = (AlbumService.selectByAlbumID2(2,  database).toString());
        String[] AlbumName2 = AlbumText2.split(",");

        String AlbumText3 = (AlbumService.selectByAlbumID2(3,  database).toString());
        String[] AlbumName3 = AlbumText3.split(",");

        String AlbumText4 = (AlbumService.selectByAlbumID2(4,  database).toString());
        String[] AlbumName4 = AlbumText4.split(",");

        String AlbumText5 = (AlbumService.selectByAlbumID2(5,  database).toString());
        String[] AlbumName5 = AlbumText5.split(",");

        String AlbumText6 = (AlbumService.selectByAlbumID2(6,  database).toString());
        String[] AlbumName6 = AlbumText6.split(",");

        String AlbumText7 = (AlbumService.selectByAlbumID2(7,  database).toString());
        String[] AlbumName7 = AlbumText7.split(",");

        String AlbumText8 = (AlbumService.selectByAlbumID2(8,  database).toString());
        String[] AlbumName8 = AlbumText8.split(",");

        String AlbumText9 = (AlbumService.selectByAlbumID2(9,  database).toString());
        String[] AlbumName9 = AlbumText9.split(",");

        String AlbumText10 = (AlbumService.selectByAlbumID2(10,  database).toString());
        String[] AlbumName10 = AlbumText10.split(",");

        String AlbumText11 = (AlbumService.selectByAlbumID2(11,  database).toString());
        String[] AlbumName11 = AlbumText11.split(",");

        String AlbumText12 = (AlbumService.selectByAlbumID2(12,  database).toString());
        String[] AlbumName12 = AlbumText12.split(",");

        String AlbumText13 = (AlbumService.selectByAlbumID2(13,  database).toString());
        String[] AlbumName13 = AlbumText13.split(",");

        String AlbumText14 = (AlbumService.selectByAlbumID2(14,  database).toString());
        String[] AlbumName14 = AlbumText14.split(",");

        String AlbumText15 = (AlbumService.selectByAlbumID2(15,  database).toString());
        String[] AlbumName15 = AlbumText15.split(",");


        Image Peck = new Image("Gui/20170911_232450.jpg", 400, 300, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
        Image Ali = new Image("Gui/20170912_132539.jpg", 400, 300, false, true);
        Image Dove = new Image("Gui/20170912_134249.jpg", 400, 300, false, true);
        Image Fish4 = new Image("Gui/20170414_102301 (2).jpg", 400, 300, false, true);
        Image Fish5 = new Image("Gui/20170416_113607 (2).jpg", 400, 300, false, true);
        Image Fish6 = new Image("Gui/20170529_000705.jpg", 400, 300, false, true);
        Image Fish7 = new Image("Gui/20170806_081318.jpg", 400, 300, false, true);
        Image Fish8 = new Image("Gui/20170910_021927.jpg", 400, 300, false, true);
        Image Fish9 = new Image("Gui/20170911_193052.jpg", 400, 300, false, true);
        Image Fish10 = new Image("Gui/20170913_165904.jpg", 400, 300, false, true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutY(30);
        scrollPane.setVmax(440);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.prefWidthProperty().bind(root.widthProperty());
        root.prefHeightProperty().bind(root.heightProperty());
        root.setPadding(new Insets(20));
        root.getStyleClass().add("Pane");

        Button home = new Button("Home");
        home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(19);
        home.getStyleClass().add("MenuButton");

        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(80);
        album.getStyleClass().add("MenuButton");

        Button table = new Button("Table");
        table.setContentDisplay(ContentDisplay.TOP);
        table.setLayoutX(145);
        table.getStyleClass().add("MenuButton");

        Button addPhoto = new Button("Add Photo");
        addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(205);
        addPhoto.getStyleClass().add("MenuButton");

        Button addAlbum = new Button("Add Album");
        addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(295);
        addAlbum.getStyleClass().add("MenuButton");

        Button addLake = new Button("Add Lake");
        addLake.setContentDisplay(ContentDisplay.TOP);
        addLake.setLayoutX(390);
        addLake.getStyleClass().add("MenuButton");

        Button button1 = new Button(AlbumName1[1], new ImageView(Peck));
        button1.setContentDisplay(ContentDisplay.TOP);
        root.add(button1, 0, 0);
        button1.getStyleClass().add("FishButton");

        Button button2 = new Button(AlbumName2[1], new ImageView(Ali));
        button2.setContentDisplay(ContentDisplay.TOP);
        button2.getStyleClass().add("FishButton");

        Button button3 = new Button(AlbumName3[1], new ImageView(Dove));
        button3.setContentDisplay(ContentDisplay.TOP);
        button3.getStyleClass().add("FishButton");

        Button button4 = new Button(AlbumName4[1], new ImageView(Fish4));
        button4.setContentDisplay(ContentDisplay.TOP);
        button4.getStyleClass().add("FishButton");

        Button button5 = new Button(AlbumName5[1], new ImageView(Fish6));
        button5.setContentDisplay(ContentDisplay.TOP);
        button5.getStyleClass().add("FishButton");

        Button button6 = new Button(AlbumName6[1], new ImageView(Fish8));
        button6.setContentDisplay(ContentDisplay.TOP);
        button6.getStyleClass().add("FishButton");

        Button button7 = new Button(AlbumName7[1], new ImageView(Fish10));
        button7.setContentDisplay(ContentDisplay.TOP);
        button7.getStyleClass().add("FishButton");

        Button button8 = new Button(AlbumName8[1], new ImageView(Fish5));
        button8.setContentDisplay(ContentDisplay.TOP);
        button8.getStyleClass().add("FishButton");

        Button button9 = new Button(AlbumName9[1], new ImageView(Fish9));
        button9.setContentDisplay(ContentDisplay.TOP);
        button9.getStyleClass().add("FishButton");

        Button button10 = new Button(AlbumName10[1], new ImageView(Fish10));
        button10.setContentDisplay(ContentDisplay.TOP);
        button10.getStyleClass().add("FishButton");

        Button button11 = new Button(AlbumName11[1], new ImageView(Peck));
        button11.setContentDisplay(ContentDisplay.TOP);
        button11.getStyleClass().add("FishButton");

        Button button12 = new Button(AlbumName12[1], new ImageView(Ali));
        button12.setContentDisplay(ContentDisplay.TOP);
        button12.getStyleClass().add("FishButton");

        Button button13 = new Button(AlbumName13[1], new ImageView(Fish4));
        button13.setContentDisplay(ContentDisplay.TOP);
        button13.getStyleClass().add("FishButton");

        Button button14 = new Button(AlbumName14[1], new ImageView(Fish6));
        button14.setContentDisplay(ContentDisplay.TOP);
        button14.getStyleClass().add("FishButton");

        Button button15 = new Button(AlbumName15[1], new ImageView(Fish10));
        button15.setContentDisplay(ContentDisplay.TOP);
        button15.getStyleClass().add("FishButton");

        button1.setOnAction((ActionEvent ae) -> DisplayAlbum1());
        button2.setOnAction((ActionEvent ae) -> DisplayAlbum2());
        button3.setOnAction((ActionEvent ae) -> DisplayAlbum3());
        button4.setOnAction((ActionEvent ae) -> DisplayAlbum4());
        button5.setOnAction((ActionEvent ae) -> DisplayAlbum5());
        button6.setOnAction((ActionEvent ae) -> DisplayAlbum6());
        button7.setOnAction((ActionEvent ae) -> DisplayAlbum7());
        button8.setOnAction((ActionEvent ae) -> DisplayAlbum8());
        button9.setOnAction((ActionEvent ae) -> DisplayAlbum9());
        button10.setOnAction((ActionEvent ae) -> DisplayAlbum10());
        button11.setOnAction((ActionEvent ae) -> DisplayAlbum11());
        button12.setOnAction((ActionEvent ae) -> DisplayAlbum12());
        button13.setOnAction((ActionEvent ae) -> DisplayAlbum13());
        button14.setOnAction((ActionEvent ae) -> DisplayAlbum14());
        button15.setOnAction((ActionEvent ae) -> DisplayAlbum15());


        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());

        root.add(button2, 1, 0);
        root.add(button3, 2, 0);
        root.add(button4, 0, 1);
        root.add(button5, 1, 1);
        root.add(button6, 2, 1);
        root.add(button7, 0, 2);
        root.add(button8, 1, 2);
        root.add(button9, 2, 2);
        root.add(button10, 0, 3);
        root.add(button11, 1, 3);
        root.add(button12, 2, 3);
        root.add(button13, 0, 4);
        root.add(button14, 1, 4);
        root.add(button15, 2, 4);

        scrollPane.setContent(root);
        Stage stage = new Stage();
        stage.setTitle("Albums");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(root, scrollPane, home, album, addAlbum, addPhoto, table,addLake);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getStyleClass().add("Pane");
        stage.show();

        System.out.println("You have reached the Albums");
    }

    public static void AlbumDisplay() {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutY(30);
        scrollPane.setVmax(700);
        scrollPane.setHmax(2500);
        scrollPane.setPrefSize(1500, 900);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");


        System.out.println(AlbumService.selectByAlbumID(Albumcount,  database).toString());

        Button home = new Button("Home");
        home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(19);
        home.getStyleClass().add("MenuButton");

        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(80);
        album.getStyleClass().add("MenuButton");

        Button table = new Button("Table");
        table.setContentDisplay(ContentDisplay.TOP);
        table.setLayoutX(145);
        table.getStyleClass().add("MenuButton");

        Button addPhoto = new Button("Add Photo");
        addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(205);
        addPhoto.getStyleClass().add("MenuButton");

        Button addAlbum = new Button("Add Album");
        addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(295);
        addAlbum.getStyleClass().add("MenuButton");

        Button addLake = new Button("Add Lake");
        addLake.setContentDisplay(ContentDisplay.TOP);
        addLake.setLayoutX(390);
        addLake.getStyleClass().add("MenuButton");

        System.out.println(AlbumService.selectByAlbumID2(Albumcount,  database));

        String PhotoIDs = (AlbumService.selectByAlbumID2(Albumcount,  database).toString());
        System.out.println(PhotoIDs);

        String[] PhotoIDparts = PhotoIDs.split(",");
        System.out.println(CatchService.selectByPhotoID(parseInt(PhotoIDparts[2]),  database));
        System.out.println(CatchService.selectByPhotoID(parseInt(PhotoIDparts[3]),  database));
        System.out.println(CatchService.selectByPhotoID(parseInt(PhotoIDparts[4]),  database));
        System.out.println(CatchService.selectByPhotoID(parseInt(PhotoIDparts[5]),  database));
        System.out.println(CatchService.selectByPhotoID(parseInt(PhotoIDparts[6]),  database));


        System.out.println(AlbumService.selectByAlbumID(Albumcount,  database));


        Label Photo1= new Label(CatchService.selectByPhotoID(parseInt(PhotoIDparts[2]),  database).toString());
        Label Photo2= new Label(CatchService.selectByPhotoID(parseInt(PhotoIDparts[3]),  database).toString());
        Label Photo3= new Label(CatchService.selectByPhotoID(parseInt(PhotoIDparts[4]),  database).toString());
        Label Photo4= new Label(CatchService.selectByPhotoID(parseInt(PhotoIDparts[5]),  database).toString());
        Label Photo5= new Label(CatchService.selectByPhotoID(parseInt(PhotoIDparts[6]),  database).toString());

        String Text = (AlbumService.selectByAlbumID(Albumcount,  database).toString());
        System.out.println(Text);
        String[] Albumparts = Text.split(",");

        String Text2 = (AlbumService.selectByAlbumID2(Albumcount,  database).toString());
        System.out.println(Text);
        String[] Albumparts2 = Text2.split(",");

        String PhotoText = (selectByID2(parseInt(Albumparts2[3]),  database).toString());
        System.out.println(PhotoText);
        String[] Photo1Tags = PhotoText.split(",");

        Label[] Photo1parts = new Label[13];

        Photo1parts[0] = new Label( "" + Photo1Tags[8] + Photo1Tags[9]);
        Photo1parts[1] = new Label(""+ Photo1Tags[2] );
        Photo1parts[2] = new Label(""+ Photo1Tags[5]);
        Photo1parts[3] = new Label(""+ Photo1Tags[1]);
        Photo1parts[4] = new Label(""+ Photo1Tags[6]);
        Photo1parts[5] = new Label(""+ Photo1Tags[7]);
        Photo1parts[6] = new Label(""+ Photo1Tags[13]);
        Photo1parts[7] = new Label(""+ Photo1Tags[10]);
        Photo1parts[11] = new Label(""+ Photo1Tags[3]);
        Photo1parts[8] = new Label(""+ Photo1Tags[4]);
        Photo1parts[9] = new Label(""+ Photo1Tags[11]);
        Photo1parts[10] = new Label("" + Photo1Tags[12]);

        System.out.println(Albumparts[0]);
        System.out.println(Albumparts[1]);
        System.out.println(Albumparts[2]);
        System.out.println(Albumparts[3]);
        System.out.println(Albumparts[4]);
        System.out.println(Albumparts[5]);
        System.out.println(Albumparts[6]);


        Image image1 = new Image(Albumparts[2], 450, 300, false, true);
        ImageView Image1 = new ImageView(image1);
        Image1.setLayoutY(50);
        Image1.setLayoutX(50);

        Image image2 = new Image(Albumparts[3], 450, 300, false, true);
        ImageView Image2 = new ImageView(image2);
        Image2.setLayoutY(380);
        Image2.setLayoutX(50);

        Image image3 = new Image(Albumparts[4], 450, 300, false, true);
        ImageView Image3 = new ImageView(image3);
        Image3.setLayoutY(700);
        Image3.setLayoutX(50);

        Image image4 = new Image(Albumparts[5], 450, 300, false, true);
        ImageView Image4 = new ImageView(image4);
        Image4.setLayoutY(350);
        Image4.setLayoutX(50);

        Image image5 = new Image(Albumparts[6], 450, 300, false, true);
        ImageView Image5 = new ImageView(image5);
        Image5.setLayoutY(680);
        Image5.setLayoutX(50);

        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.prefWidthProperty().bind(root.widthProperty());
        root.prefHeightProperty().bind(root.heightProperty());
        root.setPadding(new Insets(20));
        root.getStyleClass().add("Pane");

        root.add(Image1,0, 0);
        root.add(Image2,0, 1);
        root.add(Image3,0, 2);
        root.add(Image4,0, 3);
        root.add(Image5,0, 4);
        root.add(Photo1, 1,0);
        root.add(Photo2, 1,1);
        root.add(Photo3, 1,2);
        root.add(Photo4, 1,3);
        root.add(Photo5, 1,4);

        scrollPane.setContent(root);
        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(scrollPane, home, album, addPhoto, addAlbum, addLake, table);
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }

    public static int Albumcount;

    public static void DisplayAlbum1(){ Albumcount = 1; AlbumDisplay(); }

    public static void DisplayAlbum2(){ Albumcount = 2;AlbumDisplay(); }

    public static void DisplayAlbum3(){ Albumcount = 3;AlbumDisplay(); }

    public static void DisplayAlbum4(){ Albumcount = 4;AlbumDisplay(); }

    public static void DisplayAlbum5(){ Albumcount = 5;AlbumDisplay(); }

    public static void DisplayAlbum6(){ Albumcount = 6;AlbumDisplay(); }

    public static void DisplayAlbum7(){ Albumcount = 7;AlbumDisplay(); }

    public static void DisplayAlbum8(){ Albumcount = 8;AlbumDisplay(); }

    public static void DisplayAlbum9(){ Albumcount = 9;AlbumDisplay(); }

    public static void DisplayAlbum10(){ Albumcount = 10;AlbumDisplay(); }

    public static void DisplayAlbum11(){ Albumcount = 11;AlbumDisplay(); }

    public static void DisplayAlbum12(){ Albumcount = 12;AlbumDisplay(); }

    public static void DisplayAlbum13(){ Albumcount = 13;AlbumDisplay(); }

    public static void DisplayAlbum14(){ Albumcount = 14;AlbumDisplay(); }

    public static void DisplayAlbum15(){ Albumcount = 15;AlbumDisplay(); }

}
