package com.eternal_search.deskchan.groovy_support;

import com.eternal_search.deskchan.core.MessageListener;
import com.eternal_search.deskchan.core.Plugin;
import com.eternal_search.deskchan.core.PluginProxy;
import com.eternal_search.deskchan.core.ResponseListener;
import groovy.lang.Script;

public abstract class GroovyPlugin extends Script implements Plugin {
	
	private PluginProxy pluginProxy = null;
	
	@Override
	public boolean initialize(PluginProxy pluginProxy) {
		this.pluginProxy = pluginProxy;
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public void unload() {
	}
	
	protected void sendMessage(String tag, Object data) {
		pluginProxy.sendMessage(tag, data);
	}
	
	protected void sendMessage(String tag, Object data, ResponseListener responseListener) {
		pluginProxy.sendMessage(tag, data, responseListener);
	}
	
	protected void addMessageListener(String tag, MessageListener listener) {
		pluginProxy.addMessageListener(tag, listener);
	}
	
	protected void removeMessageListener(String tag, MessageListener listener) {
		pluginProxy.removeMessageListener(tag, listener);
	}
	
}
