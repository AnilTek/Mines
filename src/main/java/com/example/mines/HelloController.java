package com.example.mines;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashSet;
import java.util.Random;


public class HelloController {
    MediaPlayer mediaPlayer;
    Media media;
    MediaPlayer mediaPlayer1;
    Media media1;
    MediaPlayer mediaPlayer2;
    Media media2;
    MediaPlayer mediaPlayer3;
    Media media3;
    MediaPlayer mediaPlayer4;
    Media media4;
    Stage stage;
    public AnchorPane scenePane;
    @FXML
    private Label welcomeText;
    public Button randombutton;
    public Button cashoutmoney;
    public TextField betfield;
    public Text balance1;
    public Text cashmulti;

    public Button bir;
    public Button iki;
    public Button uc;
    public Button dort;
    public Button bes;
    public Button alti;
    public Button yedi;
    public Button sekiz;
    public Button dokuz;
    public Button on;
    public Button onbir;
    public Button oniki;
    public Button onuc;
    public Button ondort;
    public Button onbes;
    public Button onalti;
    public Button onyedi;
    public Button onsekiz;
    public Button ondokuz;
    public Button yirmi;
    public Button yirmibir;
    public Button yirmiiki;
    public Button yirmiuc;
    public Button yirmidort;
    public Button yirmibes;
    public Button lowbutton;
    public Button midbutton;
    public Button highbutton;
    public Button topbutton;
    Random random = new Random();
    int num1;
    int num2;
    int num3;
    float boxLeft = 25F;
    int lowRiskMines=3;
    int midRiskMines=6;

    int highRiskMines=9;
    int topRiskMines= 12;
    boolean lowWorking=true;
    boolean midWorking=true;
    boolean highWorking=true;
    boolean topWorking=true;
    HashSet<Integer> numberList = new HashSet<Integer>();










    float totalMulti=1F;
    int balance=1000;
    int bet;
    float cashOut;

    public void LowRiskMines(){
        ClickSound();
        numberList.clear();
        DisableLow();
        randombutton.setDisable(false);
        while (!(numberList.size()==3)){
            numberList.add((random.nextInt(1,26)));
            System.out.println(numberList);
        }
        System.out.println(numberList);
         lowWorking=true;
         midWorking=false;
         highWorking=false;
         topWorking=false;

    }
    public void MidRiskMines(){
        ClickSound();
        numberList.clear();
        DisableMid();
        randombutton.setDisable(false);
        while (!(numberList.size()==6)){
            numberList.add((random.nextInt(1,26)));
            System.out.println(numberList);
        }
        System.out.println(numberList);
         lowWorking=false;
         midWorking=true;
         highWorking=false;
         topWorking=false;

    }
    public void HighRiskMines(){
        ClickSound();
        numberList.clear();
        DisableHigh();
        randombutton.setDisable(false);
        while (!(numberList.size()==9)){
            numberList.add((random.nextInt(1,26)));
            System.out.println(numberList);
        }
        System.out.println(numberList);
         lowWorking=false;
         midWorking=false;
         highWorking=true;
         topWorking=false;

    }
    public void TopRiskMines(){
        ClickSound();
        numberList.clear();
        DisableTop();
        randombutton.setDisable(false);
        while (!(numberList.size()==12)){
            numberList.add((random.nextInt(1,26)));
            System.out.println(numberList);

        }
        System.out.println(numberList);
        lowWorking=false;
        midWorking=false;
        highWorking=false;
        topWorking=true;

    }
    public void BalanceShow(){
        balance1.setText((String.valueOf("Balance: "+balance+"$")));
    }
    public void DiamondSound(){
        String fileName = "SoundEffectD.mp3";
        String path = getClass().getResource(fileName).getPath();
        System.out.println(path);
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }
    public void DiamondSound2(){
        String fileName1 = "DiamondsScream.mp3";
        String path1 = getClass().getResource(fileName1).getPath();
        System.out.println(path1);
        media1 = new Media(new File(path1).toURI().toString());
        mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.play();
    }
    public void Ugh(){
        String fileName2 = "UGH.mp3";
        String path2 = getClass().getResource(fileName2).getPath();
        System.out.println(path2);
        media2 = new Media(new File(path2).toURI().toString());
        mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.play();
    }
    public void CashOutSound(){
        String fileName3 = "CashoutSound.mp3";
        String path3 = getClass().getResource(fileName3).getPath();
        System.out.println(path3);
        media3 = new Media(new File(path3).toURI().toString());
        mediaPlayer3 = new MediaPlayer(media3);
        mediaPlayer3.play();
    }
    public void ClickSound(){
        String fileName4 = "MouseClick.mp3";
        String path4 = getClass().getResource(fileName4).getPath();
        System.out.println(path4);
        media4 = new Media(new File(path4).toURI().toString());
        mediaPlayer4 = new MediaPlayer(media4);
        mediaPlayer4.play();
    }

