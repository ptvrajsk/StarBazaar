package com.android.sonsofpitches.starbazaar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import java.util.function.Consumer;


/**
 * This class contains the brains behind the HeaderFragment that will be
 * attached to
 */
public class HeaderFragment extends Fragment {

    private static TextView headerText;
    private static Button backButton;
    HeaderFragmentListener activityCommander;

    public interface HeaderFragmentListener {
        public void setHeaderText(Consumer<String> setHeaderText);
        public void revertToPreviousPage();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            Activity a = (Activity) context;
            activityCommander = (HeaderFragmentListener) a;
        } catch (ClassCastException e) {
            throw new ClassCastException("Attached activity has not implemented Header interface!");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View header = inflater.inflate(R.layout.header_fragment, container, false);
        header.setBackgroundResource(R.drawable.svg_header_background);
        backButton = (Button) header.findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.header_backbutton_background);
        headerText = (TextView) header.findViewById(R.id.headerText);

        Consumer<String> setHeaderText = new Consumer<String>() {
            @Override
            public void accept(String s) {
                headerText.setText(s);
            }
        };

        activityCommander.setHeaderText(setHeaderText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCommander.revertToPreviousPage();
            }
        });

        return header;
    }


}
