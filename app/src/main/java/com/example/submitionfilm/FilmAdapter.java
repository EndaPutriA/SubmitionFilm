package com.example.submitionfilm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> films = new ArrayList<>();

    public FilmAdapter(Film films) {

    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        if (itemView==null){
            itemView= LayoutInflater.from(context).inflate(R.layout.item_film,parent,false);
        }

        ViewHolder viewHolder=new ViewHolder(itemView);

        Film film=(Film) getItem(position);
        viewHolder.bind(film);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvNameFilm,tvDescFilm;
        private ImageView imgFilm;

        public ViewHolder(View itemView) {
            tvNameFilm=itemView.findViewById(R.id.tv_name);
            tvDescFilm=itemView.findViewById(R.id.tv_description);
            imgFilm=itemView.findViewById(R.id.img_film);
        }

        public void bind(Film film) {
            tvNameFilm.setText(film.getNameFilm());
            tvDescFilm.setText(film.getDescFilm());
            imgFilm.setImageResource(film.getImg());
        }
    }
}
