package com.hello.filters;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class HelloFilter extends TokenFilter {
	private final CharTermAttribute charAttr;
	
	public HelloFilter(TokenStream input) {
		super(input);
		charAttr = addAttribute(CharTermAttribute.class);
	}

	@Override
	public final boolean incrementToken() throws IOException {
		/*
		if (input.incrementToken()) {
	        String original = charAttr.toString();  // 원래 값 저장
	        charAttr.setEmpty();                    // 버퍼 초기화  
	        charAttr.append(original + " hello");    // 원래값 + "hello"
	        return true;
	    }
	    return false;
	    */
		
		if (input.incrementToken()) {
			//charAttr.setEmpty();
			charAttr.append(" hello");
			return true;
		}
		
		return false;
		
	}
}
