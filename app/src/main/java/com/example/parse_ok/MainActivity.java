package com.example.parse_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String st;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        textView = findViewById(R.id.textView);

        ImageView img = (ImageView) findViewById(R.id.imageView);

    }
	private void getTrackInfo(){
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        MusicInterface musicInterface = retrofit.create(MusicInterface.class);
        Call callTrack = musicInterface.getTrackInfo("track.getInfo","6c8dc87e402c8f96b8369f927ca0c1be","Cher","Believe","json");

        try {
        Response<TrackInfo> responseTrackInfo = callTrack.execute();
        TrackInfo trackInfo = responseTrackInfo.body();

        final Track track = trackInfo.getTrack();

        final StringBuilder sb = new StringBuilder();
        //sb.append(track.getName());

        final Album album = track.getAlbum();
        final Image[] image = album.getImage();

            sb.append(album.getArtist());
        sb.append(" - ");
        sb.append(album.getTitle());
        sb.append(", адрес картинки - ");
        sb.append(image[3].getText());//строка возвращает значение "NULL" ????

            //
        //sb.append(image.get(3).getText().toString());



        textView.setText(sb);

        } catch (IOException e) {
            System.out.println("caught IOException: " + e);
        }

    }

	private void getArtistInfo() {

        Retrofit retrofit = NetworkClient.getRetrofitClient();
        MusicInterface musicInterface = retrofit.create(MusicInterface.class);

        //Call callArtist = musicInterface.getArtistInfoMusic("artist.getinfo","Cher","6c8dc87e402c8f96b8369f927ca0c1be", "json");
        Call callArtist = musicInterface.getArtistInfoMusic("artist.getinfo", st, "6c8dc87e402c8f96b8369f927ca0c1be", "json");

            try {
                Response<ArtistInfo> responseArtistInfo = callArtist.execute();
                ArtistInfo artistInfo = responseArtistInfo.body();

                final Artist artist = artistInfo.getArtist();

                final StringBuilder sb = new StringBuilder();
                sb.append(artist.getName());
                sb.append(" значение для картинки - ");

                final List<Image> image = artist.getImage();
                sb.append(image.get(4).getText().toString());


                /*Picasso.get()
                        .load("https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png")
                        .error(R.drawable.ic_launcher_background)
                        .fit()
                        .centerCrop()
                        .into(img); */

                textView.setText("Artist is - " + sb);

                //Picasso.get().load("https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png").into(img);

            } catch (IOException e) {
                System.out.println("caught IOException: " + e);
            }
        }



    public void StartBtn(View view) {

       //st = ((EditText) findViewById(R.id.editText)).getText().toString();

       //getArtistInfo();

     getTrackInfo();
    }
}
