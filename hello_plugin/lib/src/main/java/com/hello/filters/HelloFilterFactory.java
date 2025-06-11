package com.hello.filters;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;

public class HelloFilterFactory extends AbstractTokenFilterFactory{

	public HelloFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
		super(name, settings);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new HelloFilter(tokenStream);
	}

}
