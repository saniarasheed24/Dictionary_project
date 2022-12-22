package sania.rasheed.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sania.rasheed.R;

public class DefinitionsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_definitions, textView_example, textView_synonym, textView_antonyms;

    public DefinitionsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_definitions = itemView.findViewById(R.id.textView_definition);
        textView_example = itemView.findViewById(R.id.textView_example);
        textView_synonym = itemView.findViewById(R.id.textView_synonyms);
        textView_antonyms = itemView.findViewById(R.id.textView_antonyms);

    }
}
