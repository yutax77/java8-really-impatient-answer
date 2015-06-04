package com.yutax77.java8_ans.chap8;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static com.yutax77.java8_ans.chap8.Ans3.*;

import org.junit.Test;

public class Ans3Test {

    @Test
    public void test() {
        assertThat(gcd_mod(10, 4), is(2));
        assertThat(gcd_floorMod(10, 4), is(2));
        assertThat(gcd_rem(10, 4), is(2));
        
        assertThat(gcd_mod(-10, 4), is(2));
        assertThat(gcd_floorMod(-10, 4), is(2));
        assertThat(gcd_rem(-10, 4), is(2));
        
        assertThat(gcd_mod(10, -4), is(2));
        assertThat(gcd_floorMod(10, -4), is(2));
        assertThat(gcd_rem(10, -4), is(2));
        
        assertThat(gcd_mod(-10, -4), is(2));
        assertThat(gcd_floorMod(-10, -4), is(2));
        assertThat(gcd_rem(-10, -4), is(2));
    }
    
    @Test
    public void test2() {
        assertThat(gcd_mod(10, 3), is(1));
        assertThat(gcd_floorMod(10, 3), is(1));
        assertThat(gcd_rem(10, 3), is(1));
        
        assertThat(gcd_mod(-10, 3), is(1));
        assertThat(gcd_floorMod(-10, 3), is(1));
        assertThat(gcd_rem(-10, 3), is(1));
        
        assertThat(gcd_mod(10, -3), is(1));
        assertThat(gcd_floorMod(10, -3), is(1));
        assertThat(gcd_rem(10, -3), is(1));
        
        assertThat(gcd_mod(-10, -3), is(1));
        assertThat(gcd_floorMod(-10, -3), is(1));
        assertThat(gcd_rem(-10, -3), is(1));
    }
}
