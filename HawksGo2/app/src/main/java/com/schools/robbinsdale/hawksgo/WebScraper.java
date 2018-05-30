package com.schools.robbinsdale.hawksgo;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


class WebScraper extends AsyncTask<String, Void, String> {

    public String current_URL = "https://www.google.com/";
    public String setURL(String URL){
        current_URL = URL;
        return current_URL;
    }

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


    protected void onPostExecute() {
    }

    @Override
    protected String doInBackground(String... strings) {
        String title = null;
        String url = current_URL;
        try{
            title = scrapeSite(url);
        }
        catch (IOException e){
            title = e.getMessage();
        }
        return title;
    }

}
