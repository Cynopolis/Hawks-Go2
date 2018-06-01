package com.schools.robbinsdale.hawksgo;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


//don't call this class directly, call AsyncCaller instead
class WebScraper {

    //Takes a website URL as an argument, and parses it into a Jsoup document that is returned
    public Document scrapeSite(String url) throws IOException{


        Document document = Jsoup.connect(url).get(); //downloads the html from that website

        /* Some sample code for later reference
        Elements paragraphs = document.getElementsByTag("p");

        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
        return document;
    }

}

/*
This class is the worst.
It takes a String argument, in this case a URL,
and calls the WebScraper class above.
Then it returns the document. What's special about this
class is that it does this on a sepperate thread from
the main UI thread. This is required for any downloads because
it ensures the download does not freeze the main thread as it's
downloading.
You can call this class in two different ways:
new AsyncCaller().execute(url).get(); <-- use this way if you need to use the document
immediatly after you download it. This works, but it defeats the point of an
Asynchronous thread because the main thread will wait until the document is finished downloading

AsyncCaller scraper = new AsyncCaller;
scraper.execute(url);
Document document = scraper.get();
This method is used when you know you'll need the document at some point in the future, but
not immediately. Do the first two lines asap, and then you can call the third line at
any point to retrieve the information.
 */
class AsyncCaller extends AsyncTask<String, Void, Document> {

    //the main method that is to be done in the background
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

    //once the doInBackground task is finished,
    // this posts the result fot the AsynchCaller.get() function
    @Override
    protected void onPostExecute(Document result){

        super.onPostExecute(result);

    }
}
