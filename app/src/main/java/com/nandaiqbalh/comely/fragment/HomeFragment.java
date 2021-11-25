package com.nandaiqbalh.comely.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.adapter.ProdukAdapter;
import com.nandaiqbalh.comely.model.Produk;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // member variabel
    SliderLayout sliderLayout;

    // recycler view
    RecyclerView recyclerView;
    ArrayList<Produk> dataHolder;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();

        // produk recycler view
        recyclerView = view.findViewById(R.id.rv_produk);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // menambahkan produk ke holder -> Featured Product
        dataHolder = new ArrayList<>();
        Produk produk1 = new Produk("Eiger CRUX 20 WS Backpack", "Rp 314.000,00", R.drawable.eiger_crux_20_ws_backpack);
        dataHolder.add(produk1);
        Produk produk2 = new Produk("Eiger TRVLR Cap", "Rp 125.000,00", R.drawable.eiger_trvlr_cap);
        dataHolder.add(produk2);
        Produk produk3 = new Produk("Eiger Caldera Pinch Sandals","Rp 170.000,00", R.drawable.eiger_caldera_pinch_sandals);
        dataHolder.add(produk3);
        Produk produk4 = new Produk("Eiger Derail Shoulder Bag", "Rp 332.000,00", R.drawable.derail_shoulder_bag);
        dataHolder.add(produk4);
        Produk produk5 = new Produk("Eiger Distant Shoulder Bag", "Rp 350.000,00", R.drawable.distant_shoulder_bag);
        dataHolder.add(produk5);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new ProdukAdapter(dataHolder));

        return view;

    }

    private void setSliderViews() {

        for (int i = 0; i < 3; i++){
            DefaultSliderView sliderView  = new DefaultSliderView(getContext());

            switch (i){
                case 0 :
                    sliderView.setImageDrawable(R.drawable.slider1);
                    break;
                case 1 :
                    sliderView.setImageDrawable(R.drawable.slider2);
                    break;
                case 2 :
                    sliderView.setImageDrawable(R.drawable.slider3);
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}