    public void CashOut(){
        CashOutSound();
        balance+= bet*totalMulti;
        balance1.setText(String.valueOf("Balance:"+balance+" $"));
        System.out.println(balance);
        DisableButtons();
        bet=0;
        totalMulti=1F;
        System.out.println("ÇALIŞIYOR");
        System.out.println(balance);
        ResetIcons();
        randombutton.setDisable(false);
        boxLeft=25;
        totalMulti=1f;
        cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
        cashoutmoney.setText(String.valueOf(0+" $"));
        randombutton.setDisable(true);
        midbutton.setDisable(false);
        highbutton.setDisable(false);
        lowbutton.setDisable(false);
        topbutton.setDisable(false);

    }
    public void CashoutCalc(){
        if (lowWorking){
            totalMulti *= (float) (boxLeft/(boxLeft-lowRiskMines));
        } else if (midWorking) {
            totalMulti *= (float) (boxLeft/(boxLeft-midRiskMines));
        } else if (highWorking) {
            totalMulti *= (float) (boxLeft/(boxLeft-highRiskMines));
        } else if (topWorking) {
            totalMulti *= (float) (boxLeft/(boxLeft-topRiskMines));

        }

        cashOut = totalMulti*bet;
        System.out.println(bet);
        System.out.println(cashOut);
        System.out.println(totalMulti);
        System.out.println(boxLeft);
        cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
        cashoutmoney.setText(String.valueOf(cashOut+" $"));

    }


    public void RandomMineSelector(){
        bet = Integer.parseInt(betfield.getText());
        if (balance<=0){
            stage=(Stage)scenePane.getScene().getWindow();
            Alert exit = new Alert(Alert.AlertType.WARNING);
            exit.setTitle("UYARI!");
            exit.setContentText("Maalesef battın");
            exit.showAndWait();
            stage.close();
        }else if(bet>balance){
            stage=(Stage)scenePane.getScene().getWindow();
            Alert er = new Alert(Alert.AlertType.WARNING);
            er.setTitle("UYARI!");
            er.setContentText("Oynadığınız bahis bakiyenizde bulunmamaktadır");
            er.showAndWait();


        }else{
        System.out.println(bet);
        randombutton.setDisable(true);
        balance-=bet;
        balance1.setText(String.valueOf("Balance:"+balance+" $"));
        EnableButtons();
        }





    }

