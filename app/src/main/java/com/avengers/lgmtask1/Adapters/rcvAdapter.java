package com.avengers.lgmtask1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avengers.lgmtask1.Models.Model;
import com.avengers.lgmtask1.R;

import java.util.List;

public class rcvAdapter extends RecyclerView.Adapter<rcvAdapter.mViewHolder> {
    List<Model> data;

    public rcvAdapter(List<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.testing,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        Model tempData=data.get(position);
        String stateNameAndCd=tempData.getStateName()+"( "+tempData.getStateCode()+" )";
        holder.stateNameAndCode.setText(stateNameAndCd);
        holder.districtName.setText(tempData.getDistrictName());

        holder.districtActive.setText(String.valueOf(tempData.getActive()));

        holder.districtConfirmed.setText(String.valueOf(tempData.getConfirmed()));
        holder.deltaConfirmed.setText(String.valueOf(tempData.delta.getConfirmed()));

        holder.districtMigratedOthers.setText(String.valueOf(tempData.getMigratedOther()));

        holder.districtDeceased.setText(String.valueOf(tempData.getDeceased()));
        holder.deltaDeceased.setText(String.valueOf(tempData.delta.getDeceased()));

        holder.districtRecovered.setText(String.valueOf(tempData.getRecovered()));
        holder.deltaRecovered.setText(String.valueOf(tempData.delta.getRecovered()));

        holder.note.setText(tempData.getNotes());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder{
        TextView stateNameAndCode,districtName;
        TextView districtActive;
        TextView districtConfirmed,deltaConfirmed;
        TextView districtMigratedOthers;
        TextView districtDeceased,deltaDeceased;
        TextView districtRecovered,deltaRecovered;
        TextView note;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            stateNameAndCode=itemView.findViewById(R.id.state_name_code);
            districtName=itemView.findViewById(R.id.district_name);

            districtActive=itemView.findViewById(R.id.district_active);

            districtConfirmed=itemView.findViewById(R.id.district_confirmed);
            deltaConfirmed=itemView.findViewById(R.id.delta_confirmed);

            districtMigratedOthers=itemView.findViewById(R.id.district_migratedOther);

            districtDeceased=itemView.findViewById(R.id.district_deceased);
            deltaDeceased=itemView.findViewById(R.id.delta_deceased);

            districtRecovered=itemView.findViewById(R.id.district_recovered);
            deltaRecovered=itemView.findViewById(R.id.delta_recovered);

            note=itemView.findViewById(R.id.note);
        }
    }
}
