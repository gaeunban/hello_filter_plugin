package com.hello.filters;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloFilterTest {
	
	private Analyzer analyzer;

    private String HelloString(String text) throws IOException {
    	String result = "";
    	try {
	        TokenStream stream = analyzer.tokenStream("field", text);
	        CharTermAttribute charAttr = stream.addAttribute(CharTermAttribute.class);
	
	        stream.reset();
	        
	        List<String> tokens = new ArrayList<>();
	        while (stream.incrementToken()) {
	            tokens.add(charAttr.toString());
	        }
	        stream.close();
	        
	        result = String.join(" ", tokens);
    	} catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    	
        return result;
    }
    
    @BeforeEach
	public void setup() {
    	//_analyzer
		analyzer = new Analyzer(Analyzer.PER_FIELD_REUSE_STRATEGY) {
			@Override
			protected TokenStreamComponents createComponents(String fieldName) {
				//tokenizer
				Tokenizer tokenizer = new KeywordTokenizer();
				//filter(내꺼)
				TokenStream tokenFilter = new HelloFilter(tokenizer);
				
				return new TokenStreamComponents(tokenizer, tokenFilter);
			}
		};
	}


    @Test
    void testHelloFilter() throws IOException {
        System.out.println("[Test started]");
        String result = HelloString("world");
        System.out.println("결과 : " + result);
        assertEquals("world hello", result); 
    }
}
