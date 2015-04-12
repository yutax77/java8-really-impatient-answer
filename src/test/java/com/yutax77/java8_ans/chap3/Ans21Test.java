package com.yutax77.java8_ans.chap3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Ans21Test {
    @Mock
    private Future<Integer> mock;
    
    @Before
    public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	
	doReturn(false).when(mock).cancel(anyBoolean());
	doReturn(false).when(mock).isCancelled();
	doReturn(true).when(mock).isDone();
	doReturn(1000).when(mock).get();
	doReturn(1000).when(mock).get(anyLong(), any(TimeUnit.class));
    }
    
    @Test
    public void testMap_Get() throws InterruptedException, ExecutionException {
	Future<String> actual = Ans21.map(mock, i -> i.toString());
	
	assertThat(actual.get(), is("1000"));
    }
    
    @Test
    public void testMap_GetArgs() throws InterruptedException, ExecutionException, TimeoutException {
	Future<String> actual = Ans21.map(mock, i -> i.toString());
	
	assertThat(actual.get(1000, TimeUnit.SECONDS), is("1000"));
    }
}
