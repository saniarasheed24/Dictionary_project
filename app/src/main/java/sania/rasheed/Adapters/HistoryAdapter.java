package sania.rasheed.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sania.rasheed.Database.Word;
import sania.rasheed.Database.WordRepository;
import sania.rasheed.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Word> mWords;

    public HistoryAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.history_list_items, parent, false);
        HistoryViewHolder viewHolder = new HistoryViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

        if(mWords != null){
            Word word = mWords.get(position);
            holder.setData(word.getWord(),position);
        }
        else {
            holder.historyItemView.setText(R.string.no_word);
        }

    }

    @Override
    public int getItemCount() {
        if(mWords != null){
            return mWords.size();
        }
        else {
            return 0;
        }
    }

    public void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    public Word getWordAt(int position) {
        return getWordAt(position);
    }


    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView historyItemView;
        int mPosition;

        public HistoryViewHolder(View itemView){
            super(itemView);
            historyItemView = itemView.findViewById(R.id.historyWord);
        }

        public void setData(String historyItem, int position){
            historyItemView.setText(historyItem);
            mPosition = position;
        }
    }
}
