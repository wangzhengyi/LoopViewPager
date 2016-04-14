package genius.com.wzy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NbaStarFragment extends Fragment {
    private static final String ARG_PARAM1 = "name";

    private String mStarPlayerName;

    public NbaStarFragment() {
        // Required empty public constructor
    }

    public static NbaStarFragment newInstance(String playerName) {
        NbaStarFragment fragment = new NbaStarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, playerName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStarPlayerName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nba_star, container, false);
        TextView textView = (TextView) view.findViewById(R.id.id_player_name_tv);
        textView.setText(mStarPlayerName);

        return view;
    }

}