    @FXML
    public void Button() throws InterruptedException {
        if (numberList.contains(1)){
            bir.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();


        } else {
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
            bir.setDisable(true);
            bir.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();


        }



    }
    public void Button2(){
        if (numberList.contains(2)){
            iki.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else {
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
            iki.setDisable(true);
            iki.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();
        }

    }
    public void Button3(){
        if (numberList.contains(3)){
            uc.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else {
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
            uc.setDisable(true);
            uc.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();
        }


    }
    public void Button4(){
        if (numberList.contains(4)){
            dort.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();

        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        dort.setDisable(true);
        dort.setText("\uD83D\uDC8E");
        boxLeft--;
        CashoutCalc();
        }

    }
    public void Button5(){
        if (numberList.contains(5)){
            bes.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
            bes.setDisable(true);
            bes.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();
        }


    }
    public void Button6(){
        if (numberList.contains(6)){
            alti.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        alti.setDisable(true);
        alti.setText("\uD83D\uDC8E");
        boxLeft--;
        CashoutCalc();
        }

    }
    public void Button7(){
        if (numberList.contains(7)){
            yedi.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yedi.setDisable(true);
        yedi.setText("\uD83D\uDC8E");
        boxLeft--;
        System.out.println(boxLeft);
        CashoutCalc();}

    }
    public void Button8(){
        if (numberList.contains(8)){
            sekiz.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        sekiz.setDisable(true);
        sekiz.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button9(){
        if (numberList.contains(9)){
            dokuz.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        dokuz.setDisable(true);
        dokuz.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button10(){
        if (numberList.contains(10)){
            on.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        on.setDisable(true);
        on.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button11(){
        if (numberList.contains(11)){
            onbir.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onbir.setDisable(true);
        onbir.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button12(){
        if (numberList.contains(12)){
            oniki.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        oniki.setDisable(true);
        oniki.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button13(){
        if (numberList.contains(13)){
            onuc.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onuc.setDisable(true);
        onuc.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button14(){
        if (numberList.contains(14)){
            ondort.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        ondort.setDisable(true);
        ondort.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button15(){
        if (numberList.contains(15)){
            onbes.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onbes.setDisable(true);
        onbes.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button16(){
        if (numberList.contains(16)){
            onalti.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onalti.setDisable(true);
        onalti.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button17(){
        if (numberList.contains(17)){
            onyedi.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onyedi.setDisable(true);
        onyedi.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button18(){
        if (numberList.contains(18)){
            onsekiz.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        onsekiz.setDisable(true);
        onsekiz.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button19(){
        if (numberList.contains(19)){
            ondokuz.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        ondokuz.setDisable(true);
        ondokuz.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button20(){
        if (numberList.contains(20)){
            yirmi.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yirmi.setDisable(true);
        yirmi.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button21(){
        if (numberList.contains(21)){
            yirmibir.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yirmibir.setDisable(true);
        yirmibir.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button22(){
        if (numberList.contains(22)){
            yirmiiki.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yirmiiki.setDisable(true);
        yirmiiki.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button23(){
        if (numberList.contains(23)){
            yirmiuc.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();

        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
            yirmiuc.setDisable(true);
        yirmiuc.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button24(){
        if (numberList.contains(24)){
            yirmidort.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yirmidort.setDisable(true);
        yirmidort.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void Button25(){
        if (numberList.contains(25)){
            yirmibes.setText("\uD83D\uDCA3");
            System.out.println("You Have Lost!!!");
            Ugh();
            BalanceShow();
            randombutton.setDisable(false);
            DisableButtons();
            ResetIcons();
            boxLeft=25;
            totalMulti=1f;
            cashmulti.setText(String.valueOf("MULTP-> X "+totalMulti));
            cashoutmoney.setText(String.valueOf(0+" $"));
            randombutton.setDisable(true);
            lowbutton.setDisable(false);
            midbutton.setDisable(false);
            highbutton.setDisable(false);
            topbutton.setDisable(false);
            numberList.clear();
        }else{
            if (boxLeft>12){
                DiamondSound();
            }else{
                DiamondSound2();
            }
        yirmibes.setDisable(true);
        yirmibes.setText("\uD83D\uDC8E");
            boxLeft--;
            CashoutCalc();}

    }
    public void EnableButtons(){
        bir.setDisable(false);
        iki.setDisable(false);
        uc.setDisable(false);
        dort.setDisable(false);
        bes.setDisable(false);
        alti.setDisable(false);
        yedi.setDisable(false);
        sekiz.setDisable(false);
        dokuz.setDisable(false);
        on.setDisable(false);
        onbir.setDisable(false);
        oniki.setDisable(false);
        onuc.setDisable(false);
        ondort.setDisable(false);
        onbes.setDisable(false);
        onalti.setDisable(false);
        onyedi.setDisable(false);
        onsekiz.setDisable(false);
        ondokuz.setDisable(false);
        yirmi.setDisable(false);
        yirmibir.setDisable(false);
        yirmiiki.setDisable(false);
        yirmiuc.setDisable(false);
        yirmidort.setDisable(false);
        yirmibes.setDisable(false);
    }
    public void DisableButtons(){
        bir.setDisable(true);
        iki.setDisable(true);
        uc.setDisable(true);
        dort.setDisable(true);
        bes.setDisable(true);
        alti.setDisable(true);
        yedi.setDisable(true);
        sekiz.setDisable(true);
        dokuz.setDisable(true);
        on.setDisable(true);
        onbir.setDisable(true);
        oniki.setDisable(true);
        onuc.setDisable(true);
        ondort.setDisable(true);
        onbes.setDisable(true);
        onalti.setDisable(true);
        onyedi.setDisable(true);
        onsekiz.setDisable(true);
        ondokuz.setDisable(true);
        yirmi.setDisable(true);
        yirmibir.setDisable(true);
        yirmiiki.setDisable(true);
        yirmiuc.setDisable(true);
        yirmidort.setDisable(true);
        yirmibes.setDisable(true);
    }
    public void ResetIcons(){
        bir.setText("?");
        iki.setText("?");
        uc.setText("?");
        dort.setText("?");
        bes.setText("?");
        alti.setText("?");
        yedi.setText("?");
        sekiz.setText("?");
        dokuz.setText("?");
        on.setText("?");
        onbir.setText("?");
        oniki.setText("?");
        onuc.setText("?");
        ondort.setText("?");
        onbes.setText("?");
        onalti.setText("?");
        onyedi.setText("?");
        onsekiz.setText("?");
        ondokuz.setText("?");
        yirmi.setText("?");
        yirmibir.setText("?");
        yirmiiki.setText("?");
        yirmiuc.setText("?");
        yirmidort.setText("?");
        yirmibes.setText("?");
    }

    public void DisableLow(){
        lowbutton.setDisable(true);
        midbutton.setDisable(false);
        highbutton.setDisable(false);
        topbutton.setDisable(false);

    }
    public void DisableMid(){
        lowbutton.setDisable(false);
        midbutton.setDisable(true);
        highbutton.setDisable(false);
        topbutton.setDisable(false);
    }
    public void DisableHigh(){
        lowbutton.setDisable(false);
        midbutton.setDisable(false);
        highbutton.setDisable(true);
        topbutton.setDisable(false);
    }
    public void DisableTop(){
        lowbutton.setDisable(false);
        midbutton.setDisable(false);
        highbutton.setDisable(false);
        topbutton.setDisable(true);
    }

}