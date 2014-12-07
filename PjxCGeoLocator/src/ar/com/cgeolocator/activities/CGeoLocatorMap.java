package ar.com.cgeolocator.activities;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

/**
 * @author Ariel Duarte
 * date : 12/02/2013
 */

public class CGeoLocatorMap extends MapActivity{

	private MapView mMapView = null; //Con esta variable obtendremos la referencia al XML
	private MapController mMapControl = null; //Objeto MapController, que controla el mapa representado.
	
//	private static final int latitudeE6 = -27453149; //Variables para latitud Resistencia
//	private static final int longitudeE6 = -58987366;//Variable para longuitud Resistencia
	private static final int latitudeE6 = 41899211; //Variables para latitud Chicago
	private static final int longitudeE6 = -87632675;//Variable para longuitud Chicago
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.map_view);

		mMapView = (MapView) findViewById(R.id.map_view);
		mMapView.setBuiltInZoomControls(true);
        
        List mapOverlays = mMapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_market);
		CGeoOverlay itemizedOverlay = new CGeoOverlay(drawable, this);
 
		GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
		OverlayItem overlayitem = new OverlayItem(point, "Hello I'm Ariel","I live here in **Resistencia-Argentina**");
 
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
 
		mMapControl = mMapView.getController();
 
		mMapControl.animateTo(point);
		mMapControl.setZoom(16);
		mMapControl.setCenter(point); 
		
		
//-->   TODO: ESTE BLOQUE QUEDA A LA ESPERA DE UNA MEJOR UTILIZACION <--//
//----------------------------------------------------------------------//
//		// Crear MapView y MapController asociado al primero 
//		  mMapView = new 
//		  MapView(this,"0nIdYLs3kXV_h4Urtu0B3tYzOJe8OPwc1fkzpGw"); 
//		  mMapControl = mMapView.getController(); 
//		 
//		      // Crear un punto 
//		  GeoPoint gPoint = new GeoPoint(latitudeE6,longitudeE6); 
//		     
//		  // Vista satélite 
//		  mMapView.setSatellite(true); 
//		  // Nivel de zoom 
//		  mMapControl.setZoom(16); 
//		  // Centrar el mapa en el punto 
//		  mMapControl.setCenter(gPoint); 
//		         
//		 setContentView(mMapView);
//----------------------------------------------------------------------//		
		
		
	}
	/*
	 * Metodo con lo eventos de los botones del mapa, para cambiar las
	 * preferencias de vistas
	 */
	public void onClickPreference(View target){
		switch (target.getId()) {
		case R.id.sat:
			mMapView.setSatellite(true);
			break;

		case R.id.street:
			mMapView.setStreetView(true);
			break;
			
		case R.id.traffic:
			mMapView.setTraffic(true);
			break;
			
		case R.id.normal:
			mMapView.setTraffic(false);
			mMapView.setStreetView(false);
			mMapView.setSatellite(false);
			break;
		}
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
