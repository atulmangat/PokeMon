

package cs193a.stanford.edu.pokedex;

import android.os.Bundle;
import android.view.*;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import stanford.androidlib.*;

public class PokedexFragment extends SimpleFragment {

    public PokedexFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pokedex, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        SimpleActivity activity = getSimpleActivity();
        TableLayout layout = (TableLayout) activity.findViewById(R.id.table_layout);
        for (int i = 0; i < layout.getChildCount(); i++) {
            TableRow row = (TableRow) layout.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                ImageButton button = (ImageButton) row.getChildAt(j);
                button.setOnClickListener(this);
            }
        }
    }


    @Override
    public void onClick(View view) {
        ImageButton button = (ImageButton) view;
        String tag = button.getTag().toString();

        SimpleActivity activity = getSimpleActivity();
        if (activity.isPortrait()) {
            // jump to DetailsActivity
            activity.startActivity(DetailsActivity.class, "pokemon_name", tag);
        } else {

            DetailsFragment frag = (DetailsFragment) activity.getFragmentManager().findFragmentById(R.id.frag_details);
            frag.setPokemonName(tag);
        }
    }
}
