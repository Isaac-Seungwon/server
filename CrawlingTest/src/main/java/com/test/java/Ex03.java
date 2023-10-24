package com.test.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {

	public static void main(String[] args) {
		
		try {
			
			String url = "http://lms1.sist.co.kr/worknet/SMember/index.asp?strCode=I202307110032";
			
			Document doc = Jsoup.connect(url).get();
			
			System.out.println(doc.html());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
