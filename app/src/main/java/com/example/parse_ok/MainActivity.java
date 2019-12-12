package com.example.parse_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    private void getArtist(){



        Retrofit retrofit = NetworkClient.getRetrofitClient();
        MusicInterface musicInterface = retrofit.create(MusicInterface.class);
        Call call = musicInterface.getArtist("artist.getinfo","Cher","6c8dc87e402c8f96b8369f927ca0c1be", "json");
        call.enqueue(new Callback () {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.body() !=null) {
                    Artist artist = (Artist) response.body();


                    StringBuilder sb = new StringBuilder();
                    sb.append(artist.getName());
                    sb.append(" - ");
                    //sb.append(artist.getImage().get(0));

                    textView.setText("Artist is - " + sb);


                    //textView.setText("Все отлично!");


                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }


    public void StartBtn(View view) {
        getArtist();
    }
}
