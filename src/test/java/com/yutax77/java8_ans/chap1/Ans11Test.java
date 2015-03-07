package com.yutax77.java8_ans.chap1;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.yutax77.java8_ans.chap1.Ans11.I_Abst;
import com.yutax77.java8_ans.chap1.Ans11.I_Default;
import com.yutax77.java8_ans.chap1.Ans11.I_Static;
import com.yutax77.java8_ans.chap1.Ans11.J_Abst;
import com.yutax77.java8_ans.chap1.Ans11.J_Default;
import com.yutax77.java8_ans.chap1.Ans11.J_Static;
import com.yutax77.java8_ans.chap1.Ans11.S_I_Abst;
import com.yutax77.java8_ans.chap1.Ans11.S_I_Default;
import com.yutax77.java8_ans.chap1.Ans11.S_I_Static;

@RunWith(Enclosed.class)
public class Ans11Test {
    
    public static class TestImplementsTwoInterfaces {
	    static class Abst_Abst implements I_Abst, J_Abst {
		@Override
		public void f() {
		    System.out.println("Abst_Abst");
		}
	    }

	    @Test
	    public void testAbst_Abst() {
		System.out.println("--------testAbst_Abst--------");
		Abst_Abst c = new Abst_Abst();
		c.f();
		
		// Abst_Abst
	    }
	    
	    static class Abst_Default implements I_Abst, J_Default {
		@Override
		public void f() {
		    //Implement
		    J_Default.super.f();
		    System.out.println("Abst_Default");
		}
	    }
	    
	    @Test
	    public void testAbst_Default() {
		System.out.println("--------testAbst_Default--------");
		Abst_Default c = new Abst_Default();
		c.f();
		
		// J_Default
		// Abst_Default
	    }
		
	    static class Abst_Static implements I_Abst, J_Static {
		@Override
		public void f() {
		    System.out.println("Abst_Static");
		    J_Static.f();
		}
	    }
	    
	    @Test
	    public void testAbst_Static() {
		System.out.println("--------testAbst_Static--------");
		Abst_Static c = new Abst_Static();
		c.f();
		
		// Abst_Static
		// J_Static
	    }
	    
	    static class Default_Abst implements I_Default, J_Abst {
		@Override
		public void f() {
		    //Override
		    I_Default.super.f();
		    System.out.println("Default_Abst");
		}
	    }
	    
	    @Test
	    public void testDefault_Abst() {
		System.out.println("--------testDefault_Abst--------");
		Default_Abst c = new Default_Abst();
		c.f();
		
		// I_Default
		// Default_Abst
	    }

	    static class Default_Default implements I_Default, J_Default {
		@Override
		public void f() {
		    //Override
		    I_Default.super.f();
		    J_Default.super.f();
		    System.out.println("Default_Default");
		}
	    }
	    
	    @Test
	    public void testDefault_Default() {
		System.out.println("--------testDefault_Default--------");
		Default_Default c = new Default_Default();
		c.f();
		
		// I_Defalt
		// J_Default
		// Default_Default
	    }
	    
	    static class Default_Static implements I_Default, J_Static {
		@Override
		public void f() {
		    //Override
		    I_Default.super.f();
		    J_Static.f();
		    System.out.println("Default_Static");
		}
	    }
	    
	    @Test
	    public void testDefault_Static() {
		System.out.println("--------testDefault_Static--------");
		Default_Static c = new Default_Static();
		c.f();
		
		// I_Default
		// J_Static
		// Default_Static
	    }
	    
	    static class Static_Abst implements I_Static, J_Abst {
		@Override
		public void f() {
		    //Override
		    I_Static.f();
		    System.out.println("Static_Abst");
		}
	    }
	    
	    @Test
	    public void testStatic_Abst() {
		System.out.println("--------testStatic_Abst--------");
		Static_Abst c = new Static_Abst();
		c.f();
		
		// I_Static
		// Static_Abst
	    }
	    
	    static class Static_Default implements I_Static, J_Default {
		// use J_Default.super.f()
	    }
	    
	    @Test
	    public void testStatic_Default() {
		System.out.println("--------testStatic_Default--------");
		Static_Default c = new Static_Default();
		c.f();
		
		// J_Default
	    }

	    static class Static_Static implements I_Static, J_Static {
		public void f() {
		    System.out.println("Static_Static");
		}
	    }
	    
	    @Test
	    public void testStatic_Static() {
		System.out.println("--------testStatic_Static--------");
		Static_Static c = new Static_Static();
		c.f();
		
		I_Static.f();
		J_Static.f();

		// Static_Static
		// I_Static
		// J_Static
	    }
    }
    
    public static class TestExtendsSuperClass {
	    static class Abst extends S_I_Abst {
		@Override
		public void f() {
		    //Implement
		    System.out.println("Abst");
		}
	    }
	    
	    @Test
	    public void testAbst() {
		System.out.println("--------testAbst--------");
		Abst c = new Abst();
		c.f();
		
		// Abst
	    }
	    
	    static class Default extends S_I_Default {
	    }
	    
	    @Test
	    public void testDefault() {
		System.out.println("--------testDefault--------");
		Default c = new Default();
		c.f();
		
		// I_Default
	    }
	    
	    static class Static extends S_I_Static {
		public void f() {
		    System.out.println("Static");
		}
	    }
	    
	    @Test
	    public void testStatic() {
		System.out.println("--------testStatic--------");
		Static c = new Static();
		c.f();
		I_Static.f();
		
		// Static
		// I_Default
	    }
    }
}
