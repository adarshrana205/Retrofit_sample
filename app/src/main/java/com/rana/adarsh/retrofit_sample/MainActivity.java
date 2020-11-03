package com.rana.adarsh.retrofit_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text_view_result);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://employee-employee.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build();

        DjangoApi djangoApi=retrofit.create(DjangoApi.class);

        String authHeader;
        String username="admin";
        String password="admin";
        String base=username+":"+password;
        authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        Call<List<Post>> call=djangoApi.getPosts(authHeader);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful())
                {
                    textView.setText("Code :"+ response.code());
                    return;
                }
                List<Post> posts=response.body();

                for(Post post:posts)
                {
                    String content="";
                    content+="ID: "+post.getId()+"\n";
                    content+="Employee ID: "+post.getEmployee_id()+"\n";
                    content+="Name: "+post.getName()+"\n";
                    content+="Age: "+post.getAge()+"\n";
                    content+="Ranking: "+post.getRank()+"\n\n";
                    textView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}