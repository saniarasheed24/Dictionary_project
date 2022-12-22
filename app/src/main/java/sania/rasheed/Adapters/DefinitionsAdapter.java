package sania.rasheed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sania.rasheed.Models.Definitions;
import sania.rasheed.R;
import sania.rasheed.ViewHolders.DefinitionsViewHolder;

public class DefinitionsAdapter extends RecyclerView.Adapter<DefinitionsViewHolder> {

    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionsAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionsViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionsViewHolder holder, int position) {
        holder.textView_definitions.setText("Definition: " + definitionsList.get(position).getDefinition());
        if(definitionsList.get(position).getExample() != "") {
            holder.textView_example.setText("Example: " + definitionsList.get(position).getExample());
        }
        else {
            holder.textView_example.setText("");
        }
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());
        synonyms.append(definitionsList.get(position).getAntonyms());

        holder.textView_synonym.setText(synonyms);
        holder.textView_antonyms.setText(antonyms);

        holder.textView_synonym.setSelected(true);
        holder.textView_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
