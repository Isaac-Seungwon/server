package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex01 {

	public static void main(String[] args) {
	
		//Jsoup
		
		try {
			Document doc = Jsoup.connect("http://localhost:8090/memo/list.do").get();
			
			//System.out.println(doc.html());
			
			Element h1 = doc.selectFirst("body > h1");
			
			System.out.println(h1.text());
			
			//System.out.println("---");
			
			Elements item = doc.select(".item > div:nth-child(2)");
			
			for (Element ele : item) {
				System.out.println(ele.text());
			}
			
			
			//Element result = doc.selectFirst("result");
			//System.out.println("result: " + result.text());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
