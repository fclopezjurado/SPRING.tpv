package services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SeriesExpansionTest {

    @Test
    public void testExpandElements() {
        List<String> expanded = (new SeriesExpansion().expandSerie("1,2,3"));
        assertEquals(3, expanded.size());
        assertEquals("1", expanded.get(0));
        assertEquals("3", expanded.get(2));
    }

    @Test
    public void testExpandAlphaElements() {
        List<String> expanded = (new SeriesExpansion().expandSerie("S,M,L,XL"));
        assertEquals(4, expanded.size());
        assertEquals("S", expanded.get(0));
        assertEquals("L", expanded.get(2));
    }

    @Test
    public void testExpandSerie() {
        List<String> expanded = (new SeriesExpansion().expandSerie("3-8"));
        assertEquals(6, expanded.size());
        assertEquals("3", expanded.get(0));
        assertEquals("8", expanded.get(5));
    }

    @Test
    public void testExpandCompleteSerie() {
        List<String> expanded = (new SeriesExpansion().expandSerie("4-8:2"));
        assertEquals(3, expanded.size());
        assertEquals("4", expanded.get(0));
        assertEquals("8", expanded.get(2));
    }

    @Test
    public void testExpandMixSerie() {
        List<String> expanded = (new SeriesExpansion().expandSerie("1,2,4-8:2,9"));
        assertEquals(6, expanded.size());
        assertEquals("2", expanded.get(1));
        assertEquals("8", expanded.get(4));
    }
    
    @Test
    public void testExtractSerie(){
        List<String> expanded = (new SeriesExpansion().extractSerie("abc[2-6:2]"));
        assertEquals(3, expanded.size());
        assertEquals("2", expanded.get(0));
        assertEquals("6", expanded.get(2));
    }
    
    @Test 
    public void textExtractBase(){
        assertEquals("abc", new SeriesExpansion().extractBase("abc[2..6]"));
    }

}
