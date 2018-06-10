package com.android.sonsofpitches.starbazaar;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * This class contains the brains behind the HeaderFragment that will be
 * attached to
 */
public class HeaderFragment extends Fragment {

    private static TextView headerText;
    private static ImageButton backButton;
    HeaderFragmentListener activityCommander;

    public interface HeaderFragmentListener {
        public void setHeaderText(TextView headerText);
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

        //Make fragment become a view.
        View header = inflater.inflate(R.layout.header_fragment, container, false);
        header.setBackgroundResource(R.drawable.img_header_background);

        //Set Button Resources and functions
        backButton = (ImageButton) header.findViewById(R.id.backButton);
        backButton.setBackgroundResource(R.drawable.header_backbutton_background);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityCommander.revertToPreviousPage();
            }
        });

        //Set header resources and functionality.
        headerText = (TextView) header.findViewById(R.id.headerText);
        Typeface quickSandFont = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/font_quicksand_regular.ttf");
        headerText.setTypeface(quickSandFont);
        activityCommander.setHeaderText(headerText);

        return header;
    }


}
