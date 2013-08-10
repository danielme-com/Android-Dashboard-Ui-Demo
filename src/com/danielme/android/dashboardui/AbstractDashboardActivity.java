/*
 * Copyright (C) 2012-2013 Daniel Medina <http://danielme.com>
 * 
 * This file is part of "Android Dashboard UI Demo".
 * 
 * "Android Dashboard UI Demo" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * "Android Dashboard UI Demo" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License version 3
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html/>
 */
package com.danielme.android.dashboardui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;




/**
 * Manages ActionBar with ActionBarCompat. You have to import "android-sdk-linux/extras/android/support/v7/appcompat" into Eclipse
 * as an Android project and add it as a a library.
 * @author Daniel Medina
 *
 */
public abstract class AbstractDashboardActivity extends ActionBarActivity implements ActionBar.OnNavigationListener 
{
	
	public static final int ITEM_HOME = 0;
	public static final int ITEM_WIDTH = 1;
	public static final int ITEM_FULL = 2;
	public static final int ITEM_CENTER = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);

        setContentView(getContentView());        

        Context context = getSupportActionBar().getThemedContext();
        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(context, R.array.navigation_list, android.R.layout.simple_spinner_item);
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(list, this);
        actionBar.setSelectedNavigationItem(getSelectedNavigationItem());
        actionBar.setSubtitle(R.string.subtitle);          
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	startActivity(new Intent(this, HomeActivity.class));
    	return true;
    }
	
	@Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) 
    {    
    	switch (itemPosition) 
		{
		case ITEM_HOME:
			if (!(this instanceof HomeActivity))
				startActivity(new Intent(this, HomeActivity.class));
			break;
		case ITEM_WIDTH:
			if (!(this instanceof WidthActivity))
				startActivity(new Intent(this, WidthActivity.class));
			break;
		case ITEM_FULL:
			if (!(this instanceof FullActivity))
				startActivity(new Intent(this, FullActivity.class));
			break;
		case ITEM_CENTER:
			if (!(this instanceof CenterActivity))
				startActivity(new Intent(this, CenterActivity.class));
			break;		
		}
    	
      return true;
    }
    
    public void clicked(View view)
    {
    	Button button = (Button) view;   
    	Toast.makeText(this,button.getText().toString(),Toast.LENGTH_SHORT).show();
    }
    
    protected abstract int getContentView();
    
    protected abstract int getSelectedNavigationItem();

 
}
