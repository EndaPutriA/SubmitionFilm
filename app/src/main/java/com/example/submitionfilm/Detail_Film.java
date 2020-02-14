package com.example.submitionfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail_Film extends AppCompatActivity {
    private TextView tvName,tvDesc;
    private ImageView ivFilm;
    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__film);
        tvName=findViewById(R.id.tv_name);
        tvDesc=findViewById(R.id.tv_description);
        ivFilm=findViewById(R.id.img_film);


        Intent intent=this.getIntent();
        //Film film =intent.getParcelableExtra(EXTRA_FILM);
        ArrayList<Film> films = intent.getParcelableArrayListExtra(EXTRA_FILM);
        assert films != null;
        String Name=films.get(0).getNameFilm();
        String Des=films.get(0).getDescFilm();
        int IMGFilm=films.get(0).getImg();

        tvDesc.setText(Des);
        tvName.setText(Name);
        ivFilm.setImageResource(IMGFilm);
        }

}
