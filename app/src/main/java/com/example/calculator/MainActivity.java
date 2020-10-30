package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private TextView result,insert;
    private Button one,two,three,four,five,six,seven,eight,nine,zero,equal,point,clear,plus,minus,devide,time ;
    private String input="",ans;
    private boolean clearResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.viewDisplay);
        one= (Button)findViewById(R.id.btnOne);
        two= (Button)findViewById(R.id.btnTwo);
        three= (Button)findViewById(R.id.btnThree);
        four= (Button)findViewById(R.id.btnFour);
        five= (Button)findViewById(R.id.btnFive);
        six= (Button)findViewById(R.id.btnSix);
        seven= (Button)findViewById(R.id.btnSeven);
        eight= (Button)findViewById(R.id.btnEight);
        nine= (Button)findViewById(R.id.btnNine);
        zero= (Button)findViewById(R.id.btnZero);
        equal= (Button)findViewById(R.id.btnEqual);
        point= (Button)findViewById(R.id.btnDot);
        clear= (Button)findViewById(R.id.btnClear);
        plus= (Button)findViewById(R.id.btnPlus);
        minus= (Button)findViewById(R.id.btnMinus);
        devide= (Button)findViewById(R.id.btnDevide);
        time   = (Button)findViewById(R.id.btnTime);

    }

    public void ButtonCLick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input="";
                break;
            case "*":
                clearResult=false;
                solve();
                input+="*";
                break;
            case "=":
                clearResult=true;
                solve();
                ans=input;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    clearResult=false;
                    solve();
                }
                else if(clearResult==true){
                    input="";
                    clearResult=false;
                }
                input+=data;
        }
        result.setText(input);
    }
    private void solve(){

        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try{
                double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                input=mul+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("/").length==2){
            String numbers[]=input.split("/");
            try{
                double div=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                input=div+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("\\+").length==2){
            String numbers[]=input.split("\\+");
            try{
                double sum=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                input=sum+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        else if(input.split("\\-").length>1){
            String numbers[]=input.split("\\-");
            if(numbers[0]=="" && numbers.length==2){
                numbers[0]=0+"";
            }
            try{
                double sub=0;
                if(numbers.length==2) {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                }
                else if(numbers.length==3){
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input=sub+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        result.setText(input);
    }
}