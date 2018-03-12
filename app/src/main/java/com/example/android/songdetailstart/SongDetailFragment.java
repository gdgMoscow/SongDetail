package com.example.android.songdetailstart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.songdetailstart.content.SongUtils;

import static com.example.android.songdetailstart.content.SongUtils.SONG_ID_KEY;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // SongItem includes the song title and detail.
    public SongUtils.Song mSong;

    // TODO: Rename and change types of parameters
    private String mParam1;


    public SongDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SongDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SongDetailFragment newInstance(int selectedSong) {
        SongDetailFragment fragment = new SongDetailFragment();
        Bundle args = new Bundle();
        args.putInt(SONG_ID_KEY, selectedSong);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(SONG_ID_KEY)){
            int id = getArguments().getInt(SONG_ID_KEY);
            mSong = SongUtils.SONG_ITEMS.get(id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.song_detail, container, false);

        if (mSong != null){
            TextView txtDetail = (TextView) rootView.findViewById(R.id.song_detail);
            txtDetail.setText(mSong.details);
        }

        return rootView;
    }

}
