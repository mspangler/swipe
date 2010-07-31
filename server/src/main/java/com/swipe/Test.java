package com.swipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mark
 *
 */
public class Test {
	
	private static Logger log = LoggerFactory.getLogger(Test.class);
	private Swipe swipe;
	
	public static void main(String[] args) {
		log.debug("Java: Swipe");
		Swipe.test();
	}

}
