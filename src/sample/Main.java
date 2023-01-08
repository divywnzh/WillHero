package sample;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javafx.event.EventHandler;

public class Main extends Application {
    static Stage stage = new Stage();
    static Group homescreen = new Group();
    static Group Pause = new Group();
    static ImageView pauseimage = new ImageView();
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        stage=showhomescreen();
        stage.show();

    }
    public static void homescreendikhjaebas(Stage primaryStage) throws Exception{
        primaryStage=showhomescreen();
        primaryStage.show();
    }
    public static Group homescreen() throws Exception{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        Parent hello = loader.load();
        game h = new game();
        FileInputStream titleinp= new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/will hero title.png");
        Image title = new Image(titleinp);
        ImageView titleimage = new ImageView(title);
        titleimage.setX(719);
        titleimage.setY(100);
        titleimage.setFitHeight(324);
        titleimage.setFitWidth(576);
        titleimage.setOpacity(1.0);
        titleimage.setPreserveRatio(true);
        TranslateTransition translatt = new TranslateTransition();
        translatt.setNode(titleimage);
        translatt.setDuration(Duration.millis(500));
        translatt.setCycleCount(TranslateTransition.INDEFINITE);
        translatt.setByY(50);
        translatt.setAutoReverse(true);
        translatt.play();
        homescreen.getChildren().add(h.Start());
        homescreen.getChildren().add(titleimage);
        homescreen.getChildren().add(hello);
        return homescreen;
    }
    public static Stage showhomescreen() throws Exception{
        Scene hi = new Scene(homescreen(), 1920, 1080);
        stage.setScene(hi);
        return stage;
    }
    public static void startgame() throws Exception{
        Group gamestart = new Group();
        game g= new game();
        stage.setTitle("Will Hero");
        FileInputStream pauseinput = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/pauseicon.png");
        Image pause = new Image(pauseinput);
        ImageView hi = new ImageView(pause);
        pauseimage = hi;
        pauseimage.setX(1820);
        pauseimage.setY(20);
        pauseimage.setFitHeight(75);
        pauseimage.setFitWidth(75);
        pauseimage.setOpacity(1.0);
        pauseimage.setPreserveRatio(true);
        gamestart.getChildren().add(g.Start());
        gamestart.getChildren().add(pauseimage);
        Scene gam = new Scene(gamestart,1920,1080);
        stage.setScene(gam);
        stage.show();
        Pause.getChildren().add(g.Start());
        pauseimage.setPickOnBounds(true);
        pauseimage.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    pause();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void exit(){
        stage.close();
    }
    public static void pause() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("pausemenu.fxml"));
        Parent paus = loader.load();
        Pause.getChildren().add(paus);
        Scene pauj = new Scene(Pause, 1920, 1080);
        stage.setScene(pauj);
        stage.show();
    }
    public static void gameover(Group root) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("gameover.fxml"));
        Parent end = loader.load();
        root.getChildren().add(end);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
