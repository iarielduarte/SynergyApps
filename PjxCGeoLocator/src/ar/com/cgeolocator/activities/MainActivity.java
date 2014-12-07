package ar.com.cgeolocator.activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

/**
 * @author Ariel Duarte
 * date: 19/01/2013
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//startActivity(new Intent(this, WebActivity.class));
	}
	
	/*
	 * Permite abrir una view que visualizara el mapa de la app
	 */
	public void openMap(View view){
		startActivity(new Intent(this, CGeoLocatorMap.class));
	}
	
	/*
	 * Este evento nos permite visualizar el about de la app en una webview
	 */
	public void openAbout(View button){
		String url = "file:///android_asset/html/" + getString(R.string.html_language_folder)+"/about.html";
		//Toast.makeText(getApplicationContext(), "Prueba:"+url, Toast.LENGTH_LONG).show();
		Intent i = new Intent(this,WebActivity.class);
		i.putExtra(WebActivity.EXTRA_URL, url);
		i.putExtra(WebActivity.EXTRA_TITLE, getString(R.string.label_about));
		startActivity(i);
	}

	
}
