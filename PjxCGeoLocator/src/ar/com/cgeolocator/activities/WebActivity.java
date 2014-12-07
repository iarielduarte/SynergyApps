package ar.com.cgeolocator.activities;




import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;



public class WebActivity extends Activity{

	static public final String EXTRA_URL = "EXTRA_URL";
	static public final String EXTRA_TITLE = "EXTRA_TITLE";
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.web);
//        WebView wv = (WebView) findViewById(R.id.web);        
//        wv.loadUrl("http://www.google.com.ar"); 
        
		setContentView(R.layout.web);
		TextView title = (TextView)findViewById(R.id.help_title);
		title.setText(getIntent().getStringExtra(EXTRA_TITLE));
		WebView web = (WebView)findViewById(R.id.web);
		web.loadUrl(getIntent().getStringExtra(EXTRA_URL));
	}

	

	
}