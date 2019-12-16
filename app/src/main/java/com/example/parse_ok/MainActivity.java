package com.example.parse_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
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
	
	public String getGreeting() {
        return "Hello world.";
    }

    private void getArtist(){

        Retrofit retrofit = NetworkClient.getRetrofitClient();
        MusicInterface musicInterface = retrofit.create(MusicInterface.class);
		
		Call callArtist = musicInterface.getArtist("artist.getinfo","Cher","6c8dc87e402c8f96b8369f927ca0c1be", "json");
		
                    try {
                        Response<ArtistInfo> responseArtistInfo = callArtist.execute();
                        ArtistInfo artistInfo = responseArtistInfo.body();
                        final Artist artist = artistInfo.getArtist();
                        StringBuilder sb = new StringBuilder();
                        sb.append(artist.getName());

                        textView.setText("Artist is - " + sb);
                    } catch (IOException e){
                        System.out.println("caught IOException: " + e);
                    }

                }


    public void StartBtn(View view) {
        getArtist();
    }
}
