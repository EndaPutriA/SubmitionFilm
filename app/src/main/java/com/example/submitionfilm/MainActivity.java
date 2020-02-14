package com.example.submitionfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private FilmAdapter filmAdapter;
    Film film;
    private String[] dataFilm={"London Love Story","Surga yang Tak Dirindukan","Mimpi Sejuta Dolar","Perfect Husband","Dilan 1990","99 Cahaya Dilangit Eropa","I Love You 38000","Keluarga Cemara","Weeding Agreement","Nanti Kita Cerita Tentang Hari Ini"};
    private String[] dattaDescFilm={"After spending time together for two years, Dave decides to marry Caramel. They travel to Bali where Caramel is reminded of her past. Dave and Caramel face a tragedy that changes their lives",
            "Left a good career with being a wife of Pras and mother to Nadia, Arini feels to has a perfect family. Someday, Pras rescues Meirose, a pregnant woman who has a car accident",
            "Setelah lulus dari SMA, Merry Riana harus lari ke Singapura dari situasi tidak stabil di Indonesia. Dia harus berjuang disana untuk kesuksesan dan cinta.",
            "Di Detik, waktu sekolah menengah Ayla akan berantakan ketika, tiba-tiba, Arsen datang untuk memperkenalkannya sebagai calon suaminya. Acara ini membuat hubungannya dengan Ando,pacarnya, dalam bahaya.",
            "Milea (Vanesha Prescilla) bertemu dengan Dilan (Iqbaal Ramadhan) di sebuah sekolah menengah di Bandung pada tahun 1990, ketika Milea pindah dari Jakarta ke Bandung. Pengantar yang tidak biasa membawa Milea untuk mengetahui keunikan Dilan, cerdas, baik hati, romantis. Cara Dilan mendekati Milea tidak sama dengan teman lelaki lainnya, bahkan Beni (Brandon Salim), pacar Milea di Jakarta. Perjalanan hubungan mereka tidak selalu mulus. Beni, Anhar (Giulio Perangkan), Kang Adi (Refal Hadi) mewarnai perjalanan ini. Dilan membuat Milea percaya bahwa dia dapat tiba di tujuan dengan selamat.",
            "Di film ini, diceritakan pengalaman Hanum Rais (Acha Septriasa) dan Rangga Almahendra (Abimana Aryasatya) mahasiswa Indonesia yang kuliah di luar negeri. Dapatkan pembelajaran dari orang dari negara hingga akhirnya menuntun mereka menemukan rahasia Islam di Eropa.",
            "Ketika Aletta pergi ke Bali untuk liburan, dia bertemu Arga dan mereka jatuh cinta. Mereka menghabiskan setiap momen dengan satu sama lain di Bali dan tiba saatnya bagi Aletta untuk kembali ke Jakarta. Arga berjanji untuk menemukannya dan menikahinya. Tapi yang mengejutkannya, dia tidak pernah muncul. Apakah semua itu bohong, atau apakah sesuatu terjadi padanya?",
            "Setelah rumahnya dan semua hartanya disita oleh penagih utang, berkat hutang saudara iparnya, Abah sangat bertekad untuk menahan semua ini dengan tinggal sementara di sebuah rumah di sebuah desa terpencil di Jawa Barat. Ini adalah rumah masa kecilnya, yang diwarisi oleh ayahnya. Abah kemudian harus terbiasa dengan status ekonomi barunya bersama dengan keluarga kecilnya: Emak, Euis yang menginjak remaja, juga Cemara / Ara yang merupakan anak yang bersemangat tinggi. Mereka juga harus menghadapi masalah di dalam keluarga mereka sendiri yang perlahan-lahan mengguncang prinsip keluarga: harta paling berharga adalah keluarga.",
            "Btari Hapsari tidak menyangka pernikahannya jadi mimpi buruk. Hari pertama tiba di rumah Byantara, pertimbangan, Tari langsung dihadapkan pada perjanjian pernikahan yang isinya mengatakan bahwa mereka akan bercerai dalam waktu satu tahun. Bian berencana menikahi Sarah, kekasihnya. Bian menikah hanya demi bakti bagi keluarga. Tari tidak menyerah, ia berusaha mengambil hati Bian. Namun sekuat apa pun Tari mencoba, selalu ada Sarah di antara mereka.",
            "Film NANTI KITA CERITA TENTANG HARI INI (NKCTHI) bercerita tentang keluarga yang terlihat bahagia dan baik-baik saja. Ada kakak beradik bernama Angkasa (Rio Dewanto), Aurora (Sheila Dara Aisha) dan Awan (Rachel Amanda).Ketiganya memiliki cerita pilunya masing-masing. Sampai akhirnya, Awan bertemu dan berkenalan dengan seorang pria bernama Kale.Setelah memecahkan kegagalan besar, dengan Kale, Awan membalikkan menemukan pelajaran hidup baru. Tentang rusak, bangun, jatuh, tumbuh, hilang dan semua menantang manusia pada umumnya."};
    private int[] dataImgFilm={R.drawable.londonlovestory,
            R.drawable.surgayangtakdirindukan,
            R.drawable.mimpijutadolar,
            R.drawable.perfecthusband,
            R.drawable.dilan,
            R.drawable.cahaya,
            R.drawable.ily,
            R.drawable.keluargacemara,
            R.drawable.weddingagreement,
            R.drawable.nhcti};
    private ArrayList<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.lv_film);
        filmAdapter=new FilmAdapter(this);
        listView.setAdapter(filmAdapter);


        addFilm();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                //Film film = new Film();
                //film.setNameFilm(film.getNameFilm());
                //film.setDescFilm(film.getDescFilm());
                //film.setImg(film.getImg());
                ArrayList arrayList=new ArrayList();
                arrayList.add(new Film(dataImgFilm[position],dataFilm[position],dattaDescFilm[position]));
                Intent intent=new Intent(MainActivity.this,Detail_Film.class);
                intent.putParcelableArrayListExtra(Detail_Film.EXTRA_FILM,films);
                startActivity(intent);
            }
        });

    }



    private void addFilm() {
        films=new ArrayList<>();
        for (int i=0;i<dataFilm.length;i++){
            Film film=new Film(films);
            film.setImg(dataImgFilm[i]);
            film.setNameFilm(dataFilm[i]);
            film.setDescFilm(dattaDescFilm[i]);
            films.add(film);
        }
        filmAdapter.setFilms(films);
    }



}
