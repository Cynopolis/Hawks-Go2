package com.schools.robbinsdale.hawksgo;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


class WebScraper {


    public String scrapeSite(String url) throws IOException{
        String title = null;
        Document document = Jsoup.connect(url).get(); //downloads the html from that website

        title = document.title();

        /* Some sample code for later reference
        Elements paragraphs = document.getElementsByTag("p");

        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
        return title;
    }

}

class AsyncCaller extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        WebScraper scraper = new WebScraper();
        String title;
        try{
            title = scraper.scrapeSite(strings[0]);
        }
        catch (IOException e){
            title = e.getMessage();
        }
        return title;
    }

    @Override
    protected void onPostExecute(String result){

        super.onPostExecute(result);

    }
}
