package context;

import java.util.HashMap;
import java.util.Map;

import enums.ContextData;

public class SceContext {

	private Map< String , Object > scnContext;
	
	public SceContext() {
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
