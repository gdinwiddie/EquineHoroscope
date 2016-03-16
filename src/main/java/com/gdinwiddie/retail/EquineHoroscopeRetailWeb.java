package com.gdinwiddie.retail;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.port;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import spark.QueryParamsMap;

public class EquineHoroscopeRetailWeb {

	public static void main(String[] args) {
		new EquineHoroscopeRetailWeb().startServer();
	}

	public void startServer() {
		port(20002);
		TemplateLoader loader = new ClassPathTemplateLoader();
		loader.setPrefix("/com/gdinwiddie/retail/web/templates");
		loader.setSuffix("");
		Handlebars handlebars = new Handlebars(loader);

		get("/buy", (req, res) -> handlebars.compile("buy").apply(""));
		post("/buy", (req, res) -> handlebars.compile("buy").apply(doBuyHoroscope(req.queryMap())));
	}
	
	private Map<String, String> doBuyHoroscope(QueryParamsMap query) {
		Map<String, String[]> parmsMap = query.toMap();
		Map<String, String> responseMap = new HashMap<String, String>();
		String horoscope = "Not hooked up, yet.";
		for (String key: parmsMap.keySet()) {
			responseMap.put(key, parmsMap.get(key)[0]);
		}
		responseMap.put("horoscope", horoscope);
		return responseMap;
	}
}
