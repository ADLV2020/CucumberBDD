package context;

import java.util.HashMap;
import java.util.Map;

import enums.ContextData;

public class ScnContext {

	private Map< String , Object > scnContext;
	
	public ScnContext() {
		scnContext = new HashMap<>();
	}
	
	public void setContext(ContextData key, Object value) {
		scnContext.put(key.toString(), value);
	}
	
	public Object getContext(ContextData key) {
		return scnContext.get(key.toString());
	}
	
	public Boolean isContains(ContextData key) {
		return scnContext.containsKey(key.toString());
	}
	
}
