package com.yutax77.java8_ans.chap3;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ans1 {
    static Logger logger = Logger.getLogger(Ans1.class.getName());
    
    public static void logIf(Level logLevel, BooleanSupplier condition, Supplier<String> supplier){
	if(logger.isLoggable(logLevel) && condition.getAsBoolean()) {
	    logger.log(logLevel, supplier);
	}
    }
}
