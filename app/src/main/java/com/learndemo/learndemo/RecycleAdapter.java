package com.learndemo.learndemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<DataModel> dataModelArrayList;

    public RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView Emp,EmpAge,EmpSal;

        public Myholder(View itemView) {
            super(itemView);

            Emp = (TextView) itemView.findViewById(R.id.tv_emp);
            EmpAge = (TextView) itemView.findViewById(R.id.tv_age);
            EmpSal = (TextView) itemView.findViewById(R.id.tv_Sal);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.Emp.setText(dataModel.getEmp());
        holder.EmpAge.setText(dataModel.getEmpAge());
        holder.EmpSal.setText(dataModel.getEmpSal());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
