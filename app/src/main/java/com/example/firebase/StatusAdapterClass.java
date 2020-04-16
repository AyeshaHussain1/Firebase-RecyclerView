package com.example.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase.ModelClass.StatusModelClass;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class StatusAdapterClass extends FirestoreRecyclerAdapter<StatusModelClass,StatusAdapterClass.ViewHolderStatus> {



    public StatusAdapterClass(@NonNull FirestoreRecyclerOptions<StatusModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolderStatus viewHolderStatus, int i, @NonNull StatusModelClass statusModelClass) {

        viewHolderStatus.nameTV.setText(statusModelClass.getName());
        viewHolderStatus.statusTV.setText(statusModelClass.getStatus());
        viewHolderStatus.camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(viewHolderStatus.camera.getContext(), "Good To Go", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolderStatus onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        ViewHolderStatus objectViewHolderStatus=new ViewHolderStatus(view);

        return objectViewHolderStatus;
    }

    class ViewHolderStatus extends RecyclerView.ViewHolder
    {

        TextView nameTV,statusTV;
        ImageView camera;
        public ViewHolderStatus(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.singleRow_nameTV);

            statusTV=itemView.findViewById(R.id.singleRow_statusTV);
            camera=itemView.findViewById(R.id.camera);
        }
    }
}
