package com.primary.secondgraders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Mucluc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mucluc);
        final Button bt = (Button)findViewById(R.id.get_html);
        bt.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				Intent t = new Intent(Mucluc.this, JsonTest.class);
				startActivity(t);
				return false;
			}
		});
    }
}
