package randomthoughtgenerator;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;


public class RandomThoughtGenerator {
    static String thought,creator;
    public static final String url="http://www.miniwebtool.com/random-quote-generator/";
    public RandomThoughtGenerator() throws IOException {
    	
    	WebClient wc=new WebClient();
    	wc.getOptions().setThrowExceptionOnScriptError(false);
    	wc.getOptions().setCssEnabled(false);
    	wc.getOptions().setJavaScriptEnabled(false);
    	HtmlPage currentpage=wc.getPage(url);    	
    	HtmlSubmitInput select=(HtmlSubmitInput) currentpage.getFirstByXPath("//*[@id='c1']/form/table/tbody/tr/td[3]/input");
    	HtmlPage next=select.click();
    	DomText quote= next.getFirstByXPath("//*[@id='w4']/div[4]/div[1]/text()");
    	//System.out.println(quote.asText());
    	thought=quote.asText();
    	HtmlAnchor author=next.getFirstByXPath("//*[@id='w4']/div[4]/div[2]/a");
    	//System.out.println(author.asText());
    	creator=author.asText();
        wc.close();   	
	} 
    
    public static void main(String[] args) throws IOException {
        //RandomThoughtGenerator rtg=new RandomThoughtGenerator();
        MainAppWindow mainAppWindow = new MainAppWindow();
        
    }   
}
