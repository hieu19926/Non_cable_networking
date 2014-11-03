package com.primary.secondgraders;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.primary.jsonstorage.CauHoi;

public class JsonTest extends Activity {
	private static  String url_get="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_json);
		final TextView cauHoi = (TextView) findViewById(R.id.TextViewcauhoi);
		final TextView traLoiA = (TextView) findViewById(R.id.textViewTLA);
		final TextView traLoiB = (TextView) findViewById(R.id.TextViewTLB);
		final TextView traLoiC = (TextView) findViewById(R.id.TextViewTLC);
		final TextView traLoiD = (TextView) findViewById(R.id.TextViewTLD);
		final EditText noidung = (EditText) findViewById(R.id.noidung);
		final EditText addrs = (EditText) findViewById(R.id.url);
		final Button getHtmlBt = (Button) findViewById(R.id.get_html);
		
		getHtmlBt.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				url_get = addrs.getText().toString();
				try {
					Log.e("xxx", "xxx");
					// lấy nội dung file html:
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
							.permitAll().build();
					StrictMode.setThreadPolicy(policy);
					String res = getStringContent(url_get);
					//int len = res.length();
					//byte byt[] = new byte[len];
					//byt=res.getBytes("UTF8");
					//Log.e("respose:", byt.toString());
					noidung.setText(res);
					JSONObject json = new JSONObject(res);
					JSONObject jsonPost = json.getJSONObject("post");
					cauHoi.setText("Câu "+jsonPost.getString("number")+":  "+jsonPost.getString("question"));
					traLoiA.setText(jsonPost.getString("answer_a"));
					traLoiB.setText(jsonPost.getString("answer_b"));
					traLoiC.setText(jsonPost.getString("answer_c"));
					traLoiD.setText(jsonPost.getString("answer_d"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		});
		
		/*noidung.setFocusable(false);
		CauHoi cau1 = new CauHoi("1","Cau1: 1 + x = 3, x = ?", "bang 1", "bang 2","bang 3", "bang 4", "2");
		Gson gs = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String chuoiJson = gs.toJson(cau1);
		try {
			JSONObject js = new JSONObject(chuoiJson);
			String ch = "";
			ch = js.getString("question");
			cauHoi.setText("JSON_string: " + ch);
		} catch (JSONException e) {
			Log.e("ERR", "JSONERR");
		}*/
	}

	// Ham lay tren mang:
	public static String getStringContent(String uri) throws TimeoutException,
			Exception {

		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(uri));
			HttpResponse response = client.execute(request);
			InputStream ips = response.getEntity().getContent();
			BufferedReader buf = new BufferedReader(new InputStreamReader(ips,
					"UTF-8"));

			StringBuilder sb = new StringBuilder();
			String s;
			int i = 0;
			while (true) {
				s = buf.readLine();
				if (s == null || s.length() == 0) {
					Log.e("loop: ", Integer.toString(i++));
					break;
				}
				sb.append(s);

			}
			buf.close();
			ips.close();
			return sb.toString();
		} finally {
			// any cleanup code...
		}
	}

}
