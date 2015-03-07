package com.yutax77.java8_ans.chap1;

public class Ans11 {
    public static interface I_Abst {
	public void f();
    }
    
    public static interface J_Abst {
	public void f();
    }
    
    public static interface I_Default {
	public default void f() {
	    System.out.println("I_Default");
	};
    }
    
    public static interface J_Default {
	public default void f() {
	    System.out.println("J_Default");
	};
    }
    
    public static interface I_Static {
	public static void f() {
	    System.out.println("I_Static");
	};
    }
    
    public static interface J_Static {
	public static void f() {
	    System.out.println("J_Static");
	};
    }
    
    public static abstract class S_I_Abst implements I_Abst {
    }
    

    public static abstract class S_I_Default implements I_Default {
    }
    

    public static abstract class S_I_Static implements I_Static {
    }
}
