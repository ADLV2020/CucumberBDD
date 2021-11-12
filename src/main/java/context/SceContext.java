package context;

import java.util.HashMap;
import java.util.Map;

import enums.ContextData;

public class SceContext {

	private Map< String , Object > sceContext;
	
	public SceContext () {
		sceContext = new HashMap<>();
	}
	
	public void setContext( ContextData key , Object value ) {
		sceContext.put( key.toString() , value );
	}
	
	public Object getContext( ContextData key ) {
		return sceContext.get( key.toString() );
	}
	
	public Boolean isContains( ContextData key ) {
		return sceContext.containsKey( key.toString() );
	}
	
}
