package com.hello.plugin;

import java.util.HashMap;
import java.util.Map;

import com.hello.filters.HelloFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

public class HelloPlugin extends Plugin implements AnalysisPlugin{
	
	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
		extra.put("hello_filter", HelloFilterFactory::new);

		return extra;
	}
}
