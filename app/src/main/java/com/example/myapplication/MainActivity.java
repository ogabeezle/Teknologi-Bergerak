package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.Actor;
import com.example.myapplication.model.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editbil1)
    EditText bil1;
    @BindView(R.id.editbil2)
    EditText bil2;
    @BindView(R.id.mulbutton)
    RadioButton mul;
    @BindView(R.id.divbutton)
    RadioButton div;
    @BindView(R.id.addbutton)
    RadioButton add;
    @BindView(R.id.subbutton)
    RadioButton sub;
    @BindView(R.id.resultText)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);
//        ButterKnife.bind(this);

        HashMap<String, Movie> movies = new HashMap<>();
        HashMap<String,Actor> guestStar = new HashMap<>();
        Actor actor=new Actor("Boboiboy",Boolean.FALSE);
        Actor actor2=new Actor("Yaya",Boolean.FALSE);
        guestStar.put(actor.getName(),actor);
        guestStar.put(actor2.getName(),actor2);
        Movie movie=null;
        try {
            movie = new Movie("michael","Boboiboy",2,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"),guestStar, (double) 5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TextView guest=findViewById(R.id.text1);
        System.out.println(movie.toString());
        guest.setText(movie.getHeader());
    }

    public void changeName(View v) {
        EditText password = findViewById(R.id.passwordEdit);
        TextView pass = findViewById(R.id.your_password);
        pass.setText(password.getText().toString());

        Integer hehe = 6;
        hehe.toString();

        Toast.makeText(this, hehe.toString(), Toast.LENGTH_LONG).show();
    }

    public void count(View v) {
        Double b1 = new Double(bil1.getText().toString());
        Double b2 = new Double(bil2.getText().toString());
        Double hasil = new Double("0");
        if (mul.isChecked()) {
            hasil = b1 * b2;
        } else if (div.isChecked()) {
            hasil = b1 / b2;
        } else if (add.isChecked()) {
            hasil = b1 + b2;
        } else if (sub.isChecked()) {
            hasil = b1 - b2;
        }
        result.setText(hasil.toString());
    }
}
