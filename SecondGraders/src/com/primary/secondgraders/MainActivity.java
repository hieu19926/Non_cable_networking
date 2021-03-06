package com.primary.secondgraders;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
	ProgressBar load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load = (ProgressBar) findViewById(R.id.progressBar1);
		load.setIndeterminate(true);
		load.scrollTo(5, 10);

		Log.e("time:", "running");
		final int totalProgressTime = 100;

		final Thread t = new Thread() {

			@Override
			public void run() {

				int jumpTime = 0;

				while (jumpTime < totalProgressTime) {
					try {
						sleep(200);
						jumpTime += 5;
						load.setProgress(jumpTime);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				final Intent i = new Intent(MainActivity.this, Mucluc.class);
				startActivity(i);

			}
		};
		t.start();
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
