package com.ss.gd.example.gdsocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.good.gd.GDAndroid;
import com.good.gd.GDStateListener;
import com.good.gd.net.GDSocket;

public class GDSocketActivity extends Activity implements GDStateListener {
	private String mLogTag = "GDSocketApp";
	protected EditText mInterractionLog = null;
	protected ServerSocket mSocketSrv = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gdsocket);
		GDAndroid.getInstance().activityInit(this);

		//Init UI elements
		mInterractionLog = (EditText) findViewById(R.id.interractionLog);

		final Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() 
        									{
												@Override
												public void onClick(View v) {
													Log.d(mLogTag, "Button clicked!" );
													Socket s = new Socket(hostname, port);
													s.getOutputStream().write((byte) '\n');
													int ch = s.getInputStream().read();
													s.close();
													if (ch == '\n') // its all good.
												}
        									});
		
		try
		{
			ServerSocket srv = new ServerSocket(4444);
		} catch (IOException e) {
			
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.gdsocket, menu);
		return true;
	}

	@Override
	public void onAuthorized() {
		if (mInterractionLog != null)
			mInterractionLog.append("["+mLogTag+"] :"+"Application onAuthorized() call\n");
		Log.d(mLogTag, "Application Authorized" );
	}

	@Override
	public void onLocked() {
		if (mInterractionLog != null)
			mInterractionLog.append("["+mLogTag+"] :"+"Application onLocked() call\n");

		Log.d(mLogTag, "Application onLocked() call" );
	}

	@Override
	public void onUpdateConfig(Map<String, Object> arg0) {
		if (mInterractionLog != null)
			mInterractionLog.append("["+mLogTag+"] :"+"Application onUpdateConfig(...) call\n");
		// TODO Auto-generated method stub
		Log.d(mLogTag, "Application onUpdateConfig() call" );
	}

	@Override
	public void onUpdatePolicy(Map<String, Object> arg0) {
		if (mInterractionLog != null)
			mInterractionLog.append("["+mLogTag+"] :"+"Application onUpdatePolicy(...) call\n");
		// TODO Auto-generated method stub
		Log.d(mLogTag, "Application onUpdatePolicy(...) call" );
		
		
	}

	@Override
	public void onUpdateServices() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWiped() {
		// TODO Auto-generated method stub
		
	}

}
