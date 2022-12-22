package sania.rasheed.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import sania.rasheed.Models.Phonetics;
import sania.rasheed.R;
import sania.rasheed.ViewHolders.PhoneticViewHolder;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
            holder.textView_phonetic.setText(phoneticsList.get(position).getText());
            //audio
            holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer player = new MediaPlayer();
                    try {
                        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        player.setDataSource(phoneticsList.get(position).getAudio());
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(context, "Couldn't play audio", Toast.LENGTH_SHORT).show();
                    }

                }
            });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
