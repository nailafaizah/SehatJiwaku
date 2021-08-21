package com.example.sehatjiwaku.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatjiwaku.api.ApiConfig;
import com.example.sehatjiwaku.databinding.ActivityLoginBinding;
import com.example.sehatjiwaku.model.DataLogin;
import com.example.sehatjiwaku.model.LoginModel;
import com.example.sehatjiwaku.model.LoginResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private SharedPreferences sharedPreferences;
    public static final String MY_SHARED_PREFERENCES = "my_shared_preferences";
    public static final String SESSION_STATUS = "session_status";

    /**
     * for session key
     */
    public static final String KEY_ID = "id";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAME = "name";
    public static final String KEY_LEVEL = "level";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        boolean session = sharedPreferences.getBoolean(SESSION_STATUS, false);
        String level = sharedPreferences.getString(KEY_LEVEL, null);

        if (session) {
            Intent intent;
            if(level.equalsIgnoreCase("admin")) {
                intent = new Intent(getApplicationContext(), HomeAdmin.class);
            }else{
                intent = new Intent(getApplicationContext(), Home.class);
            }
            finish();
            startActivity(intent);
        }

        binding.btnDaftar.setOnClickListener(v -> {
            Intent intent = new Intent(this, Daftar.class);
            startActivity(intent);
            finish();
        });

        binding.login.setOnClickListener(v -> {
            setLoading(true);
            LoginModel data = new LoginModel(
                    binding.username.getText().toString(),
                    binding.password.getText().toString()
            );
            Call<LoginResponse> client = ApiConfig.getApiService().login(data);
            client.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                    if(response.isSuccessful()){
                        setLoading(false);
                        assert response.body() != null;
                        String message = response.body().getMessages();
                        if(response.body().getStatus() == 200){
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

                            Intent intent;
                            DataLogin data = response.body().getData().get(0);
                            if(data.getLevel().equalsIgnoreCase("admin")) {
                                intent = new Intent(getApplicationContext(), HomeAdmin.class);
                            }else{
                                intent = new Intent(getApplicationContext(), Home.class);
                            }


                            // save the data to session

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean(SESSION_STATUS, true);
                            editor.putString(KEY_ID, data.getIdUser());
                            editor.putString(KEY_NAME, data.getNama());
                            editor.putString(KEY_USERNAME, data.getUsername());
                            editor.putString(KEY_LEVEL, data.getLevel());
                            editor.apply();

                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    Log.d("LoginPage", "onFailure: " + t.toString());
                }
            });
        });

    }

    public void loginBtn(View view){
        String u = binding.username.getText().toString();
        String p = binding.password.getText().toString();

        background bg = new background(this);
        bg.execute(u,p);
    }

    private void setLoading(Boolean state){
        ProgressDialog dialog = new ProgressDialog(Login.this);
        dialog.setMessage("Tunggu sebentar ...");
        if(state){
            dialog.show();
        }else {
            dialog.dismiss();
        }
    }
}
