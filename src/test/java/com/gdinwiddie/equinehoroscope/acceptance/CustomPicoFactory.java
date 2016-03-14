package com.gdinwiddie.equinehoroscope.acceptance;

import cucumber.runtime.java.picocontainer.PicoFactory;

/**
 * Extension of the standard PicoContainer ObjectFactory
 * which will register the proper AutomatioApi implementation
 * based on a system property.
 */
public class CustomPicoFactory extends PicoFactory {

	@Override
	public boolean addClass(Class<?> clazz) {
		if (EquineHoroscopeRetailAdapter.class.isAssignableFrom(clazz)) {
			if("web".equals(System.getProperty("EquineHoroscope.testDepth"))) {
				super.addClass(EquineHoroscopeRetailWebAdapter.class);
				return (clazz == EquineHoroscopeRetailWebAdapter.class);
			} else {
				super.addClass(EquineHoroscopeRetailApiAdapter.class);
				return (clazz == EquineHoroscopeRetailApiAdapter.class);
			}
		}
		return super.addClass(clazz);
	}
	
//    public CustomPicoFactory() {
//    	super();
//        if("web".equals(System.getProperty("EquineHoroscope.testDepth"))) {
////            addClass(WebAutomationApi.class);
//        } else {
//        	addClass(EquineHoroscopeRetailApiAdapter.class);
//        }
//    }
	
	
}
