package sania.rasheed.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sania.rasheed.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_partsOfSpeech;
    public RecyclerView recyclerView_definitions;

    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_partsOfSpeech = itemView.findViewById(R.id.textView_partsOfSpeach);
        recyclerView_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
