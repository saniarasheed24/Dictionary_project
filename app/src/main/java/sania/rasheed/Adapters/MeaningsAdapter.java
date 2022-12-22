package sania.rasheed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sania.rasheed.Models.Meanings;
import sania.rasheed.R;
import sania.rasheed.ViewHolders.MeaningsViewHolder;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
    private Context context;
    protected List<Meanings> meaningsList;

    public MeaningsAdapter(Context context, List<Meanings> meaningsList){
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textView_partsOfSpeech.setText("Parts of Speech: "+ meaningsList.get(position).getPartOfSpeech());
        holder.recyclerView_definitions.setHasFixedSize(true);
        holder.recyclerView_definitions.setLayoutManager(new GridLayoutManager(context, 1));

        DefinitionsAdapter definitionsAdapter = new DefinitionsAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recyclerView_definitions.setAdapter(definitionsAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
