package com.caoyang.news.rss;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.caoyang.news.datas.RssDataItem;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by plter on 7/4/17.
 */

public class Reader {


    private static RequestQueue requestQueue;

    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static void loadRss(Context context, String url, final OnSuccessCallback onSuccessCallback, final OnFailCallback onFailCallback) {
        getRequestQueue(context).add(new StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                List<RssDataItem> rssData = new ArrayList<RssDataItem>();

                try {

                    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));

                    NodeList items = document.getElementsByTagName("item");

                    for (int i = 0; i < items.getLength(); i++) {
                        Node NodeItem = items.item(i);

                        NodeList childNodes = NodeItem.getChildNodes();
                        Map<String, String> map = new HashMap<>();
                        Node node;
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            node = childNodes.item(j);
                            if (!node.getNodeName().equals("#text")) {
                                map.put(node.getNodeName(), node.getTextContent().trim());
                            }

                        }

                        rssData.add(new RssDataItem(
                                map.get("title"),
                                map.get("link"),
                                map.get("author"),
                                map.get("category"),
                                map.get("pubDate"),
                                map.get("comments"),
                                map.get("description")));
                    }

                    if (onSuccessCallback != null) {
                        onSuccessCallback.onSuccess(rssData);
                    }
                } catch (SAXException | IOException | ParserConfigurationException e) {
                    e.printStackTrace();

                    if (onFailCallback != null) {
                        onFailCallback.onFail(new ReaderError(e));
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (onFailCallback != null) {
                    onFailCallback.onFail(new ReaderError(error));
                }
            }
        }));
    }

    public interface OnSuccessCallback {
        void onSuccess(List<RssDataItem> rssData);
    }

    public interface OnFailCallback {
        void onFail(ReaderError error);
    }
}
