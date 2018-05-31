package com.schools.robbinsdale.hawksgo;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


class WebScraper {


    public Document scrapeSite(String url) throws IOException{
        String title = null;
        Document document = Jsoup.connect(url).get(); //downloads the html from that website

        /* Some sample code for later reference
        Elements paragraphs = document.getElementsByTag("p");

        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
        return document;
    }

}

class AsyncCaller extends AsyncTask<String, Void, Document> {

    @Override
    protected Document doInBackground(String... strings) {
        WebScraper scraper = new WebScraper();
        Document page = null;
        try{
            page = scraper.scrapeSite(strings[0]);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return page;
    }

    @Override
    protected void onPostExecute(Document result){

        super.onPostExecute(result);

    }
}
