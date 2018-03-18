

package cs193a.stanford.edu.pokedex;

import android.os.Bundle;
import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String pokemonName = getStringExtra("pokemon_name", "Pikachu");
        setPokemonName(pokemonName);
    }


    public void setPokemonName(String pokemonName) {
        int imageID = getResourceId(pokemonName.toLowerCase(), "drawable");
        int fileID = getResourceId(pokemonName.toLowerCase(), "raw");
        String fileText = readFileText(fileID);
        $TV(R.id.pokemon_name).setText(pokemonName);
        $IV(R.id.pokemon_image).setImageResource(imageID);
        $TV(R.id.pokemon_details).setText(fileText);
    }
}