class game{
    int counter=0;
    Text t;
    private ArrayList<platform> platformArrayList = new ArrayList<>();
    private ArrayList<orc> orcArrayList = new ArrayList<>();
    private ArrayList<weapon> weaponArrayList = new ArrayList<>();
    private ArrayList<coins> coinsArrayList = new ArrayList<>();
    public Group Start() throws Exception {
        FileInputStream inp = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/backgroundwillhero.png");
        Image back = new Image(inp);
        ImageView imageV = new ImageView(back);
        imageV.setX(0);
        imageV.setY(0);
        imageV.setFitHeight(1080);
        imageV.setFitWidth(1920);
        imageV.setOpacity(1.0);
        imageV.setPreserveRatio(true);

        Rectangle trans = new Rectangle();
        trans.setFill(Color.BLACK);
        trans.setStroke(Color.TRANSPARENT);
        trans.setHeight(2);
        trans.setWidth(100);
        trans.setX(300);
        trans.setY(1070);
        trans.toFront();
        Group root = new Group(imageV);
        for(int i=0;i<200;i++){
            Random r = new Random();
            int choice=r.nextInt(3);
            while(choice==0){
                choice=r.nextInt(3);
            }
            int a=r.nextInt(1080);
            while(a<550 && a>120){
                a=r.nextInt(1080);
            }
            int d=r.nextInt(19200);
            int b=r.nextInt(500);
            while(b<250){
                b=r.nextInt(500);
            }
            double o=r.nextDouble(1.0);
            while(o<0.75){
                o=r.nextDouble(1.0);
            }
            int t=r.nextInt(100);
            while(t<50){
                t+=10;
            }
            clouds c = new clouds(d,a,b,b,o,t,choice);
            ImageView x=c.imageView;
            root.getChildren().add(x);
        }
        int d=300;
        int a=372;
        int choo=6;
        int choic=1;
        for(int j=0;j<98;j++){
            Random ra = new Random();
            int ch=ra.nextInt(4);
            while(ch==0){
                ch=ra.nextInt(4);
            }
            int rando=ra.nextInt(5);
            int rand=ra.nextInt(7);
            while(rand<5){
                rand=ra.nextInt(7);
            }
            int b=ra.nextInt(700);
            while(b<400){
                b=ra.nextInt(700);
            }
            int t=100;
            Random r = new Random();
            int cho=r.nextInt(7);
            while(cho==0){
                cho=r.nextInt(7);
            }
            orc o=new orc(d,a,choic,choo);
            platform p = new platform(d,a,t,choic);
            orcArrayList.add(o);
            platformArrayList.add(p);
            d+=rand*100;
            a+=rando;
            choic=ch;
            choo=cho;
            ImageView y=p.imageVie;
            Rectangle rec=p.plat;
            ImageView or=o.imageVie;
            Rectangle or_rec=o.orc_rectangle;
            if(j!=0 && j%10==0){
                weapon w=new weapon(d,a,choic);
                weaponArrayList.add(w);
                ImageView chestObj=w.chest;
                Rectangle chest2Rec=w.chest_Rectangle;
                root.getChildren().add(chestObj);
                root.getChildren().add(chest2Rec);
            }
            if(j!=0 && j%7==0 && j!=70){
                coins cash=new coins(d,a,choic);
                coinsArrayList.add(cash);
                ImageView cashObj=cash.coins;
                Rectangle cashRec=cash.coins_Rectangle;
                root.getChildren().add(cashObj);
                root.getChildren().add(cashRec);
                if(j==7){
                      Text cashCount=cash.howmuchcash;
                      root.getChildren().add(cashCount);
                }

            }
            root.getChildren().add(y);
            root.getChildren().add(rec);
            root.getChildren().add(or);
            root.getChildren().add(or_rec);
        }
        player p=new player();
        Text liveScore=p.t;
        root.getChildren().add(liveScore);
        Character chara = new Character();
        ImageView chIm = chara.imageView;
        Rectangle chrekt = chara.rekt;
        root.setOnMousePressed(new EventHandler() {
            @Override
            public void handle(Event event) {
                p.twoclicks++;
                if(p.twoclicks!=0 && p.twoclicks%2==0){
                    p.score++;
                    String s2=String.valueOf(p.score);
                    p.t.setText("score: "+s2);
                }
                for(int i=0;i<9;i++){
                    weaponArrayList.get(i).translateanimation();
                    weaponArrayList.get(i).chest.setX(weaponArrayList.get(i).chest.getX()-150);
                    weaponArrayList.get(i).translateanimation2();
                    weaponArrayList.get(i).chest_Rectangle.setX(weaponArrayList.get(i).chest_Rectangle.getX()-150);
                }
                for(int j=0; j<12; j++){
                    coinsArrayList.get(j).animation1();
                    coinsArrayList.get(j).coins.setX(coinsArrayList.get(j).coins.getX()-150);
                    coinsArrayList.get(j).coins_Rectangle.setX(coinsArrayList.get(j).coins_Rectangle.getX()-150);
                }
                for (int k = 0; k < 98; k++) {
                    platformArrayList.get(k).plat.setX(platformArrayList.get(k).plat.getX()-150);
                    platformArrayList.get(k).imageVie.setX(platformArrayList.get(k).imageVie.getX()-150);
                    platformArrayList.get(k).translateanimation();
                    platformArrayList.get(k).translateanimation2();
                    orcArrayList.get(k).translateanimation();
                    orcArrayList.get(k).translaterectanimation();
                    orcArrayList.get(k).imageVie.setX(orcArrayList.get(k).imageVie.getX()-150);
                    orcArrayList.get(k).orc_rectangle.setX(orcArrayList.get(k).orc_rectangle.getX()-150);
                }
            }
        });
        root.getChildren().add(chIm);
        root.getChildren().add(chrekt);
        chara.gravity();
        int k=0;
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                TranslateTransition move = new TranslateTransition();
                for(int i=0;i<98;i++){
                    if(orcArrayList.get(i).orc_rectangle.getBoundsInParent().intersects(platformArrayList.get(i).plat.getBoundsInParent())){
                        for (int j=0;j<98;j++) {
                            orcArrayList.get(i).stopgravity();
                            orcArrayList.get(i).trnaslatecharachterup();
                            orcArrayList.get(i).trnaslaterectangleup();
                            orcArrayList.get(i).rebound();
                            break;
                        }
                    }
                    else if(orcArrayList.get(i).rebound_y==0){
                        orcArrayList.get(i).gravity();
                    }
                }
                for(int k=0;k<98;k++){
                    if(chara.rekt.getBoundsInParent().intersects(platformArrayList.get(k).plat.getBoundsInParent()) ){
                        chara.stopgravity();
                        chara.trnaslaterectangleup();
                        chara.trnaslatecharachterup();
                        chara.rebound();
                        break;
                    }
                    else if(chara.rebound_y==0){
                        chara.gravity();
                    }
                    if(chara.rekt.getBoundsInParent().intersects(orcArrayList.get(k).orc_rectangle.getBoundsInParent())){
                        orcArrayList.get(k).orcIsHit();
                        orcArrayList.get(k).orcishitrekt();
                    }
                }
                for(int k=0;k<9;k++){
                    if(chara.rekt.getBoundsInParent().intersects(weaponArrayList.get(k).chest_Rectangle.getBoundsInParent())){
                        weaponArrayList.get(k).chest.setImage(weaponArrayList.get(k).c2);
                    }
                }
                for(int k=0;k<12;k++){
                    if(chara.rekt.getBoundsInParent().intersects(coinsArrayList.get(k).coins_Rectangle.getBoundsInParent())){
                        coinsArrayList.get(k).coins.setImage(coinsArrayList.get(k).c2);
                        if(coinsArrayList.get(0).updateStatus==0) {
                            coinsArrayList.get(0).updateCash(); //increment coins collected
                            System.out.println(coinsArrayList.get(0).count_coins);
                        }
                        String s1=String.valueOf(coinsArrayList.get(0).count_coins);
                        coinsArrayList.get(0).howmuchcash.setText("coins: "+s1);
                        break;
                    }
                }
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
        KeyFrame kf = new KeyFrame(Duration.seconds(0),
                event -> {
                    if(chara.rekt.getBoundsInParent().intersects(trans.getBoundsInParent())){
                        try {
                            Main.gameover(root);
                            fiveSecondsWonder.stop();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        fiveSecondsWonder.getKeyFrames().addAll(kf, new KeyFrame(Duration.millis(10)));
        return root;
    }
    class player{
        private int currentposition=0;
        private int score=0;
        private int coinsCollected;
        private int twoclicks=0;
        Text t;
        public player(){
                String s=String.valueOf(score);
                t=new Text();
                t.setText("score: " + s);
                t.setFont(Font.font ("Verdana", FontWeight.BOLD,100));
                t.setStroke(Color.BLACK);
                t.setFill(Color.WHITE);
                t.setX(800);
                t.setY(130);
        }
        public void updateScore(int counter){
        }
        private int coins=0;
        public int getCoins() {
            return coins;
        }
        public int getCurrentposition() {
            return currentposition;
        }
        public void setCoins(int coins) {
            this.coins = coins;
        }
        public void setCurrentposition(int currentposition) {
            this.currentposition = currentposition;
        }
    }
    class weponsinhand extends player{
    }
    class enemies{
    }
    class boss extends enemies{
    }
    class orc extends enemies{
        ImageView imageVie;
        TranslateTransition translatt;
        TranslateTransition transrectangle;
        TranslateTransition gravityorc =new TranslateTransition();
        TranslateTransition gravityorcRectangle=new TranslateTransition();
        int rebound_y=0;
        int X;
        int Y;
        Rectangle orc_rectangle;
        public void trnaslatecharachterup(){

            translatt = new TranslateTransition();
            translatt.setNode(imageVie);
            translatt.setDuration(Duration.millis(1000));
            translatt.setByY(-100);
            translatt.play();

        }
        public void trnaslaterectangleup(){
            translatt = new TranslateTransition();
            translatt.setNode(orc_rectangle);
            translatt.setDuration(Duration.millis(1000));
            translatt.setByY(-100);
            translatt.play();
        }
        public void gravity(){
            gravityorc.setNode(imageVie);
            gravityorcRectangle.setNode(orc_rectangle);
            gravityorc.setDuration(Duration.millis(8000));
            gravityorc.setByY(1000);
            gravityorc.play();
            gravityorcRectangle.setDuration(Duration.millis(8000));
            gravityorcRectangle.setByY(1000);
            gravityorcRectangle.play();
        }
        public void stopgravity(){
            gravityorc.stop();
            gravityorcRectangle.stop();
        }
        public void rebound(){
            rebound_y=1;
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1200), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    rebound_y=0;
                }
            }));
            fiveSecondsWonder.setCycleCount(1);
            fiveSecondsWonder.play();
        }
        public orc(int x, int y,int choice, int choo) throws FileNotFoundException {
            X=x;
            Y=y;
            if(choice==1){
                if(choo==1) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc1.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 66);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(75);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 66);
                    orc_rectangle.toFront();
                }
                if(choo==2) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc2.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 63);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(78);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 63);
                    orc_rectangle.toFront();
                }
                if(choo==3) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc3.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 63);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(78);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 63);
                    orc_rectangle.toFront();
                }
                if(choo==4) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc4.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 66);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(75);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 66);
                    orc_rectangle.toFront();
                }
                if(choo==5) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc5.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 68);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(73);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 68);
                    orc_rectangle.toFront();
                }
                if(choo==6) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/transparent(1).png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 141);
                    imageVie.setY(y + 66);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(75);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 141);
                    orc_rectangle.setY(y + 66);
                    orc_rectangle.toFront();
                }
            }
            if(choice==2){
                if(choo==1) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc1.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 115);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(75);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 115);
                    orc_rectangle.toFront();
                }
                if(choo==2) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc2.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 112);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(78);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 112);
                    orc_rectangle.toFront();
                }
                if(choo==3) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc3.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 112);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(78);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 112);
                    orc_rectangle.toFront();
                }
                if(choo==4) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc4.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 115);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(75);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 115);
                    orc_rectangle.toFront();
                }
                if(choo==5) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/Orc5.png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 117);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(73);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 117);
                    orc_rectangle.toFront();
                }
                if(choo==6) {
                    FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/transparent(1).png");
                    Image image = new Image(input);
                    imageVie = new ImageView(image);
                    imageVie.setX(x + 204);
                    imageVie.setY(y + 115);
                    imageVie.setFitWidth(80);
                    imageVie.setOpacity(1.0);
                    imageVie.setPreserveRatio(true);
                    imageVie.toFront();
                    orc_rectangle = new Rectangle();
                    orc_rectangle.setFill(Color.TRANSPARENT);
                    orc_rectangle.setStroke(Color.TRANSPARENT);
                    orc_rectangle.setHeight(73);
                    orc_rectangle.setWidth(80);
                    orc_rectangle.setX(x + 204);
                    orc_rectangle.setY(y + 115);
                    orc_rectangle.toFront();
                }
            }
            if(choice==3){
                FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/transparent(1).png");
                Image image = new Image(input);
                imageVie = new ImageView(image);
                imageVie.setX(x + 66);
                imageVie.setY(y + 15);
                imageVie.setFitWidth(80);
                imageVie.setOpacity(1.0);
                imageVie.setPreserveRatio(true);
                imageVie.toFront();
                orc_rectangle = new Rectangle();
                orc_rectangle.setFill(Color.TRANSPARENT);
                orc_rectangle.setStroke(Color.TRANSPARENT);
                orc_rectangle.setHeight(73);
                orc_rectangle.setWidth(80);
                orc_rectangle.setX(x + 204);
                orc_rectangle.setY(y + 117);
                orc_rectangle.toFront();
            }
        }
        public int getY() {
            return Y;
        }
        public void setX(int x) {
            X = x;
        }
        public int getX() {
            return X;
        }
        public void setY(int y) {
            Y = y;
        }
        public void translateanimation(){
            TranslateTransition translat = new TranslateTransition();
            translat.setNode(imageVie);
            translat.setDuration(Duration.millis(100));
            translat.setByX(-100);
            translat.play();
        }
        public void translaterectanimation(){
            TranslateTransition translat = new TranslateTransition();
            translat.setNode(orc_rectangle);
            translat.setDuration(Duration.millis(100));
            translat.setByX(-100);
            translat.play();
        }
        public void orcIsHit(){
            TranslateTransition translat=new TranslateTransition();
            translat.setNode(imageVie);
            translat.setDuration(Duration.millis(100));
            translat.setByX(100);
            translat.play();
        }
        public void orcishitrekt(){
            TranslateTransition translat = new TranslateTransition();
            translat.setNode(orc_rectangle);
            translat.setDuration(Duration.millis(100));
            translat.setByX(100);
            translat.play();
        }
    }
    class obstacles{
    }
    class fallingplatforms extends obstacles{
    }
    class chest{
    }
    class coin extends chest{
    }
    class coins{
        TranslateTransition move;
        TranslateTransition move2;
        int x;
        int y;
        int ch;
        int updateStatus=0;
        int count_coins=0;
        public void setX(int _x){
            x+=_x;
        }
        ImageView coins;
        Rectangle coins_Rectangle;
        private Image c;
        Text howmuchcash;
        FileInputStream input2 = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/transparent(1).png");
        Image c2 = new Image(input2);
        public coins(int _x,int _y, int choice) throws FileNotFoundException {
            x=_x;
            y=_y;
            ch=choice;
            FileInputStream input1 = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/coins.png");
            c=new Image(input1);
            howmuchcash = new Text();
            //Setting font to the text
            howmuchcash.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            //setting the position of the text
            howmuchcash.setX(50);
            howmuchcash.setY(130);
            howmuchcash.setStroke(Color.YELLOW);
            howmuchcash.setFill(Color.YELLOW);
            //Setting the text to be added.
            howmuchcash.setText("coins: "+Integer.toString(count_coins));
            howmuchcash.toFront();
            if(choice==1){
                coins=new ImageView(c);
                coins.setX(x + 213);
                coins.setY(y + 72);
                coins.setFitWidth(60);
                coins.setOpacity(1.0);
                coins.setPreserveRatio(true);
                coins.toFront();
                coins_Rectangle = new Rectangle();
                coins_Rectangle.setFill(Color.TRANSPARENT);
                coins_Rectangle.setStroke(Color.TRANSPARENT);
                coins_Rectangle.setHeight(71);
                coins_Rectangle.setWidth(60);
                coins_Rectangle.setX(x + 213);
                coins_Rectangle.setY(y + 72);
                coins_Rectangle.toFront();
            }
            if(choice==2){
                coins=new ImageView(c);
                coins.setX(x + 199);
                coins.setY(y + 121);
                coins.setFitWidth(60);
                coins.setOpacity(1.0);
                coins.setPreserveRatio(true);
                coins.toFront();
                coins_Rectangle = new Rectangle();
                coins_Rectangle.setFill(Color.TRANSPARENT);
                coins_Rectangle.setStroke(Color.TRANSPARENT);
                coins_Rectangle.setHeight(71);
                coins_Rectangle.setWidth(60);
                coins_Rectangle.setX(x + 199);
                coins_Rectangle.setY(y + 121);
                coins_Rectangle.toFront();
            }
            if(choice==3){
                coins=new ImageView(c);
                coins.setX(x + 20);
                coins.setY(y + 50);
                coins.setFitWidth(60);
                coins.setOpacity(1.0);
                coins.setPreserveRatio(true);
                coins.toFront();
                coins_Rectangle = new Rectangle();
                coins_Rectangle.setFill(Color.TRANSPARENT);
                coins_Rectangle.setStroke(Color.TRANSPARENT);
                coins_Rectangle.setHeight(71);
                coins_Rectangle.setWidth(60);
                coins_Rectangle.setX(x + 20);
                coins_Rectangle.setY(y + 50);
                coins_Rectangle.toFront();
            }
        }
        public void animation1(){
            move=new TranslateTransition();
            move.setNode(coins);
            move.setDuration(Duration.millis((100)));
            move.setByX(-100);
            move.play();
            move2=new TranslateTransition();
            move2.setNode(coins_Rectangle);
            move2.setDuration(Duration.millis((100)));
            move2.setByX(-100);
            move2.play();
        }
        public void updateCash(){
            updateStatus=1;
            count_coins+=10;
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    updateStatus=0;
                }
            }));
            fiveSecondsWonder.setCycleCount(1);
            fiveSecondsWonder.play();
        }
    }
    class weapon extends chest{
        TranslateTransition move;
        ImageView chest;
        Rectangle chest_Rectangle;
        Image c;
        FileInputStream input2 = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/ChestOpen.png");
        Image c2= new Image(input2) ;
        boolean chest_open_status=false;
        int x;
        int y;
        int ch;
        public weapon(int _x,int _y, int choice) throws FileNotFoundException {
            x = _x;
            y = _y;
            ch = choice;
            FileInputStream input1 = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/ChestClosed.png");
            c = new Image(input1);
            if (choice == 1) {
                chest = new ImageView(c);
                chest.setX(x + 213);
                chest.setY(y + 72);
                chest.setFitWidth(100);
                chest.setOpacity(1.0);
                chest.setPreserveRatio(true);
                chest.toFront();
                chest_Rectangle = new Rectangle();
                chest_Rectangle.setFill(Color.TRANSPARENT);
                chest_Rectangle.setStroke(Color.TRANSPARENT);
                chest_Rectangle.setHeight(71);
                chest_Rectangle.setWidth(100);
                chest_Rectangle.setX(x + 213);
                chest_Rectangle.setY(y + 72);
                chest_Rectangle.toFront();
            }
            if (choice == 2) {
                chest = new ImageView(c);
                chest.setX(x + 199);
                chest.setY(y + 121);
                chest.setFitWidth(100);
                chest.setOpacity(1.0);
                chest.setPreserveRatio(true);
                chest.toFront();
                chest_Rectangle = new Rectangle();
                chest_Rectangle.setFill(Color.TRANSPARENT);
                chest_Rectangle.setStroke(Color.TRANSPARENT);
                chest_Rectangle.setHeight(71);
                chest_Rectangle.setWidth(100);
                chest_Rectangle.setX(x + 199);
                chest_Rectangle.setY(y + 121);
                chest_Rectangle.toFront();
            }
            if (choice == 3) {
                chest = new ImageView(c);
                chest.setX(x + 20);
                chest.setY(y + 50);
                chest.setFitWidth(100);
                chest.setOpacity(1.0);
                chest.setPreserveRatio(true);
                chest.toFront();
                chest_Rectangle = new Rectangle();
                chest_Rectangle.setFill(Color.TRANSPARENT);
                chest_Rectangle.setStroke(Color.TRANSPARENT);
                chest_Rectangle.setHeight(71);
                chest_Rectangle.setWidth(100);
                chest_Rectangle.setX(x + 20);
                chest_Rectangle.setY(y + 50);
                chest_Rectangle.toFront();
            }
        }
        public void translateanimation(){
            move=new TranslateTransition();
            move.setNode(chest);
            move.setDuration(Duration.millis((100)));
            move.setByX(-100);
            move.play();
        }
        public void translateanimation2(){
            move=new TranslateTransition();
            move.setNode(chest_Rectangle);
            move.setDuration(Duration.millis((100)));
            move.setByX(-100);
            move.play();
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        }
    }
    class Character{
        ImageView imageView;
        private int currentposition=150;
        Rectangle rekt;
        int y;
        int score;
        TranslateTransition translatt;
        int rebound_y=0;
        boolean temp;
        boolean temp2;
        TranslateTransition gravityCharacter =new TranslateTransition();
        TranslateTransition gravityCharRectangle=new TranslateTransition();
        TranslateTransition gravityCharacter1 =new TranslateTransition();
        TranslateTransition gravityCharRectangle1=new TranslateTransition();
        public void setCurrentposition(int currentposition) {
            this.currentposition = currentposition;
        }
        public Character() throws FileNotFoundException {
            FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/character.png");
            Image image = new Image(input);
            imageView = new ImageView(image);
            imageView.setX(300);
            imageView.setY(372);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setOpacity(1.0);
            imageView.setPreserveRatio(true);
            imageView.toFront();
            rekt = new Rectangle();
            rekt.setFill(Color.TRANSPARENT);
            rekt.setStroke(Color.TRANSPARENT);
            rekt.setHeight(62.8);
            rekt.setWidth(100);
            rekt.setX(300);
            rekt.setY(372);
            rekt.toFront();
        }
        public void trnaslatecharachterup(){
            translatt = new TranslateTransition();
            translatt.setNode(imageView);
            translatt.setDuration(Duration.millis(1000));
            translatt.setByY(-100);
            translatt.play();
        }
        public void translatecharachterdown(){
            translatt = new TranslateTransition();
            translatt.setNode(imageView);
            translatt.setDuration(Duration.millis(20000));
            translatt.setByY(10000);
            translatt.play();
        }
        public void trnaslaterectangleup(){
            translatt = new TranslateTransition();
            translatt.setNode(rekt);
            translatt.setDuration(Duration.millis(1000));
            translatt.setByY(-100);
            translatt.play();
        }
        public void translaterectangledown(){
            translatt = new TranslateTransition();
            translatt.setNode(rekt);
            translatt.setDuration(Duration.millis(20000));
            translatt.setByY(10000);
            translatt.play();
        }
        public void gravity(){
            gravityCharacter.setNode(imageView);
            gravityCharRectangle.setNode(rekt);
            gravityCharacter.setDuration(Duration.millis(10000));
            gravityCharacter.setByY(1000);
            gravityCharacter.play();
            gravityCharRectangle.setDuration(Duration.millis(10000));
            gravityCharRectangle.setByY(1000);
            gravityCharRectangle.play();
        }
        public void stopgravity(){
            gravityCharacter.stop();
            gravityCharRectangle.stop();
        }
        public void rebound(){
            rebound_y=1;
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    rebound_y=0;
                }
            }));
            fiveSecondsWonder.setCycleCount(1);
            fiveSecondsWonder.play();
        }
    }
    class platform{
        ImageView imageVie;
        private int choic;
        Rectangle plat;
        int position;
        public int getChoic() {
            return choic;
        }
        public void setX(int x) {
            X+= x;
        }
        private int X;
        private int Y;
        public int getX() {
            return X;
        }
        public int getY() {
            return Y;
        }
        public platform(int x, int y, int time, int choice) throws FileNotFoundException {
            choic=choice;
            X=x;
            Y=y;
            if(choice==1){
                FileInputStream inpu = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/platform1.png");
                Image imag = new Image(inpu);
                imageVie = new ImageView(imag);
                imageVie.setX(x);
                imageVie.setY(y);
                imageVie.setFitWidth(400);
                imageVie.setPreserveRatio(true);
                imageVie.toBack();
                plat = new Rectangle();
                plat.setFill(Color.TRANSPARENT);
                plat.setStroke(Color.TRANSPARENT);
                plat.setHeight(112);
                plat.setWidth(400);
                plat.setX(x);
                plat.setY(y+140);
                plat.toFront();
            }
            else if(choice==2){
                FileInputStream inpu = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/platform2.png");
                Image imag = new Image(inpu);
                imageVie = new ImageView(imag);
                imageVie.setX(x);
                imageVie.setY(y);
                imageVie.setFitWidth(400);
                imageVie.setPreserveRatio(true);
                imageVie.toBack();
                plat = new Rectangle();
                plat.setFill(Color.TRANSPARENT);
                plat.setStroke(Color.TRANSPARENT);
                plat.setHeight(106);
                plat.setWidth(400);
                plat.setX(x);
                plat.setY(y+190);
                plat.toFront();
            }
            else{
                FileInputStream inpu = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/platform3.png");
                Image imag = new Image(inpu);
                imageVie = new ImageView(imag);
                imageVie.setX(x);
                imageVie.setY(y);
                imageVie.setFitWidth(200);
                imageVie.setPreserveRatio(true);
                imageVie.toBack();
                plat = new Rectangle();
                plat.setFill(Color.TRANSPARENT);
                plat.setStroke(Color.TRANSPARENT);
                plat.setHeight(93);
                plat.setWidth(200);
                plat.setX(x);
                plat.setY(y+119);
                plat.toFront();
            }
        }
        public void translateanimation(){
            TranslateTransition translat = new TranslateTransition();
            translat.setNode(imageVie);
            translat.setDuration(Duration.millis(100));
            translat.setByX(-100);
            translat.play();
        }
        public void translateanimation2(){
            TranslateTransition translat = new TranslateTransition();
            translat.setNode(plat);
            translat.setDuration(Duration.millis(100));
            translat.setByX(-100);
            translat.play();
        }
    }
    class clouds{
        ImageView imageView;
        public clouds(int x,int y,int height,int width,double opacity,int time,int choice) throws FileNotFoundException {
            if(choice==1){
                FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/cloud.png");
                Image image = new Image(input);
                imageView = new ImageView(image);
                imageView.setX(x);
                imageView.setY(y);
                imageView.setFitHeight(height);
                imageView.setFitWidth(width);
                imageView.setOpacity(opacity);
                imageView.setPreserveRatio(true);
                imageView.toBack();
                TranslateTransition translatt = new TranslateTransition();
                translatt.setNode(imageView);
                translatt.setDuration(Duration.seconds(time));
                translatt.setByX(-20000);
                translatt.play();
            }
            if(choice==2){
                FileInputStream input = new FileInputStream("/Users/shashanksingh/IdeaProjects/hellooooo/src/sample/cloud2.png");
                Image image = new Image(input);
                imageView = new ImageView(image);
                imageView.setX(x);
                imageView.setY(y);
                imageView.setFitHeight(height);
                imageView.setFitWidth(width);
                imageView.setOpacity(opacity);
                imageView.setPreserveRatio(true);
                imageView.toBack();
                TranslateTransition translatt = new TranslateTransition();
                translatt.setNode(imageView);
                translatt.setDuration(Duration.seconds(time));
                translatt.setByX(-20000);
                translatt.play();
            }
        }
    }