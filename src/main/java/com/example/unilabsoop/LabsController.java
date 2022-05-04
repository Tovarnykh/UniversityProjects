package com.example.unilabsoop;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LabsController {
    @FXML
    AnchorPane mainpage;
    @FXML
    BorderPane borderpane;
    //-------------------- 1l
    @FXML
    TextField xtextfieldlab1;
    @FXML
    TextField ktextareal1;
    @FXML
    TextField rtextareal1;
    @FXML
    TextArea ansarea1;
    @FXML
    protected void onLab1ButtonClick() {
        try{
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
            double x = Double.parseDouble(xtextfieldlab1.getText());
            double a = (2/x) + Math.pow(x,2);
            double b = Math.log10((Math.pow(x,2))-4*x);
            double c = Math.tan(x) - 2*Math.sin(x);
            double h = (Math.pow(a,3))+((Math.pow(b,3))-c);
            ansarea1.setText("h = "+h+";\na = "+a+";\nb = "+b+";\nc= "+c+";");}
            else if(group.getSelectedToggle()==tougle2){
                double k = Double.parseDouble(ktextareal1.getText());
                double r =Double.parseDouble(rtextareal1.getText());
                double ans = 2*r*Math.sin(k);
                ansarea1.setText("2*R*sin(x) = "+ans*(-1));
            }
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    //-------------------- 2l

    @FXML
    TextArea ansarea2;
    @FXML
    TextField atextfieldl2;
    @FXML
    TextField btextfieldl2;
    @FXML
    TextField ctextfieldl2;
    @FXML
    protected void onLab2ButtonClick() {
        try{
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
                int a = Integer.parseInt(atextfieldl2.getText());
                int c = Integer.parseInt(btextfieldl2.getText());
                int b = Integer.parseInt(ctextfieldl2.getText());
                int d = (int) (Math.pow(b,2)-(4*a*c));
                if(d>0){
                    int x1,x2;
                    x1 = (int) ((-b+Math.sqrt(d))/2*a);
                    x2 = (int) ((-b-Math.sqrt(d))/2*a);
                    ansarea2.setText("x1: "+x1+"\nx2: "+x2);
                }else{
                    ansarea2.setText("D вийшло не більше 0");
                }
            }else if(group.getSelectedToggle()==tougle2){
                double k = (0.273*Math.log10(5))*1.13*Math.log10(3),p=Math.atan(Math.sin(0.75))*Math.log(Math.sqrt(3)),l=((7*k)-(5*p))/(Math.abs(k-p));
                ansarea2.setText("Відповідь на завданя №2 - "+l);
            }
        }catch (Exception event){
            ansarea2.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //-------------------- l3
    @FXML
    TextField xtextarealab3;
    @FXML
    TextField ytextarealab3;
    @FXML
    TextField textarealab3;
    @FXML
    TextArea ansarea31;
    @FXML
    ToggleGroup group = new ToggleGroup();
    @FXML
    RadioButton tougle1;
    @FXML
    RadioButton tougle2;
    @FXML
    protected void onLab3Button1Click(){
        try {
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){


            int x = Integer.parseInt(xtextarealab3.getText());
            int y = Integer.parseInt(ytextarealab3.getText());
            int sum=0;
            String text1 = "Згенерований перший масив:\n";

            int[][] mass1 = new int[x][y];
            int[][] mass2 = new int[x][y];
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    mass1[j][i]= (int) (Math.random()*10);
                    text1 = text1+""+mass1[j][i]+" ";
                }
                    text1 = text1+"\n";
            }
            String text2 = text1+"Змінений масив:\n";
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    mass2[j][i]= mass1[j][i]/mass1[1][0];
                    sum = (int) (sum+ Math.pow(mass2[j][i],2));
                    text2 = text2+""+mass2[j][i]+" ";
                }
                text2 = text2+"\n";
            }
            text2=text2+"Сума квадратів елементів отриманого масиву - "+sum;
            ansarea31.setText(text2);}else if(group.getSelectedToggle()==tougle2){
                ansarea31.setText(""+textarealab3.getText().length());
            }
        }catch (Exception event){
            ansarea31.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //--------------------l4
    @FXML
    TextField atextfield4;
    @FXML
    TextField btextfield4;
    @FXML
    TextField mtextfield4;
    @FXML
    TextField ntextfield4;
    @FXML
    TextArea ansarea4;
    @FXML
    protected void onLab4Button1Click(){
        try {
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
                int a = Integer.parseInt(atextfield4.getText());
                int b = Integer.parseInt(btextfield4.getText());
                if(((a%2)==0)&&((b%2)==0)){
                    ansarea4.setText("Так як a i b - парні, відповідь: a+b="+(a+b));
                }
                else if(((a%2)!=0)&&((b%2)!=0)){
                    ansarea4.setText("Так як a i b - не парні, відповідь: a-b="+(a-b));
                }else {
                    ansarea4.setText("Так як a i b - парні і не парні, відповідь: a*b="+(a*b));
                }
            }else if(group.getSelectedToggle()==tougle2){
                int m = Integer.parseInt(mtextfield4.getText());
                int n = Integer.parseInt(ntextfield4.getText());
                int sum1 =0, sum2=0;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        sum2=sum2+(2*i+j);
                    }
                    sum1=sum1+sum2;
                    sum2=0;
                }
                ansarea4.setText("Знайдена сума= "+sum1);
            }
        }catch (Exception event){
            ansarea4.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //-------------------- l5_1
    @FXML
    TextField cxtextfieldl5_1;
    @FXML
    TextField cytextfieldl5_1;
    @FXML
    TextField xtextfieldl5_1;
    @FXML
    TextField ytextfieldl5_1;
    @FXML
    TextField ntextfieldl5_1;
    @FXML
    TextArea ansarea5_1;
    @FXML
    Label masstipelabel_lab5_1;
    @FXML
    protected void onLab5_1RadioButtonClick(){
        try {
            masstipelabel_lab5_1.setText("");
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
                cytextfieldl5_1.setPromptText("Не потрібно");
                ytextfieldl5_1.setPromptText("Не потрібно");
            }else if(group.getSelectedToggle()==tougle2) {
                cytextfieldl5_1.setPromptText("Кількість рядків");
                ytextfieldl5_1.setPromptText("Індекс y");
            }
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    int xarr,yarr;
    @FXML
    protected void onLab5_1ButtonCreateClick(){
        try {
            masstipelabel_lab5_1.setText("");
            if(group.getSelectedToggle()==tougle1){
                int x = Integer.parseInt(cxtextfieldl5_1.getText());
                int mass[] = new int [x];
                String text="";
                for(int i = 0; i<x;i++){
                    mass[i]= (int) (Math.random()*100);
                    text = text + mass[i]+" ";
                }
                ansarea5_1.setText(text);
            }else if(group.getSelectedToggle()==tougle2){
                ansarea5_1.appendText("");
                xarr = Integer.parseInt(cxtextfieldl5_1.getText());
                yarr = Integer.parseInt(cytextfieldl5_1.getText());
                int x = Integer.parseInt(cxtextfieldl5_1.getText());
                int y = Integer.parseInt(cytextfieldl5_1.getText());
                int mass[][] = new int [x][y];
                String text="";
                for(int i = 0; i<y;i++){
                    for(int j = 0; j<x;j++){
                        mass[j][i]= (int) (Math.random()*100);
                        text = text + mass[j][i]+" ";
                    }
                    text = text + "\n";
                }
                ansarea5_1.setText(text);
            }
        }catch (Exception event){
            ansarea5_1.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }

    @FXML
    protected void onLab5_1ButtonEditClick(){
        try {
            masstipelabel_lab5_1.setText("");
            if(group.getSelectedToggle()==tougle1){

                String text = ansarea5_1.getText();
                String[] numbers = text.split(" ");
                int[] mass = new int[numbers.length];
                for(int i = 0; i<mass.length;i++){
                    mass[i]=Integer.parseInt(numbers[i]);
                }
                mass[Integer.parseInt(xtextfieldl5_1.getText())]=Integer.parseInt(ntextfieldl5_1.getText());
                ansarea5_1.setText("");
                for(int i = 0; i<mass.length;i++){
                    ansarea5_1.appendText(mass[i]+" ");
                }
            }else if(group.getSelectedToggle()==tougle2){
                String text = ansarea5_1.getText(), line="";
                String[] lines = text.split("\n");
                for(int i =0;i< yarr;i++){
                    line = line + lines[i];
                }
                String[] numbers = line.split(" ");
                int[][] mass = new int[xarr][yarr];
                int inx=0;
                for(int i =0;i<yarr;i++){
                    for(int j=0;j<xarr;j++){
                        mass[j][i]=Integer.parseInt(numbers[inx]);
                        inx++;
                    }
                }
                mass[Integer.parseInt(xtextfieldl5_1.getText())][Integer.parseInt(ytextfieldl5_1.getText())]=Integer.parseInt(ntextfieldl5_1.getText());
                ansarea5_1.setText("");
                for(int i =0;i<yarr;i++){
                    for(int j=0;j<xarr;j++){
                        ansarea5_1.appendText(mass[j][i]+" ");
                    }
                    ansarea5_1.appendText("\n");
                }
            }
        }catch (Exception event){
            ansarea5_1.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab5_1ButtonSortClick(){
        try {
            if(group.getSelectedToggle()==tougle1){
                masstipelabel_lab5_1.setText("Сортування алгоритмом Quick Sort");
                String text = ansarea5_1.getText();
                String[] numbers = text.split(" ");
                int[] mass = new int[numbers.length];
                for(int i = 0; i<mass.length;i++){
                    mass[i]=Integer.parseInt(numbers[i]);
                }
                LabsController obj = new LabsController();
                obj.quickSort(mass,0,mass.length-1);
                ansarea5_1.setText("");
                for(int i = 0; i<mass.length;i++){
                    ansarea5_1.appendText(mass[i]+" ");
                }
            }else if(group.getSelectedToggle()==tougle2){
                masstipelabel_lab5_1.setText("Сортування алгоритмом Selection Sort");
                String text = ansarea5_1.getText(), line="";
                String[] lines = text.split("\n");
                for(int i =0;i< yarr;i++){
                    line = line + lines[i];
                }
                String[] numbers = line.split(" ");
                int[][] mass = new int[xarr][yarr];
                int inx=0;
                for(int i =0;i<yarr;i++){
                    for(int j=0;j<xarr;j++){
                        mass[j][i]=Integer.parseInt(numbers[inx]);
                        inx++;
                    }
                }

                LabsController obj = new LabsController();
                obj.selectionSort(mass);

                ansarea5_1.setText("");
                for(int i =0;i<yarr;i++){
                    for(int j=0;j<xarr;j++){
                        ansarea5_1.appendText(mass[j][i]+" ");
                    }
                    ansarea5_1.appendText("\n");
                }
            }
        }catch (Exception event){
            ansarea5_1.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //-------------------- l5-2
    @FXML
    TextField entertextfieldl5_2;
    @FXML
    TextArea ansarea5_2;
    @FXML
    protected void onLab5_2ButtonCreateClick(){
        try {
                ansarea5_2.appendText("");
                xarr = Integer.parseInt(entertextfieldl5_2.getText());
                yarr = Integer.parseInt(entertextfieldl5_2.getText());
                int x = Integer.parseInt(entertextfieldl5_2.getText());
                int y = Integer.parseInt(entertextfieldl5_2.getText());
                int mass[][] = new int [x][y];
                String text="";
                for(int i = 0; i<y;i++){
                    for(int j = 0; j<x;j++){
                        mass[j][i]= (int) (Math.random()*100);
                        text = text + mass[j][i]+" ";
                    }
                    text = text + "\n";
                }
            ansarea5_2.setText(text);
        }catch (Exception event){
            ansarea5_2.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab5_2ButtonSortClick(){
        try {
            String text = ansarea5_2.getText(), line="";
            String[] lines = text.split("\n");
            for(int i =0;i< yarr;i++){
                line = line + lines[i];
            }
            String[] numbers = line.split(" ");
            int[][] mass = new int[xarr][yarr];
            int inx=0;
            for(int i =0;i<yarr;i++){
                for(int j=0;j<xarr;j++){
                    mass[j][i]=Integer.parseInt(numbers[inx]);
                    inx++;
                }
            }
            int p=1;
            while (p != 0)
            {
                p = 0;
                for (int i = 0; i < mass.length-1; i++)
                {
                    if (mass[i][i] < mass[i + 1][i + 1])
                    {
                        int key = mass[i][i];
                        mass[i][i] = mass[i + 1][i + 1];
                        mass[i + 1][i + 1] = key;
                        p++;
                    }
                }
            }
            ansarea5_2.setText("");
            for(int i =0;i<yarr;i++){
                for(int j=0;j<xarr;j++){
                    ansarea5_2.appendText(mass[j][i]+" ");
                }
                ansarea5_2.appendText("\n");
            }
        }catch (Exception event){
            ansarea5_2.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //-------------------- l6
    @FXML
    TextField atextfield6;
    @FXML
    TextField btextfield6;
    @FXML
    TextArea ansarea6;
    @FXML
    protected void onLab6ButtonClick(){
        try {
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
            String text = atextfield6.getText();
            String[] words = text.split(" ");
            ansarea6.setText("");
            for(int i=0;i< words.length;i++){
                for(int j =0;j<words[i].length();j++){
                    char tmpc = words[i].charAt(j);
                    if((tmpc=='2')||(tmpc=='4')||(tmpc=='6')||(tmpc=='8')||(tmpc=='с')||(tmpc=='С')||(tmpc=='ш')||(tmpc=='Ш')){
                        ansarea6.appendText(words[i]+" ");
                        break;
                    }
                }
            }

            }else if(group.getSelectedToggle()==tougle2){
                String text = btextfield6.getText();
                String[] words = text.split(", ");
                ansarea6.setText("");
                for(int i=0;i< words.length;i++){
                    if((words[i].indexOf('z')!=(-1))||(words[i].indexOf("yz")!=(-1))||(words[i].indexOf("xyz")!=(-1))){
                        ansarea6.appendText(words[i]+" ");
                    }
                }
        }
        }catch (Exception event){
            ansarea6.setText("Помилка вводу!");
            event.printStackTrace();
        }
    }
    //-------------------- l7
    @FXML
    Label label1lab7;
    @FXML
    Label label2lab7;
    @FXML
    Label label3lab7;
    @FXML
    Label label4lab7;
    @FXML
    Button bananabutton;
    @FXML
    Button applebutton;
    @FXML
    Button pearbutton;
    @FXML
    Button berrybutton;
    @FXML
    protected void onLab7ButtonBananaClick(){
        try {
            label1lab7.setText("Banana!");
            label1lab7.setTextFill(Color.color(0,1,1));
            label2lab7.setText("Banana!");
            label2lab7.setTextFill(Color.color(1,0,1));
            label3lab7.setText("Banana!");
            label3lab7.setTextFill(Color.color(1,1,0));
            label4lab7.setText("Banana!");
            label4lab7.setTextFill(Color.color(0,1,0));
            bananabutton.setText("Banana");
            applebutton.setText("Banana");
            pearbutton.setText("Banana");
            berrybutton.setText("Banana");
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab7ButtonAppleClick(){
        try {
            label1lab7.setText("Apple!");
            label1lab7.setTextFill(Color.color(0,1,0));
            label2lab7.setText("Apple!");
            label2lab7.setTextFill(Color.color(1,1,0));
            label3lab7.setText("Apple!");
            label3lab7.setTextFill(Color.color(1,0,1));
            label4lab7.setText("Apple!");
            label4lab7.setTextFill(Color.color(0,1,1));
            bananabutton.setText("Apple!");
            applebutton.setText("Apple!");
            pearbutton.setText("Apple!");
            berrybutton.setText("Apple!");
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab7ButtonPearClick(){
        try {
            label1lab7.setText("Pear!");
            label1lab7.setTextFill(Color.color(1,1,0));
            label2lab7.setText("Pear!");
            label2lab7.setTextFill(Color.color(0,1,0));
            label3lab7.setText("Pear!");
            label3lab7.setTextFill(Color.color(0,1,1));
            label4lab7.setText("Pear!");
            label4lab7.setTextFill(Color.color(1,0,1));
            bananabutton.setText("Pear!");
            applebutton.setText("Pear!");
            pearbutton.setText("Pear!");
            berrybutton.setText("Pear!");
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab7ButtonBerryClick(){
        try {
            label1lab7.setText("Berry!");
            label1lab7.setTextFill(Color.color(1,0,1));
            label2lab7.setText("Berry!");
            label2lab7.setTextFill(Color.color(0,1,1));
            label3lab7.setText("Berry!");
            label3lab7.setTextFill(Color.color(0,1,0));
            label4lab7.setText("Berry!");
            label4lab7.setTextFill(Color.color(1,1,0));
            bananabutton.setText("Berry!");
            applebutton.setText("Berry!");
            pearbutton.setText("Berry!");
            berrybutton.setText("Berry!");
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    //-------------------- l8
    @FXML
    TextField atextfield8;
    @FXML
    TextArea ansarea1l8;
    @FXML
    protected void onLab8ButtonSave1Click(){
        try {
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
            ansarea1l8.appendText(atextfield8.getText()+"\n");}
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    @FXML
    protected void onLab8ButtonClearClick(){
        try {
            tougle1.setToggleGroup(group);
            tougle2.setToggleGroup(group);
            if(group.getSelectedToggle()==tougle1){
            atextfield8.setText("");
            }
        }catch (Exception event){
            event.printStackTrace();
        }
    }

    private volatile boolean stop = true;
    @FXML
    Label time;
    @FXML
    Label time2;
    @FXML
    TextField timetextfield8;
    String newtime;
    @FXML
    protected void onLab8ButtonTimeChangeClick(){
        try {
            newtime = timetextfield8.getText();
            Thread thread = new Thread(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                stop = false;
                for(;;){try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    Platform.runLater(() -> {
                        time.setText(newtime);
                    });}
            });
            thread.start();
        }catch (Exception event){
            event.printStackTrace();}
    }
    private void Timenow(){
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            if(stop){
            for(;;){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){System.out.println(e);
                }
                String timenow = sdf.format(new Date());
                String datenow = sdf2.format(new Date());
                Platform.runLater(() -> {
                    time.setText(timenow);
                    time2.setText(datenow);
                });
            }}
        });
        thread.start();
    }

    @FXML
    TextField authorfield;
    @FXML
    TextField titlefield;
    @FXML
    TextField yearfield;
    @FXML
    TextField sectionfield;
    @FXML
    protected void loadTime(ActionEvent e){
        try {
            Timenow();
        }catch (Exception event){
            event.printStackTrace();
        }
    }
    //-------------------- l9
    String filename;
    File file;
    String[] autors = new String[10];
    String[] title = new String[10];
    int[] years = new int[10];
    String[] sections = new String[10];
    @FXML
    TextArea ans81;
    @FXML
    TextArea ans82;
    @FXML
    TextArea ans83;
    @FXML
    TextArea ans84;


    @FXML
    protected void FileOpenButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Откройте Файл");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(new Stage());
        filename=file.getAbsolutePath();
        String text="";
        boolean f = true;
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                if(f){
                    text = String.join("",text, scanner.nextLine());
                    f = false;
                }else{
                    text = String.join("\n",text, scanner.nextLine());
                }


            }
        String[] texts = text.split(";");
            String[] tmptexts = new String[4];
            for(int  i =0; i<texts.length;i++){
                tmptexts=texts[i].split("\n");
                    autors[i]=tmptexts[0];
                    ans81.appendText(autors[i]+"\n");
                    title[i] = tmptexts[1];
                ans82.appendText(title[i]+"\n");
                    years[i] = Integer.parseInt(tmptexts[2]);
                ans83.appendText(years[i]+"\n");
                    sections[i]= tmptexts[3];
                ans84.appendText(sections[i]+"\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void twoyearsButtonClick() {
        ans81.setText("");
        ans82.setText("");
        ans83.setText("");
        ans84.setText("");
        for(int i =0; i<years.length;i++){
            if((years[i]==(2021))||(years[i]==(2020))||(years[i]==(2019))){
                ans81.appendText(autors[i]+"\n");
                ans82.appendText(title[i]+"\n");
                ans83.appendText(years[i]+"\n");
                ans84.appendText(sections[i]+"\n");
            }
        }
    }
    @FXML
    TextField authorfield8;
    @FXML
    protected void searchButtonClick() {
        ans81.setText("");
        ans82.setText("");
        ans83.setText("");
        ans84.setText("");
        for(int i =0; i<autors.length;i++){
            if(autors[i]!=null){
            if(autors[i].equals(authorfield8.getText())){
                ans81.appendText(autors[i]+"\n");
                ans82.appendText(title[i]+"\n");
                ans83.appendText(years[i]+"\n");
                ans84.appendText(sections[i]+"\n");
            }}
        }
    }
    @FXML
    TextField vidanafteryearfield;
    @FXML
    TextField zadaiterozdilfield;
    @FXML
    protected void search2ButtonClick() {
        ans81.setText("");
        ans82.setText("");
        ans83.setText("");
        ans84.setText("");
        for(int i =0; i<autors.length;i++){
            if(sections[i]!=null){
                if((sections[i].equals(zadaiterozdilfield.getText()))&&(years[i]>Integer.parseInt(vidanafteryearfield.getText()))){
                    ans81.appendText(autors[i]+"\n");
                    ans82.appendText(title[i]+"\n");
                    ans83.appendText(years[i]+"\n");
                    ans84.appendText(sections[i]+"\n");
                }}
        }
    }
    //-------------------- Menu

    @FXML
    protected void onItemLab1Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab1.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab2Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab2.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab3Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab3.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab4Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab4.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab5_1Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab5.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab5_2Click(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab5-1.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab6(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab6.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }
    @FXML
    protected void onItemLab7(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab7.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();
    }

    @FXML
    protected void onItemLab8(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab8.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();

    }
    @FXML
    protected void onItemLab9(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab9.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();

    }
    @FXML
    protected void onCourseWork(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StartMenu.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();

    }
    @FXML
    protected void onExitAk(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginscreen.fxml"));
        Parent LabPage = loader.load();
        Scene LabScene = new Scene(LabPage);
        Stage window = (Stage) mainpage.getScene().getWindow();
        window.setScene(LabScene);
        window.show();

    }
    @FXML
    public void onCloseClicked(ActionEvent event){
        Platform.exit();

        System.exit(0);
    }
    //-----------------------
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
}
    public static void selectionSort(int[][] list) {

        for(int k = 0; k < list.length;k++){

            for(int i = 0; i < list[k].length;i++) {
                int currentMin = list[k][i];
                int currentMinIndexRow = k;
                int currentMinIndexColumn = i;

                if(k == 3 && i == 3) continue;

                for(int m = k; m < list.length; m++){
                    for (int j = i; j < list[k].length; j++) {
                        if (m == k && i == j) continue;

                        if (currentMin > list[m][j]) {
                            currentMin = list[m][j];
                            currentMinIndexRow = m;
                            currentMinIndexColumn = j;
                        }
                    }
                }
                if (currentMinIndexRow != k || currentMinIndexColumn != i) {
                    list[currentMinIndexRow][currentMinIndexColumn] = list[k][i];
                    list[k][i] = currentMin;
                }


            }
}}
    //-----------------------------------------------------------------------------
    @FXML private TableView<Museum> tableView;
    @FXML private TableColumn<Museum, String> nameColumn;
    @FXML private TableColumn<Museum, String> cityColumn;
    @FXML private TableColumn<Museum, String> adressColumn;
    @FXML private TableColumn<Museum, String> themeColumn;
    @FXML private TableColumn<Museum, String> formeColumn;
    @FXML private TableColumn<Museum, String> costColumn;
    @FXML private TextField namefield0;
    @FXML private TextField cityfield0;
    @FXML private TextField adressfield0;
    @FXML private TextField themefield0;
    @FXML private TextField formfield0;
    @FXML private TextField costfield0;
    @FXML private TextField deletefield0;
    @FXML private TextField searchfield0;
    @FXML private TextField loginfield;
    @FXML private PasswordField passwordfield;
    public void fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Откройте Файл");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(new Stage());
        filename=file.getAbsolutePath();
        readFile();
    }

    public static final String name = "name";
    public static final String city = "city";
    public static final String adress = "adress";
    public static final String theme = "theme";
    public static final String form = "form";
    public static final String cost = "cost";
    public static final String museum = "Museum";
    public ArrayList<Museum> lsitofmuseums = new ArrayList<>();
    public ArrayList<Museum> searchlist = new ArrayList<>();
    public void addNewObject(){
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        JSONObject obj2 = new JSONObject();
        obj2.put(name,namefield0.getText());
        obj2.put(city,cityfield0.getText());
        obj2.put(adress,adressfield0.getText());
        obj2.put(theme,themefield0.getText());
        obj2.put(form,formfield0.getText());
        obj2.put(cost,costfield0.getText());
        museumList.add(obj2);
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
        namefield0.clear();
        cityfield0.clear();
        adressfield0.clear();
        themefield0.clear();
        formfield0.clear();
        costfield0.clear();
    }

    public void searchElement(){
        String tmp = searchfield0.getText();
        boolean founded = false;
        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                searchlist.add(lsitofmuseums.get(i));
                founded=true;
            }
        }
        if(founded){
            tableView.getItems().clear();
            nameColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("name"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("city"));
            adressColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("adress"));
            themeColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("theme"));
            formeColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("form"));
            costColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("cost"));
            tableView.setItems(getSearchMuseums());
        }
        searchlist.clear();
    }

    public void deleteElement(){
        lsitofmuseums.remove(Integer.parseInt(deletefield0.getText())-1);
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }

    public void refresh(){
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }

    public void readFile(){

        JSONParser parser = new JSONParser();
        try{
            JSONArray museums = (JSONArray) parser.parse(new FileReader(filename));
            for(Object o:museums){
                JSONObject mmuseum = (JSONObject) o;
                String nname = (String) mmuseum.get(name);
                String cy = (String) mmuseum.get(city);
                String ad = (String) mmuseum.get(adress);
                String th = (String) mmuseum.get(theme);
                String fo = (String) mmuseum.get(form);
                String ccc = (String) mmuseum.get(cost);
                Museum local = new Museum(nname,cy,ad,th,fo,ccc);
                lsitofmuseums.add(local);
            }
            nameColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("name"));
            cityColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("city"));
            adressColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("adress"));
            themeColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("theme"));
            formeColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("form"));
            costColumn.setCellValueFactory(new PropertyValueFactory<Museum,String>("cost"));

            tableView.setItems(getMuseums());
            tableView.setEditable(true);
            nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            cityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            adressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            themeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            formeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            costColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Museum> getMuseums(){
            ObservableList<Museum> museumss = FXCollections.observableArrayList();
            for (int i =0; i<lsitofmuseums.size();i++){
            museumss.add(new Museum(lsitofmuseums.get(i).name,lsitofmuseums.get(i).city,lsitofmuseums.get(i).adress,lsitofmuseums.get(i).theme,lsitofmuseums.get(i).form,lsitofmuseums.get(i).cost));
        }
        return museumss;
    }
    public ObservableList<Museum> getSearchMuseums(){
        ObservableList<Museum> museumss = FXCollections.observableArrayList();
        for (int i =0; i<searchlist.size();i++){
            museumss.add(new Museum(searchlist.get(i).name,searchlist.get(i).city,searchlist.get(i).adress,searchlist.get(i).theme,searchlist.get(i).form,searchlist.get(i).cost));
        }
        return museumss;
    }

    public void changeNameCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getName();
        museumSelected.setName((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getName();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setName(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    public void changeCityCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getCity();
        museumSelected.setCity((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getCity();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setCity(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    public void changeAdressCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getAdress();
        museumSelected.setAdress((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getAdress();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setAdress(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    public void changeThemeCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getTheme();
        museumSelected.setTheme((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getTheme();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setTheme(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    public void changeFormCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getForm();
        museumSelected.setForm((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getForm();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setForm(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    public void changeCostCellEvent(TableColumn.CellEditEvent cellEditEvent){
        Museum museumSelected = tableView.getSelectionModel().getSelectedItem();
        String tmp=museumSelected.getCost();
        museumSelected.setCost((String) cellEditEvent.getNewValue());
        String tmp2 = museumSelected.getCost();

        for (int i =0; i<lsitofmuseums.size();i++){
            if((lsitofmuseums.get(i).name.equals(tmp))||(lsitofmuseums.get(i).city.equals(tmp))||(lsitofmuseums.get(i).adress.equals(tmp))||(lsitofmuseums.get(i).theme.equals(tmp))||(lsitofmuseums.get(i).form.equals(tmp))||(lsitofmuseums.get(i).cost.equals(tmp))){
                lsitofmuseums.get(i).setCost(tmp2);
            }
        }
        JSONArray museumList = new JSONArray();
        for (int i =0; i<lsitofmuseums.size();i++){
            JSONObject obj = new JSONObject();
            obj.put(name,lsitofmuseums.get(i).name);
            obj.put(city,lsitofmuseums.get(i).city);
            obj.put(adress,lsitofmuseums.get(i).adress);
            obj.put(theme,lsitofmuseums.get(i).theme);
            obj.put(form,lsitofmuseums.get(i).form);
            obj.put(cost,lsitofmuseums.get(i).cost);
            museumList.add(obj);
        }
        try(FileWriter file = new FileWriter(filename)) {
            file.write(museumList.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        tableView.getItems().clear();
        lsitofmuseums.clear();
        readFile();
    }
    //--------------------------------------------
    @FXML
    private Label badlabel;
    public void loginButtonClicked(ActionEvent e) throws IOException{
        if((loginfield.getText().equals("student"))&&(passwordfield.getText().equals("student"))){
            try {
                Thread.sleep(2000);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("StartMenuSt.fxml"));
                Parent LabPage = loader.load();
                Scene LabScene = new Scene(LabPage);
                Stage window = (Stage) mainpage.getScene().getWindow();
                window.setScene(LabScene);
                window.show();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        else if((loginfield.getText().equals("admin"))&&(passwordfield.getText().equals("admin"))){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StartMenu.fxml"));
            Parent LabPage = loader.load();
            Scene LabScene = new Scene(LabPage);
            Stage window = (Stage) mainpage.getScene().getWindow();
            window.setScene(LabScene);
            window.show();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }else{
            badlabel.setText("❌ Невірний логін або пароль!");
        }
    }
}