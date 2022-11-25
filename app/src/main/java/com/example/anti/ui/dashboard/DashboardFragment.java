package com.example.anti.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.anti.NumberAdapter;
import com.example.anti.R;
import com.example.anti.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    GridView gridView;

    //    사진 아래 적힐 글씨
    String[] numberWord = {"One", "Two", "Three", "Four", "Five", "Six"};

    //    지금은 R.drawable 에 저장했지만
//    glide 를 사용해서 url 을 가져와서 해보자
    int[] numberImage = {R.drawable.ic_baseline_electric_bike, R.drawable.ic_baseline_electric_car, R.drawable.ic_baseline_electric_moped, R.drawable.ic_baseline_electric_rickshaw, R.drawable.ic_baseline_electric_scooter, R.drawable.ic_baseline_emoji_transportation};



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //      gridview 연결
        gridView = (GridView) root.findViewById(R.id.gridView);

//      numberAdapter 연결
//      gridView 에 들어갈 사진과 글씨 다 여기서 연결해주는 듯 함
        NumberAdapter numberAdapter = new NumberAdapter(getContext(), numberWord, numberImage);

//      gridView 와 Adapter 연결
        gridView.setAdapter(numberAdapter);

//      gridView 를 클릭하면 Toast
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(), numberWord[position], Toast.LENGTH_SHORT).show();
            }
        });

//      원래 있던 text xml 이랑 함께해서 지우자
        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}