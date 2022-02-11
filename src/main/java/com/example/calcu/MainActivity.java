package com.example.calcu;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textView);


        /*
        при нажатии на ввод текста, текст стирается
         */
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.textView).equals(editText.getText().toString())){
                    editText.setText("");
                }

            }
        });

    }


    public void TextUpdate(String string){
        String oldText = editText.getText().toString();
        int cursor = editText.getSelectionStart();
        String rightText = oldText.substring(0, cursor);
        String leftText = oldText.substring(cursor);
        if (getString(R.string.textView).equals(editText.getText().toString())){
            editText.setText(string);
            editText.setSelection(cursor + 1);
        }else{
            editText.setText(String.format("%s%s%s", leftText, string, rightText));
            editText.setSelection(cursor + 1);
        }
    }


    public void PlusButton(View view){
        TextUpdate("+");
    }

    public void MinusButton(View view){
        TextUpdate("-");

    }

    public void MultiplyButton(View view){
        TextUpdate("*");

    }

    public void DivideButton(View view){
        TextUpdate("/");

    }

    public void OneButton(View view){
        TextUpdate("1");

    }
    public void TwoButton(View view){
        TextUpdate("2");

    }
    public void ThreeButton(View view){
        TextUpdate("3");

    }
    public void FourButton(View view){
        TextUpdate("4");

    }
    public void FiveButton(View view){
        TextUpdate("5");

    }
    public void SixButton(View view){
        TextUpdate("6");

    }
    public void SevenButton(View view){
        TextUpdate("7");

    }
    public void EightButton(View view){
        TextUpdate("8");

    }
    public void NineButton(View view){
        TextUpdate("9");

    }

    public void ZeroButton(View view){
        TextUpdate("0");

    }

    /*
    метод для вычисления результата
    использовалась библиотека mxparser
     */

    public void ResultButton(View view){
        String res = editText.getText().toString();

        // замена знаков
        res = res.replaceAll("÷", "/");
        res = res.replaceAll("×", "*");

        Expression exp = new Expression(res);

        String answer = String.valueOf(exp.calculate());
        editText.setText(answer);
        editText.setSelection(answer.length());



    }


    /*
    класс для очистки поля ввода
     */

    public void CleanButton(View view){

        int cursor = editText.getSelectionStart();
        SpannableStringBuilder SpanStrBuild = (SpannableStringBuilder) editText.getText(); //Это класс для текста, содержимое и разметка которого могут быть изменены.
        SpanStrBuild.replace(cursor - 1, cursor, ""); // заменяем на пустоту, делая -1
        editText.setText(SpanStrBuild);
        editText.setSelection(cursor - 1);


    }
    public void DegreeButton(View view){
        TextUpdate("^");

    }
    public void PointButton(View view){
        TextUpdate(".");

    }





}