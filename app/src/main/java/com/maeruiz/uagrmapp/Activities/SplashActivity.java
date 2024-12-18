package com.maeruiz.uagrmapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.maeruiz.uagrmapp.R;
import com.maeruiz.uagrmapp.Static.AppConstants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        //Instanciar la Base de Datos
       /*
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "dboigo", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster= new DaoMaster(db);
        daoMaster.newSession();
*/

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                /*
                DaoSession daoSession = DaoMaster.getSession();
                List<Palabra> listaPalabra;
                PalabraDao palabraDao = daoSession.getPalabraDao();
                listaPalabra = palabraDao.loadAll();

*/
                Intent mainIntent;

                if (isLoggedIn())
                    // Start the next activity

                    mainIntent = new Intent().setClass(
                            SplashActivity.this, MainActivity.class);

                else


                    mainIntent = new Intent().setClass(
                            SplashActivity.this, LoginActivity.class);
                startActivity(mainIntent);


            }
        };

        Timer timer = new Timer();

        timer.schedule(task, AppConstants.SPLASH_SCREEN_DELAY);
    }

    private boolean isLoggedIn() {
        return false;
    }

}
