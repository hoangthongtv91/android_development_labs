/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 * Main Activity for the Material Me app, a mock sports news application
 * with poor design choices.
 */
public class MainActivity extends AppCompatActivity {

    // Member variables.
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private List<Integer> mFromIndexList = new ArrayList<Integer>();
    private List<Integer> mToIndexList = new ArrayList<Integer>();
    private List<Integer> mRemoveIndexList = new ArrayList<Integer>();
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mSportsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                mFromIndexList.add(from);
                mToIndexList.add(to);
                Collections.swap(mSportsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                int position = viewHolder.getAdapterPosition();
                mRemoveIndexList.add(position);
                mSportsData.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Initialize the sports data from resources.
     */
    private void initializeData() {
        // Get the resources from the XML file.
        String[] sportsList = getResources()
                .getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources()
                .getStringArray(R.array.sports_info);
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsDetail = getResources().getStringArray(R.array.sports_detail);

        // Clear the existing data (to avoid duplication).
        mSportsData.clear();

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for (int i = 0; i < sportsList.length; i++) {
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0), sportsDetail[i]));
        }
        sportsImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initializeData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("FromArray", (ArrayList<Integer>) mFromIndexList);
        outState.putIntegerArrayList("ToArray", (ArrayList<Integer>) mToIndexList);
        outState.putIntegerArrayList("RemovingArray", (ArrayList<Integer>) mRemoveIndexList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mFromIndexList = savedInstanceState.getIntegerArrayList("FromArray");
        mToIndexList = savedInstanceState.getIntegerArrayList("ToArray");
        mRemoveIndexList = savedInstanceState.getIntegerArrayList("RemovingArray");
        for (int i = 0; i < mFromIndexList.size(); i++){
            Collections.swap(mSportsData, mFromIndexList.get(i), mToIndexList.get(i));
            mAdapter.notifyItemMoved(mFromIndexList.get(i), mToIndexList.get(i));
        }
        for (int j = 0; j < mRemoveIndexList.size(); j++){
            mSportsData.remove(mRemoveIndexList.get(j));
            mAdapter.notifyItemRemoved(mRemoveIndexList.get(j));
        }
        mFromIndexList.clear();
        mToIndexList.clear();
        mRemoveIndexList.clear();
        super.onRestoreInstanceState(savedInstanceState);
    }
}
