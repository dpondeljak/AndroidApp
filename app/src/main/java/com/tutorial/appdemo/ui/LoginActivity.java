package com.tutorial.appdemo.ui;

import android.content.Intent;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutorial.appdemo.BaseActivity;
import com.tutorial.appdemo.R;
import com.tutorial.appdemo.util.Logger;
import com.tutorial.appdemo.util.SessionManager;

public class LoginActivity extends BaseActivity {

    // TODO Dodati progresDialog ( tj. zamjenu za isti budući da je deprecated u novom SDK-u )

    private Button btnLogin;
    private EditText txtUsername;
    private EditText txtPassword;
    private TextView txtLogin;

    private SessionManager iSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmbossMaskFilter filter = new EmbossMaskFilter(
                new float[]{ 0f, -1f, 0.5f }, // direction of the light source
                0.8f, // ambient light between 0 to 1
                11, // specular highlights
                1.5f // blur before applying lighting
        );

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //txtLogin.getPaint().setMaskFilter(filter);

        // mapiranje polja
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        iSession = new SessionManager(getApplicationContext());

        if (iSession.isPrijavljen()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * doLogin metoda poziva se iz layout-a (activity_login) onClick
     *
     * @param pView
     */
    public void doLogin(View pView) {
        Logger.m("login pressed");
        String korisnickoIme = txtUsername.getText().toString().trim();
        String lozinka = txtPassword.getText().toString().trim();
        // Provjera da korisnicko ime i lozinka nisu prazni
        if (!korisnickoIme.isEmpty() && !lozinka.isEmpty()) {
            // nisu prazni
            provjeraKorisnika(korisnickoIme, lozinka);
        } else {
            Logger.m("Neispravni podaci korisnik: " + korisnickoIme + " lozinka: " + lozinka);
            Logger.T(this, "Korisnicčko ime i lozinka \n ne mogu biti prazni!");
        }
    }

    /**
     * Provjera prijave za korisnika
     *
     * @param pUsername
     * @param pLozinka
     */
    private void provjeraKorisnika(String pUsername, String pLozinka) {
        Logger.m("Provjera korisnika: " + pUsername + " lozinka: " + pLozinka);
        //TODO potrebna provjera korisnika sa podacima sa api-a i store u bazu

        // Primitivna metoda
        if ("admin".equalsIgnoreCase(pUsername) && "admin123".equalsIgnoreCase(pLozinka)) {
            // Postavi prijavu u session
            iSession.setPrijava(true);

            // otvori Main activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Logger.T(this, "Neispravni podaci za prijavu! \n Provjerite svoje korisnicke podatke.");
        }

    }


}
