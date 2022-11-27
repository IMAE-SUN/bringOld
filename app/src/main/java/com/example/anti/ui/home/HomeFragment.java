package com.example.anti.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.anti.NumberAdapter;
import com.example.anti.R;
import com.example.anti.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    HomeFragment homeFragment;
    private FragmentHomeBinding binding;


    GridView gridView_home;

    //    사진 아래 적힐 글씨

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeFragment = new HomeFragment();

        Glide.with(getActivity()).load("https://img.danawa.com/prod_img/500000/412/126/img/11126412_1.jpg?shrink=130:130&_v=20220527163310").into(binding.rand1);
        Glide.with(getActivity()).load("https://img.danawa.com/prod_img/500000/412/126/img/11126412_1.jpg?shrink=130:130&_v=20220527163310").into(binding.rand2);
        Glide.with(getActivity()).load("https://img.danawa.com/prod_img/500000/412/126/img/11126412_1.jpg?shrink=130:130&_v=20220527163310").into(binding.rand3);
        Glide.with(getActivity()).load("https://img.danawa.com/prod_img/500000/412/126/img/11126412_1.jpg?shrink=130:130&_v=20220527163310").into(binding.rand4);

        /**
         *  화면 전환을.. 클릭 시 전체를 감싸는 linear가 view.GONE 되고, 가려져있던 framelayout이 visible 되는 방식으로
         *  우선 해두었는데 더 좋은 방법이 있으면 수정 가능합니다!
         * **/
        
        binding.homeFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)
        binding.cardRand1.setOnClickListener(this::onClick); //cardview 누르면 화면 전환. todo : 뒤로가기 누르면 원상복귀



        return root;
    }

    public void onClick(View v){
        binding.homeall.setVisibility(View.GONE);
        binding.homeFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.card_rand1:
                Glide.with(getActivity()).load("https://img.danawa.com/prod_img/500000/412/126/img/11126412_1.jpg?shrink=130:130&_v=20220527163310").into(binding.frameimg);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}