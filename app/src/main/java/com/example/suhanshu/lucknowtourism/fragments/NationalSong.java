package com.example.suhanshu.lucknowtourism.fragments;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suhanshu.lucknowtourism.R;

public class NationalSong extends Fragment {
    private TextView textView;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private ImageView imageView;
    boolean value = true;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            imageView.setImageDrawable(getActivity().getDrawable(R.drawable.if_button_player_play_01_1221896));
            value = true;
            releaseMediaPlayer();
        }
    };
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();

            } else if (i == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();

            } else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
            } else if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
            }
        }
    };

    public NationalSong() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_national_song, container, false);
        textView = view.findViewById(R.id.songTextView);
        imageView = view.findViewById(R.id.song_national);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(getString(R.string.song), Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView.setText(Html.fromHtml(getString(R.string.song)));
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value) {
                    releaseMediaPlayer();
                    mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
                    int result = mAudioManager.requestAudioFocus(afChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // Start playback
                        mMediaPlayer = MediaPlayer.create(getActivity(), R.raw.vande_mataram);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(onCompletionListener);
                        imageView.setImageDrawable(getActivity().getDrawable(R.drawable.if_button_player_pause_01_1221887));
                        value = false;
                    }
                } else {
                    value = true;
                    imageView.setImageDrawable(getActivity().getDrawable(R.drawable.if_button_player_play_01_1221896));
                    mMediaPlayer.pause();
                }

            }
        });
        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
        imageView.setImageDrawable(getActivity().getDrawable(R.drawable.if_button_player_play_01_1221896));
        value = true;

    }
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
