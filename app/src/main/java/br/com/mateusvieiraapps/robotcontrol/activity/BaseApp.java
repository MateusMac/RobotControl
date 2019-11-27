package br.com.mateusvieiraapps.robotcontrol.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import br.com.mateusvieiraapps.robotcontrol.helper.BaseAppMethods;

/**
 * Classe base para as Activitys.
 *
 * @author Mateus V Machado
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressLint("Registered")
public class BaseApp extends AppCompatActivity implements BaseAppMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void abrirIntent(Class<?> cls) {

        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public void mostrarToast(CharSequence text) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarToast(CharSequence text, int duration) {

        Toast.makeText(this, text, duration).show();
    }
}
