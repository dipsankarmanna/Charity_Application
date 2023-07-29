package com.example.sudip_new_project.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sudip_new_project.R;
public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        WebView web_home=view.findViewById(R.id.web_home);
        web_home.loadUrl("https://sudipbhanja123.github.io/Crowd_Caring/index.html");

        // this will enable the javascript.
        web_home.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        web_home.setWebViewClient(new WebViewClient());
        return view;
    }
}