package com.melikeey.shoppingdemo.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.databinding.FragmentHomeBinding;
import com.melikeey.shoppingdemo.model.Product;
import com.melikeey.shoppingdemo.adapters.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Product> productList;

    FragmentHomeBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(layoutManager);

        HomeAdapter homeAdapter = new HomeAdapter(getProductList());

        mBinding.recyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
        return mBinding.getRoot();
    }

    public List<Product> getProductList() {

        productList = new ArrayList<>();
        productList.add(new Product("Bilgisayar", "Macbook", R.drawable.bilgisayar));
        productList.add(new Product("Tablet", "Samsung", R.drawable.samsung));
        productList.add(new Product("Telefon", "Huawei", R.drawable.huawei));
        productList.add(new Product("Oyun Konsolu", "Playstation", R.drawable.playstation));
        productList.add(new Product("Kulaklık", "Airpods", R.drawable.airpods));

        return productList;
    }
}
