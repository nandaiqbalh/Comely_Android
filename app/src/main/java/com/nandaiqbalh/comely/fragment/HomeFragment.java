package com.nandaiqbalh.comely.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.activity.LoginActivity;
import com.nandaiqbalh.comely.adapter.ProdukAdapter;
import com.nandaiqbalh.comely.model.produk.Produk;
import com.nandaiqbalh.comely.model.produk.network.ProductResponse;
import com.nandaiqbalh.comely.model.userlogin.LoginResponse;
import com.nandaiqbalh.comely.rest.ApiConfig;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    RecyclerView recyclerViewFeatured, recyclerViewHotDeals;
    ArrayList<Produk> dataHolder;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // inisialisasi
        inisialisasi(view);

        // display slider
        displaySlider();

        // get product featured
        getProductFeatured();
        // get product hot deals
        getProductHotDeals();



       /**
        * CARA OFFLINE DISPLAY PRODUCT SLIDER
        * // menambahkan produk ke holder -> Featured Product
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




        // menambahkan produk ke holder -> Featured Product
        dataHolder = new ArrayList<>();
        Produk hotdeals1 = new Produk("Eiger CRUX 20 WS Backpack", "Rp 314.000,00", R.drawable.eiger_crux_20_ws_backpack);
        dataHolder.add(hotdeals1);
        Produk hotdeals2 = new Produk("Eiger TRVLR Cap", "Rp 125.000,00", R.drawable.eiger_trvlr_cap);
        dataHolder.add(hotdeals2);
        Produk hotdeals3 = new Produk("Eiger Caldera Pinch Sandals","Rp 170.000,00", R.drawable.eiger_caldera_pinch_sandals);
        dataHolder.add(hotdeals3);
        Produk hotdeals4 = new Produk("Eiger Derail Shoulder Bag", "Rp 332.000,00", R.drawable.derail_shoulder_bag);
        dataHolder.add(hotdeals4);
        Produk hotdeals5 = new Produk("Eiger Distant Shoulder Bag", "Rp 350.000,00", R.drawable.distant_shoulder_bag);
        dataHolder.add(hotdeals5);

        */

        return view;

    }

    private void inisialisasi(View view){
        sliderLayout = view.findViewById(R.id.slider);

        // produk recycler view
        recyclerViewFeatured = view.findViewById(R.id.rv_featured_product);

        // produk recycler view
        recyclerViewHotDeals = view.findViewById(R.id.rv_hotdeals);

    }

    private ArrayList<Produk> featuredArrayList = new ArrayList<>();
    private void getProductFeatured(){
        Call<ProductResponse> productResponseCall = ApiConfig.getService().productFeatured();
        productResponseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {

                ProductResponse respon = response.body();
                if (respon.getSuccess() == 1){
                    featuredArrayList = respon.getProduct();
                    displayProduct();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });
    }


    private ArrayList<Produk> hotDealsArrayList = new ArrayList<>();
    private void getProductHotDeals(){
        Call<ProductResponse> productResponseCall = ApiConfig.getService().productHotDeals();
        productResponseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {

                ProductResponse respon = response.body();
                if (respon.getSuccess() == 1){
                    hotDealsArrayList = respon.getProduct();
                    displayProduct();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });
    }

    private void displaySlider(){
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderViews();
    }

    private void displayProduct(){

        // featured product
        LinearLayoutManager featuredLinearLayoutManager = new LinearLayoutManager(getActivity());
        featuredLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewFeatured.setLayoutManager(featuredLinearLayoutManager);
        recyclerViewFeatured.setAdapter(new ProdukAdapter(requireActivity(), featuredArrayList));


        // hot deals product
        LinearLayoutManager hotDealslinearLayoutManager = new LinearLayoutManager(getActivity());
        hotDealslinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewHotDeals.setLayoutManager(hotDealslinearLayoutManager);
        recyclerViewHotDeals.setAdapter(new ProdukAdapter(requireActivity(), hotDealsArrayList));
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