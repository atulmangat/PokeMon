

package cs193a.stanford.edu.pokedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.*;
import stanford.androidlib.*;

public class DetailsFragment extends SimpleFragment {


    public DetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleActivity activity = getSimpleActivity();
        String pokemonName = activity.getStringExtra("pokemon_name", "Pikachu");
        setPokemonName(pokemonName);
    }


    public void setPokemonName(String pokemonName) {
        SimpleActivity activity = getSimpleActivity();
        int imageID = activity.getResourceId(pokemonName.toLowerCase(), "drawable");
        int fileID = activity.getResourceId(pokemonName.toLowerCase(), "raw");
        String fileText = activity.readFileText(fileID);
        activity.$TV(R.id.pokemon_name).setText(pokemonName);
        activity.$IV(R.id.pokemon_image).setImageResource(imageID);
        activity.$TV(R.id.pokemon_details).setText(fileText);
    }
}
