package com.caoyang.news.controllers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.caoyang.news.activitys.Main2Activity;
import com.caoyang.news.activitys.adapters.Adapter;
import com.caoyang.news.databinding.FragmentNewsBinding;
import com.caoyang.news.datas.Data;
import com.caoyang.news.fragments.NewsFragment;

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
 * Created by caoyang on 17-6-27.
 */

public class NewsFragmentController {
    private List<Data> list = new ArrayList<>();
    private final NewsFragment fragment;
    private final FragmentNewsBinding binding;
    private Adapter adapter;
    private List<String> listString = new ArrayList<>();
    private List<String> listContent = new ArrayList<>();

    public NewsFragmentController(final NewsFragment fragment, FragmentNewsBinding binding) {
        this.fragment = fragment;
        this.binding = binding;

        addList();
        data();

        itemOnClickListener(fragment, binding);
    }

    private void itemOnClickListener(final NewsFragment fragment, FragmentNewsBinding binding) {
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(fragment.getContext(), Main2Activity.class);
                String content_text = listContent.get(position);
                intent.putExtra("data", content_text);

                fragment.getContext().startActivity(intent);
            }
        });
    }

    private void addList() {
        Volley.newRequestQueue(fragment.getContext()).add(new StringRequest("http://news.qq.com/newsgn/rss_newsgn.xml", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

//            System.out.println("===========Response" + response);

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

                        list.add(new Data(
                                map.get("title"),
                                map.get("link"),
                                map.get("author"),
                                map.get("category"),
                                map.get("pubDate"),
                                map.get("comments"),
                                map.get("description")));
                        for (int h = 0; h < list.size(); h++) {
                            String title = list.get(h).getTitle();
                            String description = list.get(h).getDescription();
                            listString.add(title);
                            listContent.add(description);
                        }

                    }

                } catch (SAXException | IOException | ParserConfigurationException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }));
//
    }

    private void data() {
        adapter = new Adapter(listString, fragment.getContext(), listContent);
        binding.listView.setAdapter(adapter);
    }

    private StringRequest stringRequest = null;

    public List<Data> getList() {
        return list;
    }
}
