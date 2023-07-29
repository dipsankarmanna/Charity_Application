package com.example.sudip_new_project.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sudip_new_project.R;

public class ContactFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) WebView web_donate=view.findViewById(R.id.contact);
        web_donate.loadUrl("https://sudipbhanja123.github.io/Crowd_Caring/contact.html");

        // this will enable the javascript.
        web_donate.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        web_donate.setWebViewClient(new WebViewClient());
        return view;
    }
}