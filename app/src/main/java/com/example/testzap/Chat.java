package com.example.testzap;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.mancj.materialsearchbar.MaterialSearchBar;

public class Chat extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    MaterialSearchBar materialSearchBar;
    FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chat, container, false);

        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddChat.class));
            }
        });


        materialSearchBar = view.findViewById(R.id.searchBar);
        materialSearchBar.setSpeechMode(true);

//      materialSearchBar.addTextChangeListener();

        tabLayout=view.findViewById(R.id.Tab_layout);
        viewPager=view.findViewById(R.id.View_pager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.setFragments(new Chats(),"Chats");
        viewPagerAdapter.setFragments(new Explore(),"Explore");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}