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

import java.util.Locale;

import android.os.Bundle;
import android.webkit.WebView;

public class HomeActivity extends AbstractDashboardActivity
{

	@Override
	protected int getContentView()
	{
		return R.layout.home;
	}

	@Override
	protected int getSelectedNavigationItem()
	{
		return ITEM_HOME;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		WebView webview = (WebView) findViewById(R.id.webview);
		// Welcome page loaded from assets directory
		if (Locale.getDefault().getLanguage().equals("es"))
		{
			webview.loadUrl("file:///android_asset/welcome_es.html");
		}
		else
		{
			webview.loadUrl("file:///android_asset/welcome.html");
		}
		
		webview.requestFocus();
	}

}
